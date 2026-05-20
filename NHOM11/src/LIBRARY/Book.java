package LIBRARY;

public class Book {
	private String idBook;
	private String title;
	private String author;
	private String category;
	private boolean status;
	private double price;
	private int year;// Năm sản xuất
//true=con sach
//false=sach dang duoc muon

	public Book(String idBook, String title, String author, String category, boolean status) {
		super();
		this.idBook = idBook;
		this.title = title;
		this.author = author;
		this.category = category;
		this.status = status;
	}

	public String getIdBook() {
		return idBook;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getCategory() {
		return category;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	public double getPrice() {
		return price;
	}
	public int getYear() {
		return year;
	}

	@Override
	public String toString() {
		return "idBook=" + idBook + ", title=" + title + ", author=" + author + ", category=" + category + ", status="
				+ status;
	}

}
