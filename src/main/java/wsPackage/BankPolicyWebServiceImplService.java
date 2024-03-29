
package wsPackage;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "BankPolicyWebServiceImplService", targetNamespace = "http://webservice.nju.edu.cn", wsdlLocation = "http://localhost:3456/services/ws/api?wsdl")
public class BankPolicyWebServiceImplService
    extends Service
{

    private final static URL BANKPOLICYWEBSERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException BANKPOLICYWEBSERVICEIMPLSERVICE_EXCEPTION;
    private final static QName BANKPOLICYWEBSERVICEIMPLSERVICE_QNAME = new QName("http://webservice.nju.edu.cn", "BankPolicyWebServiceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:3456/services/ws/api?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        BANKPOLICYWEBSERVICEIMPLSERVICE_WSDL_LOCATION = url;
        BANKPOLICYWEBSERVICEIMPLSERVICE_EXCEPTION = e;
    }

    public BankPolicyWebServiceImplService() {
        super(__getWsdlLocation(), BANKPOLICYWEBSERVICEIMPLSERVICE_QNAME);
    }

    public BankPolicyWebServiceImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), BANKPOLICYWEBSERVICEIMPLSERVICE_QNAME, features);
    }

    public BankPolicyWebServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, BANKPOLICYWEBSERVICEIMPLSERVICE_QNAME);
    }

    public BankPolicyWebServiceImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, BANKPOLICYWEBSERVICEIMPLSERVICE_QNAME, features);
    }

    public BankPolicyWebServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BankPolicyWebServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns BankPolicyService
     */
    @WebEndpoint(name = "BankPolicyWebServiceImplPort")
    public BankPolicyService getBankPolicyWebServiceImplPort() {
        return super.getPort(new QName("http://webservice.nju.edu.cn", "BankPolicyWebServiceImplPort"), BankPolicyService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BankPolicyService
     */
    @WebEndpoint(name = "BankPolicyWebServiceImplPort")
    public BankPolicyService getBankPolicyWebServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservice.nju.edu.cn", "BankPolicyWebServiceImplPort"), BankPolicyService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (BANKPOLICYWEBSERVICEIMPLSERVICE_EXCEPTION!= null) {
            throw BANKPOLICYWEBSERVICEIMPLSERVICE_EXCEPTION;
        }
        return BANKPOLICYWEBSERVICEIMPLSERVICE_WSDL_LOCATION;
    }

}
