package mcjty.incontrol;

import mcjty.incontrol.rules.RulesManager;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class CmdLoadSpawn extends CommandBase {
    @Override
    public String getName() {
        return "ctrlloadspawn";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "ctrlloadspawn";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (!RulesManager.readCustomSpawn(args[0])) {
            sender.sendMessage(new TextComponentString(TextFormatting.RED + "Error reading file '" + args[0] + "'!"));
            InControl.logger.warn("Error reading file '" + args[0] + "'!");
        }
    }
}
