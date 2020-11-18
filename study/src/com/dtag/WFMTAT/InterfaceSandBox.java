package com.dtag.WFMTAT;

import java.util.ArrayList;
import java.util.HashMap;

public class InterfaceSandBox {

    public static void basicInterfaceExample() {
        HighEducation highEducation = new HighEducation();
        MediumEducation mediumEducation = new MediumEducation();
        BasicEducation basicEducation = new BasicEducation();
        Agreable[] agreables = new  Agreable[3];

        agreables[0] = highEducation;
        agreables[1] = mediumEducation;
        agreables[2] = basicEducation;

        for (int i = 0; i < agreables.length; i++) {
            System.out.println(agreables[i].agree());
        }



    }
}
