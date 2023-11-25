package renderer.entity.builder;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import renderer.entity.Entity;
import renderer.entity.IEntity;
import renderer.point.MyPoint;
import renderer.shapes.MyPolygon;
import renderer.shapes.Tetrahedron;

public class BasicEntityBuilder {

	public static Tetrahedron createCube(double size, double centerX, double centerY, double centerZ) {
		
		MyPoint p1 = new MyPoint(centerX+size/2, centerY-size/2, centerZ-size/2);
		MyPoint p2 = new MyPoint(centerX+size/2, centerY+size/2, centerZ-size/2);
		MyPoint p3 = new MyPoint(centerX+size/2, centerY+size/2, centerZ+size/2);
		MyPoint p4 = new MyPoint(centerX+size/2, centerY-size/2, centerZ+size/2);
		MyPoint p5 = new MyPoint(centerX-size/2, centerY-size/2, centerZ-size/2);
		MyPoint p6 = new MyPoint(centerX-size/2, centerY+size/2, centerZ-size/2);
		MyPoint p7 = new MyPoint(centerX-size/2, centerY+size/2, centerZ+size/2);
		MyPoint p8 = new MyPoint(centerX-size/2, centerY-size/2, centerZ+size/2);

		Tetrahedron tetra = new Tetrahedron(
				new MyPolygon(p5,p6,p7,p8),
				new MyPolygon(p1,p2,p3,p4),
				new MyPolygon(p1,p2,p6,p5),
				new MyPolygon(p1,p5,p8,p4),
				new MyPolygon(p2,p6,p7,p3),
				new MyPolygon(p4,p3,p7,p8));
		return tetra;
		
	}
	
	public static Tetrahedron createUV(double radius, int rings, int segments, double centerX, double centerY, double centerZ) {
		MyPoint[][] points= new MyPoint[rings-1][segments];
		ArrayList<MyPolygon> polygons = new ArrayList<>();
		MyPoint top = new MyPoint(centerX, centerY, centerZ+radius);
		MyPoint bottom = new MyPoint(centerX,centerY,centerZ-radius);
				
		double phiChange = Math.PI / (rings);
		double thetaChange = 2 * Math.PI / segments;
		
		for(double phi = phiChange, i=0; i<rings-1; phi+=phiChange,i++) {
			for(double theta = 0, j=0; j<segments; theta+=thetaChange,j++) {
				double x = radius * Math.cos(theta) * Math.sin(phi)+centerX;
				double y = radius * Math.sin(theta) * Math.sin(phi)+centerY;
				double z = radius * Math.cos(phi)+centerZ;
				points[(int) i][(int)j]=new MyPoint(x,y,z);
			}
		}
		for(int i = 0; i<rings-2; i++) {
			for(int j = 0; j<segments; j++) {
				
				polygons.add(new MyPolygon(points[i][j], points[i][(j+1)%segments], points[i+1][(j+1)%segments],points[i+1][j]));
			}
		}
		//connect top
		for(int j = 0; j<segments;j++) {
			polygons.add(new MyPolygon(points[0][j], points[0][(j+1)%segments], top));
			polygons.add(new MyPolygon(points[points.length-1][j],points[points.length-1][(j+1)%segments], bottom));
		}
		
		Tetrahedron tetra = new Tetrahedron(polygons.toArray(new MyPolygon[0]));
		return tetra;
		//return new Entity(new ArrayList<Tetrahedron>(Arrays.asList(tetra)));
	}
	
	public static Tetrahedron createICO(double radius, int res, double centerX, double centerY, double centerZ) {
		ArrayList<MyPolygon> polygons = new ArrayList<>();
		/*
		int res = 2;
		double radius = 100;
		double phi = (1.57-Math.atan2(1,2));
		double thetaChange = Math.PI/5;
		for(double i = 0;i<res;i++) {
			
			for(double k = 0;k<Math.pow(2,res-1);k++) {
				double tp = (k+1)*phi/(i+1);
				for(double j = 0,theta = 0;j<10*i;j++,theta+=thetaChange) {
					double x = radius * Math.cos(theta) *Math.sin(tp);
					double y = radius * Math.sin(theta) *Math.sin(tp);
					double z = radius * Math.cos(tp);
					if(j%2==0) z*=-1;
					if(k%2==0)z*=-1;
					entity.tetrahedrons.add(BasicEntityBuilder.createUV(5,10,5,x,y,z));
					//System.out.println(x+", "+y+", "+z+"phi: " +phi + " theta: "+theta);
				}
			}
		}
		entity.tetrahedrons.add(BasicEntityBuilder.createUV(5,10,5,0,0,radius));
		entity.tetrahedrons.add(BasicEntityBuilder.createUV(5,10,5,0,0,-radius));
		
		*/
		
		
		return null;
	}
	
	


}
