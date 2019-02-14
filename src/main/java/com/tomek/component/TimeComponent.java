package com.tomek.component;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
// parameter scopeName defines scope of component. Default in spring every object is singleton. It may be defined as String but better use static variable from WebApplicationContext interface
// SCOPE_REQUEST means that every request creates new instance of object TimeComponent that stores current time
// when inject shorter lifespan object into object with longer lifespan use proxy. TARGET_CLASS for classes and INTERFACES if class implements any interface
@Scope(scopeName = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class TimeComponent {

    private long time;

    public TimeComponent() {
         time = System.currentTimeMillis();
    }

    public long getTime() {
        return time;
    }

    @PostConstruct
    public void afterCreated() {
        System.out.println(this + " created");
    }

    @PreDestroy
    public void beforeDestroy() {
        System.out.println(this + " destroyed");
    }
}
