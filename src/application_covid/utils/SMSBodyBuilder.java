package application_covid.utils;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class SMSBodyBuilder {
    public static String getBodyString(Map<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();

        result.append("{\"outboundSMSMessageRequest\":{");

        result.append("\"address\":");
        result.append("\"tel:+"+params.get("address")+"\",");
        result.append("\"senderAddress\":");
        result.append("\"tel:+"+params.get("senderAddress")+"\",");
        result.append("\"outboundSMSTextMessage\":{");
        result.append("\"message\":");
        result.append("\""+params.get("message")+"\"");
        result.append("}}");
        result.append("}}");

        String resultString = result.toString();
        return resultString.length() > 0
                ? resultString.substring(0, resultString.length() - 1)
                : resultString;

    }
}
