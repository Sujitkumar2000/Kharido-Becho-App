package dto;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Customer {
	@Id
	@GeneratedValue(generator = "idgenerator")
	@SequenceGenerator(initialValue = 6814321,allocationSize = 1,name="idgenerator",sequenceName="idgenerator")
	int Custid;
	String name;
	String email;
	long mobile;
	String password;
	String gender;
	Date dob;
	String address;
	int age;
}
