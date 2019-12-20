package ru.flametaichou.monorail.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRailBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import ru.flametaichou.monorail.MonorailMain;

import java.lang.reflect.Field;

public class RailRoadRails extends BlockRailBase {

    private IIcon turnedIcon;
    private double speedMultiplier = 2F;
    private float maxSpeed = 2F;
    private float defaultSpeed = 0.4F;

    public RailRoadRails() {
        super(false);
        this.setBlockName("railroadrails");
        this.setCreativeTab(MonorailMain.tabMonorail);
        this.setStepSound(soundTypeStone);
        this.setHarvestLevel("pickaxe", 0);
        this.setBlockTextureName("monorail:RailRoadRails");

        try {
            Field[] fields = this.getClass().getSuperclass().getSuperclass().getDeclaredFields();
            Field field = null;
            for (Field f : fields) {
                if (f.getType().getName().equals("net.minecraft.block.material.Material")) {
                    field = f;
                    break;
                }
            }
            field.setAccessible(true);
            field.set(this, Material.iron);
        } catch (Exception e) {
            System.out.println("Error on setting material for RailRoadRails: " + e.getMessage());
            e.printStackTrace();
        }

        this.setBlockUnbreakable();
        this.setResistance(6000000.0F);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
        return p_149691_2_ >= 6 ? this.turnedIcon : this.blockIcon;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_) {
        super.registerBlockIcons(p_149651_1_);
        this.turnedIcon = p_149651_1_.registerIcon(this.getTextureName() + "_turned");
    }

    @Override
    public float getRailMaxSpeed(World world, EntityMinecart cart, int x, int y, int z)
    {
        int meta = world.getBlockMetadata(x, y, z);

        if (meta == 1) {
            if (cart.motionX > 0) {
                Block block = world.getBlock(x + 1, y, z);
                meta = world.getBlockMetadata(x + 1, y, z);
                if (block == this && meta == 1) {
                    return maxSpeed;
                } else {
                    return defaultSpeed;
                }
            } else {
                Block block = world.getBlock(x - 1, y, z);
                meta = world.getBlockMetadata(x - 1, y, z);
                if (block == this && meta == 1) {
                    return maxSpeed;
                } else {
                    return defaultSpeed;
                }
            }
        } else if (meta == 0) {
            if (cart.motionZ > 0) {
                Block block = world.getBlock(x, y, z + 1);
                meta = world.getBlockMetadata(x, y, z + 1);
                if (block == this && meta == 0) {
                    return maxSpeed;
                } else {
                    return defaultSpeed;
                }
            } else {
                Block block = world.getBlock(x, y, z - 1);
                meta = world.getBlockMetadata(x, y, z - 1);
                if (block == this && meta == 0) {
                    return maxSpeed;
                } else {
                    return defaultSpeed;
                }
            }
        }

        return defaultSpeed;
    }

    @Override
    public void onMinecartPass(World world, EntityMinecart cart, int x, int y, int z) {
        int railMeta = this.getBasicRailMetadata(world, cart, x, y, z);
        int meta = world.getBlockMetadata(x, y, z);

        double d15 = Math.sqrt(cart.motionX * cart.motionX + cart.motionZ * cart.motionZ);

        if (d15 > 0.01D)
        {
            //double d16 = speedMultiplier * 0.06D;
            //cart.motionX += cart.motionX / d15 * d16;
            //cart.motionZ += cart.motionZ / d15 * d16;
            if (cart.riddenByEntity != null && cart.riddenByEntity instanceof EntityPlayer) {
                cart.motionX = cart.motionX * speedMultiplier;
                cart.motionZ = cart.motionZ * speedMultiplier;
            } else {
                cart.motionX = 0F;
                cart.motionZ = 0F;
            }
        }
        else if (railMeta == 1)
        {
            if (cart.worldObj.getBlock(x - 1, y, z).isNormalCube())
            {
                cart.motionX = 0.02D * speedMultiplier;
            }
            else if (cart.worldObj.getBlock(x + 1, y, z).isNormalCube())
            {
                cart.motionX = -0.02D * speedMultiplier;
            }
        }
        else if (railMeta == 0)
        {
            if (cart.worldObj.getBlock(x, y, z - 1).isNormalCube())
            {
                cart.motionZ = 0.02D * speedMultiplier;
            }
            else if (cart.worldObj.getBlock(x, y, z + 1).isNormalCube())
            {
                cart.motionZ = -0.02D * speedMultiplier;
            }
        }
    }
}
