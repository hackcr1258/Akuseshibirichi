package hackcr.accessibility.mixin;


import com.llamalad7.mixinextras.sugar.Local;
import hackcr.accessibility.akuseshibirichi;
import net.minecraft.client.entity.living.player.ClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerRenderer;
import net.minecraft.client.render.model.entity.PlayerModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerRenderer.class)
public class HidePlayerHand {
	@Inject(method = "setModelStatus", at = @At("TAIL"))
	public void akuseshibirichi$HideHand(ClientPlayerEntity entity, CallbackInfo ci, @Local PlayerModel playerModel) {
		if (akuseshibirichi.isZooming() && akuseshibirichi.isFirstPerson()) {
			playerModel.setVisible(false);
		}
	}
}


