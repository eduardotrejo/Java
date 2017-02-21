/**
 * Title: Student.java
 * Abstract: This program contains the needed constructors, getters, and setters for School.java.
 * 			 It also contains the update location function.
 * Author: Eduardo Trejo
 * ID: 6787
 * Date: 10/24/2014
 */
public class Student {

	private int studentId;
	private String studentName;
	private int studentCourse;
	private double studentGrade;
	private String studentLetter;
	
	public Student(){
		this.studentId = 0;
		this.studentName = "";
		this.studentCourse = 0;
		this.studentGrade = 0;
		this.studentLetter = "";
	}
	
	public Student(int studentId, String studentName, int studentCourse, double studentGrade, String studentLetter){
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentCourse = studentCourse;
		this.studentGrade = studentGrade;
		this.studentLetter = studentLetter;
	}
	
	public String toString() {
		return studentId + studentName + studentCourse + studentGrade + studentLetter ;
	}
	
	public int getStudentId() {
		return studentId;
	}
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(int studentCourse) {
		this.studentCourse = studentCourse;
	}

	public double getStudentGrade() {
		return studentGrade;
	}

	public void setStudentGrade(double studentGrade) {
		this.studentGrade = studentGrade;
	}

	public String getStudentLetter() {
		return studentLetter;
	}

	public void setStudentLetter(String studentLetter) {
		this.studentLetter = studentLetter;
	}
}
