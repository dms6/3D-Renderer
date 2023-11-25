package renderer.entity;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import renderer.point.MyPoint;
import renderer.shapes.MyPolygon;
import renderer.shapes.Tetrahedron;

public class Entity implements IEntity{
	List<Tetrahedron> tetrahedrons;
	public static double globalMinX =0, globalMaxX =0, globalMinY =0, globalMaxY =0, globalMinZ =0, globalMaxZ =0;
	
	public Entity() {
		tetrahedrons = new ArrayList<>();
	}

	public Entity(List<Tetrahedron> tetras) {
		this.tetrahedrons = tetras;
		
	}

	@Override
	public void render(Graphics g) {
		Tetrahedron.sortTetrahedrons(tetrahedrons);
		for(Tetrahedron tetra : tetrahedrons) {
			tetra.render(g);
		}
	}

	@Override
	public void rotate(boolean CW, double xDegrees, double yDegrees, double zDegrees) {
		Tetrahedron.sortTetrahedrons(tetrahedrons);
		for(Tetrahedron tetra : tetrahedrons) {
			tetra.rotate(CW,xDegrees,yDegrees,zDegrees);
		}
	}

	public void center() {
		
		for(Tetrahedron tetra : tetrahedrons) {
			for(MyPolygon poly : tetra.polygons) {
				for(MyPoint p : poly.points) {
					globalMinX = Math.min(p.x, globalMinX);
					globalMaxX = Math.max(p.x, globalMaxX);
					
					globalMinY = Math.min(p.y, globalMinY);
					globalMaxY = Math.max(p.y, globalMaxY);
					
					globalMinZ = Math.min(p.z, globalMinZ);
					globalMaxZ = Math.max(p.z, globalMaxZ);
					
				}
			}
		}
		//System.out.println(minX+", "+maxX+", "+minY+", "+maxY+", "+minZ+", "+maxZ);
		double cX = -(globalMaxX + globalMinX)/2;
		double cY = -(globalMaxY + globalMinY)/2;
		double cZ = -(globalMaxZ + globalMinZ)/2;
		for(Tetrahedron tetra : tetrahedrons) {
			for(MyPolygon poly : tetra.polygons) {
				for(MyPoint p : poly.points) {
					p.x+=cX;
					p.y+=cY;
					p.z+=cZ;
				}
			}
		}
		
	}
	
	
	
	

}
