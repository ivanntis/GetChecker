package org.websec;

import burp.api.montoya.MontoyaApi;
import burp.api.montoya.core.Annotations;
import burp.api.montoya.core.HighlightColor;
import burp.api.montoya.http.handler.*;

public class PostHttpRequestHandler implements HttpHandler {
    public static final String URL_VALIDATE = "mercadolibre.com";
    public static final String METHOD_VALIDATE = "POST";
    public static final String CONTENT_TYPE_VALIDATOR = "application/x-www-form-urlencoded";
    private final MontoyaApi api;

    public PostHttpRequestHandler(MontoyaApi api) {
        this.api = api;
    }

    @Override
    public RequestToBeSentAction handleHttpRequestToBeSent(HttpRequestToBeSent httpRequestToBeSent) {
        Annotations annotations = httpRequestToBeSent.annotations();

        if (isPostFormMercadoLibre(httpRequestToBeSent)) {
            annotations = annotations.withNotes("Request was a post");
            PostReplier client = new PostReplier(this.api);
            client.replyGetParameter(httpRequestToBeSent);
        }
        return burp.api.montoya.http.handler.RequestToBeSentAction.continueWith(httpRequestToBeSent, annotations);
    }

    @Override
    public ResponseReceivedAction handleHttpResponseReceived(HttpResponseReceived httpResponseReceived) {
        Annotations annotations = httpResponseReceived.annotations();
        if (isPostFormMercadoLibre(httpResponseReceived)) {
            annotations = annotations.withHighlightColor(HighlightColor.BLUE);
        }

        return burp.api.montoya.http.handler.ResponseReceivedAction.continueWith(httpResponseReceived, annotations);
    }

    private static boolean isPostFormMercadoLibre(HttpRequestToBeSent httpRequestToBeSent) {
        return httpRequestToBeSent.method().equalsIgnoreCase(METHOD_VALIDATE) &&
                httpRequestToBeSent.headers().stream().anyMatch(httpHeader -> httpHeader.value().equalsIgnoreCase(CONTENT_TYPE_VALIDATOR)) &&
                httpRequestToBeSent.url().contains(URL_VALIDATE);
    }

    private static boolean isPostFormMercadoLibre(HttpResponseReceived httpResponseReceived) {
        return httpResponseReceived.initiatingRequest().method().equalsIgnoreCase(METHOD_VALIDATE) &&
                httpResponseReceived.initiatingRequest().headers().stream().anyMatch(httpHeader -> httpHeader.value().equalsIgnoreCase(CONTENT_TYPE_VALIDATOR)) &&
                httpResponseReceived.initiatingRequest().url().contains(URL_VALIDATE);
    }
}
