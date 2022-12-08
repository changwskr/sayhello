package com.eplaton.xya.framwork.transfer;

import java.util.HashMap;
import java.util.Map;

public abstract class DTO implements IDTO {
	private Map dtoProperties;

	/**
	 * @see java.lang.Object#Object()
	 */
	public DTO() {
	}

	private Map getDTOProperties() {
		if (dtoProperties == null) {
			dtoProperties = new HashMap(2);
		}
		return dtoProperties;
	}

	public final void clearDTOProperty() {
		if (dtoProperties != null) {
			dtoProperties.clear();
		}
	}

	public final Object getDTOProperty(Object key) {
		if (dtoProperties == null) {
			return null;
		} else {
			return getDTOProperties().get(key);
		}
	}

	public final void putDTOProperty(Object key, Object value) {
		getDTOProperties().put(key, value);
	}
}
