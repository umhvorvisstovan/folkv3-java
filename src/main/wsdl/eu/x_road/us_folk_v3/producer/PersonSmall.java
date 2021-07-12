
package eu.x_road.us_folk_v3.producer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for PersonSmall complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="PersonSmall"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="privateId" type="{http://us-folk-v3.x-road.eu/producer}PrivateId"/&amp;gt;
 *         &amp;lt;element name="name" type="{http://us-folk-v3.x-road.eu/producer}PersonName"/&amp;gt;
 *         &amp;lt;element name="gender" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="address" type="{http://us-folk-v3.x-road.eu/producer}Address"/&amp;gt;
 *         &amp;lt;element name="placeOfBirth" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="incapacity" type="{http://us-folk-v3.x-road.eu/producer}Incapacity"/&amp;gt;
 *         &amp;lt;element name="specialMarks" type="{http://us-folk-v3.x-road.eu/producer}SpecialMarks"/&amp;gt;
 *         &amp;lt;element name="dateOfDeath" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonSmall", propOrder = {
    "privateId",
    "name",
    "gender",
    "address",
    "placeOfBirth",
    "incapacity",
    "specialMarks",
    "dateOfDeath"
})
@XmlSeeAlso({
    PersonMedium.class
})
public class PersonSmall {

    @XmlElement(required = true)
    protected PrivateId privateId;
    @XmlElement(required = true)
    protected PersonName name;
    @XmlElement(required = true)
    protected String gender;
    @XmlElement(required = true)
    protected Address address;
    @XmlElement(required = true)
    protected String placeOfBirth;
    @XmlElement(required = true)
    protected Incapacity incapacity;
    @XmlElement(required = true)
    protected SpecialMarks specialMarks;
    @XmlElement(required = true)
    protected String dateOfDeath;

    /**
     * Gets the value of the privateId property.
     * 
     * @return
     *     possible object is
     *     {@link PrivateId }
     *     
     */
    public PrivateId getPrivateId() {
        return privateId;
    }

    /**
     * Sets the value of the privateId property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrivateId }
     *     
     */
    public void setPrivateId(PrivateId value) {
        this.privateId = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link PersonName }
     *     
     */
    public PersonName getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonName }
     *     
     */
    public void setName(PersonName value) {
        this.name = value;
    }

    /**
     * Gets the value of the gender property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGender(String value) {
        this.gender = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setAddress(Address value) {
        this.address = value;
    }

    /**
     * Gets the value of the placeOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    /**
     * Sets the value of the placeOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlaceOfBirth(String value) {
        this.placeOfBirth = value;
    }

    /**
     * Gets the value of the incapacity property.
     * 
     * @return
     *     possible object is
     *     {@link Incapacity }
     *     
     */
    public Incapacity getIncapacity() {
        return incapacity;
    }

    /**
     * Sets the value of the incapacity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Incapacity }
     *     
     */
    public void setIncapacity(Incapacity value) {
        this.incapacity = value;
    }

    /**
     * Gets the value of the specialMarks property.
     * 
     * @return
     *     possible object is
     *     {@link SpecialMarks }
     *     
     */
    public SpecialMarks getSpecialMarks() {
        return specialMarks;
    }

    /**
     * Sets the value of the specialMarks property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpecialMarks }
     *     
     */
    public void setSpecialMarks(SpecialMarks value) {
        this.specialMarks = value;
    }

    /**
     * Gets the value of the dateOfDeath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateOfDeath() {
        return dateOfDeath;
    }

    /**
     * Sets the value of the dateOfDeath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateOfDeath(String value) {
        this.dateOfDeath = value;
    }

}
