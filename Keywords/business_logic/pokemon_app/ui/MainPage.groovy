package business_logic.pokemon_app.ui

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import business_logic.pokemon_app.common.CommonUI
import org.openqa.selenium.WebElement

public class MainPage {

	
	public MainPage() {
	}
	
	public void NavigateToPokedexFromQuickLinksMenu()
	{
		List<WebElement> elements =  WebUI.findWebElements(findTestObject('pokemon_app/MainPage/NATIONAL_DEX_LINK'),4)
		WebUI.waitForElementVisible(findTestObject('pokemon_app/MainPage/NATIONAL_DEX_LINK'), 10)
		elements[0].click()
	}
	
	
}
