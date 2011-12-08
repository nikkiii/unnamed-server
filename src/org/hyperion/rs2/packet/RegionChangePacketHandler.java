package org.hyperion.rs2.packet;

import org.hyperion.rs2.gameevent.EventProducer;
import org.hyperion.rs2.gameevent.impl.RegionChangeEvent;
import org.hyperion.rs2.model.Player;
import org.hyperion.rs2.net.Packet;

/**
 * An implementation of a <code>PacketHandler</code> which handles when regions
 * are loaded
 * 
 * @author Nikki
 * 
 */
public class RegionChangePacketHandler extends EventProducer implements
		PacketHandler {

	@Override
	public void handle(Player player, Packet packet) {
		//TODO ground items etc
		produce(new RegionChangeEvent(player));
	}
}
