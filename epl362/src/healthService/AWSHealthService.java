package healthService;

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

import javax.jws.WebMethod;
import javax.jws.WebService;


import viewpoints.Disease;
import viewpoints.Perscription;
import viewpoints.Pharmako;

//@WebMethod
@WebService
public interface AWSHealthService {

	/**
	 * Returns all the prescriptions.
	 * @return
	 */
	@WebMethod
	public Perscription[] returnPrescritpions();
	@WebMethod
	public Pharmako[] returnPharmaka();
	@WebMethod
	public Disease[] returnDiseases();
	/**
	 * Returns the report.
	 * @return
	 */
	@WebMethod
	public String returnReport();
	
}
