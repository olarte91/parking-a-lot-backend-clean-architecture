package com.katusoft.usecase.getallregisters;

import com.katusoft.model.register.Register;
import com.katusoft.model.register.gateways.RegisterRepository;

import java.util.List;

public class GetAllRegistersUseCase {

  private final RegisterRepository registerRepository;

  public GetAllRegistersUseCase(RegisterRepository registerRepository){
    this.registerRepository = registerRepository;
  }

  public List<Register> execute(){
    return registerRepository.findAll();
  }
}
