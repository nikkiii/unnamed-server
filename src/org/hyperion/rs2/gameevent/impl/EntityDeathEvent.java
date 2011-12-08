package org.hyperion.rs2.gameevent.impl;

import org.hyperion.rs2.gameevent.Event;
import org.hyperion.rs2.model.Entity;


/**
 * Represents a player or npc death
 * 
 * @author Nikki
 *
 */
public class EntityDeathEvent implements Event {
	
	/**
	 * The entity
	 */
	private Entity entity;
	
	/**
	 * Create a new event..
	 * @param entity
	 * 			The entity
	 */
	public EntityDeathEvent(Entity entity) {
		this.entity = entity;
	}
	
	/**
	 * Get the entity
	 * @return
	 */
	public Entity getEntity() {
		return entity;
	}
}
