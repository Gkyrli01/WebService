
package clinical.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "returnSideEffectsResponse", namespace = "http://clinical/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "returnSideEffectsResponse", namespace = "http://clinical/")
public class ReturnSideEffectsResponse {

    @XmlElement(name = "return", namespace = "", nillable = true)
    private viewpoints.SideEffect[] _return;

    /**
     * 
     * @return
     *     returns SideEffect[]
     */
    public viewpoints.SideEffect[] getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(viewpoints.SideEffect[] _return) {
        this._return = _return;
    }

}
