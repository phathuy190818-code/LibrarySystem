package LIBRARY;

public class LoginSystem {
	private AuthService authService;

	public LoginSystem(AuthService authService) {
		super();
		this.authService = authService;
	}

	public Customer login(String email, String password) {
		return authService.login(email, password);
	}
}
