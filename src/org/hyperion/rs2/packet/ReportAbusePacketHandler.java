package org.hyperion.rs2.packet;

import org.hyperion.rs2.model.Player;
import org.hyperion.rs2.model.World;
import org.hyperion.rs2.net.Packet;
import org.hyperion.rs2.util.NameUtils;

public class ReportAbusePacketHandler implements PacketHandler {

	@SuppressWarnings("unused")
	@Override
	public void handle(Player player, Packet packet) {
		String name = NameUtils.longToName(packet.getLong());
		int rule = packet.get();
		boolean mute = (packet.get() == 1);
		if (!World.getWorld().isPlayerOnline(name)) {
			player.getActionSender().sendMessage("This player is not online.");
			return;
		}
		if (mute) {
			if (player.getRights().toInteger() >= 1) {
				// TODO mute
			} else {
				// They are trying to cheat a mute!
			}
		}
		//TODO save a report/snippet of chat from the last 60 seconds
		player.getActionSender().sendMessage(
				"Thank-you, your abuse report has been received.");
	}
}
