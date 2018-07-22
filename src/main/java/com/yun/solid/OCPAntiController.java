package com.yun.solid;

import com.yun.solid.partner.payment.CardPaymentDto;
import com.yun.solid.partner.payment.CardType;
import com.yun.solid.partner.shinhan.ShinhanCardPaymentService;
import com.yun.solid.partner.woori.WooriCardPaymentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class OCPAntiController {

    private final ShinhanCardPaymentService shinhanCardPaymentService;
    private final WooriCardPaymentService wooriCardPaymentService;

    @RequestMapping(value = "/ocp/anti/payment", method = RequestMethod.POST)
    public void pay(@RequestBody CardPaymentDto.PaymentRequest req){
        if(req.getType() == CardType.SHINHAN){
            shinhanCardPaymentService.pay(req);
        }else if(req.getType() == CardType.WOORI){
            wooriCardPaymentService.pay(req);
        }
    }

}
