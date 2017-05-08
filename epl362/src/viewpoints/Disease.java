package viewpoints;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Disease")
public class Disease {

/*
CREATE TABLE Diseases(
DiName nvarchar(50) PRIMARY KEY
)
	*/
	@XmlElement(name="name")
	public String name;
	

	
	public Disease(String name) {
		this.name=name;
	}
	


public static String select="SELECT * FROM [webService].[dbo].[Diseases]";
public static String delete="DELETE  FROM [webService].[dbo].[Diseases]";

public Disease() {
	// TODO Auto-generated constructor stub
}

public static Disease returnDiseaseByName(String username) {
	username="'"+username+"'";
	GetConnection ok=new GetConnection();
	ok.getDBConnection();
	
	ResultSet pop=ok.select(select+" WHERE DiName="+username);
	try {
		return new Disease(pop.getString(1));
	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	}
}


public Disease[] returnDiseases() {
	GetConnection ok=new GetConnection();
	ok.getDBConnection();
	ResultSet pop=ok.select(select);
	ArrayList<Disease>arras=new ArrayList<Disease>();
	
	try {
		
		pop.first();
		arras.add(new Disease(pop.getString(1)));
		while(pop.next()){
			arras.add(new Disease(pop.getString(1)));
		}
	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	}
	Disease[] zwa=new Disease[arras.size()];
	int i=0;
	for (Disease doctor : arras) {
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
	String name1="'"+name+"'";
	GetConnection ok=new GetConnection();
	ok.getDBConnection();		
	ok.delete(delete+" WHERE DiName="+name1);
	
}
	
/*
public static void main(String[] args) {
	Disease egkasia=new Disease("Psuxas");
	egkasia.insert();
	
	System.out.println(returnSideEffectByName("Psuxas").name);
	
	System.out.println(egkasia.returnPerscription()[0].name);
	egkasia.delete();
	
}
	*/
}
