package com.abrab.operationmicroservice.service;

import com.abrab.operationmicroservice.domain.Operation;
import com.abrab.operationmicroservice.dto.Compte;
import com.abrab.operationmicroservice.repository.OperationRepository;
import com.abrab.operationmicroservice.serviceProxy.CompteServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationService {

    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private CompteServiceProxy compteServiceProxy;

    public Operation save(Operation operation) {
        Compte compte = compteServiceProxy.findCompte(operation.getRib());
        if (compte != null) {
            System.out.println("haaaa lport a chef =======================>" + compte.getPort());
            if (operation.getType() == 1) {//credit
                if (compte.getSolde() - operation.getMontant() >= 0) {
                    compte.setSolde(compte.getSolde() - operation.getMontant());
                    compteServiceProxy.editCompte(compte, compte.getId());// TODO tester le cas d'echec !!
                    return operationRepository.save(operation);
                }
            } else {//debit
                compte.setSolde(compte.getSolde() + operation.getMontant());
                compteServiceProxy.editCompte(compte, compte.getId());// TODO tester le cas d'echec !!
                return operationRepository.save(operation);
            }

        }
        return null;
    }

    public Operation edit(Operation operation) {
        //TODO some logic here before edit
        return operationRepository.save(operation);
    }

    public List<Operation> findAll() {
        return operationRepository.findAll();
    }

    public Operation findOne(Long id) {
        return operationRepository.findOne(id);
    }

    public String delete(Long id) {
        Operation operation = operationRepository.findOne(id);
        if (operation != null) {
            Compte compte = compteServiceProxy.findCompte(operation.getRib());
            if (operation.getType() == 1) {
                compte.setSolde(compte.getSolde() + operation.getMontant());
            } else {
                compte.setSolde(compte.getSolde() - operation.getMontant());
            }
            operationRepository.delete(id);
            compteServiceProxy.editCompte(compte, compte.getId());// TODO tester le cas d'echec !!
            return "operation removed";
        }

        return "operation not removed !!";
    }

    public Page<Operation> pageOfOperations(int type, PageRequest pageRequest) {
        return operationRepository.findByTypeEquals(type, pageRequest);
    }

    public List<Operation> findByCompte(String rib) {
        return operationRepository.findByRibLike(rib);
    }

    public long sizeByCompte(String rib) {
        return operationRepository.countOperationByRibLike(rib);
    }
}
