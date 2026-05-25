package LIBRARY;

public class DailyCappedFineStrategy implements FineStrategy {
	private double finePerDay;

    public DailyCappedFineStrategy(double finePerDay) {
        this.finePerDay = finePerDay;
    }

    @Override
    public double calculateFine(BorrowHistory history) {
        if (history == null || history.getBook() == null) {
            return 0;
        }

        double bookPrice = history.getBook().getPrice();
        double fine = history.getOverdueDays() * finePerDay;
        if (bookPrice > 0 && fine >= bookPrice) {
            return bookPrice;
        }
        return fine;
    }


}
