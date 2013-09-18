
package com.packtpub.techbuzz.config;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

public class TechBuzzExceptionHandlerFactory extends ExceptionHandlerFactory {

    private ExceptionHandlerFactory base;
    
    private ViewExpiredExceptionHandler cached;
    
    public TechBuzzExceptionHandlerFactory(ExceptionHandlerFactory base) {
        this.base = base;
    }
    
    @Override
    public ExceptionHandler getExceptionHandler() {
        if(cached == null) {
            cached = new ViewExpiredExceptionHandler(base.getExceptionHandler());
        }
        
        return cached;
    }
}
