package renderer.entity;

import java.awt.Graphics;
import renderer.entity.builder.BasicEntityBuilder;
import renderer.entity.builder.LetterBuilder;
import renderer.input.ClickType;
import renderer.input.Mouse;
import renderer.point.MyPoint;
import renderer.point.PointConverter;

public class EntityManager {
	
//	private List<IEntity> entities;
	private Entity entity;
	private int initialX, initialY;
	
	public EntityManager() {
		this.entity = new Entity();
	}
	
	public void init() {
		//entity.tetrahedrons.add(BasicEntityBuilder.createCube(200, 0, 0, 0));
//		entity.tetrahedrons.add(BasicEntityBuilder.createUV(100,30,30,50,50, 50));

//		HELLO WORLD
//		entity.tetrahedrons.add(LetterBuilder.createH(-30, 0,0));
//		entity.tetrahedrons.add(LetterBuilder.createE(-30, 40,0));
//		entity.tetrahedrons.add(LetterBuilder.createL(-30, 80,0));
//		entity.tetrahedrons.add(LetterBuilder.createL(-30, 120,0));
//		entity.tetrahedrons.add(LetterBuilder.createO(-30, 160,0));
//
//		entity.tetrahedrons.add(LetterBuilder.createW(-30, 0,-50));
//		entity.tetrahedrons.add(LetterBuilder.createO(-30, 40,-50));
//		entity.tetrahedrons.add(LetterBuilder.createR(-30, 80,-50));
//		entity.tetrahedrons.add(LetterBuilder.createL(-30, 120,-50));
//		entity.tetrahedrons.add(LetterBuilder.createO(-30, 160,-50));

		//entity.tetrahedrons.add(LetterBuilder.createLine(-30, 0,-45,160,-45));
//


//		CUBE CUBE
		for(int i = -2; i<=2;i++) {
			for(int j = -2;j<=2;j++) {
				for(int k=-2;k<=2;k++) {
					entity.tetrahedrons.add(BasicEntityBuilder.createCube(75, i*100, j*100, k*100));
				}
			}
		}

		//CIRCLE CIRCLE
//		int radius = 200;
//		int rings = 20;
//		int segments = 30;
//		double phiChange = Math.PI / (rings);
//		double thetaChange = 2 * Math.PI / segments;
//		for(double phi = phiChange, i=0; i<rings-1; phi+=phiChange,i++) {
//			for(double theta = 0, j=0; j<segments; theta+=thetaChange,j++) {
//				double x = radius * Math.cos(theta) * Math.sin(phi);
//				double y = radius * Math.sin(theta) * Math.sin(phi);
//				double z = radius * Math.cos(phi);
//				entity.tetrahedrons.add(BasicEntityBuilder.createUV(5,8,8,x,y, z));
//			}
//		}
		entity.center();
		
		
	}
	
	public void update(Mouse mouse) {
		//rotate(false, 0.3,-0.3,0.3);

		int x = mouse.getX();
		int y = mouse.getY();
		
		if(mouse.getButton() == ClickType.LeftClick) {
			int xDif = x - initialX;
			int yDif = y - initialY;

			rotate(true, 0, -yDif/2.5, -xDif/2.5);
		}

		if(mouse.isScrollingUp()) {
			PointConverter.zoomOut();
		}
		else if(mouse.isScrollingDown()) {
			PointConverter.zoomIn();
		}
		
		mouse.resetScroll();
		
		initialX = x;
		initialY = y;
	}
	
	public void render(Graphics g) {
		entity.render(g);
	}
	
	private void rotate(boolean CW, double xDegrees, double yDegrees, double zDegrees) {
		entity.rotate(CW, xDegrees, yDegrees, zDegrees);
	}



}
