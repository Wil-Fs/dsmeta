package com.devsuperior.dsmeta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {

	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;
	
	@Autowired
	private SaleRepository salesRepository;
	
	public void sendSms(Long saleId) {
		
		Sale sale = salesRepository.findById(saleId).get();
		
		String date = sale.getDate().getMonthValue() + "/" + sale.getDate().getYear();
		
		String name = sale.getSellerName();
		
		Double amount = sale.getAmount();
		
		String msg = "O vendedor " + name + " foi destaque em " + date +
				" por bater meta no valor de: R$" + String.format("%2f", amount);
				

		Twilio.init(twilioSid, twilioKey);

		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

		Message message = Message.creator(to, from, msg).create();

		System.out.println(message.getSid());
	}
}