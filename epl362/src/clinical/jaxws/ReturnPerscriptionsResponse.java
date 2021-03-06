
package clinical.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "returnPerscriptionsResponse", namespace = "http://clinical/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "returnPerscriptionsResponse", namespace = "http://clinical/")
public class ReturnPerscriptionsResponse {

    @XmlElement(name = "return", namespace = "", nillable = true)
    private viewpoints.Perscription[] _return;

    /**
     * 
     * @return
     *     returns Perscription[]
     */
    public viewpoints.Perscription[] getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(viewpoints.Perscription[] _return) {
        this._return = _return;
    }

}
