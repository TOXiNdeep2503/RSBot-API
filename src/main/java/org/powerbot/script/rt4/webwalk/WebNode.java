package org.powerbot.script.rt4.webwalk;

import org.powerbot.script.rt4.webwalk.handlers.AbstractActionHandler;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WebNode implements Serializable {

	protected int x, y, z;
	private final Map<WebNode, WebEdge> edges = new HashMap<>();

	public WebNode(final int x, final int y) {
		this(x, y, 0);
	}

	public WebNode(final int x, final int y, final int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public void addEdge(final WebNode node, final AbstractActionHandler action) {
		edges.put(node, new WebEdge(node, distanceTo(node), action));
	}

	public int x() {
		return x;
	}

	public int y() {
		return y;
	}

	public int z() {
		return z;
	}

	public WebEdge edgeTo(final WebNode target) {
		return edges.getOrDefault(target, null);
	}

	public Collection<WebEdge> edges() {
		return edges.values();
	}

	public float distanceTo(final WebNode node) {
		return distanceTo(node.x, node.y);
	}

	public float distanceTo(final int x, final int y) {
		return (float) Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2));
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final WebNode that = (WebNode) o;
		return x == that.x && y == that.y && edges.equals(that.edges);
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y, z, edges);
	}

	@Override
	public String toString() {
		return "WebNode{" +
				"x=" + x +
				", y=" + y +
				", z=" + z +
				'}';
	}
}
