package renderer.point;

import java.awt.Point;

import renderer.Display;

public class PointConverter {
	
	private static double scale = 1;
	private static final double ZoomFactor = 1.1;

	public static Point convertPoint(MyPoint point3D) {
		double x3d = point3D.y * scale;
		double y3d = point3D.z * scale;
		double depth = point3D.x * scale;

//		double lightScale = 1;
		double lightScale = 1400/(1400-depth);

		int x2d = (int)(Display.WIDTH/2 + x3d*lightScale);
		int y2d = (int)(Display.HEIGHT/2 - y3d*lightScale);

		return new Point(x2d, y2d);

	}
	
	public static void rotateAxisX(MyPoint p, boolean CW, double degrees) {
		double radius = Math.sqrt(p.y*p.y + p.z*p.z);
		double theta = Math.atan2(p.z, p.y);
		theta += Math.PI/180*degrees*(CW?-1:1);
		p.y = radius * Math.cos(theta);
		p.z = radius * Math.sin(theta);
	}
	
	public static void rotateAxisY(MyPoint p, boolean CW, double degrees) {
		double radius = Math.sqrt(p.z*p.z + p.x*p.x);
		double theta = Math.atan2(p.x, p.z);
		theta += 2*Math.PI/360*degrees*(CW?-1:1);
		p.x = radius * Math.sin(theta);
		p.z = radius * Math.cos(theta);
	}
	
	public static void rotateAxisZ(MyPoint p, boolean CW, double degrees) {
		double radius = Math.sqrt(p.y*p.y + p.x*p.x);
		double theta = Math.atan2(p.y, p.x);
		theta += Math.PI/180*degrees*(CW?-1:1);
		p.y = radius * Math.sin(theta);
		p.x = radius * Math.cos(theta);
	}
	
	public static void zoomIn() {
		scale *= ZoomFactor;
	} 
	
	public static void zoomOut() {
		scale /= ZoomFactor;
	}

}
