package lib.securebit;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public class InfoLayout {

	protected String colorPrimary;
	protected String colorSecondary;
	protected String colorImportant;
	protected String colorPositiv;
	protected String colorNegative;
	protected String prefix;
	
	protected List<String> transaction;
	
	public InfoLayout() {
		this("");
	}
	
	public InfoLayout(String prefix) {
		this.colorPrimary = "§8";
		this.colorSecondary = "§3";
		this.colorImportant = "§b";
		this.colorPositiv = "§f";
		this.colorNegative = "§c";
		this.prefix = prefix;
		
		this.transaction = new ArrayList<String>();
	}
	
	public void message(CommandSender sender, String text) {
		sender.sendMessage(this.prefix + this.format(this.colorSecondary + text));
	}
	
	public void broadcast(String text) {
		Bukkit.broadcastMessage(this.prefix + this.format(this.colorSecondary + text));
	}

	public void begin() {
		this.transaction.clear();
	}

	public void commit(CommandSender cs) {
		while (this.transaction.size() > 0) {
			cs.sendMessage(this.transaction.remove(0)); // FIFO (first in, first out)
		}
	}

	public void rollback() {
		this.transaction.clear();
	}
	
	public void category(String name) {
		this.barrier();
		this.line("*" + name + "*");
	}
	
	public void barrier() {
		String barrier = "=======================================================";
		this.transaction.add(this.prefix + this.colorPrimary + barrier);
	}
	
	public void line(String text) {
		this.transaction.add(this.prefix + this.colorSecondary + this.format(text));
	}
	
	public void suggestion(String commandLine, String description) {
		if (description != null) {
			description = this.format(description);
		}
		
		this.transaction.add(this.colorSecondary + "/" + commandLine + 
				(description == null || description.isEmpty() || description.trim().isEmpty() ? "" : this.colorPrimary + " - " + this.colorSecondary + description));
	}


	public void prefix(String newPrefix) {
		this.prefix = newPrefix;
	}

	public boolean hasPrefix() {
		return this.prefix != null && !this.prefix.isEmpty();
	}

	public String prefix() {
		return this.prefix;
	}
	
	public String format(String text) {
		text = text.replaceAll("\\*(.+)\\*", this.colorImportant + "$1" + this.colorSecondary);
		text = text.replaceAll("-(.+)-", this.colorNegative + "$1" + this.colorSecondary);
		text = text.replaceAll("\\+(.+)\\+", this.colorPositiv + "$1" + this.colorSecondary);
		text = text.replace("\\pre", this.prefix);
		return text;
	}
	
}
