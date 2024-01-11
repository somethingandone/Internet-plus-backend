
package wsPackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>exRegulation_count complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="exRegulation_count">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="exRegulation" type="{http://webservice.nju.edu.cn}exRegulation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exRegulation_count", propOrder = {
    "exRegulation"
})
public class ExRegulationCount {

    protected ExRegulation exRegulation;

    /**
     * 获取exRegulation属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ExRegulation }
     *     
     */
    public ExRegulation getExRegulation() {
        return exRegulation;
    }

    /**
     * 设置exRegulation属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ExRegulation }
     *     
     */
    public void setExRegulation(ExRegulation value) {
        this.exRegulation = value;
    }

}
