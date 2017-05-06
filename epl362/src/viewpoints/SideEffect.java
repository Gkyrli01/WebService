package viewpoints;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SideEffect")
public class SideEffect {

	
	

/*CREATE TABLE SideEffects(
SideEffectName nvarchar(50) PRIMARY KEY
)
*/
	@XmlElement(name="name")
	public String name;
	
	
	public SideEffect(String name) {
		this.name=name;
	}
	
public SideEffect() {
	// TODO Auto-generated constructor stub
}

public static String select="SELECT * FROM [webService].[dbo].[SideEffects]";
public static String delete="DELETE  FROM [webService].[dbo].[SideEffects]";

public static SideEffect returnSideEffectByName(String username) {
	username="'"+username+"'";
	GetConnection ok=new GetConnection();
	ok.getDBConnection();
	
	ResultSet pop=ok.select(select+" WHERE SideEffectName="+username);
	try {
		return new SideEffect(pop.getString(1));
	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	}
}


public SideEffect[] returnSideEffect() {
	GetConnection ok=new GetConnection();
	ok.getDBConnection();
	ResultSet pop=ok.select(select);
	ArrayList<SideEffect>arras=new ArrayList<SideEffect>();
	
	try {
		
		pop.first();
		arras.add(new SideEffect(pop.getString(1)));
		while(pop.next()){
			arras.add(new SideEffect(pop.getString(1)));
		}
	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	}
	SideEffect[] zwa=new SideEffect[arras.size()];
	int i=0;
	for (SideEffect doctor : arras) {
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
	ok.delete(delete+" WHERE SideEffectName="+name1);
	
}
	


/*
public static void main(String[] args) {
	SideEffect egkasia=new SideEffect("Psuxas");
	egkasia.insert();
	
	System.out.println(returnSideEffectByName("Psuxas").name);
	
	System.out.println(egkasia.returnPerscription()[0].name);
	
}
*/

}
