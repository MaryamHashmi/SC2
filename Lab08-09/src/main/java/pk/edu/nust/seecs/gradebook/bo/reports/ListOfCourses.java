package pk.edu.nust.seecs.gradebook.bo.reports;

import pk.edu.nust.seecs.gradebook.entity.Course;

import java.util.List;


public class ListOfCourses extends Report {

    public ListOfCourses(List<Course> courses) {
        setHeadings(new String[]{
                "Course",
                "Credit Hours",
                "Instructor",
                "No. of Courses",
                "Start Date",
                "End Date"
        });

        Object[][] data = new Object[courses.size()][6];

        for (int i = 0; i < courses.size(); i++) {
            data[i][0] = courses.get(i).getCourseTitle();
            data[i][1] = courses.get(i).getCreditHours();
            data[i][2] = courses.get(i).getTeacher().getName();
            data[i][3] = courses.get(i).getStudents().size();
            data[i][4] = courses.get(i).getStartsOn();
            data[i][5] = courses.get(i).getEndsOn();
        }

        setData(data);
    }

}
