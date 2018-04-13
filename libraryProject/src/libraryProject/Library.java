package libraryProject;
import java.util.*;

public class Library {
	HashMap<Integer, Customer> customerMap = new HashMap<Integer, Customer>();
	HashMap<Integer, Item> bookShelf = new HashMap<Integer, Item>();
	Integer idAssignment = 1; 
	Integer itemAssignment = 1;
	
	public static void main(String[] args) {
		
		Library library = new Library();
		library.autoFillLibrary();
		library.addItem("book","Programming in Java");
		library.addItem("theses", "Economics Thesis");
		library.addItem("journal", "The chemsitry journal");
		library.createNewCustomer("Salah");
		library.assignItem(1, 101);
		library.accessCustomerDetails(1);
		library.updateCustomer(1, "mo");
		library.accessCustomerDetails(1);
		library.updateItem(102, "thesis replacement");
		library.assignItem(1, 102);
		library.accessCustomerDetails(1);
		
		/*
		library.createNewCustomer("Firmino");
		library.assignItem(2, 102);
		library.assignItem(2, 103);
		library.accessCustomerDetails(2);
		*/
	}
	
	public void createNewCustomer(String name) {
		Customer customer = new Customer();
		customer.name = name;
		customer.id = idAssignment;
		idAssignment++;
		customerMap.put(customer.id, customer);
	}
	
	public void deleteCustomer(Integer i) {
		customerMap.remove(i);
	}
	
	public void autoFillLibrary() {
		
		for(int i = 1; i <= 100; i++) {
			Book book = new Book(i);
			bookShelf.put(book.getID(), book);
			itemAssignment ++;
		}
	}
	
	public void addItem(String type, String title) {
		Book book = new Book(itemAssignment);
		Theses theses = new Theses(itemAssignment);
		Journals journal = new Journals(itemAssignment);
		
		book.title = title;
		theses.title = title;
		journal.title = title;
		
		switch(type){
		case "book" : bookShelf.put(book.getID(), book); break;
		case "journal": bookShelf.put(journal.getID(), journal); break;
		case "theses": bookShelf.put(theses.getID(), theses); break;
		}
		
		itemAssignment++;
	}
	
	public void removeItem(Integer id) {
		bookShelf.remove(id);
	}
	
	public void updateItem(Integer id, String replaceTitle){
		Item item = bookShelf.get(id);
		item.setTitle(replaceTitle);
	}
	
	public void updateCustomer(Integer id, String replaceName) {
		Customer customer = customerMap.get(id);
		customer.name = replaceName;
	}
	
	public void assignItem(Integer customerID, Integer itemID) {
		Customer customer = customerMap.get(customerID);
		//System.out.println(customer);
		customer.borrowedBooks.add(bookShelf.get(itemID));
	}
	
	public void checkOutItem(Integer customerID, Integer itemID) {
		Customer customer = customerMap.get(customerID);
		customer.borrowedBooks.remove(bookShelf.get(itemID));
	}
	
	public void accessCustomerDetails(Integer id) {
		try {
		Customer customer = customerMap.get(id);
		System.out.print("Name: ");
		System.out.println(customer.name);
		System.out.print("Customer ID: ");
		System.out.println(customer.id);
		
		System.out.print("Assigned Items: ");
		if(customer.borrowedBooks != null) {
			for(int i = 0; i < customer.borrowedBooks.size(); i++) {
				//System.out.print("Assigned item(ID): ");
				//System.out.println(customer.borrowedBooks.get(i).getID());
				
				
				if(customer.borrowedBooks.get(i).getTitle() != null) {
					System.out.print(customer.borrowedBooks.get(i).getTitle() +". ");
				}
			}
		}
		System.out.println("");
		System.out.println("");
		
		}
		catch(NullPointerException e){
			System.out.println("Error, Customer does not exist");
		}
	}
}