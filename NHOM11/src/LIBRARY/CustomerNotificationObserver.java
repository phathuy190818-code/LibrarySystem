package LIBRARY;

public class CustomerNotificationObserver implements NotificationObserver {
	public void onNotification(Customer customer, String message) {
        System.out.println("Thong bao cho " + customer.getName() + ": " + message);
    }

}
