package LIBRARY;

public class LibrarySystem {
	private LibraryDatabase databases;
	private BookService bookService;
	private BorrowService borrowService;
	private ReportService reportService;
	private FineService fineService;
    private Payment payment;
    private NotificationService notificationService;
    private ReservationService reservationService;

	public LibrarySystem() {
		super();
		this.databases = new LibraryDatabase();
		this.bookService = new BookService(databases);
		this.borrowService = new BorrowService(databases);
		this.reportService = new ReportService();
		this.notificationService = new NotificationService();
        this.notificationService.addObserver(new CustomerNotificationObserver());
        this.fineService = new FineService(borrowService, new DailyCappedFineStrategy(5000));
        this.reservationService = new ReservationService(databases, notificationService);
        this.bookService.setFineService(fineService);
        this.bookService.setReservationService(reservationService);
        this.payment = new Payment(fineService, new BankPaymentGateway());

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
	public FineService getFineService() {
        return fineService;
    }

    public Payment getPayment() {
        return payment;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }

    public ReservationService getReservationService() {
        return reservationService;
    }

}
