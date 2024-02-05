
public class Student {
	String name;
	String address;
	double gpa;
	
	public Student(String name, String address, double gpa) {
		super();
		this.name = name;
		this.address = address;
		this.gpa = gpa;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getGPA() {
		return gpa;
	}
	public void setGPA(double gPA) {
		gpa = gPA;
	}
	
	public String toString() {
		return name + ", " + address + ", " + gpa;
	}
}
