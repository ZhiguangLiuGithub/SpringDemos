package com.jia.bean2;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class bean1 {

//类的静态工厂方法
    /*
    private static bean1 instance=new bean1();
    private static bean1 createInstance()
    {
        return instance;
    }
*/



    private String strValue;
    private int intValue;
    private String[] arrayValue;
    private List listValue;
    private Map MapValue;

    //提供一个日期类的属性
    private Date dateValue;

    public Date getDateValue() {
        return dateValue;
    }

    public void setDateValue(Date dateValue) {
        this.dateValue = dateValue;
    }

    public Map getMapValue() {
        return MapValue;
    }

    public void setMapValue(Map mapValue) {
        MapValue = mapValue;
    }

    public Set getSetValue() {
        return SetValue;
    }

    public void setSetValue(Set setValue) {
        SetValue = setValue;
    }

    private Set SetValue;

    public String getStrValue() {
        return strValue;
    }

    public void setStrValue(String strValue) {
        this.strValue = strValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public String[] getArrayValue() {
        return arrayValue;
    }

    public void setArrayValue(String[] arrayValue) {
        this.arrayValue = arrayValue;
    }

    public List getListValue() {
        return listValue;
    }

    public void setListValue(List listValue) {
        this.listValue = listValue;
    }

    //无参构造
    public bean1()
    {}


}
