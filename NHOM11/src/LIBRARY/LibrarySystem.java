package LIBRARY;

public class LibrarySystem {
	private LibraryDatabase databases;
	private BookService bookService;
	private BorrowService borrowService;
	private ReportService reportService;

	public LibrarySystem() {
		super();
		this.databases = new LibraryDatabase();
		this.bookService = new BookService(databases);
		this.borrowService = new BorrowService(databases);
		this.reportService = new ReportService();

	}

	public LibraryDatabase getDatabases() {
		return databases;
	}

	public BookService getBookService() {
		return bookService;
	}

	public BorrowService getBorrowService() {
		return borrowService;
	}

	public ReportService getReportService() {
		return reportService;
	}

}
