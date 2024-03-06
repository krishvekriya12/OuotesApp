package com.example.ouotesapp;

public class QoutesList {

    private final String qoute;
    private  final String writer;

    public QoutesList(String qoute,String writer){
        this.qoute =  qoute;
        this.writer = writer;
    }
    public  String getQoute(){
        return qoute;
    }
    public String getWriter(){
        return writer;
    }
}
