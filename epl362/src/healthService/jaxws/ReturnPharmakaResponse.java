
package healthService.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "returnPharmakaResponse", namespace = "http://healthService/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "returnPharmakaResponse", namespace = "http://healthService/")
public class ReturnPharmakaResponse {

    @XmlElement(name = "return", namespace = "", nillable = true)
    private viewpoints.Pharmako[] _return;

    /**
     * 
     * @return
     *     returns Pharmako[]
     */
    public viewpoints.Pharmako[] getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(viewpoints.Pharmako[] _return) {
        this._return = _return;
    }

}
