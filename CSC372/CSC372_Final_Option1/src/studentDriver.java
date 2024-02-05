import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class studentDriver {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		LinkedList<Student> studentList = new LinkedList<>();
		Scanner myObj = new Scanner(System.in);
		boolean quit = false;
		
		while (!quit) {
			String response = "";
			String name = "";
			String address = "";
			double gpa = -1.0;
			
			
			System.out.println("What is the name: ");
			name = myObj.nextLine();
			
			System.out.println("What is the address: ");
			address = myObj.nextLine();
			
			
			while(gpa < 0.0 || gpa > 4.0) {
				try {
					System.out.println("What is the gpa (0.0 - 4.0): ");
					gpa = Double.parseDouble(myObj.nextLine());
				}
				catch(Exception e) {
					System.out.println("Please enter a number");
				}
			}
			
			studentList.add(new Student(name, address, gpa));
			
			System.out.println("Do you want to enter another? (y/n): ");
			response = myObj.nextLine();
			
			
			
			if(response.toLowerCase().equals("n") || response.toLowerCase().equals("no")) {
				quit = true;
			}
		}
		
		Collections.sort(studentList, new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				return s1.name.compareToIgnoreCase(s2.name);
			}
		});
		
		FileWriter fw = new FileWriter("output.txt");
		for (int i = 0; i < studentList.size(); i++) {
		    fw.write(studentList.get(i).toString() + "\n");
		}
		fw.close();
	}
}