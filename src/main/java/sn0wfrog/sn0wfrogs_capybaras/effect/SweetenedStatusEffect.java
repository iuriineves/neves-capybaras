package sn0wfrog.sn0wfrogs_capybaras.effect;

import sn0wfrog.sn0wfrogs_capybaras.event.ConsumeItemCallback;
import sn0wfrog.sn0wfrogs_capybaras.init.ModStatusEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;

public class SweetenedStatusEffect extends StatusEffect {

    public SweetenedStatusEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!(entity instanceof PlayerEntity player)) return;
        if ((entity.getWorld().isClient())) return;


        ConsumeItemCallback.EVENT.register((itemStack, user) -> {
            if (user == player && player.hasStatusEffect(ModStatusEffects.SWEETENED)) {

                // check for golden and enchanted golden apple for buffed status effects
                if (itemStack.getItem() == Items.GOLDEN_APPLE) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 1));
                }

                if (itemStack.getItem() == Items.ENCHANTED_GOLDEN_APPLE) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 4));
                }

                // 1.5x food logic
                player.getHungerManager().add((itemStack.getFoodComponent().getHunger() / 4), 0.3f);
            }
            return ActionResult.SUCCESS;
        });
    }
}
