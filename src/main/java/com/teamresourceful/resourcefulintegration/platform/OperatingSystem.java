package com.teamresourceful.resourcefulintegration.platform;

import java.awt.*;
import java.io.File;
import java.net.URI;
import java.util.concurrent.TimeUnit;

public enum OperatingSystem {
    WINDOWS,
    MAC,
    LINUX,
    UNKNOWN;

    public static final OperatingSystem OS = getOS();

    private static OperatingSystem getOS() {
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            if (osName.contains("windows")) return OperatingSystem.WINDOWS;
            if (osName.contains("mac")) return OperatingSystem.MAC;
            if (osName.contains("linux")) return OperatingSystem.LINUX;
        } catch (Exception ignored) {}
        return OperatingSystem.UNKNOWN;
    }

    public boolean openUrl(URI uri) {
        if (Desktop.isDesktopSupported()) {
            try {
                if (Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                    Desktop.getDesktop().browse(uri);
                    return true;
                }
            } catch (Throwable ignored) {}
        }
        return execOpen(uri.toString());
    }

    public boolean openFile(File file) {
        if (Desktop.isDesktopSupported()) {
            try {
                if (Desktop.getDesktop().isSupported(Desktop.Action.OPEN)) {
                    Desktop.getDesktop().open(file);
                    return true;
                }
            } catch (Throwable ignored) {}
        }
        return execOpen(file.getPath());
    }

    private boolean execOpen(String uri) {
        switch (this) {
            case WINDOWS:
                return exec(false, "rundll32", "url.dll,FileProtocolHandler", uri);
            case MAC:
                return exec(false, "open", uri);
            case LINUX:
                for (String browser : new String[]{"xdg-open", "kde-open", "gnome-open"}) {
                    if (exec(true, browser, uri)) {
                        return true;
                    }
                }
                return false;
        }
        return false;
    }

    private boolean exec(boolean checkProcessing, String... inputs) {
        try {
            Process process = Runtime.getRuntime().exec(inputs);
            if (process != null) {
                if (checkProcessing) {
                    if (process.waitFor(2, TimeUnit.SECONDS)) {
                        return process.exitValue() == 0;
                    }
                    return true;
                }
                return process.isAlive();
            }
        } catch (Exception ignored) {}
        return false;
    }

}
