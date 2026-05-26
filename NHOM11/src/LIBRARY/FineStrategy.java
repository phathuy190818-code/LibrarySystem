package LIBRARY;

public class FineStrategy {
	private double finePerDay;

	public FineStrategy(double finePerDay) {
		super();
		this.finePerDay = finePerDay;
	}

	public double calculateFine(long overdueDays) {
		if (overdueDays <= 0) {
			return 0;
		}
		return overdueDays * finePerDay;
	}
}
