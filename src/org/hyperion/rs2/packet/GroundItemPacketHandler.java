package org.hyperion.rs2.packet;

import org.hyperion.rs2.model.Item;
import org.hyperion.rs2.model.Player;
import org.hyperion.rs2.net.Packet;

public class GroundItemPacketHandler implements PacketHandler {

	private static final int DROP_ITEM = 87, PICKUP_ITEM = 236;

	@Override
	public void handle(Player player, Packet packet) {
		switch (packet.getOpcode()) {
		case DROP_ITEM:
			handleDropItem(player, packet);
			break;
		case PICKUP_ITEM:
			handlePickupItem(player, packet);
			break;
		}
	}

	/**
	 * Handle a drop item
	 * 
	 * @param player
	 *            The player
	 * @param packet
	 *            The packet
	 */
	private void handleDropItem(Player player, Packet packet) {
		int id = packet.getShortA();
		packet.getByte();
		packet.getByte();
		int slot = packet.getShortA();
		Item inventoryItem = player.getInventory().get(slot);
		if (inventoryItem != null) {
			if (inventoryItem.getId() == id) {
				player.getInventory().remove(slot, inventoryItem);
			}
		}
	}

	/**
	 * Handle a pickup item
	 * 
	 * @param player
	 *            The player
	 * @param packet
	 *            The packet
	 */
	@SuppressWarnings("unused")
	private void handlePickupItem(Player player, Packet packet) {
		int y = packet.getLEShort();
		int id = packet.getShort();
		int x = packet.getLEShort();
		
	}
}
