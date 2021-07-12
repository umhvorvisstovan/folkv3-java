
package eu.x_road.us_folk_v3.producer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for CommunityPerson complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="CommunityPerson"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="person" type="{http://us-folk-v3.x-road.eu/producer}PersonSmall"/&amp;gt;
 *         &amp;lt;element name="existingId" type="{http://us-folk-v3.x-road.eu/producer}PrivateId"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommunityPerson", propOrder = {
    "status",
    "person",
    "existingId"
})
public class CommunityPerson {

    @XmlElement(required = true)
    protected String status;
    @XmlElement(required = true)
    protected PersonSmall person;
    @XmlElement(required = true)
    protected PrivateId existingId;

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the person property.
     * 
     * @return
     *     possible object is
     *     {@link PersonSmall }
     *     
     */
    public PersonSmall getPerson() {
        return person;
    }

    /**
     * Sets the value of the person property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonSmall }
     *     
     */
    public void setPerson(PersonSmall value) {
        this.person = value;
    }

    /**
     * Gets the value of the existingId property.
     * 
     * @return
     *     possible object is
     *     {@link PrivateId }
     *     
     */
    public PrivateId getExistingId() {
        return existingId;
    }

    /**
     * Sets the value of the existingId property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrivateId }
     *     
     */
    public void setExistingId(PrivateId value) {
        this.existingId = value;
    }

}
