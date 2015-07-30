package eu.securebit.command;

import lib.securebit.InfoLayout;

public final class LayoutCommandSettings implements CommandSettings {

	private final String messagePrefix;
	private final String messageNoPermission;
	private final String messageSyntax;
	private final String messageOnlyPlayer;
	private final String messageDefault;
	
	private final InfoLayout layout;

	public LayoutCommandSettings(InfoLayout layout) {
		this.layout = layout;

		this.messagePrefix = this.layout.prefix();
		this.messageNoPermission = this.layout.format("-Du hast hierzu keine Berechtigung.-");
		this.messageSyntax = this.layout.format("-Syntax: %s-");
		this.messageOnlyPlayer = this.layout.format("-Dieser Befehl ist nur für Spieler.-");
		this.messageDefault = this.layout.format("-Bitte benutze ein spezifisches Argument.-");
	}
	
	@Override
	public String getMessagePrefix() {
		return this.messagePrefix;
	}

	@Override
	public String getMessageNoPermission() {
		return this.messageNoPermission;
	}

	@Override
	public String getMessageSyntax() {
		return this.messageSyntax;
	}

	@Override
	public String getMessageOnlyPlayer() {
		return this.messageOnlyPlayer;
	}

	@Override
	public String getMessageDefault() {
		return this.messageDefault;
	}
}
