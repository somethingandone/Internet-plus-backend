
package wsPackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>inRegulation_count complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="inRegulation_count">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="inRegulation" type="{http://webservice.nju.edu.cn}inRegulation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inRegulation_count", propOrder = {
    "inRegulation"
})
public class InRegulationCount {

    protected InRegulation inRegulation;

    /**
     * 获取inRegulation属性的值。
     * 
     * @return
     *     possible object is
     *     {@link InRegulation }
     *     
     */
    public InRegulation getInRegulation() {
        return inRegulation;
    }

    /**
     * 设置inRegulation属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link InRegulation }
     *     
     */
    public void setInRegulation(InRegulation value) {
        this.inRegulation = value;
    }

}
