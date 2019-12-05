package com.projectphase.zero.services;

import com.projectphase.zero.models.Civilization;
import com.projectphase.zero.models.CivilizatonApiResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CivilizationApi {

  @GET("/api/v1/civilizations")
  Call<CivilizatonApiResponse> getAllCivilizations();

  @GET("/api/v1/civilization/{id}")
  Call<Civilization> getCivilizationById(@Path("id") int id);
}
