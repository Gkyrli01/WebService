package viewpoints;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Relatives")
public class Relatives {

	/*
	 * 
CREATE TABLE Relatives(
patientId int NOT NULL,
Rname nvarchar(50) NOT NULL,
phone int,
RelativeNumber int IDENTITY(1,1) PRIMARY key
)

	 */
	@XmlElement(name="patient")
	public Patient patient;
	@XmlElement(name="name")
	public String name;
	@XmlElement(name="phone")
	public int phone;
	@XmlElement(name="id")
	public int id;




public static String select="SELECT * FROM [webService].[dbo].[Relatives]";
public static String delete="DELETE  FROM [webService].[dbo].[Relatives]";

	
	
	public Relatives(int patientId,String name,int phone,int id) {
		this.patient=Patient.returnPatientById(patientId);
		this.name=name;
		this.phone=phone;
		this.id=id;
	}
	
	public Relatives() {
		// TODO Auto-generated constructor stub
	}

public static Relatives returnRelativesById(int id) {
	GetConnection ok=new GetConnection();
	ok.getDBConnection();
	
	ResultSet pop=ok.select(select+" WHERE RelativeNumber="+id);
	try {
		return new Relatives(pop.getInt(1),pop.getString(2),pop.getInt(3),pop.getInt(4));
	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	}
}


public Relatives[] returnRelativesByPatientId(int id) {
	GetConnection ok=new GetConnection();
	ok.getDBConnection();
	ResultSet pop=ok.select(select+" WHERE patientId="+id);
	ArrayList<Relatives>arras=new ArrayList<Relatives>();
	
	try {
		
		pop.first();
		arras.add(new Relatives(pop.getInt(1),pop.getString(2),pop.getInt(3),pop.getInt(4)));
		while(pop.next()){
			arras.add(new Relatives(pop.getInt(1),pop.getString(2),pop.getInt(3),pop.getInt(4)));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	Relatives[] zwa=new Relatives[arras.size()];
	int i=0;
	for (Relatives doctor : arras) {
		zwa[i]=doctor;
		i++;
	}
	return zwa;
}



public Relatives[] returnRelatives() {
	GetConnection ok=new GetConnection();
	ok.getDBConnection();
	ResultSet pop=ok.select(select);
	ArrayList<Relatives>arras=new ArrayList<Relatives>();
	
	try {
		
		pop.first();
		arras.add(new Relatives(pop.getInt(1),pop.getString(2),pop.getInt(3),pop.getInt(4)));
		while(pop.next()){
			arras.add(new Relatives(pop.getInt(1),pop.getString(2),pop.getInt(3),pop.getInt(4)));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	Relatives[] zwa=new Relatives[arras.size()];
	int i=0;
	for (Relatives doctor : arras) {
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



public boolean insert(){

	GetConnection ok=new GetConnection();
	ok.getDBConnection();
	ResultSet pop=ok.select(select);
	try {
		pop.moveToInsertRow();
		pop.updateInt(1, patient.id);
		pop.updateString(2, name);
		pop.updateInt(3, phone);


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

	GetConnection ok=new GetConnection();
	ok.getDBConnection();
	
	ResultSet pop=ok.select(select+" WHERE RelativeNumber="+id);
	try {
		pop.updateInt(1, patient.id);
		pop.updateString(2, name);
		pop.updateInt(3, phone);
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
	ok.delete(delete+" WHERE RelativeNumber="+id);					
}
	/*
	public static void main(String[] args) {
		Relatives kokos=new Relatives(3, "Ola",99999999, 1);
		kokos.insert();
		System.out.println(kokos.returnRelativesByPatientId(3)[0].name);
		
		kokos.phone=9000000;
		kokos.update();
		System.out.println(returnRelativesById(1).phone);
		
		kokos.delete();
		
	}
	*/
}
