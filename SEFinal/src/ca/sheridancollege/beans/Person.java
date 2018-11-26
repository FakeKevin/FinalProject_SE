package ca.sheridancollege.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
public class Person implements Serializable {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String email;

	
	public Person(String name, String email){
		this.name = name;
		this.email = email;
	}
}


