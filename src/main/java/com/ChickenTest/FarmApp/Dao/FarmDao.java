package com.ChickenTest.FarmApp.Dao;

import java.util.List;

import com.ChickenTest.FarmApp.Models.Chicken;

public interface FarmDao {

	void insertar (Chicken chicken);
	
	void modificar (Chicken chicken);
	
	void eliminar (Chicken chicken);
	
	List<Chicken> ObtenerTodos();
	
	Chicken obtener(Long id);	
	
}
