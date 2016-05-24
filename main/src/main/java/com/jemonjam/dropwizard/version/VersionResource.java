/*
 * Copyright 2016 Jacob Meacham (jemonjam.com).
 */

package com.jemonjam.dropwizard.version;

import com.jemonjam.dropwizard.version.api.VersionApi;
import com.jemonjam.versioneer.api.VersionLocator;

public class VersionResource implements VersionApi {
    private final VersionLocator version;

    public VersionResource(VersionLocator version) {
        this.version = version;
    }

    @Override
    public final String version() {
        return version.getVersion().orElse("UNSPECIFIED");
    }

}
