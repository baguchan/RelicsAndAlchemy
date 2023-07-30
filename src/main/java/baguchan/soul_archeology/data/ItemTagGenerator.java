package baguchan.soul_archeology.data;

import baguchan.soul_archeology.SoulArcheology;
import baguchan.soul_archeology.registry.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ItemTagGenerator extends ItemTagsProvider {
    public ItemTagGenerator(PackOutput p_255871_, CompletableFuture<HolderLookup.Provider> p_256035_, CompletableFuture<TagsProvider.TagLookup<Block>> p_256467_, ExistingFileHelper exFileHelper) {
        super(p_255871_, p_256035_, p_256467_, SoulArcheology.MODID, exFileHelper);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ItemTags.TRIMMABLE_ARMOR).add(ModItems.STUDDED_BOOTS.get(), ModItems.STUDDED_LEGGINGS.get(), ModItems.STUDDED_CHESTPLATE.get(), ModItems.STUDDED_HELMET.get());
    }
}