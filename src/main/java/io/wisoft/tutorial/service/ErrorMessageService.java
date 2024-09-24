package io.wisoft.tutorial.service;

import java.util.Locale;
import java.util.ResourceBundle;

public class ErrorMessageService {
  public static String getMessage(String key, Locale locale) {
    ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
    return bundle.getString(key);
  }
}
