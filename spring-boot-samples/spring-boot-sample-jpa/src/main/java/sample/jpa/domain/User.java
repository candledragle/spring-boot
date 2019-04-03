package sample.jpa.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
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
