package stonehill.edu.VolunteerTrack;

public class SurveyDao extends Dao {
	
	SurveyDao()
	{
		path = this.getClass().getClassLoader().getResource("survey.xml").getPath().replace("%20"," "); 
		open();
	}

	
	@Override
	protected int indexOf(Object value) 
	{
		Book book = (Book) value;
		
		// Iterate through book looking for match
		for (int i=0; i<list.size(); i++)
		{
			// Locate book
			if (book.getISBN().equals(((Book)list.get(i)).getISBN()))
			{	
				return i;
			}
		}
		
		// Invalid book
		return -1;
	}
	
	public Object selectByISBN(String isbn) 
	{	
		Book result = null;
		
		Book proxy = new Book("","", "", "", 0, isbn, 0);
		
		if (indexOf(proxy) >= 0)
		{
			result = (Book) list.get(indexOf(proxy));
		}
		return result;
	}
}
