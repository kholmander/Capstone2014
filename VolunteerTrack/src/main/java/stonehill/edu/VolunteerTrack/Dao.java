package stonehill.edu.VolunteerTrack;

import java.beans.XMLEncoder;
import java.beans.XMLDecoder;

import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;

public abstract class Dao {
	
	XMLEncoder encoder;
	XMLDecoder decoder;
	ArrayList list;
	
	String path;
	HttpServlet servlet;
	
	Dao()
	{
	}
	
	Dao(HttpServlet servletValue)
	{
		servlet = servletValue;
	}
	
	protected void open()
	{	
  		// Get all objects
  		list = new ArrayList();
  		
//		Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
  		
	    try {
	    	
	    	decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(path)));
	    	
	  		try
	  		{
	  			while (true)
	  			{
	  				list.add(decoder.readObject());
	  			}
	  			
	  		}
	  		catch (ArrayIndexOutOfBoundsException e)
	  		{
	  			System.out.println("End of object stream...");
	  			decoder.close();
	  		}
	    } 
	    catch (Exception e)
	    {
	    	e.printStackTrace();
	    }
	}
	
	public void close()
	{
	//	Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
		
		try {
			
	    	  encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(path)));
	    	  
	    	  for (int i=0; i<list.size(); i++)
	    	  {
	    		  encoder.writeObject(list.get(i));
	    		  encoder.flush();
	    	  }
	    	  
	    	  encoder.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void delete(Object value) 
	{
		list.remove(indexOf(value));
	}
	
	public void insert(Object value) {
		
		list.add(value);
	}

	public ArrayList<Object> selectAll() 
	{	
		return (ArrayList<Object>) list;
	}

	public void update(Object value) {

		list.set(indexOf(value), value);
	}
	
	protected abstract int indexOf(Object value);
}
