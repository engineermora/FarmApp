package com.ChickenTest.FarmApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.ChickenTest.FarmApp.Models.Farm;

@RepositoryRestResource
public interface FarmRepository extends JpaRepository<Farm, Long>{
}