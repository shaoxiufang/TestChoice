package myTest;
import java.util.ArrayList;
import java.util.List;

public class Course {
	private String CourserId;
	private String CourseName;
	private String CoursePlace;
	private String CourseTime;
	private double CourseScore;
	//����Teacher��Student
	private Teacher teacher;
	private List<Student> student=new ArrayList<Student>();
	//����course �Ĺ��췽��
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
	//ת�����ַ���
	@Override
	public String toString() {
		return "�γ̱�ţ�" + CourserId + ", �γ����ƣ�" + CourseName + ", �Ͽε�ַ��" + CoursePlace
				+ ", �Ͽ�ʱ�䣺" + CourseTime + ", ѧ��:" + CourseScore +"\n"+ "��ʦ��" + teacher + '\n'+"ѡ��ѧ����"
				+ student + "]";
	}
	
	
	

}
