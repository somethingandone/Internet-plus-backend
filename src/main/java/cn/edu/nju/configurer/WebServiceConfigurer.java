package cn.edu.nju.configurer;
import cn.edu.nju.webservice.BankPolicyWebService;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class WebServiceConfigurer {

    @Autowired
    private BankPolicyWebService bankPolicyWebService;
    /**
     * Apache CXF 核心架构是以BUS为核心，整合其他组件。
     * Bus是CXF的主干, 为共享资源提供一个可配置的场所，作用类似于Spring的ApplicationContext，这些共享资源包括
     * WSDl管理器、绑定工厂等。通过对BUS进行扩展，可以方便地容纳自己的资源，或者替换现有的资源。默认Bus实现基于Spring架构，
     * 通过依赖注入，在运行时将组件串联起来。BusFactory负责Bus的创建。默认的BusFactory是SpringBusFactory，对应于默认
     * 的Bus实现。在构造过程中，SpringBusFactory会搜索META-INF/cxf（包含在 CXF 的jar中）下的所有bean配置文件。
     * 根据这些配置文件构建一个ApplicationContext。开发者也可以提供自己的配置文件来定制Bus。
     */
    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }


    //webservice /services/ws/api?wsdl
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), bankPolicyWebService);
        endpoint.publish("/ws/api");
        return endpoint;
    }
}
