
package wsPackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>exRegulation_count complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡexRegulation���Ե�ֵ��
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
     * ����exRegulation���Ե�ֵ��
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
