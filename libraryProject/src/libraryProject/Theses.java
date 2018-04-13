package libraryProject;

public class Theses implements Item{
	int rentTime;
	private Integer id;
	String title;
	
	public Theses(Integer i) {
		this.id = i;
	}
	@Override
	public Integer getID() {
		return id;
	}

	@Override
	public void setID(Integer i) {
		// TODO Auto-generated method stub
		this.id = i;
	}
	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return title;
	}
	@Override
	public void setTitle(String str) {
		this.title = str;
		
	}

}
