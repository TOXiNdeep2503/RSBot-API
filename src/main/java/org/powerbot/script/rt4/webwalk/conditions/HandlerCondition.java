package org.powerbot.script.rt4.webwalk.conditions;

import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.webwalk.handlers.AbstractActionHandler;

public interface HandlerCondition {

	boolean check(final ClientContext ctx, final AbstractActionHandler handler);
}
