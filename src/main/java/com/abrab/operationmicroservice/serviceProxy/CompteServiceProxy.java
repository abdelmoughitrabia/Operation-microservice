package com.abrab.operationmicroservice.serviceProxy;

import com.abrab.operationmicroservice.config.CompteConfiguration;
import com.abrab.operationmicroservice.dto.Compte;
import com.abrab.operationmicroservice.serviceProxy.fallback.CompteServiceProxyFallback;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Primary//to handle Autowiring problem
@FeignClient(name = "compte-ms", fallback = CompteServiceProxyFallback.class)
@RibbonClient(name = "compte-ms", configuration = CompteConfiguration.class)
public interface CompteServiceProxy {

    @GetMapping("/comptes/rib/{rib}")
    public Compte findCompte(@PathVariable("rib") String rib);

    @PutMapping("/compte/{id}")
    public Compte editCompte(Compte Compte, @PathVariable("id") Long id);

}
