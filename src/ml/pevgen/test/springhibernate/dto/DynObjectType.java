package ml.pevgen.test.springhibernate.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * DataTransferObject(DTO) для операций по объектам.
 *
 * @author Polyak Evgeny
 * @since 24.10.2016
 */
public class DynObjectType {

    @JsonProperty("id_poezd")
    private Long idPoezd;

    @JsonProperty("pr_grup")
    private Integer prGroup;

    @JsonProperty("vrsvop")
    private Date vrsvop;

    @JsonProperty("id_obj")
    private Long idObj;
    @JsonProperty("id_park")
    private Long idPark;
    @JsonProperty("id_stan")
    private Long idStan;
    @JsonProperty("is_my_road")
    private Integer isMyRoad;
    @JsonProperty("is_my_nod")
    private Integer isMyNode;
    @JsonProperty("kodop_p")
    private String kodOpP;
    @JsonProperty("name_op")
    private String nameOp;
    @JsonProperty("kateg_poezd")
    private Integer kategPoezd;
    @JsonProperty("nom_poezd")
    private String nomPoezd;
    @JsonProperty("kol_vag_ob")
    private Integer kolVagOb;
    @JsonProperty("udl_p")
    private Integer udlP;
    @JsonProperty("ves_brutto_p")
    private Integer vesBruttoP;
    @JsonProperty("pn_sost")
    private String pnSost;
    @JsonProperty("vag_gol")
    private String vagGol;
    @JsonProperty("vag_hvost")
    private String vagHvost;
    @JsonProperty("esrst_form")
    private Integer esrstForm;
    @JsonProperty("terminal_operation_form")
    private Integer terminalOperationForm;
    @JsonProperty("check_number_form")
    private Integer checkNumberForm;
    @JsonProperty("esrst_nazn")
    private Integer esrstNazn;
    @JsonProperty("terminal_operation_nazn")
    private Integer terminalOperationNazn;
    @JsonProperty("check_number_nazn")
    private Integer checkNumberNazn;
    @JsonProperty("is_stage")
    private Integer stage;
    @JsonProperty("kod_vp")
    private Integer kodVp;
    @JsonProperty("style_name")
    private String styleName;
    @JsonProperty("id_poezd_prev")
    private Long idPoezdPrev;
    @JsonProperty("id_poezd_external")
    private Long idPoezdExternal;
    @JsonProperty("id_poezd_link")
    private Long idPoezdLink;
    @JsonProperty("tip_left")
    private String tipLeft;//                  varchar2(1000), -- комментарий(всплывающая подсказка) : левая часть
    @JsonProperty("tip_right")
    private String tipRight; //                 varchar2(1000), -- комментарий(всплывающая подсказка) : правая часть
    @JsonProperty("tip_top")
    private String tipTop;//                  varchar2(1000), -- комментарий(всплывающая подсказка) : верх
    @JsonProperty("tip_bottom")
    private String tipBottom; //               varchar2(1000), -- комментарий(всплывающая подсказка) : низ
    @JsonProperty("layout_extend_id")
    private Long layoutExtendId; //           number, -- ссылка на ид.в шаблоне, куда привязывается событие (для модели ресурсов)
    @JsonProperty("name_stationary")
    private String nameStationary; //           varchar2(1000), -- наименование динамически-стационарного объекта (т.к. его нет в стационарной модели, для ресурсов),
    @JsonProperty("in_multi_stationary")
    private Integer inMultiStationary; //        number, -- если необходимо учитывать объект в нескольких частях шаблона (например, динам.часть и стационарная)
    @JsonProperty("supplement_set_name")
    private String supplementSetName; //       NSI.SPLMT_SET.NAME%type, -- имя набора "дополнений", который относится к операции (точнее объекту операции)
    @JsonProperty("is_plan")
    private Integer planFact = 0;//                    number default KIND_FACT, -- тип записи план(1)/факт(0 - default)
    @JsonProperty("explosive_railcar_count")
    private Integer explosiveRailcarCount; //    number,
    @JsonProperty("esr_napr")
    private String esr_napr; //                  varchar2(6), --код еср направления отправления
    @JsonProperty("esr_prib")
    private String esrPrib;         //         varchar2(6), --код еср направления прибытия
    @JsonProperty("type_park")
    private Integer typePark;     //             number, -- тип парка, в котором находится поезд
    @JsonProperty("is_read_only")
    private Integer readOnly;       //        number(1) default IS_READ_ONLY_TRUE, -- возможно (0) или нет(1) редактирование операции
    @JsonProperty("esr_obj")
    private Integer esrObj;        //            number, --код еср, соответствующий id_obj
    @JsonProperty("esr_obj_terminal_operation")
    private Integer esrObjTerminalOperation; // number, --5-й знак еср, соответствующий id_obj
    @JsonProperty("esr_obj_check_number")
    private Integer esrObjCheckNumber; //       number, --6-й, проверочный знак еср, соответствующий id_obj
    @JsonProperty("lgas_car_count")
    private Integer lgasCarCount; //             number, -- количество вагонов со сжиженным газом
    @JsonProperty("loc_ser")
    private String locSer; //                   varchar2(1000), -- серия локомотива
    @JsonProperty("loc_ser_num")
    private String locSerNum; //               varchar2(1000), -- номер серии локомотива

