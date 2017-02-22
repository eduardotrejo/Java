/**
 * Title: Instructor.java
 * Abstract: This program contains the needed constructors, getters, and setters for School.java.
 * 			 It also contains the update location function.
 * Author: Eduardo Trejo
 * Date: 10/24/2014
 */
public class Instructor {

	private int instructorNum;
	private String instructorName;
	private String instructorEmail;
	private String instructorPhone;
	
	public Instructor(){
		this.instructorNum = 0;
		this.instructorName = "";
		this.instructorEmail = "";
		this.instructorPhone = "";
	}

	public Instructor(int iNum, String iName, String iEmail, String iPhone) {
		
		this.instructorNum = iNum;
		this.instructorName = iName;
		this.instructorEmail = iEmail;
		this.instructorPhone = iPhone;
	}

	public String toString() {
		return instructorNum + instructorName + instructorEmail + instructorPhone;
	}
	
	public int getInstructorNum() {
		return instructorNum;
	}

	public void setInstructorNum(int instructorNum) {
		this.instructorNum = instructorNum;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	public String getInstructorEmail() {
		return instructorEmail;
	}

	public void setInstructorEmail(String instructorEmail) {
		this.instructorEmail = instructorEmail;
	}

	public String getInstructorPhone() {
		return instructorPhone;
	}

	public void setInstructorPhone(String intructorPhone) {
		this.instructorPhone = intructorPhone;
	}

}
