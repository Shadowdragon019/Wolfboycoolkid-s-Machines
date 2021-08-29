
package net.mcreator.wolfboycoolkidsautomation.fuel;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

import net.mcreator.wolfboycoolkidsautomation.item.CharcoalChunkItem;

@Mod.EventBusSubscriber
public class CharcoalChunkFuelFuel {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == CharcoalChunkItem.block)
			event.setBurnTime(200);
	}
}
