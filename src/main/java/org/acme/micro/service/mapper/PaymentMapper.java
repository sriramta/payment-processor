package org.acme.micro.service.mapper;

import org.acme.micro.domain.Payment;

import generated.PaymentInstructionInformation3;

public class PaymentMapper implements DataMapper<PaymentInstructionInformation3, Payment> {

	@Override
	public Payment mapData(PaymentInstructionInformation3 input) {

		return new Payment.Builder().withDbtAccount(input.getDbtrAcct().getId().getIBAN())
				.withCurrency(input.getDbtrAcct().getCcy()).withCtrlSum(input.getCtrlSum())
				.withNoOfTx(Integer.parseInt(input.getNbOfTxs()))
				.withDbtAgent(input.getDbtrAgt().getFinInstnId().getNm()).build();
	}

}
