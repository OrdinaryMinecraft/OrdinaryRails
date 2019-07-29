package ru.flametaichou.monorail.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockRailBase;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import ru.flametaichou.monorail.MonorailMain;

public class RailRoadRails extends BlockRailBase {

    public RailRoadRails() {
        super(true);
        this.setBlockName("railroadrails");
        this.setCreativeTab(MonorailMain.tabMonorail);
        this.setStepSound(soundTypeStone);
        this.setHarvestLevel("pickaxe", 0);
        this.setBlockTextureName("monorail:RailRoadRails");

        this.setBlockUnbreakable();
        this.setResistance(6000000.0F);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return this.blockIcon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        super.registerBlockIcons(p_149651_1_);
    }

    public void onMinecartPass(World world, EntityMinecart cart, int x, int y, int z) {
        int railMeta = this.getBasicRailMetadata(world, cart, x, y, z);
        int meta = world.getBlockMetadata(x,y,z);
        double d15 = Math.sqrt(cart.motionX * cart.motionX + cart.motionZ * cart.motionZ);

        if (meta == 0) {
            return;
        }
        if (d15 > 0.01D)
        {
            double d16 = 0.06D;
            cart.motionX += cart.motionX / d15 * d16;
            cart.motionZ += cart.motionZ / d15 * d16;
        }
        else if (railMeta == 1)
        {
            if (cart.worldObj.getBlock(x - 1, y, z).isNormalCube())
            {
                cart.motionX = 0.02D;
            }
            else if (cart.worldObj.getBlock(x + 1, y, z).isNormalCube())
            {
                cart.motionX = -0.02D;
            }
        }
        else if (railMeta == 0)
        {
            if (cart.worldObj.getBlock(x, y, z - 1).isNormalCube())
            {
                cart.motionZ = 0.02D;
            }
            else if (cart.worldObj.getBlock(x, y, z + 1).isNormalCube())
            {
                cart.motionZ = -0.02D;
            }
        }
    }
}
