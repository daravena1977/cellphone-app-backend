package com.diegoaravena.cellphoneserviceapp.services;

import com.diegoaravena.cellphoneserviceapp.dtos.WorkorderDTO;
import com.diegoaravena.cellphoneserviceapp.models.enums.StateOrder;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.Workorder;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.WorkorderRepairCellphone;
import com.diegoaravena.cellphoneserviceapp.repositories.WorkorderRepairCellphoneRepository;
import com.diegoaravena.cellphoneserviceapp.repositories.WorkorderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class WorkOrderService {

    @Autowired
    private CorrelativeWorkOrderService correlativeWorkOrderService;

    @Autowired
    private WorkorderRepository workorderRepository;

    @Autowired
    WorkorderRepairCellphoneRepository  workorderRepairCellphoneRepository;

    public Workorder createWorkOrder(Workorder workorder) {
        int correlativeNumber = correlativeWorkOrderService.generateCorrelativeNumber();
        workorder.setNumber(correlativeNumber);
        return workorderRepository.save(workorder);
    }

    public WorkorderDTO updateWorkOrder(WorkorderDTO workorderDTO) {
        Workorder workorder = workorderRepository.findById(workorderDTO.getId()).orElse(null);

        if (workorder != null) {
            workorder.setStateOrder(workorderDTO.getStateOrder());
            workorder.setDeliverDate(workorderDTO.getDeliverDate());
            workorder.setDescription(workorderDTO.getDescription());

            workorderDTO.getWorkorderRepairCellphones().forEach(workorderRepairCellphoneDTO -> {
                WorkorderRepairCellphone workorderRepairCellphone = workorderRepairCellphoneRepository
                        .findById(workorderRepairCellphoneDTO.getId()).orElse(null);

                if (workorderRepairCellphone != null) {
                    workorderRepairCellphone.setPayment(workorderRepairCellphoneDTO.getPayment());
                }
            }  );

            workorderRepository.save(workorder);

            return new WorkorderDTO(workorder);

        } else {
            throw new RuntimeException("No se encontro la orde de trabajo número: " + workorderDTO.getNumber() +
                    "de fecha " + workorderDTO.getCreationDate());
        }
    }

    public Set<WorkorderDTO> findAllWorkOrdersByNumber(Integer number) {
        return workorderRepository
                .findByNumber(number)
                .stream()
                .map(WorkorderDTO::new)
                .collect(Collectors.toSet());
    }

    public Set<WorkorderDTO> findAllWorkOrdersByDate(LocalDate startDate, LocalDate endDate) {
        return workorderRepository.searchByDate(startDate, endDate)
                .stream()
                .map(WorkorderDTO::new)
                .collect(Collectors.toSet());
    }

    public Set<WorkorderDTO> findAllWorkOrdersByState(StateOrder stateOrder) {
        return workorderRepository.searchByState(stateOrder)
                .stream()
                .map(WorkorderDTO::new)
                .collect(Collectors.toSet());
    }

}
