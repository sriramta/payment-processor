package org.acme.micro.domain;

import java.math.BigDecimal;

/**
 * Payment Object
 * 
 * @author srira
 *
 */
public class Payment extends DomainObject {

	private String dbtAccount;
	private String currency;
	private String payId;
	private String dbtAgent;
	private String dbtAgentAccount;
	private BigDecimal ctrlSum;
	private Integer noOfTx;
	private String fileReference;

	public static class Builder {
		private String dbtAccount;
		private String currency;
		private String payId;
		private String dbtAgent;
		private String dbtAgentAccount;
		private BigDecimal ctrlSum;
		private Integer noOfTx;
		private String fileReference;

		public Builder withDbtAccount(String dbtAccount) {
			this.dbtAccount = dbtAccount;
			return this;
		}

		public Builder withCurrency(String currency) {
			this.currency = currency;
			return this;
		}

		public Builder withPayId(String payId) {
			this.payId = payId;
			return this;
		}

		public Builder withDbtAgent(String dbtAgent) {
			this.dbtAgent = dbtAgent;
			return this;
		}

		public Builder withDbtAgentAccount(String dbtAgentAccount) {
			this.dbtAgentAccount = dbtAgentAccount;
			return this;
		}

		public Builder withCtrlSum(BigDecimal ctrlSum) {
			this.ctrlSum = ctrlSum;
			return this;
		}

		public Builder withNoOfTx(Integer noOfTx) {
			this.noOfTx = noOfTx;
			return this;
		}

		public Builder withFileReference(String fileReference) {
			this.fileReference = fileReference;
			return this;
		}

		public Payment build() {
			return new Payment(this);
		}
	}

	private Payment(Builder builder) {
		this.dbtAccount = builder.dbtAccount;
		this.currency = builder.currency;
		this.payId = builder.payId;
		this.dbtAgent = builder.dbtAgent;
		this.dbtAgentAccount = builder.dbtAgentAccount;
		this.ctrlSum = builder.ctrlSum;
		this.noOfTx = builder.noOfTx;
		this.fileReference = builder.fileReference;
	}
}
