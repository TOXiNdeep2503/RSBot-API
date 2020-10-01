package org.powerbot.script.rt4.webwalk.conditions;

import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.webwalk.handlers.AbstractActionHandler;

public class TargetReachableCondition implements HandlerCondition {

	@Override
	public boolean check(final ClientContext ctx, final AbstractActionHandler handler) {
		return handler.getTarget().matrix(ctx).reachable();
	}
}
