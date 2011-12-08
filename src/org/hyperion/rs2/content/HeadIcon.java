package org.hyperion.rs2.content;

/**
 * An enum containing headicon ids
 * 
 * @author Nikki
 */
public enum HeadIcon {

	NONE(-1);

	/**
	 * The headicon id
	 */
	private int headIconId = -1;

	/**
	 * Create a headicon with the specified id
	 * 
	 * @param headIconId
	 *            The id to set
	 */
	private HeadIcon(int headIconId) {
		this.headIconId = headIconId;
	}

	/**
	 * Get the headicon's id
	 * 
	 * @return The id associated with the headicon
	 */
	public int asInt() {
		return headIconId;
	}
}
