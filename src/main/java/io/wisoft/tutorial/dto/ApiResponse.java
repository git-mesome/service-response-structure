package io.wisoft.tutorial.dto;

public class ApiResponse {
  private String status;
  private Object data;

  public ApiResponse() {
  }

  public ApiResponse(String status, Object data) {
    this.status = status;
    this.data = data;
  }

  public String getStatus() {
    return status;
  }

  public Object getData() {
    return data;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public void setData(Object data) {
    this.data = data;
  }
}
