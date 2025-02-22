package br.com.udemy.webfluxcourse.model.request;

import br.com.udemy.webfluxcourse.validator.TrimString;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequest(
		@TrimString @Size(min = 3, max = 50, message = "must be between 3 and 50 characters") @NotBlank(message = "must not be null or empty") String name,

		@TrimString @Email @NotBlank(message = "must not be null or empty") String email,

		@TrimString @NotBlank(message = "must not be null or empty") String password) {

}
