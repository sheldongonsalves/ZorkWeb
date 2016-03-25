
public class Room {

	public Room() {
		// TODO Auto-generated constructor stub
	}
	private String name;
	private String option1;
	private String option2;
	private String option3;
	private String things;
	
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	
	public String getThings() {
		return things;
	}
	public void setThings(String things) {
		this.things = things;
	}
	public String getName() {
		return name;
	}
	public void setName(String name1) {
		this.name = name1;
	}
	
	
	public Room(String name1  ,String things1 ,String opt1 ,String opt2 ,String opt3) {
		this.name = name1;
		this.option1 = opt1;
		this.option2 = opt2;
		this.option3 = opt3;
		this.things = things1;
	}
	@Override
	public String toString() {
		return "Room [name=" + name + ",option1="+ option1 +",option2=" + option2 +",option3="+ option3 +" ,things=" + things + "]";
	}
	
	

}
