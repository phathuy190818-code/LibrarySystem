package LIBRARY;

import java.time.LocalDate;
import java.util.Scanner;

public class Test {
	private static Scanner sc = new Scanner(System.in);
	private static LibrarySystem system = new LibrarySystem();

	public static void main(String[] args) {
		addSampleBooks();
		int choice;
		do {
			showMenu();
			choice = readInt("Chon chuc nang: ");

			switch (choice) {
			case 1:
				register();
				break;
			case 2:
				login();
				break;
			case 3:
				addBook();
				break;
			case 4:
				borrowBook();
				break;
			case 5:
				returnBook();
				break;
			case 6:
				system.getDatabases().showAllBook();
				break;
			case 7:
				system.getDatabases().showAllCustomer();
				break;
			case 8:
				report();
				break;
			case 0:
				System.out.println("Thoat chuong trinh!");
				break;
			default:
				System.out.println("Lua chon khong hop le!");
				break;
			}
		} while (choice != 0);
	}

	private static void addSampleBooks() {
		system.getBookService().addBook(new Book("B01", "Lap trinh Java", "Nguyen Van A", "Cong nghe", true));
		system.getBookService().addBook(new Book("B02", "Co so du lieu", "Tran Van B", "Cong nghe", true));
		system.getBookService().addBook(new Book("B03", "Phan tich thiet ke he thong", "Le Thi C", "Cong nghe", true));
		system.getBookService().addBook(new Book("B04", "Toan roi rac", "Pham Van D", "Toan hoc", true));
		system.getBookService().addBook(new Book("B05", "Ky nang giao tiep", "Hoang Thi E", "Ky nang", true));
	}

	private static void showMenu() {
		System.out.println("\n===== LIBRARY SYSTEM =====");
		System.out.println("1. Dang ki tai khoan");
		System.out.println("2. Dang nhap");
		System.out.println("3. Them sach");
		System.out.println("4. Muon sach");
		System.out.println("5. Tra sach");
		System.out.println("6. Xem danh sach sach");
		System.out.println("7. Xem danh sach khach hang");
		System.out.println("8. Bao cao");
		System.out.println("0. Thoat");
	}

	private static void register() {
		System.out.println("\n===== DANG KI =====");
		System.out.print("Nhap id khach hang: ");
		String id = sc.nextLine();

		System.out.print("Nhap ho ten: ");
		String name = sc.nextLine();

		System.out.print("Nhap email: ");
		String email = sc.nextLine();

		System.out.print("Nhap mat khau: ");
		String password = sc.nextLine();

		System.out.print("Dong y dieu khoan? (Y/N): ");
		String agreed = sc.nextLine();

		Customer customer = new Customer(id, name, email, password, false);
		boolean result = system.getRegisterSystem().register(customer, agreed.equalsIgnoreCase("Y"));
		if (result) {
			System.out.println("Dang ki thanh cong!");
		} else {
			System.out.println("Dang ki that bai! Email/id co the da ton tai hoac thong tin khong hop le.");
		}
	}

	private static void login() {
		System.out.println("\n===== DANG NHAP =====");
		System.out.print("Nhap email: ");
		String email = sc.nextLine();

		System.out.print("Nhap mat khau: ");
		String password = sc.nextLine();

		Customer customer = system.getLoginSystem().login(email, password);
		if (customer == null) {
			System.out.println("Dang nhap that bai! Tai khoan khong ton tai hoac sai mat khau.");
		} else {
			System.out.println("Dang nhap thanh cong! Xin chao " + customer.getName());
		}
	}

	private static void addBook() {
		System.out.println("\n===== THEM SACH =====");
		System.out.print("Nhap id sach: ");
		String idBook = sc.nextLine();

		System.out.print("Nhap ten sach: ");
		String title = sc.nextLine();

		System.out.print("Nhap ten tac gia: ");
		String author = sc.nextLine();

		System.out.print("Nhap the loai: ");
		String category = sc.nextLine();

		Book book = new Book(idBook, title, author, category, true);
		boolean result = system.getBookService().addBook(book);
		if (result) {
			System.out.println("Them sach thanh cong!");
		} else {
			System.out.println("Them sach that bai! Id sach co the da ton tai.");
		}
	}

	private static void borrowBook() {
		System.out.println("\n===== MUON SACH =====");
		System.out.print("Nhap id sach: ");
		String idBook = sc.nextLine();

		System.out.print("Nhap id khach hang: ");
		String idCustomer = sc.nextLine();

		Book book = system.getDatabases().findBookById(idBook);
		Customer customer = system.getDatabases().findCustomerById(idCustomer);
		if (book == null) {
			System.out.println("Khong tim thay sach!");
			return;
		}
		if (customer == null) {
			System.out.println("Khong tim thay khach hang!");
			return;
		}

		LocalDate borrowDate = readDate("Nhap ngay muon (yyyy-mm-dd): ");
		LocalDate dueDate = readDate("Nhap han tra (yyyy-mm-dd): ");

		boolean result = system.getBorrowService().borrowBook(book, customer, borrowDate, dueDate, dueDate);
		if (result) {
			System.out.println("Muon sach thanh cong!");
		} else {
			System.out.println("Muon sach that bai!");
		}
	}

	private static void returnBook() {
		System.out.println("\n===== TRA SACH =====");
		System.out.print("Nhap id sach can tra: ");
		String idBook = sc.nextLine();

		Book book = system.getDatabases().findBookById(idBook);
		if (book == null) {
			System.out.println("Khong tim thay sach!");
			return;
		}

		LocalDate actualReturnDate = readDate("Nhap ngay tra thuc te (yyyy-mm-dd): ");
		boolean result = system.getBorrowService().returnBook(book, actualReturnDate);
		if (result) {
			System.out.println("Cap nhat tra sach thanh cong!");
		} else {
			System.out.println("Khong tim thay thong tin muon sach chua tra!");
		}
	}

	private static void report() {
		System.out.println("\n===== BAO CAO =====");
		System.out.println("1. Bao cao sach");
		System.out.println("2. Bao cao khach hang");
		int reportChoice = readInt("Chon loai bao cao: ");

		System.out.print("Nhap the loai (nhan Enter de bo qua): ");
		String category = sc.nextLine();

		System.out.print("Nhap trang thai (all/borrowed/available/violation): ");
		String status = sc.nextLine();

		int year = readInt("Nhap nam (0 de bo qua): ");
		ReportFilter filter = new ReportFilter(category, year, status);

		if (reportChoice == 1) {
			system.getReportService().setStrategy(new BookReport(system.getDatabases()));
		} else if (reportChoice == 2) {
			system.getReportService().setStrategy(new CustomerReport(system.getDatabases()));
		} else {
			System.out.println("Loai bao cao khong hop le!");
			return;
		}

		system.getReportService().generateReport(filter);
	}

	private static int readInt(String message) {
		while (true) {
			try {
				System.out.print(message);
				return Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Vui long nhap so hop le!");
			}
		}
	}

	private static LocalDate readDate(String message) {
		while (true) {
			try {
				System.out.print(message);
				return LocalDate.parse(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Ngay khong hop le! Vi du dung: 2026-05-25");
			}
		}
	}
}
