
package receptionist.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "returnRelativesByPatientIdResponse", namespace = "http://receptionist/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "returnRelativesByPatientIdResponse", namespace = "http://receptionist/")
public class ReturnRelativesByPatientIdResponse {

    @XmlElement(name = "return", namespace = "", nillable = true)
    private viewpoints.Relatives[] _return;

    /**
     * 
     * @return
     *     returns Relatives[]
     */
    public viewpoints.Relatives[] getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(viewpoints.Relatives[] _return) {
        this._return = _return;
    }

}
