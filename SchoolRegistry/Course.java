/**
 * Title: Course.java
 * Abstract: This program contains the needed constructors, getters, and setters for School.java.
 * 			 It also contains the update location function.
 * Author: Eduardo Trejo
 * ID: 6787
 * Date: 10/24/2014
 */
public class Course {

	private int courseNum;
	private String courseName;
	private int courseInstructor;
	private String courseLocation;

	public Course(){
		this.courseNum = 0;
		this.courseName = "";
		this.courseInstructor = 0;
		this.courseLocation = "";
	}
	
	public Course(int courseNum, String courseName, int courseInstructor, String courseLocation) {
		this.courseNum = courseNum;
		this.courseName = courseName;
		this.courseInstructor = courseInstructor;
		this.courseLocation = courseLocation;
	}
	public String toString() {
		return courseNum + courseName + courseInstructor + courseLocation;
	}
	
	public int getCourseNum() {
		return courseNum;
	}
	
	public void setCourseNum(int courseNum) {
		this.courseNum = courseNum;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public int getCourseInstructor() {
		return courseInstructor;
	}
	
	public void setCourseInstructor(int courseInstructor) {
		this.courseInstructor = courseInstructor;
	}
	
	public String getCourseLocation() {
		return courseLocation;
	}
	
	public void setCourseLocation(String courseLocation) {
		this.courseLocation = courseLocation;
	}
	
	public void updateLocation(String courseLocation){
		this.courseLocation = courseLocation;
	}
}
