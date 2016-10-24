package org.acme.micro.service.mapper;

import org.acme.micro.domain.File;

import generated.CustomerCreditTransferInitiationV03;

/**
 * File Data Mapper Input to the mapper is the partial jaxb unmarshalled
 * <class>CustomerCreditTransferInitiationV03</class> object.
 * 
 * @author srira
 *
 */
public class FileMapper implements DataMapper<CustomerCreditTransferInitiationV03, File> {

	@Override
	public File mapData(CustomerCreditTransferInitiationV03 input) {

		return new File.Builder().withId("SomeFlakeId").withReference("InputReference").build();
	}

}
