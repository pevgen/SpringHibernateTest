package ml.pevgen.test.springhibernate.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    LocalDateTime vrsvop;

    //    @OneToOne(fetch = FetchType.LAZY)
    @OneToOne
    @JoinColumn(name = "id_stan")
    private NameOb stan;


    //    @OneToOne(fetch = FetchType.LAZY)
    @OneToOne
    @JoinColumn(name = "id_obj")
    private NameOb obj;

    //    @OneToOne(fetch = FetchType.LAZY)
    @OneToOne
    @JoinColumn(name = "kodop_p")
    private Ns015 kodOpP;

    public long getIdPoezd() {
        return idPoezd;
    }

    public void setIdPoezd(long idPoezd) {
        this.idPoezd = idPoezd;
    }

    public LocalDateTime getVrsvop() {
        return vrsvop;
    }

    public void setVrsvop(LocalDateTime vrsvop) {
        this.vrsvop = vrsvop;
    }

    public NameOb getStan() {
        return stan;
    }

    public void setStan(NameOb stan) {
        this.stan = stan;
    }

    public NameOb getObj() {
        return obj;
    }

    public void setObj(NameOb obj) {
        this.obj = obj;
    }

    public Ns015 getKodOpP() {
        return kodOpP;
    }

    public void setKodOpP(Ns015 kodOpP) {
        this.kodOpP = kodOpP;
    }
}

