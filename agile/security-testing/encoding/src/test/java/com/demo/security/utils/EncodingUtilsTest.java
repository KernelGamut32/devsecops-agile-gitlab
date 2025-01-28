package com.demo.security.utils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class EncodingUtilsTest {

    @Test
    void testEncodeForHTML() {
        String maliciousInput = "<script>alert('XSS')</script>";
        String encoded = EncodingUtils.encodeForHTML(maliciousInput);
        assertEquals("&lt;script&gt;alert(&#39;XSS&#39;)&lt;/script&gt;", encoded);
    }

    @Test
    void testEncodeForJavaScript() {
        String maliciousInput = "alert('XSS')";
        String encoded = EncodingUtils.encodeForJavaScript(maliciousInput);
        assertEquals("alert(\\x27XSS\\x27)", encoded);
    }

    @Test
    void testEncodeForURL() {
        String maliciousInput = "https://example.com/?q=<script>";
        String encoded = EncodingUtils.encodeForURL(maliciousInput);
        assertEquals("https%3A%2F%2Fexample.com%2F%3Fq%3D%3Cscript%3E", encoded);
    }

    @Test
    void testEncodeForHTML_EmptyInput() {
        String maliciousInput = "";
        String encoded = EncodingUtils.encodeForHTML(maliciousInput);
        assertEquals("", encoded);
    }

    @Test
    void testEncodeForHTMLAttribute() {
        String maliciousInput = "\" onmouseover=alert('XSS') \"";
        String encoded = EncodingUtils.encodeForHTMLAttribute(maliciousInput);
        assertEquals("&#34; onmouseover=alert(&#39;XSS&#39;) &#34;", encoded);
    }

    @Test
    void testEncodeForHTML_NestedInput() {
        String maliciousInput = "<script>alert('<script>alert(1)</script>')</script>";
        String encoded = EncodingUtils.encodeForHTML(maliciousInput);
        assertEquals("&lt;script&gt;alert(&#39;&lt;script&gt;alert(1)&lt;/script&gt;&#39;)&lt;/script&gt;", encoded);
    }

    @Test
    void testEncodingForInjectionPrevention() {
        String maliciousInput = "<script>alert('XSS')</script>";
        String encoded = EncodingUtils.encodeForHTML(maliciousInput);

        // Assert that the encoded string does not contain dangerous characters
        assertFalse(encoded.contains("<"));
        assertFalse(encoded.contains(">"));
        assertFalse(encoded.contains("'"));
    }
}
