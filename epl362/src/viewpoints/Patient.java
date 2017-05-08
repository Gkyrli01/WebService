package viewpoints;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Patient")
public class Patient {
	
	@XmlElement(name="name")
	public String name;
	@XmlElement(name="doctor")
	public DoctorC doctor;
	@XmlElement(name="id")
	public int id;
	@XmlElement(name="adress")
	public String adress;
	@XmlElement(name="dead")
	public boolean dead;
	@XmlElement(name="Description")
	public String Description;
	@XmlElement(name="Selfharm")
	public boolean Selfharm;
	@XmlElement(name="diName")
	public Disease diName;
	@XmlElement(name="phoneNumber")
	public int phoneNumber;
	
	
	
	
	public static String select="SELECT * FROM [webService].[dbo].[Patient]";
	public static String delete="DELETE  FROM [webService].[dbo].[Patient]";

	
	public Patient(){
		
	}
	
	public static Patient returnPatientById(int id) {
		GetConnection ok=new GetConnection();
		ok.getDBConnection();
		
		ResultSet pop=ok.select(select+" WHERE id="+id);
		try {
			return new Patient(pop.getString(1),pop.getString(2),pop.getInt(3),pop.getString(4),pop.getInt(5),pop.getInt(6),pop.getInt(7),pop.getString(8),pop.getInt(9));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public Patient(String name,String adress,int dead,String Descr,int selfharm,int doctor,int phone,String disease,int id){
		this.adress=adress;
		this.name=name;
		this.dead=dead==1;
		Description=Descr;
		Selfharm=selfharm==1;
		diName=new Disease(disease);
		if(doctor!=-1){
			this.doctor=DoctorC.returnDoctorById(doctor);
			
		}
		this.phoneNumber=phone;
		this.id=id;
	}
	
	


public static boolean returnPatientAllergy(int patientId,String pharmako)
{
	ArrayList<PercriptionDetails>arras=new ArrayList<PercriptionDetails>();

	GetConnection ole=new GetConnection();
	Connection conn=ole.getDBConnection();
	try {
		CallableStatement cstmt = conn.prepareCall("{call dbo.pSideEffect(?,?)}");
		cstmt.setInt(1,patientId);
		cstmt.setString(2,pharmako);
		ResultSet pop=cstmt.executeQuery();
		if(pop.next()){
			return true;
		}		

	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		return false;
	}
	return false;
}

	
	//SideEffect
	
	
	public Patient[] returnPatients() {
		GetConnection ok=new GetConnection();
		ok.getDBConnection();
		ResultSet pop=ok.select(select);
		ArrayList<Patient>arras=new ArrayList<Patient>();
		
		try {
			pop.first();
			arras.add(new Patient(pop.getString(1),pop.getString(2),pop.getInt(3),pop.getString(4),pop.getInt(5),pop.getInt(6),pop.getInt(7),pop.getString(8),pop.getInt(9)));
			while(pop.next()){
				arras.add(new Patient(pop.getString(1),pop.getString(2),pop.getInt(3),pop.getString(4),pop.getInt(5),pop.getInt(6),pop.getInt(7),pop.getString(8),pop.getInt(9)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Patient[] zwa=new Patient[arras.size()];
		int i=0;
		for (Patient doctor : arras) {
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
			pop.updateString(1, name);
			pop.updateString(2, adress);
			pop.updateInt(3, 0);
			pop.updateString(4, Description);
			pop.updateInt(5, booleanToInt(Selfharm));
			if(doctor!=null)
				pop.updateInt(6, doctor.id);
			pop.updateInt(7,phoneNumber);
			pop.updateString(8,diName.name);

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
		
		ResultSet pop=ok.select(select+" WHERE id="+id);
		try {
			pop.updateString(1, name);
			pop.updateString(2, adress);
			pop.updateInt(3, booleanToInt(dead));
			pop.updateString(4, Description);
			pop.updateInt(5, booleanToInt(Selfharm));
			if(doctor!=null)
				pop.updateInt(6, doctor.id);
			pop.updateInt(7,phoneNumber);
			pop.updateString(8,diName.name);
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
		if(returnPatientAllergy(3, "Panadol")){
			System.out.println("ok");
		}
		else {
			System.out.println("false");

		}
	}*/
	/*
	public static void main(String[] args) {
		Patient kokos=new Patient();
		kokos.name="lasdfk";
		kokos.dead=false;
		kokos.Description="Exei themata";
		kokos.doctor=null;
		kokos.Selfharm=false;
		kokos.adress="villos";
		kokos.diName=new Disease("Psuxas");
		kokos.id=2;
		kokos.phoneNumber=96405121;
		kokos.returnPatients();
	}
*/}
