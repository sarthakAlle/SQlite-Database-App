package com.example.sqlitedb;

public class Employee {

    public Employee(int sno,String name,double increment) {
        this.Sno = sno;
        this.name=name;
        this.increment=increment;
    }


    public int getSno() {
        return Sno;
    }

    public void setSno(int sno) {
        Sno = sno;
    }

    private  int Sno;
    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getIncrement() {
        return increment;
    }

    public void setIncrement(double increment) {
        this.increment = increment;
    }

    private  double increment;
}
