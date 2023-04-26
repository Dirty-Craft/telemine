package net.dirtycraft.telemine.mixin;

import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.PlayerAdvancementTracker;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerAdvancementTracker.class)
public class PlayerAdvancementTrackerMixin {
    @Inject(at = @At("NEW"), method = "grantCriterion")
    public void injected(Advancement advancement, String criterionName, CallbackInfoReturnable<Boolean> ci)
    {
        //
    }
}
