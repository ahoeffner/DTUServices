module your.consumer.project
{
    // Misc
    requires org.jspecify;
    requires java.compiler;

    // Common APIs
    requires dtu.services.library;

    // Json handlers
    requires jakarta.annotation;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.datatype.jsr310;

    // OpenAPI/Swagger access
    requires io.swagger.v3.oas.models;
    requires io.swagger.v3.oas.annotations;

    // Standard Spring requirements for a consumer app
    requires spring.web;
    requires spring.boot;
    requires spring.context;
    requires spring.boot.autoconfigure;

    // Allow reflection for the generated models
    opens dtu.services.api.model to tools.jackson.databind;
    opens dtu.services.internal.model to tools.jackson.databind;
}