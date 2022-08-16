package business_logic.pokemon_app.common

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
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.RestRequestObjectBuilder
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.FormDataBodyParameter
import com.kms.katalon.core.testobject.TestObjectProperty

import internal.GlobalVariable

public class APICore {
	private String Url
	private String Directory
	private RequestObject Client
	ArrayList DefaultHeaders = new ArrayList()
	ArrayList<FormDataBodyParameter> BodyFormDataParameters = new ArrayList<FormDataBodyParameter>()


	public APICore(String url, String dir){
		this.Url = url
		this.Directory = dir
	}

	public void BuildGetRequest() {
		Client = new RestRequestObjectBuilder()
				.withRestUrl("${Url}${Directory}")
				.withHttpHeaders(DefaultHeaders)
				.withRestRequestMethod("GET")
				.build()
	}

	public void BuildPostRequest() {
		Client = new RestRequestObjectBuilder()
				.withRestUrl("${Url}${Directory}")
				.withHttpHeaders(DefaultHeaders)
				.withRestRequestMethod("POST")
				.withMultipartFormDataBodyContent(BodyFormDataParameters)
				.build()
	}

	public void BuildPutRequest() {
		Client = new RestRequestObjectBuilder()
				.withRestUrl("${Url}${Directory}")
				.withHttpHeaders(DefaultHeaders)
				.withRestRequestMethod("PUT")
				.withMultipartFormDataBodyContent(BodyFormDataParameters)
				.build()
	}



	public void AddAuthorizationHeader(String token) {
		TestObjectProperty header = new TestObjectProperty("Authorization", ConditionType.EQUALS, "Bearer ${token}" )
		DefaultHeaders.add(header)
	}

	public void AddJsonHeaderToRequest() {
		TestObjectProperty header = new TestObjectProperty("Content-Type", ConditionType.EQUALS, "application/json")
		DefaultHeaders.add(header)
	}

	public void AddFormDataBodyParameter(String key, String value, String mimeType, String contentType) {
		def parameter = new FormDataBodyParameter(key, value, mimeType, contentType)
		BodyFormDataParameters.add(parameter)
	}

	public void AddHeaderToRequest(String key, String value) {
		TestObjectProperty header = new TestObjectProperty(key, ConditionType.EQUALS, value)
		DefaultHeaders.add(header)
	}

	public void AddBodyContent(String body) {
		Client.setBodyContent(new HttpTextBodyContent(body));
	}

	public ResponseObject  ExecuteAPICall() {
		ResponseObject respObj = WS.sendRequest(Client)
		return respObj
	}
}
