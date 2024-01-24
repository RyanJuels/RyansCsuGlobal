import java.util.Comparator;

public class CompareRollNo implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		return s1.rollno - s2.rollno;
	}

}
