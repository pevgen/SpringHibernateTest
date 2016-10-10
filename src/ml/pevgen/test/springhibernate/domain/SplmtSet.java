package ml.pevgen.test.springhibernate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by user on 15.09.2016.
 */
@Entity
@Table(name = "NSI.SPLMT_SET")
public class SplmtSet {

    @Id
    @Column(name = "id_supplement_set")
    long idSupplementSet;

    @Column(name = "name")
    String name;
    @Column(name = "categ")
    String categ;

}
