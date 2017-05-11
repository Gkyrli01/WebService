package medicalRecord;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.jws.WebMethod;
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

//
@WebService
public interface AWSMedicalRecord {
	/**
	 * Returns all the requests.
	 * @return
	 */
	@WebMethod
	public Requests[] returnRequests();
	/**
	 * Returns all the transactions.
	 * @return
	 */
	@WebMethod
	public Transaction[] returnTransaction();
	@WebMethod
	public boolean updateRequest(Requests toUse, String newParam);
	@WebMethod
	public boolean updatePatient(Patient toUse, String newParam);
	@WebMethod
	public boolean insertPatient(Patient toUse, String newParam);
	@WebMethod
	public Patient[] returnPatients();
	/**
	 * Returns a patient by the id given.
	 * @param id
	 * @return
	 */
	@WebMethod
	public Patient returnPatientById(int id);
	@WebMethod
	public boolean insertPharmako(Pharmako toUse, String newParam);
	/**
	 * Inserts a pharmako side effects.
	 * @param toUse
	 * @param newParam
	 * @return
	 */
	@WebMethod
	public boolean insertPharmakoSideEffect(PharmakoSideEffects toUse, String newParam);
	@WebMethod
	public void deletePharmakoSideEffect(PharmakoSideEffects toUse, String newParam);
	/**
	 * Insert a pharmako treating capability
	 * @param toUse
	 * @param newParam
	 * @return
	 */
	@WebMethod
	public boolean insertPharmakoTreat(PharmakoTreats toUse, String newParam);
	@WebMethod
	public void deletePharmakoTreat(PharmakoTreats toUse, String newParam);
	/**
	 * Inserts a new sideeffect
	 * @param toUse
	 * @param newParam
	 * @return
	 */
	@WebMethod
	public boolean insertSideEffect(SideEffect toUse, String newParam);
	@WebMethod
	public void deleteToUse(User toUse, String newParam);
	@WebMethod
	public boolean insertUser(User toUse, String newParam);
	@WebMethod
	public boolean insertTransaction(Transaction toUse);
	@WebMethod
	public void deleteTransaction(Transaction toUse);
	
	/**
	 * Inserts a clinic
	 * @param toUse
	 * @param uname
	 * @return
	 */
	@WebMethod
	public boolean insertClinic(Clinic toUse, String uname);
	/**
	 * Deletes a clinic
	 * @param toUse
	 * @param uname
	 */
	@WebMethod
	public void deleteClinic(Clinic toUse, String uname);
	@WebMethod
	public boolean insertDoctor(DoctorC toUse, String uname);
	/**
	 * Deletes a doctor.
	 * @param toUse
	 * @param uname
	 */
	@WebMethod
	public void deleteDoctor(DoctorC toUse, String uname);
	@WebMethod
	public Clinic[] returnClinics();
	@WebMethod
	public Disease[] returnDisease();
	@WebMethod
	public SideEffect[] returnSideEffect();
	@WebMethod
	public DoctorC[] returnDoctors();
	/**
	 * Return all the treating capabilities by a pharmako name.
	 * @param pharmako
	 * @return
	 */
	@WebMethod
	public PharmakoTreats[] returnPharmakoTreats(String pharmako);
	/**
	 * Returns all side effects by a pharmako.
	 * @param pharmako
	 * @return
	 */
	@WebMethod
	public PharmakoSideEffects[] returnPharmakoSideEffects(String pharmako);
	@WebMethod
	public boolean insertDisease(Disease toUse, String newParam);
	
	
}
