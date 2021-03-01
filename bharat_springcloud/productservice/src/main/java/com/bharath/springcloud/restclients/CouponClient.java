package com.bharath.springcloud.restclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bharath.springcloud.model.Coupon;

@FeignClient("zuul-api-gateway")
//@RibbonClient("COUPON-SERVICE")
public interface CouponClient {
	@GetMapping("/coupon-service/couponapi/coupons/{code}")
	Coupon getCoupon(@PathVariable("code") String code);
}
