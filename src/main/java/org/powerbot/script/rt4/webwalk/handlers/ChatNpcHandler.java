package org.powerbot.script.rt4.webwalk.handlers;

import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

public class ChatNpcHandler extends DefaultNpcHandler {

	private final String[] conversation;

	public ChatNpcHandler(final Tile source, final Tile target, final String npcName, final String action, final String... conversation) {
		super(source, target, npcName, action);
		this.conversation = conversation;
	}

	@Override
	public boolean interact(final ClientContext ctx) {
		if (!super.interact(ctx)) {
			return false;
		}

		if (!Condition.wait(() -> ctx.chat.chatting(), 500, 8)) {
			return false;
		}

		for (final String option : conversation) {
			ctx.chat.continueChat(option);
		}

		return !ctx.chat.chatting();
	}
}
