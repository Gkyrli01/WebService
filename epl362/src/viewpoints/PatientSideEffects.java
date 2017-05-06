package viewpoints;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PatientSideEffects")
public class PatientSideEffects {
	@XmlElement(name="patient")
	public Patient patient;
	@XmlElement(name="sideEffect")
	public SideEffect sideEffect;
	
	public PatientSideEffects(int patientId,String sideEffect) {
		patient=Patient.returnPatientById(patientId);
		this.sideEffect=new SideEffect(sideEffect);
	}
	

	

	public static String select="SELECT * FROM [webService].[dbo].[PatientSideEffects]";
	public static String delete="DELETE  FROM [webService].[dbo].[PatientSideEffects]";

	public static PatientSideEffects returnPatientSideEffectsById(String sideEffectName ,int patientId) {
		GetConnection ok=new GetConnection();
		ok.getDBConnection();
		ResultSet pop=ok.select(select+" WHERE SideEffectName='"+sideEffectName+"' AND patientId="+patientId);
		try {
			return new PatientSideEffects(pop.getInt(1),pop.getString(2));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static PatientSideEffects[] returnPatientSideEffectsByPatient(int id) {
		GetConnection ok=new GetConnection();
		ok.getDBConnection();
		ResultSet pop=ok.select(select+" WHERE patientId="+id);
		ArrayList<PatientSideEffects>arras=new ArrayList<PatientSideEffects>();
		
		try {	
			pop.first();
			arras.add(new PatientSideEffects(pop.getInt(1),pop.getString(2)));
			while(pop.next()){
				arras.add(new PatientSideEffects(pop.getInt(1),pop.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		PatientSideEffects[] zwa=new PatientSideEffects[arras.size()];
		int i=0;
		for (PatientSideEffects doctor : arras) {
			zwa[i]=doctor;
			i++;
		}
		return zwa;
	}

	
	
	public PatientSideEffects[] returnPatientSideEffects() {
		GetConnection ok=new GetConnection();
		ok.getDBConnection();
		ResultSet pop=ok.select(select);
		ArrayList<PatientSideEffects>arras=new ArrayList<PatientSideEffects>();
		
		try {	
			pop.first();
			arras.add(new PatientSideEffects(pop.getInt(1),pop.getString(2)));
			while(pop.next()){
				arras.add(new PatientSideEffects(pop.getInt(1),pop.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		PatientSideEffects[] zwa=new PatientSideEffects[arras.size()];
		int i=0;
		for (PatientSideEffects doctor : arras) {
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
			pop.updateString(2, sideEffect.name);
			pop.updateInt(1, patient.id);
			pop.insertRow();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		//return "INSERT INTO Doctor VALUES ('"+doctorName+"')";
	}
	
	public PatientSideEffects() {
		// TODO Auto-generated constructor stub
	}
	public void delete(){		
		GetConnection ok=new GetConnection();
		ok.getDBConnection();		
		ok.delete(delete+" WHERE SideEffectName='"+sideEffect.name+"' AND patientId="+patient.id);					
	}
	
	
	/*
	public static void main(String[] args) {
		PatientSideEffects ok=new PatientSideEffects();
		ok.returnPatientSideEffectsByPatient(3);
	}*/
	/*
	public static void main(String[] args) {
		PatientSideEffects ola=new PatientSideEffects(3, "psuxas");
		//ola.insert();
		//System.out.println(ola.returnPatientSideEffects()[0].patient.Description);
		//ola.delete();
		
	}*/
	
}
