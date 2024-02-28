import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationLogger {
    private static ApplicationLogger instance;

    private Logger logger;

    public ApplicationLogger info(String message) {
        if (message.isBlank()) {
            return this;
        }

        getLogger().info(message);

        return this;
    }

    public ApplicationLogger debug(String message) {
        if (message.isBlank()) {
            return this;
        }

        getLogger().debug(message);

        return this;
    }

    public ApplicationLogger warn(String message) {
        if (message.isBlank()) {
            return this;
        }

        getLogger().warn(message);

        return this;
    }

    public ApplicationLogger error(String message) {
        if (message.isBlank()) {
            return this;
        }

        getLogger().error(message);

        return this;
    }

    public ApplicationLogger trace(String message) {
        if (message.isBlank()) {
            return this;
        }

        getLogger().trace(message);

        return this;
    }

    public ApplicationLogger forClass(Class<?> cls) throws ArgumentNullException {
        ArgumentNullException.throwIfNull(cls, "cls");
        logger = LoggerFactory.getLogger(cls);

        return this;
    }

    public ApplicationLogger forClass(String cls) throws ArgumentNullException {
        ArgumentNullException.throwIfNull(cls, "cls");
        logger = LoggerFactory.getLogger(cls);

        return this;
    }

    /**
     * @description The static singleton entrance point that caches and returns the same instance of this class.
     * @return The stored instance of the ApplicationLogger class.
     */
    public static ApplicationLogger instance() {
        if (instance == null) {
            instance = new ApplicationLogger();
        }

        return instance;
    }

    private Logger getLogger() {
        if (logger == null) {
            logger = LoggerFactory.getLogger(ApplicationLogger.class);
        }

        return logger;
    }

    /**
     * @description Private constructor to enforce entrance through the singleton method.
     */
    private ApplicationLogger() { }
}