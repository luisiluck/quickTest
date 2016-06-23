package helpers;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestListener implements ITestListener {

	public void onFinish(ITestContext arg0) {
		Reporter.log( "Suite ends", true );

	}

	public void onStart(ITestContext arg0) {
		Reporter.log( "Suite begins", true );

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult arg0) {
		Reporter.log( "test #" + arg0.getName() + " FAILED", true );

	}

	public void onTestSkipped(ITestResult arg0) {
		Reporter.log( "test #" + arg0.getName() + " SKIPED", true );

	}

	public void onTestStart(ITestResult arg0) {
		Reporter.log( "test #" + arg0.getName() + " START", true );

	}

	public void onTestSuccess(ITestResult arg0) {
		Reporter.log( "test #" + arg0.getName() + " PASSED!", true );

	}

}
