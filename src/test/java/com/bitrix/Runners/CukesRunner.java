package com.bitrix.Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@CucumberOptions(

        plugin = {"pretty",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"
        },
        features = "src/test/resources/features/UserStory1",
        glue  = "com/bitrix/step_definitions",
        dryRun = false,
        tags="@checklist"
        //span[@title = 'Visual editor' and @id='lhe_button_editor_task-form-lifefeed_task_form']
)
@RunWith(Cucumber.class)
public class CukesRunner {
}
