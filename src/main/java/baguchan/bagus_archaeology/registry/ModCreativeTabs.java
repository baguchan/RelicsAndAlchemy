package baguchan.bagus_archaeology.registry;

import baguchan.bagus_archaeology.RelicsAndAlchemy;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.stream.Stream;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RelicsAndAlchemy.MODID);

    public static final RegistryObject<CreativeModeTab> RELIC_AMD_ALCHEMY = CREATIVE_TABS.register("relics_and_alchemy", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .title(Component.translatable("itemGroup." + "relics_and_alchemy"))
            .icon(() -> ModItems.ALCHEMY_INGOT.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.acceptAll(Stream.of(
                        ModItems.PIGMAN_SKULL,
                        ModItems.STUDDED_LEATHER,
                        ModItems.STUDDED_HELMET,
                        ModItems.STUDDED_CHESTPLATE,
                        ModItems.STUDDED_LEGGINGS,
                        ModItems.STUDDED_BOOTS
                ).map(sup -> {
                    return sup.get().getDefaultInstance();
                }).toList());
                output.acceptAll(Stream.of(
                        ModBlocks.SUSPICIOUS_SOUL_SAND,
                        ModBlocks.SUSPICIOUS_SOUL_SOIL
                ).map(sup -> {
                    return sup.get().asItem().getDefaultInstance();
                }).toList());
                output.acceptAll(Stream.of(
                        ModItems.ALCHEMY_POTION,
                        ModItems.ALCHEMY_PROJECTILE,
                        ModItems.ALCHEMY_INGOT,
                        ModItems.ALCHEMY_COMBAT_GOLEM,
                        ModItems.ALCHEMY_SLIME,
                        ModItems.GOLEM_COMBAT_CORE
                ).map(sup -> {
                    return sup.get().getDefaultInstance();
                }).toList());
            }).build());
}