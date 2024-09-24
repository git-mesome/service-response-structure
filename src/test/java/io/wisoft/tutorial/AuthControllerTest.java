package io.wisoft.tutorial;

import io.wisoft.tutorial.dto.ApiResponse;
import io.wisoft.tutorial.dto.UserResponse;
import io.wisoft.tutorial.error.ErrorCode;
import io.wisoft.tutorial.service.AuthService;
import io.wisoft.tutorial.service.ErrorMessageService;
import io.wisoft.tutorial.dto.ErrorResponse;
import io.wisoft.tutorial.exception.AuthException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AuthControllerTest {

  @InjectMocks
  private AuthController authController;

  @Mock
  private AuthService authService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  @DisplayName("사용자 로그인 성공")
  public void signin_success() throws Exception {
    //given
    String email = "test@test.com";
    String password = "testSuccess";
    Locale userLocale = Locale.KOREA;
    UserResponse expectedUserResponse = new UserResponse(email, password);

    when(authService.authenticate(email, password, userLocale))
        .thenReturn(expectedUserResponse);

    //when
    ApiResponse response = authController.signin(email, password);

    //then
    assertEquals("success", response.getStatus());
    assertEquals(expectedUserResponse,response.getData());

  }

  @Test
  @DisplayName("사용자 로그인 실패")
  void signin_fail() throws AuthException {
    //given
    String email = "test@test.com";
    String password = "testWrong";
    Locale userLocale = Locale.KOREA;

    String errorMessage = ErrorMessageService.getMessage("auth.failed", userLocale);
    when(authService.authenticate(email, password, userLocale))
        .thenThrow(new AuthException(errorMessage));

    //when
    ApiResponse response = authController.signin(email, password);

    //then
    assertEquals("fail", response.getStatus());

    ErrorResponse errorResponse = (ErrorResponse) response.getData();
    assertNotNull(errorResponse);

    // ErrorCode 가 AUTH_FAILED 인지 확인
    assertEquals(ErrorCode.AUTH_FAILED, errorResponse.error());

    // ErrorCode 의 세부 정보도 확인
    assertEquals("AUTH_FAILED", errorResponse.error().getErrorCode());
    assertEquals(errorMessage, errorResponse.error().getMessage(userLocale));
  }

}