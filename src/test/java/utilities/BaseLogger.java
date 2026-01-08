package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class BaseLogger {

    protected final Logger logger = LogManager.getLogger(this.getClass());
}
