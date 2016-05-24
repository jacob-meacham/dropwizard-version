/*
 * Copyright 2016 Jacob Meacham (jemonjam.com).
 */

package com.jemonjam.dropwizard.version;

import static com.google.common.base.Preconditions.checkNotNull;

import com.jemonjam.versioneer.DefaultVersioneer;
import com.jemonjam.versioneer.api.VersionLocator;
import io.dropwizard.Bundle;
import io.dropwizard.jersey.DropwizardResourceConfig;
import io.dropwizard.jersey.setup.JerseyContainerHolder;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.servlet.ServletContainer;

public class VersionBundle implements Bundle {
    private final VersionLocator locator;
    private final boolean isAdmin;

    public VersionBundle() {
        this(new DefaultVersioneer(), false);
    }

    public VersionBundle(final boolean isAdmin) {
        this(new DefaultVersioneer(), isAdmin);
    }

    public VersionBundle(final VersionLocator locator, final boolean isAdmin) {
        checkNotNull(locator);

        this.locator = locator;
        this.isAdmin = isAdmin;
    }

    @Override
    public final void initialize(Bootstrap<?> bootstrap) {
        // Nothing to do
    }

    @Override
    public final void run(Environment environment) {
        if (isAdmin) {
            final DropwizardResourceConfig jerseyConfig = new DropwizardResourceConfig(environment.metrics());
            JerseyContainerHolder jerseyContainerHolder = new JerseyContainerHolder(new ServletContainer(jerseyConfig));
            jerseyConfig.register(new VersionResource(locator));
            environment.admin().addServlet("version", jerseyContainerHolder.getContainer()).addMapping("/");
        } else {
            environment.jersey().register(new VersionResource(locator));
        }

    }

}
