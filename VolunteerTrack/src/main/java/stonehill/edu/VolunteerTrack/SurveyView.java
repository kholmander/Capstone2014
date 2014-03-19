package stonehill.edu.VolunteerTrack;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.RestartResponseAtInterceptPageException;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RadioChoice;
import org.apache.wicket.model.PropertyModel;

public class SurveyView extends WebPage 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Book book;

	public SurveyView()
	{
		// Authentication Stuff
		if (!CustomSession.get().isAuthenticated())
		{
			// I wanted to do setRedirect() here, but that didn't work.  It went to the login
			// page, but the login didn't work.  Not sure why.  Also... there is a
			// there is a redirectToInterceptPage(), but I had to pass in an object, not a
			// class to that method... so I'm using this instead.
			throw new RestartResponseAtInterceptPageException(LoginView.class);
		}
		
		// Model Stuff
		SurveyDao surveyDao = new SurveyDao();
		ArrayList<Object> booksModel = surveyDao.selectAll();
		
		// View Stuff
		
		// NOTE: This option will display object references since the Book's toString() method hasn't been
		// customized.
		//RadioChoice booksView = new RadioChoice("books",new PropertyModel(this,"book"), (List) booksModel);

		// NOTE: This option will display the choices properly... title only
		ChoiceRenderer renderer = new ChoiceRenderer("title");
		RadioChoice booksView = new RadioChoice("books",new PropertyModel(this,"book"), (List) booksModel, renderer);
		
		Button submit = new Button("submit");
		
		// Controller Stuff
		Form form = new Form("form")
		{
			@Override
			public void onSubmit()
			{
			   book.setVotes(book.getVotes()+1);
			   SurveyDao surveyDao = new SurveyDao();
			   surveyDao.update(book);
			   surveyDao.close();
			   
			   this.setResponsePage(ResultsView.class);
			}
		};

		// Add components to component tree
		form.add(booksView);
		form.add(submit);
		add(form);
	}
}
