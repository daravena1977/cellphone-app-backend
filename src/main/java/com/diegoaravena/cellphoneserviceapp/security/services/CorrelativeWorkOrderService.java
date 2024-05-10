package com.diegoaravena.cellphoneserviceapp.security.services;

import com.diegoaravena.cellphoneserviceapp.models.otherclass.CorrelativeWorkOrder;
import com.diegoaravena.cellphoneserviceapp.repositories.CorrelativeWorkOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;

@Service
public class CorrelativeWorkOrderService {

    @Autowired
    private CorrelativeWorkOrderRepository correlativeWorkOrderRepository;

    public int generateCorrelativeNumber() {
        CorrelativeWorkOrder correlativeWorkOrder = getCurrentCorrelative();

        correlativeWorkOrder.setCorrelativeNumber(correlativeWorkOrder.getCorrelativeNumber() + 1);
        correlativeWorkOrderRepository.save(correlativeWorkOrder);
        return correlativeWorkOrder.getCorrelativeNumber();
    }

    private CorrelativeWorkOrder getCurrentCorrelative() {

        CorrelativeWorkOrder correlativeWorkOrder = correlativeWorkOrderRepository
                .findById(1L).orElse(null);

        if (correlativeWorkOrder == null) {
            correlativeWorkOrder = new CorrelativeWorkOrder();
            correlativeWorkOrder.setCorrelativeNumber(0);
            correlativeWorkOrder.setYearCorrelative(Year.now().getValue());
        } else {
            Year year = Year.now();
            if (correlativeWorkOrder.getYearCorrelative() != year.getValue()) {
                correlativeWorkOrder.setCorrelativeNumber(0);
                correlativeWorkOrder.setYearCorrelative(year.getValue());
            }
        }
        return correlativeWorkOrder;
    }
}
