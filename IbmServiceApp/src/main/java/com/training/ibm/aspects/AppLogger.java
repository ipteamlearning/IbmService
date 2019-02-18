
package com.training.ibm.aspects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A customized Logger, a wrapper around the org.slf4j.Logger.
 *
 */

public class AppLogger
{
    private Logger logger;

    /**
     * @param clazz the logger will be named after clazz
     */
    public AppLogger(Class<?> clazz)
    {
        this.logger = LoggerFactory.getLogger(clazz);
    }

    /**
     * @see org.slf4j.Logger#error(String, Object)
     * @param msg the message string to be logged
     */
    public void error(String msg)
    {
        this.logger.error(msg);
    }
    
    /**
     * @see org.slf4j.Logger#error(String msg, Object... arguments)
     * @param msg the message string to be logged
     * @param arguments a list of 3 or more argumentss 
     */ 
    public void error(String msg, Object... arguments)
    {
        this.logger.error(msg, arguments);
    }
    
    /**
     * @see org.slf4j.Logger#error(String msg, Throwable t, Object... arguments)
     * @param msg the message string to be logged
     * @param t the exception (throwable) to log
     */ 
    public void error(String msg, Throwable t)
    {
        this.logger.error(msg, t);
    }

    /**
     * @see org.slf4j.Logger#warning(String msg)
     * @param msg the message string to be logged
     */ 
    public void warn(String msg)
    {
        this.logger.warn(msg);
    }
    
    /**
     * @see org.slf4j.Logger#warning(String msg, Object... arguments)
     * @param msg the message string to be logged
     * @param arguments a list of 3 or more argumentss 
     */ 
    public void war(String msg, Object... arguments)
    {
        this.logger.warn(msg, arguments);
    }
    
    /**
     * @see org.slf4j.Logger#warn(String msg, Throwable t, Object... arguments)
     * @param msg the message string to be logged
     * @param t   the exception (throwable) to log
     */ 
    public void warn(String msg, Throwable t)
    {
        this.logger.warn(msg, t);
    }

    /**
     * @see org.slf4j.Logger#info(String msg)
     * @param msg the message string to be logged
     */ 
    public void info(String msg)
    {
        this.logger.info(msg);
    }

    /**
     * @see org.slf4j.Logger#info(String msg, Object... arguments)
     * @param msg the message string to be logged
     * @param arguments a list of 3 or more argumentss 
     */ 
    public void info(String msg, Object... arguments)
    {
        this.logger.info(msg, arguments);
    }
    
    /**
     * @see org.slf4j.Logger#debug(String msg)
     * @param msg the message string to be logged
     */ 
    public void debug(String msg)
    {
        this.logger.debug(msg);
    }
    
    /**
     * @see org.slf4j.Logger#debug(String msg, Object... arguments)
     * @param msg the message string to be logged
     * @param arguments a list of 3 or more argumentss 
     */ 
    public void debug(String msg, Object... arguments)
    {
        this.logger.debug(msg, arguments);
    }
    
    /**
     * @see org.slf4j.Logger#trace(String msg)
     * @param msg the message string to be logged
     */ 
    public void trace(String msg)
    {
        this.logger.trace(msg);
    }
    
    /**
     * @see org.slf4j.Logger#trace(String msg, Object... arguments)
     * @param msg the message string to be logged
     * @param arguments a list of 3 or more argumentss 
     */ 
    public void trace(String msg, Object... arguments)
    {
        this.logger.trace(msg, arguments);
    }

    /**
     * @see org.slf4j.Logger#isTraceEnabled()
     * @return True if this Logger is enabled for the TRACE level, false otherwise.
     */ 
    public boolean isTraceEnabled() 
    {
        return this.logger.isTraceEnabled();
    }

    /**
     * @see org.slf4j.Logger#isDebugEnabled()
     * @return True if this Logger is enabled for the DEBUG level, false otherwise.
     */
    public boolean isDebugEnabled() 
    {
        return this.logger.isDebugEnabled();
    }
}
