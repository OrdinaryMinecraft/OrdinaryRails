package ru.flametaichou.monorail;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import ru.flametaichou.monorail.blocks.*;

@Mod (modid = "monorail", name = "Ordinary Monorail", version = "1.1")

public class MonorailMain {

	
	public static Block railroadblock;
	public static Block railroadstairs;
	public static Block railroadlamp;
	public static Block railroadrails;
	public static Block railroadslab;
	public static Block railroadcobbleblock;
	public static Block railroadglass;


	public static CreativeTabs tabMonorail = new TabMonorail("monorail");
	
	@EventHandler
	public void preLoad(FMLPreInitializationEvent event)
	{
		railroadblock = new RailRoadBlock();
		GameRegistry.registerBlock(railroadblock, "railroadblock");

		railroadstairs = new RailRoadStairs();
		GameRegistry.registerBlock(railroadstairs, "railroadstairs");

		railroadlamp = new RailRoadLamp();
		GameRegistry.registerBlock(railroadlamp, "railroadlamp");

		railroadrails = new RailRoadRails();
		GameRegistry.registerBlock(railroadrails, "railroadrails");

		railroadslab = new RailRoadSlab();
		GameRegistry.registerBlock(railroadslab, "railroadslab");

		railroadcobbleblock = new RailRoadCobbleBlock();
		GameRegistry.registerBlock(railroadcobbleblock, "railroadcobbleblock");

		railroadglass = new RailRoadGlass();
		GameRegistry.registerBlock(railroadglass, "railroadglass");

	}
	
}
