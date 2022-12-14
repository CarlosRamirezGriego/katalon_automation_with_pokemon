import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import business_logic.pokemon_app.common.CommonUI
import business_logic.pokemon_app.ui.MainPage
import business_logic.pokemon_app.ui.NationalDexPage
import business_logic.pokemon_app.api.PokemonLogic

/*** Import Libraries ***/

CommonUI commonUi = new CommonUI()
MainPage mainPage = new MainPage()
NationalDexPage natPage = new NationalDexPage()
PokemonLogic pkAPI = new PokemonLogic()

/*** Steps Execution UI ***/

commonUi.NavigateToPokemonDBHomePage()
mainPage.NavigateToPokedexFromQuickLinksMenu()
System.out.println(natPage.DoesAPokemonWithThisNameExist("Pikachu"))
System.out.println(natPage.DoesAPokemonWithThisNumberExist(25))
System.out.println(natPage.ReturnNumberOfPokemonWithThisName("Pikachu"))
System.out.println(natPage.ReturnNameOfPokemonWithThisNumber(25))
natPage.ClickPokemonWithThisName("Mewtwo")

sleep(5000)


/*** Steps Execution API ***/
System.out.println(pkAPI.ReturnNameOfPokemonWithThisNumber(25))
System.out.println(pkAPI.ReturnNumberOfPokemonWithThisName("Pikachu"))
