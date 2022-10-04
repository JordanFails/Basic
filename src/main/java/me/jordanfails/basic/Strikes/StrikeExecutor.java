package me.jordanfails.basic.Strikes;

import LorexMC.us.utils.other.command.ArgumentExecutor;
import me.jordanfails.basic.Basic;
import me.jordanfails.basic.Strikes.args.StrikeCheckArgument;

public class StrikeExecutor extends ArgumentExecutor {


    public StrikeExecutor(Basic plugin) {
        super("strike");
        addArgument(new StrikeCheckArgument(plugin));
    }
}
