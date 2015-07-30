package eu.securebit.command;

public abstract interface CommandSettings {
	
	public abstract String getMessagePrefix();

	public abstract String getMessageNoPermission();

	public abstract String getMessageSyntax();

	public abstract String getMessageOnlyPlayer();

	public abstract String getMessageDefault();
	
}
