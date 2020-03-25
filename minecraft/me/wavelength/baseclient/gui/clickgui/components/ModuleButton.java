package me.wavelength.baseclient.gui.clickgui.components;

import java.awt.Color;

import me.wavelength.baseclient.module.Module;
import me.wavelength.baseclient.utils.RenderUtils;
import me.wavelength.baseclient.utils.Strings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

public class ModuleButton extends GuiButton {

	private Module module;

	public ModuleButton(int buttonId, int x, int y, int widthIn, int heightIn, Module module) {
		super(buttonId, x, y, widthIn, heightIn, Strings.capitalizeFirstLetter(module.getName()));
		this.module = module;
	}

	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY) {
		if (this.visible) {
			this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
			this.mouseDragged(mc, mouseX, mouseY);
			int j = 14737632;

			if (!this.enabled) {
				j = 10526880;
			} else if (this.hovered) {
				if (module.isToggled())
					j = new Color(80, 255, 0).getRGB();
				else
					j = 16777120;
			} else if (module.isToggled()) {
				j = new Color(0, 240, 0).getRGB();
			}

			RenderUtils.drawString(this.displayString, this.xPosition, this.yPosition, j);
		}
	}

	public boolean mouseClicked(int mouseX, int mouseY, int mouseButton) {
		return false;
	}

	@Override
	public boolean mousePressed(Minecraft mc, int mouseX, int mouseY) {
		return super.mousePressed(mc, mouseX, mouseY);
	}

	@Override
	public void mouseReleased(int mouseX, int mouseY) {
		if (hovered)
			module.toggle();
	}

}