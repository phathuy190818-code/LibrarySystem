package LIBRARY;

import java.time.LocalDate;
import java.util.*;

public class UI {
	private LibrarySystem system;
	private Scanner sc;

	public UI() {
		super();
		this.system = new LibrarySystem();
		this.sc = new Scanner(System.in);
	}

	public LibrarySystem getSystem() {
		return system;
	}

	public void registerUI() {
		System.out.print("Nhap id khach hang:");
		String id = sc.nextLine();

		System.out.print("Nhap ho ten:");
		String name = sc.nextLine();

		System.out.print("Nhap email:");
		String email = sc.nextLine();

		System.out.print("Nhap mat khau:");
		String password = sc.nextLine();

		System.out.print("Dong y dieu khoan? (Y/N):");
		String confirm = sc.nextLine();
		if (!confirm.equalsIgnoreCase("Y")) {
			System.out.println("Dang ki khong thanh cong vi chua dong y dieu khoan!");
			return;
		}

		Customer customer = new Customer(id, name, email, password, false);
		boolean result = system.getRegisterSystem().register(customer, true);
		if (result) {
			System.out.println("Dang ki thanh cong!");
		} else {
			System.out.println("Email da ton tai hoac thong tin khong hop le!");
		}
	}

	public Customer loginUI() {
		System.out.print("Nhap email:");
		String email = sc.nextLine();

		System.out.print("Nhap mat khau:");
		String password = sc.nextLine();

		Customer customer = system.getLoginSystem().login(email, password);
		if (customer == null) {
			System.out.println("Tai khoan khong ton tai hoac sai mat khau, vui long nhap lai!");
		} else {
			System.out.println("Dang nhap thanh cong!");
		}
		return customer;
	}

//thu thu nhap cac thong tin sach va he thong hien thi lai ket qua
	public void addBook() {
		System.out.print("Nhap id sach:");
		String idBook = sc.nextLine();

		System.out.print("Nhap ten sach:");
		String title = sc.nextLine();

		System.out.print("Nhap ten tac gia:");
		String author = sc.nextLine();

		System.out.print("Nhap the loai:");
		String category = sc.nextLine();

		Book book = new Book(idBook, title, author, category, true);
		boolean result = system.getBookService().addBook(book);
		if (result) {
			System.out.println("Them sach thanh cong!");
		} else {
			System.out.println("Them sach khong thanh cong!");
		}
	}

	// thu thu nhap id sach muon xoa va he thong hien thi lai ket qua
	public void removeBook() {
		System.out.print("\nNhap id sach muon xoa");
		String id = sc.nextLine();
		boolean result = system.getBookService().removeBook(id);
		if (result) {
			System.out.println("Xoa sach thanh cong!");
		} else {
			System.out.println("Xoa sach khong thanh cong!");
		}
	}

	public void returnBookUI() {
		System.out.print("Nhap id sach can tra:");
		String idBook = sc.nextLine();

		Book book = system.getDatabases().findBookById(idBook);
		if (book == null) {
			System.out.println("Khong tim thay sach!");
			return;
		}

		System.out.print("Nhap ngay tra thuc te (yyyy-mm-dd):");
		LocalDate actualReturnDate = LocalDate.parse(sc.nextLine());

		boolean result = system.getBorrowService().returnBook(book, actualReturnDate);
		if (result) {
			System.out.println("Cap nhat trang thai tra sach thanh cong!");
		} else {
			System.out.println("Khong tim thay thong tin muon sach chua tra!");
		}
	}

	public void reportUI() {
		System.out.println("Chon 1 trong 2 loai bao cao");
		System.out.println("1.Bao cao sach");
		System.out.println("2.Bao cao khach hang");

		int choice = Integer.parseInt(sc.nextLine());
		System.out.print("Nhap the loai(nhan enter de bo qua)");
		String category = sc.nextLine();

		System.out.print("Nhap trang thai: ALL/BORROWED/AVAILABLE (nhan enter de bo qua)");
		String status = sc.nextLine();

		System.out.print("Nhap nam(nhap 0 de bo qua)");
		int year = Integer.parseInt(sc.nextLine());

		ReportFilter filter = new ReportFilter(category, year, status);

		if (choice == 1) {
			ReportStrategy strategy = new BookReport(system.getDatabases());
			system.getReportService().setStrategy(strategy);
		} else if (choice == 2) {
			ReportStrategy strategy = new CustomerReport(system.getDatabases());
			system.getReportService().setStrategy(strategy);
		}
		system.getReportService().generateReport(filter);
	}
}
