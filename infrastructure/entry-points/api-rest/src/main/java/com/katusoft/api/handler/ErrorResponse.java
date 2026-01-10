package com.katusoft.api.handler;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse {
  private String code;
  private String message;
  private String detail;
}
