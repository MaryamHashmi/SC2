package pk.edu.nust.seecs.gradebook.bo;

import pk.edu.nust.seecs.gradebook.dao.*;
import pk.edu.nust.seecs.gradebook.entity.*;

import java.util.*;

/**
 * @author saifkhichi96
 */
public class BusinessObject {

    private final CloDao cloDao;
    private final ContentDao contentDao;
    private final CourseDao courseDao;
    private final GradeDao gradeDao;
    private final StudentDao studentDao;
    private final TeacherDao teacherDao;

    private Map<Integer, Course> courseMap = new HashMap<>();
    private Map<Integer, Teacher> teacherMap = new HashMap<>();
    private Map<Integer, Student> studentMap = new HashMap<>();

    public BusinessObject(CloDao cloDao, ContentDao contentDao, CourseDao courseDao, GradeDao gradeDao, StudentDao studentDao, TeacherDao teacherDao) {
        this.cloDao = cloDao;
        this.contentDao = contentDao;
        this.courseDao = courseDao;
        this.gradeDao = gradeDao;
        this.studentDao = studentDao;
        this.teacherDao = teacherDao;
    }

    public int createCourse(String title, int credits) {
        Course course = new Course();
        course.setCourseTitle(title);
        course.setCreditHours(credits);
        course.setContents(new HashSet<Content>());
        course.setStudents(new HashSet<Student>());
        courseMap.put(courseMap.size(), course);
        return courseMap.size() - 1;
    }

    public Content addContent(int courseId, String title, String description) {
        Course course = courseMap.get(courseId);

        Content content = new Content();
        content.setTitle(title);
        content.setDescription(description);
        content.setCLO(new ArrayList<CLO>());
        content.setCourse(course);

        course.getContents().add(content);
        return content;
    }

    public void setTeacher(int courseId, int teacherId) {
        Course course = courseMap.get(courseId);
        Teacher teacher = teacherMap.get(teacherId);

        teacher.getCourses().add(course);
        course.setTeacher(teacher);
    }

    public int setTeacher(int courseId, String tname) {
        Course course = courseMap.get(courseId);

        Teacher teacher = new Teacher();
        teacher.setName(tname);
        teacher.setCourses(new HashSet<Course>());
        teacher.getCourses().add(course);
        course.setTeacher(teacher);

        teacherMap.put(teacherMap.size(), teacher);
        return teacherMap.size() - 1;
    }

    public void addStudent(int courseId, int studentId) {
        Course course = courseMap.get(courseId);
        Student student = studentMap.get(studentId);

        student.getCourses().add(course);
        course.getStudents().add(student);
    }

    public int addStudent(int courseId, String sname) {
        Course course = courseMap.get(courseId);

        Student student = new Student();
        student.setName(sname);
        student.setCourses(new HashSet<Course>());
        student.getCourses().add(course);

        course.getStudents().add(student);

        studentMap.put(studentMap.size(), student);
        return studentMap.size() - 1;
    }

    public void update() {
        for (Course course : courseMap.values()) {
            courseDao.addCourse(course);
        }
    }

    public List<Course> getCourses() {
        List<Course> courses = new ArrayList<>();
        courses.addAll(courseMap.values());
        return courses;
    }

    public List<Teacher> getTeacherList() {
        List<Teacher> teachers = new ArrayList<>();
        teachers.addAll(teacherMap.values());
        return teachers;
    }

    public List<Student> getStudentList() {
        List<Student> students = new ArrayList<>();
        students.addAll(studentMap.values());
        return students;
    }

    public void setStudentGrades(int studentId, Content content, String gradeName, int gradeScore) {
        Grade grade = new Grade();
        grade.setName(gradeName);
        grade.setScore(gradeScore);
        grade.setContentItem(content);

        content.getGrades().add(grade);
        content.getStudents().add(studentMap.get(studentId));
    }
}
