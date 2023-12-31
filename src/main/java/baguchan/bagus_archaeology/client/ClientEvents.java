package baguchan.bagus_archaeology.client;

import baguchan.bagus_archaeology.RelicsAndAlchemy;
import baguchan.bagus_archaeology.material.AlchemyMaterial;
import baguchan.bagus_archaeology.registry.ModTags;
import baguchan.bagus_archaeology.util.AlchemyData;
import baguchan.bagus_archaeology.util.AlchemyUtils;
import com.google.common.collect.Lists;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = RelicsAndAlchemy.MODID, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void toolTip(ItemTooltipEvent event) {
        List<Component> list = Lists.newArrayList();
        ItemStack stack = event.getItemStack();
        Player player = event.getEntity();

        if (stack.getItem() instanceof ArmorItem armorItem || stack.getItem() instanceof TieredItem || stack.is(ModTags.Items.ALCHEMY_ALLOW_TOOL)) {
            List<AlchemyData> alchemyMaterialList = AlchemyUtils.getAlchemyMaterials(stack);
            for (AlchemyData entry : alchemyMaterialList) {
                AlchemyMaterial alchemyMaterial = entry.alchemy;
                list.add(alchemyMaterial.getName());
            }
        }
    }
}
