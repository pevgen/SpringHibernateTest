package ml.pevgen.test.springhibernate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by user on 15.09.2016.
 */
@Entity
@Table(name = "NSI.SPLMT_SET_IDS")
public class SplmtSetIds implements Serializable {

    @Id
    @Column(name = "id_supplement_set", updatable=false)
    Long idSupplementSet;

    @Id
    @Column(name = "id_supplement", updatable=false)
    Long idSupplement;


    @Column(name = "sn", updatable=false)
    Integer sn;

}
