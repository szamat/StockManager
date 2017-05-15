package manager.stock.bss.bme.hu.stockmanager;


import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowLog;

public class TestHelper {

	public static void setTestInjector() {
		ShadowLog.stream = System.out;
		StockApplication application = (StockApplication) RuntimeEnvironment.application;
		StockApplicationComponent injector = DaggerTestComponent.builder().testModule(new TestModule(application.getApplicationContext())).build();
		application.setInjector(injector);
	}
}
