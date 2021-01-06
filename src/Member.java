public class Member {
private String email; 
private String username; 
private String password; 

public Member() {
	super(); 
}

public Member(String email, String username, String password) { 
    super();
    this.email = email;
    this.username = username; 
    this.password = password; 
}

public Member(String email, String username) {
    super();
    this.email = email; 
    this.username = username; 
}


public void setEmail(String email) { 
	this.email = email; 
} 
public void setUsername(String username) {
	this.username = username; 
}
public void setPassword(String password) { 
	this.password = password; 
}

public String getEmail() { 
	return email; 
}
public String getUsername() { 
	return username; 
}
public String getPassword() { 
	return password;
}

}

