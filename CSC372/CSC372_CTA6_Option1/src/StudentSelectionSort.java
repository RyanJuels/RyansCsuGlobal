import java.util.ArrayList;
import java.util.Comparator;

public class StudentSelectionSort {
	
	public void selectionSort(ArrayList<Student> li, Comparator<Student> comp) {
		
		int min;
		Student tempStudent;
		
		for(int i = 0; i < li.size() - 1; i++) {
			min = i;
			for(int j = i + 1; j < li.size(); j++) {
				if(comp.compare(li.get(j), li.get(min)) < 0) {
					min = j;
				}
			}
			tempStudent = li.get(i);
			li.set(i, li.get(min));
			li.set(min, tempStudent);
		}
	}
	
}
