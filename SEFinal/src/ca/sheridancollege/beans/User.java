package ca.sheridancollege.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Getter
@Setter
//This named query is used for the queryAccount method in the DAO
@NamedQuery(name = "User.login", query = "from user where email = :email and password = :password")
public class User implements Serializable {
	
	@Id
	@GeneratedValue
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String loginPassword; 
	
	public User(String fname, String lname, String email, String password){
		this.firstName = fname;
		this.lastName = lname;
		this.email = email;
		this.loginPassword = password;
	}
	//Users can have multiple accounts
	@OneToMany
	private List<Account> accountList = new ArrayList<Account>();
	
public boolean login(List<User> user) {
	if(user.size() == 1) {
		user.removeAll(user);
		return true; 
	}
	else {
		user.remove(user);
		return false;
	}
}



}


