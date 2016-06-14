grails.project.dependency.resolver = "maven" // or ivy

grails.project.dependency.resolution = {
    inherits("global")
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsCentral()
        mavenCentral()
    }
    dependencies {
        test ("org.spockframework:spock-grails-support:0.7-groovy-2.0") { export = false }
        build 'com.google.gwt:gwt-user:2.5.1', {
            export=false
        }
        runtime 'mysql:mysql-connector-java:5.1.29'
        compile "org.grails.plugins:hibernate-jpa-provider:1.0.0.M1"
        compile "org.grails.plugins:bcrypt:1.0"
    }
    plugins {
        test(":spock:0.7") { export = false }
        build (":release:3.0.0", ':rest-client-builder:1.0.3') { export = false }
        build ":extended-dependency-manager:0.5.5"
        runtime ":resources:1.2"
        compile (":gwt:1.0-SNAPSHOT"){
            transitive = false
        }


    }
}

grails.release.scm.enabled = false

// Needed to run commands locally that trip over the GWT_HOME check.
gwt { version = "2.5.1" }