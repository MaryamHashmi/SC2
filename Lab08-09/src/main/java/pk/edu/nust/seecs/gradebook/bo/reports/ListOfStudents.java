package pk.edu.nust.seecs.gradebook.bo.reports;


import pk.edu.nust.seecs.gradebook.entity.Course;
import pk.edu.nust.seecs.gradebook.entity.Student;

import java.util.List;

public class ListOfStudents extends Report {

    public ListOfStudents(List<Student> students) {
        setHeadings(new String[]{
                "Student ID",
                "Name",
                "No. of Courses",
                "Courses"
        });

        Object[][] data = new Object[students.size()][4];

        for (int i = 0; i < students.size(); i++) {
            data[i][0] = students.get(i).getStudentId();
            data[i][1] = students.get(i).getName();
            data[i][2] = students.get(i).getCourses().size();

            data[i][3] = "";
            for (Course course : students.get(i).getCourses()) {
                data[i][3] += course.getCourseTitle() + ". ";
            }
        }

        setData(data);
    }

}
