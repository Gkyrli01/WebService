
package medicalRecord.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "returnPharmakoTreatsResponse", namespace = "http://medicalRecord/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "returnPharmakoTreatsResponse", namespace = "http://medicalRecord/")
public class ReturnPharmakoTreatsResponse {

    @XmlElement(name = "return", namespace = "", nillable = true)
    private viewpoints.PharmakoTreats[] _return;

    /**
     * 
     * @return
     *     returns PharmakoTreats[]
     */
    public viewpoints.PharmakoTreats[] getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(viewpoints.PharmakoTreats[] _return) {
        this._return = _return;
    }

}
