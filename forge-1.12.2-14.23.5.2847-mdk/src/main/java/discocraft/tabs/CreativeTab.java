package discocraft.tabs;

import discocraft.init.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTab {

	public static CreativeTabs DiscoCraftTab = new CreativeTabs("DiscoCraft") {
		
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(Item.getItemFromBlock(ModBlocks.DISCO_BALL));
		}
		
	};
	
}
