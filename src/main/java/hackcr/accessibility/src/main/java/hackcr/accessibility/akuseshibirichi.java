package hackcr.accessibility;

import hackcr.accessibility.options.ZoomKeyRegister;
import net.minecraft.client.Minecraft;
import net.ornithemc.osl.keybinds.api.KeybindEvents;
import net.ornithemc.osl.entrypoints.api.client.ClientModInitializer;

public class akuseshibirichi implements ClientModInitializer {

	public static boolean currentlyZoomed;
	public static boolean Zoomed;
	private static boolean originalSmoothCameraEnabled;

	public static final float zoomInDistance = (float) 0.23;

	@Override
	public void initClient() {
		KeybindEvents.REGISTER_KEYBINDS.register(ZoomKeyRegister::init);

		Zoomed = false;
		originalSmoothCameraEnabled = false;
	}

	public static boolean isZooming() {
		return ZoomKeyRegister.Zoom.isPressed();
	}

	public static void manageSmoothCamera() {
		if (zoomStarting()) {
			zoomStarted();
			enableSmoothCamera();
		}

		if (zoomStopping()) {
			zoomStopped();
			resetSmoothCamera();
		}
	}

	public static boolean isFirstPerson() {
		return Minecraft.getInstance().options.perspective == 0;
	}

	private static boolean isSmoothCamera() {
		return Minecraft.getInstance().options.smoothCamera;
	}

	private static void enableSmoothCamera() {
		Minecraft.getInstance().options.smoothCamera = true;
	}

	private static void disableSmoothCamera() {
		Minecraft.getInstance().options.smoothCamera = false;
	}

	private static boolean zoomStarting() {
		return isZooming() && !currentlyZoomed;
	}

	private static boolean zoomStopping() {
		return !isZooming() && currentlyZoomed;
	}

	private static void zoomStarted() {
		originalSmoothCameraEnabled = isSmoothCamera();
		currentlyZoomed = true;
	}

	private static void zoomStopped() {
		currentlyZoomed = false;
	}

	private static void resetSmoothCamera() {
		if (originalSmoothCameraEnabled) {
			enableSmoothCamera();
		} else {
			disableSmoothCamera();
		}
	}
}


