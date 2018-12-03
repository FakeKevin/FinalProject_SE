package ca.sheridancollege.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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

@Table(name = "user")

//This named query is used for the queryAccount method in the DAO
@NamedQueries({ @NamedQuery(name = "User.login", query = "from User where email = :email and password = :password"), 
				@NamedQuery(name = "User.exists",query = "from User where email = :email")
})

public class User implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "firstname")
	private String firstName;
	@Column(name = "lastname")
	private String lastName;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String loginPassword;

	public User(String fname, String lname, String email, String password) {
		this.firstName = fname;
		this.lastName = lname;
		this.email = email;
		this.loginPassword = password;
	}

	public User(String email, String password) {
		this.email = email;
		this.loginPassword = password;
	}

	// Users can have multiple accounts
	@OneToMany
	private List<Account> accountList = new ArrayList<Account>();

	public boolean login(List<User> user) {
		if (!user.isEmpty()) {
			user.clear();
			return true;
		} else {
			user.clear();
			return false;
		}
	}
}
