package com.francetelecom.yoyo.model.persistent;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

/**
 * Generic Class for whole persistent model. Manage optimistic lock with version
 * field, name field and toString() method
 * 
 * @author Clara
 */
@EntityListeners(EntityLastModifiedSetter.class)
@MappedSuperclass
public abstract class GenericEntity implements Serializable {

	private static final long serialVersionUID = -8116869590332449954L;

	@Transient
	private SimpleDateFormat sdf;

	/**
	 * version for optimistic lock
	 */
	@Version
	protected int version;

	/**
	 * name
	 */
	@Column(unique = true, length = 30)
	protected String name;
	
	/**
	 * last modified date : this field is updated by the EntityLastModifiedSetter class)
	 */
	@Temporal(TemporalType.TIMESTAMP)
	protected Date lastModified;


	/*
	 * The name should be unique in database
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (obj.getClass() != this.getClass()))
			return false;
		// object must be tested at this point
		GenericEntity test = (GenericEntity) obj;
		return name.equals(test.name);
	}

	/*
	 * name is unique
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return name.hashCode();
	}

	/**
	 * introspect all String/Date/int/float/double/boolean getters
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(500);
		String className = getClass().getName();
		sb.append(className.substring(className.lastIndexOf('.') + 1));
		sb.append(" - ");
		boolean first = true;
		Method[] m = getClass().getMethods();
		for (int i = 0; i < m.length; i++) {
			String name = m[i].getName();
			if (name.startsWith("get")
					&& (String.class.equals(m[i].getReturnType())
							|| Date.class.equals(m[i].getReturnType())
							|| float.class.equals(m[i].getReturnType())
							|| double.class.equals(m[i].getReturnType())
							|| boolean.class.equals(m[i].getReturnType()) || int.class
							.equals(m[i].getReturnType()))) {
				if (!first) {
					sb.append(", ");
				}
				first = false;
				sb.append(name.substring(3));
				sb.append(": ");
				try {
					Object result = m[i].invoke(this, new Object[0]);
					if (result instanceof Date) {
						if (sdf == null) {
							sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
						}
						result = sdf.format(result);
					}
					sb.append(result);
				} catch (IllegalAccessException e) {
					sb.append("(IllegalAccessException)");
				} catch (InvocationTargetException e) {
					// if m[i].getParameterTypes().length==0, ie getter with
					// argument
					sb.append("(InvocationTargetException)");
				}
			}
		}
		return sb.toString();
	}

	/* getter/setter */

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Date getLastModified() {
		return lastModified;
	}

}
