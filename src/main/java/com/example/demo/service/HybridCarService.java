package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.HybridCar;

public interface HybridCarService {

    Integer count();

    List<HybridCar> findAll();

    HybridCar findOne(Long id);
    
    HybridCar save(HybridCar car);

    boolean delete(Long id);

    void deleteAll();

    List<HybridCar> findByColor(String color);
    
    List<HybridCar> findByDoor(int door);

    List<HybridCar> findByBrand(String brand);
    
    List<HybridCar> findStarted();

}
