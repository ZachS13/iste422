package JavaProjectThings.src;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenerateOutputs {
    Logger log;

    public GenerateOutputs() {
        outputInfo();
        outputDebug();
    }

    public void outputInfo() {
        System.out.println("This is some info");

        getLogger().info("This is some info");
    }

    public void outputDebug() {
        System.out.println("This is a debug");

        getLogger().debug("This is a better debug message, right?");
    }

    private Logger getLogger() {
        if (this.log == null) {
            this.log = LoggerFactory.getLogger(GenerateOutputs.class);
        }

        return this.log;
    }

}
