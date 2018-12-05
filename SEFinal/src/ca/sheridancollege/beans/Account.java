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
//These named queries are used for the select queries in the DAO
@NamedQuery(name = "Account.display", query = "from Account where accountid =:accountid")
public class Account implements Serializable{
	//Database Rows and Variable Declaration
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "location")
	private String location;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "accountid")
	private int accountid;
	//Constructor for Account without ID because id is a generated value
	public Account( String pass, String name, String location, int accountID) {
		accountid = accountID;
		this.location = location;
		username = name;
		password = pass;
	}
	
}
