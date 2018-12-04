package ca.sheridancollege.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//Lombok and Hibernate import annotations
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Getter
@Setter
@Table(name = "account")
@NamedQuery(name = "Account.login", query = "from Account where id =:id")
public class Account implements Serializable{
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "location")
	private String location;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@GeneratedValue
	@Column(name = "sequence")
	private int sequence;
	
	public Account(int accountID, String location, String name, String pass) {
		id = accountID;
		this.location = location;
		username = name;
		password = pass;
	}
	
}
