package viewpoints;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestPatient {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Tests 
	 */
	@Test
	public void test1() {
		Patient kokos=new Patient();
		kokos.name="lasdfk";
		kokos.dead=false;
		kokos.Description="Exei themata";
		kokos.doctor=new DoctorC().returnDoctors()[0];
		kokos.Selfharm=false;
		kokos.adress="Mixail";
		kokos.diName=new Disease().returnDiseases()[0];
		kokos.phoneNumber=96405120;
		int i=kokos.returnPatients().length;
		kokos.insert();
		System.out.println(i);
        assertEquals("After one insertion,biggerList?", i+1,kokos.returnPatients().length);
        kokos.id=kokos.returnPatients()[kokos.returnPatients().length-1].id;
        kokos.delete();
	}
	
	@Test
	public void testInsertsAndUpdatesDelete() {
		DoctorC ola=new DoctorC();
		ola.doctorName="Mikelidis";
		ola.insert();
		int id=0;
		boolean fred=false;
		for (int i=0;i<ola.returnDoctors().length;i++) {
			if(ola.returnDoctors()[i].doctorName.equals("Mikelidis")){
				fred=true;
				id=ola.returnDoctors()[i].id;
				break;
			}
		}
        assertEquals("After one insertion,biggerList?", DoctorC.returnDoctorById(id).doctorName,"Mikelidis");	

        ola.doctorName="MikelSketo";
        
		ola.id=id;
		ola.update();
        assertEquals("After one insertion,biggerList?", DoctorC.returnDoctorById(id).doctorName,"MikelSketo");	
		ola.delete();
        assertEquals("After one insertion,biggerList?", DoctorC.returnDoctorById(id),null);
           
	}

	@Test
	public void pharmako() {

		Pharmako toFarmakoMastre=new Pharmako("PanadolJ");
		toFarmakoMastre.insert();
        assertEquals("PharmakoTest?",Pharmako.returnPharmako("PanadolJ").name,"PanadolJ");
		toFarmakoMastre.delete();
        assertEquals("PharmakoTestDel?",Pharmako.returnPharmako("PanadolJ"),null);

	}


	@Test
	public void Disease() {

		Disease toFarmakoMastre=new Disease("DoubleIdentity");
		toFarmakoMastre.insert();
        assertEquals("PharmakoTest?",Disease.returnDiseaseByName("DoubleIdentity").name,"DoubleIdentity");
		toFarmakoMastre.delete();
        assertEquals("PharmakoTestDel?",Pharmako.returnPharmako("DoubleIdentity"),null);

	}

	
	@Test
	public void Overrule() {
		int i;
		Overrule toFarmakoMastre=new Overrule("kokos",1002,"junit",1);
		if(toFarmakoMastre.returnOverrule()==null)
			i=0;
		else 
			i=toFarmakoMastre.returnOverrule().length;
		toFarmakoMastre.insert();
        assertEquals("OveruleInsert?",i+1,toFarmakoMastre.returnOverrule().length);
        
        toFarmakoMastre.id=toFarmakoMastre.returnOverrule()[0].id;
		toFarmakoMastre.delete();
		
		if(toFarmakoMastre.returnOverrule()==null)
	        assertEquals("OveruleDelete?",i,0);
		else 
	        assertEquals("OveruleDelete?",i,toFarmakoMastre.returnOverrule().length);
        
	}
	
	
	@Test
	public void ConsultationDbUsage() {
        assertEquals("After one insertion,biggerList?", Consultations.returnConsultationsById(1003).clinic.name,"Trooditissa");
        assertEquals("After one insertion,biggerList?", Consultations.returnMostRecentConsultationOfPatient(1002).perscriptioId.id,1019);
	}
	
	
	
	@Test
	public void Sideeffect(){
		SideEffect disease=new SideEffect("Flwritida");
		disease.insert();
        assertEquals("Can i find the disease?", disease.returnSideEffectByName(disease.name).name,"Flwritida");
        
		disease.delete();
        assertEquals("Can i find the disease?", disease.returnSideEffectByName(disease.name),null);
        
	}
	@Test
	public void Perscription() {
		Perscription ok=new Perscription(1002, "2010-10-11 00:09:13", "2010-11-11 00:11:12", 1);
		ok.insert();
        assertEquals("Date is same?",ok.returnPerscriptionById(ok.returnPerscription()[ok.returnPerscription().length-1].id).patient.id,1002);
        ok.id=ok.returnPerscriptionById(ok.returnPerscription()[ok.returnPerscription().length-1].id).id;
        ok.delete();
        
	}
	
	@Test
	public void TestAllergy(){
	
        assertEquals("Date is same?",Patient.returnPatientAllergy(1002, "Celexa"),true);
        assertEquals("Date is same?",Patient.returnPatientAllergy(1002, "Paxil"),false);
        assertEquals("Date is same?",Patient.returnPatientAllergy(1002, "Luvox"),false);
        assertEquals("Date is same?",Patient.returnPatientAllergy(1002, "Zoloft"),true);
        assertEquals("Date is same?",Patient.returnPatientAllergy(1002, "Prozac"),true);
	}
	
	
}
