package com.francetelecom.yoyo.model;

//import javax.xml.bind.annotation.XmlRootElement;

/**
 * Data Transfer Object designing a Market
 * 
 * @author Clara
 * 
 */
//@XmlRootElement(name = "marketBean")
public class MarketBean extends GenericBean {

	private static final long serialVersionUID = 7611886917596403950L;

	/**
	 * Optional description
	 */
	private String description;
	
	//
	// This empty constructor is needed by JAXB
	// used is REST exchange with JSON or XML format.
	//
	public MarketBean() {
		super();
	}
	
	/**
	 * full constructor
	 * 
	 * @param id
	 *            technical id
	 * @param name
	 *            market name
	 * @param description
	 *            description
	 */
	public MarketBean(Integer id, String name, String description) {
		super(id, name);
		this.description = description;
	}

	/**
	 * constructor without id
	 * 
	 * @param name
	 *            market name
	 * @param description
	 *            description
	 */
	public MarketBean(String name, String description) {
		super(name);
		this.description = description;
	}

	/**
	 * readable market content
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append(", description=");
		sb.append(description);

		return sb.toString();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
