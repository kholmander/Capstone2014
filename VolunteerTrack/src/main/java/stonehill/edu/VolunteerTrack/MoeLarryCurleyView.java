package stonehill.edu.VolunteerTrack;

import java.io.Serializable;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class MoeLarryCurleyView extends WebPage 
{
	private Label message;

	public MoeLarryCurleyView()
	{
		message = new Label("message","All I want is a ship and a star to sail her by...");
		add(message);
	}
}
