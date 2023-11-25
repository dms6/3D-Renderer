package renderer.point;

public class MyPoint {
	
	public double x, y, z;

	public MyPoint(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public MyPoint(double x, double y) {
		this.y = x;
		this.z = y;
		this.x = 0;
	}
	@Override
	public String toString() {
		return "("+x+", "+y+", "+z+")";
	}

}
