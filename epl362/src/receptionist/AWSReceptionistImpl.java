package receptionist;

import javax.jws.WebService;

import viewpoints.Clinic;
import viewpoints.Consultations;
import viewpoints.DoctorC;
import viewpoints.Patient;
import viewpoints.PercriptionDetails;
import viewpoints.Perscription;
import viewpoints.Relatives;
import viewpoints.Requests;
import viewpoints.Transaction;

@WebService(endpointInterface="receptionist.AWSReceptionist")
public class AWSReceptionistImpl implements AWSReceptionist {

	public Consultations[] returnConsultations() {
		return new Consultations().returnConsultations();
	}
	public Consultations returnConsultationsById(int id) {
		return Consultations.returnConsultationsById(id);
	}
	public Consultations returnMostRecentConsultationOfPatient(int patientId) {
		return Consultations.returnMostRecentConsultationOfPatient(patientId);
	}
	public Consultations[] returnAttentedNotUpdatedConsultations() {
		return Consultations.returnAttentedNotUpdatedConsultations(Consultations.getYesterdayDateString(),Consultations.getTodayDateString());
	}
	public Patient[] returnNotAttentedPatients() {
		return Consultations.returnNotAttentedPatients(Consultations.getYesterdayDateString(),Consultations.getTodayDateString());
	}
	public boolean insertConsultation(Consultations toUse, String newParam) {
		insertTransaction(new Transaction(newParam, "Inserting Consultation", 0));
		return toUse.insert();
	}
	public boolean updateConsultation(Consultations toUse, String newParam) {
		insertTransaction(new Transaction(newParam, "Updating Consultation", 0));
		return toUse.update();
	}
	public void deleteConsultation(Consultations toUse, String newParam) {
		insertTransaction(new Transaction(newParam, "Deleting Consultation", 0));
		toUse.delete();
	}
	public PercriptionDetails[] returnLastPerscriptionDetailsByPId(int patientId) {
		return PercriptionDetails.returnLastPerscriptionDetailsByPId(patientId);
	}
	public boolean insertPerscriptionDetail(PercriptionDetails toUse, String newParam) {
		insertTransaction(new Transaction(newParam, "Inserting PrescriptionDetail", 0));
		return toUse.insert();
	}
	public boolean insertPerscription(Perscription toUse, String newParam) {
		insertTransaction(new Transaction(newParam, "Inserting Prescription,PId:"+toUse.patient.id, 0));
		return toUse.insert();
	}
	public boolean insertTransaction(Transaction toUse) {
		
		return toUse.insert();
	}
	public boolean insertRequest(Requests toUse, String newParam) {
		insertTransaction(new Transaction(newParam, "Inserting Request,PId:"+toUse.patient.id, 0));
		return toUse.insert();
	}
	public boolean insertRelative(Relatives toUse, String newParam) {
		insertTransaction(new Transaction(newParam, "Inserting Relative"+toUse.name, 0));
		return toUse.insert();
	}
	public boolean updateRelative(Relatives toUse, String newParam) {
		insertTransaction(new Transaction(newParam, "Updating Relative"+toUse.name, 0));
		return toUse.update();
	}
	public void deleteRelative(Relatives toUse, String newParam) {
		insertTransaction(new Transaction(newParam, "Deleting Relative"+toUse.name, 0));
		toUse.delete();
	}
	public Relatives[] returnRelativesByPatientId(int id) {
		return new Relatives().returnRelativesByPatientId(id);
	}
	public Patient[] returnAllPatients() {
		return new Patient().returnPatients();
	}
	public Clinic[] returnClinics() {
		Clinic ola=new Clinic();
		return ola.returnClinics();
	}

	public DoctorC[] returnDoctors() {
		DoctorC ola=new DoctorC();
		return ola.returnDoctors();
	}
	public Patient returnPatientById(int id) {
		return Patient.returnPatientById(id);
	}
	@Override
	public Perscription[] returnPrescriptions() {
		return new Perscription().returnPerscription();

	}

}
