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
@XmlType(name = "PercriptionDetails")
public class PercriptionDetails {

	
	
/*
CREATE TABLE percriptionFarmaka(
perId int NOT NULL,
phName nvarchar(50) NOT NULL,
quantity int
)
*/
	
	@XmlElement(name="perscription")
	public Perscription perscription;
	@XmlElement(name="pharmako")
	public Pharmako pharmako;
	@XmlElement(name="quantity")
	public int quantity;
	
	public PercriptionDetails() {
		// TODO Auto-generated constructor stub
	}

public PercriptionDetails(String pharmako,int pescriptionId,int quantity) {
	this.quantity=quantity;
	this.pharmako=new Pharmako(pharmako);
	this.perscription=Perscription.returnPerscriptionById(pescriptionId);
}




public static String select="SELECT * FROM [webService].[dbo].[PercriptionDetails]";
public static String delete="DELETE  FROM [webService].[dbo].[PercriptionDetails]";

public static PercriptionDetails returnPercriptionDetailsById(int perscriptionId,String pharmakoName) {
	GetConnection ok=new GetConnection();
	ok.getDBConnection();
	
	ResultSet pop=ok.select(select+" WHERE perId="+perscriptionId+" AND phName='"+pharmakoName+"'");
	try {
		return new PercriptionDetails(pop.getString(2),pop.getInt(1),pop.getInt(3));
	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	}
}



public static PercriptionDetails[] returnLastPerscriptionDetailsByPId(int patientId)
{
	ArrayList<PercriptionDetails>arras=new ArrayList<PercriptionDetails>();

	GetConnection ole=new GetConnection();
	Connection conn=ole.getDBConnection();
	PercriptionDetails tmPercriptionDetails=new PercriptionDetails();
	try {
		CallableStatement cstmt = conn.prepareCall("{call dbo.LastPrescription(?)}");
		cstmt.setInt(1,patientId);
		ResultSet pop=cstmt.executeQuery();
		pop.next();
		return tmPercriptionDetails.returnPercriptionDetails(pop.getInt(1));
		
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		return null;
	}
}



public PercriptionDetails[] returnPercriptionDetails(int perscriptionId ) {
	GetConnection ok=new GetConnection();
	ok.getDBConnection();
	ResultSet pop=ok.select(select+" WHERE perId="+perscriptionId);
	ArrayList<PercriptionDetails>arras=new ArrayList<PercriptionDetails>();
	
	try {
		
		pop.first();
		arras.add(new PercriptionDetails(pop.getString(2),pop.getInt(1),pop.getInt(3)));
		while(pop.next()){
			arras.add(new PercriptionDetails(pop.getString(2),pop.getInt(1),pop.getInt(3)));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	PercriptionDetails[] zwa=new PercriptionDetails[arras.size()];
	int i=0;
	for (PercriptionDetails doctor : arras) {
		zwa[i]=doctor;
		i++;
	}
	return zwa;
}



public PercriptionDetails[] returnPercriptionDetails() {
	GetConnection ok=new GetConnection();
	ok.getDBConnection();
	ResultSet pop=ok.select(select);
	ArrayList<PercriptionDetails>arras=new ArrayList<PercriptionDetails>();
	
	try {
		
		pop.first();
		arras.add(new PercriptionDetails(pop.getString(2),pop.getInt(1),pop.getInt(3)));
		while(pop.next()){
			arras.add(new PercriptionDetails(pop.getString(2),pop.getInt(1),pop.getInt(3)));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	PercriptionDetails[] zwa=new PercriptionDetails[arras.size()];
	int i=0;
	for (PercriptionDetails doctor : arras) {
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
		pop.updateInt(1, perscription.id);
		pop.updateString(2, pharmako.name);
		pop.updateInt(3, quantity);


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
	
	ResultSet pop=ok.select(select+" WHERE perId="+perscription.id+" AND phName='"+pharmako.name+"'");
	try {
		pop.updateInt(3, quantity);
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
	ok.delete(delete+" WHERE perId="+perscription.id+" AND phName='"+pharmako.name+"'");					
}


	/*
	public static void main(String[] args) {
		PercriptionDetails leptomereies=new PercriptionDetails("panadol", 2, 10);
		
		System.out.println(leptomereies.returnPercriptionDetails(2).length);
		
		
		System.out.println("");
		//leptomereies.insert();
		//System.out.println(leptomereies.returnPercriptionDetails()[0].quantity);
		//leptomereies.update();
		//System.out.println(leptomereies.returnPercriptionDetails()[0].quantity);
		//leptomereies.returnPercriptionDetails()
		System.out.println(returnLastPerscriptionDetailsByPId(3).length);

		
	}
	*/
	
	
	
	
	
	
}
