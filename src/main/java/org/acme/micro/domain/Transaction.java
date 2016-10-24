package org.acme.micro.domain;

import java.math.BigDecimal;

/**
 * Transaction Object
 * 
 * @author srira
 *
 */
public class Transaction extends DomainObject {

	private String crdtAccount;
	private String crdtAccountCcy;
	private BigDecimal amount;
	private String paymentReference;

	public static class Builder {
		private String crdtAccount;
		private String crdtAccountCcy;
		private BigDecimal amount;
		private String paymentReference;

		public Builder crdtAccount(String crdtAccount) {
			this.crdtAccount = crdtAccount;
			return this;
		}

		public Builder crdtAccountCcy(String crdtAccountCcy) {
			this.crdtAccountCcy = crdtAccountCcy;
			return this;
		}

		public Builder amount(BigDecimal amount) {
			this.amount = amount;
			return this;
		}

		public Builder paymentReference(String paymentReference) {
			this.paymentReference = paymentReference;
			return this;
		}

		public Transaction build() {
			return new Transaction(this);
		}
	}

	private Transaction(Builder builder) {
		this.crdtAccount = builder.crdtAccount;
		this.crdtAccountCcy = builder.crdtAccountCcy;
		this.amount = builder.amount;
		this.paymentReference = builder.paymentReference;
	}
}
