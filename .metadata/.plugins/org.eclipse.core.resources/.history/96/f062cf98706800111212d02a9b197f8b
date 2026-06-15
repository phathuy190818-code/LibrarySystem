package LIBRARY;

import java.time.LocalDate;

public class Test {
	public static void main(String[] args) {
		UI ui = new UI();
		// them sach
		ui.addBook();
		ui.addBook();
		// them khach hang
		Customer c1 = new Customer("IT1", "NGUYEN PHAT HUY", false);
		Customer c2 = new Customer("IT2", "PHAN NGUYEN ANH TAI", false);
		Customer c3 = new Customer("IT3", "TRAN THI YEN NHI", false);
		Customer c4 = new Customer("IT4", "HUYNH MAN DAT", false);
		Customer c5 = new Customer("IT5", "NGUYEN HO NHAT TAN", false);
		ui.getSystem().getDatabases().addCustomer(c1);
		ui.getSystem().getDatabases().addCustomer(c2);
		ui.getSystem().getDatabases().addCustomer(c3);
		ui.getSystem().getDatabases().addCustomer(c4);
		ui.getSystem().getDatabases().addCustomer(c5);

		// muon sach
		Book b1 = ui.getSystem().getDatabases().getBooks().get(0);
		Book b2 = ui.getSystem().getDatabases().getBooks().get(1);
		//Sách b3 b4 là sách có sẵn
		Book b3 = new Book("113", "CTDL", "N. Dũ", "Programming", true, 120000, 2008);
		ui.getSystem().getDatabases().addBook(b3);
        Book b4 = new Book("114", "TKHDT", "N. Trâm", "Programming", true, 200000, 1994);
        ui.getSystem().getDatabases().addBook(b4);
        
        System.out.println("Danh sach sach");
		ui.getSystem().getDatabases().showAllBook();
		System.out.println("Danh sach khach hang");
		ui.getSystem().getDatabases().showAllCustomer();

		boolean borrow1 = ui.getSystem().getBorrowService().borrowBook(b1, c4, 
				LocalDate.of(2026, 1, 1), 
				LocalDate.of(2026, 1, 10), 
				LocalDate.of(2026, 1, 15));
		System.out.println("Muon sach lan 1:" + borrow1);

		boolean borrow2 = ui.getSystem().getBorrowService().borrowBook(b2, c1, 
				LocalDate.of(2026, 2, 2),
				LocalDate.of(2026, 2, 11),
				LocalDate.of(2026, 2, 17));
		System.out.println("Muon sach lan 2:" + borrow2);

		boolean borrow3 = ui.getSystem().getBorrowService().borrowBook(b1, c5, 
				LocalDate.of(2026, 3, 7),
				LocalDate.of(2026, 3, 17),
				LocalDate.of(2026, 3, 27));
		System.out.println("Muon sach lan 3:" + borrow3);
		//Mượn sách b3
		boolean borrow4 = ui.getSystem().getBorrowService().borrowBook(b3, c2, 
				LocalDate.of(2026, 5, 20),
				LocalDate.of(2026, 5, 25),
				LocalDate.of(2026, 5, 27));
		System.out.println("Muon sach lan 4:" + borrow4);

		// tra sach
		boolean return1 = ui.getSystem().getBorrowService().returnBook(b1);
		System.out.println("Tra sach lan 1:" + return1);
		//tra sách b3
		boolean return2 = ui.getSystem().getBorrowService().returnBook(b3);
		System.out.println("Tra sach lan 2:" + return2);
		
		//Tính tiền phạt của khách c2
		double fine1 = ui.getSystem().getBookService().checkFine(c2);
		System.out.println("Tiền phạt cần thanh toán của khách hàng " + c2 + " là " + fine1);
		//đặt trước sách b4
		boolean reserved = ui.getSystem().getBookService().reserveBook(b4, c3);
        System.out.println("Dat truoc thanh cong: " + reserved);

		ui.getSystem().getDatabases().showAllCustomer();

		// xoa sach
		boolean remove1 = ui.getSystem().getBookService().removeBook(b1.getIdBook());
		System.out.println("Xoa sach 1" + remove1);

		boolean remove2 = ui.getSystem().getBookService().removeBook("B100");
		System.out.println("Xoa sach 2" + remove2);

		// bao cao tat ca sach
		ReportFilter filter1 = new ReportFilter("", 0, "all");
		ReportStrategy strategy1 = new BookReport(ui.getSystem().getDatabases());

		ui.getSystem().getReportService().setStrategy(strategy1);
		ui.getSystem().getReportService().generateReport(filter1);

		// bao cao sach dang muon
		ReportFilter filter2 = new ReportFilter("", 0, "borrowed");
		ui.getSystem().getReportService().generateReport(filter2);
		// bao cao sach theo nam
		ReportFilter filter3 = new ReportFilter("", 2025, "all");
		ui.getSystem().getReportService().generateReport(filter3);

		// bao cao khach hang vi pham
		ReportStrategy strategy2 = new CustomerReport(ui.getSystem().getDatabases());
		ui.getSystem().getReportService().setStrategy(strategy2);

		ReportFilter filter4 = new ReportFilter("", 0, "violation");
		ui.getSystem().getReportService().generateReport(filter4);
	}
	//hehehehehehehehehehehehehehehehehehehehehehehehehheheheheheheeh
}
