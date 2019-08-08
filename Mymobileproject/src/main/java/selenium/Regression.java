package selenium;

public class Regression extends Sanitytest {

	// verification of login with wrong user name 
		public void invaliduser() throws Exception{
			displayCheckDN(UserNameN, "Username");
			enterValueN(UserNameN, "Wrong", "UserName");
			enterValueN(PasswordN,orprop.getProperty("RLpassword").trim(), "Password");
			clickDI(SecurityquedropdownID, "Security question drop down");
			clickDN(LocalSecQueN1, "Security Question");
			enterValueN(SecAnsN, orprop.getProperty("RLSecAns").trim(),"SecurityAnswer");		
			clickDN(LoginBtnN, "Login Button");		
			displayCheckDN(errormsgN, "Username validation message- Please verify username, try again.");
			
		}		
		
		// verification of login with wrong Password / securityQ&A for 4 attempts
		public void invalidpassword() throws Exception{

			//validation with wrong password
			displayCheckDN(UserNameN, "Username");
			enterValueN(UserNameN, orprop.getProperty("RLcarestaff").trim(), "UserName");
			enterValueN(PasswordN,"wrongpass", "Password");
			clickDI(SecurityquedropdownID, "Security question drop down");
			clickDN(LocalSecQueN1, "Security Question");
			enterValueN(SecAnsN, orprop.getProperty("RLSecAns").trim(),"SecurityAnswer");			
			clickDN(LoginBtnN, "Login Button");		
			sleeper(driver,3);
			displayCheckDN(errorpass1, orprop.getProperty("errorpass1"));

			//validating with wrong securiry question
			clearNEnterTextN(PasswordN, orprop.getProperty("RLpassword").trim(), "Password");		
			clickDI(SecurityquedropdownID, "Security question drop down");
			clickDN(LocalSecQueN2, "Security Question");
			enterValueN(SecAnsN, orprop.getProperty("RLSecAns").trim(),"SecurityAnswer");			
			clickDN(LoginBtnN, "Login Button");			
			displayCheckDN(errorpass2, orprop.getProperty("errorpass2"));

			//validating with wrong securiry Answer
			clearNEnterTextN(PasswordN, orprop.getProperty("RLpassword").trim(), "Password");		
			clickDI(SecurityquedropdownID, "Security question drop down");
			clickDN(LocalSecQueN1, "Security Question");
			enterValueN(SecAnsN, "wrong answer","SecurityAnswer");			
			clickDN(LoginBtnN, "Login Button");	
			displayCheckDN(errorpass3,orprop.getProperty("errorpass3"));
			
		}

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// verification of login with valid credentials 
		public void validlogin() throws Exception{

			displayCheckDN(UserNameN, "Username");
			enterValueN(UserNameN, orprop.getProperty("RLcarestaff").trim(), "UserName");
			enterValueN(PasswordN,orprop.getProperty("RLpassword").trim(), "Password");
			clickDI(SecurityquedropdownID, "Security question drop down");
			clickDN(LocalSecQueN1, "Security Question");
			enterValueN(SecAnsN, orprop.getProperty("RLSecAns").trim(),"SecurityAnswer");
			clickDN(LoginBtnN, "Login Button");	
			invisibleElement("ProgressBar",60);
			displayCheckDN(HomepageN, "Home Page");	
			
		}

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// verification of login with invalid data in offline mode 
		public void invalidloginoffline() throws Exception{

			displayCheckDN(UserNameN, "Username");
			enterValueN(UserNameN, "Wrong", "UserName");
			enterValueN(PasswordN,orprop.getProperty("RLpassword").trim(), "Password");
			clickDI(SecurityquedropdownID, "Security question drop down");
			clickDN(LocalSecQueN1, "Security Question");
			enterValueN(SecAnsN, orprop.getProperty("RLSecAns").trim(),"SecurityAnswer");			
			clickDN(LoginBtnN, "Login Button");		
			displayCheckDN(invalidusermsgN, "invalid user meesage");
			
			//Verifing with invalid password			
			displayCheckDN(invalidusermsgN, "Username validation message");
			clearNEnterTextN(UserNameN, orprop.getProperty("RLcarestaff").trim(), "UserName");
			enterValueN(PasswordN,"wrongpass", "Password");
			clickDI(SecurityquedropdownID, "Security question drop down");
			clickDN(LocalSecQueN1, "Security Question");
			enterValueN(SecAnsN, orprop.getProperty("RLSecAns").trim(),"SecurityAnswer");			
			clickDN(LoginBtnN, "Login Button");		
			displayCheckDN(invalidpassmsgN, orprop.getProperty("invalidpassmsgN"));
						
			//Verifing with invalid security Question
			
			clearNEnterTextN(PasswordN, orprop.getProperty("RLpassword").trim(), "Password");		
			clickDI(SecurityquedropdownID, "Security question drop down");
			clickDN(LocalSecQueN2, "Security Question");
			enterValueN(SecAnsN, orprop.getProperty("RLSecAns").trim(),"SecurityAnswer");			
			clickDN(LoginBtnN, "Login Button");				
			displayCheckDN(invalidpassmsgN, orprop.getProperty("invalidquemsgN"));
			
			//Verifing with invalid security Answer		
			
			clickDI(SecurityquedropdownID, "Security question drop down");
			clickDN(LocalSecQueN1, "Security Question");
			enterValueN(SecAnsN, "wrong answer","SecurityAnswer");			
			clickDN(LoginBtnN, "Login Button");	
			displayCheckDN(invalidpassmsgN,  orprop.getProperty("invalidansmsgN"));
			
		}	

}
