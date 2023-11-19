package cn.edu.nju.webservice.impl;

import cn.edu.nju.webservice.BankPolicyWebService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

@Component
@WebService(name = "BankPolicyWebServiceImpl", targetNamespace = "http://webservice.nju.edu.cn",
        endpointInterface = "cn.edu.nju.webservice.BankPolicyWebService")
public class BankPolicyWebServiceImpl implements BankPolicyWebService {
    @Override
    public String hello() {
        return "hello";
    }
}
