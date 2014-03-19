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


public class LoginViewPrototype extends WebPage 
{
	private int count;
	private Model countModel;
	
	private TextField userid;
	private TextField password;
	private Label message;
	private Label attempts;

	public LoginViewPrototype()
	{
		// Model Stuff
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
		userid    = new TextField("userid",new Model(""));
		password  = new PasswordTextField("password",new Model(""));
		message = new Label("message","");
		attempts = new Label("attempts",countModel);
		Button submit = new Button("submit");
		
		// Controller Stuff
		Form form = new Form("form")
		{
			@Override
			public void onSubmit()
			{
				String valueUserId   = (String) userid.getDefaultModelObject();
				String valuePassword = (String) userid.getDefaultModelObject();
								
				if (valueUserId.equals("bdugan") && valuePassword.equals("csrocks55"))
				{
					message.setDefaultModelObject("success");
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
