package myTest;

public class Student extends Person {
	//����Course��
	Course course;
	Student(String Id, String Name,char sex) {
	//���ø��๹�췽��
		super(Id,Name,sex);
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
}
