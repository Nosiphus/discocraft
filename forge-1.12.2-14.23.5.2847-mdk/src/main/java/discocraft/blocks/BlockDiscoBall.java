package discocraft.blocks;

import java.util.Random;

import discocraft.proxy.ClientProxy;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockDiscoBall extends BlockBase {

	public BlockDiscoBall(String name) {
		
		super(name, Material.IRON);
		
		setHardness(0.3F);
		setHarvestLevel("pickaxe", 1);
		setLightLevel(1.0F);
		setLightOpacity(0);
		setResistance(1.5F);
		setSoundType(SoundType.GLASS);
		
	}
	
}
