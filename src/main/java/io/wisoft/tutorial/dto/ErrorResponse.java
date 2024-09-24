package io.wisoft.tutorial.dto;

import io.wisoft.tutorial.error.ErrorCode;

import java.util.Locale;

public record ErrorResponse(ErrorCode error) {

  @Override
  public String toString() {
    return "ErrorResponse {" +
        "errorCode='" + error.getErrorCode() + '\'' +
        ", errorMessage='" + error.getMessage(Locale.KOREA) + '\'' +
        '}';
  }
}
