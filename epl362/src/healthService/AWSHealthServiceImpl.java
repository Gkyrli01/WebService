package healthService;

import javax.jws.WebService;

import viewpoints.Disease;
import viewpoints.HealthReport;
import viewpoints.Perscription;
import viewpoints.Pharmako;

@WebService(endpointInterface="healthService.AWSHealthService")
public class AWSHealthServiceImpl implements AWSHealthService {

	public Perscription[] returnPrescritpions() {
		return new Perscription().returnPerscription();
	}

	
	public Pharmako[] returnPharmaka() {
		return new Pharmako().returnPharmako();
	}

	public Disease[] returnDiseases() {
		return new Disease("").returnDiseases();
	}

	public String returnReport() {
		return HealthReport.returnReport("", "");
	}

}
