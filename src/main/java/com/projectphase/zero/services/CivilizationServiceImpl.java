package com.projectphase.zero.services;

import com.projectphase.zero.models.Civilization;
import com.projectphase.zero.models.CivilizatonApiResponse;
import com.projectphase.zero.models.Result;
import com.projectphase.zero.repositories.CivilizationRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Service
public class CivilizationServiceImpl implements CivilizationService {

  private CivilizationRepository civilizationRepository;
  private RetrofitService retrofitService;
  private CivilizationApi civilizationApi;


  @Autowired
  public CivilizationServiceImpl(CivilizationRepository civilizationRepository,
      RetrofitService retrofitService) {
    this.civilizationRepository = civilizationRepository;
    this.retrofitService = retrofitService;
    this.civilizationApi = this.retrofitService.getCivilizationApi();
  }

  @Override
  public List<Civilization> findAll() {
    List<Civilization> civilizations = new ArrayList<>();
    civilizationRepository.findAll().forEach(civilizations::add);
    return civilizations;
  }

  @Override
  public Civilization findCivById(int id) {
    return civilizationRepository.findById(id);
  }

  @Override
  public void saveCivilizations(CivilizatonApiResponse civilizatonApiResponse) {
    List<Result> civilizations = civilizatonApiResponse.getCivilizations();
    civilizations.forEach(result -> civilizationRepository.save(
        new Civilization(
            result.getId(),
            result.getName(),
            result.getArmy_type(),
            result.getExpansion(),
            result.getUnique_unit()
        )));
  }

  @Override
  public void getCivilizations() {
    civilizationApi.getAllCivilizations().enqueue(new Callback<CivilizatonApiResponse>() {
      @Override
      public void onResponse(Call<CivilizatonApiResponse> call,
          Response<CivilizatonApiResponse> response) {
        saveCivilizations(response.body());
      }

      @Override
      public void onFailure(Call<CivilizatonApiResponse> call, Throwable t) {
        t.printStackTrace();
      }
    });
  }


  @Override
  public List<Civilization> getConquerors() {
    return civilizationRepository.findTheConquerors();
  }

  @Override
  public void saveCivById(int id) {

    civilizationApi.getCivilizationById(id).enqueue(new Callback<Civilization>() {
      @Override
      public void onResponse(Call<Civilization> call,
          Response<Civilization> response) {
        civilizationRepository
            .save(new Civilization(
                response.body().getId(),
                response.body().getName(),
                response.body().getExpansion(),
                response.body().getArmy_type(),
                response.body().getUnique_unit()));
      }

      @Override
      public void onFailure(Call<Civilization> call, Throwable t) {
        t.printStackTrace();
      }
    });
  }
}
