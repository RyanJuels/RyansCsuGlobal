import java.util.Comparator;

public class CompareName implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		// TODO Auto-generated method stub
		return s1.name.compareToIgnoreCase(s2.name);
	}

}
