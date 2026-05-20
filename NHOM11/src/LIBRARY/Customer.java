package LIBRARY;

public class Customer extends User {
	private boolean violation;

	public Customer(String id, String name, boolean violation) {
		super(id, name);
		this.violation = violation;
	}

	public boolean isViolation() {
		return violation;
	}

	public void setViolation(boolean violation) {
		this.violation = violation;
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", violation=" + violation;
	}

}
