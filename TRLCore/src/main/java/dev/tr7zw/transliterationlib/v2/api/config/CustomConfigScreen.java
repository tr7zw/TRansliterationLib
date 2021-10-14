package dev.tr7zw.transliterationlib.v2.api.config;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.CycleOption;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Button.OnPress;
import net.minecraft.client.gui.components.CycleButton;
import net.minecraft.client.gui.components.CycleButton.TooltipSupplier;
import net.minecraft.client.gui.components.OptionsList;
import net.minecraft.client.gui.screens.OptionsSubScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.util.FormattedCharSequence;

public abstract class CustomConfigScreen extends Screen {

	protected final Screen lastScreen;
	private OptionsList list;
	private final Runnable onClose;

	public CustomConfigScreen(Screen lastScreen, String title, Runnable onClose) {
		super(new TranslatableComponent(title));
		this.lastScreen = lastScreen;
		this.onClose = onClose;
	}

	@Override
	public void removed() {
		if(onClose != null) {
			onClose.run();
		}
	}

	@Override
	public void onClose() {
		this.minecraft.setScreen(this.lastScreen);
	}

	public OptionsList getOptions() {
		return list;
	}

	protected void init() {
		this.list = new OptionsList(this.minecraft, this.width, this.height, 32, this.height - 32, 25);
		this.addWidget(this.list);
		this.createFooter();
		initialize();
	}

	public abstract void initialize();

	protected void createFooter() {
		this.addRenderableWidget(
				new Button(this.width / 2 - 100, this.height - 27, 200, 20, CommonComponents.GUI_DONE, new OnPress() {

					@Override
					public void onPress(Button button) {
						CustomConfigScreen.this.onClose();
					}
				}));
	}

	public void render(PoseStack poseStack, int i, int j, float f) {
		this.renderBackground(poseStack);
		this.list.render(poseStack, i, j, f);
		drawCenteredString(poseStack, this.font, this.title, this.width / 2, 20, 16777215);
		super.render(poseStack, i, j, f);
		List<FormattedCharSequence> list = OptionsSubScreen.tooltipAt(this.list, i, j);
		this.renderTooltip(poseStack, list, i, j);
	}

	public CycleOption<Boolean> getBooleanOption(String translationKey, Supplier<Boolean> current,
			Consumer<Boolean> update) {
		return CycleOption.createBinaryOption(translationKey, new TranslatableComponent(translationKey + ".on"),
				new TranslatableComponent(translationKey + ".off"), options -> current.get(),
				(options, option, boolean_) -> update.accept(boolean_));
	}

	public CycleOption<Boolean> getOnOffOption(String translationKey, Supplier<Boolean> current,
			Consumer<Boolean> update) {
		return CycleOption.createOnOff(translationKey, options -> current.get(),
				(options, option, boolean_) -> update.accept(boolean_));
	}

	public <T extends Enum> CycleOption getEnumOption(String translationKey, Class<T> targetEnum, Supplier<T> current,
			Consumer<T> update) {
		return CycleOption.create(translationKey, Arrays.asList(targetEnum.getEnumConstants()),
				(t) -> new TranslatableComponent(translationKey + "." + t.name()), options -> current.get(),
				(options, option, value) -> update.accept(value));
	}

	public <T> Function<Minecraft, CycleButton.TooltipSupplier<T>> createStaticTooltip(String translationKey) {
		TranslatableComponent component = new TranslatableComponent(translationKey);
		return (minecraft) -> {
			return new TooltipSupplier<T>() {

				@Override
				public List<FormattedCharSequence> apply(T t) {
					return minecraft.font.split(component, 200);
				}
			};
		};
	}

}
