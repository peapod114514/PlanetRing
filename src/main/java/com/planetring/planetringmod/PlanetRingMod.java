package com.planetring.planetringmod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = PlanetRingMod.MODID, version = PlanetRingMod.VERSION)
public class PlanetRingMod {

    public static final String MODID = "planetring";
    public static final String VERSION = "1.1.0";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        MinecraftForge.EVENT_BUS.register(new SaturnRingRenderer());
        MinecraftForge.EVENT_BUS.register(new UranusRingRenderer());
        MinecraftForge.EVENT_BUS.register(new SaturnStationRingRenderer());
        MinecraftForge.EVENT_BUS.register(new UranusStationRingRenderer());
    }
}