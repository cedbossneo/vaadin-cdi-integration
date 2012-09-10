package com.vaadin.cdi;

import java.util.logging.Logger;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.Extension;

/**
 * CDI Extension which registers VaadinContextImpl context.
 * 
 * @author Tomi Virkki / Vaadin Ltd
 */
public class VaadinExtension implements Extension {

    void afterBeanDiscovery(@Observes
    final AfterBeanDiscovery afterBeanDiscovery, final BeanManager beanManager) {
        getLogger().finest("Initializing VaadinContext CDI Extension");
        afterBeanDiscovery.addContext(new VaadinContext(beanManager));
    }

    private static Logger getLogger() {
        return Logger.getLogger(VaadinExtension.class.getCanonicalName());
    }

}