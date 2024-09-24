package io.wisoft.tutorial;

import io.wisoft.tutorial.dto.ApiResponse;
import io.wisoft.tutorial.dto.UserResponse;
import io.wisoft.tutorial.dto.ErrorResponse;
import io.wisoft.tutorial.service.AuthService;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    // 서비스 및 컨트롤러 인스턴스 생성
    AuthRepository authRepository = new AuthRepository();
    AuthService authService = new AuthService(authRepository);
    AuthController authController = new AuthController(authService);

    Scanner scanner = new Scanner(System.in);

    System.out.println("로그인 하세요.");

    // 이메일 입력
    System.out.print("이메일: ");
    String email = scanner.nextLine();

    // 비밀번호 입력
    System.out.print("비밀번호: ");
    String password = scanner.nextLine();

    // 로그인 시도
    ApiResponse response = authController.signin(email, password);

    // 결과 출력
    System.out.println("응답 상태: " + response.getStatus());
    if ("success".equals(response.getStatus())) {
      UserResponse userResponse = (UserResponse) response.getData();
      System.out.println("로그인 성공!");
      System.out.println("사용자 이메일: " + userResponse.email());
    } else {
      ErrorResponse errorResponse = (ErrorResponse) response.getData();
      System.out.println("로그인 실패!");
      System.out.println(errorResponse.toString());
    }

    // 스캐너 닫기
    scanner.close();
  }
}
