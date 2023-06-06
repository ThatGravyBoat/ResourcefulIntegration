package com.teamresourceful.resourcefulintegration.messages;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.regex.Pattern;

public enum Formatting {
    BLACK("black", '0', Color.BLACK),
    DARK_BLUE("dark_blue", '1', new Color(0, 0, 170)),
    DARK_GREEN("dark_green", '2', new Color(0, 170, 0)),
    DARK_AQUA("dark_aqua", '3', new Color(0, 170, 170)),
    DARK_RED("dark_red", '4', new Color(170, 0, 0)),
    DARK_PURPLE("dark_purple", '5', new Color(170, 0, 170)),
    GOLD("gold", '6', new Color(255, 170, 0)),
    GRAY("gray", '7', new Color(170, 170, 170)),
    DARK_GRAY("dark_gray", '8', new Color(85, 85, 85)),
    BLUE("blue", '9', new Color(85, 85, 255)),
    GREEN("green", 'a', new Color(85, 255, 85)),
    AQUA("aqua", 'b', new Color(85, 255, 255)),
    RED("red", 'c', new Color(255, 85, 85)),
    LIGHT_PURPLE("light_purple", 'd', new Color(255, 85, 255)),
    YELLOW("yellow", 'e', new Color(255, 255, 85)),
    WHITE("white", 'f', Color.WHITE),

    OBFUSCATED("obfuscated", 'k', null),
    BOLD("bold", 'l', null),
    STRIKETHROUGH("strikethrough", 'm', null),
    UNDERLINE("underline", 'n', null),
    ITALIC("italic", 'o', null),

    RESET("reset", 'r', null),
    ;

    public static final char PREFIX = '\u00a7';
    public static final Pattern PATTERN = Pattern.compile("\u00a7[0-9A-FK-ORa-fk-or]");

    private String name;
    private char code;
    @Nullable private Color color;

    Formatting(String name, char code, @Nullable Color color) {
        this.name = name;
        this.code = code;
        this.color = color;
    }

    public String id() {
        return name;
    }

    public char code() {
        return code;
    }

    @NotNull
    public Color color() {
        if (color == null) throw new IllegalStateException("Cannot get color for formatting code " + code);
        return color;
    }

    public String format(String text) {
        return PREFIX + code + text;
    }

    public boolean isColor() {
        return color != null;
    }

    public boolean isFormat() {
        return color == null && this != RESET;
    }

    @Override
    public String toString() {
        return "" + PREFIX + code;
    }


    public static String strip(String input) {
        return PATTERN.matcher(input).replaceAll("");
    }
}
