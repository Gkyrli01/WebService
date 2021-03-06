
package clinical.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "returnDoctorsResponse", namespace = "http://clinical/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "returnDoctorsResponse", namespace = "http://clinical/")
public class ReturnDoctorsResponse {

    @XmlElement(name = "return", namespace = "", nillable = true)
    private viewpoints.DoctorC[] _return;

    /**
     * 
     * @return
     *     returns DoctorC[]
     */
    public viewpoints.DoctorC[] getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(viewpoints.DoctorC[] _return) {
        this._return = _return;
    }

}
