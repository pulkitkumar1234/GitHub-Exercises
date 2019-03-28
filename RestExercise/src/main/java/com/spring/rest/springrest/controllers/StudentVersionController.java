package com.spring.rest.springrest.controllers;

import com.spring.rest.springrest.versioning.StudentName;
import com.spring.rest.springrest.versioning.StudentV1;
import com.spring.rest.springrest.versioning.StudentV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentVersionController {
    //URI VERSIONING
    @GetMapping("/student/V1")
    StudentV1 getPersonV1() {
        return new StudentV1("Pulkit Kumar");
    }

    @GetMapping("/student/V2")
    StudentV2 getPersonV2() {
        return new StudentV2(new StudentName("Pulkit","Kumar"));
    }
}





/*
@RestController
public class PersonController {

    //URI Versioning

    @GetMapping("/person/V1")
    PersonV1 getPersonV1() {
        return new PersonV1("Peter Parker");
    }

    @GetMapping("/person/V2")
    PersonV2 getPersonV2() {
        return new PersonV2(new Name("Peter","Parker"));
    }

    //Parameter Versioning
    // /person/param?version=1
    @GetMapping(value = "/person/param",params = "version=1")
    PersonV1 getPersonParam1() {
        return new PersonV1("Peter Parker");
    }

    @GetMapping(value = "/person/param",params = "version=2")
    PersonV2 getPersonParam2() {
        return new PersonV2(new Name("Peter","Parker"));
    }


    //Header Versioning
    //API-VERSION 1 header required with request
    @GetMapping(value = "/person/header",headers = "API-VERSION=1")
    PersonV1 getPersonHeader1() {
        return new PersonV1("Peter Parker");
    }

    @GetMapping(value = "/person/header",headers = "API-VERSION=2")
    PersonV2 getPersonHeader2() {
        return new PersonV2(new Name("Peter","Parker"));
    }

    //Mime Type/Content Negotiation/Accept Header Versioning
    //Accept application/app-v1+json header required with request
    @GetMapping(value = "/person/produces",produces = "application/app-v1+json")
    PersonV1 getPersonProducer1() {
        return new PersonV1("Peter Parker");
    }

    @GetMapping(value = "/person/produces",produces = "application/app-v2+json")
    PersonV2 getPersonProducer2() {
        return new PersonV2(new Name("Peter","Parker"));
    }

}
*/
