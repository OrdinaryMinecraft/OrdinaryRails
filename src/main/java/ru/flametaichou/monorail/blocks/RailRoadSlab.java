package ru.flametaichou.monorail.blocks;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import ru.flametaichou.monorail.MonorailMain;

public class RailRoadSlab extends BlockSlab {

    public RailRoadSlab() {
        super(false, Material.rock);
        this.setBlockName("railroadslab");
        this.setCreativeTab(MonorailMain.tabMonorail);
        this.setLightOpacity(0);
        this.setHarvestLevel("pickaxe", 0);
        this.setBlockTextureName("monorail:RailRoadBlock");

        this.setBlockUnbreakable();
        this.setHardness(6000000.0F);
        this.setResistance(6000000.0F);
    }

    @Override
    public String func_150002_b(int p_150002_1_) {
        return super.getUnlocalizedName();
    }
}


