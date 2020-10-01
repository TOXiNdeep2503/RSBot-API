package org.powerbot.script.rt4.webwalk.handlers;

import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.LocalPath;
import org.powerbot.script.rt4.webwalk.conditions.HandlerCondition;
import org.powerbot.script.rt4.webwalk.conditions.TargetWithinRadiusCondition;

public class WalkHandler extends AbstractActionHandler {

	public WalkHandler(final Tile source, final Tile target) {
		super(source, target);
	}

	@Override
	public boolean interact(final ClientContext ctx) {
		final LocalPath localPath = ctx.movement.findPath(target);
		if (localPath.valid()) {
			return localPath.traverse();
		}
		return ctx.movement.step(target);
	}

	@Override
	public boolean valid(final ClientContext ctx) {
		return source.distanceTo(ctx.players.local()) <= 6 && target.matrix(ctx).reachable();
	}

	@Override
	public HandlerCondition success() {
		return new TargetWithinRadiusCondition(5);
	}
}
