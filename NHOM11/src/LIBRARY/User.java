package LIBRARY;

public abstract class User {
	protected String id;
	protected String name;
	protected String email;
	protected String password;

	public User(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public User(String id, String name, String email, String password) {
		this(id, name);
		this.email = email;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

}
