package viewpoints;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Transaction")
public class Transaction {

	/*
	 * 
CREATE Table atransaction(
username nvarchar(50) not Null,
Details nvarchar(400) not NUll,
id int IDENTITY(1,1) PRIMARY KEY
)


	 */
	
	@XmlElement(name="username")
	public String username;
	@XmlElement(name="details")
	public String details;
	@XmlElement(name="id")
	public int id;
	
	public Transaction(String user,String details,int id) {
		username=user;
		this.details=details;
		this.id=id;
	}
	
public Transaction() {
	// TODO Auto-generated constructor stub
}
public static String select="SELECT * FROM [webService].[dbo].[atransaction]";
public static String delete="DELETE  FROM [webService].[dbo].[atransaction]";

/**
 * Returns all transactions.
 * @return
 */
public Transaction[] returnTransaction() {
	GetConnection ok=new GetConnection();
	ok.getDBConnection();
	ResultSet pop=ok.select(select);
	ArrayList<Transaction>arras=new ArrayList<Transaction>();
	
	try {
		
		pop.first();
		arras.add(new Transaction(pop.getString(1),pop.getString(2),pop.getInt(3)));
		while(pop.next()){
			arras.add(new Transaction(pop.getString(1),pop.getString(2),pop.getInt(3)));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	Transaction[] zwa=new Transaction[arras.size()];
	int i=0;
	for (Transaction doctor : arras) {
		zwa[i]=doctor;
		i++;
	}
	return zwa;
}

/**
 * Inserts a new transaction.
 * @return
 */
public boolean insert(){
	GetConnection ok=new GetConnection();
	ok.getDBConnection();
	ResultSet pop=ok.select(select);
	try {
		pop.moveToInsertRow();
		pop.updateString(1, username);
		pop.updateString(2, details);
		pop.insertRow();
		return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
}
/**
 * Deletes a transaction.
 */
public void delete(){		
	GetConnection ok=new GetConnection();
	ok.getDBConnection();		
	ok.delete(delete+" WHERE id="+id);					
}
	
	
}
