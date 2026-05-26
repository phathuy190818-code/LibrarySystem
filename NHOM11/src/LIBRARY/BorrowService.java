package LIBRARY;

import java.time.LocalDate;
import java.util.*;

public class BorrowService {
	private LibraryDatabase database;
	private FineStrategy fineStrategy;

	public BorrowService(LibraryDatabase database) {
		this(database, new FineStrategy(5000));
	}

	public BorrowService(LibraryDatabase database, FineStrategy fineStrategy) {
		super();
		this.database = database;
		this.fineStrategy = fineStrategy;
	}

	public boolean borrowBook(Book book, Customer customer, LocalDate borrowDate, LocalDate returnDate, LocalDate dueDate) {
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

		BorrowHistory history = new BorrowHistory(book, customer, borrowDate, returnDate, dueDate);
		database.addHistory(history);
		return true;
	}

	public boolean returnBook(Book book) {
		return returnBook(book, null);
	}

	public boolean returnBook(Book book, LocalDate actualReturnDate) {
		if (book == null) {
			return false;
		}
		List<BorrowHistory> histories = database.getHistories();
		for (int i = 0; i < histories.size(); i++) {
			BorrowHistory history = histories.get(i);
			if (history.getBook().getIdBook().equalsIgnoreCase(book.getIdBook()) && history.isReturned() == false) {
				if (actualReturnDate != null) {
					history.setReturnDate(actualReturnDate);
				}
				history.setReturned(true);
				book.setStatus(true);

				long overdueDays = history.getOverdueDays();
				if (overdueDays > 0) {
					history.setLate(true);
					Customer customer = history.getCustomer();
					customer.setViolation(true);
					System.out.println("Khach hang tra sach qua han!");
					System.out.println("So ngay tre: " + overdueDays);
					System.out.println("Tien phat: " + fineStrategy.calculateFine(overdueDays));
				} else {
					System.out.println("Tra sach thanh cong!");
				}
				return true;
			}
		}
		return false;
	}
}
