package viewpoints;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Perscription")
public class Perscription {

	
/*
CREATE TABLE perscription(
patientId int NOT NULL,
startDate smalldatetime DEFAULT GETDATE(),
expDate smalldatetime,
id int IDENTITY(1,1) PRIMARY key NOT NULL,
)
*/
	
	
@XmlElement(name="patient")
public Patient patient;
@XmlElement(name="startDate")
public String startDate;
@XmlElement(name="expDate")
public String expDate;
@XmlElement(name="id")
public int id;
	

public Perscription() {
	// TODO Auto-generated constructor stub
}
public Perscription(int patientId,String dates,String dateE,int id) {

	patient=Patient.returnPatientById(patientId);
	startDate=dates;
	expDate=dateE;
	this.id=id;
}




public static String select="SELECT * FROM [webService].[dbo].[perscription]";
public static String delete="DELETE  FROM [webService].[dbo].[perscription]";
/**
 * Return a prescription by the id given.
 * @param id
 * @return
 */
public static Perscription returnPerscriptionById(int id) {
	GetConnection ok=new GetConnection();
	ok.getDBConnection();
	
	ResultSet pop=ok.select(select+" WHERE id="+id);
	try {
		return new Perscription(pop.getInt(1),pop.getString(2),pop.getString(3),pop.getInt(4));
	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	}
}

/**
 * Returns all the prescription.
 * @return
 */
public Perscription[] returnPerscription() {
	GetConnection ok=new GetConnection();
	ok.getDBConnection();
	ResultSet pop=ok.select(select);
	ArrayList<Perscription>arras=new ArrayList<Perscription>();
	
	try {
		
		pop.first();
		arras.add(new Perscription(pop.getInt(1),pop.getString(2),pop.getString(3),pop.getInt(4)));
		while(pop.next()){
			arras.add(new Perscription(pop.getInt(1),pop.getString(2),pop.getString(3),pop.getInt(4)));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	Perscription[] zwa=new Perscription[arras.size()];
	int i=0;
	for (Perscription doctor : arras) {
		zwa[i]=doctor;
		i++;
	}
	return zwa;
}

public int booleanToInt(boolean what) {
	if(what){
		return 1;
	}
	return 0;
}
public int checkNull(Object what) {
	if(what==null){
		return -1;
	}
	return 0;
}


/**
 * Inserts a prescription.
 * @return
 */
public boolean insert(){
	
	java.sql.Timestamp kk = new java.sql.Timestamp(java.sql.Timestamp.valueOf(startDate).getTime());
	java.sql.Timestamp kk1 = new java.sql.Timestamp(java.sql.Timestamp.valueOf(expDate).getTime());

	GetConnection ok=new GetConnection();
	ok.getDBConnection();
	ResultSet pop=ok.select(select);
	try {
		pop.moveToInsertRow();
		pop.updateInt(1, patient.id);
		pop.updateTimestamp(2, kk);
		pop.updateTimestamp(3, kk1);


		pop.insertRow();
		return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	//return "INSERT INTO Doctor VALUES ('"+doctorName+"')";
}

public boolean update(){

	java.sql.Timestamp kk = new java.sql.Timestamp(java.sql.Timestamp.valueOf(startDate).getTime());
	java.sql.Timestamp kk1 = new java.sql.Timestamp(java.sql.Timestamp.valueOf(expDate).getTime());

	GetConnection ok=new GetConnection();
	ok.getDBConnection();
	
	ResultSet pop=ok.select(select+" WHERE id="+id);
	try {
		pop.updateInt(1, patient.id);
		pop.updateTimestamp(2, kk);
		pop.updateTimestamp(3, kk1);


		pop.updateRow();
		return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
}
public void delete(){		
	GetConnection ok=new GetConnection();
	ok.getDBConnection();		
	ok.delete(delete+" WHERE id="+id);					
}
/*
	public static void main(String[] args) {
		Perscription ok=new Perscription(3, "2010-10-11 00:09:13", "2010-11-11 00:11:12", 1);
		ok.insert();
		//ok.update();
		//ok.delete();
		System.out.println(ok.returnPerscription()[0].startDate);
		System.out.println(ok.returnPerscription()[0].patient.Description);

	}*/
}
