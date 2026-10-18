package hackcr.accessibility.options;

import net.minecraft.client.options.KeyBinding;
import net.ornithemc.osl.keybinds.api.KeybindRegistry;
import org.lwjgl.input.Keyboard;

public final class ZoomKeyRegister {

	public static final KeyBinding Zoom = KeybindRegistry.register("key.zoom", Keyboard.KEY_C, "key.categories.akuseshibirichi");

	public static void init() {
	}
}
