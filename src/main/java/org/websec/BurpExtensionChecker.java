package org.websec;

import burp.api.montoya.BurpExtension;
import burp.api.montoya.MontoyaApi;
import burp.api.montoya.logging.Logging;




public class BurpExtensionChecker implements BurpExtension {

    @Override
    public void initialize(MontoyaApi api) {
        api.extension().setName("Get Checker Extension");
        Logging logging = api.logging();
        api.http().registerHttpHandler(new PostHttpRequestHandler(api));

    }
}

