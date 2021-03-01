# Rest client for the Kraken Trading Platform
This client is for the use in a Spring Boot based microservice. I did not find a 
[OpenFeign](https://github.com/OpenFeign) based client and decide to write my own.
Rest client communicate with the [Kraken Rest Api](https://www.kraken.com/features/api) of the Kraken trading platform.

To calculate the signature I use the algorithm of the following javascript snippet:

    var CryptoJS = require("crypto-js");
	api_key = "<the api key>";
	api_secret = CryptoJS.enc.Base64.parse("<The signature>==");
	api_nonce = (Date.now() * 1000).toString();
	api_endpoint = "/0/private/Balance";
	api_post = "nonce=" + api_nonce;
	api_sha256 = CryptoJS.SHA256(api_nonce + api_post);
	api_sign = CryptoJS.algo.HMAC.create(CryptoJS.algo.SHA512, api_secret);
	api_sign.update(api_endpoint, api_secret);
	api_sign.update(api_sha256, api_secret);
	api_sign = api_sign.finalize().toString(CryptoJS.enc.Base64);
	console.log('apisign: ' + api_sign);

The snippet is from the [postman](https://support.kraken.com/hc/en-us/articles/360047140731-REST-API-Postman-Collections) kraken example.


I was inspired by this [client](https://github.com/sbouclier/kraken-java-api-client). Thx for this great work. But this is an Spring independent client, I want to use the Spring Framework

**In progress ..** 
