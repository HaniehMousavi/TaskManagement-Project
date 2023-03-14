package com.example.persistence.base.util;

import com.fasterxml.jackson.core.JsonProcessingException;

public class Print {
	private static com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();

	public static void print(Object subject, Object body) {
		try {
			System.out.println("\nVVVVVVVVVVV " + subject + " VVVVVVVVVVV");
			System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(body));
			System.out.println("AAAAAAAAAAA " + subject + " AAAAAAAAAAA\n");
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	public static String toString(Object body) {
		try {
			return objectMapper.writeValueAsString(body);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}
}
