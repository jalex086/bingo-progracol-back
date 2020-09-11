package com.progracol.backend.apirest.generic.types;

import java.util.Properties;

import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.usertype.DynamicParameterizedType;

import com.vladmihalcea.hibernate.type.array.internal.ArraySqlTypeDescriptor;

public class IntArrayType extends AbstractSingleColumnStandardBasicType<Integer[]> implements DynamicParameterizedType {

	private static final long serialVersionUID = 805024045173160147L;

	public IntArrayType() {
		super(ArraySqlTypeDescriptor.INSTANCE, IntArrayTypeDescriptor.INSTANCE);
	}

	public String getName() {
		return "int-array";
	}

	@Override
	protected boolean registerUnderJavaType() {
		return true;
	}

	@Override
	public void setParameterValues(Properties parameters) {
		((IntArrayTypeDescriptor) getJavaTypeDescriptor()).setParameterValues(parameters);
	}
}
