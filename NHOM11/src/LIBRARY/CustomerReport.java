package LIBRARY;

import java.util.*;

public class CustomerReport implements ReportStrategy {
	private LibraryDatabase database;

	public CustomerReport(LibraryDatabase database) {
		super();
		this.database = database;
	}

	@Override
	public void generateReport(ReportFilter filter) {
		System.out.println("\n Bao cao khach hang");
		List<Customer> customers = database.getCustomers();
		for (int i = 0; i < customers.size(); i++) {
			Customer c = customers.get(i);
			// xem tat ca khach hang
			if (filter.getStatus().equalsIgnoreCase("all")) {
				System.out.println(c);
				// xem khach hang dang vi pham
			} else if (filter.getStatus().equalsIgnoreCase("violation") && c.isViolation() == true) {
				System.out.println(c);
			}
		}
	}
	

}
