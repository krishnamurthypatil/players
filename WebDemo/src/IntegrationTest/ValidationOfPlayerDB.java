package IntegrationTest;

import org.testng.annotations.Test;

import AllPages.Base;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class ValidationOfPlayerDB extends Base {

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();

		driver.manage().window().maximize();

	}
	@Test
	public void createNewPlayer() {
		try {

			WebDriverWait wait = new WebDriverWait(driver, 10);

			String vId = "209819";
			String vName = "Krishnamurthy Patil";
			String vAge = "36";
			String vEmail = "krishnamurthy.patil@wipro.com";
			String vAdd = "Bangalore";

			driver.get("http://localhost:8080/WebDemo/FetchData.jsp");

			WebElement sid = driver.findElement(By.name("ID"));
			WebElement sname = driver.findElement(By.name("NAME"));
			WebElement sage = driver.findElement(By.name("AGE"));
			WebElement semail = driver.findElement(By.name("EMAIL"));
			WebElement saddress = driver.findElement(By.name("ADDRESS"));
			WebElement sNewPlayerBtn = driver.findElement(By.xpath("//input[@value='Add New Player']"));

			sid.sendKeys(vId);
			sname.sendKeys(vName);
			sage.sendKeys(vAge);
			semail.sendKeys(vEmail);
			saddress.sendKeys(vAdd);
			sNewPlayerBtn.click();

			WebElement sCheckSuccessMsg = driver
					.findElement(By.xpath("//h1[contains(text(),'New Player Added to the Team Successfully')]"));

			Assert.assertEquals(true, sCheckSuccessMsg.isDisplayed());

			WebElement sViewAllPlayersbtn = driver
					.findElement(By.xpath("//input[@value='View Recently Entered Data']"));

			sViewAllPlayersbtn.click();

			WebElement sCheckRecentlyAdded = driver.findElement(By.xpath("//td[contains(text()," + vId + ")]"));

			Assert.assertEquals(true, sCheckRecentlyAdded.isDisplayed());

			WebElement sBackBtn = driver.findElement(By.xpath("//input[@value='Back To Home']"));

			sBackBtn.click();

			viewPlayers(vId);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void viewPlayers(String vvId) {
		try {

			WebDriverWait wait = new WebDriverWait(driver, 10);

			WebElement sGetPlayerBtn = driver.findElement(By.xpath("//input[@value='Get Player Details']"));

			sGetPlayerBtn.click();

			WebElement sGetPlayersMainScreen = driver
					.findElement(By.xpath("//h1[contains(text(),'Show Players List')]"));

			Assert.assertEquals(true, sGetPlayersMainScreen.isDisplayed());
			WebElement sGetAllPlayersBtn = driver.findElement(By.xpath("//input[@value='Get All Player Details']"));
			sGetAllPlayersBtn.click();

			WebElement sCompletePlayersListScreen = driver
					.findElement(By.xpath("//h1[contains(text(),'Complete Players List')]"));

			Assert.assertEquals(true, sCompletePlayersListScreen.isDisplayed());

			WebElement sTableColID = driver.findElement(By.xpath("//td[contains(text(),'ID')]"));
			WebElement sTableColNAME = driver.findElement(By.xpath("//td[contains(text(),'NAME')]"));
			WebElement sTableColAGE = driver.findElement(By.xpath("//td[contains(text(),'AGE')]"));
			WebElement sTableColEMAIL = driver.findElement(By.xpath("//td[contains(text(),'EMAIL')]"));
			WebElement sTableColADDRESS = driver.findElement(By.xpath("//td[contains(text(),'ADDRESS')]"));

			Assert.assertEquals(true, sTableColID.isDisplayed());
			Assert.assertEquals(true, sTableColNAME.isDisplayed());
			Assert.assertEquals(true, sTableColAGE.isDisplayed());
			Assert.assertEquals(true, sTableColEMAIL.isDisplayed());
			Assert.assertEquals(true, sTableColADDRESS.isDisplayed());

			System.out.println("View All Players Flow Completed");

			WebElement sBackBtn = driver.findElement(By.xpath("//input[@value='Back To Home']"));
			sBackBtn.click();

			sGetPlayerBtn = driver.findElement(By.xpath("//input[@value='Get Player Details']"));
			sGetPlayerBtn.click();

			sGetPlayersMainScreen = driver.findElement(By.xpath("//h1[contains(text(),'Show Players List')]"));
			Assert.assertEquals(true, sGetPlayersMainScreen.isDisplayed());
			WebElement sGetIndivisualPlayersBtn = driver
					.findElement(By.xpath("//input[@value='Get Indivisual Player Details']"));

			sGetIndivisualPlayersBtn.click();

			WebElement sGetSinglePlayerScreen = driver
					.findElement(By.xpath("//h1[contains(text(),'Get Player Details')]"));
			Assert.assertEquals(true, sGetSinglePlayerScreen.isDisplayed());

			WebElement sid = driver.findElement(By.name("ID"));
			sid.sendKeys(vvId);

			WebElement sGetSinglePlayerBtn = driver.findElement(By.xpath("//input[@value='Get Player Details']"));
			sGetSinglePlayerBtn.click();

			WebElement sGetSinglePlayerTable = driver
					.findElement(By.xpath("//h1[contains(text(),'Player Details For :')]"));

			Assert.assertEquals(true, sGetSinglePlayerTable.isDisplayed());

			WebElement sCheckRecentlyAdded = driver.findElement(By.xpath("//td[contains(text()," + vvId + ")]"));

			int rowCount = driver.findElements(By.xpath("//tbody[1]//tr")).size();

			Assert.assertEquals(rowCount, 2, "Only One Row will display");
			sBackBtn = driver.findElement(By.xpath("//input[@value='Back To Home']"));
			sBackBtn.click();

			System.out.println("View Single Player Flow Completed");

			updatePlayers(vvId);
			deletePlayers(vvId);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void updatePlayers(String vvId) {
		try {

			WebElement sUpdatePlayerBtn = driver.findElement(By.xpath("//input[@value='Update Player Record']"));

			sUpdatePlayerBtn.click();

			WebElement sUpdatePlayerScreen = driver
					.findElement(By.xpath("//h1[contains(text(),'Updating Player From The List')]"));

			Assert.assertEquals(true, sUpdatePlayerScreen.isDisplayed());

			WebElement sid = driver.findElement(By.name("ID"));
			sid.sendKeys(vvId);

			WebElement sUpdateBtn = driver.findElement(By.xpath("//input[@value='Update Player']"));
			sUpdateBtn.click();

			WebElement sSuccessDeleteScreen = driver.findElement(
					By.xpath("//h1[contains(text(),'Player Data Updated For : "+vvId+" Successfully')]"));

			Assert.assertEquals(true, sSuccessDeleteScreen.isDisplayed());

			WebElement sViewUpdatedEntryBtn = driver.findElement(By.xpath("//input[@value='Verify Updated Entry']"));

			sViewUpdatedEntryBtn.click();

			WebElement sBackBtn = driver.findElement(By.xpath("//input[@value='Back To Home']"));
			sBackBtn.click();

			System.out.println("Update Player Flow Completed");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deletePlayers(String vvId) {
		try {

			WebElement sDeletePlayerBtn = driver.findElement(By.xpath("//input[@value='Delete The Player']"));

			sDeletePlayerBtn.click();

			WebElement sDeletePlayerScreen = driver
					.findElement(By.xpath("//h1[contains(text(),'Deleting Player From The List')]"));

			Assert.assertEquals(true, sDeletePlayerScreen.isDisplayed());

			WebElement sid = driver.findElement(By.name("ID"));
			sid.sendKeys(vvId);

			WebElement sDeleteBtn = driver.findElement(By.xpath("//input[@value='Delete Player']"));
			sDeleteBtn.click();

			WebElement sSuccessDeleteScreen = driver.findElement(
					By.xpath("//h1[contains(text(),'Player Data Deleted Successfully from the Data Bas')]"));

			Assert.assertEquals(true, sSuccessDeleteScreen.isDisplayed());

			WebElement sViewDeletedEntryBtn = driver.findElement(By.xpath("//input[@value='Verify Deleted Entry']"));

			sViewDeletedEntryBtn.click();

			//Assert.assertFalse(driver.findElement(By.xpath("//td[contains(text(),'" + vvId + "')]")).isDisplayed());

			System.out.println("Delete Player Flow Completed");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}