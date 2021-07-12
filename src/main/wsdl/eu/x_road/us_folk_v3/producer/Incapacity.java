
package eu.x_road.us_folk_v3.producer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for Incapacity complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="Incapacity"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="guardian1" type="{http://us-folk-v3.x-road.eu/producer}Guardian"/&amp;gt;
 *         &amp;lt;element name="guardian2" type="{http://us-folk-v3.x-road.eu/producer}Guardian" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Incapacity", propOrder = {
    "guardian1",
    "guardian2"
})
public class Incapacity {

    @XmlElement(required = true)
    protected Guardian guardian1;
    protected Guardian guardian2;

    /**
     * Gets the value of the guardian1 property.
     * 
     * @return
     *     possible object is
     *     {@link Guardian }
     *     
     */
    public Guardian getGuardian1() {
        return guardian1;
    }

    /**
     * Sets the value of the guardian1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Guardian }
     *     
     */
    public void setGuardian1(Guardian value) {
        this.guardian1 = value;
    }

    /**
     * Gets the value of the guardian2 property.
     * 
     * @return
     *     possible object is
     *     {@link Guardian }
     *     
     */
    public Guardian getGuardian2() {
        return guardian2;
    }

    /**
     * Sets the value of the guardian2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Guardian }
     *     
     */
    public void setGuardian2(Guardian value) {
        this.guardian2 = value;
    }

}
