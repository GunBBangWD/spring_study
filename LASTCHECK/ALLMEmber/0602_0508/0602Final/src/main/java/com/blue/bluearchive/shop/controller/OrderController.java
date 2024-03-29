package com.blue.bluearchive.shop.controller;

import com.blue.bluearchive.shop.dto.OrderDto;
import com.blue.bluearchive.shop.dto.OrderHistDto;
import com.blue.bluearchive.shop.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;
    // Ajax 쓰는 부분
    @PostMapping(value = "/order")
    public @ResponseBody ResponseEntity order(@RequestBody @Valid OrderDto orderDto,
                                              BindingResult bindingResult,
                                              Principal principal) { // 여기서 email을 받아오기에 그것 때문에
                                                                     // security의 principal를 가져오고 쓴다
        if (bindingResult.hasErrors())
        {
            StringBuilder sb = new StringBuilder();
            List<FieldError> fieldErrors =bindingResult.getFieldErrors();
            for(FieldError fieldError: fieldErrors)
            {
                sb.append(fieldError.getDefaultMessage());
            }
            return  new ResponseEntity<String>(sb.toString(), HttpStatus.BAD_REQUEST);
        }
        String email = principal.getName();
        Long orderId;
        try {
            orderId = orderService.order(orderDto, email);
        }
        catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        orderService.checkGrade(principal.getName());
        return new ResponseEntity<Long>(orderId, HttpStatus.OK);
    }

    @GetMapping(value= {"/orders", "/orders/{page}"})
    public String orderHist(@PathVariable("page")Optional<Integer> page, Principal principal, Model model)
    {
        Pageable pageable = PageRequest.of(page.isPresent()?page.get(): 0 , 5);
        Page<OrderHistDto> orderHistDtoList = orderService.getOrderList(principal.getName(), pageable);

        model.addAttribute("orders", orderHistDtoList);
        model.addAttribute("page", pageable.getPageNumber());
        model.addAttribute("maxPage", 5);
        return "shopOrder";
    }

    @PostMapping("/order/{orderId}/cancel")
    public @ResponseBody ResponseEntity cancelOrder(@PathVariable("orderId") Long orderId, Principal principal)
    {
        if(!orderService.validateOrder(orderId, principal.getName()))
        {
            return new ResponseEntity<String>("주문 취소 권한이 없습니다.", HttpStatus.FORBIDDEN);
        }
        orderService.cancelOrder(orderId);
        orderService.checkGrade(principal.getName());
        return new ResponseEntity<Long>(orderId, HttpStatus.OK);
    }



}
