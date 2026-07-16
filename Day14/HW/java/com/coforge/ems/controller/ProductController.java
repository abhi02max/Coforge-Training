package com.coforge.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.coforge.ems.model.Product;
import com.coforge.ems.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService service;

	@RequestMapping("home")
	public ModelAndView loadHome() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ProductHome");

		return mv;
	}

	@RequestMapping(value = "product", method = RequestMethod.POST, params = "submit=Insert")
	public ModelAndView createProduct(@ModelAttribute Product product) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ProductHome");

		String result = "";
		
		if (product.getProductId() == null || product.getProductName() == null || product.getProductName().trim().isEmpty() ||
            product.getProductPrice() == null || product.getProductPrice() <= 0 ||
            product.getProductQuantity() == null || product.getProductQuantity() <= 0) {
			result = "FAILED : Invalid inputs. Name cannot be empty and price/quantity must be > 0.";
		} else {
			boolean status = service.createProduct(product);
			if (status) {
				result = "SUCCESS : Product Object Saved";
			} else {
				result = "FAILED : Product ID already exists";
			}
		}

		mv.addObject("result", result);

		return mv;
	}

	@RequestMapping(value = "product", method = RequestMethod.POST, params = "submit=Update")
	public ModelAndView updateProduct(@ModelAttribute Product product) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ProductHome");

		String result = "";
		
		if (product.getProductName() == null || product.getProductName().trim().isEmpty() ||
            product.getProductPrice() == null || product.getProductPrice() <= 0 ||
            product.getProductQuantity() == null || product.getProductQuantity() <= 0) {
			result = "FAILED : Invalid inputs. Name cannot be empty and price/quantity must be > 0.";
		} else {
			boolean status = service.updateProduct(product);
			if (status) {
				result = "SUCCESS : Product Object Updated";
			} else {
				result = "FAILED : Product Not Found, Nothing Updated";
			}
		}

		mv.addObject("result", result);
		return mv;
	}

	@RequestMapping(value = "product", method = RequestMethod.POST, params = "submit=Delete")
	public ModelAndView deleteProduct(@RequestParam(required=false) Integer productId) {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("ProductHome");

		String result = "";
        if (productId == null) {
            result = "FAILED : Product ID cannot be empty.";
        } else {
		    boolean status = service.deleteProduct(productId);
		    if (status) {
			    result = "SUCCESS : Product Object Deleted";
		    } else {
			    result = "FAILED : Product Not Found, Nothing Deleted";
		    }
        }

		mv.addObject("result", result);

		return mv;
	}

	@RequestMapping(value = "product", method = RequestMethod.POST, params = "submit=Find")
	public ModelAndView findProduct(@RequestParam(required=false) Integer productId) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ProductHome");

		String result = "";
        if (productId == null) {
            result = "FAILED : Product ID cannot be empty.";
        } else {
		    Product found = service.findProduct(productId);
		    if (found != null) {
			    result = "SUCCESS : " + found.toString();
		    } else {
			    result = "FAILED : Product Not Found";
		    }
        }

		mv.addObject("result", result);
		return mv;
	}

	@RequestMapping(value = "product", method = RequestMethod.POST, params = "submit=FindAll")
	public ModelAndView findAllProducts() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ProductHome");

		List<Product> list = service.findAllProducts();

		mv.addObject("result", "SUCCESS : " + list.size() + " Product(s) Found");
		mv.addObject("productList", list);
		return mv;
	}

}
