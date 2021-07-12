
package eu.x_road.us_folk_v3.producer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for NameAndAddressParam complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="NameAndAddressParam"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="name" type="{http://us-folk-v3.x-road.eu/producer}NameParam"/&amp;gt;
 *         &amp;lt;element name="address" type="{http://us-folk-v3.x-road.eu/producer}AddressParam"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NameAndAddressParam", propOrder = {
    "name",
    "address"
})
public class NameAndAddressParam {

    @XmlElement(required = true)
    protected NameParam name;
    @XmlElement(required = true)
    protected AddressParam address;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link NameParam }
     *     
     */
    public NameParam getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link NameParam }
     *     
     */
    public void setName(NameParam value) {
        this.name = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link AddressParam }
     *     
     */
    public AddressParam getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressParam }
     *     
     */
    public void setAddress(AddressParam value) {
        this.address = value;
    }

}
