package com.teamresourceful.resourcefulintegration.sounds;

import com.teamresourceful.resourcefulintegration.utils.Identifier;
import com.teamresourceful.resourcefulintegration.utils.PreprocessedReplaced;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.util.ResourceLocation;

@PreprocessedReplaced
public final class Sounds {

    private Sounds() {
        throw new IllegalStateException("Utility class");
    }

    @PreprocessedReplaced
    public static void playSound(@Identifier String id, float volume, float pitch) {
        try {
            ResourceLocation resourceLocation = new ResourceLocation(id);
            PositionedSound sound = new PositionedSoundRecord(resourceLocation, volume, pitch, 0, 0, 0) {
                {
                    this.attenuationType = ISound.AttenuationType.NONE;
                }
            };

            Minecraft.getMinecraft().getSoundHandler().playSound(sound);
        } catch (Exception ignored) {

        }
    }
}
