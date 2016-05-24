dropwizard-version
==================
[ ![Download](https://api.bintray.com/packages/jacob-meacham/maven/dropwizard-version/images/download.svg) ](https://bintray.com/jacob-meacham/maven/dropwizard-version/_latestVersion) [![Build Status](https://travis-ci.org/jacob-meacham/dropwizard-version.svg?branch=develop)](https://travis-ci.org/jacob-meacham/dropwizard-version)

dropwizard-version is a Dropwizard bundle that adds an endpoint for easily checking the application version at runtime. This utilizes [java-versioneer](https://github.com/jacob-meacham/java-versioneer) to supply the version.

Quick Start
-----------
If you're using gradle, to your build.gradle, add
```
compile 'com.jemonjam.dropwizard:dropwizard-version:0.1.0'
```

If you're using maven, to you pom.xml, add
```
<dependency>
  <groupId>com.jemonjam.dropwizard</groupId>
  <artifactId>dropwizard-version</artifactId>
  <version>0.1.0</version>
  <type>pom</type>
</dependency>
```

Then, all you need to do is add the bundle to your application
```
public void initialize(Bootstrap<ScoutConfiguration> bootstrap) {
        // To use the defaults
        bootstrap.addBundle(new VersionBundle());

        // To add the bundle to the admin servlet instead of the application servlet
        // bootstrap.addBundle(new VersionBundle(true));

        // To use your own VersionLocator
        // bootstrap.addBundle(new VersionBundle(new StaticVersionLocator("MyVersion"), false));        
```

The endpoint will be accessible at /version, either on the application servlet (by default) or on the admin servlet.
