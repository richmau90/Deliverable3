package com.bdd.newDictionary;

import cucumber.api.junit.*;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(
		format={"pretty", "html:target/cucumber"},
		features={"src/test/resources"})
public class CukesRunner {}

