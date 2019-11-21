package applestoreAPI;

public class appleStorePOJO {
	
	private String name;
	private String status;
	
	//constructor
	public appleStorePOJO() {
		
	}

	public appleStorePOJO(String Nm, String Stat) {
		this.name=Nm;
		this.status=Stat;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
