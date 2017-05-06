package viewpoints;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class HealthReport {


	public static String returnReport(String startD,String endD)
	{
		String toRet="";
	ArrayList<Consultations>arras=new ArrayList<Consultations>();

	GetConnection ole=new GetConnection();
	Connection conn=ole.getDBConnection();
	try {
		
		for (int i=7;i>=1;i--){
			startD=getDateString(i);
			endD=getDateString(i-1);
			CallableStatement cstmt = conn.prepareCall("{call dbo.ClinicPatientsEachDay(?,?)}");
			toRet=toRet+ new SimpleDateFormat("EEEE", Locale.ENGLISH).format(yesterday(i))+":\n";
			cstmt.setString(1,startD);
			cstmt.setString(2, endD);
			ResultSet pop=cstmt.executeQuery();
			while(pop.next()){
				toRet=toRet+"Clinic:"+pop.getString(1)+" | "+pop.getInt(2)+" patients.\n";
			}
			cstmt.close();
		}
		
		startD=getDateString(7);
		endD=getDateString(0);
		CallableStatement cstmt = conn.prepareCall("{call dbo.TotalPatientsAWeek(?,?)}");
		cstmt.setString(1,startD);
		cstmt.setString(2, endD);
		ResultSet pop=cstmt.executeQuery();
		while(pop.next()){
			toRet=toRet+"All Patients:"+pop.getInt(1)+"\n";
		}
		cstmt = conn.prepareCall("{call dbo.ContitionCount()}");
		pop=cstmt.executeQuery();
		while(pop.next()){
			toRet=toRet+"Disease:"+pop.getString(1)+" | "+pop.getInt(2)+ " patients.\n";
		}
		
		cstmt = conn.prepareCall("{call dbo.CountPharmaka(?,?)}");
		cstmt.setString(1,startD);
		cstmt.setString(2, endD);
		pop=cstmt.executeQuery();
		while(pop.next()){
			toRet=toRet+"Drug:"+pop.getString(1)+" | "+pop.getInt(2)+ " pieces.\n";
		}
		
		
		return toRet;
		
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		return null;
	}
	
	}

	
	public static Date yesterday(int daysBefore) {
	    final Calendar cal = Calendar.getInstance();
	    cal.set(Calendar.HOUR_OF_DAY, 0);
	    cal.set(Calendar.MINUTE, 0);
	    cal.set(Calendar.SECOND, 0);
	
	    cal.add(Calendar.DATE, -daysBefore);
	    return cal.getTime();
	}

	public static String getDateString(int daysBefore) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");
        return dateFormat.format(yesterday(daysBefore));
	}

	/*
	public static void main(String[] args) {
		System.out.println(returnReport("",""));
	}
	*/
		
	}
