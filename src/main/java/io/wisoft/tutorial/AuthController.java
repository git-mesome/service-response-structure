package io.wisoft.tutorial;

import io.wisoft.tutorial.dto.ApiResponse;
import io.wisoft.tutorial.dto.UserResponse;
import io.wisoft.tutorial.error.ErrorCode;
import io.wisoft.tutorial.dto.ErrorResponse;
import io.wisoft.tutorial.exception.AuthException;
import io.wisoft.tutorial.service.AuthService;

import java.util.Locale;

public class AuthController {
  private final AuthService authService;

  public AuthController(AuthService authService) {
    this.authService = authService;
  }

  /**
   * 사용자 로그인 메서드.
   *
   * @param email    사용자의 이메일 주소
   * @param password 사용자의 비밀번호
   * @return ApiResponse 성공 시 "success" 상태와 요청 데이터값을 포함한 응답, 실패 시 "fail" 상태와 오류 메시지를 포함한 응답
   * @throws AuthException 인증 실패 시 예외가 발생하며, 실패 응답이 반환된다
   */
  public ApiResponse signin(String email, String password) {
    Locale userLocale = Locale.KOREA;

    try {
      UserResponse user = authService.authenticate(email, password, userLocale);
      return new ApiResponse("success", user);

    } catch (AuthException e) {
      return new ApiResponse("fail", new ErrorResponse(ErrorCode.AUTH_FAILED));
    }
  }

}
