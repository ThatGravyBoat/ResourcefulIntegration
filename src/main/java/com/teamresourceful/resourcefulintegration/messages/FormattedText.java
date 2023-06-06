package com.teamresourceful.resourcefulintegration.messages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormattedText {

    private final List<Part> parts = new ArrayList<>();

    public FormattedText() {}

    public FormattedText(String text) {
        this(text, Formatting.WHITE);
    }

    public FormattedText(String text, Formatting formatting) {
        this.parts.add(new Part(text, formatting));
    }

    public FormattedText add(String text) {
        return add(text, Formatting.WHITE);
    }

    public FormattedText add(String text, Formatting... formatting) {
        this.parts.add(new Part(text, formatting));
        return this;
    }

    public FormattedText add(FormattedText text) {
        this.parts.addAll(text.parts);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        parts.forEach(builder::append);
        return builder.toString();
    }

    private static class Part {

        private final String text;
        private final List<Formatting> formatting = new ArrayList<>();

        private Part(String text, Formatting... formatting) {
            this.text = text;
            this.formatting.addAll(Arrays.asList(formatting));
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            formatting.forEach(builder::append);
            builder.append(text);
            builder.append(Formatting.RESET);
            return builder.toString();
        }
    }

}
