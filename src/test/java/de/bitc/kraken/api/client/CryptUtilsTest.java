package de.bitc.kraken.api.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CryptUtilsTest {

	private CryptUtils cryptUtils;

	@BeforeEach
	void setUp() throws Exception {
		cryptUtils = new CryptUtils();
	}

	@Test
	void testConcatByteArry() {
		byte[] concat = cryptUtils.concatByteArray("The".getBytes(), "Test".getBytes());

		assertEquals("TheTest", new String(concat));
	}

	@Test()
	void testGenerateSignature() throws InvalidKeyException, NoSuchAlgorithmException {
		Map<String, String> postData = new HashMap<>();
		postData.put("nonce", "1614577757468000");
		String signature = cryptUtils.generateSignature(
				"fRF3XSNJO++5RandomizedTestExamplejsepwS634PJGylaIYeEY4gzuWVuL3JkM23vrN1Cr66ibCvQqh65Hz==",
				"/0/private/Balance", postData);
		assertEquals(
				"K6ABJzsZo3Ke39GcV6yMne19ClXRRxbmvIKZGsDIiBPgA0LUOsegn8LNPSh8le+zTxx5SSDsZuXhy2LXR8oYQA==",
				signature);
	}
}
