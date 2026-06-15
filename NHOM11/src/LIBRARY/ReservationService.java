package LIBRARY;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ReservationService {
	private LibraryDatabase database;
    private NotificationService notificationService;
    private List<ICheckValidationStrategy> validators = new ArrayList<ICheckValidationStrategy>();

    public ReservationService(LibraryDatabase database, NotificationService notificationService) {
        this.database = database;
        this.notificationService = notificationService;
        validators.add(new CustomerViolationValidation());
        validators.add(new InvertValidationDecorator(new BookStatusValidate()));
    }
    
    public void addValidator(ICheckValidationStrategy validator) {
    	this.validators.add(validator);
    }

    public boolean reserveAvailableBook(Book book, Customer customer) {
    	for (ICheckValidationStrategy validator : validators) {
			if (!validator.validate(book, customer)) {
				return false; // 1 chien luoc false -> kh the dat cho
			}
		}
        //tao don giu cho , UUID.randomUUID(): tao random id cho reservation
        Reservation res = new Reservation( UUID.randomUUID().toString(),book, customer, LocalDate.now());
        database.addReservation(res); //them don giu cho
        notificationService.notifyCustomer(customer, "Dat truoc thanh cong! ma giu cho: "+ res.getReservationID());
        database.addQueue(customer); // them khach hang vao hang cho giu cho
        //them khach hang vao observer de thong bao
        return true;
        
        
    }
    
    

}
