package com.projectphase.zero.services;

import com.projectphase.zero.models.Civilization;
import com.projectphase.zero.models.CivilizatonApiResponse;
import java.util.List;

public interface CivilizationService {


   List<Civilization> findAll();

   void getCivilizations();

   void saveCivilizations(CivilizatonApiResponse civilizatonApiResponse);
}
