package com.katusoft.model.valueobjects;

import com.katusoft.model.exception.InvalidLicensePlateException;

import java.util.Objects;

public class LicensePlate {

  private String value;

  public LicensePlate(String value) {
    if(value == null || value.isEmpty()) {
      throw new InvalidLicensePlateException("The value of the licenseplate is null or empty");
    }
    if(value.matches("^[A-Za-z]{3}[0-9]{2}[0-9A-Za-z]$")){
      throw new InvalidLicensePlateException("The value of the licenseplate is invalid");
    }

    this.value = value;
  }
  public String getValue() {
    return value;
  }

  @Override
  public boolean equals(Object obj){
    if(this== obj) return true;
    if(obj == null || getClass() != obj.getClass()) return false;
    LicensePlate licensePlate = (LicensePlate)obj;
    return Objects.equals(value, licensePlate.value );
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
