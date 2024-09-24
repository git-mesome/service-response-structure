package io.wisoft.tutorial;

/**
 * HTTP 응답에 해당하는 오류 코드 포함
 * 성공 여부 및 상태 찾기 제공
 */
public enum HttpStatus {
  OK(200),
  UNAUTHORIZED(401),
  INTERNAL_SERVER_ERROR(500);

  private final int code;

  HttpStatus(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }


  public boolean isSuccess() {
    return code >= 200 && code < 300;
  }

  public static HttpStatus findByCode(int code) {
    for (HttpStatus status : HttpStatus.values()) {
      if (status.getCode() == code) {
        return status;
      }
    }
    return null;
  }

}
