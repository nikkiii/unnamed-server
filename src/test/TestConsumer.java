package test;

import java.util.logging.Logger;

import org.hyperion.rs2.gameevent.Event;
import org.hyperion.rs2.gameevent.EventConsumer;
import org.hyperion.rs2.gameevent.impl.PlayerLoginEvent;
import org.hyperion.rs2.gameevent.impl.PlayerLoginEvent.PlayerLogin;
import org.hyperion.rs2.gameevent.impl.PlayerLoginEvent.PlayerLogout;

public class TestConsumer extends EventConsumer {

	public TestConsumer() {
		bind(PlayerLogin.class, PlayerLogout.class);
	}
	
	@Override
	public void consume(Event event) {
		PlayerLoginEvent evt = (PlayerLoginEvent) event;
		if(evt.isPlayerLogin()) {
			Logger.getAnonymousLogger().info("Player "+evt.getPlayer()+" logged in [PLUGIN]");
		} else {
			Logger.getAnonymousLogger().info("Player "+evt.getPlayer()+" logged out [PLUGIN]");
		}
	}

}
