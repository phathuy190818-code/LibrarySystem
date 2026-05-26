package LIBRARY;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BorrowHistory {
	private Book book;
	private Customer customer;
	private LocalDate returnDate;
	private LocalDate borrowDate;
	private LocalDate dueDate;
	private int borrowYear;
	private boolean returned;
	private boolean late;

	public BorrowHistory(Book book, Customer customer, LocalDate borrowDate, LocalDate returnDate, LocalDate dueDate) {
		super();
		this.book = book;
		this.customer = customer;
		this.returnDate = returnDate;
		this.borrowDate = borrowDate;
		this.dueDate = dueDate;
		this.returned = false;
		this.late = false;
	}

	public Book getBook() {
		return book;
	}

	public Customer getCustomer() {
		return customer;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public LocalDate getBorrowDate() {
		return borrowDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public boolean isReturned() {
		return returned;
	}

	public boolean isLate() {
		return late;
	}

	public void setReturned(boolean returned) {
		this.returned = returned;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public void setLate(boolean late) {
		this.late = late;
	}
	
	public int getBorrowYear() {
		return borrowYear;
	}

	//Tính số ngày quá hạn trả sách
	public long getOverdueDays() {
        if (returnDate.isAfter(dueDate)) {
            return ChronoUnit.DAYS.between(dueDate, returnDate);
        }
        //Trả đúng hạn thì số ngày quá hạn = 0
        return 0;
    }

	@Override
	public String toString() {
		return customer.getName() + " muon sach " + book.getTitle() + " ngay tra " + returnDate + ", ngay muon=" + borrowDate
				+ ", han tra=" + dueDate + ",tre han=" + late;
	}

}
