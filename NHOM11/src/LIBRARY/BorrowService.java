package LIBRARY;

import java.util.*;

public class BorrowService {
	private LibraryDatabase database;

	public BorrowService(LibraryDatabase database) {
		super();
		this.database = database;
	}

	public boolean borrowBook(Book book, Customer customer, int year, int borrowDate, int dueDate) {
		if (book == null || customer == null) {
			return false;
		}
		if (book.isStatus() == false) {
			System.out.println("Sach dang duoc muon!");
			return false;
		}
		if (customer.isViolation()) {
			System.out.println("Khach hang dang vi pham!");
			return false;
		}
		book.setStatus(false);

		BorrowHistory history = new BorrowHistory(book, customer, year, borrowDate, dueDate);
		database.addHistory(history);
		return true;
	}

	public boolean returnBook(Book book, int currentDate) {
		List<BorrowHistory> histories = database.getHistories();
		for (int i = 0; i < histories.size(); i++) {
			BorrowHistory history = histories.get(i);
			if (history.getBook().getIdBook().equalsIgnoreCase(book.getIdBook()) && history.isReturned() == false) {
				history.setReturned(true);
				book.setStatus(true);
				
				int totalDate=currentDate-history.getBorrowDate();
				if (totalDate > history.getDueDate()) {
					history.setLate(true);
					Customer customer = history.getCustomer();
					customer.setViolation(true);
					System.out.println("Khach hang tra sach qua han!");
				} else {
					System.out.println("Tra sach thanh cong!");
				}
				return true;
			}
		}
		return false;
	}
}
