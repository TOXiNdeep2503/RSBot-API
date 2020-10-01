package org.powerbot.script.rt4.webwalk;

import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.webwalk.handlers.AbstractActionHandler;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class WebPath {

	private final Deque<WebEdge> stack = new ArrayDeque<>();

	public WebPath(final List<WebNode> nodes) {
		if (nodes.size() < 2) {
			return;
		}
		for (int i = 1; i < nodes.size(); i++) {
			final WebNode curr = nodes.get(i - 1);
			final WebNode next = nodes.get(i);
			stack.push(curr.edgeTo(next));
		}
	}

	public boolean traverse(final ClientContext ctx) {
		if (!valid()) {
			return false;
		}
		final WebEdge edge = stack.pop();
		if (edge == null) {
			return false;
		}
		final AbstractActionHandler action = edge.getHandler();
		if (!action.valid(ctx)) {
			return false;
		}
		return action.interact(ctx);
	}

	public boolean valid() {
		return !stack.isEmpty();
	}
}
