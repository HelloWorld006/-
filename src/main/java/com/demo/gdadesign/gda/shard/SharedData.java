package com.demo.gdadesign.gda.shard;

import com.demo.gdadesign.gda.repository.GdaRepository;
import com.demo.gdadesign.gda.repository.UserRepository;

public class SharedData {
    private static SharedData sharedData = new SharedData();

    private UserRepository userRepository;
    private GdaRepository gdaRepository;

    public static SharedData getSharedData() {
        return sharedData;
    }

    public static void setSharedData(SharedData sharedData) {
        SharedData.sharedData = sharedData;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public GdaRepository getGdaRepository() {
        return gdaRepository;
    }

    public void setGdaRepository(GdaRepository gdaRepository) {
        this.gdaRepository = gdaRepository;
    }

    public SharedData() {
    }
}
