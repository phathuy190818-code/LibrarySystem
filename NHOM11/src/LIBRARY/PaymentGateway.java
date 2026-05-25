package LIBRARY;

public interface PaymentGateway {
	boolean pay(Customer customer, double amount);

}
