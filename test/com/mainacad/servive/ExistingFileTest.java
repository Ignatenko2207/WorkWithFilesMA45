package com.mainacad.servive;

import com.mainacad.helper.ConnectionInfoHelper;
import com.mainacad.model.ConnectionInfo;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ExistingFileTest {

    private static final String FILE_NAME = "connections.txt";
    private List<ConnectionInfo> connectionInfoList;

    @BeforeEach
    void setUp() {
        connectionInfoList = FileService.readConectionsFromFile(FILE_NAME);
    }

    @AfterEach
    void tearDown() {
        boolean append = false;
        for (ConnectionInfo connectionInfo : connectionInfoList) {
            FileService.writeTextToFile(connectionInfo.toString(), FILE_NAME, append);
            append = true;
        }
    }


    @Test
    void testReadAndWriteObject(){
        ConnectionInfo connectionInfo = ConnectionInfoHelper.getRandomConnectionInfo();
        FileService.writeTextToFile(connectionInfo.toString(), FILE_NAME, false);

        List<ConnectionInfo> testObj = FileService.readConectionsFromFile(FILE_NAME);

        assertEquals(testObj.get(0).getIp(), connectionInfo.getIp());
        assertEquals(testObj.get(0).getSessionId(), connectionInfo.getSessionId());
        assertEquals(testObj.get(0).getConnectionTime(), connectionInfo.getConnectionTime());
    }

}
