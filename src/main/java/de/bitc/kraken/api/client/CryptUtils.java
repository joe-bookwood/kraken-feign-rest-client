package de.bitc.kraken.api.client;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Service;

/**
 * I try to implement the javascript functions from the Kraken Postman Template
 * 
 * <pre>
 * {@code
 * api_nonce = (Date.now() * 1000).toString();
 * api_endpoint = "/0/private/Balance";
 * api_post = "nonce=" + api_nonce;
 * api_sha256 = CryptoJS.SHA256(api_nonce + api_post);
 * api_sign = CryptoJS.algo.HMAC.create(CryptoJS.algo.SHA512, api_secret);
 * api_sign.update(api_endpoint, api_secret);
 * api_sign.update(api_sha256, api_secret);
 * api_sign = api_sign.finalize().toString(CryptoJS.enc.Base64);
 * 
 * 
 * @return
 */
@Service
public class CryptUtils {

	private static final Charset UTF8_CHARSET = Charset.forName("UTF-8");

	public Long nonce() {
		LocalDateTime ts = LocalDateTime.now();
		return ts.toInstant(ZoneOffset.UTC).toEpochMilli() * 1000L;
	}

	public Map<String, String> initParams() {
		Map<String, String> header = new HashMap<>();
		header.put("nonce", nonce().toString());
		return header;
	}

	/**
	 * @param message
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public byte[] sha256(String message) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		return md.digest(message.getBytes(StandardCharsets.UTF_8));
	}

	public byte[] hmacSha512(byte[] key, byte[] message) throws NoSuchAlgorithmException, InvalidKeyException {
		Mac mac = Mac.getInstance("HmacSHA512");
		mac.init(new SecretKeySpec(key, "HmacSHA512"));
		return mac.doFinal(message);
	}

	private byte[] stringToBytes(String message) {
		return message.getBytes(UTF8_CHARSET);
	}

	public static String bytesToString(byte[] bytes) {
		return new String(bytes, UTF8_CHARSET);
	}

	public static byte[] base64Decode(String input) {
		return Base64.getDecoder().decode(input);
	}

	public static String base64Encode(byte[] data) {
		return Base64.getEncoder().encodeToString(data);
	}

	/**
	 * Concatenate two byte arrays
	 * 
	 * @param a Byte array a
	 * @param b Byte array b
	 * @return the concated arrays
	 */
	public byte[] concatByteArray(byte[] a, byte[] b) {
		int cLength = a.length + b.length;
		byte c[] = new byte[cLength];
		for (int i = 0; i < cLength; i++) {
			c[i] = i < a.length ? a[i] : b[i - a.length];
		}
		return c;
	}

	public String generateSignature( String apiSecret, String path, Map<String, String> postDataMap)
			throws NoSuchAlgorithmException, InvalidKeyException {
		String nonce = postDataMap.get("nonce");
		String postData = postDataMap.entrySet().stream().map(e -> e.getKey() + "=" + e.getValue())
				.collect(Collectors.joining("&"));
		byte[] bytePath = stringToBytes(path);
		String payload = nonce + postData;
		byte[] sha256 = sha256(payload);
		byte[] hmacMessage = concatByteArray(bytePath, sha256);
		byte[] hmacKey = base64Decode(apiSecret);
		byte[] byteHmacSha512 = hmacSha512(hmacKey, hmacMessage);
		String hmacDigest = base64Encode(byteHmacSha512);
		return hmacDigest;
	}
}
