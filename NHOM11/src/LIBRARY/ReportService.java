package LIBRARY;

public class ReportService {
	private ReportStrategy strategy;

	public ReportService() {
		super();

	}

	public ReportStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(ReportStrategy strategy) {
		this.strategy = strategy;
	}

	public void generateReport(ReportFilter filter) {
		if (strategy != null) {
			strategy.generateReport(filter);
		}
	}

}
