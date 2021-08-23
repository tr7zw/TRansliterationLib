package dev.tr7zw.transliterationlib.fabric.registry;

import java.util.List;

import dev.tr7zw.transliterationlib.api.registry.ItemGroups;
import dev.tr7zw.transliterationlib.api.wrapper.item.ItemStack;
import dev.tr7zw.transliterationlib.api.wrapper.util.Identifier;
import dev.tr7zw.transliterationlib.fabric.wrapper.item.TRLItemStack;
import dev.tr7zw.transliterationlib.fabric.wrapper.util.TRLIdentifier;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.search.SearchManager;

public class ItemGroupsImpl implements ItemGroups{
	
	@Override
	public void registerItemGroup(Identifier id, ItemStack icon, List<ItemStack> items) {
		FabricItemGroupBuilder.create(
				((TRLIdentifier)id).handle())
				.icon(() -> ((TRLItemStack)icon).handle())
				.appendItems(stacks -> {
					items.forEach(item -> {
						MinecraftClient.getInstance().getSearchableContainer(SearchManager.ITEM_TOOLTIP).add(((TRLItemStack)item).handle());
						stacks.add(((TRLItemStack)item).handle());
					});
					MinecraftClient.getInstance().getSearchableContainer(SearchManager.ITEM_TOOLTIP).reload();
				})
				.build();
		
	}

}
