package ru.flametaichou.monorail.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import ru.flametaichou.monorail.MonorailMain;

public class RailRoadLamp extends Block {

    public RailRoadLamp()
        {
            super(Material.glass);
            this.setCreativeTab(MonorailMain.tabMonorail);
            this.setBlockTextureName("monorail:RailRoadLamp");
            this.setBlockName("railroadlamp");
            this.setLightOpacity(0);
            this.setLightLevel(1F);
            this.setStepSound(soundTypeGlass);

            this.setBlockUnbreakable();
            this.setResistance(6000000.0F);
        }

}
