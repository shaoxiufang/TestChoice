package myTest;

public class Person {
	
	public   String Id;
	public   String Name;
	public char sex;
	//person��Ĺ��췽��
	public Person(String Id, String Name, char sex) {
		this.Id=Id;
		this.Name=Name;
		this.sex=sex;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "���:" + Id + ", ����:" + Name + ", �Ա�:" + sex;
	}
	
	

}
