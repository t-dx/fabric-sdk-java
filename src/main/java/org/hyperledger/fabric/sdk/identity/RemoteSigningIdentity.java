package org.hyperledger.fabric.sdk.identity;

import org.hyperledger.fabric.sdk.User;
import org.hyperledger.fabric.sdk.exception.CryptoException;
import org.hyperledger.fabric.sdk.security.CryptoSuite;

public abstract class RemoteSigningIdentity extends RemoteIdentity implements SigningIdentity {
    public RemoteSigningIdentity(User user) {
        super(user);
    }

    @Override
    public boolean verifySignature(byte[] msg, byte[] sig) throws CryptoException {
        throw new CryptoException("Not Implemented yet!!!");
    }
}