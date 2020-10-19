package dev.naturecodevoid.forge.optifinecapes;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;

import java.io.File;

public class Utils {
    private static final String optifineCapesUrl = "http://s.optifine.net/capes/%s.png";
    private static final ResourceLocation noCapeImage = new ResourceLocation(OptifineCapes.MODID, "textures/no_cape.png");

    public static ThreadDownloadImageData getDownloadImageCape(ResourceLocation resourceLocation, String username) {
        TextureManager textureManager = getMinecraft().getTextureManager();
        ITextureObject iTextureObject = textureManager.getTexture(resourceLocation);

        iTextureObject = new ThreadDownloadImageData((File) null, String.format(Utils.optifineCapesUrl, username), Utils.noCapeImage, new ParseCape());
        textureManager.loadTexture(resourceLocation, iTextureObject);

        return (ThreadDownloadImageData) iTextureObject;
    }

    public static Minecraft getMinecraft() {
        try {
            return Minecraft.getMinecraft();
        } catch (Exception ignored) {
            return Minecraft.getInstance();
        }
    }
}
