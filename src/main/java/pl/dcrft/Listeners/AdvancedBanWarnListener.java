package pl.dcrft.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import static pl.dcrft.DragonCraftCore.prefix;

//this is such a garbage, dont look here >;c
public class AdvancedBanWarnListener implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onCommandPreprocess(PlayerCommandPreprocessEvent e) {
        if (e.getMessage().startsWith("/warn")) {
            e.setCancelled(true);
            String[] args = e.getMessage().split(" ");
            if(!e.getPlayer().hasPermission("ab.warn.temp")) {
                e.getPlayer().sendMessage(prefix + "§cNie ma takiej komendy. U\u017cyj §e/info§c, aby dowiedzie\u0107 si\u0119 wi\u0119cej o dost\u0119pnych komendach.");
                return;
            }
            else if (args.length < 3) {
                e.getPlayer().sendMessage("§e§lDragon§6§lCraft§e » §cUżycie: §e/warn <nick> <powód> [-s]§c.");
            }
            else {
                Player p = e.getPlayer();
                final StringBuilder sb = new StringBuilder();
                for (int k = 2; k < args.length; ++k) {
                    sb.append(args[k]).append(" ");
                }
                final String allArgs = sb.toString().trim();
                p.chat("/tempwarn " + args[1] + " #1 " + allArgs);
            }
        }
    }
}