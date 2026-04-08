package com.sudolev.dynamicvillage.village;

import com.mojang.datafixers.util.Pair;
import com.sudolev.dynamicvillage.VillageLife;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.SinglePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

import java.util.ArrayList;
import java.util.List;

@EventBusSubscriber(modid = VillageLife.MODID)
public class VillageAddition {
    // Updated to use the new fromNamespaceAndPath method
    private static final ResourceKey<StructureProcessorList> EMPTY_PROCESSOR_LIST_KEY = ResourceKey.create(
            Registries.PROCESSOR_LIST, ResourceLocation.fromNamespaceAndPath("minecraft", "empty"));

    private static void addBuildingToPool(RegistryAccess registryAccess,
                                          ResourceLocation poolRL,
                                          String nbtPieceRL,
                                          int weight) {

        var templatePoolRegistry = registryAccess.registryOrThrow(Registries.TEMPLATE_POOL);
        var processorListRegistry = registryAccess.registryOrThrow(Registries.PROCESSOR_LIST);

        Holder<StructureProcessorList> emptyProcessorList = processorListRegistry.getHolderOrThrow(EMPTY_PROCESSOR_LIST_KEY);

        StructureTemplatePool pool = templatePoolRegistry.get(poolRL);
        if (pool == null) return;

        // Use .legacy( for villages/outposts and .single( for everything else
        SinglePoolElement piece = SinglePoolElement.legacy(nbtPieceRL,
                emptyProcessorList).apply(StructureTemplatePool.Projection.RIGID);

        for (int i = 0; i < weight; i++) {
            pool.templates.add(piece);
        }

        List<Pair<StructurePoolElement, Integer>> listOfPieceEntries = new ArrayList<>(pool.rawTemplates);
        listOfPieceEntries.add(new Pair<>(piece, weight));
        pool.rawTemplates = listOfPieceEntries;
    }

    @SubscribeEvent
    public static void addNewVillageBuilding(final ServerAboutToStartEvent event) {
        RegistryAccess registryAccess = event.getServer().registryAccess();

        // Updated all of these to use ResourceLocation.parse() for single-string namespaces
        addBuildingToPool(registryAccess,
                ResourceLocation.parse("minecraft:village/plains/houses"),
                "dynamicvillage:plains/plains_mech", 20);
        addBuildingToPool(registryAccess,
                ResourceLocation.parse("minecraft:village/plains/houses"),
                "dynamicvillage:plains/plains_miner", 20);
        addBuildingToPool(registryAccess,
                ResourceLocation.parse("minecraft:village/plains/houses"),
                "dynamicvillage:plains/plains_train", 20);
        addBuildingToPool(registryAccess,
                ResourceLocation.parse("minecraft:village/plains/houses"),
                "dynamicvillage:plains/plains_plumber", 20);

        addBuildingToPool(registryAccess,
                ResourceLocation.parse("minecraft:village/desert/houses"),
                "dynamicvillage:desert/desert_mech", 20);
        addBuildingToPool(registryAccess,
                ResourceLocation.parse("minecraft:village/desert/houses"),
                "dynamicvillage:desert/desert_miner", 20);
        addBuildingToPool(registryAccess,
                ResourceLocation.parse("minecraft:village/desert/houses"),
                "dynamicvillage:desert/desert_train", 20);
        addBuildingToPool(registryAccess,
                ResourceLocation.parse("minecraft:village/desert/houses"),
                "dynamicvillage:desert/desert_plumber", 20);

        addBuildingToPool(registryAccess,
                ResourceLocation.parse("minecraft:village/taiga/houses"),
                "dynamicvillage:taiga/taiga_mech", 20);
        addBuildingToPool(registryAccess,
                ResourceLocation.parse("minecraft:village/taiga/houses"),
                "dynamicvillage:taiga/taiga_miner", 20);
        addBuildingToPool(registryAccess,
                ResourceLocation.parse("minecraft:village/taiga/houses"),
                "dynamicvillage:taiga/taiga_train", 20);
        addBuildingToPool(registryAccess,
                ResourceLocation.parse("minecraft:village/taiga/houses"),
                "dynamicvillage:taiga/taiga_plumber", 20);

        addBuildingToPool(registryAccess,
                ResourceLocation.parse("minecraft:village/snowy/houses"),
                "dynamicvillage:snowy/snowy_mech", 20);
        addBuildingToPool(registryAccess,
                ResourceLocation.parse("minecraft:village/snowy/houses"),
                "dynamicvillage:snowy/snowy_miner", 20);
        addBuildingToPool(registryAccess,
                ResourceLocation.parse("minecraft:village/snowy/houses"),
                "dynamicvillage:snowy/snowy_train", 20);
        addBuildingToPool(registryAccess,
                ResourceLocation.parse("minecraft:village/snowy/houses"),
                "dynamicvillage:snowy/snowy_plumber", 20);

        addBuildingToPool(registryAccess,
                ResourceLocation.parse("minecraft:village/savanna/houses"),
                "dynamicvillage:savanna/savanna_mech", 20);
        addBuildingToPool(registryAccess,
                ResourceLocation.parse("minecraft:village/savanna/houses"),
                "dynamicvillage:savanna/savanna_miner", 20);
        addBuildingToPool(registryAccess,
                ResourceLocation.parse("minecraft:village/savanna/houses"),
                "dynamicvillage:savanna/savanna_train", 20);
        addBuildingToPool(registryAccess,
                ResourceLocation.parse("minecraft:village/savanna/houses"),
                "dynamicvillage:savanna/savanna_plumber", 20);
    }
}