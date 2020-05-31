package ui;

import java.util.ArrayList;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import model.IPaintable;
import model.TreePaintVisitor;

public class PianterCanvas extends Canvas{
	
	private GraphicsContext graphicsContext = null;
	private ArrayList<IPaintable> ipaintableObjects = null;
	
	private TreePaintVisitor treePaintVisitor = null;
	
	public PianterCanvas()
	{
		treePaintVisitor = new TreePaintVisitor();
		
	}
	
	
	public void setIPaintableObjects( ArrayList<IPaintable> ipaintableObjects)
	{
		this.ipaintableObjects = ipaintableObjects;
		drawCanvas();
	}
	
	public void drawCanvas()
	{
		
		graphicsContext = getGraphicsContext2D();
		treePaintVisitor.setGraphicsContext(graphicsContext);
		
		for(IPaintable ipaintable : ipaintableObjects)
		{
			ipaintable.accept(treePaintVisitor);
		}
		
		
	}
	
	
	

}
