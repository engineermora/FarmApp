package com.ChickenTest.FarmApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.ChickenTest.FarmApp.Models.Egg;

@RepositoryRestResource
public interface EggRepository extends JpaRepository<Egg, Long>{
}