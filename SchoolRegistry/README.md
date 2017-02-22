#SchoolRegistry

<p>This program contains four classes called School, Instructor, Course, and Student to store instructors, courses, and student information of a school</p>

<b>Sample Input File</b>
<p align="center">
<img src="https://github.com/eduardotrejo/Java/blob/master/SchoolRegistry/text_file.png"/>
</p>
<p>The first line (= 4) indicates the number of instructors in the school. The information includes the instructor’s unique employee number, name, email, and phone number. Note that each data (= each line) is delimited by comma symbol (,).</p>
<p>After the instructor’s data, the following number 4 indicates the number of courses in the school. The course data includes the unique course number, course title, instructor’s number, and class room.</p>
<p>
After the course data, there is the number of students (= 5 in the example) in the school. Each student’s information indicates the student’s unique ID, name, course enrolled, final score, and letter grade.</p>

<b>Some limitation and comments</b>
* To process the input data with the comma symbol (,) delimiter, StringTokenizer class will be
useful.
* For the deleteCourse() method, a course should not be deleted from the school if there’s a student enrolled the course.
* For the graduateStudent() method, all courses the student enrolled should be deleted.
<p align="center">
<b>Output example</b>
<img src="https://github.com/eduardotrejo/Java/blob/master/SchoolRegistry/example.png"/>
<img src="https://github.com/eduardotrejo/Java/blob/master/SchoolRegistry/example2.png"/>
</p>
