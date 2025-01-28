package com.demo.security.utils;

import org.owasp.encoder.Encode;

public class EncodingUtils {

    public static String encodeForHTML(String input) {
        return Encode.forHtml(input);
    }

    public static String encodeForHTMLAttribute(String input) {
        return Encode.forHtmlAttribute(input);
    }

    public static String encodeForJavaScript(String input) {
        return Encode.forJavaScript(input);
    }

    public static String encodeForURL(String input) {
        return Encode.forUriComponent(input);
    }
}
