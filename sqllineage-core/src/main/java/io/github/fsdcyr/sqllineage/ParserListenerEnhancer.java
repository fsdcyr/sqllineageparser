package io.github.fsdcyr.sqllineage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fsdcyr
 * @version 1.0
 * @date 2023-09-07 16:00
 */
public abstract class ParserListenerEnhancer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected boolean subQuery = false;

    public boolean isSubQuery() {
        return subQuery;
    }

}
