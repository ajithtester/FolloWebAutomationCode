package com.follo.enginerunner;                

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(


	//	tags = "@Regression", 	

		// tags = "@Register" ,
		 tags = "@Login",
		//	tags = "@NegativeCases" ,		
		features = {"Features_SP1" , "Features_SP2", "Features_SP3", "Features_SP4" , "Features_SP5", "Features_SP6" , "Features_SP7"}, 

		glue = {"com\\follo\\stepdefinition\\sp1", "com\\follo\\stepdefinition\\sp2", "com\\follo\\stepdefinition\\sp3", 
				"com\\follo\\stepdefinition\\sp4" , "com.follo.stepdefinition.sp5" , "com.follo.stepdefinition.sp6" , "com.follo.stepdefinition.sp7",
		"\\com\\follo\\Hooks"}, 
		plugin = {"rerun:target/failed_Cases.txt"},

		monochrome = true,	dryRun= false)
public class EngineRunner extends AbstractTestNGCucumberTests {


}















