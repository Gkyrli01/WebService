package login;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.jws.WebMethod;
import javax.jws.WebService;

import viewpoints.User;

@WebService
public interface AWSLogin {
	@WebMethod
	public int Login(String username,String password);
	@WebMethod
	public boolean update(User toUSe,String newPass);
	
}
