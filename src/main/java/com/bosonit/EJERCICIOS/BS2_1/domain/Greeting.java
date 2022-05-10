package com.bosonit.EJERCICIOS.BS2_1.domain;

public class Greeting {

    private final long id ;
    private final String content;

    //CONTRUCTOR
    public Greeting (long id, String content){
        this.id = id;
        this.content = content;
    }

    //GETTERS
    public long getId() {
        return id;
    }

    public String getContent (){
        return content;
    }
}
