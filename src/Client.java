

import java.util.ArrayList;



import csc2a.model.IPaintable;
import csc2a.model.Rectangle;
import csc2a.model.Triangle;
import csc2a.ui.PianterCanvas;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Client extends Application{

	private PianterCanvas painterCanvas;
	public static void main(String[] args) {
		launch(args);

	}

	//BEFORE REFACTORING

@Override
	public void start(Stage primaryStage) throws Exception {
	    
		PianterCanvas painterCanvas = new PianterCanvas();
		Button button = new Button("Draw Xmas tree");
		
		button.setOnAction((ActionEvent e) ->{
			
			ArrayList<IPaintable> ipaintableObjects = new ArrayList<>();
			//IPaintable rectangle = new Rectangle(Color.GREEN, 120, 10, 50, 100);
			
			IPaintable baseTraingle = new Triangle(Color.GREEN,200,130,320,270,105,270);
			IPaintable middleTraingle = new Triangle(Color.GREEN,200,60,300,200,115,200);
			IPaintable topTraingle = new Triangle(Color.GREEN,200,10,280,130,135,130);
			//ipaintableObjects.add(rectangle);
			ipaintableObjects.add(middleTraingle);
			ipaintableObjects.add(topTraingle);
			ipaintableObjects.add(baseTraingle);
					
			painterCanvas.setIPaintableObjects(ipaintableObjects);
					
		});
		
		BorderPane root = new BorderPane();
		StackPane container = new StackPane();
		painterCanvas.widthProperty().bind(container.widthProperty());
		painterCanvas.heightProperty().bind(container.heightProperty());
		container.setPrefWidth(700);
		container.setPrefHeight(650);
		container.getChildren().add(painterCanvas);
		
		root.setTop(button);
		root.setCenter(container);

		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	
	//AFTER REFACTORING
	@Override
	public void start(Stage primaryStage) throws Exception {
	    
	    painterCanvas = new PianterCanvas();
		Button button = new Button("Draw Xmas tree");
		
		button.setOnAction((ActionEvent e) ->{
			set_values_of_objects_to_drawn();			
		});
		
		primaryStage.setScene(create_scene(button));
		primaryStage.show();	
	}
	
	private void set_values_of_objects_to_drawn()
	{
		
		//IPaintable rectangle = new Rectangle(Color.GREEN, 120, 10, 50, 100);	
		IPaintable baseTraingle = new Triangle(Color.GREEN,200,130,320,270,105,270);
		IPaintable middleTraingle = new Triangle(Color.GREEN,200,60,300,200,115,200);
		IPaintable topTraingle = new Triangle(Color.GREEN,200,10,280,130,135,130);
		//ipaintableObjects.add(rectangle);
		add_Objects_to_array(baseTraingle,middleTraingle,topTraingle);
		
	}
	
	private void add_Objects_to_array(IPaintable... shapeObjects)
	{
		ArrayList<IPaintable> ipaintableObjects = new ArrayList<>();	
		for(IPaintable object_to_add:shapeObjects)
		{
			ipaintableObjects.add(object_to_add);
		}	
		painterCanvas.setIPaintableObjects(ipaintableObjects);	
	}
	
	private StackPane set_up_layout_environment()
	{
		StackPane container = new StackPane();
		painterCanvas.widthProperty().bind(container.widthProperty());
		painterCanvas.heightProperty().bind(container.heightProperty());
		container.setPrefWidth(700);
		container.setPrefHeight(650);
		container.getChildren().add(painterCanvas);
		return container;	
	}
	
	private Scene create_scene(Button button)
	{
		BorderPane root = new BorderPane();
		StackPane container = set_up_layout_environment();	
		root.setTop(button);
		root.setCenter(container);
		return new Scene(root);		
	}

}
