package LIBRARY;

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

        System.out.print("Nhap gia sach:");
        double price = Double.parseDouble(sc.nextLine());
        
        System.out.print("Nhap nam xuat ban:");
        int year = Integer.parseInt(sc.nextLine());

		Book book = new Book(idBook, title, author, category, true, price, year);
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
