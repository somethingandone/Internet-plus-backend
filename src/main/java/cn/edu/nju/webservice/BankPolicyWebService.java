package cn.edu.nju.webservice;

import cn.edu.nju.model.ExRegulation;
import cn.edu.nju.model.InRegulation;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(name = "BankPolicyService", targetNamespace = "http://webservice.nju.edu.cn")
public interface BankPolicyWebService {
    @WebMethod
    String hello();
    @WebMethod
    InRegulation inRegulation_getById(@WebParam(name = "id") String id);
    @WebMethod
    List<InRegulation> inRegulation_list();
    @WebMethod
    int inRegulation_count(@WebParam(name = "inRegulation") InRegulation inRegulation);
    @WebMethod
    ExRegulation exRegulation_getById(@WebParam(name = "id") String id);
    @WebMethod
    List<ExRegulation> exRegulation_list();
    @WebMethod
    int exRegulation_count(@WebParam(name = "exRegulation") ExRegulation exRegulation);

}
