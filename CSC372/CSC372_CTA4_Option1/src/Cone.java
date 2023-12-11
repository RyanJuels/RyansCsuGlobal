
public class Cone extends Shape {
	
	private double radius;
	private double height;
	
	public Cone(double radius, double height) {
		super();
		this.radius = radius;
		this.height = height;
	}

	
	@Override	
	public double surface_area() {
		return Math.PI * this.radius * (this.radius + (Math.sqrt(Math.pow(this.radius, 2) + Math.pow(this.height, 2))));
	}

	@Override
	public double volume() {
		return Math.PI * Math.pow(this.radius, 2) * this.height / 3;
	}
	
	@Override
	public String toString() {
		return String.format("Surface Area: %.2f\nVolume: %.2f", surface_area(), volume());
	}

}
