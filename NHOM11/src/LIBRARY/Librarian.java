package LIBRARY;

public class Librarian extends User {

	public Librarian(String id, String name) {
		super(id, name);

	}

	public String toString() {

		return "id=" + id + ", name=" + name;
	}
}
