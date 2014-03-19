package stonehill.edu.VolunteerTrack;

import org.apache.log4j.*;



public class UserDao extends Dao {

	// Example of how to setup a logger... google log4j
	Logger logger = Logger.getLogger(UserDao.class);
	
	UserDao()
	{
		// *** IMPORTANT READ THIS ***
		// This is a superior way to access the users.xml file.  The xml file is treated as a resource.
		// A resource can be any kind of file, provided it is stored in the resources directory associated
		// with the class that is using the resource.  All of the java code that you write for Wicket
		// is stored in the "src/main/java" directory.  All of the resources for this java code are stored
		// in the "src/main/resources" directory.  When the project is built, the class files get copied
		// to the "/WEB-INF/classes/edu/stonehill" directory and the resources get copied to the
		// "/WEB-INF/classes" directory.  The getResource() method knows how to find the files in this
		// directory.
		//
		// *** IMPORTANT READ THIS TOO ***
		// The file path returned from getPath() contains webified character substitutes for non-standard
		// characters like "%20" instead of " " that can appear in a file path.  We need to replace the 
		// substitute with the actual character.
		path = this.getClass().getClassLoader().getResource("users.xml").getPath().replace("%20"," ");
		
		// Example of how use a logger... you can configure what gets printed out using the
		// log4j.properties file
		logger.info("The path is: " + path);
		
		open();
	}

	@Override
	protected int indexOf(Object value) 
	{
		User user = (User) value;
		
		// Iterate through users looking for match
		for (int i=0; i<list.size(); i++)
		{		
			// Locate user
			if (user.getUserId().equals(((User)list.get(i)).getUserId()))
			{
				return i;
			}
		}
		
		// Invalid user
		return -1;
	}
	
	public Object selectByUserId(String value) 
	{	
		User result = null;
		
		User proxy = new User(value,"");
		
		if (indexOf(proxy) >= 0)
		{
			result = (User) list.get(indexOf(proxy));
		}
		return result;
	}
}
