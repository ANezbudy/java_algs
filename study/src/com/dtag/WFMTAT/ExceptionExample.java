package com.dtag.WFMTAT;

public class ExceptionExample {
    public static void examplify() {
        System.out.println("Exemplify");
        checkedVSUnchecked();

    }

    private static void checkedVSUnchecked() {
        System.out.println("VS");
//        checked();
//        unchecked();
        try {
            unchecked();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage() + " wtfgt???");
        }
    }

    private static void checked() throws Exception {
        System.out.println("checked");
        throw new Exception("ololo");
    }

    private static void unchecked() throws RuntimeException {
        System.out.println("unchecked");
        throw new RuntimeException("rururur");
//        try{
//            throw new RuntimeException("rururur");
//        } catch (RuntimeException e) {
//            System.out.println("wtf?");
//            e.printStackTrace();
//        }

    }
}
