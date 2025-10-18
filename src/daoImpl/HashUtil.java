package daoImpl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Utilidad para manejo de hashing de contraseñas
 * @author Sistema
 * @version 2.0
 */
public class HashUtil {
    
    /**
     * Genera hash MD5 de una cadena
     * @param input Cadena a hashear
     * @return Hash MD5 en formato hexadecimal
     */
    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : array) {
                sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al generar hash MD5", e);
        }
    }
    
    /**
     * Verifica si una cadena ya está hasheada (formato MD5)
     * @param input Cadena a verificar
     * @return true si parece un hash MD5, false en caso contrario
     */
    public static boolean isHashedMD5(String input) {
        if (input == null || input.length() != 32) {
            return false;
        }
        return input.matches("[a-fA-F0-9]{32}");
    }
    
    /**
     * Genera hash SHA-256 de una cadena (más seguro que MD5)
     * @param input Cadena a hashear
     * @return Hash SHA-256 en formato hexadecimal
     */
    public static String getSHA256(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] array = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : array) {
                sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al generar hash SHA-256", e);
        }
    }
    
    /**
     * Verifica si una cadena ya está hasheada (formato SHA-256)
     * @param input Cadena a verificar
     * @return true si parece un hash SHA-256, false en caso contrario
     */
    public static boolean isHashedSHA256(String input) {
        if (input == null || input.length() != 64) {
            return false;
        }
        return input.matches("[a-fA-F0-9]{64}");
    }
}