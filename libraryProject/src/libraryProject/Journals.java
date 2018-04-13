package libraryProject;

public class Journals implements Item{
	int rentTime;
	private Integer id;
	String title;
	
	public Journals(Integer i) {
		this.id = i;
	}
	
	@Override
	public Integer getID() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void setID(Integer i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTitle() {
		
		return title;
	}

	@Override
	public void setTitle(String str) {
		this.title = str;
	}

}
