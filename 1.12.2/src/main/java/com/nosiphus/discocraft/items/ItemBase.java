package com.nosiphus.discocraft.items;

import com.nosiphus.discocraft.DiscoCraft;
import com.nosiphus.discocraft.init.ModItems;
import com.nosiphus.discocraft.tabs.CreativeTab;
import com.nosiphus.discocraft.util.IHasModel;
import com.nosiphus.discocraft.util.Reference;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {
	
	public ItemBase(String name) {
		
		setUnlocalizedName(Reference.MODID + "." + name);
		setRegistryName(name);
		setCreativeTab(CreativeTab.DiscoCraftTab);
		
		ModItems.ITEMS.add(this);
		
	}
	
	@Override
	public void registerModels() {
		
		DiscoCraft.proxy.registerItemRenderer(this, 0, "inventory");
		
	}

}
