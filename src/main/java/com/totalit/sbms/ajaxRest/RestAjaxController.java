/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.totalit.sbms.ajaxRest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.totalit.sbms.domain.Brand;
import com.totalit.sbms.domain.Category;
import com.totalit.sbms.domain.Client;
import com.totalit.sbms.domain.ClientInventory;
import com.totalit.sbms.domain.Contact;
import com.totalit.sbms.domain.RequiredDocuments;
import com.totalit.sbms.dto.CategoryDTO;
import com.totalit.sbms.dto.ClientInventoryDTO;
import com.totalit.sbms.dto.ContactDTO;
import com.totalit.sbms.service.BrandService;
import com.totalit.sbms.service.CategoryService;
import com.totalit.sbms.service.ClientInventoryService;
import com.totalit.sbms.service.ClientService;
import com.totalit.sbms.service.ContactService;
import com.totalit.sbms.service.RequiredDocumentsService;
import com.totalit.sbms.utilities.AjaxResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("ajax/")
public class RestAjaxController {
     @Resource
     private CategoryService categoryService;
     @Resource
     private ContactService contactService;
     @Resource
     private ClientService clientService;
     @Resource
     private ClientInventoryService inventoryService;
     @Resource
     private BrandService brandService;
     @Resource
     private RequiredDocumentsService documentsService;
    
     @PostMapping(value = "/category/add", consumes = "application/json")
       public AjaxResponse addCategory(@RequestBody CategoryDTO categoryDto) throws JsonProcessingException {       
            Category cat =   categoryService.save(categoryDto.getInstance(categoryDto));
            CategoryDTO catDto = new CategoryDTO(cat.getId(), cat.getName(), cat.getDescription());           
            AjaxResponse response = new AjaxResponse("Done", catDto);
            return response;         
     }
    @GetMapping(value = "/category/all")
    public AjaxResponse listCat() {
            
           List<Category> list = categoryService.getAll();
           List<CategoryDTO> categoryDTOs = new ArrayList<>();
           for(Category category : list){
               CategoryDTO categoryDTO = new CategoryDTO(category.getId(), category.getName(), category.getDescription());
               categoryDTOs.add(categoryDTO);
           }          
            AjaxResponse response = new AjaxResponse("Done", categoryDTOs);
            return response;
    }
    @PostMapping(value = "/contact/add", consumes = "application/json")
    public AjaxResponse addContact(@RequestBody ContactDTO contactDto){
        Client client = clientService.get(contactDto.getCi());
        contactDto.setClient(client);
        Contact c = contactService.save(contactDto.getInstance(contactDto));
        ContactDTO cdto = new ContactDTO(c.getId(), c.getFirstName(), c.getLastName(), c.getGender(),
                c.getJobPosition(), c.getDepartment(), c.getOfficePhone(),c.getMobilePhone(), c.getEmail(), c.getClient());
         AjaxResponse response = new AjaxResponse("Done", cdto);
         return response;  
    }
     @PostMapping(value = "/inventory/add", consumes = "application/json")
    public AjaxResponse addClientInventory(@RequestBody ClientInventoryDTO clientInventoryDTO){
         Client client = clientService.get(clientInventoryDTO.getCi());
         Brand b = brandService.get(clientInventoryDTO.getBrand());
         clientInventoryDTO.setClient(client);
         clientInventoryDTO.setBrands(b);
         ClientInventory ci = inventoryService.save(clientInventoryDTO.getInstance(clientInventoryDTO));
         ClientInventoryDTO cidto = new ClientInventoryDTO(ci.getModel(), ci.getQuantity(), ci.getNeedMaintenence());
        
         AjaxResponse response = new AjaxResponse("Done", cidto);
         return response;  
    }
     @GetMapping(value = "/procurementDocs/{id}")
    public AjaxResponse getProcurementDocs(@PathVariable Long id) {
         RequiredDocuments documents = documentsService.findByClient(id);
         AjaxResponse response = new AjaxResponse("Done", documents);
         return response;
    }
    
}
