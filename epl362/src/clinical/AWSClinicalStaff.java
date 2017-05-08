package clinical;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.jws.WebMethod;
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

//@WebMethod
@WebService
public interface AWSClinicalStaff {
	@WebMethod
	public Patient returnPatientById(int id);
	@WebMethod
	public Patient[] returnAllPatients();
	@WebMethod
	public Consultations returnById(int id);
	@WebMethod
	public Consultations returnMostRecentConsultationOfPatient(int patientId);
	@WebMethod
	public  Consultations[] returnAttentedNotUpdatedConsultations();
	@WebMethod
	public  Patient[] returnNotAttentedPatients();
	@WebMethod
	public boolean updateConsultations(Consultations toUse, String newParam);
	@WebMethod
	public void deleteConsults(Consultations toUse, String newParam);
	@WebMethod
	public boolean updatePatients(Patient toUse, String newParam);
	@WebMethod
	public void deletePatient(Patient toUse, String newParam);
	@WebMethod
	public Disease[] returnDiseases();
	@WebMethod
	public DoctorC[] returnDoctors();
	@WebMethod
	public PercriptionDetails[] returnLastPerscriptionDetailsByPId(int patientId);
	@WebMethod
	public PatientSideEffects[] returnPatientSideEffectsByPatientId(int id);
	@WebMethod
	public Clinic[] returnClinics();
	@WebMethod
	public boolean insertPerscription(Perscription toUse, String newParam);
	@WebMethod
	public boolean updatePerscription(Perscription toUse, String newParam);
	@WebMethod
	public boolean insertPerscriptionDetails(PercriptionDetails toUse, String newParam);
	@WebMethod
	public void deletePerscrtiptionDetails(PercriptionDetails toUse, String newParam);
	@WebMethod
	public Pharmako[] returnPharmako();
	@WebMethod
	public boolean insertTransaction(Transaction toUse);
	@WebMethod
	public boolean insertOverrule(Overrule toUse, String newParam);
	@WebMethod
	public  boolean returnPatientAllergy(int patientId,String pharmako);
	@WebMethod
	public  PharmakoTreats[] returnPharmakoTreatsByDrugName(String name);
	@WebMethod
	public PharmakoSideEffects[] returnPharmakoSideEffectsbyName(String name);
	@WebMethod
	public boolean updateSelfHarmIncident(SelfHarmIncident toUse, String newParam);
	@WebMethod
	public boolean insertSelfHarmIncident(SelfHarmIncident toUse, String newParam);
	@WebMethod
	public void deleteSelfHarmIncident(SelfHarmIncident toUse, String newParam);
	@WebMethod
	public SelfHarmIncident[] returnSelfHarmIncidentByPatientId(int id);
	@WebMethod
	public boolean insertPatientSideEffects(PatientSideEffects toUse, String newParam) ;
	@WebMethod
	public SideEffect[] returnSideEffects();
	@WebMethod
	public Perscription[] returnPerscriptions();
	@WebMethod
	public void deletePatientSideEffects(PatientSideEffects toUse, String newParam);
}
