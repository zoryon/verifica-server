package com.example.lib;

public class ResponseMessages {
    private static String REQUEST_ERROR = "Errore effettuato nella richiesta, perfavore riprovare.";
    private static String GUESS_IS_UNDER = "<";
    private static String GUESS_IS_OVER = ">";
    private static String GUESS_IS_CORRECT = "=";

    public static String getREQUEST_ERROR() {
        return REQUEST_ERROR;
    }

    public static String getGUESS_IS_UNDER() {
        return GUESS_IS_UNDER;
    }

    public static String getGUESS_IS_OVER() {
        return GUESS_IS_OVER;
    }


    public static String getGUESS_IS_CORRECT() {
        return GUESS_IS_CORRECT;
    }
}
