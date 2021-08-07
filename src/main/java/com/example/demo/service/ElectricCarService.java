package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.ElectricCar;

public interface ElectricCarService {

    Integer count();

    List<ElectricCar> findAll();

    ElectricCar findOne(Long id);
    
    ElectricCar save(ElectricCar car);

    boolean delete(Long id);
    
    List<ElectricCar> findByColor(String color);
    
    List<ElectricCar> findByDoor(int door);

    List<ElectricCar> findByBrand(String brand);
    
    List<ElectricCar> findStarted();

}
