package com.diegoaravena.cellphoneserviceapp.controllers;

import com.diegoaravena.cellphoneserviceapp.dtos.CorrelativeWorkOrderDTO;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.CorrelativeWorkOrder;
import com.diegoaravena.cellphoneserviceapp.repositories.CorrelativeWorkOrderRepository;
import com.diegoaravena.cellphoneserviceapp.security.services.CorrelativeWorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class CorrelativeWorkOrderController {

    @Autowired
    private CorrelativeWorkOrderRepository correlativeWorkOrderRepository;

    @Autowired
    private CorrelativeWorkOrderService correlativeWorkOrderService;

    @GetMapping("/correlative")
    public CorrelativeWorkOrderDTO getCorrelativeWorkOrderDTO() {
        int correlative = correlativeWorkOrderService.generateCorrelativeNumber();

        CorrelativeWorkOrder correlativeWorkOrder = new CorrelativeWorkOrder(correlative, LocalDate.now().getYear());

        return new CorrelativeWorkOrderDTO(correlativeWorkOrder);
    }

}
