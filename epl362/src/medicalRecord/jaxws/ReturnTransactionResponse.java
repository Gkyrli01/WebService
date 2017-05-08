
package medicalRecord.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "returnTransactionResponse", namespace = "http://medicalRecord/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "returnTransactionResponse", namespace = "http://medicalRecord/")
public class ReturnTransactionResponse {

    @XmlElement(name = "return", namespace = "", nillable = true)
    private viewpoints.Transaction[] _return;

    /**
     * 
     * @return
     *     returns Transaction[]
     */
    public viewpoints.Transaction[] getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(viewpoints.Transaction[] _return) {
        this._return = _return;
    }

}
