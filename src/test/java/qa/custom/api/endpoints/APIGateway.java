package qa.custom.api.endpoints;

import qa.context.TestContext;
import qa.utils.ConfigLoader;

public class APIGateway {

    public static final String STAGING = "https://staging-apig.splashlearn.com";
    public static final String PREPROD = "https://preprod-apig.splashlearn.com";
    public static final String PROD = "https://apig.splashlearn.com";
    public static final String OTP_GATEWAY ="http://staging-apig.splashlearn.com";

    public static String getUrl() {

        if (ConfigLoader.getInstance().getBaseUrl().contains("preprod"))
            return PREPROD;
        else if (ConfigLoader.getInstance().getBaseUrl().contains("www"))
            return PROD;
        else
            return STAGING;
    }
}
