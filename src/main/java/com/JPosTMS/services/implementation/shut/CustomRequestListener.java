//package com.JPosTMS.services.implementation;
//
//import lombok.AllArgsConstructor;
//import org.jpos.core.Configurable;
//import org.jpos.core.Configuration;
//import org.jpos.core.ConfigurationException;
//import org.jpos.iso.*;
//import org.jpos.iso.channel.NACChannel;
//import org.jpos.iso.packager.GenericPackager;
//import org.jpos.q2.iso.QMUX;
//import org.jpos.transaction.Context;
//import org.jpos.util.Log;
//import org.jpos.util.NameRegistrar;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.io.IOException;
//
//@Component
//@AllArgsConstructor
//public class CustomRequestListener extends Log implements ISORequestListener, Configurable {
////IncomingListener
//    private Configuration cfg;
//    private TransactionDataService transactionDataService;
//
//    public CustomRequestListener() {
//        super();
//    }
//
//    @Override
//    public void setConfiguration(Configuration cfg) throws ConfigurationException {
//        this.cfg = cfg;
//    }
//
//    @Override
//    @Transactional
//    public boolean process(ISOSource source, ISOMsg request) {
//
//        try {
//            System.out.println("waiting for connection");
//            logRequestTransaction(request);
//
//            ISOMsg response = forwardMessageToPTSA(request);
//
//            logResponseTransaction(response);
//
//            source.send(response);
//        } catch (ISOException | IOException e) {
//            e.printStackTrace();
//            return false;
//        }
//
//        return true;
//    }
//
//
//
//    private ISOMsg forwardMessageToPTSA(ISOMsg request) throws ISOException, IOException {
//        GenericPackager genericPackager = new GenericPackager("C:\\Users\\NoahUhunmwangho-John\\IdeaProjects\\jPosCustomImplementation\\cfg\\packager\\iso87ascii-binary-bitmap.xml");
//        //routing rule to determine the ptsa. once confirmed, pass in the address and the port
//        NACChannel channel = new NACChannel();
//        channel.setHost("localhost", 8000);
//        channel.setPackager(genericPackager);
////        channel.setConfiguration();
//
//        channel.connect();
//        channel.send(request);
//        ISOMsg response = channel.receive();
//        channel.disconnect();
//
//        return response;
//
//    }
//
//    private ISOMsg forwardMessageViaMuxToPTSA(ISOMsg request) throws ISOException, NameRegistrar.NotFoundException {
//        QMUX qmux = (QMUX) QMUX.getMUX("ptsa-mux");
//
//        return qmux.request(request, 30*1000);
//    }
//
//    private void logResponseTransaction(ISOMsg msg) {
//        transactionDataService.addResponseToTransactionData(msg);
//    }
//
//    private void logRequestTransaction(ISOMsg msg) throws ISOException{
//        transactionDataService.createTransactionData(msg);
//    }
//}
