package LIBRARY;

public class BookStatusValidate implements ICheckValidationStrategy {

	@Override
	public boolean validate(Book book, Customer customer) {
		if(book==null || book.isStatus().equalsIgnoreCase("dang muon")) {
			System.out.println("Sach dang muon hoac khong hop le!");
			return false;
		}
		return true;
	}

}
