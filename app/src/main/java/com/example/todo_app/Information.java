package com.example.todo_app;

class Information {
    String d;
    int r;
    public Information(String d, int r) {
        this.d=d;
        this.r=r;
    }
    public String getName()
    {
        return d;
    }
    public int getEnable()
    {
        return r;
    }

    public void setEnable(int i) {
        r=i;
    }
}
