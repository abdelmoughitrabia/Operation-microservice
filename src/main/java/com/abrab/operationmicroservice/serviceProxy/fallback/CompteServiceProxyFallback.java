package com.abrab.operationmicroservice.serviceProxy.fallback;

import com.abrab.operationmicroservice.dto.Compte;
import com.abrab.operationmicroservice.serviceProxy.CompteServiceProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class CompteServiceProxyFallback implements CompteServiceProxy {

    @Override
    public Compte findCompte(String rib) {

        System.out.println("=========================>findCompte FallBack");
        return null;
    }

    @Override
    public Compte editCompte(Compte Compte, Long id) {

        System.out.println("=========================>editCompte FallBack");
        return null;
    }

}
