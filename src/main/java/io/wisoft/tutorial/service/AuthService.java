package io.wisoft.tutorial.service;

import io.wisoft.tutorial.AuthRepository;
import io.wisoft.tutorial.domain.User;
import io.wisoft.tutorial.dto.UserResponse;
import io.wisoft.tutorial.exception.AuthException;

import java.util.Locale;

public class AuthService {

  private final AuthRepository authRepository;

  public AuthService(final AuthRepository authRepository) {
    this.authRepository = authRepository;
  }

  public UserResponse authenticate(String email, String password, Locale locale) throws AuthException {

    User user = authRepository.findByEmailAndPassword(email, password);

    if (user == null) {
      // 인증 실패 시 예외 발생
      String errorMessage = ErrorMessageService.getMessage("auth.failed", locale);
      throw new AuthException(errorMessage);
    }

    return new UserResponse(user.getEmail(), user.getPassword());
  }
}
