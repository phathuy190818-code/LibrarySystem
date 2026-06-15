package LIBRARY;

import java.time.LocalDate;
import java.util.*;

public class BorrowService {
	private LibraryDatabase database;
	private List<ICheckValidationStrategy> validators = new ArrayList<ICheckValidationStrategy>();

	public BorrowService(LibraryDatabase database) {
		this.database = database;
		
		//them phuong thuc kiem tra hien tai 
		 validators.add(new BookStatusValidate()); // kiem tra sach co san trong thu vien khong 
		 validators.add(new CustomerViolationValidation()); // kiem tra khach hang co vi pham khong
		 validators.add(new NumberOfBookBorrowed()); // kiem tra da dat gioi han muon sach hay chua
	}
	
	//them phuong thuc kiem tra moi
	public void addValidator(ICheckValidationStrategy validator ) {
		this.validators.add(validator);
	}
	
	
	public boolean borrowBook(Book book, Customer customer, LocalDate dueDate) {
		//duyet qua tat ca cac chien luoc de kiem tra
		for (ICheckValidationStrategy iBorrowValidationStrategy : validators) {
			if(!iBorrowValidationStrategy.validate(book, customer)) {
				return false; // 1 chien luoc that bai -> tu choi muon
			}
		}
		
		book.setStatus("dang muon");
		BorrowHistory history = new BorrowHistory(book, customer, LocalDate.now(), null, dueDate);
		database.addHistory(history); // luu lich su tim sach 
		customer.booksBorrowedList.add(book);
		return true;
	}

}
