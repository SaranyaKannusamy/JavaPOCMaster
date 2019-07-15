package com.consumer.BusServiceConsumer;



import io.swagger.annotations.Contact;

import io.swagger.annotations.ExternalDocs;

import io.swagger.annotations.Info;

import io.swagger.annotations.License;

import io.swagger.annotations.SwaggerDefinition;
@SwaggerDefinition(

        info = @Info(

                description = "Consumer Service",

                version = "V12.0.12",

                title = "Consumer MICROSERVICE",

                contact = @Contact(

                   name = "Saranya", 

                   email = "aarthi229@gmail.com", 

                   url = ""

                ),

                license = @License(

                   name = "Apache 2.0", 

                   url = "http://www.apache.org/licenses/LICENSE-2.0"

                )

        ),

        consumes = {"application/json", "application/xml"},

        produces = {"application/json", "application/xml"},

        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS},

        externalDocs = @ExternalDocs(value = "Read This For Sure", url = "http://in28minutes.com")

)

public interface ApiDocumentationConfig {

}
