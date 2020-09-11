package com.progracol.backend.apirest.generic.types;

import com.vladmihalcea.hibernate.type.array.internal.AbstractArrayTypeDescriptor;

public class BooleanArrayTypeDescriptor extends AbstractArrayTypeDescriptor<Boolean[]> {

	private static final long serialVersionUID = -7603353027057207756L;
	public static final BooleanArrayTypeDescriptor INSTANCE = new BooleanArrayTypeDescriptor();

	public BooleanArrayTypeDescriptor() {
		super(Boolean[].class);
	}

	@Override
	protected String getSqlArrayType() {
		return "boolean";
	}
}