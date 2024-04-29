package com.serethewind.JPosTMS.services.implementation;

import com.serethewind.JPosTMS.exceptions.BytesNotFoundInParseMessageException;
import com.serethewind.JPosTMS.exceptions.GenericPackageNotFoundException;
import com.serethewind.JPosTMS.services.interfaces.IsoMsgInterface;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class IsoMsgInterfaceImpl implements IsoMsgInterface {
    private GenericPackager genericPackager;

    @Override
    public ISOMsg createIsoMsg() {
        ISOMsg isoMsg = new ISOMsg();
        isoMsg.setPackager(genericPackager);
        return isoMsg;
    }

    @Override
    public GenericPackager createPackager() {
        try {
            genericPackager = new GenericPackager("/fields.xml");
        } catch (ISOException e) {
            log.info(String.format("exception occurred: %s", e.getMessage()));
            throw new GenericPackageNotFoundException("Package not found");
        }
        return genericPackager;
    }

    @Override
    public ISOMsg parseIsoMessage(String message) {
       ISOMsg isoMsg = createIsoMsg();
       try {
           isoMsg.unpack(message.getBytes());
       } catch (ISOException e){
           throw new BytesNotFoundInParseMessageException(String.format("exception occurred: %s", e.getMessage()));
       }
       return isoMsg;
    }


}
