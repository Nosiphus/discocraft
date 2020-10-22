package com.nosiphus.discocraft.items;

import com.nosiphus.discocraft.DiscoCraft;
import com.nosiphus.discocraft.init.ModItems;
import com.nosiphus.discocraft.tabs.CreativeTab;
import com.nosiphus.discocraft.util.IHasModel;
import com.nosiphus.discocraft.util.Reference;
import net.minecraft.item.ItemRecord;
import net.minecraft.util.SoundEvent;

public class ItemModRecord extends ItemRecord implements IHasModel {

	public ItemModRecord(String name, SoundEvent soundIn) {
		super(name, soundIn);
		
		setUnlocalizedName(Reference.MODID + "." + name);
		setRegistryName(name);
		setCreativeTab(CreativeTab.DiscoCraftTab);
		
		ModItems.ITEMS.add(this);
	}
	
	public void registerModels() {
		
		DiscoCraft.proxy.registerItemRenderer(this, 0, "inventory");
		
	}

}
