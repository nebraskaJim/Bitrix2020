package com.bitrix.Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@CucumberOptions(

        plugin = {"pretty",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"
        },
        features = {"src/test/resources/features/UserStory1",
                "src/test/resources/features/UserStory1",
                "src/test/resources/features/UserStory1"

        },

        glue  = "com/bitrix/step_definitions"
        //dryRun = false,
        //tags="@contact"
)
@RunWith(Cucumber.class)
public class RegressionRunner {
}
