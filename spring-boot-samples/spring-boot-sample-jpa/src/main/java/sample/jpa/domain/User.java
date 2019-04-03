package sample.jpa.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class User {

	@Id
	private Integer id;
	@Column
	private Integer age;
	@Column
	private String name;
	@Column
	private String address;
	@Column
	private String city;
}
