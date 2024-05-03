package me.asakura_kukii.plutoarknights.argument.command;

import me.asakura_kukii.siegecore.argument.PArgument;
import me.asakura_kukii.siegecore.argument.PSender;
import me.asakura_kukii.siegecore.io.PType;
import me.asakura_kukii.siegecore.util.math.PVector;
import org.bukkit.entity.Player;

public class CommandHandler {

    public static boolean onCommand(PSender sender, PArgument argument) {
        sender.nextLine();
        sender.log("Issued:");
        sender.raw(">> " + argument.colorize());

        String s = argument.nextString();
        if (!argument.success) {
            sender.error("Missing sub-argument");
            return false;
        }

        switch (s) {
            case "info":
                return onInfo(sender, argument);
            default:
                sender.error("Invalid sub-argument");
                return false;
        }
    }

    public static boolean onInfo(PSender sender, PArgument argument) {
        sender.info("Standby!");
        return true;
    }
}
