package com.hotsix.titans.generator;

import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.SequenceGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Properties;

public class SalaryGenarator extends SequenceGenerator {

    private final String PREFIX_KEY = "prefix_key";
    private final int DEF_NUMBER_LENGTH = 2;
    private String prefixKey = "";
    private String memberCode;

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {

        prefixKey = ConfigurationHelper.getString( PREFIX_KEY, params);
        super.configure(StandardBasicTypes.LONG, params, serviceRegistry);
    }

    @Override
    public Serializable generate(final SharedSessionContractImplementor session, final Object obj) {

        Serializable v = super.generate(session, obj);

        Long longValue = (Long)v;

        int valueLength = String.valueOf(longValue).length();
        valueLength = valueLength > DEF_NUMBER_LENGTH ? valueLength : DEF_NUMBER_LENGTH;
        valueLength = valueLength > 9 ? 9 : valueLength;

        return String.format(prefixKey + "%0" + memberCode + valueLength + "d", v);
    }
}
