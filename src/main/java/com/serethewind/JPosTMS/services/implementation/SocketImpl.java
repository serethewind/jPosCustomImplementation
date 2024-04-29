package com.serethewind.JPosTMS.services.implementation;

import com.serethewind.JPosTMS.exceptions.IOStyledException;
import com.serethewind.JPosTMS.exceptions.SocketStyledException;
import com.serethewind.JPosTMS.services.interfaces.SocketInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SocketImpl implements SocketInterface {

    private Socket socket;
    private String inetSocketAddress;
    private int aggregatorServerPort;
    private int timeOut;


    @Override
    public Socket createClientSocket() {
        socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(inetSocketAddress, aggregatorServerPort));
        } catch (IOException e){
            throw new SocketStyledException(String.format("exception occurred: %s", e.getMessage()));

        }
        return socket;
    }

    public Socket setSocketTimeout(int timeOut){
        if(socket != null) {
            try {
                socket.setSoTimeout(timeOut);
            } catch (SocketException e){
                throw new SocketStyledException(String.format("exception occurred while setting timeout: %s", e.getMessage()));
            }
            return socket;
        } else {
            throw new IllegalArgumentException("Socket cannot be null");
        }
    }

    public BufferedWriter fromSocketOutputStream(){
        BufferedWriter bufferedWriter;
        try {
         bufferedWriter = new BufferedWriter (new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e){
            throw new SocketStyledException(String.format("exception occurred while fetching input stream from socket: %S", e.getMessage()));
        }
       return bufferedWriter;
    }

    public BufferedReader fromSocketInputStream(){
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e){
            throw new SocketStyledException(String.format("exception occurred while fetching output stream from socket: %S", e.getMessage()));
        }
        return bufferedReader;
    }

    public String readFromBuffer(BufferedReader bufferedReader){
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append(bufferedReader.readLine());
        } catch (IOException e){
            throw new IOStyledException(String.format("exception occurred while reading from buffer: %s", e.getMessage()));
        }
        return stringBuilder.toString();
    }

    public void writeToByteArray(BufferedWriter bufferedWriter, char[] charArray){
        try {
            bufferedWriter.write(charArray);
        } catch (IOException e){
            throw new IOStyledException(String.format("exception occurred while writing from buffer: %s", e.getMessage()));
        }

    }

    public void closeConnections(BufferedReader bufferedReader, BufferedWriter bufferedWriter){

        try {
            bufferedReader.close();
            bufferedWriter.close();
            socket.close();
        } catch (IOException exception){
            throw new IOStyledException(String.format("error occurred while closing connections", exception.getMessage()));
        }

    }


}
