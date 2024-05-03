package me.asakura_kukii.plutoarknights;

import me.asakura_kukii.plutoarknights.item.PDeco;
import me.asakura_kukii.plutoarknights.item.PEquipment;
import me.asakura_kukii.siegecore.SiegeCore;
import me.asakura_kukii.siegecore.argument.PArgument;
import me.asakura_kukii.siegecore.argument.PSender;
import me.asakura_kukii.siegecore.io.PFile;
import me.asakura_kukii.siegecore.io.PType;
import me.asakura_kukii.siegecore.util.format.PFormat;
import me.asakura_kukii.plutoarknights.argument.command.CommandHandler;
import me.asakura_kukii.plutoarknights.argument.tab.TabHandler;
import me.asakura_kukii.plutoarknights.effect.PParticle;
import me.asakura_kukii.plutoarknights.effect.PSound;
import me.asakura_kukii.plutoarknights.util.ItemDisplayHandler;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlutoArknights extends JavaPlugin {
    public static String pluginColorCode = "&8";
    public static Server server = null;
    public static String pluginName;
    public static String pluginPrefix;
    public static String consolePluginPrefix;
    public static JavaPlugin pluginInstance = null;
    public static File pluginFolder = null;
    public static HashMap<JavaPlugin, BukkitTask> updaterRegister = new HashMap<>();

    public static void registerEvent() {
    }

    public static void registerType() {
        PType.putPType(pluginInstance, "particle", PParticle.class);
        PType.putPType(pluginInstance, "sound", PSound.class);
        PType.putPType(pluginInstance, "deco", PDeco.class);

        PType.putPType(pluginInstance, "equipment", PEquipment.class);
        // PType.putPType(pluginInstance, "DATA", DATA.class);
    }

    @Override
    public void onEnable() {
        server = getServer();
        pluginName = getName();
        pluginPrefix = PFormat.format("&8[" + pluginColorCode + pluginName + "&8] &f");
        consolePluginPrefix = "[" + pluginName + "]->>";
        SiegeCore.info(consolePluginPrefix, "Enabling " + pluginName);
        pluginInstance = this;
        pluginFolder = getDataFolder();
        if (!pluginFolder.exists() && pluginFolder.mkdirs()) SiegeCore.warn(consolePluginPrefix, "Creating plugin folder [" + pluginName + "]");

        registerEvent();
        registerType();

        updater();

        SiegeCore.info(consolePluginPrefix, pluginName + " enabled");
    }

    public void onDisable() {
        updaterRegister.get(pluginInstance).cancel();
        updaterRegister.remove(pluginInstance);

        ItemDisplayHandler.removeAll();

        SiegeCore.info(consolePluginPrefix, "Disabling " + pluginName);
        SiegeCore.info(consolePluginPrefix, pluginName + " disabled");
    }

    public static void updater() {
        if (updaterRegister.containsKey(pluginInstance)) {
            updaterRegister.get(pluginInstance).cancel();
            updaterRegister.remove(pluginInstance);
        }
        updaterRegister.put(pluginInstance, new BukkitRunnable() {
            @Override
            public void run() {
            }
        }.runTaskTimer(pluginInstance , 0, 1));
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String label, String[] args) {
        List<String> sL = new ArrayList<>();
        if (args.length > 0) {
            PArgument argument = new PArgument(label, args);
            PSender sender = new PSender(pluginName, pluginPrefix, commandSender);
            sL = TabHandler.onTab(sender, argument);
            return sL;
        }
        return sL;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, Command command, @NotNull String label, String[] args) {
        if (command.getName().equalsIgnoreCase(pluginName)) {
            PArgument argument = new PArgument(label, args);
            PSender sender = new PSender(pluginName, pluginPrefix, commandSender);
            return CommandHandler.onCommand(sender, argument);
        }
        return true;
    }
}