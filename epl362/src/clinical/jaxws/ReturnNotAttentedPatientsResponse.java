
package clinical.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "returnNotAttentedPatientsResponse", namespace = "http://clinical/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "returnNotAttentedPatientsResponse", namespace = "http://clinical/")
public class ReturnNotAttentedPatientsResponse {

    @XmlElement(name = "return", namespace = "", nillable = true)
    private viewpoints.Patient[] _return;

    /**
     * 
     * @return
     *     returns Patient[]
     */
    public viewpoints.Patient[] getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(viewpoints.Patient[] _return) {
        this._return = _return;
    }

}
