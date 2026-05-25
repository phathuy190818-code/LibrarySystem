package LIBRARY;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {
	private List<NotificationObserver> observers = new ArrayList<NotificationObserver>();

    public void addObserver(NotificationObserver observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    public void removeObserver(NotificationObserver observer) {
        observers.remove(observer);
    }

    public void notifyCustomer(Customer customer, String message) {
        for (NotificationObserver observer : observers) {
            observer.onNotification(customer, message);
        }
    }

}
