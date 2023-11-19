package cn.edu.nju.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "BankPolicyService", targetNamespace = "http://webservice.nju.edu.cn")
public interface BankPolicyWebService {
    @WebMethod
    String hello();
}
