package Labsession16_08;

import org.testng.annotations.Test;

public class GroupingTests {
	@Test(groups="Smoke")
	public void loginTest() {
		System.out.println("loginTest executed");
	}
	@Test(groups="Regression")
	public void paymentTest() {
		System.out.println("paymentTest executed");
	}
	@Test(groups = {"Smoke","Regression"})
	public void logoutTest() {
		System.out.println("logoutTest executed");
	}
	
}
