package com.aavn.rs.domain;

public enum Gender {
	MALE((short)1, "Male"), FEMALE((short)0, "Female");
	private short id;
	private String label;

	private Gender(short id, String label) {
		this.id = id;
		this.label = label;
	}

	public short getId() {
		return id;
	}
	
	public String getLabel() {
		return label;
	}
	
	public static String getLabel(Integer id) {
		if (id == null)
			return "";
		switch (id) {
		case 0:
			return Gender.FEMALE.getLabel();
		case 1:
			return Gender.MALE.getLabel();
		default:
			return "";
		}
	}
}
