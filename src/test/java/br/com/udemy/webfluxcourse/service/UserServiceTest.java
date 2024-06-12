package br.com.udemy.webfluxcourse.service;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Objects;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.udemy.webfluxcourse.entity.User;
import br.com.udemy.webfluxcourse.mapper.UserMapper;
import br.com.udemy.webfluxcourse.model.request.UserRequest;
import br.com.udemy.webfluxcourse.repository.UserRepository;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	private UserRepository repository;

	@Mock
	private UserMapper mapper;

	@InjectMocks
	private UserService service;

	@Test
	void save() {
		UserRequest request = new UserRequest("andre", "andre@gmail.com", "12345");
		User entity = User.builder().build();

		when(mapper.toEntity(request)).thenReturn(entity);
		when(repository.save(entity)).thenReturn(Mono.just(User.builder().build()));

		Mono<User> result = service.save(request);

		StepVerifier.create(result).expectNextMatches(Objects::nonNull).expectComplete().verify();
		
		Mockito.verify(repository).save(entity);
	}
}
