package ca.sheridancollege.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

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
@NamedQuery(name = "Account.login", query = "from account where id =:id")
public class Account implements Serializable{
	@Id
	@GeneratedValue
	private int id;
	private String username;
	private String password;	

	public Account(String name, String pass) {
		this.username = name;
		this.password = pass;
	}
}
