package pk.edu.nust.seecs.gradebook;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import pk.edu.nust.seecs.gradebook.bo.BusinessObject;
import pk.edu.nust.seecs.gradebook.bo.reports.*;
import pk.edu.nust.seecs.gradebook.entity.Content;
import pk.edu.nust.seecs.gradebook.entity.Course;

/**
 *
 */
public class App {

    public static void main(String[] args) {
        Resource r = new ClassPathResource("applicationContext.xml");
        BeanFactory factory = new XmlBeanFactory(r);

        BusinessObject bo = (BusinessObject) factory.getBean("bo");

        // Create courses
        int sqe = bo.createCourse("Software Qulaity Engineering", 3);
        int tbw = bo.createCourse("Technical and Business Writing", 2);
        int fm = bo.createCourse("Formal Methods", 3);
        int ml = bo.createCourse("Machine Learning", 4);
        int nm = bo.createCourse("Numerical Methods", 3);
        int sc = bo.createCourse("Software Construction", 4);

        // Set course teachers
        int tsqe = bo.setTeacher(sqe, "Ayesha Kanwal");
        int ttbw = bo.setTeacher(tbw, "Komal Malik");
        int tfm = bo.setTeacher(fm, "Sohail Iqbal");
        int tml = bo.setTeacher(ml, "Imran Malik");
        int tnm = bo.setTeacher(nm, "Atifa Kanwal");
        int tsc = bo.setTeacher(sc, "Fahad Satti");

        // Enroll myself in all courses
        int me = bo.addStudent(sqe, "Muhammad Saifullah Khan");
        bo.addStudent(tbw, me);
        bo.addStudent(fm, me);
        bo.addStudent(ml, me);
        bo.addStudent(nm, me);
        bo.addStudent(sc, me);

        // Add OHTs
        Content osqe = bo.addContent(sqe, "OHT-1", "First One-Hour Test");
        Content otbw = bo.addContent(tbw, "OHT-1", "First One-Hour Test");
        Content ofm = bo.addContent(fm, "OHT-1", "First One-Hour Test");
        Content oml = bo.addContent(ml, "OHT-1", "First One-Hour Test");
        Content onm = bo.addContent(nm, "OHT-1", "First One-Hour Test");
        Content osc = bo.addContent(sc, "OHT-1", "First One-Hour Test");

        // Set OHT marks
        bo.setStudentGrades(me, osqe, "B+ /45", 30);
        bo.setStudentGrades(me, osc, "A /35", 27);

        Report report;

        report = new ListOfCourses(bo.getCourses());
        report.export("report-courses");

        report = new ListOfTeachers(bo.getTeacherList());
        report.export("report-teachers");

        report = new ListOfStudents(bo.getStudentList());
        report.export("report-students");

        report = new CourseContent(bo.getCourses());
        report.export("course-content");
    }

}