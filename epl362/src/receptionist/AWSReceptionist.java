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

@WebMethod
public  Consultations[] returnConsultations();
@WebMethod
public  Consultations returnConsultationsById(int id);
@WebMethod
public  Consultations returnMostRecentConsultationOfPatient(int patientId);
@WebMethod
public  Consultations[] returnAttentedNotUpdatedConsultations();
@WebMethod
public  Patient[] returnNotAttentedPatients();
@WebMethod
public boolean insertConsultation(Consultations toUse, String newParam);
@WebMethod
public boolean updateConsultation(Consultations toUse, String newParam);
@WebMethod
public void deleteConsultation(Consultations toUse, String newParam);
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
@WebMethod
public boolean insertRelative(Relatives toUse, String newParam);
@WebMethod
public boolean updateRelative(Relatives toUse, String newParam);
@WebMethod
public void deleteRelative(Relatives toUse, String newParam);
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
@WebMethod
public Perscription[] returnPrescriptions();

}
