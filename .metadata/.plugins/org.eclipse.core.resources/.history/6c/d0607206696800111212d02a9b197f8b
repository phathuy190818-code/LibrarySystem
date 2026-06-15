package LIBRARY;

import java.util.*;

public class BookReport implements ReportStrategy {
	private LibraryDatabase database;

	public BookReport(LibraryDatabase database) {
		super();
		this.database = database;
	}

	@Override
	public void generateReport(ReportFilter filter) {
		System.out.println("\n Bao cao sach");
		List<BorrowHistory> histories = database.getHistories();
		for (int i = 0; i < histories.size(); i++) {
			BorrowHistory h = histories.get(i);
			Book b = h.getBook();
			// loc theo the loai
			boolean matchCategory = filter.getCategory().equals("")
					|| b.getCategory().equalsIgnoreCase(filter.getCategory());
			// loc theo nam
			boolean matchYear = filter.getYear() == 0 || h.getBook().getYear() == filter.getYear();
			// loc theo trang thai
			boolean matchStatus = true;
			    //xem sach dang muon
			if (filter.getStatus().equalsIgnoreCase("borrowed")) {
				matchStatus = b.isStatus() == false;
				// xem sach con lai trong thu vien
			} else if (filter.getStatus().equalsIgnoreCase("available")) {
				matchStatus = b.isStatus() == true;
				// xem tat ca sach
			} else if (filter.getStatus().equalsIgnoreCase("all") || filter.getStatus().equals("")) {
				matchStatus = true;

			}
			if (matchCategory && matchYear && matchStatus) {
				System.out.println(h);
			}
		}
	}

}
