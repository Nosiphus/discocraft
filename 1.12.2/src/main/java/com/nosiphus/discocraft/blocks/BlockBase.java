package com.nosiphus.discocraft.blocks;

import com.nosiphus.discocraft.DiscoCraft;
import com.nosiphus.discocraft.init.ModBlocks;
import com.nosiphus.discocraft.init.ModItems;
import com.nosiphus.discocraft.tabs.CreativeTab;
import com.nosiphus.discocraft.util.IHasModel;
import com.nosiphus.discocraft.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {
	
	public BlockBase(String name, Material material) {
		
		super(material);
		setUnlocalizedName(Reference.MODID + "." + name);
		setRegistryName(name);
		setCreativeTab(CreativeTab.DiscoCraftTab);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		
	}
	
	@Override
	public void registerModels() {
		DiscoCraft.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

}
