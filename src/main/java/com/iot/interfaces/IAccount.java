package com.iot.interfaces;

public interface IAccount {
	String getPassword(String username);
	String[]getRoles(String username);
}
