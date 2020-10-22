package com.nosiphus.discocraft.init;

import java.util.ArrayList;
import java.util.List;

import com.nosiphus.discocraft.items.*;
import net.minecraft.item.Item;

import com.nosiphus.discocraft.sound.ModSounds;

public class ModItems {

	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item BLANK_MUSIC_DISC = new ItemBase("blank_music_disc");
	public static final Item CHISEL = new ItemBase("chisel");
	public static final Item MIRROR = new ItemBase("mirror");
	public static final Item MIRROR_CHIP = new ItemBase("mirror_chip");
	public static final Item RECEIVER = new ItemBase("receiver");
	
	//Kevin MacLeod
	public static final ItemModRecord DISCO_CON_TUTTI = new ItemModRecord("disco_con_tutti", ModSounds.DISCO_CON_TUTTI);
	public static final ItemModRecord DISCO_LOUNGE = new ItemModRecord("disco_lounge", ModSounds.DISCO_LOUNGE);
	public static final ItemModRecord ETHER_DISCO = new ItemModRecord("ether_disco", ModSounds.ETHER_DISCO);
	public static final ItemModRecord OVERCAST = new ItemModRecord("overcast", ModSounds.OVERCAST);
	public static final ItemModRecord STRINGED_DISCO = new ItemModRecord("stringed_disco", ModSounds.STRINGED_DISCO);
	public static final ItemModRecord WHO_LIKES_TO_PARTY = new ItemModRecord("who_likes_to_party", ModSounds.WHO_LIKES_TO_PARTY);
	
}
