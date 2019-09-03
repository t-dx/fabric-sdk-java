package org.hyperledger.fabric.sdk.identity;

import java.io.Serializable;
import java.security.KeyPair;
import java.security.PrivateKey;

import org.hyperledger.fabric.sdk.Enrollment;
import org.hyperledger.fabric.sdk.exception.CryptoException;
import org.hyperledger.fabric.sdk.transaction.ProtoUtils;

public abstract class RemoteEnrollment implements Enrollment, Serializable {
    @Override
    public PrivateKey getKey() {
        return null;
    }
}
