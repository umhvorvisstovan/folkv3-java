
package eu.x_road.us_folk_v3.producer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for PersonMediumResponse complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="PersonMediumResponse"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://us-folk-v3.x-road.eu/producer}ResponseBase"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="result" type="{http://us-folk-v3.x-road.eu/producer}PersonMedium"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonMediumResponse", propOrder = {
    "result"
})
@XmlSeeAlso({
    GetPersonMediumByNameAndDateOfBirthResponse.class,
    GetPersonMediumByNameAndAddressResponse.class,
    GetPersonMediumByPtalResponse.class,
    GetPersonMediumByPublicIdResponse.class,
    GetPersonMediumByPrivateIdResponse.class
})
public class PersonMediumResponse
    extends ResponseBase
{

    @XmlElement(required = true)
    protected PersonMedium result;

    /**
     * Gets the value of the result property.
     * 
     * @return
     *     possible object is
     *     {@link PersonMedium }
     *     
     */
    public PersonMedium getResult() {
        return result;
    }

    /**
     * Sets the value of the result property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonMedium }
     *     
     */
    public void setResult(PersonMedium value) {
        this.result = value;
    }

}
