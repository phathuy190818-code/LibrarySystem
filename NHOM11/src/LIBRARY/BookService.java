package LIBRARY;

public class BookService {
	private LibraryDatabase database;
	private FineService fineService;
    private ReservationService reservationService;

	public BookService(LibraryDatabase database) {
		super();
		this.database = database;
	}
	

public void setFineService(FineService fineService) {
		this.fineService = fineService;
	}


	public void setReservationService(ReservationService reservationService) {
		this.reservationService = reservationService;
	}


	//kt xem sach duoc them vao la null hay id co rong ko
	public boolean addBook(Book book) {
		if (book == null || book.getIdBook().equals("")) {
			return false;
		}
		return database.addBook(book);

	}
//kt id sach muon xoa la null hay rong
	public boolean removeBook(String id) {
		if (id == null || id.equals("")) {
			return false;
		}
		return database.removeBook(id);

	}
	//Kiểm tra tiền phạt của khách hàng
	public double checkFine(Customer customer) {
        if (fineService == null || customer == null) {
            return 0;
        }
        return fineService.getTotalFine(customer);
    }
	//Đặt trước sách
    public boolean reserveBook(Book book, Customer customer) {
        if (reservationService == null) {
            return false;
        }
        return reservationService.reserveAvailableBook(book, customer);
    }
}
