package com.example.Spring_Boot_JDBC;

import com.example.Spring_Boot_JDBC.dto.CustomerDTO;
import com.example.Spring_Boot_JDBC.entity.Customer;
import com.example.Spring_Boot_JDBC.service.CustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SpringBootJdbcApplication implements CommandLineRunner {
	static Logger logger= LogManager.getLogger(SpringBootJdbcApplication.class);

	static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcApplication.class, args);
	}
	@Autowired
	CustomerService customerService;


	@Override
	public void run(String... args) throws Exception {
		CustomerDTO customer1= new CustomerDTO(7022713754L, "Ash", 27, "M", "MEXICO", 1);
		CustomerDTO customer2= new CustomerDTO(7022713744L, "Robert", 27, "M", "GERMANY", 2);
		CustomerDTO customer3= new CustomerDTO(7022713722L, "Lucy", 27, "F", "INDIA", 3);

		try {
			/*
			inserting data
			 */
//			customerService.insert(customer1);
//			customerService.insert(customer2);
//			customerService.insert(customer3);
//			logger.info("Records are successfully added..");

			/*
			fetching all data
			 */
//			List<Customer> custList = customerService.selectAllCustomers();
//
//			logger.info(" **** Records in the Table ****");
//			logger.info(" PhoneNo        Name    Age   Gender    Address       PlanID");
//			for (Customer list : custList) {
//				logger.info(list.getPhoneNumber() + "\t" + list.getName() + "\t" + list.getAge() + "\t" + list.getGender()
//						+ "\t" + list.getAddress() + "\t\t" + list.getPlanId());
//			}

			/*
			getting the count of data
			 */
//			logger.info("Number of records in the Employee Table are:{} ",customerService.getNumberOfCustomers());

			/*
			deleting the data
			 */
//			logger.info("Enter the phone Number of the Customer which has to be deleted.");
//			Long phoneNo = scanner.nextLong();
//			// Invoking Service layer method to remove Employee details from
//			// Employee table
//			int result = customerService.delete(phoneNo);
//			if (result == 1) {
//				logger.info("Success : Record deleted successfully ");
//			} else {
//				logger.info("Error : No record found for the given phone number ");
//			}

			/*
			updating the database
			 */
//			logger.info("Enter the customer number to be updated ");
//			Long custNo = scanner.nextLong();
//			logger.info("Enter the new Address:  ");
//			String address = scanner.next();
//			int x1 = customerService.updateCustomer(custNo, address);
//			if (x1 > 0) {
//				logger.info(" Record Updated ");
//			} else {
//				logger.info(" No records found for the empid given ");
//			}

			/*
			fetching single data from database
			 */
//			logger.info("Enter the PhoneNo to be fetched ");
//			Long custNo = scanner.nextLong();
//			logger.info(customerService.get(custNo));


			/*
			using the transcation scope
			 */
//			CustomerDTO customer = new CustomerDTO(70227137100L, "Robert", 27, "M", "VENICE", 1);
//			int z=customerService.TransactionalUpdateCustomer(CustomerDTO.CustomerEntity(customer),50,50);
//			if(z>0){
//				logger.info("Transaction successfull");
//			}
//			else {
//				logger.info("Transaction failed");
//			}

			/*
			invoking stored procedure
			 */
//			CustomerDTO a=new CustomerDTO(10002040L,"Rajesh",21,"T","China",2);
//			logger.info(customerService.inertPrepareCall(a));

			/*
			stored procedure using jdbc call
			 */
			logger.info(customerService.getCustomerStoredProcedure(7022713722L));

			scanner.close();
		}
		catch (DataAccessException e){
			logger.info(e.getMessage());
		}




	}
}
