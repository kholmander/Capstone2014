package stonehill.edu.VolunteerTrack;


import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.validator.RangeValidator;
import org.apache.wicket.validation.validator.StringValidator;

public class DemosView extends WebPage {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DemosView()
	{
		// Image (no code)
		
		// Validation
		// NOTE: Deprecation warning for NumberValidator is a known bug!}
		Form form = new Form("form");
		form.add(new TextField("rangevalidator", new Model(), Integer.class).add(new RangeValidator<Integer>(1, 10)));
		form.add(new TextField("required").setRequired(true));
		form.add(new PasswordTextField("exactlengthvalidator").add(StringValidator.exactLength(8)));
		form.add(new Button("submit"));
		add(form);
		
		// Navigation (no code)
		
		// Feedback
		add(new FeedbackPanel("feedback"));
		
	}

}
