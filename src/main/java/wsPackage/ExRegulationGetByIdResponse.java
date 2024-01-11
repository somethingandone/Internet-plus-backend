
package wsPackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>exRegulation_getByIdResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="exRegulation_getByIdResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://webservice.nju.edu.cn}exRegulation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exRegulation_getByIdResponse", propOrder = {
    "_return"
})
public class ExRegulationGetByIdResponse {

    @XmlElement(name = "return")
    protected ExRegulation _return;

    /**
     * 获取return属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ExRegulation }
     *     
     */
    public ExRegulation getReturn() {
        return _return;
    }

    /**
     * 设置return属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ExRegulation }
     *     
     */
    public void setReturn(ExRegulation value) {
        this._return = value;
    }

}
