package discocraft.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;

import discocraft.blocks.*;

public class ModBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block DANCE_FLOOR = new BlockDanceFloor("dance_floor", false);
	public static final Block DANCE_FLOOR_ON = new BlockDanceFloor("dance_floor_on", true);
	public static final Block DISCO_BALL = new BlockDiscoBall("disco_ball");
	public static final Block INVERTED_DANCE_FLOOR = new BlockInvertedDanceFloor("inverted_dance_floor", false);
	public static final Block INVERTED_DANCE_FLOOR_ON = new BlockInvertedDanceFloor("inverted_dance_floor_on", true);
	
}
