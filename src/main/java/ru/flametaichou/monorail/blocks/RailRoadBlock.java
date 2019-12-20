package ru.flametaichou.monorail.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import ru.flametaichou.monorail.MonorailMain;

public class RailRoadBlock extends Block {

	public RailRoadBlock() {
		super(Material.iron);
		this.setBlockName("railroadblock");
		this.setCreativeTab(MonorailMain.tabMonorail);
		this.setStepSound(soundTypeStone);
		this.setHarvestLevel("pickaxe", 0);
		this.setBlockTextureName("monorail:RailRoadBlock");

		this.setBlockUnbreakable();
		this.setResistance(6000000.0F);
	}
}
