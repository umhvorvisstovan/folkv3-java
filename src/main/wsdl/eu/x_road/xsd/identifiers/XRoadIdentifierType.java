
package eu.x_road.xsd.identifiers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Globally unique identifier in the X-Road system.
 *                 Identifier consists of object type specifier and list of
 *                 hierarchical codes (starting with code that identifiers
 *                 the X-Road instance).
 * 
 * &lt;p&gt;Java class for XRoadIdentifierType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="XRoadIdentifierType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://x-road.eu/xsd/identifiers}xRoadInstance" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://x-road.eu/xsd/identifiers}memberClass" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://x-road.eu/xsd/identifiers}memberCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://x-road.eu/xsd/identifiers}subsystemCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://x-road.eu/xsd/identifiers}groupCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://x-road.eu/xsd/identifiers}serviceCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://x-road.eu/xsd/identifiers}serviceVersion" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://x-road.eu/xsd/identifiers}securityCategoryCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://x-road.eu/xsd/identifiers}serverCode" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *       &amp;lt;attribute ref="{http://x-road.eu/xsd/identifiers}objectType use="required""/&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XRoadIdentifierType", propOrder = {
    "xRoadInstance",
    "memberClass",
    "memberCode",
    "subsystemCode",
    "groupCode",
    "serviceCode",
    "serviceVersion",
    "securityCategoryCode",
    "serverCode"
})
@XmlSeeAlso({
    XRoadClientIdentifierType.class,
    XRoadServiceIdentifierType.class,
    XRoadCentralServiceIdentifierType.class,
    XRoadSecurityCategoryIdentifierType.class,
    XRoadSecurityServerIdentifierType.class,
    XRoadGlobalGroupIdentifierType.class,
    XRoadLocalGroupIdentifierType.class
})
public class XRoadIdentifierType {

    protected String xRoadInstance;
    protected String memberClass;
    protected String memberCode;
    protected String subsystemCode;
    protected String groupCode;
    protected String serviceCode;
    protected String serviceVersion;
    protected String securityCategoryCode;
    protected String serverCode;
    @XmlAttribute(name = "objectType", namespace = "http://x-road.eu/xsd/identifiers", required = true)
    protected XRoadObjectType objectType;

    /**
     * Gets the value of the xRoadInstance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXRoadInstance() {
        return xRoadInstance;
    }

    /**
     * Sets the value of the xRoadInstance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXRoadInstance(String value) {
        this.xRoadInstance = value;
    }

    /**
     * Gets the value of the memberClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMemberClass() {
        return memberClass;
    }

    /**
     * Sets the value of the memberClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMemberClass(String value) {
        this.memberClass = value;
    }

    /**
     * Gets the value of the memberCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMemberCode() {
        return memberCode;
    }

    /**
     * Sets the value of the memberCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMemberCode(String value) {
        this.memberCode = value;
    }

    /**
     * Gets the value of the subsystemCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubsystemCode() {
        return subsystemCode;
    }

    /**
     * Sets the value of the subsystemCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubsystemCode(String value) {
        this.subsystemCode = value;
    }

    /**
     * Gets the value of the groupCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupCode() {
        return groupCode;
    }

    /**
     * Sets the value of the groupCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupCode(String value) {
        this.groupCode = value;
    }

    /**
     * Gets the value of the serviceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceCode() {
        return serviceCode;
    }

    /**
     * Sets the value of the serviceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceCode(String value) {
        this.serviceCode = value;
    }

    /**
     * Gets the value of the serviceVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceVersion() {
        return serviceVersion;
    }

    /**
     * Sets the value of the serviceVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceVersion(String value) {
        this.serviceVersion = value;
    }

    /**
     * Gets the value of the securityCategoryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecurityCategoryCode() {
        return securityCategoryCode;
    }

    /**
     * Sets the value of the securityCategoryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecurityCategoryCode(String value) {
        this.securityCategoryCode = value;
    }

    /**
     * Gets the value of the serverCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServerCode() {
        return serverCode;
    }

    /**
     * Sets the value of the serverCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServerCode(String value) {
        this.serverCode = value;
    }

    /**
     * Gets the value of the objectType property.
     * 
     * @return
     *     possible object is
     *     {@link XRoadObjectType }
     *     
     */
    public XRoadObjectType getObjectType() {
        return objectType;
    }

    /**
     * Sets the value of the objectType property.
     * 
     * @param value
     *     allowed object is
     *     {@link XRoadObjectType }
     *     
     */
    public void setObjectType(XRoadObjectType value) {
        this.objectType = value;
    }

}
