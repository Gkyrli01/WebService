
package healthService.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "returnDiseasesResponse", namespace = "http://healthService/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "returnDiseasesResponse", namespace = "http://healthService/")
public class ReturnDiseasesResponse {

    @XmlElement(name = "return", namespace = "", nillable = true)
    private viewpoints.Disease[] _return;

    /**
     * 
     * @return
     *     returns Disease[]
     */
    public viewpoints.Disease[] getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(viewpoints.Disease[] _return) {
        this._return = _return;
    }

}
