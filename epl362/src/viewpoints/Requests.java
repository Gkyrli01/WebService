package viewpoints;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Requests")
public class Requests {

/*
 * 
CREATE Table request(
patientId int not NUll,
Details nvarchar(400) not NUll,
status int Default 0,
id int IDENTITY(1,1) PRIMARY KEY
)

 */
	@XmlElement(name="patient")
	public Patient patient;
	@XmlElement(name="details")
	public String details;
	@XmlElement(name="status")
	public int status;	
	@XmlElement(name="id")
	public int id;
	
	public Requests() {
		// TODO Auto-generated constructor stub
	}
	public Requests(int pId,String details,int status,int id) {
		patient=Patient.returnPatientById(pId);
		this.details=details;
		this.status=status;
		this.id=id;
	}
	
	
	public static String select="SELECT * FROM [webService].[dbo].[request]";
	public static String delete="DELETE  FROM [webService].[dbo].[request]";


	public Requests[] returnRequests() {
		GetConnection ok=new GetConnection();
		ok.getDBConnection();
		ResultSet pop=ok.select(select);
		ArrayList<Requests>arras=new ArrayList<Requests>();
		
		try {
			
			pop.first();
			arras.add(new Requests(pop.getInt(1),pop.getString(2),pop.getInt(3),pop.getInt(4)));
			while(pop.next()){
				arras.add(new Requests(pop.getInt(1),pop.getString(2),pop.getInt(3),pop.getInt(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		Requests[] zwa=new Requests[arras.size()];
		int i=0;
		for (Requests doctor : arras) {
			zwa[i]=doctor;
			i++;
		}
		return zwa;
	}
	
	
	public boolean insert(){
		GetConnection ok=new GetConnection();
		ok.getDBConnection();
		ResultSet pop=ok.select(select);
		try {
			pop.moveToInsertRow();
			pop.updateInt(1, patient.id);
			pop.updateString(2, details);
			pop.updateInt(3, status);
			pop.insertRow();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}


public boolean update(){

	GetConnection ok=new GetConnection();
	ok.getDBConnection();
	
	ResultSet pop=ok.select(select+" WHERE id="+id);
	try {
		pop.updateInt(3, status);
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
		
	
}
