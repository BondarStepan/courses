package com.iba.courses.service;

import com.ibm.ims.connect.*;

import static com.sun.xml.internal.messaging.saaj.packaging.mime.util.ASCIIUtility.getBytes;

public class ImsConnectionService {
    private final String USER_ID = "LAPUSHA";
    private final String PASSWORD = "LAPUSHA2";
    private final String HOST = "172.20.2.116";
    private ConnectionFactory connectionFactory;
    private TmInteraction tmInteraction;
    private Connection connection;


//    ImsParameters imsParameters = new ImsParameters();
//imsParameters.setHostname(HOST);
//imsParameters.setDatastore("IVP1");
//imsParameters.setExitIdentifier("*SAMPL1*");
//imsParameters.setPort(7003);
//imsParameters.setUserId(USER_ID);
//imsParameters.setPassword(PASSWORD);


    public void init() throws Exception {
        try {
            this.connectionFactory = new ConnectionFactory();
            this.connectionFactory.setHostName(HOST);
            this.connectionFactory.setPortNumber(7003);
            this.connectionFactory.setSocketType(ConnectionFactory.SOCKET_TYPE_PERSISTENT);
            this.connection = this.connectionFactory.getConnection();
            this.tmInteraction = this.connection.createInteraction();

            /* Interaction settings */
            this.tmInteraction.setImsConnectTimeout(5000);
            this.tmInteraction.setInteractionTimeout(50000);
            this.tmInteraction.setTrancode("");
            this.tmInteraction.setInputMessageDataSegmentsIncludeLlzzAndTrancode(false);
            this.tmInteraction.setCommitMode(ApiProperties.COMMIT_MODE_0);
            this.tmInteraction.setResponseIncludesLlll(true);
            this.tmInteraction.setInteractionTypeDescription(ApiProperties.INTERACTION_TYPE_DESC_SENDRECV);
            this.tmInteraction.setImsConnectUserMessageExitIdentifier("*SAMPL1*");
            this.tmInteraction.setImsDatastoreName("IVP1");
            /* RACF settings */
            this.tmInteraction.setRacfUserId(USER_ID);
            this.tmInteraction.setRacfPassword(PASSWORD);
            this.tmInteraction.setRacfGroupName("");
            this.tmInteraction.setRacfApplName("");
        } catch (Exception e) {
            throw new Exception("Can't set IMS connection properties. IMS Connect API message: " + e.getMessage(), e);
        }
        /*try {
            InputMessage inputMessage = this.tmInteraction.getInputMessage();
            inputMessage.setInputMessageData(getBytes(tmInteraction.getImsConnectCodepage()));
            this.tmInteraction.execute();
//            outputMessage = ;
            return tmInteraction.getOutputMessage().getDataAsString();
        } catch (Exception e) {
            throw new Exception("Error while executing command. IMS Connect API message: " + e.getMessage(), e);
        }*/

    }

    public void connect() {
        try {
            this.connection.connect();
        } catch (Exception e) {
            System.out.println("Error in connecting");
            e.printStackTrace();
        }
    }

    public String execute(String command) {
        try {
            InputMessage inputMessage = this.tmInteraction.getInputMessage();
            inputMessage.setInputMessageData(command.getBytes(tmInteraction.getImsConnectCodepage()));
            this.tmInteraction.execute();
            OutputMessage outputMessage = tmInteraction.getOutputMessage();
            return outputMessage.getDataAsString();
        } catch (Exception e) {
            System.out.println("Error in executing");
            e.printStackTrace();
        }
        return "Error";
    }
}
