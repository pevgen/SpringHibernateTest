package ml.pevgen.test.springhibernate.dto;

import ml.pevgen.test.springhibernate.domain.TmObjectOp;

/**
 * Конвертер DTO from Entity
 *
 * @author Polyak Evgeny
 * @since 25.10.2016
 */
public class DynObjectTypeConverter {

    public static DynObjectType convert(TmObjectOp entity){

        DynObjectType dto = new DynObjectType();
        dto.setIdPoezd(entity.getIdPoezd());

        return dto;
    }

}
