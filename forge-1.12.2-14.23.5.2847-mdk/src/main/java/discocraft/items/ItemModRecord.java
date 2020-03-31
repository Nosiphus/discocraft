package discocraft.items;

import discocraft.Main;
import discocraft.init.ModItems;
import discocraft.tabs.CreativeTab;
import discocraft.util.IHasModel;
import discocraft.util.Reference;
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
		
		Main.proxy.registerItemRenderer(this, 0, "inventory");
		
	}

}
