package com.minnymin.command.example;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import com.minnymin.command.CommandFramework;
import com.minnymin.command.Completer;

/**
 * Command Framework - Demo <br>
 * A demo plugin demonstrating how the command framework works
 * 
 * @author minnymin3
 * 
 */
public class DemoPlugin extends JavaPlugin {

	/**
	 * Your plugin's command framework object.
	 */
	CommandFramework framework;

	public void onEnable() {
		/**Initializes a new CommandFramework object**/
		framework = new CommandFramework(this);
		
		/**
		 * This will register all the @Command and @Completer methods in this
		 * class. It can be done with any class.
		 * Note: Commands do not need to be registered in plugin.yml!
		 */
		framework.registerCommands(this);
		
		/**
		 * This will allow for the commands to be visible in the plugin's help
		 * ie. '/help demo'
		 */
		framework.registerHelp();
	}
	
	/**
	 * An example command. All commands are required to have a single
	 * CommandArgs argument
	 * 
	 * @param Commands
	 *            must have a CommandArgs argument
	 */
	@Command(name = "test", aliases = { "testing" }, description = "This is a test command", usage = "This is how you use it")
	public void testCommands(CommandArgs args) {
		args.getSender().sendMessage("This is a test command");
	}

	/**
	 * An example completer. All completers are required to have a single
	 * CommandArgs argument and return a string list
	 * 
	 * @param args
	 *            Completers must have a CommandArgs argument
	 * @return Must return a String List
	 */
	@Completer(name = "test", aliases = { "testing" })
	public List<String> testCompleter(CommandArgs args) {
		List<String> list = new ArrayList<String>();
		list.add("Hello");
		return list;
	}

	/**
	 * An example sub command with permission test.test, aliases as
	 * test.subcommand and testing.subcommand along with a custom permissions
	 * message for when the player does not have permission
	 */
	@Command(name = "test.sub", permission = "test.test", aliases = { "test.subcommand", "testing.subcommand",
			"testing.sub" }, noPerm = "You do not have permission to test!")
	public void testSubCommand(CommandArgs args) {
		args.getSender().sendMessage("This is a test subcommand");
	}

}
