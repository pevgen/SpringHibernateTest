package ml.pevgen.test.springhibernate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by user on 15.09.2016.
 */
@Entity
@Table(name = "TDM.TM_OBJECT_OP")
public class TmObjectOp {

    @Id
    @Column(name = "id_poezd")
    long idPoezd;
    @Column(name = "vrsvop")
    Date vrsvop;
    @Column(name = "kodop_p")
    String kodOpP;
    @Column(name = "id_stan")
    long idStan;
    @Column(name = "id_obj")
    long idObj;


    public long getIdPoezd() {
        return idPoezd;
    }

    public void setIdPoezd(long idPoezd) {
        this.idPoezd = idPoezd;
    }

    public Date getVrsvop() {
        return vrsvop;
    }

    public void setVrsvop(Date vrsvop) {
        this.vrsvop = vrsvop;
    }

    public String getKodOpP() {
        return kodOpP;
    }

    public void setKodOpP(String kodOpP) {
        this.kodOpP = kodOpP;
    }

    public long getIdStan() {
        return idStan;
    }

    public void setIdStan(long idStan) {
        this.idStan = idStan;
    }

    public long getIdObj() {
        return idObj;
    }

    public void setIdObj(long idObj) {
        this.idObj = idObj;
    }
}
