package com.sudolev.dynamicvillage;

import com.sudolev.dynamicvillage.villager.ModVillagers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.neoforge.mods.toml file
@Mod(VillageLife.MODID)
public class VillageLife {
    public static final String MODID = "dynamicvillage";

    // NeoForge 1.21.1 now passes the modEventBus directly into the constructor!
    public VillageLife(IEventBus modEventBus) {

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register our custom registries
        ModVillagers.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Enqueue work for thread-safe execution
        event.enqueueWork(() -> {
            ModVillagers.registerPOIs();
        });
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MODID, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}