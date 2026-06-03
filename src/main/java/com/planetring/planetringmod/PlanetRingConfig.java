package com.planetring.planetringmod;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = PlanetRingMod.MODID)
public class PlanetRingConfig {

    // ==================== 开关配置 ====================
    @Config.Name("enable_saturn_ring")
    @Config.LangKey("planetring.config.enable_saturn_ring")
    @Config.Comment("Enable the Saturn ring rendering")
    public static boolean enableSaturnRing = true;

    @Config.Name("enable_uranus_ring")
    @Config.LangKey("planetring.config.enable_uranus_ring")
    @Config.Comment("Enable the Uranus ring rendering")
    public static boolean enableUranusRing = true;

    @Config.Name("enable_saturn_station_ring")
    @Config.LangKey("planetring.config.enable_saturn_station_ring")
    @Config.Comment("Enable the Saturn space station ring rendering")
    public static boolean enableSaturnStationRing = true;

    @Config.Name("enable_uranus_station_ring")
    @Config.LangKey("planetring.config.enable_uranus_station_ring")
    @Config.Comment("Enable the Uranus space station ring rendering")
    public static boolean enableUranusStationRing = true;

    // ==================== 维度ID配置 ====================
    @Config.Name("saturn_dimension_id")
    @Config.LangKey("planetring.config.saturn_dimension_id")
    @Config.Comment("Dimension ID for Saturn")
    @Config.RangeInt(min = -100, max = 100)
    public static int saturnDimensionId = -16;

    @Config.Name("uranus_dimension_id")
    @Config.LangKey("planetring.config.uranus_dimension_id")
    @Config.Comment("Dimension ID for Uranus")
    @Config.RangeInt(min = -100, max = 100)
    public static int uranusDimensionId = -17;

    @Config.Name("saturn_station_dimension_id")
    @Config.LangKey("planetring.config.saturn_station_dimension_id")
    @Config.Comment("Dimension ID for Saturn space station")
    @Config.RangeInt(min = -100, max = 100)
    public static int saturnStationDimensionId = 2;

    @Config.Name("uranus_station_dimension_id")
    @Config.LangKey("planetring.config.uranus_station_dimension_id")
    @Config.Comment("Dimension ID for Uranus space station")
    @Config.RangeInt(min = -100, max = 100)
    public static int uranusStationDimensionId = 4;

    @Mod.EventBusSubscriber(modid = PlanetRingMod.MODID)
    public static class ConfigSyncHandler {
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(PlanetRingMod.MODID)) {
                ConfigManager.sync(PlanetRingMod.MODID, Config.Type.INSTANCE);
            }
        }
    }
}