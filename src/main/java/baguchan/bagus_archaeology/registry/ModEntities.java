package baguchan.bagus_archaeology.registry;

import baguchan.bagus_archaeology.RelicsAndAlchemy;
import baguchan.bagus_archaeology.entity.AlchemyGolem;
import baguchan.bagus_archaeology.entity.AlchemySlime;
import baguchan.bagus_archaeology.entity.AlchemyThrown;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static baguchan.bagus_archaeology.RelicsAndAlchemy.prefix;

@Mod.EventBusSubscriber(modid = RelicsAndAlchemy.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES_REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, RelicsAndAlchemy.MODID);

    public static final RegistryObject<EntityType<AlchemyThrown>> ALCHEMY_THROWN = ENTITIES_REGISTRY.register("alchemy_thrown", () -> EntityType.Builder.<AlchemyThrown>of(AlchemyThrown::new, MobCategory.MISC).sized(0.3F, 0.3F).build(prefix("alchemy_thrown").toString()));
    public static final RegistryObject<EntityType<AlchemyGolem>> ALCHEMY_COMBAT_GOLEM = ENTITIES_REGISTRY.register("alchemy_combat_golem", () -> EntityType.Builder.of(AlchemyGolem::new, MobCategory.MISC).sized(0.5F, 1.45F).build(prefix("alchemy_combat_golem").toString()));
    public static final RegistryObject<EntityType<AlchemySlime>> ALCHEMY_SLIME = ENTITIES_REGISTRY.register("alchemy_slime", () -> EntityType.Builder.of(AlchemySlime::new, MobCategory.MONSTER).sized(2.04F, 2.04F).clientTrackingRange(10).build(prefix("alchemy_slime").toString()));

    @SubscribeEvent
    public static void registerEntity(EntityAttributeCreationEvent event) {
        event.put(ALCHEMY_COMBAT_GOLEM.get(), AlchemyGolem.createAttributes().build());
        event.put(ALCHEMY_SLIME.get(), AlchemySlime.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacement(SpawnPlacementRegisterEvent event) {
        event.register(ALCHEMY_COMBAT_GOLEM.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(ALCHEMY_SLIME.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }
}
