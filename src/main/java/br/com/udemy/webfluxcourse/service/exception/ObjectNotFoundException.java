package br.com.udemy.webfluxcourse.service.exception;

public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 6213639114961039424L;

	public ObjectNotFoundException(String message) {
		super(message);
	}
}
