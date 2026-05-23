//Copyright 2026 ___PEAPOD___

//        Licensed under the Apache License, Version 2.0 (the "License");
//        you may not use this file except in compliance with the License.
//        You may obtain a copy of the License at

//        http://www.apache.org/licenses/LICENSE-2.0

//        Unless required by applicable law or agreed to in writing, software
//        distributed under the License is distributed on an "AS IS" BASIS,
//        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//        See the License for the specific language governing permissions and
//        limitations under the License.

package com.planetring.planetringmod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = PlanetRingMod.MODID, version = PlanetRingMod.VERSION)
class PlanetRingMod {

    public static final String MODID = "planetring";
    public static final String VERSION = "1.0.0";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new SaturnRingRenderer());
        MinecraftForge.EVENT_BUS.register(new UranusRingRenderer());
        MinecraftForge.EVENT_BUS.register(new UranusRingRenderer());
    }
}