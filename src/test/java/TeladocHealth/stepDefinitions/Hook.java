package TeladocHealth.stepDefinitions;
import TeladocHealth.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import java.util.concurrent.TimeUnit;

public class Hook {
    @Before
    public void setUp(){
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);    }
    @After
    public void tearDown() {
        Driver.closeDriver();
    }

}
