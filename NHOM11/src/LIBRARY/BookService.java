package LIBRARY;

public class BookService {
	private LibraryDatabase database;

	public BookService(LibraryDatabase database) {
		super();
		this.database = database;
	}

//kt xem sach duoc them vao la null hay id co rong ko
	public boolean addBook(Book book) {
		if (book == null || book.getIdBook().equals("")) {
			return false;
		}
		return database.addBook(book);

	}
//kt id sach muon xoa la null hay rong
	public boolean removeBook(String id) {
		if (id == null || id.equals("")) {
			return false;
		}
		return database.removeBook(id);

	}
}
