package com.progracol.backend.apirest.generic.types;

import java.util.Properties;

import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.usertype.DynamicParameterizedType;

import com.vladmihalcea.hibernate.type.array.internal.ArraySqlTypeDescriptor;

public class BooleanArrayType extends AbstractSingleColumnStandardBasicType<Boolean[]> implements DynamicParameterizedType {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6082696769983730520L;

	public BooleanArrayType() {
		super(ArraySqlTypeDescriptor.INSTANCE, BooleanArrayTypeDescriptor.INSTANCE);
	}

	public String getName() {
		return "boolean-array";
	}

	@Override
	protected boolean registerUnderJavaType() {
		return true;
	}

	@Override
	public void setParameterValues(Properties parameters) {
		((BooleanArrayTypeDescriptor) getJavaTypeDescriptor()).setParameterValues(parameters);
	}
}
