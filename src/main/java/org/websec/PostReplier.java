package org.websec;

import burp.api.montoya.MontoyaApi;
import burp.api.montoya.http.handler.HttpRequestToBeSent;
import burp.api.montoya.logging.Logging;
import okhttp3.*;

import java.io.IOException;

public class PostReplier {
    OkHttpClient client;
    private final Logging logger;

    public PostReplier(MontoyaApi api) {
        this.client = new OkHttpClient();
        this.logger = api.logging();
    }

    public void replyGetParameter(HttpRequestToBeSent originalRequest)  {
        String urlBase = originalRequest.url();
        String params = originalRequest.bodyToString();
        String url = urlBase+"?"+params;
        this.logger.raiseInfoEvent("url reply 1" +url);
        this.logger.logToOutput("url reply 2" +url);
        Request request = new Request.Builder()
                .url(url)
                .build();
        final Logging loggerRef = this.logger;
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            public void onResponse(Call call, Response response)
                    throws IOException {

                if (response.isSuccessful()) {
                    loggerRef.raiseInfoEvent("replyOK " + response.code());
                    loggerRef.logToOutput("replyOK " + response.code());
                }
                response.close();
            }

            public void onFailure(Call call, IOException e) {
                loggerRef.raiseInfoEvent("Request failed 1: " + e.getMessage() );
                loggerRef.logToOutput("Request failed 2: " + e.getMessage());
            }
        });

   }
}
