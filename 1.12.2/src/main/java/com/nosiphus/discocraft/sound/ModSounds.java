package com.nosiphus.discocraft.sound;

import com.nosiphus.discocraft.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModSounds {

	public static final SoundEvent DISCO_CON_TUTTI = create("disco_con_tutti");
	public static final SoundEvent DISCO_LOUNGE = create("disco_lounge");
	public static final SoundEvent ETHER_DISCO = create("ether_disco");
	public static final SoundEvent OVERCAST = create("overcast");
	public static final SoundEvent STRINGED_DISCO = create("stringed_disco");
	public static final SoundEvent WHO_LIKES_TO_PARTY = create("who_likes_to_party");
	
	private static SoundEvent create(String name) {
		ResourceLocation id = new ResourceLocation(Reference.MODID, name);
		return new SoundEvent(id).setRegistryName(name);
	}
	
	@SubscribeEvent
	public static void registerSoundEvents(RegistryEvent.Register<SoundEvent> event) {
		event.getRegistry().registerAll(
				DISCO_CON_TUTTI,
				DISCO_LOUNGE,
				ETHER_DISCO,
				OVERCAST,
				STRINGED_DISCO,
				WHO_LIKES_TO_PARTY);
		}
}
