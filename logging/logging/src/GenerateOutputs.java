import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenerateOutputs {
    private Logger l;

    public GenerateOutputs() {
        outputInfo();

        outputDebug();

        outputWarn();

        outputError();
    }

    public void outputInfo() {
        //System.out.println("Informational Only!!");

        getLogger().info("A real info log");
    }

    public void outputDebug() {
        //System.out.println("A poor man's debug.");

        getLogger().debug("A real debug!");
    }

    public void outputWarn() {
        //System.out.println("Sound the alarm! Warn the troops!");

        getLogger().warn("Oh boy, it's getting spicy!");
    }

    public void outputError() {
        //System.out.println("An error! Onoz!");

        getLogger().error("Oh crap, an error!");
    }

    private Logger getLogger() {
        if (l == null) {
            l = LoggerFactory.getLogger(GenerateOutputs.class);
        }

        return l;
    }
}