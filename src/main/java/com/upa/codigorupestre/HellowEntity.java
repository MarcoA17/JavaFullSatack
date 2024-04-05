package com.upa.codigorupestre;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "helloword")
public class HellowEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Integer age;
	private String msj;

	public HellowEntity() {
		// TODO Auto-generated constructor stub
	}

	public HellowEntity(Long id, String name, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @return the msj
	 */
	public String getMsj() {
		return msj;
	}

	/**
	 * @param msj the msj to set
	 */
	public void setMsj(String msj) {
		this.msj = msj;
	}

	@Override
	public String toString() {
		return "HellowEntity [id=" + id + ", name=" + name + ", age=" + age + ", msj=" + msj + "]";
	}

}
