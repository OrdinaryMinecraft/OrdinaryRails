package ru.flametaichou.monorail.blocks;

import ru.flametaichou.monorail.MonorailMain;
import net.minecraft.block.BlockStairs;

public class RailRoadStairs extends BlockStairs {

	public RailRoadStairs() {
		super(MonorailMain.railroadblock, 1);
		this.setBlockName("railroadstairs");
		this.setCreativeTab(MonorailMain.tabMonorail);
		this.setLightOpacity(0);
		this.setHarvestLevel("pickaxe", 0);
		this.setBlockTextureName("monorail:RailRoadBlock");

		this.setBlockUnbreakable();
		this.setResistance(6000000.0F);
	}
}

