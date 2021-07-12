
package eu.x_road.xsd.identifiers;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for XRoadObjectType.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * &lt;pre&gt;
 * &amp;lt;simpleType name="XRoadObjectType"&amp;gt;
 *   &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *     &amp;lt;enumeration value="MEMBER"/&amp;gt;
 *     &amp;lt;enumeration value="SUBSYSTEM"/&amp;gt;
 *     &amp;lt;enumeration value="SERVER"/&amp;gt;
 *     &amp;lt;enumeration value="GLOBALGROUP"/&amp;gt;
 *     &amp;lt;enumeration value="LOCALGROUP"/&amp;gt;
 *     &amp;lt;enumeration value="SECURITYCATEGORY"/&amp;gt;
 *     &amp;lt;enumeration value="SERVICE"/&amp;gt;
 *     &amp;lt;enumeration value="CENTRALSERVICE"/&amp;gt;
 *   &amp;lt;/restriction&amp;gt;
 * &amp;lt;/simpleType&amp;gt;
 * &lt;/pre&gt;
 * 
 */
@XmlType(name = "XRoadObjectType")
@XmlEnum
public enum XRoadObjectType {

    MEMBER,
    SUBSYSTEM,
    SERVER,
    GLOBALGROUP,
    LOCALGROUP,
    SECURITYCATEGORY,
    SERVICE,
    CENTRALSERVICE;

    public String value() {
        return name();
    }

    public static XRoadObjectType fromValue(String v) {
        return valueOf(v);
    }

}
