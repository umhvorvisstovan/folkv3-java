
package eu.x_road.us_folk_v3.producer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for PrivilegesResponse complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="PrivilegesResponse"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://us-folk-v3.x-road.eu/producer}ResponseBase"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="result" type="{http://us-folk-v3.x-road.eu/producer}PrivilegeList"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrivilegesResponse", propOrder = {
    "result"
})
@XmlSeeAlso({
    GetPrivilegesMediumResponse.class,
    GetPrivilegesSmallResponse.class,
    GetMyPrivilegesResponse.class
})
public class PrivilegesResponse
    extends ResponseBase
{

    @XmlElement(required = true)
    protected PrivilegeList result;

    /**
     * Gets the value of the result property.
     * 
     * @return
     *     possible object is
     *     {@link PrivilegeList }
     *     
     */
    public PrivilegeList getResult() {
        return result;
    }

    /**
     * Sets the value of the result property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrivilegeList }
     *     
     */
    public void setResult(PrivilegeList value) {
        this.result = value;
    }

}
