
package clinical.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "insertPerscriptionDetails", namespace = "http://clinical/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertPerscriptionDetails", namespace = "http://clinical/", propOrder = {
    "arg0",
    "arg1"
})
public class InsertPerscriptionDetails {

    @XmlElement(name = "arg0", namespace = "")
    private viewpoints.PercriptionDetails arg0;
    @XmlElement(name = "arg1", namespace = "")
    private String arg1;

    /**
     * 
     * @return
     *     returns PercriptionDetails
     */
    public viewpoints.PercriptionDetails getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(viewpoints.PercriptionDetails arg0) {
        this.arg0 = arg0;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getArg1() {
        return this.arg1;
    }

    /**
     * 
     * @param arg1
     *     the value for the arg1 property
     */
    public void setArg1(String arg1) {
        this.arg1 = arg1;
    }

}
