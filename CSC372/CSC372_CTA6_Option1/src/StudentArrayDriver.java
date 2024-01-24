import java.util.ArrayList;

public class StudentArrayDriver {

	public static String listToSting(ArrayList<Student> li) {
		String ret = "";
		for(Student s : li) {
			ret += s.toSting();
			ret += "\n";
		}
		return ret;
	}
	
	public static void main(String[] args) {
		StudentSelectionSort sorting = new StudentSelectionSort();
		
		ArrayList<Student> myList = new ArrayList<>();
		myList.add(new Student(9, "Ryan", "111 East Lane"));
		myList.add(new Student(5, "Jim", "222 West Prov"));
		myList.add(new Student(6, "Eric", "333 Maple"));
		myList.add(new Student(10, "John", "123 Yesterday Street"));
		myList.add(new Student(2, "Sherry", "8123 New York"));
		myList.add(new Student(3, "Jessica", "347 W Inverness Lane"));
		myList.add(new Student(1, "Mary", "347 W Inverness Lane"));
		myList.add(new Student(8, "Justin", "673 W Maple Road"));
		myList.add(new Student(7, "Jake", "8123 New York"));
		myList.add(new Student(4, "Tiffany", "123123 Main Street"));
		
		
		System.out.println("This is the original List: ");
		System.out.println(listToSting(myList));
		
		sorting.selectionSort(myList, new CompareRollNo());
		
		System.out.println("\n\n\n\nThis is the List when sorted by rollNo: ");
		System.out.println(listToSting(myList));
		
		sorting.selectionSort(myList, new CompareName());
		
		System.out.println("\n\n\n\nThis is the List when sorted by Name: ");
		System.out.println(listToSting(myList));
	}
}
