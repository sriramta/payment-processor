package org.acme.micro.domain;

/**
 * File object.
 * 
 * @author srira
 *
 */
public class File extends DomainObject {

	private String id;
	private String reference;

	public static class Builder {
		private String id;
		private String reference;

		public Builder withId(String id) {
			this.id = id;
			return this;
		}

		public Builder withReference(String reference) {
			this.reference = reference;
			return this;
		}

		public File build() {
			return new File(this);
		}
	}

	private File(Builder builder) {
		this.id = builder.id;
		this.reference = builder.reference;
	}
}
