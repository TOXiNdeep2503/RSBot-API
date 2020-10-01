package org.powerbot.script.rt4.webwalk.handlers;

import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.webwalk.conditions.HandlerCondition;

public abstract class AbstractActionHandler {

	protected final Tile source;
	protected final Tile target;

	public AbstractActionHandler(final Tile source, final Tile target) {
		this.source = source;
		this.target = target;
	}

	public abstract boolean interact(final ClientContext ctx);

	public abstract boolean valid(final ClientContext ctx);

	public abstract HandlerCondition success();

	public Tile getSource() {
		return source;
	}

	public Tile getTarget() {
		return target;
	}
}
