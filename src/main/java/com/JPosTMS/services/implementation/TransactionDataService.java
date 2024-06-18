package com.JPosTMS.services.implementation;

import com.JPosTMS.services.interfaces.TransactionDataInterface;
import com.JPosTMS.repository.TransactionDataRepository;
import lombok.RequiredArgsConstructor;
import org.jpos.iso.ISOMsg;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionDataService implements TransactionDataInterface {

    private final TransactionDataRepository transactionDataRepository;

    @Override
    public String createTransactionData(ISOMsg IsoMsg) {
        return "";
    }

    @Override
    public String addResponseToTransactionData(ISOMsg isoMsg) {
        return "";
    }


}
