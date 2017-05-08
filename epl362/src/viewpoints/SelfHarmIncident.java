package viewpoints;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SelfHarmIncident")
public class SelfHarmIncident {

/*
CREATE TABLE SelfHarmful(
patientId int not null,
details nvarchar(300) NOT NUll,
incidentId int IDENTITY(1,1) PRIMARY KEY
)
*/
	@XmlElement(name="patient")
	public Patient patient;
	@XmlElement(name="details")
	public String details;
	@XmlElement(name="id")
	public int id;
	
	public SelfHarmIncident() {
		// TODO Auto-generated constructor stub
	}
	
	public SelfHarmIncident(int patientId,String details,int id) {
		patient=Patient.returnPatientById(patientId);
		this.details=details;
		this.id=id;
	}
	
	

public static String select="SELECT * FROM [webService].[dbo].[SelfHarmIncident]";
public static String delete="DELETE  FROM [webService].[dbo].[SelfHarmIncident]";

public static SelfHarmIncident returnSelfHarmIncidentById(int id) {
	GetConnection ok=new GetConnection();
	ok.getDBConnection();
	
	ResultSet pop=ok.select(select+" WHERE incidentId="+id);
	try {
		return new SelfHarmIncident(pop.getInt(1),pop.getString(2),pop.getInt(3));
	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	}
}


public SelfHarmIncident[] returnSelfHarmIncidentByPatientId(int id) {
	GetConnection ok=new GetConnection();
	ok.getDBConnection();
	ResultSet pop=ok.select(select+" WHERE patientId="+id);
	ArrayList<SelfHarmIncident>arras=new ArrayList<SelfHarmIncident>();
	
	try {
		
		pop.first();
		arras.add(new SelfHarmIncident(pop.getInt(1),pop.getString(2),pop.getInt(3)));
		while(pop.next()){
			arras.add(new SelfHarmIncident(pop.getInt(1),pop.getString(2),pop.getInt(3)));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	SelfHarmIncident[] zwa=new SelfHarmIncident[arras.size()];
	int i=0;
	for (SelfHarmIncident doctor : arras) {
		zwa[i]=doctor;
		i++;
	}
	return zwa;
}



public SelfHarmIncident[] returnSelfHarmIncident() {
	GetConnection ok=new GetConnection();
	ok.getDBConnection();
	ResultSet pop=ok.select(select);
	ArrayList<SelfHarmIncident>arras=new ArrayList<SelfHarmIncident>();
	
	try {
		
		pop.first();
		arras.add(new SelfHarmIncident(pop.getInt(1),pop.getString(2),pop.getInt(3)));
		while(pop.next()){
			arras.add(new SelfHarmIncident(pop.getInt(1),pop.getString(2),pop.getInt(3)));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	SelfHarmIncident[] zwa=new SelfHarmIncident[arras.size()];
	int i=0;
	for (SelfHarmIncident doctor : arras) {
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
		pop.updateString(2, details);
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
	
	ResultSet pop=ok.select(select+" WHERE incidentId="+id);
	try {
		pop.updateString(2, details);
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
	ok.delete(delete+" WHERE incidentId="+id);					
}
	/*
public static void main(String[] args) {
	
	SelfHarmIncident love=new SelfHarmIncident(3, "K to eipe oti tou gamei tin mana", 2);
	love.insert();
	
	System.out.println(love.returnSelfHarmIncidentByPatientId(3)[0].details);
	
	love.details="njasdklf";
	love.update();
	System.out.println(SelfHarmIncident.returnSelfHarmIncidentById(2).details);
	love.delete();
}
	*/
}
