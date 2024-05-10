package com.diegoaravena.cellphoneserviceapp;

import com.diegoaravena.cellphoneserviceapp.models.enums.CellphoneColor;
import com.diegoaravena.cellphoneserviceapp.models.enums.ERole;
import com.diegoaravena.cellphoneserviceapp.models.enums.StateOrder;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.*;
import com.diegoaravena.cellphoneserviceapp.models.subclass.Admin;
import com.diegoaravena.cellphoneserviceapp.models.subclass.Client;
import com.diegoaravena.cellphoneserviceapp.models.subclass.ClientWholesaler;
import com.diegoaravena.cellphoneserviceapp.models.subclass.Employee;
import com.diegoaravena.cellphoneserviceapp.repositories.*;
import com.diegoaravena.cellphoneserviceapp.security.services.CorrelativeWorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDate;

@SpringBootApplication
public class CellphoneserviceappApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;


	public static void main(String[] args) {
		SpringApplication.run(CellphoneserviceappApplication.class, args);}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("http://localhost:8081")
						.allowedMethods("*")
						.allowedHeaders("*");
			}
		};
	}

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, EmployeeRepository employeeRepository,
									  ClientWholesalerRepository clientWholesalerRepository, BrandRepository brandRepository,
									  ModelRepository modelRepository, CellphoneRepository cellPhoneRepository,
									  RepairRepository repairRepository, RepairCellphoneRepository repairCellPhoneRepository,
									  WorkorderRepository workOrderRepository, WorkorderRepairCellphoneRepository workorderRepairCellphoneRepository,
									  AdminRepository adminRepository, RoleRepository roleRepository, WorkorderRepository workorderRepository,
									  CorrelativeWorkOrderService correlativeWorkOrderService){

		return (args) -> {
			Client client1 = new Client("24852368", "Juan", "Pérez",
					"juanperez@cellphon.com",passwordEncoder.encode("juan123"), "343-5544268", "Racedo 111" );
			clientRepository.save(client1);

			ClientWholesaler clientWholesaler1 = new ClientWholesaler("35478121", "Luis", "Aravena",
					"luis@gmail.com",passwordEncoder.encode("luis123"));
			clientWholesalerRepository.save(clientWholesaler1);

			Employee employee1 = new Employee("45621785", "Enzo", "Aravena",
					"enzo@gmail.com",passwordEncoder.encode("enzo123"), LocalDate.now());
			employeeRepository.save(employee1);

			Admin admin = new Admin("555555", "Juan", "Pérez", "juanperez@admin.com",
					passwordEncoder.encode("admin123"));
			adminRepository.save(admin);

			Brand brand1 = new Brand("SAMSUNG");
			Brand brand2 = new Brand("MOTOROLA");
			Brand brand3 = new Brand("LG");
			Brand brand4 = new Brand("XIAOMI");
			Brand brand5 = new Brand("IPHONE");

			brandRepository.save(brand1);
			brandRepository.save(brand2);
			brandRepository.save(brand3);
			brandRepository.save(brand4);
			brandRepository.save(brand5);

			Model model1 = new Model("A70");
			Model model2 = new Model("G42");
			Model model3 = new Model("G22");
			Model model4 = new Model("A51");
			Model model5 = new Model("E20");
			Model model6 = new Model("15");
			Model model7 = new Model("Z FOLD");
			Model model8 = new Model("K40S");
			Model model9 = new Model("K20");
			Model model10 = new Model("REDMI NOTE 7");
			Model model11 = new Model("A03");

			brand1.addModel(model1);
			brand2.addModel(model2);
			brand2.addModel(model3);
			brand1.addModel(model4);
			brand2.addModel(model5);
			brand5.addModel(model6);
			brand1.addModel(model7);
			brand3.addModel(model8);
			brand3.addModel(model9);
			brand4.addModel(model10);
			brand1.addModel(model11);

			modelRepository.save(model1);
			modelRepository.save(model2);
			modelRepository.save(model3);
			modelRepository.save(model4);
			modelRepository.save(model5);
			modelRepository.save(model6);
			modelRepository.save(model7);
			modelRepository.save(model8);
			modelRepository.save(model9);
			modelRepository.save(model10);
			modelRepository.save(model11);

			Cellphone cellPhone1 = new Cellphone(brand1, model1);
			Cellphone cellPhone2 = new Cellphone(brand2, model3);

			cellPhoneRepository.save(cellPhone1);
			cellPhoneRepository.save(cellPhone2);

			Repair repair1 = new Repair("CAMBIO DE MODULO");
			Repair repair2 = new Repair("PIN DE CARGA");
			Repair repair3 = new Repair("BOTON DE ENCENDIDO");
			Repair repair4 = new Repair("PLACA DE CARGA");

			repairRepository.save(repair1);
			repairRepository.save(repair2);
			repairRepository.save(repair3);
			repairRepository.save(repair4);


			RepairCellphone repairCellPhone1 = new RepairCellphone(35000d);

			repairCellPhone1.setCellPhone(cellPhone1);
			repairCellPhone1.setRepair(repair1);

			RepairCellphone repairCellphone2 = new RepairCellphone(15600d);

			repairCellphone2.setCellPhone(cellPhone2);
			repairCellphone2.setRepair(repair1);

			Workorder workOrder1 = new Workorder(correlativeWorkOrderService.generateCorrelativeNumber(),
					LocalDate.now(), LocalDate.now(), "Fixing module", StateOrder.PENDIENTE);

			Workorder workorder2 = new Workorder(correlativeWorkOrderService.generateCorrelativeNumber(),
					LocalDate.now(), LocalDate.now(), "Fixing all", StateOrder.PENDIENTE);

            Workorder workorder3 = new Workorder(1, LocalDate.now().plusYears(1),LocalDate.now(),"Hola",StateOrder.ENTREGADO);

			WorkorderRepairCellphone workorderRepairCellphone1 = new WorkorderRepairCellphone(32000d);
			WorkorderRepairCellphone workorderRepairCellphone2 = new WorkorderRepairCellphone(15600d);

			workOrder1.setClient(client1);
			workOrder1.addRepair(workorderRepairCellphone1);
			workOrder1.addRepair(workorderRepairCellphone2);

			workorder2.setClient(client1);

            workorder3.setClient(client1);

			workorderRepairCellphone1.setWorkOrder(workOrder1);
			workorderRepairCellphone1.setRepairCellphone(repairCellPhone1);

			workorderRepairCellphone2.setWorkOrder(workOrder1);
			workorderRepairCellphone2.setRepairCellphone(repairCellphone2);

			workOrderRepository.save(workOrder1);
			workorderRepository.save(workorder2);
            workorderRepository.save(workorder3);

			repairCellPhoneRepository.save(repairCellPhone1);
			repairCellPhoneRepository.save(repairCellphone2);
			workorderRepairCellphoneRepository.save(workorderRepairCellphone1);
			workorderRepairCellphoneRepository.save(workorderRepairCellphone2);

			Role roleAdmin = new Role(ERole.ROLE_ADMIN);
			Role roleClient = new Role(ERole.ROLE_CLIENT);
			Role roleClientWholesaler = new Role(ERole.ROLE_CLIENT_WHOLESALER);

			roleRepository.save(roleAdmin);
			roleRepository.save(roleClient);
			roleRepository.save(roleClientWholesaler);

		};
	};
}
