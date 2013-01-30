package com.francetelecom.yoyo.model.persistent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * persistent market model. ORM mapping is done with JPA annotations
 * 
 * @author Clara
 */
@Entity
public class Market extends GenericEntity {

	private static final long serialVersionUID = -2812544388912831191L;

	/**
	 * Id with generated value
	 */
	@Id
	// additional specific mapping is defined in orm_*.xml.
	// with postgresql or mysql, the easiest is to use
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDMAR", nullable = false)
	private int id;

	/**
	 * Description
	 */
	@Column(length = 2000)
	private String description;

	/**
	 * Empty constructor
	 */
	public Market() {
		super();
	}

	/**
	 * Constructeur
	 * 
	 * @param name
	 *            Market name
	 * @param description
	 *            Market description
	 */
	public Market(String name, String description) {

		this.name = name;
		this.description = description;

	}

	/**
	 * @return Returns the id.
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            The id to set.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return Returns the description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            The description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}