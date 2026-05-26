package LIBRARY;

public class AuthService {
	private LibraryDatabase database;

	public AuthService(LibraryDatabase database) {
		super();
		this.database = database;
	}

	public boolean isEmailExists(String email) {
		return database.findCustomerByEmail(email) != null;
	}

	public boolean register(Customer customer) {
		if (customer == null || isBlank(customer.getEmail()) || isBlank(customer.getPassword())) {
			return false;
		}
		if (isEmailExists(customer.getEmail())) {
			return false;
		}
		return database.addCustomer(customer);
	}

	public Customer login(String email, String password) {
		if (isBlank(email) || isBlank(password)) {
			return null;
		}
		Customer customer = database.findCustomerByEmail(email);
		if (customer != null && password.equals(customer.getPassword())) {
			return customer;
		}
		return null;
	}

	private boolean isBlank(String value) {
		return value == null || value.trim().equals("");
	}
}
