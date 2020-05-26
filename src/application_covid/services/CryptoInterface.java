package application_covid.services;

/**
 *
 * @author A
 */
public interface CryptoInterface {
    
    byte[] encrypt(byte[] data);
    
    byte[] decrypt(byte[] data);
}
