package com.ytg123.oldnotchapple.mixin;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FoodComponents.class)
public class FoodComponentsMixin {
    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/FoodComponent$Builder;statusEffect(Lnet/minecraft/entity/effect/StatusEffectInstance;F)Lnet/minecraft/item/FoodComponent$Builder;", ordinal = 1))
    private static FoodComponent.Builder changeNotchAppleRegen(FoodComponent.Builder builder, StatusEffectInstance instance, float chance) {
        builder.statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 600, 4), 1.0F);
        return builder;
    }

    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/FoodComponent$Builder;statusEffect(Lnet/minecraft/entity/effect/StatusEffectInstance;F)Lnet/minecraft/item/FoodComponent$Builder;", ordinal = 4))
    private static FoodComponent.Builder changeNotchAppleAbsorb(FoodComponent.Builder builder, StatusEffectInstance instance, float chance) {
        builder.statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 0), 1.0F);
        return builder;
    }
}
