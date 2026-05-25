package LIBRARY;

public class Payment {
	private FineService fineService;
    private PaymentGateway paymentGateway;

    public Payment(FineService fineService, PaymentGateway paymentGateway) {
        this.fineService = fineService;
        this.paymentGateway = paymentGateway;
    }

    public double getTotalFine(Customer customer) {
        return fineService.getTotalFine(customer);
    }

    public boolean confirmPayment(Customer customer) {
        double totalFine = getTotalFine(customer);
        boolean success = paymentGateway.pay(customer, totalFine);
        if (success) {
            fineService.markPaid(customer);
        } else {
            fineService.markFailed(customer);
        }
        return success;
    }

}
