package br.com.udemy.webfluxcourse.mapper;

import br.com.udemy.webfluxcourse.entity.User;
import br.com.udemy.webfluxcourse.model.request.UserRequest;
import br.com.udemy.webfluxcourse.model.response.UserResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-20T10:09:14-0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 21.0.1 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserRequest request) {
        if ( request == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        if ( request.name() != null ) {
            user.name( request.name() );
        }
        if ( request.email() != null ) {
            user.email( request.email() );
        }
        if ( request.password() != null ) {
            user.password( request.password() );
        }

        return user.build();
    }

    @Override
    public User toEntity(UserRequest request, User entity) {
        if ( request == null ) {
            return entity;
        }

        if ( request.name() != null ) {
            entity.setName( request.name() );
        }
        if ( request.email() != null ) {
            entity.setEmail( request.email() );
        }
        if ( request.password() != null ) {
            entity.setPassword( request.password() );
        }

        return entity;
    }

    @Override
    public UserResponse toResponse(User entity) {
        if ( entity == null ) {
            return null;
        }

        String id = null;
        String name = null;
        String email = null;
        String password = null;

        if ( entity.getId() != null ) {
            id = entity.getId();
        }
        if ( entity.getName() != null ) {
            name = entity.getName();
        }
        if ( entity.getEmail() != null ) {
            email = entity.getEmail();
        }
        if ( entity.getPassword() != null ) {
            password = entity.getPassword();
        }

        UserResponse userResponse = new UserResponse( id, name, email, password );

        return userResponse;
    }
}
