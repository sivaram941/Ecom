package com.spring.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.dao.CategoryDAO;
import com.spring.dao.ProductDAO;
import com.spring.dao.SupplierDAO;
import com.spring.model.Category;
import com.spring.model.Product;



@Controller
	public class ProductController {
		
		@Autowired
		ProductDAO productDAO;
		@Autowired
		SupplierDAO supplierDAO;
		@Autowired
		CategoryDAO categoryDAO;
	/*	@Autowired
		Product product;*/
		private Path path;
		
		@RequestMapping(value = { "product"})
		public String ProductPage(@ModelAttribute("product") Product product,BindingResult result,Model model) {
			//model.addAttribute("category", new Category());
			model.addAttribute("productList", productDAO.list());
			model.addAttribute("supplierList", supplierDAO.list());
			model.addAttribute("categoryList", categoryDAO.list());
			model.addAttribute("ProductPageClicked", "true");
			return "index";
		}
		@RequestMapping(value = { "saveProduct" }, method = RequestMethod.POST)
		public String addProduct(@ModelAttribute("product") Product product,RedirectAttributes attributes,HttpServletRequest request) {
			productDAO.saveProduct(product);
			attributes.addFlashAttribute("SuccessMessage", "Product  has been added/Updated Successfully");
					
			MultipartFile file=product.getImage();
			String rootDirectory = request.getSession().getServletContext().getRealPath("/");
	        path = Paths.get(rootDirectory + "\\resources\\images\\"+product.getId()+".jpg");
	        if (file != null && !file.isEmpty()) {
	            try {
	            	System.out.println("Image Saving Start");
	            	file.transferTo(new File(path.toString()));
	            	System.out.println("Image Saved");
	            } catch (Exception e) {
	                e.printStackTrace();
	                System.out.println("Error");
	                throw new RuntimeException("item image saving failed.", e);
	            }
	        }
		
			return "redirect:/product";
		}
		@RequestMapping("editproduct/{id}")
		public String editCategory(@PathVariable("id") int id, Model model,RedirectAttributes attributes) {
			System.out.println("editProduct");
			attributes.addFlashAttribute("category", this.productDAO.getProductById(id));
			return "redirect:/product";
		}
		@RequestMapping(value = { "removeproduct/{id}"})
		public String removeCategory(@PathVariable("id") int id,RedirectAttributes attributes) throws Exception {
			productDAO.removeProductById(id);
			attributes.addFlashAttribute("DeleteMessage", "product has been deleted Successfully");
			return "redirect:/product";
		}


		
	

}