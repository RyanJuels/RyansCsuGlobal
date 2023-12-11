
public class Sphere extends Shape {

	private double radius;
	
	public Sphere(double radius) {
		super();
		this.radius = radius;
	}
	
	@Override
	public double surface_area() {
		return 4 * Math.PI * Math.pow(this.radius, 2);
	}

	@Override
	public double volume() {
		// TODO Auto-generated method stub
		return 4.0 / 3 * Math.PI * Math.pow(this.radius, 3);
	}
	
	@Override
	public String toString() {
		return String.format("Surface Area: %.2f\nVolume: %.2f", surface_area(), volume());
	}

}
