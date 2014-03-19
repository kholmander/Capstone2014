package stonehill.edu.VolunteerTrack;

import java.io.Serializable;

public class User implements Serializable {
	private String userId;
	private String password;
	
	// For serialization
	static final long serialVersionUID = 9L;
	
	public User()
	{
		setUserId("");
		setPassword("");
	}
	
	public User(String userIdValue, String passwordValue)
	{
		setUserId(userIdValue);
		setPassword(passwordValue);
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
