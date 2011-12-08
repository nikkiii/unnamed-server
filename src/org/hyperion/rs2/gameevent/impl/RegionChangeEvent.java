package org.hyperion.rs2.gameevent.impl;

import org.hyperion.rs2.gameevent.Event;
import org.hyperion.rs2.model.Player;

/**
 * An event which is called when a player changes regions.
 * 
 * @author Nikki
 * 
 */
public class RegionChangeEvent implements Event {

	/**
	 * The player this event belongs to
	 */
	private Player player;

	/**
	 * Create an event for the player
	 * 
	 * @param player
	 *            The player
	 */
	public RegionChangeEvent(Player player) {
		this.player = player;
	}

	/**
	 * Get the player
	 * 
	 * @return The player
	 */
	public Player getPlayer() {
		return player;
	}
}
