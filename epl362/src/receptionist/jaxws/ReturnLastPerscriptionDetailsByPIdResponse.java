
package receptionist.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "returnLastPerscriptionDetailsByPIdResponse", namespace = "http://receptionist/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "returnLastPerscriptionDetailsByPIdResponse", namespace = "http://receptionist/")
public class ReturnLastPerscriptionDetailsByPIdResponse {

    @XmlElement(name = "return", namespace = "", nillable = true)
    private viewpoints.PercriptionDetails[] _return;

    /**
     * 
     * @return
     *     returns PercriptionDetails[]
     */
    public viewpoints.PercriptionDetails[] getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(viewpoints.PercriptionDetails[] _return) {
        this._return = _return;
    }

}
