package com.ChickenTest.FarmApp;

import java.util.*;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ChickenTest.FarmApp.Models.Chicken;
import com.ChickenTest.FarmApp.Models.Egg;
import com.ChickenTest.FarmApp.Models.Farm;
import com.ChickenTest.FarmApp.Repositories.ChickenRepository;
import com.ChickenTest.FarmApp.Repositories.EggRepository;
import com.ChickenTest.FarmApp.Repositories.FarmRepository;

@SpringBootApplication
@ComponentScan({"com.ChickenTest.FarmApp.Controllers"})
@EntityScan("com.ChickenTest.FarmApp.Models")
@EnableJpaRepositories("com.ChickenTest.FarmApp.Repositories")
public class FarmAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmAppApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner initDataGamePlayer(FarmRepository farmRepository,
												ChickenRepository chickenRepository,
												EggRepository eggRepository) {
		return (String... args) -> {
		
			Farm farm = new Farm();
			
			farmRepository.save(farm);
			
			
			Chicken chicken1 = new Chicken(farm, "Lola");
			Chicken chicken2 = new Chicken(farm, "La locura");
			Chicken chicken3 = new Chicken(farm, "Incoherente");
			
			List<Chicken> chickensToFarm = new LinkedList<Chicken>();
			chickensToFarm.add(chicken1);
			chickensToFarm.add(chicken2);
			chickensToFarm.add(chicken3);
			
			farm.addChickens(chickensToFarm);
			
			chickenRepository.save(chicken1);
			chickenRepository.save(chicken2);
			chickenRepository.save(chicken3);
			
			Egg egg101 = new Egg(chicken1);
			Egg egg102 = new Egg(chicken1);
			Egg egg103 = new Egg(chicken1);
			Egg egg104 = new Egg(chicken1);
			Egg egg105 = new Egg(chicken1);
			
			Egg egg201 = new Egg(chicken2);
			Egg egg202 = new Egg(chicken2);
			Egg egg203 = new Egg(chicken2);
			Egg egg204 = new Egg(chicken2);
			
			Egg egg301 = new Egg(chicken3);
			Egg egg302 = new Egg(chicken3);

			eggRepository.save(egg101);
			eggRepository.save(egg102);
			eggRepository.save(egg103);
			eggRepository.save(egg104);
			eggRepository.save(egg105);
			eggRepository.save(egg201);
			eggRepository.save(egg202);
			eggRepository.save(egg203);
			eggRepository.save(egg204);
			eggRepository.save(egg301);
			eggRepository.save(egg302);
		};
	}
}
