package login;

import javax.jws.WebService;

import viewpoints.User;

@WebService(endpointInterface="login.AWSLogin")
public class AWSLoginImpl implements AWSLogin {

	public int Login(String username, String password) {
		return User.Login(username, password);		
	}
	public boolean update(User toUSe, String newPass) {
		return toUSe.update(newPass);
	}

}
