package com.projectphase.zero.services;

import com.projectphase.zero.models.CivilizatonApiResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CivilizationApi {

  @GET("/api/v1/civilizations")
  Call<CivilizatonApiResponse> getAllCivilizations();
}
