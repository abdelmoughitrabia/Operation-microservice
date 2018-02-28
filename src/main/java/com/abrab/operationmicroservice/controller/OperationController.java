package com.abrab.operationmicroservice.controller;

import com.abrab.operationmicroservice.domain.Operation;
import com.abrab.operationmicroservice.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class OperationController {

    @Autowired
    private OperationService operationService;
    @Value("${global}")
    private String testConf;

    @GetMapping("/conf")
    public String testConf() {
        return testConf;
    }

    @GetMapping("/operations")
    public List<Operation> getOperations() {
        return operationService.findAll();
    }

    @GetMapping("/operations/{id}")
    public Operation getOneOperation(@PathVariable("id") Long id) {
        return operationService.findOne(id);
    }

    @GetMapping("/pageOperations")
    public Page<Operation> getPageOfOperation(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "0") int size,
            @RequestParam(name = "type", defaultValue = "") int type
    ) {
        return operationService.pageOfOperations(type, new PageRequest(page, size, Sort.Direction.DESC, "dateCreation"));
    }

    @PostMapping("/operation")
    public Operation save(@RequestBody Operation operation) {
        operation.setDateCreation(new Date());
        return operationService.save(operation);
    }

    @PutMapping("/operation/{id}")
    public Operation edit(Operation operation, @PathVariable("id") Long id) {
        operation.setId(id);
        return operationService.edit(operation);
    }

    @DeleteMapping("/operation/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        return operationService.delete(id);
    }

    @GetMapping("{rib}/operations/size")
    public long totalOperationsByCompte(@PathVariable("rib") String rib) {
        return operationService.sizeByCompte(rib);
    }

}
