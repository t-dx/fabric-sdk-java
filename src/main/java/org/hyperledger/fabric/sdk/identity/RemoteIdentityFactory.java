package org.hyperledger.fabric.sdk.identity;

import org.hyperledger.fabric.sdk.User;

public interface RemoteIdentityFactory {
    RemoteSigningIdentity getRemoteSigningIdentity(User u);
}