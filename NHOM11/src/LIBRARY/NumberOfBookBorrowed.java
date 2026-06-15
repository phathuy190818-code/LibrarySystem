package LIBRARY;

public class NumberOfBookBorrowed implements IBorrowValidationStrategy {

	@Override
	public boolean validate(Book book, Customer customer) {
		if(customer.booksBorrowedList.size()>3) {
			System.out.println("da dat gioi han muon sach!");
			return false;
		}
		return true;
	}

}
