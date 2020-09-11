package com.progracol.backend.apirest.generic.types;

import com.vladmihalcea.hibernate.type.array.internal.AbstractArrayTypeDescriptor;

public class IntArrayTypeDescriptor extends AbstractArrayTypeDescriptor<Integer[]> {

	private static final long serialVersionUID = -7603353027057207756L;
	public static final IntArrayTypeDescriptor INSTANCE = new IntArrayTypeDescriptor();

	public IntArrayTypeDescriptor() {
		super(Integer[].class);
	}

	@Override
	protected String getSqlArrayType() {
		return "integer";
	}
}