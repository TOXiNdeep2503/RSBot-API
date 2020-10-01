package org.powerbot.script.rt4.webwalk.handlers;

import java.util.regex.Pattern;

public enum ObstacleType {
	DOOR("((.*)?door)|gate|"),
	STAIR_UP("ladder|staircase|stairs"),
	STAIR_DOWN(STAIR_UP.getRegex() + "|manhole");

	private final Pattern pattern;
	private final String regex;

	ObstacleType(final String regex) {
		this.regex = regex;
		this.pattern = Pattern.compile(regex);
	}

	public String getRegex() {
		return regex;
	}

	public Pattern getPattern() {
		return pattern;
	}
}
