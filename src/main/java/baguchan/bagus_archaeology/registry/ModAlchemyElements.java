package baguchan.bagus_archaeology.registry;

import baguchan.bagus_archaeology.RelicsAndAlchemy;
import baguchan.bagus_archaeology.element.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.*;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = RelicsAndAlchemy.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModAlchemyElements {
    public static final DeferredRegister<AlchemyElement> ALCHEMY_ELEMENT = DeferredRegister.create(new ResourceLocation(RelicsAndAlchemy.MODID, "alchemy_element"), RelicsAndAlchemy.MODID);
    public static final Supplier<IForgeRegistry<AlchemyElement>> ALCHEMY_ELEMENT_REGISTRY = ALCHEMY_ELEMENT.makeRegistry(
            () -> new RegistryBuilder<AlchemyElement>());

    public static final RegistryObject<AlchemyElement> GLOW = ALCHEMY_ELEMENT.register("thick", () -> new ThickElement(new AlchemyElement.Properties(new AlchemyElement.AlchemyType[]{AlchemyElement.AlchemyType.CORE}, 2.0F)));
    public static final RegistryObject<AlchemyElement> EXTEND = ALCHEMY_ELEMENT.register("extend", () -> new ThickElement(new AlchemyElement.Properties(new AlchemyElement.AlchemyType[]{AlchemyElement.AlchemyType.CORE}, 1.5F)));
    public static final RegistryObject<AlchemyElement> SOUL = ALCHEMY_ELEMENT.register("soul", () -> new SoulElement(new AlchemyElement.Properties(new AlchemyElement.AlchemyType[]{AlchemyElement.AlchemyType.PROJECTILE}, 0.5F)));
    public static final RegistryObject<AlchemyElement> SUGAR = ALCHEMY_ELEMENT.register("sugar", () -> new SugarElement(new AlchemyElement.Properties(new AlchemyElement.AlchemyType[]{AlchemyElement.AlchemyType.SELF}, 1F)));
    public static final RegistryObject<AlchemyElement> EXPLOSION = ALCHEMY_ELEMENT.register("explosion", () -> new ExplosionElement(new AlchemyElement.Properties(new AlchemyElement.AlchemyType[]{AlchemyElement.AlchemyType.PROJECTILE}, 0.25F)));

    private static Supplier<IForgeRegistry<AlchemyElement>> registry;

    @SubscribeEvent
    public static void onNewRegistry(NewRegistryEvent event) {
        registry = event.create(new RegistryBuilder<AlchemyElement>()
                .addCallback(AlchemyElement.class)
                .setName(new ResourceLocation(RelicsAndAlchemy.MODID, "alchemy_element"))
                .setDefaultKey(new ResourceLocation(RelicsAndAlchemy.MODID, "thick")));
    }

    public static Supplier<IForgeRegistry<AlchemyElement>> getRegistry() {
        if (registry == null) {
            throw new IllegalStateException("Registry not yet initialized");
        }
        return registry;
    }
}