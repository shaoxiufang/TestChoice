package myTest;
import java.util.ArrayList;
import java.util.List;

public class Course {
	private String CourserId;
	private String CourseName;
	private String CoursePlace;
	private String CourseTime;
	private double CourseScore;
	//调用Teacher和Student
	private Teacher teacher;
	private List<Student> student=new ArrayList<Student>();
	//创建course 的构造方法
	public Course (String courserId, String courseName, String coursePlace, String courseTime, double courseScore){
		super();
		CourserId = courserId;
		CourseName = courseName;
		CoursePlace = coursePlace;
		CourseTime = courseTime;
		CourseScore = courseScore;
	}

	public String getCourserId() {
		return CourserId;
	}

	public void setCourserId(String courserId) {
		CourserId = courserId;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	public String getCoursePlace() {
		return CoursePlace;
	}

	public void setCoursePlace(String coursePlace) {
		CoursePlace = coursePlace;
	}

	public String getCourseTime() {
		return CourseTime;
	}

	public void setCourseTime(String courseTime) {
		CourseTime = courseTime;
	}

	public double getCourseScore() {
		return CourseScore;
	}

	public void setCourseScore(double courseScore) {
		CourseScore = courseScore;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}
	//转化成字符串
	@Override
	public String toString() {
		return "课程编号：" + CourserId + ", 课程名称：" + CourseName + ", 上课地址：" + CoursePlace
				+ ", 上课时间：" + CourseTime + ", 学分:" + CourseScore +"\n"+ "教师：" + teacher + '\n'+"选课学生："
				+ student + "]";
	}
	
	
	

}
