package renderer.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import renderer.entity.Entity;
import renderer.point.MyPoint;

public class Tetrahedron {
	
	public MyPolygon[] polygons;

	
	public Tetrahedron(MyPolygon... polygons) {
		this.polygons = polygons;
		this.sortPolygons();

	}
	
	public void render(Graphics g) {
		for(MyPolygon poly : this.polygons) {
			poly.render(g);
		}
	}
	
	public void rotate(boolean CW, double xDegrees, double yDegrees, double zDegrees){
		for(MyPolygon poly : this.polygons) {
			poly.rotate(CW, xDegrees, yDegrees, zDegrees );
		}
		this.sortPolygons();
	}
	private  void sortPolygons() {
		MyPolygon.sortPolygons(this.polygons);
	}

	
	public double getAverageX(){
		double sum = 0;
		for(MyPolygon polygon : polygons) {
			sum+=polygon.getAverageX();
		}
		return sum/polygons.length;
	}
	public static List<Tetrahedron> sortTetrahedrons(List<Tetrahedron> tetrahedrons) {
		
		tetrahedrons.sort(new Comparator<Tetrahedron>() {

			@Override
			public int compare(Tetrahedron t1, Tetrahedron t2) {
				float a = (float) t1.getAverageX();
				float b = (float) t2.getAverageX();
				if(a==b) return 0;
				return (a - b > 0 ? 1 : -1);

			}
		});
		
		return tetrahedrons;
	}
	public static Tetrahedron extrude(double depth, MyPolygon poly) {
		int len = poly.points.length;
		MyPolygon[] tetra = new MyPolygon[len+2];
		MyPoint[] back = new MyPoint[len];
		for(int i = 0; i< len; i++) {
			MyPoint p = poly.points[i];
			back[i] = new MyPoint(p.x-depth, p.y, p.z);
		}
		tetra[len] = poly; tetra[len+1] = new MyPolygon(back);
		for(int i = 0; i<tetra.length-2; i++) {
			tetra[i] = new MyPolygon(poly.points[i], poly.points[(i+1)%len], back[(i+1)%len], back[i]);
		}
		return new Tetrahedron(tetra);
		
	}
	
	

}
