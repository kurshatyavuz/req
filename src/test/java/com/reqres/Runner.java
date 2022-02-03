package com.reqres;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin ={"json:target/cucumber.json"},
        features = {"src/test/resources/features"
        },
        glue={
                "com/reqres/step_definitions",
        },
        dryRun = false
)

public class Runner {



}
