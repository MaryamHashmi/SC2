package pk.edu.nust.seecs.gradebook.bo.reports;


import pk.edu.nust.seecs.gradebook.entity.Course;
import pk.edu.nust.seecs.gradebook.entity.Teacher;

import java.util.List;

public class ListOfTeachers extends Report {

    public ListOfTeachers(List<Teacher> teachers) {
        setHeadings(new String[]{
                "Teacher ID",
                "Name",
                "No. of Courses",
                "Courses"
        });

        Object[][] data = new Object[teachers.size()][4];

        for (int i = 0; i < teachers.size(); i++) {
            data[i][0] = teachers.get(i).getTeacherId();
            data[i][1] = teachers.get(i).getName();
            data[i][2] = teachers.get(i).getCourses().size();

            data[i][3] = "";
            for (Course course : teachers.get(i).getCourses()) {
                data[i][3] += course.getCourseTitle() + ". ";
            }

        }

        setData(data);
    }

}
