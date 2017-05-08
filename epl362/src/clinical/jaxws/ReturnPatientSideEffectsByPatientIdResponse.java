
package clinical.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "returnPatientSideEffectsByPatientIdResponse", namespace = "http://clinical/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "returnPatientSideEffectsByPatientIdResponse", namespace = "http://clinical/")
public class ReturnPatientSideEffectsByPatientIdResponse {

    @XmlElement(name = "return", namespace = "", nillable = true)
    private viewpoints.PatientSideEffects[] _return;

    /**
     * 
     * @return
     *     returns PatientSideEffects[]
     */
    public viewpoints.PatientSideEffects[] getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(viewpoints.PatientSideEffects[] _return) {
        this._return = _return;
    }

}
