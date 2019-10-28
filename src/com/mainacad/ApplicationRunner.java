package com.mainacad;

import com.mainacad.helper.ConnectionInfoHelper;
import com.mainacad.model.ConnectionInfo;
import com.mainacad.servive.FileService;

import java.util.logging.Logger;

public class ApplicationRunner {

    private static final Logger LOGGER =
            Logger.getLogger(ApplicationRunner.class.getName());

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            ConnectionInfo connectionInfo = ConnectionInfoHelper.getRandomConnectionInfo();
            FileService.writeTextToFile(connectionInfo.toString(), "connections.txt", true);
        }
    }

}
