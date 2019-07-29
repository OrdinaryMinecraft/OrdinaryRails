package ru.flametaichou.monorail.blocks;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockStainedGlass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import ru.flametaichou.monorail.MonorailMain;

import java.util.List;
import java.util.Random;

public class RailRoadGlass extends BlockStainedGlass {

    private static IIcon icon;

    public RailRoadGlass() {
        super(Material.glass);
        this.setCreativeTab(MonorailMain.tabMonorail);
        this.setBlockName("railroadglass");
        this.setBlockUnbreakable();
        this.setResistance(6000000.0F);
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
    {
        p_149666_3_.add(new ItemStack(p_149666_1_, 1, 7));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        icon = p_149651_1_.registerIcon( "glass_silver");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return icon;
    }

    public int damageDropped(int p_149692_1_)
    {
        return p_149692_1_;
    }

    public int quantityDropped(Random p_149745_1_)
    {
        return 0;
    }

    @SideOnly(Side.CLIENT)
    public static int func_149997_b(int p_149997_0_)
    {
        return 1;
    }

    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 1;
    }

    protected boolean canSilkHarvest()
    {
        return true;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

}
