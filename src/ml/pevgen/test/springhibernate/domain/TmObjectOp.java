package ml.pevgen.test.springhibernate.domain;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by user on 15.09.2016.
 */
@Entity
@Table(name = "TDM.TM_OBJECT_OP")
@Immutable
public class TmObjectOp implements Serializable{

    @Id
    @Column(name = "id_poezd", updatable=false)
    private long idPoezd;
    @Id
    @Column(name = "vrsvop", updatable=false)
    private LocalDateTime vrsvop;

    ////////////////////////////////////////////////////////

    @Column(name = "pr_grup", updatable=false)
    private Integer prGroup;

    @Column(name = "kateg_poezd", updatable=false)
    private Integer kategPoezd;

    @Column(name = "nom_poezd", updatable=false)
    private String nomPoezd;

    @Column(name = "kol_vag_ob", updatable=false)
    private Integer kolVagOb = 0;

    @Column(name = "udl_p", updatable=false)
    private Integer udlP = 0;

    @Column(name = "ves_brutto_p", updatable=false)
    private Integer vesBruttoP = 0;

    @Column(name = "pn_sost", updatable=false)
    private String pnSost;

    @Column(name = "vag_gol", updatable=false)
    private String vagGol;

    @Column(name = "vag_hvost", updatable=false)
    private String vagHvost;

    @Column(name = "vrsvop_prev", updatable=false)
    private LocalDateTime vrsvopPrev;

    @Column(name = "esr_f", updatable=false)
    private String esrF;

    @Column(name = "esr_n", updatable=false)
    private String esrN;

    @Column(name = "external_id_poezd", updatable=false)
    private Long externalIdPoezd;

    @Column(name = "mnvr_id_poezd", updatable=false)
    private Long mnvrIdPoezd;

    /////////////////////////////////////////////////////////////
    @OneToOne
    @JoinColumn(name = "id_stan", updatable=false)
    private NameOb stan;

    @OneToOne
    @JoinColumn(name = "id_obj", updatable=false)
    private NameOb obj;

    @OneToOne
    @JoinColumn(name = "kodop_p", updatable=false)
    private Ns015 kodOpP;

    @OneToOne
    @JoinColumn(name = "prev_id_obj", updatable=false)
    private NameOb objPrev;


    /////////////////////////////////////////////////////////////

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

    public Integer getPrGroup() {
        return prGroup;
    }

    public void setPrGroup(Integer prGroup) {
        this.prGroup = prGroup;
    }

    public Integer getKategPoezd() {
        return kategPoezd;
    }

    public void setKategPoezd(Integer kategPoezd) {
        this.kategPoezd = kategPoezd;
    }

    public String getNomPoezd() {
        return nomPoezd;
    }

    public void setNomPoezd(String nomPoezd) {
        this.nomPoezd = nomPoezd;
    }

    public Integer getKolVagOb() {
        return kolVagOb;
    }

    public void setKolVagOb(Integer kolVagOb) {
        this.kolVagOb = kolVagOb;
    }

    public Integer getUdlP() {
        return udlP;
    }

    public void setUdlP(Integer udlP) {
        this.udlP = udlP;
    }

    public Integer getVesBruttoP() {
        return vesBruttoP;
    }

    public void setVesBruttoP(Integer vesBruttoP) {
        this.vesBruttoP = vesBruttoP;
    }

    public String getPnSost() {
        return pnSost;
    }

    public void setPnSost(String pnSost) {
        this.pnSost = pnSost;
    }

    public String getVagGol() {
        return vagGol;
    }

    public void setVagGol(String vagGol) {
        this.vagGol = vagGol;
    }

    public String getVagHvost() {
        return vagHvost;
    }

    public void setVagHvost(String vagHvost) {
        this.vagHvost = vagHvost;
    }

    public LocalDateTime getVrsvopPrev() {
        return vrsvopPrev;
    }

    public void setVrsvopPrev(LocalDateTime vrsvopPrev) {
        this.vrsvopPrev = vrsvopPrev;
    }

    public String getEsrF() {
        return esrF;
    }

    public void setEsrF(String esrF) {
        this.esrF = esrF;
    }

    public String getEsrN() {
        return esrN;
    }

    public void setEsrN(String esrN) {
        this.esrN = esrN;
    }

    public Long getExternalIdPoezd() {
        return externalIdPoezd;
    }

    public void setExternalIdPoezd(Long externalIdPoezd) {
        this.externalIdPoezd = externalIdPoezd;
    }

    public Long getMnvrIdPoezd() {
        return mnvrIdPoezd;
    }

    public void setMnvrIdPoezd(Long mnvrIdPoezd) {
        this.mnvrIdPoezd = mnvrIdPoezd;
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

    public NameOb getObjPrev() {
        return objPrev;
    }

    public void setObjPrev(NameOb objPrev) {
        this.objPrev = objPrev;
    }
}


/*
                                   substr(NVL(op.esr_f, '000000'), 1, 4) esrst_form,
                                   substr(NVL(op.esr_f, '000000'), 5, 1) terminal_operation_form,
                                   decode(substr(NVL(op.esr_f, '000000'), 6),
                                          ' ',
                                          0,
                                          substr(NVL(op.esr_f, '000000'), 6)) check_number_form,
                                   substr(NVL(op.esr_n, '000000'), 1, 4) esrst_nazn,
                                   substr(NVL(op.esr_n, '000000'), 5, 1) terminal_operation_nazn,
                                   decode(substr(NVL(op.esr_n, '000000'), 6),
                                          ' ',
                                          0,
                                          substr(NVL(op.esr_n, '000000'), 6)) check_number_nazn,
                                   0 is_stage,
                                   op.external_id_poezd,
                                   op.mnvr_id_poezd,
                                   null op_comm,
                                   0 PRWRONGWAY,
                                   tdm.pnx_train_srv_core.KIND_FACT is_plan,
                                   tdm.pnx_train_srv_core.IS_READ_ONLY_TRUE is_read_only
* */
