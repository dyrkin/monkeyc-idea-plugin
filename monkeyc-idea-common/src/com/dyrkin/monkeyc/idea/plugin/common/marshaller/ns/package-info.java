/**
 * @author eugene zadyra
 */
@XmlSchema(namespace = "http://www.garmin.com/xml/connectiq",
        elementFormDefault = XmlNsForm.QUALIFIED,
        xmlns = {
                @XmlNs(
                        prefix = "iq",
                        namespaceURI = "http://www.garmin.com/xml/connectiq")
        })
package com.dyrkin.monkeyc.idea.plugin.common.marshaller.ns;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;