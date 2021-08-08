package com.example.demo.service;

import java.util.List;
import com.example.demo.domain.CombustionCar;

public interface CombustionCarService {

    Integer count();

    List<CombustionCar> findAll();

    CombustionCar findOne(Long id);
    
    CombustionCar save(CombustionCar car);

    boolean delete(Long id);

    void deleteAll();

    List<CombustionCar> findByColor(String color);
    
    List<CombustionCar> findByDoor(int door);

    List<CombustionCar> findByBrand(String brand);
    
    List<CombustionCar> findStarted();
}
