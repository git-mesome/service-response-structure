package io.wisoft.tutorial.error;

import java.util.Locale;

public enum ErrorCode {
  AUTH_FAILED("AUTH_FAILED", "auth.failed"),
  VALIDATION_FAILED("VALIDATION_FAILED", "missing.fields");

  private final String errorCode;
  private final String messageKey;

  ErrorCode(String errorCode, String messageKey) {
    this.errorCode = errorCode;
    this.messageKey = messageKey;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public String getMessage(Locale locale) {
    return ErrorMessageService.getMessage(messageKey, locale);
  }

}
