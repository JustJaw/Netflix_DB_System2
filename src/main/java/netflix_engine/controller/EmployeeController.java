package netflix_engine.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import netflix_engine.model.Customer;
import netflix_engine.service.EmployeeService;

@Controller
@SessionAttributes("Employee")
public class EmployeeController {

	@Autowired
    private EmployeeService employeeService;

	/**
    *
    * This will basically perform a query from the mapper's xml file
    * It calls the store procedure in the database.
    *
    */
   @RequestMapping(value="customerList", method = RequestMethod.GET)
   public @ResponseBody List<Customer> returnMailingList() {
 	  List<Customer> customerList = employeeService.returnMailingList();

 	  return customerList;
   }


   @RequestMapping(value="allcustomerList", method = RequestMethod.GET)
   public @ResponseBody List<Customer> getAllCustomers() {
 	  List<Customer> customerList =  employeeService.getAllCustomers();

 	  return customerList;
   }
   
//   @RequestMapping(value="login", method = RequestMethod.GET)
//   public @ResponseBody String login() {

 	 // return "redirect:resources/jsp/login.jsp";
   //}


	 @RequestMapping(value="addcustomer", method = RequestMethod.POST)
	 public @ResponseBody String newCustomer(@RequestBody Customer newCustomer) {

		try {
			employeeService.addCustomer(newCustomer);
			return "hey";
			
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 			
		 
		return "ERROR";
	}
}
