package renderer.entity.builder;

import renderer.point.MyPoint;
import renderer.shapes.MyPolygon;
import renderer.shapes.Tetrahedron;

public class LetterBuilder {

	public static Tetrahedron createH(double d, double cX, double cY) {
		
		MyPoint p1 = new MyPoint(0+cX,0+cY);
		MyPoint p2 = new MyPoint(10+cX,0+cY);
		MyPoint p3 = new MyPoint(10+cX,15+cY);
		MyPoint p4 = new MyPoint(20+cX,15+cY);
		MyPoint p5 = new MyPoint(20+cX,0+cY);
		MyPoint p6 = new MyPoint(30+cX,0+cY);
		MyPoint p7 = new MyPoint(30+cX,40+cY);
		MyPoint p8 = new MyPoint(20+cX,40+cY);
		MyPoint p9 = new MyPoint(20+cX,25+cY);
		MyPoint p10 = new MyPoint(10+cX,25+cY);
		MyPoint p11 = new MyPoint(10+cX,40+cY);
		MyPoint p12 = new MyPoint(0+cX,40+cY);
		Tetrahedron tetra = Tetrahedron.extrude( d, new MyPolygon(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12));
		return tetra;
	}
	public static Tetrahedron createE(double d, double cX, double cY) {
		return Tetrahedron.extrude(d, new MyPolygon(
				new MyPoint(0+cX,0+cY),
				new MyPoint(30+cX,0+cY),
				new MyPoint(30+cX,8+cY),
				new MyPoint(10+cX,8+cY),
				new MyPoint(10+cX,16+cY),
				new MyPoint(30+cX,16+cY),
				new MyPoint(30+cX,24+cY),
				new MyPoint(10+cX,24+cY),
				new MyPoint(10+cX,32+cY),
				new MyPoint(30+cX,32+cY),
				new MyPoint(30+cX,40+cY),
				new MyPoint(0+cX,40+cY)));
	}
	public static Tetrahedron createL(double d, double cX, double cY) {
		return Tetrahedron.extrude(d, new MyPolygon(
				new MyPoint(0+cX,0+cY),
				new MyPoint(30+cX,0+cY),
				new MyPoint(30+cX,10+cY),
				new MyPoint(10+cX,10+cY),
				new MyPoint(10+cX,40+cY),
				new MyPoint(0+cX,40+cY)
				));
	}
	public static Tetrahedron createO(double d, double cX, double cY) {
		return Tetrahedron.extrude(d, new MyPolygon(
				new MyPoint(0+cX,0+cY),
				new MyPoint(30+cX,0+cY),
				new MyPoint(30+cX,40+cY),
				new MyPoint(0+cX,40+cY),
				new MyPoint(0+cX,27+cY),
				new MyPoint(20+cX,27+cY),
				new MyPoint(20+cX,13+cY),
				new MyPoint(10+cX,13+cY),
				new MyPoint(10+cX,27+cY),
				new MyPoint(0+cX,27+cY)
				));
	}
	public static Tetrahedron createW(double d, double cX, double cY) {
		return Tetrahedron.extrude(d, new MyPolygon(
				new MyPoint(0+cX,0+cY),
				new MyPoint(5+cX,0+cY),
				new MyPoint(15+cX,7.2+cY),
				new MyPoint(25+cX,0+cY),
				new MyPoint(30+cX,0+cY),
				new MyPoint(30+cX,40+cY),
				new MyPoint(21.5+cX,40+cY),
				new MyPoint(21.5+cX,14+cY),
				new MyPoint(15+cX,18.7+cY),
				new MyPoint(8.5+cX,14+cY),
				new MyPoint(8.5+cX,40+cY),
				new MyPoint(0+cX,40+cY)));
	}
	public static Tetrahedron createR(double d, double cX, double cY) {
		return Tetrahedron.extrude(d, new MyPolygon(
				new MyPoint(0+cX,0+cY),
				new MyPoint(8+cX,0+cY),
				new MyPoint(8+cX,10+cY),
				new MyPoint(24.19+cX,0+cY),
				new MyPoint(30+cX,0+cY),
				new MyPoint(30+cX,5.81+cY),
				new MyPoint(13.61+cX,15.94+cY),
				new MyPoint(30+cX,15.94+cY),
				new MyPoint(30+cX,40+cY),
				new MyPoint(0+cX,40+cY),
				new MyPoint(0+cX,32+cY),
				new MyPoint(22+cX,32+cY),
				new MyPoint(22+cX,23.94+cY),
				new MyPoint(8+cX,23.94+cY),
				new MyPoint(8+cX,32+cY),
				new MyPoint(0+cX,32+cY),
				new MyPoint(0+cX,0+cY)));
		
	}
	public static Tetrahedron createLine(double d, double startX,double startY,double finX, double finY) {
		return Tetrahedron.extrude(d, new MyPolygon(
				new MyPoint(startX, startY), new MyPoint(finX, finY)));
		
	}
	
	

}
