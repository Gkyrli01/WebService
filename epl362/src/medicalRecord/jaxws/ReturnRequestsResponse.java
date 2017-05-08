
package medicalRecord.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "returnRequestsResponse", namespace = "http://medicalRecord/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "returnRequestsResponse", namespace = "http://medicalRecord/")
public class ReturnRequestsResponse {

    @XmlElement(name = "return", namespace = "", nillable = true)
    private viewpoints.Requests[] _return;

    /**
     * 
     * @return
     *     returns Requests[]
     */
    public viewpoints.Requests[] getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(viewpoints.Requests[] _return) {
        this._return = _return;
    }

}
