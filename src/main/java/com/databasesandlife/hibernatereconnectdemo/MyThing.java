package com.databasesandlife.hibernatereconnectdemo;

import javax.persistence.*;

@Entity
@Table(name = "my_thing")
public class MyThing {

    @Id
    @Column(name = "string_value")
    public String string_value;
}
