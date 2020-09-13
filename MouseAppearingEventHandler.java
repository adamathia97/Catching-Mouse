import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import java.util.Random;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class MouseAppearingEventHandler implements EventHandler<MouseEvent>
{
	private Mouse mouse;
	private Label l;
	public  int score;
	
	public MouseAppearingEventHandler( Mouse mouse)
	{
		this.mouse = mouse;
		this.l = l;
	}
	
	public void handle(MouseEvent event)
	{
		Random rand = new Random();
		if(event.getEventType().equals(MouseEvent.MOUSE_CLICKED))
		{
			int x = rand.nextInt((450-60)+1) + 60;
			int y  = rand.nextInt((650-25)+1)+25;
			
			mouse.move(x,y);
			score++;
			l.setText("score : " + score);
		}
	}
}