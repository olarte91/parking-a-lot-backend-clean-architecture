package com.katusoft.config;

import com.katusoft.model.authentication.gateways.PasswordService;
import com.katusoft.model.authentication.gateways.TokenService;
import com.katusoft.model.fare.gateways.FareRepository;
import com.katusoft.model.parkingspace.gateways.ParkingSpaceRepository;
import com.katusoft.model.register.gateways.RegisterRepository;
import com.katusoft.model.user.gateways.UserRepository;
import com.katusoft.usecase.createfare.CreateFareUseCase;
import com.katusoft.usecase.createparkingspace.CreateParkingSpaceUseCase;
import com.katusoft.usecase.createuser.CreateUserUseCase;
import com.katusoft.usecase.getallparkingspaces.GetAllParkingSpacesUseCase;
import com.katusoft.usecase.loginuser.LoginUserUseCase;
import com.katusoft.usecase.processvehicleexit.ProcessVehicleExitUseCase;
import com.katusoft.usecase.registervehicle.RegisterVehicleUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "com.katusoft.usecase",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+UseCase$")
        },
        useDefaultFilters = false)
public class UseCasesConfig {

  @Bean
  public CreateParkingSpaceUseCase createParkingSpaceUseCase(
      ParkingSpaceRepository repository) {
    return new CreateParkingSpaceUseCase(repository);
  }

  @Bean
  public GetAllParkingSpacesUseCase getAllParkingSpacesUseCase(ParkingSpaceRepository repository) {
    return new GetAllParkingSpacesUseCase(repository);
  }

  @Bean
  public CreateFareUseCase createFareUseCase(
      FareRepository repository){
    return new CreateFareUseCase(repository);
  }

  @Bean
  public CreateUserUseCase createUserUseCase(
      UserRepository userRepository, PasswordService passwordService){
    return new CreateUserUseCase(userRepository, passwordService);
  }

  @Bean
  public LoginUserUseCase loginUserUseCase(
      UserRepository userRepository,
      PasswordService passwordService,
      TokenService tokenService){
    return new LoginUserUseCase(userRepository, passwordService, tokenService);
  }

  @Bean
  public RegisterVehicleUseCase registerVehicleUseCase(
      ParkingSpaceRepository parkingSpaceRepository,
      UserRepository userRepository,
      RegisterRepository registerRepository){
    return new RegisterVehicleUseCase(parkingSpaceRepository, userRepository, registerRepository);
  }

  @Bean
  public ProcessVehicleExitUseCase processVehicleExitUseCase(RegisterRepository register,
                                               ParkingSpaceRepository parkingSpaceRepository,
                                               FareRepository fare){
    return new ProcessVehicleExitUseCase(register, parkingSpaceRepository, fare);
  }
}
