package com.jia.bean2.examples;

import com.jia.bean2.bean1;

public class DefaultServiceLocator {
    private static bean1 instance=new bean1();
    public bean1 getInstance()
    {return instance;}

}
