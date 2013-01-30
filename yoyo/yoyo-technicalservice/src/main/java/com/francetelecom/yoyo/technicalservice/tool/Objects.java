package com.francetelecom.yoyo.technicalservice.tool;

public class Objects {
	/**
     * Helps to avoid using {@code @SuppressWarnings({"unchecked"})} when casting to a generic type.
     * See http://stackoverflow.com/questions/509076/how-do-i-address-unchecked-cast-warnings/509230#509230
     */
    @SuppressWarnings({"unchecked"})
    public static <T> T uncheckedCast(Object obj) {
        return (T) obj;
    }

}
