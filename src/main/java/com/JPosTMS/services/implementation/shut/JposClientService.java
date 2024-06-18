//package com.serethewind.JPosTMS.services.implementation;
//
//import jakarta.annotation.PostConstruct;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//import org.jpos.iso.ISOException;
//import org.jpos.iso.channel.NACChannel;
//import org.jpos.iso.packager.GenericPackager;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//@AllArgsConstructor
//@NoArgsConstructor
//public class JposClientService {
//
//    private Map<String, Integer> ptsaPort= new HashMap<>(); //will be populated
//    private Map<String, Integer> ptsaAddress = new HashMap<>();
//
//    private GenericPackager genericPackager;
//    private NACChannel channel;
//
//    @PostConstruct
//    public void init() throws ISOException, IOException {
//
//    }
//}
