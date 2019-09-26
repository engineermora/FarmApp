package com.ChickenTest.FarmApp.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ChickenTest.FarmApp.DTO.EggDTO;
import com.ChickenTest.FarmApp.Models.Egg;

@Service
public interface EggServices {

public List<Object> getData();

public EggDTO getEggData(Egg egg);

public EggDTO add(EggDTO eggDTO);

public EggDTO delete(EggDTO eggDTO);

public EggDTO update(EggDTO eggDTO);

}