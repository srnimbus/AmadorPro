package br.com.srnimbus.amadorpro.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.RSAKeyGenParameterSpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import br.com.srnimbus.amadorpro.exception.AmadorProException;

public class CryptoUtil {

	private static final int RSAKEYSIZE = 1024;

	@Deprecated
	public static String hash(String string) {
		int hash = 1;
		int prime = 31;
		char[] array = string.toCharArray();
		for (int i = 0; i < array.length; i++) {
			hash = prime * hash + array[i];
		}
		// return Integer.toString(prime + hash, 36);
		return Integer.toHexString(prime + hash);
	}

	public static String getHashMD5(String clearText) throws AmadorProException {
		return getHash(clearText, "MD5");
	}

	public static String getHashSHA2(String clearText) throws AmadorProException {
		return getHash(clearText, "SHA-256");
	}

	private static String getHash(String clearText, String instance) throws AmadorProException {

		MessageDigest md;
		String retorno;

		try {
			md = MessageDigest.getInstance(instance);
		} catch (NoSuchAlgorithmException e) {
			throw new AmadorProException(e.getMessage());
		}

		md.update(clearText.getBytes());

		byte[] mdbytes = md.digest();

		retorno = new String();

		for (byte a : mdbytes) {
			retorno += Integer.toString((Byte.valueOf(a) & 0xff) + 0x100, 16).substring(1);
		}

		return retorno;
	}

	// ==========

	public static byte[][] crypt(PublicKey pubKey, byte[] clearText) throws NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException,
			InvalidAlgorithmParameterException {
		byte[] cipheredText = null;
		byte[] cipheredKey = null;

		// -- A) Gerando uma chave simétrica de 128 bits
		KeyGenerator kg = KeyGenerator.getInstance("AES");
		kg.init(128);
		SecretKey sk = kg.generateKey();
		byte[] key = sk.getEncoded();
		// -- B) Cifrando o texto com a chave simétrica gerada
		Cipher aescf = Cipher.getInstance("AES/CBC/PKCS5Padding");
		IvParameterSpec ivspec = new IvParameterSpec(new byte[16]);
		aescf.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"), ivspec);
		cipheredText = aescf.doFinal(clearText);
		// -- C) Cifrando a chave com a chave pública
		Cipher rsacf = Cipher.getInstance("RSA");
		rsacf.init(Cipher.ENCRYPT_MODE, pubKey);
		cipheredKey = rsacf.doFinal(key);

		return new byte[][] { cipheredText, cipheredKey };
	}

	public static byte[] decrypt(PrivateKey pvtKey, byte[] cipheredText, byte[] cipheredKey)
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException,
			BadPaddingException, InvalidAlgorithmParameterException {
		byte[] decipheredText = null;

		// -- A) Decifrando a chave simétrica com a chave privada
		Cipher rsacf = Cipher.getInstance("RSA");
		rsacf.init(Cipher.DECRYPT_MODE, pvtKey);
		byte[] decipheredKey = rsacf.doFinal(cipheredKey);
		// -- B) Decifrando o texto com a chave simétrica decifrada
		Cipher aescf = Cipher.getInstance("AES/CBC/PKCS5Padding");
		IvParameterSpec ivspec = new IvParameterSpec(new byte[16]);
		aescf.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decipheredKey, "AES"), ivspec);
		decipheredText = aescf.doFinal(cipheredText);

		return decipheredText;
	}

	// ==========

	public static PublicKey loadPublicKey(File pubKeyFile) throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pubKeyFile));
		PublicKey ret = (PublicKey) ois.readObject();
		ois.close();
		return ret;
	}

	public static PrivateKey loadPrivateKey(File pvtKeyFile) throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pvtKeyFile));
		PrivateKey ret = (PrivateKey) ois.readObject();
		ois.close();
		return ret;
	}

	public static void generatePairKeys(File pubKeyFile, File pvtKeyFile) throws IOException, NoSuchAlgorithmException,
			InvalidAlgorithmParameterException, CertificateException, KeyStoreException {

		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
		kpg.initialize(new RSAKeyGenParameterSpec(RSAKEYSIZE, RSAKeyGenParameterSpec.F4));
		KeyPair kpr = kpg.generateKeyPair();
		PrivateKey priv = kpr.getPrivate();
		PublicKey pub = kpr.getPublic();

		// -- Gravando a chave pública em formato serializado
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pubKeyFile));
		oos.writeObject(pub);
		oos.close();

		// -- Gravando a chave privada em formato serializado
		// -- Não é a melhor forma (deveria ser guardada em um keystore, e
		// protegida por senha),
		// -- mas isto é só um exemplo
		oos = new ObjectOutputStream(new FileOutputStream(pvtKeyFile));
		oos.writeObject(priv);
		oos.close();

	}

}
