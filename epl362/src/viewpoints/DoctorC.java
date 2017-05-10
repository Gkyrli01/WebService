package viewpoints;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DoctorC")
public class DoctorC {
	@XmlElement(name="doctorName")
	public String doctorName;
	@XmlElement(name="id")
	public int id;
	
	
	public static String select="SELECT * FROM [webService].[dbo].[Doctor]";
	public static String delete="DELETE  FROM [webService].[dbo].[Doctor]";

	
	public DoctorC(){
		
	}
	
	public DoctorC(String name,int id){
		doctorName=name;
		this.id=id;
	}
	
	/**
	 * Returns all doctors
	 * @return
	 */
	public DoctorC[] returnDoctors() {
		GetConnection ok=new GetConnection();
		ok.getDBConnection();
		ResultSet pop=ok.select(select);
		ArrayList<DoctorC>arras=new ArrayList<DoctorC>();
		
		try {
			pop.first();
			arras.add(new DoctorC(pop.getString(1), pop.getInt(2)));
			while(pop.next()){
				arras.add(new DoctorC(pop.getString(1), pop.getInt(2)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DoctorC[] zwa=new DoctorC[arras.size()];
		int i=0;
		for (DoctorC doctor : arras) {
			zwa[i]=doctor;
			i++;
		}
		return zwa;
	}
	/**
	 * Return a doctor by id given
	 * @param id
	 * @return
	 */
	public static DoctorC returnDoctorById(int id) {
		GetConnection ok=new GetConnection();
		ok.getDBConnection();
		
		ResultSet pop=ok.select(select+" WHERE DoctorId="+id);
		try {
			return new DoctorC(pop.getString(1), pop.getInt(2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * Inserts a new doctor
	 * @return
	 */
	public boolean insert(){
		
		GetConnection ok=new GetConnection();
		ok.getDBConnection();
		ResultSet pop=ok.select(select);
		try {
			pop.moveToInsertRow();
			pop.updateString(1, doctorName);
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
		//System.out.println(select+" WHERE DoctorId="+id);
		GetConnection ok=new GetConnection();
		ok.getDBConnection();
		
		ResultSet pop=ok.select(select+" WHERE DoctorId="+id);
		try {
			pop.updateString(1, doctorName);
			pop.updateRow();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * Deletes a doctor
	 */
	public void delete(){		
		GetConnection ok=new GetConnection();
		ok.getDBConnection();		
		ok.delete(delete+" WHERE DoctorId="+id);
			
		
	}
	
	/*
	public static void main(String[] args) {
		Doctor ok=new Doctor();
		ok.returnDoctors();
	}*/
}
