package ru.flametaichou.monorail.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import ru.flametaichou.monorail.MonorailMain;

public class RailRoadCobbleBlock extends Block {

    public RailRoadCobbleBlock() {
        super(Material.iron);
        this.setBlockName("railroadcobbleblock");
        this.setCreativeTab(MonorailMain.tabMonorail);
        this.setStepSound(soundTypeStone);
        this.setHarvestLevel("pickaxe", 0);
        this.setBlockTextureName("monorail:RailRoadBlock2");

        this.setBlockUnbreakable();
        this.setResistance(6000000.0F);
    }
}
