package com.bdd.newDictionary;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

public class DictionaryStepDefs {
	
	/***************************** Feature: admin ***********************************/
	private String _file;
	@Given("^the dictionary text file$")
	public void the_dictionary_text_file() throws Throwable {
	   _file = "src/main/java/com/bdd/newDictionary/dictionary.txt";
	}

	private Dictionary _d = new Dictionary();
	private String _build_output;
	@When("^the program executes the build$")
	public void the_program_executes_the_build() throws Throwable {
	    _build_output = _d.buildDictionary(_file);
	}

	@Then("^the result is success$")
	public void the_result_is_success() throws Throwable {
	   assertEquals("success", _build_output);
	}

	@Given("^a missing dictionary text file$")
	public void a_missing_dictionary_text_file() throws Throwable {
	   _file = "";
	}

	@Then("^the result is failed$")
	public void the_result_is_failed() throws Throwable {
		assertEquals("failed", _build_output);
	}
	
	/***************************** Feature: admin2 **********************************/
	private Dictionary _d2 = new Dictionary();
	private Profile _temp2;
	@Given("^the user is not in the system$")
	public void the_user_is_not_in_the_system() throws Throwable {
	   _d2.initialize();
	   _temp2 = new Profile("Not", "in");
	}

	private String _create_output;
	@When("^I create the user$")
	public void I_create_the_user() throws Throwable {
	    _create_output = _d2.create_user(_temp2);
	}

	@Then("^the result is created user$")
	public void the_result_is_created_user() throws Throwable {
	    assertEquals("created user", _create_output);
	}

	private Dictionary _d21 = new Dictionary();
	private Profile _temp21;
	@Given("^the user is in the system$")
	public void the_user_is_in_the_system() throws Throwable {
	   _d21.initialize();
	   _temp21 = new Profile("user", "user");
	}
	
	private String _delete_output;
	@When("^I delete the user$")
	public void I_delete_the_user() throws Throwable {
	   _delete_output = _d21.delete_user(_temp21);
	}

	@Then("^the result is deleted user$")
	public void the_result_is_deleted_user() throws Throwable {
	  assertEquals("deleted user", _delete_output);
	}
	
	/***************************** Feature: user **********************************/
	private Dictionary _d3 = new Dictionary();
	@Given("^a user login screen$")
	public void a_user_login_screen() throws Throwable {
	    _d3.initialize();
	}

	private String _name;
	@When("^I enter the correct name$")
	public void I_enter_the_correct_name() throws Throwable {
	    _name = "user";
	}

	private String _password;
	@When("^correct password$")
	public void correct_password() throws Throwable {
	   _password = "user";
	}
	
	private String _check_output;
	@Then("^the result will be User Log In Successfully!!$")
	public void the_result_will_be_User_Log_In_Successfully_() throws Throwable {
	    _check_output = _d3.check_user(_name, _password);
	    assertEquals("User Log In Successfully!!", _check_output);
	}

	private String _password_wrong;
	@When("^incorrect password$")
	public void incorrect_password() throws Throwable {
	    _password_wrong = "wrong";
	}

	@Then("^the result will be Failed!! Wrong Password.$")
	public void the_result_will_be_Failed_Wrong_Password() throws Throwable {
	    _check_output = _d3.check_user(_name, _password_wrong);
	    assertEquals("Failed!! Wrong Password.", _check_output);
	}

	private String _name_wrong;
	@When("^I enter the incorrect name$")
	public void I_enter_the_incorrect_name() throws Throwable {
	   _name_wrong = "wrong";
	}

	@Then("^the result will be Failed!! Wrong User Name.$")
	public void the_result_will_be_Failed_Wrong_User_Name() throws Throwable {
	    _check_output = _d3.check_user(_name_wrong, _password);
	    assertEquals("Failed!! Wrong User Name.", _check_output);
	}

	@Then("^the result will be Failed!! Wrong User Name and Password$")
	public void the_result_will_be_Failed_Wrong_User_Name_and_Password() throws Throwable {
	    _check_output = _d3.check_user(_name_wrong, _password_wrong);
	    assertEquals("Failed!! Wrong User Name and Password", _check_output);
	}

	/***************************** Feature: user2 **********************************/
	private Dictionary _d4 = new Dictionary();
	private String _file4;
	@Given("^an input screen$")
	public void an_input_screen() throws Throwable {
		_file4 = "src/main/java/com/bdd/newDictionary/dictionary.txt";
		_d4.buildDictionary(_file4);
	}

	private String _prefix;
	private String _word_output;
	@When("^I enter a prefix$")
	public void I_enter_a_prefix() throws Throwable {
	    _prefix = "abe";
	    _word_output = _d4.check_word(_prefix);
	}
	
	@Then("^the result will be a prefix$")
	public void the_result_will_be_a_prefix() throws Throwable {
	   assertEquals("a prefix", _word_output);
	}

	private String _word;
	@When("^I enter a word$")
	public void I_enter_a_word() throws Throwable {
	    _word = "hives";
	    _word_output = _d4.check_word(_word);
	}

	@Then("^the result will be a word$")
	public void the_result_will_be_a_word() throws Throwable {
	   assertEquals("a word", _word_output);
	}

	private String _prefix_word;
	@When("^I enter a prefix word$")
	public void I_enter_a_prefix_word() throws Throwable {
	   _prefix_word = "abet";
	   _word_output = _d4.check_word(_prefix_word);
	}

	@Then("^the result will be a prefix and word$")
	public void the_result_will_be_a_prefix_and_word() throws Throwable {
	   assertEquals("a prefix and word", _word_output);
	}

	private String _invalid;
	@When("^I enter an invalid$")
	public void I_enter_an_invalid() throws Throwable {
	    _invalid = "1";
	    _word_output = _d4.check_word(_invalid);
	}

	@Then("^the result will be not found$")
	public void the_result_will_be_not_found() throws Throwable {
	   assertEquals("not found", _word_output);
	}
	
	/***************************** Feature: holder **********************************/
	private Dictionary _d5 = new Dictionary();
	private String _file5;
	@Given("^a dictionary$")
	public void a_dictionary() throws Throwable {
  		_file5 = "src/main/java/com/bdd/newDictionary/dictionary.txt";
  		_d5.buildDictionary(_file5);
	}

	private String _input;
	@Given("^authorization screen$")
	public void authorization_screen() throws Throwable {
   		_input = "y";
	}

	private String _holder_output;
	@When("^I enter y$")
	public void I_enter_y() throws Throwable {
   		_holder_output = _d5.authorize(_input);
	}

	@Then("^the dictionary will be authorized$")
	public void the_dictionary_will_be_authorized() throws Throwable {
    	assertEquals("authorized", _holder_output);
	}

	@When("^I enter n$")
	public void I_enter_n() throws Throwable {
	   _input = "n";
	   _holder_output = _d5.authorize(_input);
	}
	
	@Then("^the dictionary will be unauthorized$")
	public void the_dictionary_will_be_unauthorized() throws Throwable {
	    assertEquals("unauthorized", _holder_output);
	}
}
