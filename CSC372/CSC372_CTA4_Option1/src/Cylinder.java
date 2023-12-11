
public class Cylinder extends Shape {
	
	private double radius;
	private double height;
	
	public Cylinder(double radius, double height) {
		super();
		this.radius = radius;
		this.height = height;
	}
	
	@Override
	public double surface_area() {
		// TODO Auto-generated method stub
		return (2 * Math.PI * this.radius * this.height) + (2 * Math.PI * Math.pow(this.radius, 2));
	}

	@Override
	public double volume() {
		return Math.PI * Math.pow(this.radius, 2) * this.height;
	}

	@Override
	public String toString() {
		return String.format("Surface Area: %.2f\nVolume: %.2f", surface_area(), volume());
	}
}
