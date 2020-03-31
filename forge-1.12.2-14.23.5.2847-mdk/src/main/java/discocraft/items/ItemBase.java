package discocraft.items;

import discocraft.Main;
import discocraft.init.ModItems;
import discocraft.tabs.CreativeTab;
import discocraft.util.IHasModel;
import discocraft.util.Reference;
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
		
		Main.proxy.registerItemRenderer(this, 0, "inventory");
		
	}

}
