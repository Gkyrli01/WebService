package viewpoints;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Pharmako")
public class Pharmako {

	
	@XmlElement(name="name")
	public String name;
	
	
	public Pharmako(String name) {
		this.name=name;
	}
	


public Pharmako() {
		// TODO Auto-generated constructor stub
	}



public static String select="SELECT * FROM [webService].[dbo].[pharmako]";
public static String delete="DELETE  FROM [webService].[dbo].[pharmako]";

public static Pharmako returnPharmako(String username) {
	username="'"+username+"'";
	GetConnection ok=new GetConnection();
	ok.getDBConnection();
	
	ResultSet pop=ok.select(select+" WHERE phName="+username);
	try {
		return new Pharmako(pop.getString(1));
	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	}
}


public Pharmako[] returnPharmako() {
	GetConnection ok=new GetConnection();
	ok.getDBConnection();
	ResultSet pop=ok.select(select);
	ArrayList<Pharmako>arras=new ArrayList<Pharmako>();
	
	try {
		
		pop.first();
		arras.add(new Pharmako(pop.getString(1)));
		while(pop.next()){
			arras.add(new Pharmako(pop.getString(1)));
		}
	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	}
	Pharmako[] zwa=new Pharmako[arras.size()];
	int i=0;
	for (Pharmako doctor : arras) {
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
	ok.delete(delete+" WHERE phName="+name1);
	
}
	
	/*
public static void main(String[] args) {
	
	Pharmako toFarmakoMastre=new Pharmako("Panadol");
	toFarmakoMastre.insert();
	
	System.out.println(returnPharmako("Panadol").name);
	System.out.println(toFarmakoMastre.returnPharmako()[0].name);
	
	toFarmakoMastre.delete();

}
*/

}
