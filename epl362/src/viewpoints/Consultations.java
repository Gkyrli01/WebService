package viewpoints;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Consultations")
public class Consultations {

/*
CREATE TABLE Consultations(
patientId int not NULL,
DoctorId int,
DateHappening smalldatetime NOT NULL,
attended bit DEFAULT 0 Not NUll,
wasDropin bit DEFAULT 0,
perscriptioId int,
clinicName nvarchar(50),
ConsultationId int IDENTITY(1,1) PRIMARY KEY
)

	
	
	*/
@XmlElement(name="patient")	
public Patient patient;	
@XmlElement(name="doctorC")
public DoctorC doctorC;
@XmlElement(name="date")
public String date;
@XmlElement(name="attented")
public int attended;
@XmlElement(name="dropin")
public int dropin;
@XmlElement(name="perscriptioId")
public Perscription perscriptioId;
@XmlElement(name="clinic")
public Clinic clinic;
@XmlElement(name="updated")
public int updated;
@XmlElement(name="consultationId")
public int consultationId;


public static String select="SELECT * FROM [webService].[dbo].[Consultations]";
public static String delete="DELETE  FROM [webService].[dbo].[Consultations]";

//current.updateTimestamp(i+2,new java.sql.Timestamp(System.currentTimeMillis()));
//java.sql.Timestamp kk = new java.sql.Timestamp(java.sql.Timestamp.valueOf(
//edits.get(z).getText()+ " 00:00:00").getTime());

public Consultations() {
	// TODO Auto-generated constructor stub
}


public Consultations(int patient,int doctorId,String theDate,int attend,int drop,int perId,String clinic,int update, int id){
	this.patient=Patient.returnPatientById(patient);
	doctorC= DoctorC.returnDoctorById(doctorId);
	date=theDate;
	attended=attend;
	dropin=drop;
	this.updated=update;
	this.perscriptioId=Perscription.returnPerscriptionById(perId);
	this.clinic=Clinic.returnClinicByName(clinic);
	consultationId=id;
	//per
}

/**
 * Returns all the consultations.
 * @return
 */
public Consultations[] returnConsultations() {
	GetConnection ok=new GetConnection();
	ok.getDBConnection();
	ResultSet pop=ok.select(select);
	ArrayList<Consultations>arras=new ArrayList<Consultations>();
	
	try {
		pop.first();
		arras.add(new Consultations(pop.getInt(1), pop.getInt(2),pop.getString(3),pop.getInt(4),pop.getInt(5),pop.getInt(6),pop.getString(7),pop.getInt(8),pop.getInt(9)));
		while(pop.next()){
			arras.add(new Consultations(pop.getInt(1), pop.getInt(2),pop.getString(3),pop.getInt(4),pop.getInt(5),pop.getInt(6),pop.getString(7),pop.getInt(8),pop.getInt(9)));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Consultations[] zwa=new Consultations[arras.size()];
	int i=0;
	for (Consultations doctor : arras) {
		zwa[i]=doctor;
		i++;
	}
	return zwa;
}
/**
 * Returns a consultation based on the id given
 * @param id
 * @return
 */
public static Consultations returnConsultationsById(int id) {
	GetConnection ok=new GetConnection();
	ok.getDBConnection();
	
	ResultSet pop=ok.select(select+" WHERE ConsultationId="+id);
	try {
		return new Consultations(pop.getInt(1), pop.getInt(2),pop.getString(3),pop.getInt(4),pop.getInt(5),pop.getInt(6),pop.getString(7),pop.getInt(8),pop.getInt(9));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}

/**
 * Return most recent Consultation of patient.
 * @param patientId
 * @return
 */
public static Consultations returnMostRecentConsultationOfPatient(int patientId)
{
	GetConnection ole=new GetConnection();
	Connection conn=ole.getDBConnection();
	try {
		CallableStatement cstmt = conn.prepareCall("{call dbo.MostRecent(?)}");
		cstmt.setInt(1,patientId);
		ResultSet pop=cstmt.executeQuery();
		while(pop.next()){
			return returnConsultationsById(pop.getInt(1));
		}
		
		//System.out.println("MANAGER ID: " + cstmt.get(2));
		cstmt.close();
		return null;
		
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		return null;
	}
	
}
//[AttentedNotUpdated]

/**
 * Returns attended and not updated consultations between two dates.
 * @param startD
 * @param endD
 * @return
 */
public static Consultations[] returnAttentedNotUpdatedConsultations(String startD,String endD)
{
	ArrayList<Consultations>arras=new ArrayList<Consultations>();

	GetConnection ole=new GetConnection();
	Connection conn=ole.getDBConnection();
	try {
		CallableStatement cstmt = conn.prepareCall("{call dbo.AttentedNotUpdated(?,?)}");
		cstmt.setString(1,startD);
		cstmt.setString(2, endD);
		ResultSet pop=cstmt.executeQuery();
		while(pop.next()){
			arras.add(Consultations.returnConsultationsById(pop.getInt(2)));
		}
		Consultations[] zwa=new Consultations[arras.size()];
		int i=0;
		for (Consultations doctor : arras) {
			zwa[i]=doctor;
			i++;
		}
		
		
		cstmt.close();
		return zwa;
		
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		return null;
	}
	
}

/**
 * Returns not attended patients between two dates.
 * @param startD
 * @param endD
 * @return
 */
public static Patient[] returnNotAttentedPatients(String startD,String endD)
{
	ArrayList<Patient>arras=new ArrayList<Patient>();

	GetConnection ole=new GetConnection();
	Connection conn=ole.getDBConnection();
	try {
		CallableStatement cstmt = conn.prepareCall("{call dbo.notAttented(?,?)}");
		cstmt.setString(1,startD);
		cstmt.setString(2, endD);
		ResultSet pop=cstmt.executeQuery();
		while(pop.next()){
			arras.add(Patient.returnPatientById(pop.getInt(1)));
		}
		Patient[] zwa=new Patient[arras.size()];
		int i=0;
		for (Patient doctor : arras) {
			zwa[i]=doctor;
			i++;
		}
		
		
		cstmt.close();
		return zwa;
		
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		return null;
	}
	
}
/**
 * Inserts a consultation.
 * @return
 */
public boolean insert(){

	java.sql.Timestamp kk = new java.sql.Timestamp(java.sql.Timestamp.valueOf(date).getTime());

	GetConnection ok=new GetConnection();
	ok.getDBConnection();
	ResultSet pop=ok.select(select);
	try {
		pop.moveToInsertRow();
		pop.updateInt(1, patient.id);
		if(doctorC!=null)
			pop.updateInt(2, doctorC.id);
		pop.updateTimestamp(3,kk);
		pop.updateInt(4, attended);
		pop.updateInt(5, dropin);
		if(perscriptioId!=null)
		pop.updateInt(6,perscriptioId.id);
		if(clinic!=null)
			pop.updateString(7, clinic.name);
		pop.updateInt(8, updated);
		pop.insertRow();
		return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	//return "INSERT INTO Doctor VALUES ('"+doctorName+"')";
}
/**
 * Updates a consultation.
 * @return
 */
public boolean update(){
	java.sql.Timestamp kk = new java.sql.Timestamp(java.sql.Timestamp.valueOf(date).getTime());

	//System.out.println(select+" WHERE DoctorId="+id);
	GetConnection ok=new GetConnection();
	ok.getDBConnection();
	
	ResultSet pop=ok.select(select+" WHERE ConsultationId="+consultationId);
	try {
		pop.updateInt(1, patient.id);
		if(doctorC!=null)
			pop.updateInt(2, doctorC.id);
		pop.updateTimestamp(3,kk);
		pop.updateInt(4, attended);
		pop.updateInt(5, dropin);
		if(perscriptioId!=null)
		pop.updateInt(6,perscriptioId.id);
		if(clinic!=null)
			pop.updateString(7, clinic.name);
		pop.updateInt(8, updated);
		pop.updateRow();
		return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
}
/**
 * deletes a consultation.
 */
public void delete(){		
	GetConnection ok=new GetConnection();
	ok.getDBConnection();		
	ok.delete(delete+" WHERE ConsultationId="+consultationId);
		
	
}

public static Date yesterday() {
    final Calendar cal = Calendar.getInstance();
    cal.set(Calendar.HOUR_OF_DAY, 0);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);

    cal.add(Calendar.DATE, -3);
    return cal.getTime();
}
public static Date today() {
    final Calendar cal = Calendar.getInstance();
    cal.set(Calendar.HOUR_OF_DAY, 0);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    return cal.getTime();
}
	public static String getYesterdayDateString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/dd/MM HH:mm:ss");
        return dateFormat.format(yesterday());
	}
	public static String getTodayDateString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/dd/MM HH:mm:ss");
        return dateFormat.format(today());
	}
	/*
public static void main(String[] args) {
	
	System.out.println(returnAttentedNotUpdatedConsultations(getYesterdayDateString(), getTodayDateString())[0].patient.Description);
	
	
}*/

}
