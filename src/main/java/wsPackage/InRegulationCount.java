
package wsPackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>inRegulation_count complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡinRegulation���Ե�ֵ��
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
     * ����inRegulation���Ե�ֵ��
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
