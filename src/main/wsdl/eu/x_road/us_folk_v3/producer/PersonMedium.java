
package eu.x_road.us_folk_v3.producer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for PersonMedium complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="PersonMedium"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://us-folk-v3.x-road.eu/producer}PersonSmall"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="publicId" type="{http://us-folk-v3.x-road.eu/producer}PublicId"/&amp;gt;
 *         &amp;lt;element name="ptal" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="dateOfBirth" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="civilStatus" type="{http://us-folk-v3.x-road.eu/producer}CivilStatus"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonMedium", propOrder = {
    "publicId",
    "ptal",
    "dateOfBirth",
    "civilStatus"
})
public class PersonMedium
    extends PersonSmall
{

    @XmlElement(required = true)
    protected PublicId publicId;
    @XmlElement(required = true)
    protected String ptal;
    @XmlElement(required = true)
    protected String dateOfBirth;
    @XmlElement(required = true)
    protected CivilStatus civilStatus;

    /**
     * Gets the value of the publicId property.
     * 
     * @return
     *     possible object is
     *     {@link PublicId }
     *     
     */
    public PublicId getPublicId() {
        return publicId;
    }

    /**
     * Sets the value of the publicId property.
     * 
     * @param value
     *     allowed object is
     *     {@link PublicId }
     *     
     */
    public void setPublicId(PublicId value) {
        this.publicId = value;
    }

    /**
     * Gets the value of the ptal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPtal() {
        return ptal;
    }

    /**
     * Sets the value of the ptal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPtal(String value) {
        this.ptal = value;
    }

    /**
     * Gets the value of the dateOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the value of the dateOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateOfBirth(String value) {
        this.dateOfBirth = value;
    }

    /**
     * Gets the value of the civilStatus property.
     * 
     * @return
     *     possible object is
     *     {@link CivilStatus }
     *     
     */
    public CivilStatus getCivilStatus() {
        return civilStatus;
    }

    /**
     * Sets the value of the civilStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link CivilStatus }
     *     
     */
    public void setCivilStatus(CivilStatus value) {
        this.civilStatus = value;
    }

}
