package LIBRARY;

public class BorrowHistory {
	private Book book;
	private Customer customer;
	private int borrowYear;
	private int borrowDate;
	private int dueDate;
	private boolean returned;
	private boolean late;

	public BorrowHistory(Book book, Customer customer, int borrowYear, int borrowDate, int dueDate) {
		super();
		this.book = book;
		this.customer = customer;
		this.borrowYear = borrowYear;
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

	public int getBorrowYear() {
		return borrowYear;
	}

	public int getBorrowDate() {
		return borrowDate;
	}

	public int getDueDate() {
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

	@Override
	public String toString() {
		return customer.getName() + " muon sach " + book.getTitle() + " nam " + borrowYear + ", ngay muon=" + borrowDate
				+ ", han tra=" + dueDate + ",tre han=" + late;
	}

}
