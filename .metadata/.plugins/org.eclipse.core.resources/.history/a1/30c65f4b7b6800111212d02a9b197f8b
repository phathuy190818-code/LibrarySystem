package LIBRARY;

import java.util.List;

public class FineService {
	private BorrowService borrowService;
    private FineStrategy strategy;

    public FineService(BorrowService borrowService, FineStrategy strategy) {
        this.borrowService = borrowService;
        this.strategy = strategy;
    }

    public void setStrategy(FineStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateFine(BorrowHistory history) {
        if (strategy == null) {
            return 0;
        }
        return strategy.calculateFine(history);
    }

    public double getTotalFine(Customer customer) {
        double total = 0;
        List<BorrowHistory> violations = borrowService.getViolationHistories(customer);
        for (BorrowHistory history : violations) {
            total += calculateFine(history);
        }
        return total;
    }

    public void markPaid(Customer customer) {
        List<BorrowHistory> violations = borrowService.getViolationHistories(customer);
        for (BorrowHistory history : violations) {
            history.setFinePaid(true);
        }
        customer.setViolation(false);
    }

    public void markFailed(Customer customer) {
        List<BorrowHistory> violations = borrowService.getViolationHistories(customer);
        for (BorrowHistory history : violations) {
            history.setPaymentFailed(true);
        }
    }

}
