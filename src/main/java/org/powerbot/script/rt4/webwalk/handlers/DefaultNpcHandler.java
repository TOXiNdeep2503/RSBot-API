package org.powerbot.script.rt4.webwalk.handlers;

import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Npc;
import org.powerbot.script.rt4.webwalk.conditions.HandlerCondition;
import org.powerbot.script.rt4.webwalk.conditions.TargetReachableCondition;

public class DefaultNpcHandler extends AbstractActionHandler {

	private final String npcName;
	private final String action;
	private Npc npc;

	public DefaultNpcHandler(final Tile source, final Tile target, final String npcName, final String action) {
		super(source, target);
		this.npcName = npcName;
		this.action = action;
	}

	@Override
	public boolean interact(final ClientContext ctx) {
		if (!npc.inViewport()) {
			ctx.camera.turnTo(npc);
		}
		return npc.interact(action);
	}

	@Override
	public boolean valid(final ClientContext ctx) {
		return (npc = ctx.npcs.select().name(npcName).action(action).nearest(source).poll()).valid();
	}

	@Override
	public HandlerCondition success() {
		return new TargetReachableCondition();
	}
}
