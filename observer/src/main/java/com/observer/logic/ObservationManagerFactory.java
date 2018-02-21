package com.observer.logic;

/**
 * Created by abhimanyus on 2/21/18.
 */
public class ObservationManagerFactory {

    private static final ObservationManager observationManager = new ObservationManager();

    public static ObservationManager getObservationMgr() {
        return observationManager;
    }
}
