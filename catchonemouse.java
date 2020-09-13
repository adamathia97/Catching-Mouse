/*
*/
import javafx.application.Application;
import javafx.scene.Group;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.geometry.Insets;
import java.util.Random;
import javafx.scene.control.TextField;

public class catchonemouse extends Application 
{
	public void start(Stage primaryStage) throws Exception 
	{
		String startlevel;
		int score;
		Random rand = new Random();
		
		Mouse mouse = new Mouse(Color.PINK);
		
		int x = rand.nextInt((480-60)+1) + 60;
		int y  = rand.nextInt((650-25)+1)+25;
		mouse.move(x,y);
		
		Group group = mouse.getGroup();
		
		MouseAppearingEventHandler handler = new MouseAppearingEventHandler(mouse);
		group.addEventHandler(MouseEvent.MOUSE_CLICKED , handler);
		
		Insets insets = new Insets(20);
		Label l = new Label();
		l.setFont(Font.font(24));
		l.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getEventType().equals(MouseEvent.MOUSE_CLICKED))
				{
					l.setText("Score: ");
				}
			}
		});
		
		Label k = new Label();
		k.setFont(Font.font(24));
		k.setText("Level");
		
		TextField field = new TextField();
		field.setPromptText("Start Level");
		startlevel = field.getText();
		
		
		Pane p = new Pane(group);
		p.setMinHeight(800);
		p.setMinWidth(600);
		
		BorderPane pane = new BorderPane();
		pane.setTop(field);
		BorderPane.setMargin(l , insets);
		pane.setBottom(k);
		pane.setCenter(l);
		HBox hbox = new HBox(10,p,pane);
		hbox.setMinWidth(1000);
		hbox.setMinHeight(800);
		hbox.setPadding(new Insets(20));
		
		Scene scene = new Scene(hbox);
		
		scene.setFill(Color.WHITE);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
