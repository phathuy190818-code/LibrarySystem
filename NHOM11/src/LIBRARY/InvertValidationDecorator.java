package LIBRARY;

public class InvertValidationDecorator implements ICheckValidationStrategy {
	private ICheckValidationStrategy originalStrategy;

	public InvertValidationDecorator(ICheckValidationStrategy originalStrategy) {
		this.originalStrategy = originalStrategy;
	}

	//phuong thuc de dao nguoc ket qua cua 1 chien luoc khi khai bao constructor
	@Override
	public boolean validate(Book book, Customer customer) {
		// dao nguoc ket qua cua chien luoc
		return !originalStrategy.validate(book, customer);
		
	}
}
