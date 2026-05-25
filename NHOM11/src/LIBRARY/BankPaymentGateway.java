package LIBRARY;

public class BankPaymentGateway implements PaymentGateway {
	private boolean nextResult = true;

    public void setNextResult(boolean nextResult) {
        this.nextResult = nextResult;
    }

    @Override
    public boolean pay(Customer customer, double amount) {
        return amount >= 0 && nextResult;
    }

}
