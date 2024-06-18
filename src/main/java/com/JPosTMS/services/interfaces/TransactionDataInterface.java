package com.JPosTMS.services.interfaces;

import org.jpos.iso.ISOMsg;

public interface TransactionDataInterface {

    String createTransactionData(ISOMsg IsoMsg);

    String addResponseToTransactionData(ISOMsg isoMsg);

}
