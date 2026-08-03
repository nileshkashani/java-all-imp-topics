// Java 8 introduced multiple helper utilities to handle common programming needs:
// 1. StringJoiner: A class to construct a sequence of characters separated by a delimiter, 
//    and optionally starting with a supplied prefix and ending with a supplied suffix.
// 2. String.join(): A new static method added to String class to quickly join strings.
// 3. Base64: A built-in class (java.util.Base64) that provides encoders and decoders 
//    for the Base64 encoding scheme (both standard and URL-safe).

import java.util.StringJoiner;
import java.util.Base64;
import java.nio.charset.StandardCharsets;

public class StringJoinerBase64 {
    public static void main(String[] args) {

        // ====================================================
        // PART 1: StringJoiner and String.join()
        // ====================================================
        System.out.println("=== Part 1: String Joining ===");

        // 1.1 Using StringJoiner with Delimiter
        StringJoiner sj1 = new StringJoiner(","); // Delimiter is comma
        sj1.add("Java");
        sj1.add("Python");
        sj1.add("JavaScript");
        System.out.println("StringJoiner with delimiter: " + sj1);

        // 1.2 Using StringJoiner with Delimiter, Prefix, and Suffix
        StringJoiner sj2 = new StringJoiner("-", "[", "]"); // Delimiter: "-", Prefix: "[", Suffix: "]"
        sj2.add("Red");
        sj2.add("Green");
        sj2.add("Blue");
        System.out.println("StringJoiner with prefix/suffix: " + sj2);

        // 1.3 Using String.join() static helper (very convenient!)
        String joinedStr = String.join(" & ", "Nilesh", "Rahul", "Aman");
        System.out.println("String.join helper result: " + joinedStr);


        // ====================================================
        // PART 2: Base64 Encoding and Decoding
        // ====================================================
        System.out.println("\n=== Part 2: Base64 Encoding and Decoding ===");

        String originalMessage = "Welcome to Java 8 Features Guide!";
        System.out.println("Original String: " + originalMessage);

        // 2.1 Basic Encoder and Decoder
        // Encodes standard text to Base64 byte/string representation
        String encodedBase64 = Base64.getEncoder().encodeToString(originalMessage.getBytes(StandardCharsets.UTF_8));
        System.out.println("Encoded String (Basic): " + encodedBase64);

        // Decodes Base64 string back to standard text
        byte[] decodedBytes = Base64.getDecoder().decode(encodedBase64);
        String decodedText = new String(decodedBytes, StandardCharsets.UTF_8);
        System.out.println("Decoded String (Basic): " + decodedText);

        // 2.2 URL and Filename Safe Encoder and Decoder
        // Standard Base64 uses '/' and '+' which can be problematic in URLs.
        // URL Encoder replaces them with '-' and '_' to make them URL-safe.
        String urlToEncode = "https://www.google.com/search?q=java+8+features";
        String encodedUrl = Base64.getUrlEncoder().encodeToString(urlToEncode.getBytes(StandardCharsets.UTF_8));
        System.out.println("\nOriginal URL: " + urlToEncode);
        System.out.println("Encoded URL (Safe):  " + encodedUrl);

        byte[] decodedUrlBytes = Base64.getUrlDecoder().decode(encodedUrl);
        String decodedUrl = new String(decodedUrlBytes, StandardCharsets.UTF_8);
        System.out.println("Decoded URL:         " + decodedUrl);
    }
}
