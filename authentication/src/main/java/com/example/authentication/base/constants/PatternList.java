package com.example.authentication.base.constants;

public class PatternList {
	public final static String USERNAME = "^[A-Za-z0-9_]{4,30}$";
	public final static String PASSWORD = "^[A-Za-z0-9_!@#$&*]{4,30}$";
	public final static String ROLE = "^ROLE_[A-Z_]{4,30}$";
}
