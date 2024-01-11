
package wsPackage;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wsPackage package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _HelloResponse_QNAME = new QName("http://webservice.nju.edu.cn", "helloResponse");
    private final static QName _InRegulationCountResponse_QNAME = new QName("http://webservice.nju.edu.cn", "inRegulation_countResponse");
    private final static QName _ExRegulationCount_QNAME = new QName("http://webservice.nju.edu.cn", "exRegulation_count");
    private final static QName _InRegulationGetByIdResponse_QNAME = new QName("http://webservice.nju.edu.cn", "inRegulation_getByIdResponse");
    private final static QName _InRegulationCount_QNAME = new QName("http://webservice.nju.edu.cn", "inRegulation_count");
    private final static QName _ExRegulationCountResponse_QNAME = new QName("http://webservice.nju.edu.cn", "exRegulation_countResponse");
    private final static QName _Hello_QNAME = new QName("http://webservice.nju.edu.cn", "hello");
    private final static QName _ExRegulationGetById_QNAME = new QName("http://webservice.nju.edu.cn", "exRegulation_getById");
    private final static QName _ExRegulationList_QNAME = new QName("http://webservice.nju.edu.cn", "exRegulation_list");
    private final static QName _InRegulationListResponse_QNAME = new QName("http://webservice.nju.edu.cn", "inRegulation_listResponse");
    private final static QName _ExRegulationListResponse_QNAME = new QName("http://webservice.nju.edu.cn", "exRegulation_listResponse");
    private final static QName _InRegulationGetById_QNAME = new QName("http://webservice.nju.edu.cn", "inRegulation_getById");
    private final static QName _InRegulationList_QNAME = new QName("http://webservice.nju.edu.cn", "inRegulation_list");
    private final static QName _ExRegulationGetByIdResponse_QNAME = new QName("http://webservice.nju.edu.cn", "exRegulation_getByIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wsPackage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InRegulationList }
     * 
     */
    public InRegulationList createInRegulationList() {
        return new InRegulationList();
    }

    /**
     * Create an instance of {@link ExRegulationListResponse }
     * 
     */
    public ExRegulationListResponse createExRegulationListResponse() {
        return new ExRegulationListResponse();
    }

    /**
     * Create an instance of {@link InRegulationGetById }
     * 
     */
    public InRegulationGetById createInRegulationGetById() {
        return new InRegulationGetById();
    }

    /**
     * Create an instance of {@link ExRegulationGetByIdResponse }
     * 
     */
    public ExRegulationGetByIdResponse createExRegulationGetByIdResponse() {
        return new ExRegulationGetByIdResponse();
    }

    /**
     * Create an instance of {@link ExRegulationCount }
     * 
     */
    public ExRegulationCount createExRegulationCount() {
        return new ExRegulationCount();
    }

    /**
     * Create an instance of {@link InRegulationGetByIdResponse }
     * 
     */
    public InRegulationGetByIdResponse createInRegulationGetByIdResponse() {
        return new InRegulationGetByIdResponse();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link InRegulationCountResponse }
     * 
     */
    public InRegulationCountResponse createInRegulationCountResponse() {
        return new InRegulationCountResponse();
    }

    /**
     * Create an instance of {@link ExRegulationGetById }
     * 
     */
    public ExRegulationGetById createExRegulationGetById() {
        return new ExRegulationGetById();
    }

    /**
     * Create an instance of {@link ExRegulationList }
     * 
     */
    public ExRegulationList createExRegulationList() {
        return new ExRegulationList();
    }

    /**
     * Create an instance of {@link InRegulationListResponse }
     * 
     */
    public InRegulationListResponse createInRegulationListResponse() {
        return new InRegulationListResponse();
    }

    /**
     * Create an instance of {@link ExRegulationCountResponse }
     * 
     */
    public ExRegulationCountResponse createExRegulationCountResponse() {
        return new ExRegulationCountResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link InRegulationCount }
     * 
     */
    public InRegulationCount createInRegulationCount() {
        return new InRegulationCount();
    }

    /**
     * Create an instance of {@link ExRegulation }
     * 
     */
    public ExRegulation createExRegulation() {
        return new ExRegulation();
    }

    /**
     * Create an instance of {@link InRegulation }
     * 
     */
    public InRegulation createInRegulation() {
        return new InRegulation();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.nju.edu.cn", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InRegulationCountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.nju.edu.cn", name = "inRegulation_countResponse")
    public JAXBElement<InRegulationCountResponse> createInRegulationCountResponse(InRegulationCountResponse value) {
        return new JAXBElement<InRegulationCountResponse>(_InRegulationCountResponse_QNAME, InRegulationCountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExRegulationCount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.nju.edu.cn", name = "exRegulation_count")
    public JAXBElement<ExRegulationCount> createExRegulationCount(ExRegulationCount value) {
        return new JAXBElement<ExRegulationCount>(_ExRegulationCount_QNAME, ExRegulationCount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InRegulationGetByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.nju.edu.cn", name = "inRegulation_getByIdResponse")
    public JAXBElement<InRegulationGetByIdResponse> createInRegulationGetByIdResponse(InRegulationGetByIdResponse value) {
        return new JAXBElement<InRegulationGetByIdResponse>(_InRegulationGetByIdResponse_QNAME, InRegulationGetByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InRegulationCount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.nju.edu.cn", name = "inRegulation_count")
    public JAXBElement<InRegulationCount> createInRegulationCount(InRegulationCount value) {
        return new JAXBElement<InRegulationCount>(_InRegulationCount_QNAME, InRegulationCount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExRegulationCountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.nju.edu.cn", name = "exRegulation_countResponse")
    public JAXBElement<ExRegulationCountResponse> createExRegulationCountResponse(ExRegulationCountResponse value) {
        return new JAXBElement<ExRegulationCountResponse>(_ExRegulationCountResponse_QNAME, ExRegulationCountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.nju.edu.cn", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExRegulationGetById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.nju.edu.cn", name = "exRegulation_getById")
    public JAXBElement<ExRegulationGetById> createExRegulationGetById(ExRegulationGetById value) {
        return new JAXBElement<ExRegulationGetById>(_ExRegulationGetById_QNAME, ExRegulationGetById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExRegulationList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.nju.edu.cn", name = "exRegulation_list")
    public JAXBElement<ExRegulationList> createExRegulationList(ExRegulationList value) {
        return new JAXBElement<ExRegulationList>(_ExRegulationList_QNAME, ExRegulationList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InRegulationListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.nju.edu.cn", name = "inRegulation_listResponse")
    public JAXBElement<InRegulationListResponse> createInRegulationListResponse(InRegulationListResponse value) {
        return new JAXBElement<InRegulationListResponse>(_InRegulationListResponse_QNAME, InRegulationListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExRegulationListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.nju.edu.cn", name = "exRegulation_listResponse")
    public JAXBElement<ExRegulationListResponse> createExRegulationListResponse(ExRegulationListResponse value) {
        return new JAXBElement<ExRegulationListResponse>(_ExRegulationListResponse_QNAME, ExRegulationListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InRegulationGetById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.nju.edu.cn", name = "inRegulation_getById")
    public JAXBElement<InRegulationGetById> createInRegulationGetById(InRegulationGetById value) {
        return new JAXBElement<InRegulationGetById>(_InRegulationGetById_QNAME, InRegulationGetById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InRegulationList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.nju.edu.cn", name = "inRegulation_list")
    public JAXBElement<InRegulationList> createInRegulationList(InRegulationList value) {
        return new JAXBElement<InRegulationList>(_InRegulationList_QNAME, InRegulationList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExRegulationGetByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.nju.edu.cn", name = "exRegulation_getByIdResponse")
    public JAXBElement<ExRegulationGetByIdResponse> createExRegulationGetByIdResponse(ExRegulationGetByIdResponse value) {
        return new JAXBElement<ExRegulationGetByIdResponse>(_ExRegulationGetByIdResponse_QNAME, ExRegulationGetByIdResponse.class, null, value);
    }

}
