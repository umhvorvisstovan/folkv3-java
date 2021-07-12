
package eu.x_road.us_folk_v3.producer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for CommunityPersonResponse complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="CommunityPersonResponse"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://us-folk-v3.x-road.eu/producer}ResponseBase"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="result" type="{http://us-folk-v3.x-road.eu/producer}CommunityPerson"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommunityPersonResponse", propOrder = {
    "result"
})
@XmlSeeAlso({
    AddPersonToCommunityByNameAndDateOfBirthResponse.class,
    AddPersonToCommunityByNameAndAddressResponse.class
})
public class CommunityPersonResponse
    extends ResponseBase
{

    @XmlElement(required = true)
    protected CommunityPerson result;

    /**
     * Gets the value of the result property.
     * 
     * @return
     *     possible object is
     *     {@link CommunityPerson }
     *     
     */
    public CommunityPerson getResult() {
        return result;
    }

    /**
     * Sets the value of the result property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommunityPerson }
     *     
     */
    public void setResult(CommunityPerson value) {
        this.result = value;
    }

}
