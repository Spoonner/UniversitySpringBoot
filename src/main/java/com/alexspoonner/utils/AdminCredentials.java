package com.alexspoonner.utils;

/**
 * Created by spoonner on 7/6/17.
 */
public class AdminCredentials {

    private AdminCredentials(){}

    //keep it hardcoded for now
    //TODO: make 'Users' table is DB
    private static final String ADMIN_EMAIL = "admin@superadmin.com";
    private static final String ADMIN_PASSWORD = "adminadmin";

    public static boolean isAdmin(String email, String password) {
        return (email.equals(ADMIN_EMAIL) &&
                password.equals(ADMIN_PASSWORD));
    }
}
