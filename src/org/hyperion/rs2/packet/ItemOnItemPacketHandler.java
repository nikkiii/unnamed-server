package org.hyperion.rs2.packet;

import org.hyperion.rs2.gameevent.EventProducer;
import org.hyperion.rs2.gameevent.impl.ItemOnItemEvent;
import org.hyperion.rs2.model.Item;
import org.hyperion.rs2.model.Player;
import org.hyperion.rs2.net.Packet;

/**
 * A class to handle skills like Herblore, Firemaking and Fletching (To name a
 * few)
 * 
 * @author Nikki
 */
public class ItemOnItemPacketHandler extends EventProducer implements
		PacketHandler {

	@Override
	public void handle(Player player, Packet packet) {
		int usedSlot = packet.getShort();
		int usedWithSlot = packet.getShortA();
		int usedWith = packet.getLEShortA();
		packet.getShort();
		int usedId = packet.getLEShort();
		packet.getShort();

		Item useItem = player.getInventory().get(usedSlot);
		Item useWithItem = player.getInventory().get(usedWithSlot);
		if (useItem.getId() == usedId && useWithItem.getId() == usedWith) {
			produce(new ItemOnItemEvent(player, useItem, useWithItem));
		}
	}
}
