package com.bharath.springcloud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bharath.springcloud.model.Coupon;
import com.bharath.springcloud.model.Product;
import com.bharath.springcloud.repos.ProductRepo;
import com.bharath.springcloud.restclients.CouponClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/productapi")
public class ProductRestController {

	@Autowired
	CouponClient couponClient;

	@Autowired
	private ProductRepo repo;

	@HystrixCommand(fallbackMethod = "sendErrorResponse")
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public Product create(@RequestBody Product product) {
		Coupon coupon = couponClient.getCoupon(product.getCouponCode());
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return repo.save(product);

	}

	public Product sendErrorResponse(Product product) {
		return product;

	}

}
