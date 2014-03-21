package stonehill.edu.VolunteerTrack;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class MikeSingletonView extends WebPage {

	private Label message;
	
	MikeSingletonView(){
		message= new Label("message","This is my message to you");
		add(message);
	}
}
