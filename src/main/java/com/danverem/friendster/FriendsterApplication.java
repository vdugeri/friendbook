package com.danverem.friendster;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class FriendsterApplication extends ResourceConfig {

    public FriendsterApplication() {
        packages("com.danverem.friendster");
        register(JacksonFeature.class);
    }
}
