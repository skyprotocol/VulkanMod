package net.vulkanmod.vulkan;

import net.vulkanmod.Initializer;
import oshi.hardware.CentralProcessor;

public class SystemInfo {
    public static final String cpuInfo;

    static {
        CentralProcessor centralProcessor = null;
        // Opening F3 crashes the game on one specific platform, this hack fixes it
        try {
            centralProcessor = new oshi.SystemInfo().getHardware().getProcessor();
        } catch (NoClassDefFoundError e){
            Initializer.LOGGER.warn("Failed to initialize OSHI class, no cpu info will be available");
        }
        cpuInfo = centralProcessor != null ?
                String.format("%s", centralProcessor.getProcessorIdentifier().getName()).replaceAll("\\s+", " ") :
                "Unknown";
    }
}
