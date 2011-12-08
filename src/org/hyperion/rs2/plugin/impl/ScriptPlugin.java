package org.hyperion.rs2.plugin.impl;

import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;

import org.hyperion.rs2.plugin.Plugin;
import org.hyperion.rs2.script.ScriptManager;

/**
 * A work around for the java SPI which usually registers the extensions,
 * this class will manually register script extensions etc from any factory which is set.
 * @author Nikki
 *
 */
public class ScriptPlugin extends Plugin {
	
	/**
	 * The factory this plugin runs on
	 */
	private ScriptEngineFactory factory;

	/**
	 * An empty factory until setFactory is called..
	 */
	public ScriptPlugin() {
		//We can use setFactory()
	}
	
	/**
	 * The proper constructor
	 * @param factory
	 * 			The factory this plugin represents
	 */
	public ScriptPlugin(ScriptEngineFactory factory) {
		this.factory = factory;
	}

	/**
	 * Unfortunately since using a URLClassLoader on a plugin file will not cause the spi to be loaded (?) (Could be wrong!)
	 * we should register it manually and deregister it also.
	 */
	@Override
	public void onLoad() throws Exception {
		ScriptEngineManager manager = ScriptManager.getEngineManager();
		for(String extension : factory.getExtensions()) {
			manager.registerEngineExtension(extension, factory);
		}
		for(String name : factory.getNames()) {
			manager.registerEngineName(name, factory);
		}
		for(String type : factory.getMimeTypes()) {
			manager.registerEngineMimeType(type, factory);
		}
	}

	/** 
	 * Unregister the factory extensions names and mime types by pointing them to a <code>null</code> object
	 */
	@Override
	public void onUnload() throws Exception {
		ScriptEngineManager manager = ScriptManager.getEngineManager();
		for(String extension : factory.getExtensions()) {
			manager.registerEngineExtension(extension, null);
		}
		for(String name : factory.getNames()) {
			manager.registerEngineName(name, null);
		}
		for(String type : factory.getMimeTypes()) {
			manager.registerEngineMimeType(type, null);
		}
	}
	
	/**
	 * Set the factory
	 * @param factory
	 * 			The factory
	 */
	public void setFactory(ScriptEngineFactory factory) {
		this.factory = factory;
	}
}
