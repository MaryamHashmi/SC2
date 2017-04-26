package pk.edu.nust.seecs.gradebook.bo.reports;

import pk.edu.nust.seecs.gradebook.entity.*;

import java.util.List;

public class CourseContent extends Report {

    public CourseContent(List<Course> courses) {
        setHeadings(new String[]{
                "Content ID",
                "Title",
                "Description",
                "Course",
                "CLOs",
                "Students",
                "Grades"
        });

        int count = 0;
        for (Course course : courses) {
            count += course.getContents().size();
        }

        Object[][] data = new Object[count][7];

        int i = 0;
        for (Course course : courses) {
            for (Content content : course.getContents()) {
                data[i][0] = content.getContentId();
                data[i][1] = content.getTitle();
                data[i][2] = content.getDescription();
                data[i][3] = content.getCourse().getCourseTitle();

                data[i][4] = "";
                for (CLO clo : content.getCLO()) {
                    data[i][4] += clo.getName() + ". ";
                }

                data[i][5] = "";
                for (Student student : content.getStudents()) {
                    data[i][5] += student.getName() + ". ";
                }

                data[i][6] = "";
                for (Grade grade : content.getGrades()) {
                    data[i][6] += String.valueOf(grade.getScore()) + ". ";
                }

                i++;
            }
        }

        setData(data);
    }

}