    //----------------ПТО-----------------------------------------------------------------------------------------------
    @JsonProperty("crew")
    private String crew;//              varchar2(1000), -- наименование бригады ТО
    @JsonProperty("standard_op_min")
    private Integer standardOpMin;//    number, -- норма операции ТО в минутах
    @JsonProperty("driver_comment")
    private String driverComment;//    varchar2(1000), -- замечаниея машиниста лок-ва, включая его ФИО
    @JsonProperty("esrstkgu")
    private String esrstKgu;//          varchar2(6), --ЕСР станции КГУ
    @JsonProperty("name_st_kgu")
    private String nameStKgu;//       varchar2(20), --наименование станции КГУ
    @JsonProperty("is_same_road_kgu")
    private Integer  sameRoadKgu;//  number, --1-принадлежность станции КГУ нашей дороге
    @JsonProperty("name_st_kgu57")
    private String nameStKgu57; //     varchar2(20), --наименование станции КГУ из АСОУП
    @JsonProperty("is_same_road_kgu57")
    private Integer sameRoadKgu57;// number, --1-принадлежность станции КГУ из АСОУП нашей дороге
    //----------------------------------------------------------------------------------------------------------
    @JsonProperty("plan_departure")
    private Date  planDeparture;
    @JsonProperty("id_protz")
    private Integer idProtz;  // -- ид техпроцесса
    @JsonProperty("prz_por")
    private Integer przPor;
    @JsonProperty("loc_info")
    private String locInfo;
    @JsonProperty("op_comm")
    private String opComm;
    @JsonProperty("mnvr_dlit")
    private Integer mnvrDlit;
    @JsonProperty("disappear")
    private Integer disappear;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public Long getIdPoezd() {
        return idPoezd;
    }

    public void setIdPoezd(Long idPoezd) {
        this.idPoezd = idPoezd;
    }

    public Integer getPrGroup() {
        return prGroup;
    }

    public void setPrGroup(Integer prGroup) {
        this.prGroup = prGroup;
    }

    public Date getVrsvop() {
        return vrsvop;
    }

    public void setVrsvop(Date vrsvop) {
        this.vrsvop = vrsvop;
    }

    public Long getIdObj() {
        return idObj;
    }

    public void setIdObj(Long idObj) {
        this.idObj = idObj;
    }

    public Long getIdPark() {
        return idPark;
    }

    public void setIdPark(Long idPark) {
        this.idPark = idPark;
    }

    public Long getIdStan() {
        return idStan;
    }

    public void setIdStan(Long idStan) {
        this.idStan = idStan;
    }

    public Integer getIsMyRoad() {
        return isMyRoad;
    }

    public void setIsMyRoad(Integer isMyRoad) {
        this.isMyRoad = isMyRoad;
    }

