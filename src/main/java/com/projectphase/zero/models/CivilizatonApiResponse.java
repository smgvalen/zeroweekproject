package com.projectphase.zero.models;

import java.util.List;

public class CivilizatonApiResponse {

  private List<Result> civilizations;

  public CivilizatonApiResponse(
      List<Result> civilizations) {
    this.civilizations = civilizations;
  }

  public CivilizatonApiResponse(){}

  public List<Result> getCivilizations() {
    return this.civilizations;
  }

  public void setCivilizations(List<Result> civilizations) {
    this.civilizations = civilizations;
  }
}
