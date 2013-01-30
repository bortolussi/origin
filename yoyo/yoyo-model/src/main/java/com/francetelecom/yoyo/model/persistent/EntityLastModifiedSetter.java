package com.francetelecom.yoyo.model.persistent;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * GenericEntity Class Listener. Sets the lastModified field upon persist and update operations
 * 
 * @author Clara
 */
public class EntityLastModifiedSetter {
	

	@PrePersist
	public void beforeNewEntity(GenericEntity genericEntity) {
		
		genericEntity.lastModified = new Date();
	}

	@PreUpdate
	public void beforeUpdateEntity(GenericEntity genericEntity) {
		
		genericEntity.lastModified = new Date();
	}

}
