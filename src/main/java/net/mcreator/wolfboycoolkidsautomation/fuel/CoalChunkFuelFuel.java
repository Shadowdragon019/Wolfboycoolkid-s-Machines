
package net.mcreator.wolfboycoolkidsautomation.fuel;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

import net.mcreator.wolfboycoolkidsautomation.item.CoalChunkItem;

@Mod.EventBusSubscriber
public class CoalChunkFuelFuel {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == CoalChunkItem.block)
			event.setBurnTime(200);
	}
}
