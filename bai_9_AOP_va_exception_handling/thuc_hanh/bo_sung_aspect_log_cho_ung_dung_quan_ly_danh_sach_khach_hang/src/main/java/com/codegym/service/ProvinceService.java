package com.codegym.service;

import com.codegym.model.Province;

import java.util.List;

public interface ProvinceService {
    List<Province> findAll();

    Province findOne(int id);

    Province save(Province Province);

    List<Province> save(List<Province> Provinces);

    boolean exists(int id);

    List<Province> findAll(List<Integer> ids);

    long count();

    void delete(int id);

    void delete(Province Province);

    void delete(List<Province> Provinces);

    void deleteAll();
}
