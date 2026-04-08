package com.sudolev.dynamicvillage.event;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.sudolev.dynamicvillage.VillageLife;
import com.sudolev.dynamicvillage.villager.ModVillagers;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

import java.util.List;

@EventBusSubscriber(modid = VillageLife.MODID)
public class HydraulicEngineerTrades {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        // Use .value() instead of .get() for the new DeferredHolder
        if(event.getType() == ModVillagers.HYDRAULIC_ENGINEER.value()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            int villagerLevel1 = 1;
            int villagerLevel2 = 2;
            int villagerLevel3 = 3;
            int villagerLevel4 = 4;
            int villagerLevel5 = 5;

            // The first argument of MerchantOffer is now an ItemCost instead of ItemStack
            trades.get(villagerLevel1).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 2),
                    new ItemStack(AllItems.COPPER_SHEET.get(), 8),8,8,0.02F));

            trades.get(villagerLevel1).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.DRIED_KELP, 32),
                    new ItemStack(Items.EMERALD, 2), 8,8,0.01F));

            trades.get(villagerLevel1).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 5),
                    new ItemStack(Items.DRIED_KELP, 16), 8,8,0.01F));

            trades.get(villagerLevel1).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 2),
                    new ItemStack(AllBlocks.FLUID_PIPE.get(), 6),10,8,0.02F));

            trades.get(villagerLevel1).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.COPPER_INGOT, 6),
                    new ItemStack(Items.EMERALD, 1), 10,8,0.02F));

            trades.get(villagerLevel1).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 3),
                    new ItemStack(AllItems.COPPER_DIVING_HELMET.get(), 1),3,24,0.04F));

            trades.get(villagerLevel2).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 2),
                    new ItemStack(AllBlocks.COPPER_CASING.get(), 1),8,8,0.1F));

            trades.get(villagerLevel2).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 4),
                    new ItemStack(AllBlocks.SPOUT.get(), 1),10,12,0.1F));

            trades.get(villagerLevel2).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 2),
                    new ItemStack(AllBlocks.FLUID_TANK.get(), 1),10,10,0.1F));

            trades.get(villagerLevel2).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 3),
                    new ItemStack(AllBlocks.MECHANICAL_PUMP.get(), 2),10,10,0.1F));

            trades.get(villagerLevel3).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(AllBlocks.COPPER_CASING.get(), 4),
                    new ItemStack(Items.EMERALD, 1), 10,8,0.02F));

            trades.get(villagerLevel3).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(AllBlocks.FLUID_TANK.get(), 3), 10,10,0.01F));

            trades.get(villagerLevel3).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 4),
                    new ItemStack(AllBlocks.MECHANICAL_MIXER.get(), 1), 8,12,0.01F));

            trades.get(villagerLevel4).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 2),
                    new ItemStack(AllBlocks.FLUID_VALVE.get(), 3), 4,16,0.01F));

            trades.get(villagerLevel4).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(AllBlocks.LARGE_WATER_WHEEL.get(), 3), 6,10,0.01F));

//            trades.get(villagerLevel5).add((trader, rand) -> new MerchantOffer(
//                    new ItemCost(Items.EMERALD, 1),
//                    new ItemStack(AllItems.HONEYED_APPLE.get(), 8), 3,16,0.01F));

            trades.get(villagerLevel5).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 4),
                    new ItemStack(AllItems.COPPER_DIVING_BOOTS.get(), 1),3,16,0.02F));

            trades.get(villagerLevel5).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 7),
                    new ItemStack(AllItems.COPPER_BACKTANK.get(), 1),3,16,0.02F));
        }
    }
}