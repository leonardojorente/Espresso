package com.leonardojorente.espressotests.DifferentTestScenariosWithoutProjectStructure;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BasicLoginEspressoTests.class,
        ToastMatcher.class
})
public class RunTestSuite {

}

//Process finished with exit code 1
//Class not found: "edu.macalester.comp124.hw0.AreaTest"Empty test suite.
//for this failure, the solution is: click the drop down right of the green hammer above, select edit configuration
//find the configuration related to the run of that class and press the - button to remove
//apply and run the class again to generate a new runner