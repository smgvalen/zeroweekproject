package com.projectphase.zero.services;

import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@Service
public class RetrofitService {

  private Retrofit getConnectionToAOEIIApi(String url) {
    return new Retrofit
        .Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
  }

  public CivilizationApi getCivilizationApi() {
    return getConnectionToAOEIIApi(System.getenv("API_URL")).create(CivilizationApi.class);
  }
}

