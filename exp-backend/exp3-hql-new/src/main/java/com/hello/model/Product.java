package com.hello.model;

import javax.persistence.*;

@Entity
@Table(name="product")
public class Product {

@Id
private int id;

private String name;
private double price;
private int quantity;

public Product(){}

public Product(int id,String name,double price,int quantity){
this.id=id;
this.name=name;
this.price=price;
this.quantity=quantity;
}

public String toString(){
return id+" "+name+" "+price+" "+quantity;
}
}