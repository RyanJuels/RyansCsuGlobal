
public class ShapeArray {

	public static void main(String[] args) {
		Sphere mySphere = new Sphere(5);
		Cylinder myCylinder = new Cylinder(5, 7);
		Cone myCone = new Cone(5, 8);
		
		Shape[] shapeArray = {mySphere, myCylinder, myCone};
		
		for (Shape item : shapeArray) {
			System.out.printf("%s: \n%s \n\n", item.getClass().getSimpleName(), item.toString());
		}

	}

}
