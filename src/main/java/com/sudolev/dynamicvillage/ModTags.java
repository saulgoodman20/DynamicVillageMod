package com.sudolev.dynamicvillage;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        private static TagKey<Block> tag(String name) {
            // Updated to use the new fromNamespaceAndPath method
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(VillageLife.MODID, name));
        }

        private static TagKey<Block> commonTag(String name) {
            // The "forge" namespace is officially dead in 1.21.1! We now use "c" (Common)
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
        }
    }
}