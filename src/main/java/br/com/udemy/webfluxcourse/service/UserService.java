package br.com.udemy.webfluxcourse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.udemy.webfluxcourse.entity.User;
import br.com.udemy.webfluxcourse.mapper.UserMapper;
import br.com.udemy.webfluxcourse.model.request.UserRequest;
import br.com.udemy.webfluxcourse.repository.UserRepository;
import br.com.udemy.webfluxcourse.service.exception.ObjectNotFoundException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	@Autowired
	private UserMapper mapper;

	public Mono<User> save(final UserRequest request) {
		return repository.save(mapper.toEntity(request));
	}

	public Mono<User> findById(final String id) {
		return handleNotFound(repository.findById(id), id);
	}

	public Flux<User> findAll() {
		return repository.findAll();
	}

	public Mono<User> update(final String id, final UserRequest request) {
		return findById(id).map(entity -> mapper.toEntity(request, entity)).flatMap(repository::save);
	}

	public Mono<User> delete(final String id) {
		return handleNotFound(repository.findAndRemove(id), id);
	}

	private <T> Mono<T> handleNotFound(Mono<T> mono, String id) {
		return mono.switchIfEmpty(Mono.error(new ObjectNotFoundException(
				String.format("Object not found with ID: %s, Type: %s", id, User.class.getSimpleName()))));
	}
}
