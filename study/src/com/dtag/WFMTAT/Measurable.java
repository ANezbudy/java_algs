package com.dtag.WFMTAT;

public interface Measurable {

    double getWeight();
    double getLength();
    double getWidth();
    double getHeight();

    void setWeight(double weight);
    void setLength(double length);
    void setWidth(double width);
    void setHeight(double height);


    default double getDensity() {
        return getWeight()/(getLength()*getHeight()*getWeight());
    }


}
