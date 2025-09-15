package com.miir.atlas.world.gen.biome;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record BiomeColor(int rgb) {
    public static Codec<BiomeColor> CODEC = Codec.STRING.comapFlatMap(BiomeColor::fromHex, BiomeColor::toHex);

    public static DataResult<BiomeColor> fromHex(String hex) {
        if (!hex.startsWith("#")) {
            return DataResult.error(() -> "Biome color must start with a '#' as it must be a hex color.");
        }
        hex = hex.substring(1);

        if(hex.length() != 6) {
            return DataResult.error(() -> "Biome color must be have exactly 6 hex digits.");
        }

        try {
            int parsedValue = Integer.parseInt(hex, 16);
            return DataResult.success(new BiomeColor(parsedValue));
        }
        catch(NumberFormatException e) {
            return DataResult.error(() -> "Invalid hex number: " + e.getMessage());
        }
    }

    public String toHex() {
        String hexString = Integer.toHexString(rgb).toUpperCase();
        int leading_zeros = 6 - hexString.length();
        return "#" + "0".repeat(leading_zeros) + hexString;
    }
}
