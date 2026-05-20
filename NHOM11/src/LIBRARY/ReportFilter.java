package LIBRARY;

public class ReportFilter {
	private String category;
	private int year;
	private String status;
//ALL=XEM TAT CA SACH
//BORROWED=XEM CAC SACH DANG DUOC MUON
//AVAILABLE=XEM CAC SACH CHUA DUOC MUON
	public ReportFilter(String category, int year, String status) {
		super();
		this.category = category;
		this.year = year;
		this.status = status;
	}

	public String getCategory() {
		return category;
	}

	public int getYear() {
		return year;
	}

	public String getStatus() {
		return status;
	}

}
