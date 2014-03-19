package stonehill.edu.VolunteerTrack;

import java.io.Serializable;

public class Book implements Serializable {
	
	String title;
	String authorFirst;
	String authorLast;
	String publisher;
	int    year;
	String isbn;
	int    votes;
	
	// For serialization
	static final long serialVersionUID = 0L;
	
	public Book()
	{
		// Required to conform to java bean for XMLEncoding/XMLDecoding
	}
	
	public Book(String title, String authorFirst, String authorLast, String publisher, int year, String isbn, int votes) {
		this.title = title;
		this.authorFirst = authorFirst;
		this.authorLast = authorLast;
		this.publisher = publisher;
		this.year = year;
		this.isbn = isbn;
		this.votes = votes;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorFirst() {
		return authorFirst;
	}

	public void setAuthorFirst(String authorFirst) {
		this.authorFirst = authorFirst;
	}

	public String getAuthorLast() {
		return authorLast;
	}

	public void setAuthorLast(String authorLast) {
		this.authorLast = authorLast;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getISBN() {
		return isbn;
	}
	
	public void setISBN(String isbn) {
		this.isbn = isbn;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

}
