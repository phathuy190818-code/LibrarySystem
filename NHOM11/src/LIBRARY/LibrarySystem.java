package LIBRARY;

public class LibrarySystem {
	private LibraryDatabase databases;
	private BookService bookService;
	private BorrowService borrowService;
	private ReportService reportService;
	private AuthService authService;
	private FineStrategy fineStrategy;
	private RegisterSystem registerSystem;
	private LoginSystem loginSystem;

	public LibrarySystem() {
		super();
		this.databases = new LibraryDatabase();
		this.bookService = new BookService(databases);
		this.fineStrategy = new FineStrategy(5000);
		this.borrowService = new BorrowService(databases, fineStrategy);
		this.reportService = new ReportService();
		this.authService = new AuthService(databases);
		this.registerSystem = new RegisterSystem(authService);
		this.loginSystem = new LoginSystem(authService);

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

	public AuthService getAuthService() {
		return authService;
	}

	public FineStrategy getFineStrategy() {
		return fineStrategy;
	}

	public RegisterSystem getRegisterSystem() {
		return registerSystem;
	}

	public LoginSystem getLoginSystem() {
		return loginSystem;
	}

}
