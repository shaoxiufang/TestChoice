package myTest;

public class Teacher extends Person{
	//µ÷ÓÃcourseÀà
	Course course;
	public Teacher(String Id, String Name,char sex) {
		super(Id,Name,sex);
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	
}
