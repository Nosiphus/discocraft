package discocraft.blocks;

import java.util.Random;

import discocraft.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockDanceFloor extends BlockBase {
	
	private final boolean isOn;

	public BlockDanceFloor(String name, boolean isOn) {
		
		super(name, Material.IRON);
		
		setHardness(0.3F);
		setHarvestLevel("pickaxe", 1);
		setLightLevel(0.0F);
		setLightOpacity(0);
		setResistance(1.5F);
		setSoundType(SoundType.GLASS);
		
		this.isOn = isOn;
		
		if (isOn) {
			
			this.setLightLevel(1.0F);
			this.setCreativeTab(null);
			
		}
		
	}
	
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        if (!worldIn.isRemote)
        {
            if (this.isOn && !worldIn.isBlockPowered(pos))
            {
                worldIn.setBlockState(pos, ModBlocks.DANCE_FLOOR.getDefaultState(), 2);
            }
            else if (!this.isOn && worldIn.isBlockPowered(pos))
            {
                worldIn.setBlockState(pos, ModBlocks.DANCE_FLOOR_ON.getDefaultState(), 2);
            }
        }
    }
	
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        if (!worldIn.isRemote)
        {
            if (this.isOn && !worldIn.isBlockPowered(pos))
            {
                worldIn.scheduleUpdate(pos, this, 4);
            }
            else if (!this.isOn && worldIn.isBlockPowered(pos))
            {
                worldIn.setBlockState(pos, ModBlocks.DANCE_FLOOR_ON.getDefaultState(), 2);
            }
        }
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote)
        {
            if (this.isOn && !worldIn.isBlockPowered(pos))
            {
                worldIn.setBlockState(pos, ModBlocks.DANCE_FLOOR.getDefaultState(), 2);
            }
        }
    }
    
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(ModBlocks.DANCE_FLOOR);
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(ModBlocks.DANCE_FLOOR);
    }

    protected ItemStack getSilkTouchDrop(IBlockState state)
    {
        return new ItemStack(ModBlocks.DANCE_FLOOR);
    }
	
}
