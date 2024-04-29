package com.serethewind.JPosTMS.services.interfaces;

import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;

public interface IsoMsgInterface {

    ISOMsg createIsoMsg();

    GenericPackager createPackager();

    ISOMsg parseIsoMessage(String isoMsg);
}
