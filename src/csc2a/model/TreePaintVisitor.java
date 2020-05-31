package csc2a.model;

import csc2a.model.Rectangle;
import csc2a.model.Triangle;
import javafx.scene.canvas.GraphicsContext;

public class TreePaintVisitor implements IPaintVisitor{

	
	private GraphicsContext graphicsContext = null;
	
	public void setGraphicsContext(GraphicsContext graphicsContext)
	{
		this.graphicsContext = graphicsContext;
	}
	
	public void paint(Rectangle rectangle) {
		graphicsContext.setFill(rectangle.getColor());
		graphicsContext.fillRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
		
	}

	
	public void paint(Triangle triangle) {
		
		graphicsContext.setFill(triangle.getColor());
		graphicsContext.fillPolygon(triangle.getXCoords(),triangle.getYCoords(),3);
	}

}
