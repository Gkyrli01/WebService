
package clinical.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "returnSelfHarmIncidentByPatientIdResponse", namespace = "http://clinical/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "returnSelfHarmIncidentByPatientIdResponse", namespace = "http://clinical/")
public class ReturnSelfHarmIncidentByPatientIdResponse {

    @XmlElement(name = "return", namespace = "", nillable = true)
    private viewpoints.SelfHarmIncident[] _return;

    /**
     * 
     * @return
     *     returns SelfHarmIncident[]
     */
    public viewpoints.SelfHarmIncident[] getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(viewpoints.SelfHarmIncident[] _return) {
        this._return = _return;
    }

}
