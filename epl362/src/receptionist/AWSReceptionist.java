package receptionist;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.jws.WebMethod;
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

//@WebMethod
@WebService
public interface AWSReceptionist {

	/**
	 * Returns all the consultations.
	 * @return
	 */
@WebMethod
public  Consultations[] returnConsultations();
/**
 * 
 * Returns the consultation related to the id.
 * @param id
 * @return
 */
@WebMethod
public  Consultations returnConsultationsById(int id);
/**
 * Returns the most recent consultation of a patient givign patient id.
 * @param patientId
 * @return
 */
@WebMethod
public  Consultations returnMostRecentConsultationOfPatient(int patientId);
/**
 * Returns attented and not updated consultations.
 * @return
 */
@WebMethod
public  Consultations[] returnAttentedNotUpdatedConsultations();
/**
 * Returns not attented patients.
 * @return
 */
@WebMethod
public  Patient[] returnNotAttentedPatients();
@WebMethod
public boolean insertConsultation(Consultations toUse, String newParam);
@WebMethod
public boolean updateConsultation(Consultations toUse, String newParam);
@WebMethod
public void deleteConsultation(Consultations toUse, String newParam);
/**
 * Returns last prescription details.
 * @param patientId
 * @return
 */
@WebMethod
public PercriptionDetails[] returnLastPerscriptionDetailsByPId(int patientId);
@WebMethod
public boolean insertPerscriptionDetail(PercriptionDetails toUse, String newParam);
@WebMethod
public boolean insertPerscription(Perscription toUse, String newParam);
@WebMethod
public boolean insertTransaction(Transaction toUse);
@WebMethod
public boolean insertRequest(Requests toUse, String newParam);
/**
 * Inserts a new relative.
 * @param toUse
 * @param newParam username.
 * @return
 */
@WebMethod
public boolean insertRelative(Relatives toUse, String newParam);
/**
 * Updates a relative.
 * @param toUse
 * @param newParam
 * @return
 */
@WebMethod
public boolean updateRelative(Relatives toUse, String newParam);
@WebMethod
public void deleteRelative(Relatives toUse, String newParam);
/**
 * Returns all relatives by a patient id.
 * @param id
 * @return
 */
@WebMethod
public Relatives[] returnRelativesByPatientId(int id);
@WebMethod
public Patient returnPatientById(int id);
@WebMethod
public Patient[] returnAllPatients();
@WebMethod
public DoctorC[] returnDoctors();
@WebMethod
public Clinic[] returnClinics();
/**
 * Returns all the prescriptions
 * @return
 */
@WebMethod
public Perscription[] returnPrescriptions();

}
