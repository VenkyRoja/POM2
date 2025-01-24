package com;

import com.base.MyBase;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.SignUpPage;

public class Main extends MyBase{
    String myTitle = "Sri Ram"; 
	public static LoginPage  loginpage;
	public static HomePage   homepage;
	public static SignUpPage signuppage;


    public Main() {
		super();
	}

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.myTitle);
        initialize();
        System.out.println("Hello world!");

        loginpage = new LoginPage();
        String title = loginpage.fetchTitle();
        System.out.println("Login page Title = " + title);

        String uname = prop.getProperty("username");
		String pwd = prop.getProperty("password");
		
		homepage = loginpage.login(uname, pwd);  

        //signuppage = loginpage.clickOnSignUpLink();


        //quit();

    }
}


