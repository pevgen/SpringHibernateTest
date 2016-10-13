CREATE SCHEMA IF NOT EXISTS NSI;
CREATE SCHEMA IF NOT EXISTS TDM;

-- ----------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------
create table IF NOT EXISTS NSI.NS015
(
  kodop_p  CHAR(2) not null,
  name_op  CHAR(21) not null,
  name_ops CHAR(15) not null,
  obozn_op CHAR(3) not null,
  tab_kod  CHAR(18),
  kod_1042 CHAR(2),
  pr_otmen NUMBER(1) default 1 not null,
  tipop_p  VARCHAR2(1),
  pr_vag   NUMBER(1),
  pr_gimr  NUMBER(1)
);
-- Create/Recreate primary, unique and foreign key constraints
alter table NSI.NS015 add constraint XPKNS015 primary key (KODOP_P);
-- ----------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------

create table IF NOT EXISTS NSI.NAME_OB
(
  id_obj      NUMBER(14) not null,
  esrst       CHAR(6) not null,
  type_ob     CHAR(2) not null,
  vid_ob      CHAR(2) not null,
  name_20     CHAR(20) not null,
  name_6      CHAR(6) not null,
  external_id NUMBER(14) default 0,
  name_2      VARCHAR2(2) default 00,
  subtype     NUMBER(3) default 0,
  id_owner    NUMBER(14) default 0,
  num_ob      NUMBER default 0
);
-- Create/Recreate indexes
create index NSI.XIE1NAME_OB on NSI.NAME_OB (TYPE_OB, VID_OB, ESRST);
create index NSI.XIE2NAME_OB on NSI.NAME_OB (ID_OBJ, NUM_OB);
-- Create/Recreate primary, unique and foreign key constraints
alter table NSI.NAME_OB add constraint XPKNAME_OB primary key (ID_OBJ);
-- ----------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------
create table IF NOT EXISTS TDM.TM_OBJECT_OP
(
  id_poezd          NUMBER(38) not null,
  vrsvop            TIMESTAMP not null,
  kodop_p           CHAR(2) not null,
  id_obj            NUMBER(14) not null,
  id_stan           NUMBER not null,
  kateg_poezd       NUMBER,
  esr_f             CHAR(6),
  pn_sost           CHAR(3),
  esr_n             CHAR(6),
  nom_poezd         VARCHAR2(15),
  vag_gol           CHAR(8),
  vag_hvost         CHAR(8),
  udl_p             NUMBER(6,2),
  ves_tara_p        INTEGER,
  ves_netto_p       INTEGER,
  ves_brutto_p      INTEGER,
  osi_p             INTEGER,
  osi_p_rol         INTEGER,
  kol_vag_ob        INTEGER,
  kol_vag_gr        INTEGER,
  kod_prikr_p       CHAR(1),
  marsh_p           CHAR(1),
  ngb_n             CHAR(1),
  ngb_b             CHAR(1),
  ngb_v             CHAR(1),
  ngb_vt            CHAR(1),
  kont_sr_gr_p      INTEGER,
  kont_sr_por_p     INTEGER,
  kont_kr_gr_p      INTEGER,
  kont_kr_por_p     INTEGER,
  pr_tg             CHAR(1),
  pr_pov_vesa       CHAR(1),
  pr_dls            CHAR(1),
  pr_pdl            CHAR(1),
  pr_n_v_pz         CHAR(1),
  pr_n_v_npf        CHAR(1),
  pr_n_v_nsp        CHAR(1),
  otkl_ves          INTEGER,
  otkl_dlin         INTEGER,
  external_kodop_p  INTEGER default 0,
  d_timer           TIMESTAMP,
  kod_vp            NUMBER(1) default 0,
  esr_napr          CHAR(6),
  vrsvop_prev       TIMESTAMP,
  vrsvop_prib       TIMESTAMP,
  prev_id_obj       NUMBER(14),
  prev_id_poezd     NUMBER(38),
  rec_state         NUMBER(1) default 0 not null,
  external_id_poezd NUMBER(38),
  pr_grup           CHAR(1),
  tranzit_ost       NUMBER(1),
  key_rep           VARCHAR2(6),
  dis_esr           CHAR(6),
  dis_park          CHAR(2),
  dis_put           CHAR(2),
  mnvr_id_poezd     NUMBER,
  mnvr_kolvag       NUMBER,
  mnvr_dlit         NUMBER,
  vrsvop_ext        TIMESTAMP,
  id_obj_tdm        NUMBER(14),
  gg_time           TIMESTAMP,
  savedate          TIMESTAMP default sysdate not null,
  ves_brutto_kg     INTEGER,
  ves_netto_kg      INTEGER,
  pr_vrf_s          NUMBER(1),
  dlb_p             CHAR(1),
  giv_p             CHAR(1),
  pr_n_v_ohr        CHAR(1),
  pr_razr_gr        CHAR(1),
  pr_soed           CHAR(1),
  pr_1368           NUMBER(1) default 0,
  polnota           CHAR(1),
  esrstkgu          VARCHAR2(6),
  esr_napr_prib     VARCHAR2(6),
  gg_src            NUMBER(4)
);
create index XIE1TM_OBJECT_OP on TDM.TM_OBJECT_OP (VRSVOP);
create index XIE2TM_OBJECT_OP on TDM.TM_OBJECT_OP (SAVEDATE);
create index XIE3TM_OBJECT_OP on TDM.TM_OBJECT_OP (ID_STAN, ID_OBJ);
create index XIE4TM_OBJECT_OP on TDM.TM_OBJECT_OP (ID_OBJ, VRSVOP, KODOP_P);
create index XIE5TM_OBJECT_OP on TDM.TM_OBJECT_OP (REC_STATE, VRSVOP);
-- Create/Recreate primary, unique and foreign key constraints
alter table TDM.TM_OBJECT_OP add constraint XPKTM_OBJECT_OP primary key (ID_POEZD, VRSVOP);
