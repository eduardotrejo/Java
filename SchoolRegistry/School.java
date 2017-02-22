/**
 * Title: School.java
 * Abstract: This program uses 3 array list to store data of a file that is read.
 * 			 It acts as a school database. It has a function that reads the data,
 * 			 prints out the school info, delete course, course info, add instructor,
 * 			 add course, get course, add student, graduate student, and student info.
 * Author: Eduardo Trejo
 * Date: 10/24/2014
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class School {

	private String department;
	private boolean testing = false;
	private ArrayList<Student> studentData = new ArrayList<Student>();
	private ArrayList<Instructor> instructorData = new ArrayList<Instructor>();
	private ArrayList<Course> courseData = new ArrayList<Course>();
	
	public School(){
		department = "";
	}
	
	public School(String dp){
		department = dp;
	}
	
	// Reads the data of file as sections. It uses delimiter to remove comma and
	// creates new objects.
	public void readData(String fileName){

		int number = 0;
		int dataSections = 0;
		
		FileReader text = null;
		try{
			text = new FileReader(fileName);
			
		}catch(FileNotFoundException e){
			System.out.println("Error opening the file " + fileName);
			System.exit(0);	
			
		}	
		Scanner source = new Scanner(text);
		
		// Used to remove the comma in the file.
		source.useDelimiter(",");
		
		while(source.hasNext())
		{
			// File has 3 sections.
			if(dataSections == 0)
			{
				// Determines how many times to loop.
				number = Integer.parseInt(source.nextLine());
				
				while(number-- != 0){
					// Create object of Instructor class that takes in all variables.
					Instructor newTeacher = new Instructor(source.nextInt(), source.next(), source.next(), source.nextLine());
					// Makes sure the comma before the phone number is not added.
					newTeacher.setInstructorPhone(newTeacher.getInstructorPhone().replace(",", ""));
					// Adds the object to the array list.
					instructorData.add(newTeacher);
					// Once number is equal to 0 increase section.
					if(number == 0){
						dataSections++;
					}
				}				
			}
			
			if(dataSections == 1)
			{
				// Determines how many times to loop.
				number = Integer.parseInt(source.nextLine());
	
				while(number-- != 0){
					// Create object of Course class that takes in all variables.
					Course newCourse = new Course(source.nextInt(), source.next(), source.nextInt(), source.nextLine());
					// Makes sure the comma before the course location is not added.
					newCourse.setCourseLocation(newCourse.getCourseLocation().replace(",", ""));
					// Adds the object to the array list.
					courseData.add(newCourse);
					// Once number is equal to 0 increase section.
					if(number == 0){
						dataSections++;
					}
				}			
			}
			
			if(dataSections == 2)
			{
				// Determines how many times to loop.
				number = Integer.parseInt(source.nextLine());
				while(number-- != 0){
					// Create object of Student class that takes in all variables.
					Student newStudent = new Student(source.nextInt(), source.next(), source.nextInt(), source.nextDouble(),
							source.nextLine());
					// Makes sure the comma before the student letter is not added.
					newStudent.setStudentLetter(newStudent.getStudentLetter().replace(",", ""));
					// Adds the object to the array list.
					studentData.add(newStudent);
				}			
			}
		}
	}

	// Prints out the school info.
	public void schoolInfo(){
	
        System.out.print("School Name: " + department + "\n");
        System.out.println("Instructor Information");
        
        // Prints out instructors name.
        for(Instructor obj : instructorData){
			System.out.print("	" + obj.getInstructorName() + "\n");
		}
        
        System.out.println("Course Information");
        
        // Prints out the course information.
        for(Course obj : courseData){
			System.out.print("	" + obj.getCourseName() + "\n");
		}
        
        System.out.println("Student Information");
        
        // Prints the name of the student with their courses.
        for(Student obj : studentData){
        	for(Course otherobj : courseData)
        	{		
        		if(obj.getStudentCourse() == otherobj.getCourseNum())
        		{
        			System.out.print("	" + obj.getStudentName() + ": "
        					+ otherobj.getCourseName() + "\n");
        		}
        	}
		}   
	}
	
	// Deletes courses from the school if it has no students enrolled in it.
	public void deleteCourse(int courseNum){

		boolean exist = false;
		
		for(Course obj : courseData){
				
			if(obj.getCourseNum() == courseNum)
			{
				for(Student object : studentData){
					if(obj.getCourseNum() == object.getStudentCourse()){
						exist = true;
						break;
					}
				}	
				if(exist == false){
					courseData.remove(obj);
					break;
				}		
			}
		}	
	}

	// Prints out the number of courses with the number of students enrolled.
	public void courseInfo() {
		System.out.println("Number of Courses: " + courseData.size());
		int enrolled = 0;
		for(Course obj : courseData){
			
			for(Student object : studentData){
				if(obj.getCourseNum() == object.getStudentCourse()){
					enrolled++;
				}
			}
			System.out.print(obj.getCourseNum() + ": " + enrolled + " enrolled.\n");
			enrolled = 0;		
		}
		
	}
	
	// Prints out course info if found, otherwise it does not.
	public void courseInfo(int cNum) {

		boolean found = false;
		int num = 0;
		int coursenum = 0;
		int students = 0;
		
		for(Course obj : courseData){
			if(obj.getCourseNum() == cNum){
				System.out.println("Course Number: " + cNum);
				num = obj.getCourseInstructor();	
				coursenum = cNum;
				found = true;
			}
		}
		if(found == true){
			for(Instructor obj : instructorData){
				if(obj.getInstructorNum() == num){
					System.out.println("Instructor Name: " + obj.getInstructorName());
					
				}
			}
			for(Course obj : courseData){
				if(obj.getCourseNum() == coursenum){
					System.out.println("Course Title: " + obj.getCourseName());	
					System.out.println("Room: " + obj.getCourseLocation());	
				}
			}
			double average = 0;
			for(Student obj : studentData){
				if(obj.getStudentCourse() == coursenum){
					students++;
					System.out.printf("	%s: %.2f (%s)\n", obj.getStudentName(), obj.getStudentGrade()
							, obj.getStudentLetter());	
					average += obj.getStudentGrade();
				}
			}
			if(students > 0){
				System.out.printf("Course Average: %.2f\n", average / students);
			}
			else{
				System.out.println("Course Average: 0.00");
			}
		}
		else{
			System.out.println("Course Number: " + cNum + " was not found.");
		}
	}

	// Checks if the instructor number already exist, if not it adds it.
	public void addInstructor(int iNum, String iName, String iEmail, String iPhone){
		boolean duplicate = false;
		
		for(Instructor obj : instructorData)
    	{	
			if(obj.getInstructorNum() == iNum){
			
				System.out.println("Instructor addition failed – Duplicated instructor number.");
				duplicate = true;
			}	
    	}
		if(duplicate == false){
			Instructor newInstructor = new Instructor(iNum, iName, iEmail, iPhone);
			instructorData.add(newInstructor);
		}	
		duplicate = false;		
	}

	// Checks if the course number already exist, if not it adds it.
	public void addCourse(int cNum, String cName, int cInstructor, String cLocation) {
		boolean duplicate = false;
		
		for(Course obj : courseData)
    	{	
			if(obj.getCourseNum() == cNum){
			
				System.out.println("Course addition failed – Duplicated course number.");
				duplicate = true;
			}	
    	}
		if(duplicate == false){
			Course newCourse = new Course(cNum, cName, cInstructor, cLocation);
			courseData.add(newCourse);
		}	
		duplicate = false;
	}

	// Returns the object of that Course that is requested.
	public Course getCourse(int cNum) {
		
		for(Course obj: courseData)
		{
			if(obj.getCourseNum() == cNum)
			{
				return obj;
			}
		}
		return null;
	}

	// Checks if the student number already exist, if not it adds it.
	public void addStudent(int sId, String sName, int sCourse, double sGrade, String sLetter) {
		boolean duplicate = false;
		
		for(Student obj : studentData)
    	{	
			if(obj.getStudentId() == sId){
			
				System.out.println("Student addition failed – Duplicated student number.");
				duplicate = true;
			}	
    	}
		if(duplicate == false){
			Student newStudent = new Student(sId, sName, sCourse, sGrade, sLetter);
			studentData.add(newStudent);
		}
		duplicate = false;
	}

	// Checks if that student exist and deletes all courses the student is enrolled in.
	public void graduateStudent(int sNum) {
		// Had to use for loop here instead of a for each.
		for(int i = 0; i < studentData.size(); i++){
			
			if(studentData.get(i).getStudentId() == sNum){
				studentData.remove(i);
				i = 0;
				testing = true;
				continue;
			}
			else if(testing != true)
			{
				System.out.println("Student does not exist.");
				break;
			}
		}		
	}

	// First checks if that course number exist and if does prints out information.
	public void studentInfo(int sNum) {
		System.out.println("Student Number: " + sNum);
		if(testing == true){
			System.out.println("Does not exist");
		}
		else{
			testing = false;
			for(Student obj : studentData){
				if(obj.getStudentId() == sNum){
					System.out.println("Name: " + obj.getStudentName());
					break;
				}
			}
			double average = 0;
			int students = 0;
			System.out.println("Courses Enrolled: ");
			for(Student obj : studentData){
					if(obj.getStudentId() == sNum){
						students++;
						System.out.printf("	%d: %.2f (%s)\n", obj.getStudentCourse(), obj.getStudentGrade()
								, obj.getStudentLetter());
						average += obj.getStudentGrade();
					}
				
			}	
			System.out.printf("Course Average: %.2f\n", average / students);
		}		
	}
}
