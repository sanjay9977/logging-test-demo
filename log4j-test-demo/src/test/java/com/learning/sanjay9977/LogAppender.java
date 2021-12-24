package com.learning.sanjay9977;

import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Plugin(name = "LogAppender", category = "Core", elementType = "appender", printObject = true)
public class LogAppender extends AbstractAppender {

    private List<LogEvent> logEvents = new ArrayList<>();

    protected LogAppender(final String name, final Layout<? extends Serializable> layout) {
        super(name, null, layout, true, Property.EMPTY_ARRAY);
    }

    @PluginFactory
    public static LogAppender createAppender(@PluginAttribute("name") String name, @PluginElement("Layout") Layout<? extends Serializable> layout) {
        return new LogAppender(name, layout);
    }

    @Override
    public void append(LogEvent event) {
        logEvents.add(event);
    }

    public void reset() {
        logEvents.clear();
        LOGGER.info("Clearing all the stored messages, log msg count : {}", logEvents.size());
    }

    public boolean isMsgEquals(final String searchMsg) {
        return this.logEvents.stream().anyMatch(event -> toSerializable(event).toString().trim().equals(searchMsg));
    }
}
