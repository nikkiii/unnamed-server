package org.hyperion.rs2.packet;

import org.hyperion.rs2.action.impl.AttackAction;
import org.hyperion.rs2.gameevent.EventProducer;
import org.hyperion.rs2.gameevent.impl.NPCOptionEvent;
import org.hyperion.rs2.model.NPC;
import org.hyperion.rs2.model.Player;
import org.hyperion.rs2.model.World;
import org.hyperion.rs2.net.Packet;

public class NPCOptionPacketHandler extends EventProducer implements
		PacketHandler {

	private static final int ATTACK = 72, OPTION_1 = 155, OPTION_2 = 17;

	@Override
	public void handle(Player player, Packet packet) {
		switch (packet.getOpcode()) {
		case ATTACK:
			handleAttack(player, packet);
			break;
		case OPTION_1:
			handleOption1(player, packet);
			break;
		case OPTION_2:
			handleOption2(player, packet);
			break;
		}
	}

	private void handleAttack(Player player, Packet packet) {
		int index = packet.getShortA();
		NPC npc = World.getWorld().getNPC(index);
		npc.setInteractingEntity(player);
		player.getActionQueue().addAction(new AttackAction(player, npc));
	}

	private void handleOption1(Player player, Packet packet) {
		int index = packet.getLEShort();
		NPC npc = World.getWorld().getNPC(index);
		// Produce an event for the option
		produce(new NPCOptionEvent.NPCOption1(player, npc));
	}

	private void handleOption2(Player player, Packet packet) {
		int index = packet.getLEShortA();
		NPC npc = World.getWorld().getNPC(index);
		// Produce an event for the option
		produce(new NPCOptionEvent.NPCOption2(player, npc));
	}
}
