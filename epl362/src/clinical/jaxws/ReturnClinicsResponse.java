
package clinical.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "returnClinicsResponse", namespace = "http://clinical/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "returnClinicsResponse", namespace = "http://clinical/")
public class ReturnClinicsResponse {

    @XmlElement(name = "return", namespace = "", nillable = true)
    private viewpoints.Clinic[] _return;

    /**
     * 
     * @return
     *     returns Clinic[]
     */
    public viewpoints.Clinic[] getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(viewpoints.Clinic[] _return) {
        this._return = _return;
    }

}
