package Labsession16_08;

import org.testng.annotations.Test;

public class GroupingUsers {
	@Test(groups ="Sanity")
	public void createUser() {
		System.out.println("createUser is executed");
	}
		@Test(groups = "Regression")
	    public void updateUser() {
	        System.out.println("updateUser is executed");
	}
		@Test(groups = {"sanity","Regression"})
		public void deleteUser () {
			System.out.println("deleteUser is executed");
		}
		@Test(groups = "Smoke")
		public void viewUser() {
			System.out.println("viewUser is executed");
		}
	}


