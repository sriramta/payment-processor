package org.acme.micro.service.impl;

import java.util.Map;

import org.acme.micro.service.PaymentExtractorService;
import org.acme.micro.service.mapper.DataMapper;

import generated.CustomerCreditTransferInitiationV03;

public class PaymentExtractorServiceImpl implements PaymentExtractorService {

	/**
	 * This is to be autowired from spring configuration.
	 */
	// @Resource
	private Map<String, DataMapper> dataMappers;

	@Override
	public void extractPaymentInformation(String xmlFilePath) {

		/**
		 * Use Partial XML Transformation to extract only information needed.
		 * And map data with help of mappers.
		 */
		dataMappers.get("FILE/PAYMENT/TRANSACTION").mapData(new CustomerCreditTransferInitiationV03());
		// save to couchBase.
	}

}
