package org.hyperledger.fabric.sdk.identity;

import org.hyperledger.fabric.sdk.Enrollment;
import org.hyperledger.fabric.sdk.User;
import org.hyperledger.fabric.sdk.security.CryptoSuite;

public class IdentityFactory {

    private static RemoteIdentityFactory rf;
    private IdentityFactory() {
        // private constructor for utility class
    }

    public static void setRemoteIdentityFactory(RemoteIdentityFactory rf) {
        IdentityFactory.rf = rf;
    }

    public static SigningIdentity getSigningIdentity(CryptoSuite cryptoSuite, User user) {
        Enrollment enrollment = user.getEnrollment();

        try {
            if (enrollment instanceof IdemixEnrollment) { // Need Idemix signer for this.
                return new IdemixSigningIdentity((IdemixEnrollment) enrollment);
            } else if (enrollment instanceof RemoteEnrollment) {
                return rf.getRemoteSigningIdentity(user);
            } else { // for now all others are x509
                return new X509SigningIdentity(cryptoSuite, user);
            }

        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

}
