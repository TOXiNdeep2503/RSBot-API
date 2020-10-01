package org.powerbot.script.rt4.webwalk;

import org.powerbot.script.rt4.webwalk.handlers.AbstractActionHandler;

public class WebEdge {

	private final WebNode target;
	private final float weight;
	private final AbstractActionHandler handler;

	public WebEdge(final WebNode target, final float weight, final AbstractActionHandler handler) {
		this.target = target;
		this.weight = weight;
		this.handler = handler;
	}

	public WebNode getTarget() {
		return target;
	}

	public float getWeight() {
		return weight;
	}

	public AbstractActionHandler getHandler() {
		return handler;
	}
}
