package cn.edu.nju.service;

import cn.edu.nju.model.ExRegulation;

import java.util.List;

public interface ExRegulationService {
    void save(ExRegulation exRegulation);
    List<ExRegulation> findAll();
}
