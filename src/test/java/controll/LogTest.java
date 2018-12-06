package controll;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

/**
 * Created by marck on 05.12.2018.
 */
public class LogTest {

    private static final Logger LOG = LogManager.getLogger(LogTest.class);

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        PropertyConfigurator.configureAndWatch( "log.iml", 60*1000 );
    }

    @Test
    public void test() {
        LOG.debug("This Will Be Printed On Debug");
        LOG.info("Appending string: {}.");
    }
}
