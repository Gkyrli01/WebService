
package clinical.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "returnByIdResponse", namespace = "http://clinical/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "returnByIdResponse", namespace = "http://clinical/")
public class ReturnByIdResponse {

    @XmlElement(name = "return", namespace = "")
    private viewpoints.Consultations _return;

    /**
     * 
     * @return
     *     returns Consultations
     */
    public viewpoints.Consultations getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(viewpoints.Consultations _return) {
        this._return = _return;
    }

}
