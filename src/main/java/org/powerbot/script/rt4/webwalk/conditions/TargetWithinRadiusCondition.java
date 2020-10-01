package org.powerbot.script.rt4.webwalk.conditions;

import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.webwalk.handlers.AbstractActionHandler;

public class TargetWithinRadiusCondition implements HandlerCondition {

	private final int radius;

	public TargetWithinRadiusCondition(final int radius) {
		this.radius = radius;
	}

	@Override
	public boolean check(final ClientContext ctx, final AbstractActionHandler handler) {
		return handler.getTarget().distanceTo(ctx.players.local()) <= radius;
	}
}
