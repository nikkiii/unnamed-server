package test;

import java.util.logging.Logger;

import org.hyperion.rs2.plugin.Plugin;

public class LoginTest extends Plugin {

	private static Logger logger = Logger.getLogger(LoginTest.class.getName());
	
	@Override
	public void onLoad() throws Exception {
		logger.info("Test Plugin loaded");
		new TestConsumer();
	}

	@Override
	public void onUnload() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
