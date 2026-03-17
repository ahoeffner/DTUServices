module dtu.services.books
{
    requires dtu.services.library;
    requires io.swagger.v3.oas.annotations;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires jakarta.annotation;
    requires jakarta.validation;
    requires org.jspecify;
    requires java.compiler;
    requires static lombok;
    requires org.mapstruct;

    // 1. Change this to match the package where Application.java resides
    opens dtu.services to spring.core, spring.beans, spring.context;

    // 2. Add an open for your specific logic package if it is different
    // (e.g., if your controllers/services are in dtu.services.books)
    // opens dtu.services.books to spring.core, spring.beans, spring.context;

    opens dtu.services.api to spring.core, spring.beans, spring.context, spring.web;
    opens dtu.services.api.model to tools.jackson.databind;
    opens dtu.services.transformations to spring.core;
}