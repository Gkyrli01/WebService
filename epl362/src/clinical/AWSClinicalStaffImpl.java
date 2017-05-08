package clinical;

import javax.jws.WebService;

import viewpoints.Clinic;
import viewpoints.Consultations;
import viewpoints.Disease;
import viewpoints.DoctorC;
import viewpoints.Overrule;
import viewpoints.Patient;
import viewpoints.PatientSideEffects;
import viewpoints.PercriptionDetails;
import viewpoints.Perscription;
import viewpoints.Pharmako;
import viewpoints.PharmakoSideEffects;
import viewpoints.PharmakoTreats;
import viewpoints.SelfHarmIncident;
import viewpoints.SideEffect;
import viewpoints.Transaction;

@WebService(endpointInterface="clinical.AWSClinicalStaff")
public class AWSClinicalStaffImpl implements AWSClinicalStaff {

	public Patient returnPatientById(int id) {
		return Patient.returnPatientById(id);
	}

	public Patient[] returnAllPatients() {
		return new Patient().returnPatients();
	}

	public Consultations returnById(int id) {
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

	public boolean updateConsultations(Consultations toUse, String newParam) {
		insertTransaction(new Transaction(newParam, "Updating Consultation", 0));
		return toUse.update();
	}

	public void deleteConsults(Consultations toUse, String newParam) {
		insertTransaction(new Transaction(newParam, "Deleting Consultation", 0));
		toUse.delete();
	}

	public boolean updatePatients(Patient toUse, String newParam) {
		insertTransaction(new Transaction(newParam, "Updating Patient : "+toUse.id, 0));
		return toUse.update();
	}

	public void deletePatient(Patient toUse, String newParam) {
		insertTransaction(new Transaction(newParam, "Deleting Patient : "+toUse.name, 0));
		 toUse.delete();
	}

	public Disease[] returnDiseases() {
		Disease ola=new Disease("");
		return ola.returnDiseases();
	}

	
	public DoctorC[] returnDoctors() {
		DoctorC ola=new DoctorC();
		return ola.returnDoctors();
	}

	public PercriptionDetails[] returnLastPerscriptionDetailsByPId(int patientId) {
		return PercriptionDetails.returnLastPerscriptionDetailsByPId(patientId);
	}

	public PatientSideEffects[] returnPatientSideEffectsByPatientId(int id) {
		return PatientSideEffects.returnPatientSideEffectsByPatient(id);
	}

	public Clinic[] returnClinics() {
		Clinic ola=new Clinic();
		return ola.returnClinics();
	}

	public boolean insertPerscription(Perscription toUse, String newParam) {
		insertTransaction(new Transaction(newParam, "Inserting Prescription", 0));

		return toUse.insert();
	}

	public boolean updatePerscription(Perscription toUse, String newParam) {
		insertTransaction(new Transaction(newParam, "Updating Prescription PeID: "+toUse.id, 0));
		return toUse.update();
	}

	public boolean insertPerscriptionDetails(PercriptionDetails toUse, String newParam) {
		insertTransaction(new Transaction(newParam, "Inserting Prescription Detail,PatientId: "+toUse.perscription.patient.id, 0));
		return toUse.insert();
	}

	
	public void deletePerscrtiptionDetails(PercriptionDetails toUse, String newParam) {
		insertTransaction(new Transaction(newParam, "Deleting Prescription Detail,PatientId: "+toUse.perscription.patient.id, 0));
		toUse.delete();
	}

	public Pharmako[] returnPharmako() {
		Pharmako ola=new Pharmako("");
		return ola.returnPharmako();
	}

	public boolean insertTransaction(Transaction toUse) {
		return toUse.insert();
	}

	public boolean insertOverrule(Overrule toUse, String newParam) {
		insertTransaction(new Transaction(newParam, "Inserting Overrule,PatientId: "+toUse.patient.id, 0));
		return toUse.insert();
	}

	public boolean returnPatientAllergy(int patientId, String pharmako) {
		return Patient.returnPatientAllergy(patientId, pharmako);
	}

	public PharmakoTreats[] returnPharmakoTreatsByDrugName(String name) {
		return PharmakoTreats.returnPharmakoTreatsByDrugName(name);
	}

	public PharmakoSideEffects[] returnPharmakoSideEffectsbyName(String name) {
		return PharmakoSideEffects.returnPharmakoSideEffectsbyName(name);
	}

	public boolean updateSelfHarmIncident(SelfHarmIncident toUse, String newParam) {
		insertTransaction(new Transaction(newParam, "Updating SelfHarmIncident,PatientId: "+toUse.patient.id, 0));
		return toUse.update();
	}

	public boolean insertSelfHarmIncident(SelfHarmIncident toUse, String newParam) {
		insertTransaction(new Transaction(newParam, "Inserting SelfHarmIncident,PatientId: "+toUse.patient.id, 0));
		return toUse.insert();
	}

	public void deleteSelfHarmIncident(SelfHarmIncident toUse, String newParam) {
		insertTransaction(new Transaction(newParam, "Deleting SelfHarmIncident,PatientId: "+toUse.patient.id, 0));
		toUse.delete();
	}

	public SelfHarmIncident[] returnSelfHarmIncidentByPatientId(int id) {
		SelfHarmIncident ola=new SelfHarmIncident();
		return ola.returnSelfHarmIncidentByPatientId(id);
	}
	public boolean insertPatientSideEffects(PatientSideEffects toUse, String newParam) {
		insertTransaction(new Transaction(newParam, "Inserting patientSideEffect,PatientId: "+toUse.patient.id, 0));
		return toUse.insert();
	}

	public SideEffect[] returnSideEffects() {
		
		return new SideEffect().returnSideEffect();
	}

	public Perscription[] returnPerscriptions() {
		return new Perscription().returnPerscription();
	}

	public Consultations[] returnConsultations() {
		return new Consultations().returnConsultations();
	}

	public void deletePatientSideEffects(PatientSideEffects toUse, String newParam) {
		insertTransaction(new Transaction(newParam, "Deleting patientSideEffect,PatientId: "+toUse.patient.id, 0));
		toUse.delete();
	}
}
