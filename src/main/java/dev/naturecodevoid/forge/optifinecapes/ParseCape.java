package dev.naturecodevoid.forge.optifinecapes;

import net.minecraft.client.renderer.IImageBuffer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ParseCape implements IImageBuffer {
    private int imageWidth;
    private int imageHeight;
    private int imageSrcWidth;
    private int imageSrcHeight;

    @Override
    public BufferedImage parseUserSkin(BufferedImage image) {
        if (image == null) {
            return null;
        } else {
            this.imageWidth = 64;
            this.imageHeight = 32;
            this.imageSrcWidth = image.getWidth();

            for (this.imageSrcHeight = image.getHeight(); this.imageWidth < this.imageSrcWidth || this.imageHeight < this.imageSrcHeight; this.imageHeight *= 2) {
                this.imageWidth *= 2;
            }

            BufferedImage bufferedImage = new BufferedImage(this.imageWidth, this.imageHeight, 2);
            Graphics g = bufferedImage.getGraphics();
            g.drawImage(image, 0, 0, null);
            g.dispose();

            return bufferedImage;
        }
    }

    @Override
    public void skinAvailable() {
    }
}
