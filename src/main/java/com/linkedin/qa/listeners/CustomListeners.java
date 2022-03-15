package com.linkedin.qa.listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.linkedin.qa.base.TestBase;

public class CustomListeners extends TestBase implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Failed Test");
		try {
			failed();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
