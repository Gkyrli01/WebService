package viewpoints;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PharmakoSideEffects")
public class PharmakoSideEffects {

	
	/*
	 * 
	 * 
CREATE TABLE pharmakoSideEffects(
phName nvarchar(50) NOT NUll,
SideEffectName nvarchar(50) NOT NULL
)
	 */
	
	@XmlElement(name="pharmako")
	public Pharmako pharmako;
	@XmlElement(name="sideEffect")
	public SideEffect sideEffect;
	
	public PharmakoSideEffects(String pharmako,String sideEffect) {
		this.pharmako=new Pharmako(pharmako);
		this.sideEffect=new SideEffect(sideEffect);
	}
	public PharmakoSideEffects() {
		// TODO Auto-generated constructor stub
	}



	public static String select="SELECT * FROM [webService].[dbo].[pharmakoSideEffects]";
	public static String delete="DELETE  FROM [webService].[dbo].[pharmakoSideEffects]";

	/**
	 * Shouldn't be used.
	 * @param sideEffectName
	 * @param pharmakoName
	 * @return
	 */
	public static PharmakoSideEffects returnPharmakoSideEffectsById(String sideEffectName ,String pharmakoName) {
		GetConnection ok=new GetConnection();
		ok.getDBConnection();
		ResultSet pop=ok.select(select+" WHERE SideEffectName='"+sideEffectName+"' AND phName='"+pharmakoName+"'");
		try {
			return new PharmakoSideEffects(pop.getString(1),pop.getString(2));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Returns the sideeffects of a pharmako.
	 * @param name
	 * @return
	 */
	public static PharmakoSideEffects[] returnPharmakoSideEffectsbyName(String name) {
		name="'"+name+"'";
		GetConnection ok=new GetConnection();
		ok.getDBConnection();
		ResultSet pop=ok.select(select+" WHERE phName="+name);
		ArrayList<PharmakoSideEffects>arras=new ArrayList<PharmakoSideEffects>();
		
		try {
			
			pop.first();
			arras.add(new PharmakoSideEffects(pop.getString(1),pop.getString(2)));
			while(pop.next()){
				arras.add(new PharmakoSideEffects(pop.getString(1),pop.getString(2)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		PharmakoSideEffects[] zwa=new PharmakoSideEffects[arras.size()];
		int i=0;
		for (PharmakoSideEffects doctor : arras) {
			zwa[i]=doctor;
			i++;
		}
		return zwa;
	}

	
	
	public PharmakoSideEffects[] returnPharmakoSideEffects() {
		GetConnection ok=new GetConnection();
		ok.getDBConnection();
		ResultSet pop=ok.select(select);
		ArrayList<PharmakoSideEffects>arras=new ArrayList<PharmakoSideEffects>();
		
		try {
			
			pop.first();
			arras.add(new PharmakoSideEffects(pop.getString(1),pop.getString(2)));
			while(pop.next()){
				arras.add(new PharmakoSideEffects(pop.getString(1),pop.getString(2)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		PharmakoSideEffects[] zwa=new PharmakoSideEffects[arras.size()];
		int i=0;
		for (PharmakoSideEffects doctor : arras) {
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
	 * Inserts a sideeffect for a drug
	 * @return
	 */
	public boolean insert(){
		
		GetConnection ok=new GetConnection();
		ok.getDBConnection();
		ResultSet pop=ok.select(select);
		try {
			pop.moveToInsertRow();
			pop.updateString(2, sideEffect.name);
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
	/**
	 * Deletes a sideffect of a drug.
	 */
	public void delete(){		
		GetConnection ok=new GetConnection();
		ok.getDBConnection();		
		ok.delete(delete+" WHERE SideEffectName='"+sideEffect.name+"' AND phName='"+pharmako.name+"'");					
	}
	
	public static void main(String[] args) {
		returnPharmakoSideEffectsbyName("Panadol");
	}
	
	/*
	public static void main(String[] args) {
		PharmakoSideEffects olEffects=new PharmakoSideEffects("Panadol", "Psuxas");
		olEffects.insert();
		//olEffects.delete();/*
		System.out.println(olEffects.returnPharmakoSideEffects()[0].sideEffect.name);
		System.out.println(olEffects.returnPharmakoSideEffects()[0].pharmako.name);

		System.out.println(PharmakoSideEffects.returnPharmakoSideEffectsById("Psuxas", "Panadol").pharmako.name);
	}
	*/
}
