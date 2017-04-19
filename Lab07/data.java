/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class data {
	@Id
	private int id;
	private String firstName, lastName;

public int getId() {return id;}
public void setId(int id) {this.id = id;}

public String getFirstName() {return firstName;}
public void setFirstName(String firstName) {this.firstName = firstName;}

public String getLastName() {return lastName;}
public void setLastName(String lastName) {this.lastName = lastName;}
}

