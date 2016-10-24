package org.acme.micro.service.mapper;

public interface DataMapper<I, O> {

	O mapData(I input);
}
