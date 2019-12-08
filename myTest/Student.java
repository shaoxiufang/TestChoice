package myTest;

public class Student extends Person {
	//调用Course类
	Course course;
	Student(String Id, String Name,char sex) {
	//引用父类构造方法
		super(Id,Name,sex);
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
}
