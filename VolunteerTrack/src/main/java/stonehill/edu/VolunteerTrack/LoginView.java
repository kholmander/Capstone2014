package stonehill.edu.VolunteerTrack;

import java.io.Serializable;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;


public class LoginView extends WebPage 
{
	private User user;
	private int count;
	private Model countModel;
	
	private TextField userid;
	private TextField password;
	private Label message;
	private Label attempts;

	public LoginView()
	{
		// Model Stuff
		user = new User();
		count = 0;
		countModel = new Model()
		{
			@Override
			public Serializable getObject()
			{
				return Integer.toBinaryString(count);
			}
		};
		
		// View Stuff
		userid    = new TextField("userid", new PropertyModel(user,"userId"));
		password  = new PasswordTextField("password", new PropertyModel(user,"password"));
		message = new Label("message","");
		attempts = new Label("attempts",countModel);
		Button submit = new Button("submit");
		
		// Controller Stuff
		Form form = new Form("form")
		{
			@Override
			public void onSubmit()
			{
				// Note: Read Dao comment to see how to access files using Wicket
				UserDao userDao = new UserDao();
				User lookupUser = (User) userDao.selectByUserId(user.getUserId());
								
				if ((lookupUser != null) && (lookupUser.getPassword().equals(user.getPassword())))
				{
					message.setDefaultModelObject("success");
					this.setResponsePage(SurveyView.class);
					
					// Get the Session object, then set the user in our custom session object.
					// We'll query the session object in other components to make sure
					// that the user object has been set via the isAuthenticated() method.
					// This will prevent unauthorized access to other web pages.
					CustomSession.get().setUser(lookupUser);
				}
				else
				{
					message.setDefaultModelObject("failure");
					count++;
				}
			}
		};

		// Add components to component tree
		form.add(userid);
		form.add(password);
		form.add(submit);
		add(form);
		add(message);
		add(attempts);
	}
}
