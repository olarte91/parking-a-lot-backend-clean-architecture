package com.katusoft.api.mapper;

import com.katusoft.api.dto.RegisterResponse;
import com.katusoft.model.register.Register;

public interface RegisterRestMapper {
  RegisterResponse toResponse(Register domain);
}
