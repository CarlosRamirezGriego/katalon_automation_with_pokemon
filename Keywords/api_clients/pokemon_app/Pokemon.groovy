package api_clients.pokemon_app

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
import com.kms.katalon.core.testobject.ResponseObject
import business_logic.pokemon_app.common.APICore

public class PokemonAPIClient {

	public String baseURL = "https://pokeapi.co/"
	
	public PokemonAPIClient()
	{
		
	}

	public ResponseObject pokemon_byName_GET(String pokemonName) {
		String directory =  "api/v2/pokemon/"+pokemonName.toLowerCase()
		APICore client = new APICore(this.baseURL, directory)
		client.AddHeaderToRequest("Accept", "application/json, text/plain, */*")
		client.BuildGetRequest()
		ResponseObject response = client.ExecuteAPICall()
		return response
	}

	public ResponseObject pokemon_byNumber_GET(int pokemonNumber) {
		String directory =  "api/v2/pokemon/"+pokemonNumber.toString()
		APICore client = new APICore(this.baseURL, directory)
		client.AddHeaderToRequest("Accept", "application/json, text/plain, */*")
		client.BuildGetRequest()
		ResponseObject response = client.ExecuteAPICall()
		return response
	}
}
