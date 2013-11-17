package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ArticulosParserTest.class, SolicitudArticulosParserTest.class,
		SolicitudCompraParserTest.class })
public class AllTests {

}
