import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class LabelChangingEventHandler implements EventHandler<MouseEvent>
{
	private Label l;
	private int score;
	
	public LabelChangingEventHandler( Label l)
	{
		this.l = l;
	}
	
	public void handle(MouseEvent event)
	{
		if(event.getEventType().equals(MouseEvent.MOUSE_CLICKED))
		{
			score++;
			l.setText("score : " + score);
		}
	}
}