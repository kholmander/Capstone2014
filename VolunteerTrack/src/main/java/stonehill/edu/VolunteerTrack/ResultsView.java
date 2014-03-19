package stonehill.edu.VolunteerTrack;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.RestartResponseAtInterceptPageException;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;


public class ResultsView extends WebPage 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int total=0;
	private Model totalModel;
	
	public ResultsView()
	{
		// Authentication Stuff
		if (!CustomSession.get().isAuthenticated())
		{
			// See SurveyView.java for details on this exception
			throw new RestartResponseAtInterceptPageException(LoginView.class);
		}
		
		// Model Stuff
		total = 0;
		totalModel = new Model()
		{
			@Override
			public Serializable getObject()
			{
				return Integer.toString(total);
			}
		};
		
		SurveyDao surveyDao = new SurveyDao();
		ArrayList<Object> booksModel = surveyDao.selectAll();
		
		// View Stuff
		
		// NOTE: Sad, sad, sad... why a renderer can't be used here!
		// This links the list view (also called a repeater) to an anchor 
		// on the html page in our case it's:
		//
		//      <ul wicket:id="books">
		//
		ListView booksView = new ListView("books", (List) booksModel)
		{
			@Override
			// This links each item in the list to the html that will repeat over and over
			// in our case it's:
			//
			//      <li><span wicket:id="title"></span><span wicket:id="votes"></span></li>
			//
			protected void populateItem(ListItem item)
			{
				// Model
				Book book = (Book) item.getModelObject();
				total = total + book.getVotes();
				
				//View
				item.add(new Label("title",book.getTitle()));
				item.add(new Label("votes",Integer.toString(book.getVotes())));
			}
		};
		
		Label  totalView = new Label("total",totalModel);
		
		// Controller Stuff

		// Add components to component tree
		add(booksView);
		add(totalView);
	}
}
