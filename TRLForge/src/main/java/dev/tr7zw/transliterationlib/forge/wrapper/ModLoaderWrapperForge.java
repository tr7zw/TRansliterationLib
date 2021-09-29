package dev.tr7zw.transliterationlib.forge.wrapper;

import dev.tr7zw.transliterationlib.api.wrapper.ModLoaderWrapper;
import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;

public class ModLoaderWrapperForge implements ModLoaderWrapper {

	@Override
	public void disableForgeServerDisplayTest() {
		ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class,
				() -> new IExtensionPoint.DisplayTest(
						() -> ModLoadingContext.get().getActiveContainer().getModInfo().getVersion().toString(),
						(remote, isServer) -> true));
	}

}
