package cn.edu.nju.webservice.impl;

import cn.edu.nju.model.ExRegulation;
import cn.edu.nju.model.InRegulation;
import cn.edu.nju.service.impl.ExRegulationServiceImpl;
import cn.edu.nju.service.impl.InRegulationServiceImpl;
import cn.edu.nju.webservice.BankPolicyWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.List;

@Component
@WebService(name = "BankPolicyWebServiceImpl", targetNamespace = "http://webservice.nju.edu.cn",
        endpointInterface = "cn.edu.nju.webservice.BankPolicyWebService")
public class BankPolicyWebServiceImpl implements BankPolicyWebService {
    @Autowired
    InRegulationServiceImpl inRegulationService;
    @Autowired
    ExRegulationServiceImpl exRegulationService;
    @Override
    public String hello() {
        return "hello";
    }

    @Override
    public InRegulation inRegulation_getById(String id) {
        return inRegulationService.findById(id);
    }

    @Override
    public List<InRegulation> inRegulation_list() {
        return inRegulationService.findAll();
    }

    @Override
    public int inRegulation_count(InRegulation inRegulation) {
        return inRegulationService.count(inRegulation);
    }

    @Override
    public ExRegulation exRegulation_getById(String id) {
        return exRegulationService.findById(id);
    }
    @Override
    public List<ExRegulation> exRegulation_list() {
        return exRegulationService.findAll();
    }

    @Override
    public int exRegulation_count(ExRegulation exRegulation) {
        return exRegulationService.count(exRegulation);
    }
}
