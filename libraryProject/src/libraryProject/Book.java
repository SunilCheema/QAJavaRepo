package libraryProject;


public class Book implements Item{
	int rentTime;
	private Integer id;
	String title;
	
	public Book(Integer i) {
		this.id = i;
	}
	public Integer getID() {
		return id;
	}
	public void setID(Integer i) {
		this.id = i;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String str) {
		this.title = str;
	}
	
	
	
}
