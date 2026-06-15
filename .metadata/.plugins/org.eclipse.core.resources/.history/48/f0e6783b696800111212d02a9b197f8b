package LIBRARY;

import java.time.LocalDate;

public class ReservationService {
	private LibraryDatabase database;
    private NotificationService notificationService;

    public ReservationService(LibraryDatabase database, NotificationService notificationService) {
        this.database = database;
        this.notificationService = notificationService;
    }

    public boolean reserveAvailableBook(Book book, Customer customer) {
        if (book == null || customer == null || !book.isStatus()) {
            return false;
        }

        Reservation reservation = new Reservation(book, customer, LocalDate.now());
        database.addReservation(reservation);
        notificationService.notifyCustomer(customer, "Dat truoc sach thanh cong: " + book.getTitle());
        return true;
    }

}
