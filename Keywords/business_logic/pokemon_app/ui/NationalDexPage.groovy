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
import org.openqa.selenium.WebElement

public class NationalDexPage {

	public NationalDexPage() {}

	public boolean DoesAPokemonWithThisNameExist(String targetName) {
		boolean exists = false
		List<WebElement> elements =  WebUI.findWebElements(findTestObject('pokemon_app/NationalDexPage/POKEMON_NAME_LINK'),20)
		int amount = elements.size()
		int index = 0
		while(index <= amount-1) {
			String pokemonName_label = elements[index].text
			if(pokemonName_label == targetName) {
				exists = true
				break
			}
			index = index + 1
		}
		return exists
	}



	public boolean DoesAPokemonWithThisNumberExist(int targetNumber) {
		boolean exist = false
		String targetNumberString = "#"+  this.FormatPokemonNumber(targetNumber)
		List<WebElement> elements =  WebUI.findWebElements(findTestObject('pokemon_app/NationalDexPage/POKEMON_NUMBER_LABEL'),20)
		int amount =  elements.size()
		int index = 0
		while(index <= amount-1) {
			String pokemonNumberLabel = elements[index].text
			if(pokemonNumberLabel == targetNumberString) {
				exist = true
				break
			}
			index = index + 1
		}
		return exist
	}
	
	
	public String ReturnNameOfPokemonWithThisNumber(int targetNumber)
	{
		String name = null
		boolean numberExist =  this.DoesAPokemonWithThisNumberExist(targetNumber)
		if(numberExist)
		{
			List<WebElement> elements =  WebUI.findWebElements(findTestObject('pokemon_app/NationalDexPage/POKEMON_NAME_LINK'),20)
			int index = targetNumber - 1
			name =  elements[index].text
		}
		else
		{
			System.out.println("returnNameOfPokemonWithThisNumber() could not find Name of Pokemon with Number: "+targetNumber)
		}
		return name
	}
	
	
	
	public int ReturnNumberOfPokemonWithThisName(String targetName)
	{
		int pkNumber = -1
		boolean nameExist = this.DoesAPokemonWithThisNameExist(targetName)
		if(nameExist)
		{
		    List<WebElement> elements =  WebUI.findWebElements(findTestObject('pokemon_app/NationalDexPage/POKEMON_NAME_LINK'),20)
			int amount = elements.size()
			int index = 0
			while(index <= amount-1)
			{
				
				String name = elements[index].text
				if(name == targetName)
				{
					pkNumber = index + 1
					break
				}
				index = index + 1
			}
		}
		else
		{
			System.out.println("returnNumberOfPokemonWithThisName() could not find Number of Pokemon with Name: "+targetName)
		}
		return pkNumber
	}

	
	public void ClickPokemonWithThisName(String targetName)
	{
		boolean nameExist =  this.DoesAPokemonWithThisNameExist(targetName)
		if(nameExist)
		{
			int pkNumber = this.ReturnNumberOfPokemonWithThisName(targetName)
			List<WebElement> elements =  WebUI.findWebElements(findTestObject('pokemon_app/NationalDexPage/POKEMON_NAME_LINK'),20)
			WebUI.waitForElementVisible(findTestObject('pokemon_app/NationalDexPage/POKEMON_NAME_LINK'), 10)
			elements[pkNumber-1].click()
		}
		else
		{
			System.out.println("clickPokemonWithThisName() could not find Pokemon named: "+targetName)
		}
	}
	


	public String FormatPokemonNumber(int pokemonNumber) {
		String stringNumber = null
		if(pokemonNumber > 1 && pokemonNumber <= 9) {
			stringNumber = "00"+pokemonNumber.toString()
		}
		else if(pokemonNumber > 10 && pokemonNumber <= 99) {
			stringNumber = "0"+pokemonNumber.toString()
		}
		else if(pokemonNumber > 99) {
			stringNumber = pokemonNumber.toString()
		}
		return stringNumber
	}
}
