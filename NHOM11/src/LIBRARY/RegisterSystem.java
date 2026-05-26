package LIBRARY;

public class RegisterSystem {
	private AuthService authService;

	public RegisterSystem(AuthService authService) {
		super();
		this.authService = authService;
	}

	public boolean register(Customer customer, boolean agreedTerms) {
		if (!agreedTerms) {
			return false;
		}
		return authService.register(customer);
	}
}
