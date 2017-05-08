package medicalRecord;

import javax.jws.WebService;

import viewpoints.Clinic;
import viewpoints.Disease;
import viewpoints.DoctorC;
import viewpoints.Patient;
import viewpoints.Pharmako;
import viewpoints.PharmakoSideEffects;
import viewpoints.PharmakoTreats;
import viewpoints.Requests;
import viewpoints.SideEffect;
import viewpoints.Transaction;
import viewpoints.User;

@WebService(endpointInterface="medicalRecord.AWSMedicalRecord")
public class AWSMedicalRecordImpl implements AWSMedicalRecord {

	
	public Requests[] returnRequests() {
		Requests ola=new Requests();
		return ola.returnRequests();
	}

	public Transaction[] returnTransaction() {
		Transaction ola=new Transaction();
		return ola.returnTransaction();
	}

	public boolean updateRequest(Requests toUse, String newParam) {
		insertTransaction(new Transaction(newParam, "Updating Request of pid:"+toUse.patient.id, 0));
		return toUse.update();
	}

	public boolean updatePatient(Patient toUse, String newParam) {
		insertTransaction(new Transaction(newParam, "Updating Patient"+toUse.name, 0));
		return toUse.update();
	}

	public boolean insertPatient(Patient toUse, String newParam) {
		insertTransaction(new Transaction(newParam, "Inserting Patient"+toUse.name, 0));
		return toUse.insert();
	}

	public Patient[] returnPatients() {
		return new Patient().returnPatients();
	}

	public Patient returnPatientById(int id) {
		return Patient.returnPatientById(id);
	}

	public boolean insertPharmako(Pharmako toUse, String newParam) {
		insertTransaction(new Transaction(newParam, "Inserting Pharmako", 0));
		return toUse.insert();
	}

	public boolean insertPharmakoSideEffect(PharmakoSideEffects toUse, String newParam) {
		insertTransaction(new Transaction(newParam, "Inserting Pharmako side effect", 0));
		return toUse.insert();
	}

	public void deletePharmakoSideEffect(PharmakoSideEffects toUse, String newParam) {
		insertTransaction(new Transaction(newParam, "Deleting Pharmako side effect", 0));
		toUse.delete();
	}

	public boolean insertPharmakoTreat(PharmakoTreats toUse, String newParam) {
		insertTransaction(new Transaction(newParam, "Inserting Pharmako treats", 0));
		return toUse.insert();
	}

	public void deletePharmakoTreat(PharmakoTreats toUse, String newParam) {
		insertTransaction(new Transaction(newParam, " Deleting Pharmako treats", 0));
		toUse.delete();
	}

	public boolean insertSideEffect(SideEffect toUse, String newParam) {
		insertTransaction(new Transaction(newParam, "Inserting Side effect"+toUse.name, 0));
		return toUse.insert();
	}

	public void deleteToUse(User toUse, String newParam) {
		insertTransaction(new Transaction(newParam, "Deleting User", 0));
		toUse.delete();
	}

	public boolean insertUser(User toUse, String newParam) {
		if(toUse.insert()){
			insertTransaction(new Transaction(newParam, "Inserting User", 0));
			return true;
		}
		return false;
	}

	public boolean insertTransaction(Transaction toUse) {
		return toUse.insert();
	}

	public void deleteTransaction(Transaction toUse) {
		toUse.delete();
	}

	public boolean insertClinic(Clinic toUse, String uname) {
		insertTransaction(new Transaction(uname, "Inserted Clinic", 0));
		return toUse.insert();
	}

	public void deleteClinic(Clinic toUse, String uname) {
		insertTransaction(new Transaction(uname, "Deleted Clinic", 0));
		toUse.delete();
	}

	@Override
	public boolean insertDoctor(DoctorC toUse, String uname) {
		insertTransaction(new Transaction(uname, "Inserting Doctor"+toUse.doctorName, 0));
		return toUse.insert();
	}

	@Override
	public void deleteDoctor(DoctorC toUse, String uname) {
		insertTransaction(new Transaction(uname, "Deleted Doctor"+toUse.doctorName, 0));
		toUse.delete();
	}

	@Override
	public Clinic[] returnClinics() {
		return new Clinic().returnClinics();
	}

	@Override
	public Disease[] returnDisease() {
		return new Disease().returnDiseases();
	}

	@Override
	public SideEffect[] returnSideEffect() {
		return new SideEffect().returnSideEffect();
	}

	@Override
	public DoctorC[] returnDoctors() {
		return new DoctorC().returnDoctors();
	}

	public PharmakoTreats[] returnPharmakoTreats(String pharmako) {
		return 	PharmakoTreats.returnPharmakoTreatsByDrugName(pharmako);
	}

	public PharmakoSideEffects[] returnPharmakoSideEffects(String pharmako) {
		return PharmakoSideEffects.returnPharmakoSideEffectsbyName(pharmako);
	}

	public boolean insertDisease(Disease toUse, String newParam) {
		return toUse.insert();
	}

	
}
