package viewpoints;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Overrule")
public class Overrule {

	/*
	 * 
CREATE Table Overrule(
username nvarchar(50) not Null,
patientId int not NUll,
Details nvarchar(400) not NUll,
id int IDENTITY(1,1) PRIMARY KEY
)

	 */
	@XmlElement(name="username")
	public String username;
	@XmlElement(name="patient")
	public Patient patient;
	@XmlElement(name="details")
	public String details;
	@XmlElement(name="id")
	public int id;
	
	
	public Overrule(String user,int pId,String details,int id) {
		username=user;
		patient=Patient.returnPatientById(pId);
		this.details=details;
		this.id=id;
	}
	public Overrule() {
		// TODO Auto-generated constructor stub
	}

public static String select="SELECT * FROM [webService].[dbo].[Overrule]";
public static String delete="DELETE  FROM [webService].[dbo].[Overrule]";

/**
 * Returns all overrules
 * @return
 */
public Overrule[] returnOverrule() {
	GetConnection ok=new GetConnection();
	ok.getDBConnection();
	ResultSet pop=ok.select(select);
	ArrayList<Overrule>arras=new ArrayList<Overrule>();
	
	try {
		
		pop.first();
		arras.add(new Overrule(pop.getString(1),pop.getInt(2),pop.getString(3),pop.getInt(4)));
		while(pop.next()){
			arras.add(new Overrule(pop.getString(1),pop.getInt(2),pop.getString(3),pop.getInt(4)));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	Overrule[] zwa=new Overrule[arras.size()];
	int i=0;
	for (Overrule doctor : arras) {
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
 * Inserts an overrule.
 * @return
 */
public boolean insert(){
	GetConnection ok=new GetConnection();
	ok.getDBConnection();
	ResultSet pop=ok.select(select);
	try {
		pop.moveToInsertRow();
		pop.updateString(1, username);
		pop.updateInt(2, patient.id);
		pop.updateString(3, details);


		pop.insertRow();
		return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
}

/**
 * Delets an overrule.
 * @return
 */
public void delete(){		
	GetConnection ok=new GetConnection();
	ok.getDBConnection();		
	ok.delete(delete+" WHERE id="+id);					
}
	
/*
public static void main(String[] args) {
	Overrule eleoth=new Overrule("kokos", 2, "dfjkl;", 1);
	eleoth.insert();
	eleoth.insert();
	
	System.out.println(eleoth.returnOverrule()[0].details);
	
}
*/

}
