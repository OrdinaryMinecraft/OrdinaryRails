package ru.flametaichou.monorail;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabMonorail extends CreativeTabs {

    public TabMonorail(String string) {
        super(string);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem()
    {
        return Item.getItemFromBlock(MonorailMain.railroadrails);
    }

}
