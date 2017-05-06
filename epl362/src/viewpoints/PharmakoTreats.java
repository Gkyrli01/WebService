package viewpoints;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PharmakoTreats")
public class PharmakoTreats {

	/*
	 * 
	 * 
CREATE TABLE pharmakoTreats(
phName nvarchar(50) NOT NULL,
DiName nvarchar(50) NOT NULL
)
	 */
	@XmlElement(name="pharmako")
	public Pharmako pharmako;
	@XmlElement(name="disease")
	public Disease disease;
	
	public PharmakoTreats(String pharmako,String Disease) {
		this.pharmako=new Pharmako(pharmako);
		this.disease=new Disease(Disease);
	}




	public static String select="SELECT * FROM [webService].[dbo].[pharmakoTreats]";
	public static String delete="DELETE  FROM [webService].[dbo].[pharmakoTreats]";

	public PharmakoTreats() {
		// TODO Auto-generated constructor stub
	}
	public static PharmakoTreats returnPharmakoTreatsById(String DiseaseName ,String pharmakoName) {
		GetConnection ok=new GetConnection();
		ok.getDBConnection();
		ResultSet pop=ok.select(select+" WHERE DiName='"+DiseaseName+"' AND phName='"+pharmakoName+"'");
		try {
			return new PharmakoTreats(pop.getString(1),pop.getString(2));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}


	public static PharmakoTreats[] returnPharmakoTreatsByDrugName(String name) {
		GetConnection ok=new GetConnection();
		ok.getDBConnection();
		ResultSet pop=ok.select(select+" WHERE phName='"+name+"'");
		ArrayList<PharmakoTreats>arras=new ArrayList<PharmakoTreats>();
		
		try {
			
			pop.first();
			arras.add(new PharmakoTreats(pop.getString(1),pop.getString(2)));
			while(pop.next()){
				arras.add(new PharmakoTreats(pop.getString(1),pop.getString(2)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		PharmakoTreats[] zwa=new PharmakoTreats[arras.size()];
		int i=0;
		for (PharmakoTreats doctor : arras) {
			zwa[i]=doctor;
			i++;
		}
		return zwa;
	}

	
	
	public PharmakoTreats[] returnPharmakoTreats() {
		GetConnection ok=new GetConnection();
		ok.getDBConnection();
		ResultSet pop=ok.select(select);
		ArrayList<PharmakoTreats>arras=new ArrayList<PharmakoTreats>();
		
		try {
			
			pop.first();
			arras.add(new PharmakoTreats(pop.getString(1),pop.getString(2)));
			while(pop.next()){
				arras.add(new PharmakoTreats(pop.getString(1),pop.getString(2)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		PharmakoTreats[] zwa=new PharmakoTreats[arras.size()];
		int i=0;
		for (PharmakoTreats doctor : arras) {
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
			pop.updateString(2, disease.name);
			pop.updateString(1, pharmako.name);
			pop.insertRow();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		//return "INSERT INTO Doctor VALUES ('"+doctorName+"')";
	}

	public void delete(){		
		GetConnection ok=new GetConnection();
		ok.getDBConnection();		
		ok.delete(delete+" WHERE DiName='"+disease.name+"' AND phName='"+pharmako.name+"'");					
	}
	/*
	public static void main(String[] args) {
		returnPharmakoTreatsByDrugName("Panadol");
	}*/
	/*
	
	public static void main(String[] args) {
		PharmakoTreats pop=new PharmakoTreats("Panadol", "Psuxas");
		pop.insert();

		System.out.println(pop.returnPharmakoTreats()[0].disease.name);
		pop.delete();
	}
	*/
}
