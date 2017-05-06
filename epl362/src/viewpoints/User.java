package viewpoints;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "User")
public class User {
/*
CREATE TABLE Users(
username nvarchar(30) PRIMARY KEy,
passwordUs  nvarchar(30) NOT Null,
UserType smallint NOT NUll
)
	*/
	
	@XmlElement(name="username")
	public String username;
	@XmlElement(name="password")
	public String password;
	@XmlElement(name="type")
	public int type;
	
	
	
	public static String select="SELECT * FROM [webService].[dbo].[Users]";
	public static String delete="DELETE  FROM [webService].[dbo].[Users]";
	
	
	
	public static int Login(String username,String password){
		username="'"+username+"'";
		password="'"+password+"'";
		GetConnection ok=new GetConnection();
		ok.getDBConnection();
		
		ResultSet pop=ok.select(select+" WHERE username="+username +" AND passwordUs="+password);
		try {
			pop.getString(1);
			return pop.getInt(3);
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}


	public boolean insert(){
		GetConnection ok=new GetConnection();
		ok.getDBConnection();
		ResultSet pop=ok.select(select);
		try {
			pop.moveToInsertRow();
			pop.updateString(1, username);
			pop.updateString(2, password);
			pop.updateInt(3, type);
			pop.insertRow();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		//return "INSERT INTO Doctor VALUES ('"+doctorName+"')";
	}
	public boolean update(String newPass){
		String name1="'"+username+"'";
		String pass="'"+password+"'";
		GetConnection ok=new GetConnection();
		ok.getDBConnection();
		ResultSet pop=ok.select(select+" WHERE username="+name1+" AND passwordUs="+pass);
		try {
			pop.updateString(2, newPass);
			pop.updateInt(3, type);
			pop.updateRow();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public void delete(){	
		String name1="'"+username+"'";
		String pass="'"+password+"'";
		GetConnection ok=new GetConnection();
		ok.getDBConnection();		
		ok.delete(delete+" WHERE username="+name1+" AND passwordUs="+pass);					
	}
	/*
	public static void main(String[] args) {
		User pUser=new User();
		pUser.username="Frid";
		pUser.password="123";
		pUser.type=2;
		
		pUser.delete();
		
		if(Login("Frid", "123")){
			System.out.println("Reshmi");
		}
		
		pUser.password="1234";
		pUser.update();
		
		if(Login("Frid", "123")){
			System.out.println("lol");
		}
		else {
			System.out.println("yeth");

		}
	}
	*/
	
	
}
