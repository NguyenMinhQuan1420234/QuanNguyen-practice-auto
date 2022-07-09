package com.quannguyen.ExtentReport;

import org.testng.IReporter;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;



public class ExtentReportListener implements IReporter {
    
    static ExtentTest logger;
    static ExtentReports report;

    @BeforeClass
    public void startTest() {
        report = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReportsResult.html", true);
    }
    
    public void verifyPageTitle() {
        
    }
}
