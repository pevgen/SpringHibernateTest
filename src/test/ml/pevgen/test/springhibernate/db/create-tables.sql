CREATE SCHEMA IF NOT EXISTS NSI;
CREATE SCHEMA IF NOT EXISTS TDM;



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
alter table TDM.TM_OBJECT_OP
add constraint XPKTM_OBJECT_OP primary key (ID_POEZD, VRSVOP);


-- create table IF NOT EXISTS TDM.TM_OBJECT_OP
-- (
--   id_poezd NUMBER not null,
--   VRSVOP date,
--   kodop_p CHAR(2)
-- );


-- create table IF NOT EXISTS DBQ.DBQ_CHAINS
-- (
--   id_chain NUMBER not null,
--   comm VARCHAR2(4000),
--   kod_doc NUMBER
-- );

-- create table IF NOT EXISTS DBQ.DBQ_EXTCALL
-- (
--   id_chain NUMBER not null,
--   key_string VARCHAR2(2000),
--   key_type VARCHAR2(100)
-- );
--
-- create table IF NOT EXISTS DBQ.DBQ_OP
-- (
--   id_operation              NUMBER not null,
--   sender_type               VARCHAR2(100) not null,
--   in_out                    VARCHAR2(7) default 'IN_OUT',
--   attempt_count             NUMBER,
--   attempt_interval          NUMBER,
--   id_group                  NUMBER,
--   comm                      VARCHAR2(2000),
--   time_response_waiting_sec NUMBER default 60
-- );
--
-- create table IF NOT EXISTS DBQ.DBQ_OP_XSLT
-- (
--   id_operation NUMBER not null,
--   xslt_text CLOB
-- );
--
-- create table IF NOT EXISTS DBQ.DBQ_OP_DBPROC
-- (
--   id_operation  NUMBER not null,
--   package_name  VARCHAR2(1000),
--   function_name VARCHAR2(1000)
-- );
--
-- create table IF NOT EXISTS DBQ.DBQ_OP_HTTP
-- (
--   id_operation NUMBER not null,
--   host_name    VARCHAR2(1000),
--   port         NUMBER default 80,
--   context_path VARCHAR2(2000),
--   headers      VARCHAR2(2000),
--   method       VARCHAR2(100) default 'POST'
-- );
--
-- create table IF NOT EXISTS DBQ.DBQ_OP_ROUTES
-- (
--   id_chain           NUMBER not null,
--   id_operation       NUMBER not null,
--   id_operation_ok    NUMBER,
--   id_operation_error NUMBER,
--   npp                NUMBER
-- );
--
-- create table IF NOT EXISTS DBQ.DBQ_QUEUE_REQUEST
-- (
--   id_message                NUMBER not null,
--   id_message_prev           NUMBER,
--   time_create               TIMESTAMP(6) default SYSTIMESTAMP,
--   time_process              TIMESTAMP(6),
--   run_status                NUMBER(1) default 0,
--   text                      CLOB,
--   sender_type               VARCHAR2(100) default 'HTTP' not null,
--   props                     VARCHAR2(4000),
--   headers                   VARCHAR2(4000),
--   id_operation              NUMBER not null,
--   in_out                    VARCHAR2(7) default 'IN_OUT' not null,
--   id_chain                  NUMBER,
--   attempt_number            NUMBER default 1,
--   user_properties           VARCHAR2(4000),
--   time_next_attempt         TIMESTAMP(6),
--   time_response_waiting_sec NUMBER default 180
-- );
--
-- create table IF NOT EXISTS DBQ.DBQ_EXTCALL_MESSAGES
-- (
--   id_message NUMBER not null,
--   d_timer    TIMESTAMP(6) default SYSTIMESTAMP,
--   text       CLOB,
--   headers    VARCHAR2(4000),
--   is_error   NUMBER default 0,
--   id_process NUMBER
-- );