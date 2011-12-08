package org.hyperion.rs2.gameevent;

/**
 * An abstract class providing the functionality of producing an {@link Event}
 * instance to the core {@link EventProcessor}.
 * 
 * @author Blake Beaupain
 */
public class EventProducer {

	/**
	 * Produces an <code>Event</code>. The event is broadcasted through the
	 * <code>EventProcessor</code> singleton instance.
	 * 
	 * @param event
	 *            The event to produce
	 */
	public final void produce(Event event) {
		produce(event, false);
	}
	
	/**
	 * Produces an <code>Event</code>. The event is broadcasted through the
	 * <code>EventProcessor</code> singleton instance.
	 * 
	 * @param event
	 *            The event to produce
	 * @param interrupt
	 * 			  Whether to allow a ConsumerInterruptor to be thrown
	 */
	public final void produce(Event event, boolean interrupt) {
		EventProcessor.getInstance().broadcast(event, interrupt);
	}
}
