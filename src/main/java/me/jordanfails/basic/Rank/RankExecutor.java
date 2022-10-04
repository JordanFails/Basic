package me.jordanfails.basic.Rank;

import LorexMC.us.utils.other.command.ArgumentExecutor;
import me.jordanfails.basic.Basic;
import me.jordanfails.basic.Rank.args.RankDeleteArgument;
import me.jordanfails.basic.Rank.args.RankGroupArgument;
import me.jordanfails.basic.Rank.args.RankSetArgument;

public class RankExecutor extends ArgumentExecutor {

    public RankExecutor(Basic plugin) {
        super("srank");

        addArgument(new RankSetArgument(plugin));
        addArgument(new RankGroupArgument(plugin));
        addArgument(new RankDeleteArgument(plugin));
        //addArgument(new TimerSetArgument(plugin));
    }
}
