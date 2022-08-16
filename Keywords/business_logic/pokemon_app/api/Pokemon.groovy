package business_logic.pokemon_app.api

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
import api_clients.pokemon_app.PokemonAPIClient
import com.kms.katalon.core.testobject.ResponseObject
import groovy.json.JsonSlurper
import groovy.json.JsonOutput

public class PokemonLogic {

	public PokemonLogic() {}



	public boolean IsThereAPokemonWithThisName(String pokemonName) {
		PokemonAPIClient pokemonAPI = new PokemonAPIClient()
		ResponseObject response = pokemonAPI.pokemon_byName_GET(pokemonName)
		if(response.statusCode == 200) {
			return true
		}
		else {

			return false
		}
	}


	public boolean IsThereAPokemonWithThisNumber(int pokemonNumber) {
		PokemonAPIClient pokemonAPI = new PokemonAPIClient()
		ResponseObject response = pokemonAPI.pokemon_byNumber_GET(pokemonNumber)
		if(response.statusCode == 200) {
			return true
		}
		else {

			return false
		}
	}


	public ResponseObject ReturnAllInformationFromPokemonWithThisName(String pokemonName) {
		boolean exist = this.IsThereAPokemonWithThisName(pokemonName)
		PokemonAPIClient pokemonAPI = new PokemonAPIClient()
		ResponseObject response = pokemonAPI.pokemon_byName_GET(pokemonName)
		if(!exist) {
			System.out.println("ReturnAllInformationFromPokemonWithThisName() didnt return information for Pokemon named: "+pokemonName)
		}
		return response
	}


	public ResponseObject ReturnAllInformationFromPokemonWithThisNumber(int pokemonNumber) {
		boolean exist = this.IsThereAPokemonWithThisNumber(pokemonNumber)
		PokemonAPIClient pokemonAPI = new PokemonAPIClient()
		ResponseObject response = pokemonAPI.pokemon_byNumber_GET(pokemonNumber)
		if(!exist) {
			System.out.println("ReturnAllInformationFromPokemonWithThisNumber() didnt return information for Pokemon named: "+pokemonNumber)
		}
		return response
	}


	public String ReturnNameOfPokemonWithThisNumber(int pokemonNumber) {
		String name = null
		ResponseObject response = this.ReturnAllInformationFromPokemonWithThisNumber(pokemonNumber)
		if(response.statusCode == 200) {
			JsonSlurper slurper = new JsonSlurper()
			Map data = slurper.parseText(response.getResponseText())
			name = data["name"]
		}
		else {
			System.out.println("ReturnNameOfPokemonWithThisNumber() didnt return information for Pokemon number: "+pokemonNumber)
		}
		return name
	}

	public int ReturnNumberOfPokemonWithThisName(String pokemonName) {
		int number = -1
		ResponseObject response = this.ReturnAllInformationFromPokemonWithThisName(pokemonName)
		if(response.statusCode == 200) {
			JsonSlurper slurper = new JsonSlurper()
			Map data = slurper.parseText(response.getResponseText())
			number = data["id"]
		}
		else {
			System.out.println("ReturnNumberOfPokemonWithThisName() didnt return information for Pokemon number: "+pokemonName)
		}
		return number
	}
}
