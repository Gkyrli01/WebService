
package medicalRecord.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "returnPharmakoSideEffectsResponse", namespace = "http://medicalRecord/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "returnPharmakoSideEffectsResponse", namespace = "http://medicalRecord/")
public class ReturnPharmakoSideEffectsResponse {

    @XmlElement(name = "return", namespace = "", nillable = true)
    private viewpoints.PharmakoSideEffects[] _return;

    /**
     * 
     * @return
     *     returns PharmakoSideEffects[]
     */
    public viewpoints.PharmakoSideEffects[] getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(viewpoints.PharmakoSideEffects[] _return) {
        this._return = _return;
    }

}
