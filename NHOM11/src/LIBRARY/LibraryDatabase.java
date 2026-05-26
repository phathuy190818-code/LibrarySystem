package LIBRARY;

import java.util.*;

public class LibraryDatabase {
	private List<Book> books = new ArrayList<Book>();
	private List<Customer> customers = new ArrayList<Customer>();
	private List<BorrowHistory> histories = new ArrayList<BorrowHistory>();

	public LibraryDatabase() {
		super();
	}

	public List<Book> getBooks() {
		return books;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public List<BorrowHistory> getHistories() {
		return histories;
	}

	// them sach
	public boolean addBook(Book book) {
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getIdBook().equalsIgnoreCase(book.getIdBook())) {
				return false;
			}
		}
		books.add(book);
		return true;
	}

//xoa sach
	public boolean removeBook(String id) {
		for (int i = 0; i < books.size(); i++) {
			Book book = books.get(i);
			if (book.getIdBook().equalsIgnoreCase(id)) {
				if (book.isStatus() == false) {
					System.out.println("Sach dang duoc muon, khong the xoa!");
					return false;
				}
				books.remove(i);
				return true;
			}
		}
		return false;
	}

//them khach hang
	public boolean addCustomer(Customer customer) {
		if (customer == null || findCustomerById(customer.getId()) != null) {
			return false;
		}
		customers.add(customer);
		return true;
	}

	public Customer findCustomerById(String id) {
		if (id == null) {
			return null;
		}
		for (int i = 0; i < customers.size(); i++) {
			Customer customer = customers.get(i);
			if (customer.getId().equalsIgnoreCase(id)) {
				return customer;
			}
		}
		return null;
	}

	public Customer findCustomerByEmail(String email) {
		if (email == null) {
			return null;
		}
		for (int i = 0; i < customers.size(); i++) {
			Customer customer = customers.get(i);
			if (customer.getEmail() != null && customer.getEmail().equalsIgnoreCase(email)) {
				return customer;
			}
		}
		return null;
	}

	public Book findBookById(String id) {
		if (id == null) {
			return null;
		}
		for (int i = 0; i < books.size(); i++) {
			Book book = books.get(i);
			if (book.getIdBook().equalsIgnoreCase(id)) {
				return book;
			}
		}
		return null;
	}

//them lich su muon
	public void addHistory(BorrowHistory history) {
		histories.add(history);
	}

//hien thi danh sach cua sach
	public void showAllBook() {
		System.out.println("List Book");
		for (int i = 0; i < books.size(); i++) {
			System.out.println(books.get(i));
		}
	}

//hien thi danh sach khach hang
	public void showAllCustomer() {
		System.out.println("List customer");
		for (int i = 0; i < customers.size(); i++) {
			System.out.println(customers.get(i));
		}
	}
}
