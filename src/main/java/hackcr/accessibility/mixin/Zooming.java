package hackcr.accessibility.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import hackcr.accessibility.akuseshibirichi;
import net.minecraft.client.Minecraft;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.platform.GlStateManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class Zooming {

	@Inject(method = "setupCamera", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/GameRenderer;transformCamera(F)V"))
	private void akuseshibirichi$editZoom(CallbackInfo ci) {
		akuseshibirichi.manageSmoothCamera();

		if (akuseshibirichi.isZooming()) {
			float scale = 1.0f / akuseshibirichi.zoomInDistance;
			GlStateManager.scalef(scale, scale, 1.0f);
		}
	}
}

