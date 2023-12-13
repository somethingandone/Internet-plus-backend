package cn.edu.nju.service;

import cn.edu.nju.model.InRegulation;

import java.util.List;

public interface InRegulationService{
    void save(InRegulation inRegulation);
    List<InRegulation> findAll();
}
