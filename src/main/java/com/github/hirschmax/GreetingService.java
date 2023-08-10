package com.github.hirschmax;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

    public Greeting getGreeting(String name) {
        return new Greeting(String.format("Hello %s!", name));
    }

}
