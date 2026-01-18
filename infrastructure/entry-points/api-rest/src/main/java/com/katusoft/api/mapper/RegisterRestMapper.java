package com.katusoft.api.mapper;

import com.katusoft.api.dto.ExitResponse;
import com.katusoft.api.dto.RegisterResponse;
import com.katusoft.model.register.Register;

import java.util.List;

public interface RegisterRestMapper {
  RegisterResponse toResponse(Register domain);
  ExitResponse toExitResponse(Register domain);
  List<RegisterResponse> toListResponse(List<Register> domainList);
}
