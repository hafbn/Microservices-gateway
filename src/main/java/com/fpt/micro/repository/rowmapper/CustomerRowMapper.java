package com.fpt.micro.repository.rowmapper;

import com.fpt.micro.domain.Customer;
import io.r2dbc.spi.Row;
import java.util.function.BiFunction;
import org.springframework.stereotype.Service;

/**
 * Converter between {@link Row} to {@link Customer}, with proper type conversions.
 */
@Service
public class CustomerRowMapper implements BiFunction<Row, String, Customer> {

    private final ColumnConverter converter;

    public CustomerRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link Customer} stored in the database.
     */
    @Override
    public Customer apply(Row row, String prefix) {
        Customer entity = new Customer();
        entity.setId(converter.fromRow(row, prefix + "_id", Long.class));
        entity.setName(converter.fromRow(row, prefix + "_name", String.class));
        entity.setTelephone(converter.fromRow(row, prefix + "_telephone", String.class));
        entity.setMail(converter.fromRow(row, prefix + "_mail", String.class));
        return entity;
    }
}
