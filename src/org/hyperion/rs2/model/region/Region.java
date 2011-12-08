package org.hyperion.rs2.model.region;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.hyperion.rs2.model.GameObject;
import org.hyperion.rs2.model.Location;
import org.hyperion.rs2.model.NPC;
import org.hyperion.rs2.model.Player;
import org.hyperion.util.Filter;

/**
 * Represents a single region.
 * @author Graham Edgecombe
 *
 */
public class Region {

	/**
	 * The region coordinates.
	 */
	private RegionCoordinates coordinate;
	
	/**
	 * A list of players in this region.
	 */
	private List<Player> players = new LinkedList<Player>();
	
	/**
	 * A list of NPCs in this region.
	 */
	private List<NPC> npcs = new LinkedList<NPC>();
	
	/**
	 * A list of objects in this region.
	 */
	private List<GameObject> objects = new LinkedList<GameObject>();
	
	/**
	 * Creates a region.
	 * @param coordinate The coordinate.
	 */
	public Region(RegionCoordinates coordinate) {
		this.coordinate = coordinate;
	}
	
	/**
	 * Gets the region coordinates.
	 * @return The region coordinates.
	 */
	public RegionCoordinates getCoordinates() {
		return coordinate;
	}

	/**
	 * Gets the list of players.
	 * @return The list of players.
	 */
	public Collection<Player> getPlayers() {
		synchronized(this) {
			return Collections.unmodifiableCollection(new LinkedList<Player>(players));
		}
	}
	
	/**
	 * Gets the list of NPCs.
	 * @return The list of NPCs.
	 */
	public Collection<NPC> getNpcs() {
		synchronized(this) {
			return Collections.unmodifiableCollection(new LinkedList<NPC>(npcs));
		}
	}
	
	/**
	 * Get an object, matching to the filter specifications
	 * 
	 * @param filter
	 *            The filter to check vs objects
	 * @return The object if found
	 */
	public GameObject getObject(Filter<GameObject> filter) {
		for (GameObject object : objects) {
			if (filter.accept(object)) {
				return object;
			}
		}
		return null;
	}

	/**
	 * Get an object by creating a filter to match id and location
	 * 
	 * @param id
	 *            The id of the object
	 * @param loc
	 *            The location of the object
	 * @return The object if found
	 */
	public GameObject getObject(final int id, final Location loc) {
		return getObject(new Filter<GameObject>() {
			@Override
			public boolean accept(GameObject t) {
				return t.getDefinition().getId() == id
						&& t.getLocation().equals(loc);
			}
		});
	}

	/**
	 * Get an object at the specified location
	 * 
	 * @param location
	 *            The location
	 * @return The object if found
	 */
	public GameObject getObjectAt(final Location location) {
		return getObject(new Filter<GameObject>() {
			@Override
			public boolean accept(GameObject t) {
				return t.getLocation().equals(location);
			}
		});
	}
	
	/**
	 * Gets the list of objects.
	 * @return The list of objects.
	 */
	public Collection<GameObject> getGameObjects() {
		return objects;
	}

	/**
	 * Adds a new player.
	 * @param player The player to add.
	 */
	public void addPlayer(Player player) {
		synchronized(this) {
			players.add(player);
		}
	}

	/**
	 * Removes an old player.
	 * @param player The player to remove.
	 */
	public void removePlayer(Player player) {
		synchronized(this) {
			players.remove(player);
		}
	}

	/**
	 * Adds a new NPC.
	 * @param npc The NPC to add.
	 */
	public void addNpc(NPC npc) {
		synchronized(this) {
			npcs.add(npc);
		}
	}

	/**
	 * Removes an old NPC.
	 * @param npc The NPC to remove.
	 */
	public void removeNpc(NPC npc) {
		synchronized(this) {
			npcs.remove(npc);
		}
	}
}
