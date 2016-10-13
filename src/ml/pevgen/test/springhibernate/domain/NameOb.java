package ml.pevgen.test.springhibernate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Polyak on 12.10.2016.
 */
@Entity
@Table(name = "NSI.NAME_OB")
public class NameOb {

    @Id
    @Column(name = "id_obj")
    long idObj;

    @Column(name = "esrst")
    private String esrst;
    @Column(name = "type_ob")
    private String typeOb;
    @Column(name = "vid_ob")
    private String vidOb;
    @Column(name = "name_20")
    private String name20;
    @Column(name = "name_6")
    private String name6;
    @Column(name = "name_2")
    private String name2;
    @Column(name = "external_id")
    private long externalId;
    @Column(name = "subtype")
    private int subType;
    @Column(name = "id_owner")
    private long ownerId;
    @Column(name = "num_ob")
    private int numOb;

    public long getIdObj() {
        return idObj;
    }

    public void setIdObj(long idObj) {
        this.idObj = idObj;
    }

    public String getEsrst() {
        return esrst;
    }

    public void setEsrst(String esrst) {
        this.esrst = esrst;
    }

    public String getTypeOb() {
        return typeOb;
    }

    public void setTypeOb(String typeOb) {
        this.typeOb = typeOb;
    }

    public String getVidOb() {
        return vidOb;
    }

    public void setVidOb(String vidOb) {
        this.vidOb = vidOb;
    }

    public String getName20() {
        return name20;
    }

    public void setName20(String name20) {
        this.name20 = name20;
    }

    public String getName6() {
        return name6;
    }

    public void setName6(String name6) {
        this.name6 = name6;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public long getExternalId() {
        return externalId;
    }

    public void setExternalId(long externalId) {
        this.externalId = externalId;
    }

    public int getSubType() {
        return subType;
    }

    public void setSubType(int subType) {
        this.subType = subType;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public int getNumOb() {
        return numOb;
    }

    public void setNumOb(int numOb) {
        this.numOb = numOb;
    }
}
