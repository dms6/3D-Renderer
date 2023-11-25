package renderer.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import renderer.entity.Entity;
import renderer.point.MyPoint;
import renderer.point.PointConverter;

import javax.imageio.ImageIO;

public class MyPolygon {
	public MyPoint[] points;

	public static BufferedImage img;

	//put in entity class?
	static {
		try {
			img = ImageIO.read(new File("src/renderer/square.jpg"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public MyPolygon(MyPoint... points) {
		this.points = new MyPoint[points.length];
		for (int i = 0; i < points.length; i++) {
			MyPoint p = points[i];
			this.points[i] = new MyPoint(p.x, p.y, p.z);
		}

	}

	public double getAverageX() {
		double sum = 0;
		for (MyPoint p : this.points) {
			sum += p.x;
		}
		return sum / this.points.length;
	}

	public void render(Graphics g) {
		Polygon poly = new Polygon();
		for (MyPoint point : this.points) {
			Point p = PointConverter.convertPoint(point);
			poly.addPoint(p.x, p.y);
		}
		Color color = getColor();
		g.setColor(color);
		g.fillPolygon(poly);
//		//TODO

		g.setColor(Color.WHITE);
		g.drawPolygon(poly);

	}

	public void rotate(boolean CW, double xDegrees, double yDegrees, double zDegrees) {
		for (MyPoint p : points) {

			PointConverter.rotateAxisX(p, CW, xDegrees);
			PointConverter.rotateAxisY(p, CW, yDegrees);
			PointConverter.rotateAxisZ(p, CW, zDegrees);
		}
	}


	public static void sortPolygons(MyPolygon[] polygons) {
		List<MyPolygon> polygonsList = Arrays.asList(polygons);

		polygonsList.sort(new Comparator<MyPolygon>() {
			@Override
			public int compare(MyPolygon p1, MyPolygon p2) {
				try {
					return (p1.getAverageX() - p2.getAverageX() > 0 ? 1 : -1);
				} catch (Exception ignored) {
				}
				return 1;
			}
		});

		for (int i = 0; i < polygons.length; i++) {
			polygons[i] = polygonsList.get(i);
		}
	}

	public Color getColor() {
		//normalize to 0, 2*shift, then porportion to 0,255
		double shift = Entity.globalMaxX - Entity.globalMinX;
		int a = (int) ((getAverageX() + shift / 2.0) * (255 / (shift)));
		if (a > 255) a = 255;
		else if (a < 0) a = 0;
		return new Color(a, a, a);
		//return new Color(Color.HSBtoRGB(a/255f, 1f, 1));
	}
}
