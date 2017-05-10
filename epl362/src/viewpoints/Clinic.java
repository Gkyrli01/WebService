package viewpoints;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Clinic")
public class Clinic {

/*
CREATE TABLE Clinic(
ClinicName nvarchar(50) PRIMARY KEY,
adress nvarchar(100),
phoneNumber int
)
	*/

	@XmlElement(name="name")
	public String name;
	@XmlElement(name="adress")
	public String adress;
	@XmlElement(name="phoneNumber")
	public int phoneNumber;
	
	public Clinic(String name,String adress,int phoneNumber) {
		this.name=name;
		this.adress=adress;
		this.phoneNumber=phoneNumber;
	}
	
	


public static String select="SELECT * FROM [webService].[dbo].[Clinic]";
public static String delete="DELETE  FROM [webService].[dbo].[Clinic]";

/**
 * Returns a clinic by the name given.
 * @param username
 * @return a clinic
 */
public static Clinic returnClinicByName(String username) {
	username="'"+username+"'";
	GetConnection ok=new GetConnection();
	ok.getDBConnection();
	
	ResultSet pop=ok.select(select+" WHERE ClinicName="+username);
	try {
		return new Clinic(pop.getString(1),pop.getString(2),pop.getInt(3));
	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	}
}
public Clinic() {
	// TODO Auto-generated constructor stub
}


/**
 * Returns all clinics.
 * @return an array of clinics
 */
public Clinic[] returnClinics() {
	GetConnection ok=new GetConnection();
	ok.getDBConnection();
	ResultSet pop=ok.select(select);
	ArrayList<Clinic>arras=new ArrayList<Clinic>();
	
	try {
		
		pop.first();
		arras.add(new Clinic(pop.getString(1),pop.getString(2),pop.getInt(3)));
		while(pop.next()){
			arras.add(new Clinic(pop.getString(1),pop.getString(2),pop.getInt(3)));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	Clinic[] zwa=new Clinic[arras.size()];
	int i=0;
	for (Clinic doctor : arras) {
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
 * Inserst a clinic
 * @return true if success,false on fail.
 */
public boolean insert(){
	GetConnection ok=new GetConnection();
	ok.getDBConnection();
	ResultSet pop=ok.select(select);
	try {
		pop.moveToInsertRow();
		pop.updateString(1, name);
		pop.updateString(2, adress);
		pop.updateInt(3, phoneNumber);
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
 * Updates a clinic
 * @return
 */
public boolean update(){
	String name1="'"+name+"'";
	GetConnection ok=new GetConnection();
	ok.getDBConnection();
	ResultSet pop=ok.select(select+" WHERE ClinicName="+name1);
	try {
		pop.updateString(2, adress);
		pop.updateInt(3, phoneNumber);
		pop.updateRow();
		return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
}
/**
 * Deletes the clinic.
 */
public void delete(){	
	String name1="'"+name+"'";
	GetConnection ok=new GetConnection();
	ok.getDBConnection();		
	ok.delete(delete+" WHERE ClinicName="+name1);					
}
/*
	public static void main(String[] args) {
		Clinic kokos=new Clinic("Trooditissa", "MixailKoutsofta 7", 23922828);
		
		kokos.insert();
		
		System.out.println(returnClinicByName("Trooditissa").name);
		
		kokos.adress="illa";
		
		kokos.update();
		
		System.out.println(returnClinicByName("Trooditissa").adress);

		kokos.delete();
		
		
		System.out.println(kokos.returnPerscription()[0].adress);
		System.out.println(kokos.returnPerscription()[1].adress);

	}
*/
}
