
package medicalRecord.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "deleteTransaction", namespace = "http://medicalRecord/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteTransaction", namespace = "http://medicalRecord/")
public class DeleteTransaction {

    @XmlElement(name = "arg0", namespace = "")
    private viewpoints.Transaction arg0;

    /**
     * 
     * @return
     *     returns Transaction
     */
    public viewpoints.Transaction getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(viewpoints.Transaction arg0) {
        this.arg0 = arg0;
    }

}
