package com.project.authen.main;

import com.project.authen.otp.HmacHashFunction;
import com.project.authen.otp.OTPAuthenticator;
import com.project.authen.otp.OTPAuthenticatorConfig;
import com.project.authen.otp.OTPAuthenticatorKey;

public class Main {
    public static  void main(String []arg){
        int code = genTOTPDefault("JBSWY3DPEHPK3PXP");
        System.out.println(genTOTPDefault("JBSWY3DPEHPK3PXP"));
        System.out.println(genTOTPDefault("JBSWY3DPEHPK3PXP"));
        System.out.println(genTOTPDefault("JBSWY3DPEHPK3PXP"));
        System.out.println(genTOTPDefault("JBSWY3DPEHPK3PXP"));
        System.out.println(genTOTPDefault("JBSWY3DPEHPK3PXP"));
        System.out.println(genTOTPDefault("JBSWY3DPEHPK3PXP"));
        System.out.println(code);
        System.out.println(genTOTP("JBSWY3DPEHPK3PXP"));
        System.out.println(codeValidTOTPDefault("JBSWY3DPEHPK3PXP",genTOTPDefault("JBSWY3DPEHPK3PXP")));
    }

    /**
     * For default
     * Time step size in millis: 30s
     * Code code digits: 6
     * Hash Function: SHA1
     * @param secret: secret code (K)
     * @return otp code
     */
    private static int genTOTPDefault(String secret){
        OTPAuthenticator gAuth = new OTPAuthenticator();
        return gAuth.getTotpPassword(secret);
    }

    private static boolean codeValidTOTPDefault(String secret, int otpCode){
        OTPAuthenticator gAuth = new OTPAuthenticator();
        return gAuth.authorize(secret, otpCode);
    }


    private static int genTOTP(String secret){
        OTPAuthenticatorConfig.OTPAuthenticatorConfigBuilder configBuilder = new OTPAuthenticatorConfig.OTPAuthenticatorConfigBuilder();
        configBuilder.setCodeDigits(8);
        configBuilder.setTimeStepSizeInMillis(600000);
        configBuilder.setHmacHashFunction(HmacHashFunction.HmacSHA256);

        OTPAuthenticator authenticator = new OTPAuthenticator(configBuilder.build());
        return authenticator.getTotpPassword(secret);



    }


}
