package com.selena.controller.administrator;

import java.io.IOException;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.selena.repository.BillRepository;
import com.selena.repository.SaleOrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.selena.controller.BaseController;
import com.selena.model.SaleOrder;
import com.selena.model.SaleOrderProducts;
import com.selena.service.BillProductService;
import com.selena.service.SaleOrderService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminBillController extends BaseController{
	@Autowired
	private SaleOrderService saleOrderService;

	@Autowired
	private BillProductService billProductService;

	@Autowired
	private SaleOrderProductRepository saleOrderProductRepository;
	//Hiển thị chi tiết bill trong order nếu ấn check
	@RequestMapping(value = ("/admin/bill/{id}"), method = RequestMethod.GET)
	public String viewBill(final Model model, 
			final HttpServletRequest request, 
			final HttpServletResponse response,
			@PathVariable("id") int id) throws IOException {
		
		SaleOrder Order =saleOrderService.searchOrder(id);
		model.addAttribute("customerName", Order.getCustomerName());
		model.addAttribute("customerEmail", Order.getCustomerEmail());
		model.addAttribute("customerPhone", Order.getCustomerPhone());
		model.addAttribute("customerAddress", Order.getCustomerAddress());

		List<SaleOrderProducts> saleOrderProducts = saleOrderProductRepository.findBySaleOrder(saleOrderService.findById(id));
		model.addAttribute("orderDetail", saleOrderProducts);

		return "administrator/bill";
	}
//	@RequestMapping(value = "/admin/bill/search", method = RequestMethod.GET)
//	public String searchBill(@RequestParam("id") int id, Model model) throws IOException {
//		SaleOrder order = saleOrderService.searchOrder(id);
//
//		if (order != null) {
//			model.addAttribute("customerName", order.getCustomerName());
//			model.addAttribute("customerEmail", order.getCustomerEmail());
//			model.addAttribute("customerPhone", order.getCustomerPhone());
//			model.addAttribute("customerAddress", order.getCustomerAddress());
//			List<SaleOrderProducts> saleOrderProducts = saleOrderProductRepository.findBySaleOrder(saleOrderService.findById(id));
//			model.addAttribute("orderDetail", saleOrderProducts);
//
//			return "administrator/bill";
//		} else {
//			// Redirect to an error page or display an error message
//			return "redirect:/error";
//		}
//	}
	@RequestMapping(value = "/admin/bill/search", method = RequestMethod.GET)
	public String searchBill(@RequestParam("id") int id, Model model) throws IOException {
		SaleOrder order = saleOrderService.searchOrder(id);

		if (order != null) {
			model.addAttribute("customerName", order.getCustomerName());
			model.addAttribute("customerEmail", order.getCustomerEmail());
			model.addAttribute("customerPhone", order.getCustomerPhone());
			model.addAttribute("customerAddress", order.getCustomerAddress());

			// Thêm dữ liệu chi tiết hóa đơn vào model
			List<SaleOrderProducts> saleOrderProducts = saleOrderProductRepository.findBySaleOrder(saleOrderService.findById(id));
			model.addAttribute("orderDetail", saleOrderProducts);

			return "administrator/bill";
		} else {
			// Redirect to an error page or display an error message
			return "redirect:/error";
		}
	}

}
