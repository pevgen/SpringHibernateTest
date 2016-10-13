package ml.pevgen.test.springhibernate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Polyak on 12.10.2016.
 */
@Entity
@Table(name = "NSI.NS015")
public class Ns015 {

    @Id
    @Column(name = "kodop_p")
    private String kodOpP;

    @Column(name = "name_op")
    private String nameOp;
    @Column(name = "name_ops")
    private String nameOpS;
    @Column(name = "obozn_op")
    private String oboznOp;
    @Column(name = "tab_kod")
    private String tabKod;
    @Column(name = "kod_1042")
    private String kod1042;
    @Column(name = "pr_otmen")
    private Integer prOtmen;
    @Column(name = "tipop_p")
    private String tipOpP;
    @Column(name = "pr_vag")
    private Integer prVag;
    @Column(name = "pr_gimr")
    private Integer prGimr;

    public String getKodOpP() {
        return kodOpP;
    }

    public void setKodOpP(String kodOpP) {
        this.kodOpP = kodOpP;
    }

    public String getNameOp() {
        return nameOp;
    }

    public void setNameOp(String nameOp) {
        this.nameOp = nameOp;
    }

    public String getNameOpS() {
        return nameOpS;
    }

    public void setNameOpS(String nameOpS) {
        this.nameOpS = nameOpS;
    }

    public String getOboznOp() {
        return oboznOp;
    }

    public void setOboznOp(String oboznOp) {
        this.oboznOp = oboznOp;
    }

    public String getTabKod() {
        return tabKod;
    }

    public void setTabKod(String tabKod) {
        this.tabKod = tabKod;
    }

    public String getKod1042() {
        return kod1042;
    }

    public void setKod1042(String kod1042) {
        this.kod1042 = kod1042;
    }

    public String getTipOpP() {
        return tipOpP;
    }

    public void setTipOpP(String tipOpP) {
        this.tipOpP = tipOpP;
    }

    public Integer getPrOtmen() {
        return prOtmen;
    }

    public void setPrOtmen(Integer prOtmen) {
        this.prOtmen = prOtmen;
    }

    public Integer getPrVag() {
        return prVag;
    }

    public void setPrVag(Integer prVag) {
        this.prVag = prVag;
    }

    public Integer getPrGimr() {
        return prGimr;
    }

    public void setPrGimr(Integer prGimr) {
        this.prGimr = prGimr;
    }
}
