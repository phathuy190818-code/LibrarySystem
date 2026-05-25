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
	private boolean finePaid;//Đã thanh toán
	private boolean paymentFailed;//Thanh toán thất bại

	public BorrowHistory(Book book, Customer customer, LocalDate borrowDate, LocalDate returnDate, LocalDate dueDate) {
		super();
		this.book = book;
		this.customer = customer;
		this.returnDate = returnDate;
		this.borrowDate = borrowDate;
		this.dueDate = dueDate;
		this.returned = false;
		this.late = false;
		this.finePaid = false;
		this.paymentFailed = false;
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

	public void setLate(boolean late) {
		this.late = late;
	}
	
	public int getBorrowYear() {
		//Nếu Ngày mượn = null -> 0 
		//Nếu Ngày mượn != null -> lấy được year
		//Tránh trường hợp getYear khi chưa có Ngày mượn
		return borrowDate == null ? 0 : borrowDate.getYear();
	}
	public void setFinePaid(boolean finePaid) {
		this.finePaid = finePaid;
		this.paymentFailed = false;
	}

	public void setPaymentFailed(boolean paymentFailed) {
		this.paymentFailed = paymentFailed;
	}

	//Tính số ngày quá hạn trả sách
	public long getOverdueDays() {
        if (returnDate == null || dueDate == null || !returnDate.isAfter(dueDate)) {
            return 0;
        }
        //Trả đúng hạn thì số ngày quá hạn = 0
        return ChronoUnit.DAYS.between(dueDate, returnDate);
    }
	//Kiểm tra xem có bị lỗi vi phạm
	public boolean isViolationRecord() {
		return returned && late && !finePaid;
	}

	@Override
	public String toString() {
		return customer.getName() + " muon sach " + book.getTitle() + ", ngay tra= " + returnDate + ", ngay muon= " + borrowDate
				+ ", han tra=" + dueDate + ",tre han=" + late + ", da nop phat= " + finePaid;
	}

}
