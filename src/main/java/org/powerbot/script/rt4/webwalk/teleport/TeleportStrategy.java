package org.powerbot.script.rt4.webwalk.teleport;

import org.powerbot.script.rt4.ClientContext;

public interface TeleportStrategy {

	boolean teleport(final ClientContext ctx);

	boolean canTeleport(final ClientContext ctx);
}