    public Integer getIsMyNode() {
        return isMyNode;
    }

    public void setIsMyNode(Integer isMyNode) {
        this.isMyNode = isMyNode;
    }

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

    public Integer getEsrstForm() {
        return esrstForm;
    }

    public void setEsrstForm(Integer esrstForm) {
        this.esrstForm = esrstForm;
    }

    public Integer getTerminalOperationForm() {
        return terminalOperationForm;
    }

    public void setTerminalOperationForm(Integer terminalOperationForm) {
        this.terminalOperationForm = terminalOperationForm;
    }

    public Integer getCheckNumberForm() {
        return checkNumberForm;
    }

    public void setCheckNumberForm(Integer checkNumberForm) {
        this.checkNumberForm = checkNumberForm;
    }

    public Integer getEsrstNazn() {
        return esrstNazn;
    }

    public void setEsrstNazn(Integer esrstNazn) {
        this.esrstNazn = esrstNazn;
    }

    public Integer getTerminalOperationNazn() {
        return terminalOperationNazn;
    }

    public void setTerminalOperationNazn(Integer terminalOperationNazn) {
        this.terminalOperationNazn = terminalOperationNazn;
    }

    public Integer getCheckNumberNazn() {
        return checkNumberNazn;
    }

    public void setCheckNumberNazn(Integer checkNumberNazn) {
        this.checkNumberNazn = checkNumberNazn;
    }

    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
    }

    public Integer getKodVp() {
        return kodVp;
    }

    public void setKodVp(Integer kodVp) {
        this.kodVp = kodVp;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    public Long getIdPoezdPrev() {
        return idPoezdPrev;
    }

    public void setIdPoezdPrev(Long idPoezdPrev) {
        this.idPoezdPrev = idPoezdPrev;
    }

    public Long getIdPoezdExternal() {
        return idPoezdExternal;
    }

    public void setIdPoezdExternal(Long idPoezdExternal) {
        this.idPoezdExternal = idPoezdExternal;
    }

    public Long getIdPoezdLink() {
        return idPoezdLink;
    }

    public void setIdPoezdLink(Long idPoezdLink) {
        this.idPoezdLink = idPoezdLink;
    }

    public String getTipLeft() {
        return tipLeft;
    }

    public void setTipLeft(String tipLeft) {
        this.tipLeft = tipLeft;
    }

    public String getTipRight() {
        return tipRight;
    }

    public void setTipRight(String tipRight) {
        this.tipRight = tipRight;
    }

    public String getTipTop() {
        return tipTop;
    }

    public void setTipTop(String tipTop) {
        this.tipTop = tipTop;
    }

    public String getTipBottom() {
        return tipBottom;
    }

    public void setTipBottom(String tipBottom) {
        this.tipBottom = tipBottom;
    }

    public Long getLayoutExtendId() {
        return layoutExtendId;
    }

    public void setLayoutExtendId(Long layoutExtendId) {
        this.layoutExtendId = layoutExtendId;
    }

    public String getNameStationary() {
        return nameStationary;
    }

    public void setNameStationary(String nameStationary) {
        this.nameStationary = nameStationary;
    }

    public Integer getInMultiStationary() {
        return inMultiStationary;
    }

    public void setInMultiStationary(Integer inMultiStationary) {
        this.inMultiStationary = inMultiStationary;
    }

    public String getSupplementSetName() {
        return supplementSetName;
    }

    public void setSupplementSetName(String supplementSetName) {
        this.supplementSetName = supplementSetName;
    }

    public Integer getPlanFact() {
        return planFact;
    }

    public void setPlanFact(Integer planFact) {
        this.planFact = planFact;
    }

    public Integer getExplosiveRailcarCount() {
        return explosiveRailcarCount;
    }

    public void setExplosiveRailcarCount(Integer explosiveRailcarCount) {
        this.explosiveRailcarCount = explosiveRailcarCount;
    }

    public String getEsr_napr() {
        return esr_napr;
    }

    public void setEsr_napr(String esr_napr) {
        this.esr_napr = esr_napr;
    }

    public String getEsrPrib() {
        return esrPrib;
    }

    public void setEsrPrib(String esrPrib) {
        this.esrPrib = esrPrib;
    }

    public Integer getTypePark() {
        return typePark;
    }

    public void setTypePark(Integer typePark) {
        this.typePark = typePark;
    }

    public Integer getReadOnly() {
        return readOnly;
    }

    public void setReadOnly(Integer readOnly) {
        this.readOnly = readOnly;
    }

    public Integer getEsrObj() {
        return esrObj;
    }

    public void setEsrObj(Integer esrObj) {
        this.esrObj = esrObj;
    }

    public Integer getEsrObjTerminalOperation() {
        return esrObjTerminalOperation;
    }

    public void setEsrObjTerminalOperation(Integer esrObjTerminalOperation) {
        this.esrObjTerminalOperation = esrObjTerminalOperation;
    }

    public Integer getEsrObjCheckNumber() {
        return esrObjCheckNumber;
    }

    public void setEsrObjCheckNumber(Integer esrObjCheckNumber) {
        this.esrObjCheckNumber = esrObjCheckNumber;
    }

    public Integer getLgasCarCount() {
        return lgasCarCount;
    }

    public void setLgasCarCount(Integer lgasCarCount) {
        this.lgasCarCount = lgasCarCount;
    }

    public String getLocSer() {
        return locSer;
    }

    public void setLocSer(String locSer) {
        this.locSer = locSer;
    }

    public String getLocSerNum() {
        return locSerNum;
    }

    public void setLocSerNum(String locSerNum) {
        this.locSerNum = locSerNum;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public Integer getStandardOpMin() {
        return standardOpMin;
    }

    public void setStandardOpMin(Integer standardOpMin) {
        this.standardOpMin = standardOpMin;
    }

    public String getDriverComment() {
        return driverComment;
    }

    public void setDriverComment(String driverComment) {
        this.driverComment = driverComment;
    }

    public String getEsrstKgu() {
        return esrstKgu;
    }

    public void setEsrstKgu(String esrstKgu) {
        this.esrstKgu = esrstKgu;
    }

    public String getNameStKgu() {
        return nameStKgu;
    }

    public void setNameStKgu(String nameStKgu) {
        this.nameStKgu = nameStKgu;
    }

    public Integer getSameRoadKgu() {
        return sameRoadKgu;
    }

    public void setSameRoadKgu(Integer sameRoadKgu) {
        this.sameRoadKgu = sameRoadKgu;
    }

    public String getNameStKgu57() {
        return nameStKgu57;
    }

    public void setNameStKgu57(String nameStKgu57) {
        this.nameStKgu57 = nameStKgu57;
    }

    public Integer getSameRoadKgu57() {
        return sameRoadKgu57;
    }

    public void setSameRoadKgu57(Integer sameRoadKgu57) {
        this.sameRoadKgu57 = sameRoadKgu57;
    }

    public Date getPlanDeparture() {
        return planDeparture;
    }

    public void setPlanDeparture(Date planDeparture) {
        this.planDeparture = planDeparture;
    }

    public Integer getIdProtz() {
        return idProtz;
    }

    public void setIdProtz(Integer idProtz) {
        this.idProtz = idProtz;
    }

    public Integer getPrzPor() {
        return przPor;
    }

    public void setPrzPor(Integer przPor) {
        this.przPor = przPor;
    }

    public String getLocInfo() {
        return locInfo;
    }

    public void setLocInfo(String locInfo) {
        this.locInfo = locInfo;
    }

    public String getOpComm() {
        return opComm;
    }

    public void setOpComm(String opComm) {
        this.opComm = opComm;
    }

    public Integer getMnvrDlit() {
        return mnvrDlit;
    }

    public void setMnvrDlit(Integer mnvrDlit) {
        this.mnvrDlit = mnvrDlit;
    }

    public Integer getDisappear() {
        return disappear;
    }

    public void setDisappear(Integer disappear) {
        this.disappear = disappear;
    }
}
