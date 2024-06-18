//package com.serethewind.JPosTMS.services.implementation;
//
//import com.serethewind.JPosTMS.exceptions.BytesNotFoundInParseMessageException;
//import com.serethewind.JPosTMS.exceptions.GenericPackageNotFoundException;
//import com.serethewind.JPosTMS.exceptions.SocketStyledException;
//import com.serethewind.JPosTMS.services.interfaces.IsoMsgInterface;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.jpos.iso.*;
//import org.jpos.iso.channel.XMLChannel;
//import org.jpos.iso.packager.GenericPackager;
//import org.jpos.iso.packager.XMLPackager;
//import org.jpos.util.LogSource;
//import org.jpos.util.Logger;
//import org.jpos.util.SimpleLogListener;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//
//@Service
//@AllArgsConstructor
//@NoArgsConstructor
//@Slf4j
//public class IsoMsgInterfaceImpl implements IsoMsgInterface {
//    private GenericPackager genericPackager;
//
//    @Override
//    public ISOMsg createIsoMsg() {
//        ISOMsg isoMsg = new ISOMsg();
//        genericPackager = createPackager();
//        isoMsg.setPackager(genericPackager);
//        return isoMsg;
//    }
//
//    @Override
//    public GenericPackager createPackager() {
//        try {
//            genericPackager = new GenericPackager("/fields.xml");
//        } catch (ISOException e) {
//            log.info(String.format("exception occurred: %s", e.getMessage()));
//            throw new GenericPackageNotFoundException("Package not found");
//        }
//        return genericPackager;
//    }
//
//    @Override
//    public ISOMsg parseIsoMessage(String message) {
//       ISOMsg isoMsg = createIsoMsg(); //returns an instance which already has a packager.
//       try {
//           isoMsg.unpack(message.getBytes());
//       } catch (ISOException e){
//           throw new BytesNotFoundInParseMessageException(String.format("exception occurred: %s", e.getMessage()));
//       }
//       return isoMsg;
//    }
//
//}
