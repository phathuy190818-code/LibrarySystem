package LIBRARY;

public class CustomerViolationValidation implements ICheckValidationStrategy{

	@Override
	public boolean validate(Book book, Customer customer) {
		if(customer == null || customer.isViolation()) {
			System.out.println("khach hang dang vi pham!");
			return false;
		}
		return true;
	}
	

}
