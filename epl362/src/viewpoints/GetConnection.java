package viewpoints;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetConnection {

	private static boolean dbDriverLoaded = false;
	private static Connection conn = null;

	public Connection getDBConnection() {
		String dbConnString = "jdbc:sqlserver://localhost:1433;databaseName=webService;user=sa;password=9e50f75d2e;";
		
		if (!dbDriverLoaded)
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				dbDriverLoaded = true;
			} catch (ClassNotFoundException e) {
				System.out.println("Cannot load DB driver!");
				return null;
			}

		try {
			if (conn == null)
				conn = DriverManager.getConnection(dbConnString);
			else if (conn.isClosed())
				conn = DriverManager.getConnection(dbConnString);
		} catch (SQLException e) {
			System.out.print("Cannot connect to the DB!\nGot error: ");
			System.out.print(e.getErrorCode());
			System.out.print("\nSQL State: ");
			System.out.println(e.getSQLState());
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	

	public ResultSet select(String query){
		ResultSet current=null;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			current = stmt.executeQuery(query);
			
			current.next();
				
		 //   current.moveToCurrentRow();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		
		}
		return current;
	}
	
	public boolean delete(String query){
		ResultSet current=null;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			current = stmt.executeQuery(query);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		return false;
		}
		return true;
		
		
	}
	
	
}
