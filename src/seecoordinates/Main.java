package seecoordinates;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.scheduler.PluginTask;

public class Main extends PluginBase{
	public void onEnable() {
		getServer().getScheduler().scheduleRepeatingTask(new SendCoordinates(this), 10);
	}
}
class SendCoordinates extends PluginTask<Main> {

	public SendCoordinates(Main owner) {
		super(owner);
	}

	@Override
	public void onRun(int currentTick) {
		for (Player player : Server.getInstance().getOnlinePlayers().values()) {
			player.sendTip("\n\n\n[" + String.format("%.2f", player.getX()) + " " + String.format("%.2f", player.getY()) + " " + String.format("%.2f", player.getZ()) + "]");
		}
	}
}