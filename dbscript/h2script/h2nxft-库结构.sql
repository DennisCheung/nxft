drop schema if exists nxft;
create schema nxft;

--spool h2nxft-¿â½á¹¹.log

--prompt
--prompt Creating table D_MEAL_TYPE
--prompt ==========================
--prompt
create table NXFT.D_MEAL_TYPE
(
  FMEAL_TYPE_ID    VARCHAR2(32) not null,
  FMEAL_TYPE_NAME  VARCHAR2(40) not null,
  FMEAL_TIME       VARCHAR2(4) not null,
  FORDER_BEFORE    NUMBER(2) not null,
  FORDER_RULE_DESC VARCHAR2(256),
  FISAVAILABLE     CHAR(1) not null,
  FMEAL_TYPE_DESC  VARCHAR2(256),
  FVERSION         NUMBER(6) default 0 not null,
  FLOGCBY          VARCHAR2(32) not null,
  FLOGCDATE        timestamp not null,
  FLOGLUBY         VARCHAR2(32) not null,
  FLOGLUDATE       timestamp not null,
  FLOGLABY         VARCHAR2(32) not null,
  FLOGLADATE       timestamp not null
)
;
alter table NXFT.D_MEAL_TYPE
  add constraint PK_D_MEAL_TYPE primary key (FMEAL_TYPE_ID);

--prompt
--prompt Creating table DELIVE_CREATE_LOG
--prompt ================================
--prompt
create table NXFT.DELIVE_CREATE_LOG
(
  FLOG_ID       VARCHAR2(32) not null,
  FMEAL_DATE    timestamp not null,
  FMEAL_TYPE_ID VARCHAR2(32) not null,
  FCREATE_TIME  timestamp not null,
  FLOG_DESC     VARCHAR2(256),
  FVERSION      NUMBER(6) default 0 not null,
  FLOGCBY       VARCHAR2(32) not null,
  FLOGCDATE     timestamp not null,
  FLOGLUBY      VARCHAR2(32) not null,
  FLOGLUDATE    timestamp not null,
  FLOGLABY      VARCHAR2(32) not null,
  FLOGLADATE    timestamp not null
)
;
alter table NXFT.DELIVE_CREATE_LOG
  add constraint PK_DELIVE_CREATE_LOG primary key (FLOG_ID);
alter table NXFT.DELIVE_CREATE_LOG
  add constraint UK_DELIVE_CREATE_LOG unique (FMEAL_DATE, FMEAL_TYPE_ID);
alter table NXFT.DELIVE_CREATE_LOG
  add constraint FK_DELIVE_CREATE_LOG_MEAL foreign key (FMEAL_TYPE_ID)
  references NXFT.D_MEAL_TYPE (FMEAL_TYPE_ID);

--prompt
--prompt Creating table DELIVE_NOTE
--prompt ==========================
--prompt
create table NXFT.DELIVE_NOTE
(
  FDELIVE_NOTE_ID    VARCHAR2(32) not null,
  FCIRCLE_ID         VARCHAR2(32) not null,
  FDELIVE_TYPE       VARCHAR2(30) not null,
  FDELIVE_SITE_ID    VARCHAR2(32) not null,
  FDELIVE_SITE_NAME  VARCHAR2(40) not null,
  FDELIVE_ADDR       VARCHAR2(100) not null,
  FKITCHEN_CIRCLE_ID VARCHAR2(32) not null,
  FMEAL_DATE         timestamp not null,
  FWEEK              NUMBER(1) not null,
  FMEAL_TYPE_ID      VARCHAR2(32) not null,
  FMEAL_TYPE_NAME    VARCHAR2(40) not null,
  FQUANTITY          NUMBER(6) not null,
  FQUANTITY_DESC     VARCHAR2(300) not null,
  FCREATE_TIME       timestamp not null,
  FCREATE_USER_ID    VARCHAR2(32) not null,
  FCREATE_USER_NAME  VARCHAR2(50) not null,
  FLAST_STATE        VARCHAR2(30) not null,
  FLAST_TIME         timestamp not null,
  FLAST_USER_ID      VARCHAR2(32) not null,
  FLAST_NICKNAME     VARCHAR2(40) not null,
  FLAST_DESC         VARCHAR2(256),
  FNEXT_NODE_ID      VARCHAR2(30),
  FNEXT_NODE_CONTENT VARCHAR2(300),
  FIS_COMPLETE       CHAR(1) not null,
  FCOMPLETE_STATE    VARCHAR2(30),
  FFAIL_REASON_NAME  VARCHAR2(50),
  FCOMPLETE_TIME     timestamp,
  FCOMPLETE_USER_ID  VARCHAR2(32),
  FCOMPLETE_NICKNAME VARCHAR2(30),
  FCOMPLETE_DESC     VARCHAR2(256),
  FVERSION           NUMBER(6) default 0 not null,
  FLOGCBY            VARCHAR2(32) not null,
  FLOGCDATE          timestamp not null,
  FLOGLUBY           VARCHAR2(32) not null,
  FLOGLUDATE         timestamp not null,
  FLOGLABY           VARCHAR2(32) not null,
  FLOGLADATE         timestamp not null,
  FKITCHEN_TEAM_ID   VARCHAR2(32) not null,
  FCONTACT_PERSON    VARCHAR2(30),
  FCONTACT_MOBILE    VARCHAR2(30)
)
;
alter table NXFT.DELIVE_NOTE
  add constraint PK_DELIVE_NOTE primary key (FDELIVE_NOTE_ID);
alter table NXFT.DELIVE_NOTE
  add constraint FK_DELIVE_NOTE_CIRCLE foreign key (FCIRCLE_ID)
  references FXP.P_CIRCLE (FCIRCLE_ID);
alter table NXFT.DELIVE_NOTE
  add constraint FK_DELIVE_NOTE_KITCHEN foreign key (FKITCHEN_CIRCLE_ID)
  references FXP.P_CIRCLE (FCIRCLE_ID);
alter table NXFT.DELIVE_NOTE
  add constraint FK_DELIVE_NOTE_KTEAM foreign key (FKITCHEN_TEAM_ID)
  references FXP.P_TEAM (FTEAM_ID);

--prompt
--prompt Creating table MEAL_SET
--prompt =======================
--prompt
create table NXFT.MEAL_SET
(
  FMEAL_ID           VARCHAR2(32) not null,
  FMEAL_CODE         VARCHAR2(30) not null,
  FMEAL_NAME         VARCHAR2(40) not null,
  FMEAL_CONTENT      VARCHAR2(60) not null,
  FTABOO_DISEASE     VARCHAR2(100),
  FPEPPERY_LEVEL     NUMBER(1),
  FMEAL_PRICE        NUMBER(4,2) not null,
  FPHOTO_ID          VARCHAR2(32),
  FKITCHEN_CIRCLE_ID VARCHAR2(32) not null,
  FISAVAILABLE       CHAR(1) not null,
  FMEAL_DESC         VARCHAR2(256),
  FVERSION           NUMBER(6) default 0 not null,
  FLOGCBY            VARCHAR2(32) not null,
  FLOGCDATE          timestamp not null,
  FLOGLUBY           VARCHAR2(32) not null,
  FLOGLUDATE         timestamp not null,
  FLOGLABY           VARCHAR2(32) not null,
  FLOGLADATE         timestamp not null,
  FKITCHEN_TEAM_ID   VARCHAR2(32) not null
)
;
alter table NXFT.MEAL_SET
  add constraint PK_MEAL_SET primary key (FMEAL_ID);
alter table NXFT.MEAL_SET
  add constraint FK_MEAL_SET_KITCHEN foreign key (FKITCHEN_CIRCLE_ID)
  references FXP.P_CIRCLE (FCIRCLE_ID);
alter table NXFT.MEAL_SET
  add constraint FK_MEAL_SET_KTEAM foreign key (FKITCHEN_TEAM_ID)
  references FXP.P_TEAM (FTEAM_ID);

--prompt
--prompt Creating table DELIVE_DETAIL
--prompt ============================
--prompt
create table NXFT.DELIVE_DETAIL
(
  FDETAIL_ID      VARCHAR2(32) not null,
  FMEAL_ID        VARCHAR2(32) not null,
  FMEAL_CODE      VARCHAR2(30) not null,
  FMEAL_NAME      VARCHAR2(40) not null,
  FQUANTITY       NUMBER(6) not null,
  FDELIVE_NOTE_ID VARCHAR2(32),
  FVERSION        NUMBER(6) default 0 not null,
  FLOGCBY         VARCHAR2(32) not null,
  FLOGCDATE       timestamp not null,
  FLOGLUBY        VARCHAR2(32) not null,
  FLOGLUDATE      timestamp not null,
  FLOGLABY        VARCHAR2(32) not null,
  FLOGLADATE      timestamp not null
)
;
alter table NXFT.DELIVE_DETAIL
  add constraint PK_DELIVE_DETAIL primary key (FDETAIL_ID);
alter table NXFT.DELIVE_DETAIL
  add constraint UK_DELIVE_DETAIL unique (FDELIVE_NOTE_ID, FMEAL_ID);
alter table NXFT.DELIVE_DETAIL
  add constraint FK_DELIVE_DETAIL_MEAL foreign key (FMEAL_ID)
  references NXFT.MEAL_SET (FMEAL_ID);
alter table NXFT.DELIVE_DETAIL
  add constraint FK_DELIVE_DETAIL_NOTE foreign key (FDELIVE_NOTE_ID)
  references NXFT.DELIVE_NOTE (FDELIVE_NOTE_ID);

--prompt
--prompt Creating table D_CIRCLE_KITCHEN
--prompt ===============================
--prompt
create table NXFT.D_CIRCLE_KITCHEN
(
  FSIGN_ID           VARCHAR2(32) not null,
  FCIRCLE_ID         VARCHAR2(32) not null,
  FKITCHEN_CIRCLE_ID VARCHAR2(32) not null,
  FDELIVE_FEE        NUMBER(4,2) not null,
  FKITCHEN_DESC      VARCHAR2(256),
  FVERSION           NUMBER(6) default 0 not null,
  FLOGCBY            VARCHAR2(32) not null,
  FLOGCDATE          timestamp not null,
  FLOGLUBY           VARCHAR2(32) not null,
  FLOGLUDATE         timestamp not null,
  FLOGLABY           VARCHAR2(32) not null,
  FLOGLADATE         timestamp not null,
  FKITCHEN_TEAM_ID   VARCHAR2(32) not null
)
;
alter table NXFT.D_CIRCLE_KITCHEN
  add constraint PK_D_CIRCLE_KITCHEN primary key (FSIGN_ID);
alter table NXFT.D_CIRCLE_KITCHEN
  add constraint UK_D_CIRCLE_KITCHEN unique (FCIRCLE_ID, FKITCHEN_CIRCLE_ID);
alter table NXFT.D_CIRCLE_KITCHEN
  add constraint FK_D_CIRCLE_KITCHEN_CIRCLE foreign key (FCIRCLE_ID)
  references FXP.P_CIRCLE (FCIRCLE_ID);
alter table NXFT.D_CIRCLE_KITCHEN
  add constraint FK_D_CIRCLE_KITCHEN_KITCHEN foreign key (FKITCHEN_CIRCLE_ID)
  references FXP.P_CIRCLE (FCIRCLE_ID);
alter table NXFT.D_CIRCLE_KITCHEN
  add constraint FK_D_CIRCLE_KITCHEN_KTEAM foreign key (FKITCHEN_TEAM_ID)
  references FXP.P_TEAM (FTEAM_ID);

--prompt
--prompt Creating table D_FOOD_LOVE
--prompt ==========================
--prompt
create table NXFT.D_FOOD_LOVE
(
  FFOOD_LOVE_ID   VARCHAR2(32) not null,
  FFOOD_LOVE_CODE VARCHAR2(8) not null,
  FFOOD_LOVE_NAME VARCHAR2(40) not null,
  FISOTHER        CHAR(1) not null,
  FFOOD_LOVE_DESC VARCHAR2(256),
  FVERSION        NUMBER(6) default 0 not null,
  FLOGCBY         VARCHAR2(32) not null,
  FLOGCDATE       timestamp not null,
  FLOGLUBY        VARCHAR2(32) not null,
  FLOGLUDATE      timestamp not null,
  FLOGLABY        VARCHAR2(32) not null,
  FLOGLADATE      timestamp not null
)
;
alter table NXFT.D_FOOD_LOVE
  add constraint PK_D_FOOD_LOVE primary key (FFOOD_LOVE_ID);

--prompt
--prompt Creating table D_FOOD_PROHIBIT
--prompt ==============================
--prompt
create table NXFT.D_FOOD_PROHIBIT
(
  FFOOD_PROHIBIT_ID   VARCHAR2(32) not null,
  FFOOD_PROHIBIT_CODE VARCHAR2(8) not null,
  FFOOD_PROHIBIT_NAME VARCHAR2(40) not null,
  FISOTHER            CHAR(1) not null,
  FFOOD_PROHIBIT_DESC VARCHAR2(256),
  FVERSION            NUMBER(6) default 0 not null,
  FLOGCBY             VARCHAR2(32) not null,
  FLOGCDATE           timestamp not null,
  FLOGLUBY            VARCHAR2(32) not null,
  FLOGLUDATE          timestamp not null,
  FLOGLABY            VARCHAR2(32) not null,
  FLOGLADATE          timestamp not null
)
;
alter table NXFT.D_FOOD_PROHIBIT
  add constraint PK_D_FOOD_PROHIBIT primary key (FFOOD_PROHIBIT_ID);

--prompt
--prompt Creating table D_SUBJECT_TYPE
--prompt =============================
--prompt
create table NXFT.D_SUBJECT_TYPE
(
  FSUBJECT_TYPE_ID   VARCHAR2(32) not null,
  FSUBJECT_TYPE_CODE VARCHAR2(30) not null,
  FSUBJECT_TYPE_NAME VARCHAR2(40) not null,
  FISAVAILABLE       CHAR(1) not null,
  FSUBJECT_TYPE_DESC VARCHAR2(256),
  FVERSION           NUMBER(6) default 0 not null,
  FLOGCBY            VARCHAR2(32) not null,
  FLOGCDATE          timestamp not null,
  FLOGLUBY           VARCHAR2(32) not null,
  FLOGLUDATE         timestamp not null,
  FLOGLABY           VARCHAR2(32) not null,
  FLOGLADATE         timestamp not null
)
;
alter table NXFT.D_SUBJECT_TYPE
  add constraint PK_D_SUBJECT_TYPE primary key (FSUBJECT_TYPE_ID);
alter table NXFT.D_SUBJECT_TYPE
  add constraint UK_D_SUBJECT_TYPE_CODE unique (FSUBJECT_TYPE_CODE);

--prompt
--prompt Creating table D_SUBJECT_ASSISTANCE
--prompt ===================================
--prompt
create table NXFT.D_SUBJECT_ASSISTANCE
(
  FASSISTANCE_ID    VARCHAR2(32) not null,
  FCIRCLE_ID        VARCHAR2(32) not null,
  FSUBJECT_TYPE_ID  VARCHAR2(32) not null,
  FMEAL_TYPE_ID     VARCHAR2(32) not null,
  FASSISTANCE_MODEL VARCHAR2(30) not null,
  FASSISTANCE_RATIO NUMBER(3,2),
  FASSISTANCE_FEE   NUMBER(6,2),
  FASSISTANCE_DESC  VARCHAR2(256),
  FVERSION          NUMBER(6) default 0 not null,
  FLOGCBY           VARCHAR2(32) not null,
  FLOGCDATE         timestamp not null,
  FLOGLUBY          VARCHAR2(32) not null,
  FLOGLUDATE        timestamp not null,
  FLOGLABY          VARCHAR2(32) not null,
  FLOGLADATE        timestamp not null
)
;
alter table NXFT.D_SUBJECT_ASSISTANCE
  add constraint PK_D_SUBJECT_ASSISTANCE primary key (FASSISTANCE_ID);
alter table NXFT.D_SUBJECT_ASSISTANCE
  add constraint UK_D_SUBJECT_ASSISTANCE unique (FCIRCLE_ID, FSUBJECT_TYPE_ID, FMEAL_TYPE_ID);
alter table NXFT.D_SUBJECT_ASSISTANCE
  add constraint FK_D_SUBJECT_ASSISTANCE_CIRCLE foreign key (FCIRCLE_ID)
  references FXP.P_CIRCLE (FCIRCLE_ID);
alter table NXFT.D_SUBJECT_ASSISTANCE
  add constraint FK_D_SUBJECT_ASSISTANCE_MEAL foreign key (FMEAL_TYPE_ID)
  references NXFT.D_MEAL_TYPE (FMEAL_TYPE_ID);
alter table NXFT.D_SUBJECT_ASSISTANCE
  add constraint FK_D_SUBJECT_ASSISTANCE_TYPE foreign key (FSUBJECT_TYPE_ID)
  references NXFT.D_SUBJECT_TYPE (FSUBJECT_TYPE_ID);

--prompt
--prompt Creating table MEAL_DISEASE
--prompt ===========================
--prompt
create table NXFT.MEAL_DISEASE
(
  FPK_ID        VARCHAR2(32) not null,
  FDISEASE_ID   VARCHAR2(32) not null,
  FDISEASE_NAME VARCHAR2(40) not null,
  FMEAL_ID      VARCHAR2(32) not null,
  FDISEASE_DESC VARCHAR2(256),
  FVERSION      NUMBER(6) default 0 not null,
  FLOGCBY       VARCHAR2(32) not null,
  FLOGCDATE     timestamp not null,
  FLOGLUBY      VARCHAR2(32) not null,
  FLOGLUDATE    timestamp not null,
  FLOGLABY      VARCHAR2(32) not null,
  FLOGLADATE    timestamp not null
)
;
alter table NXFT.MEAL_DISEASE
  add constraint PK_MEAL_DISEASE primary key (FPK_ID);
alter table NXFT.MEAL_DISEASE
  add constraint UK_MEAL_DISEASE unique (FMEAL_ID, FDISEASE_ID);
alter table NXFT.MEAL_DISEASE
  add constraint FK_MEAL_DISEASE_DISEASE foreign key (FDISEASE_ID)
  references FXP.P_HBC_DISEASE (FDISEASE_ID);
alter table NXFT.MEAL_DISEASE
  add constraint FK_MEAL_DISEASE_MEAL foreign key (FMEAL_ID)
  references NXFT.MEAL_SET (FMEAL_ID);

--prompt
--prompt Creating table MEAL_SCHENOTE
--prompt ============================
--prompt
create table NXFT.MEAL_SCHENOTE
(
  FSCHENOTE_ID       VARCHAR2(32) not null,
  FSCHENOTE_DESC     VARCHAR2(256),
  FKITCHEN_CIRCLE_ID VARCHAR2(32) not null,
  FBEGIN_DATE        timestamp not null,
  FEND_DATE          timestamp not null,
  FPERIOD_MODEL      VARCHAR2(20) not null,
  FCREATE_TIME       timestamp not null,
  FCREATE_USER_ID    VARCHAR2(32) not null,
  FCREATE_NICKNAME   VARCHAR2(30) not null,
  FIS_PUBLISHED      CHAR(1) not null,
  FPUBLISH_TIME      timestamp,
  FPUBLISH_USER_ID   VARCHAR2(32),
  FPUBLISH_NICKNAME  VARCHAR2(30),
  FVERSION           NUMBER(6) default 0 not null,
  FLOGCBY            VARCHAR2(32) not null,
  FLOGCDATE          timestamp not null,
  FLOGLUBY           VARCHAR2(32) not null,
  FLOGLUDATE         timestamp not null,
  FLOGLABY           VARCHAR2(32) not null,
  FLOGLADATE         timestamp not null,
  FKITCHEN_TEAM_ID   VARCHAR2(32) not null
)
;
alter table NXFT.MEAL_SCHENOTE
  add constraint PK_MEAL_SCHENOTE primary key (FSCHENOTE_ID);
alter table NXFT.MEAL_SCHENOTE
  add constraint FK_MEAL_SCHENOTE_KITCHEN foreign key (FKITCHEN_CIRCLE_ID)
  references FXP.P_CIRCLE (FCIRCLE_ID);
alter table NXFT.MEAL_SCHENOTE
  add constraint FK_MEAL_SCHENOTE_KTEAM foreign key (FKITCHEN_TEAM_ID)
  references FXP.P_TEAM (FTEAM_ID);

--prompt
--prompt Creating table MEAL_SCHEDAY
--prompt ===========================
--prompt
create table NXFT.MEAL_SCHEDAY
(
  FSCHEDULE_ID       VARCHAR2(32) not null,
  FKITCHEN_CIRCLE_ID VARCHAR2(32) not null,
  FSCHENOTE_ID       VARCHAR2(32) not null,
  FMEAL_DATE         timestamp not null,
  FWEEK              NUMBER(1) not null,
  FMEAL_TYPE_ID      VARCHAR2(32) not null,
  FMEAL_TYPE_NAME    VARCHAR2(40) not null,
  FMEAL_ID           VARCHAR2(32) not null,
  FMEAL_CODE         VARCHAR2(30) not null,
  FMEAL_NAME         VARCHAR2(40) not null,
  FMEAL_CONTENT      VARCHAR2(60),
  FMEAL_PRICE        NUMBER(4,2) not null,
  FSCHEDULE_DESC     VARCHAR2(256),
  FIS_PUBLISHED      CHAR(1) not null,
  FVERSION           NUMBER(6) default 0 not null,
  FLOGCBY            VARCHAR2(32) not null,
  FLOGCDATE          timestamp not null,
  FLOGLUBY           VARCHAR2(32) not null,
  FLOGLUDATE         timestamp not null,
  FLOGLABY           VARCHAR2(32) not null,
  FLOGLADATE         timestamp not null,
  FKITCHEN_TEAM_ID   VARCHAR2(32) not null
)
;
alter table NXFT.MEAL_SCHEDAY
  add constraint PK_MEAL_SCHEDAY primary key (FSCHEDULE_ID);
alter table NXFT.MEAL_SCHEDAY
  add constraint UK_MEAL_SCHEDAY unique (FMEAL_DATE, FMEAL_TYPE_ID, FMEAL_ID);
alter table NXFT.MEAL_SCHEDAY
  add constraint FK_MEAL_SCHEDAY_KITCHEN foreign key (FKITCHEN_CIRCLE_ID)
  references FXP.P_CIRCLE (FCIRCLE_ID);
alter table NXFT.MEAL_SCHEDAY
  add constraint FK_MEAL_SCHEDAY_KTEAM foreign key (FKITCHEN_TEAM_ID)
  references FXP.P_TEAM (FTEAM_ID);
alter table NXFT.MEAL_SCHEDAY
  add constraint FK_MEAL_SCHEDAY_MEAL foreign key (FMEAL_ID)
  references NXFT.MEAL_SET (FMEAL_ID);
alter table NXFT.MEAL_SCHEDAY
  add constraint FK_MEAL_SCHEDAY_SCHENOTE foreign key (FSCHENOTE_ID)
  references NXFT.MEAL_SCHENOTE (FSCHENOTE_ID);

--prompt
--prompt Creating table NXFT_SUBJECT
--prompt ===========================
--prompt
create table NXFT.NXFT_SUBJECT
(
  FSUBJECT_ID             VARCHAR2(32) not null,
  FPERSON_ID              VARCHAR2(32) not null,
  FSUBJECT_NAME           VARCHAR2(80) not null,
  FSEX_ID                 VARCHAR2(32) not null,
  FSEX_NAME               VARCHAR2(30) not null,
  FIDTYPE_ID              VARCHAR2(32),
  FIDTYPE_NAME            VARCHAR2(30),
  FIDCARDNO               VARCHAR2(20) not null,
  FBIRTH_DATE             timestamp not null,
  FCONTACT_PHONE          VARCHAR2(30),
  FREGION_ID              VARCHAR2(32) not null,
  FREGION_NAME            VARCHAR2(80) not null,
  FADDRESS                VARCHAR2(200) not null,
  FIS_NATIVE              CHAR(1),
  FLIVING_CONDI_NAME      VARCHAR2(60),
  FCIRCLE_ID              VARCHAR2(32) not null,
  FRELATION_NAME          VARCHAR2(40),
  FFAMILY_RELATION_ID     VARCHAR2(32),
  FFAMILY_RELATION_NAME   VARCHAR2(30),
  FRELATION_PHONE         VARCHAR2(40),
  FIS_GOV_HELP            CHAR(1) default 'N',
  FGOV_HELP_ID            VARCHAR2(32),
  FGOV_HELP_NAME          VARCHAR2(30),
  FSUBJECT_DISEASE        VARCHAR2(100),
  FHAVE_FOOD_ALLERGY      CHAR(1) default 'N',
  FFOOD_ALLERGY           VARCHAR2(200),
  FSUBJECT_FOOD_PROHIBIT  VARCHAR2(100),
  FSUBJECT_TYPE_ID        VARCHAR2(32) not null,
  FSUBJECT_TYPE_NAME      VARCHAR2(30) not null,
  FSUBJECT_DESC           VARCHAR2(256),
  FDELIVE_TYPE            VARCHAR2(30) not null,
  FDELIVE_SITE_ID         VARCHAR2(32) not null,
  FDELIVE_SITE_NAME       VARCHAR2(40) not null,
  FOVERDRAFT              NUMBER(8,2) not null,
  FCREATE_TIME            timestamp not null,
  FCREATE_CIRCLE_ID       VARCHAR2(32) not null,
  FCREATE_TEAM_ID         VARCHAR2(32) not null,
  FCREATE_USER_ID         VARCHAR2(32) not null,
  FCREATE_NICKNAME        VARCHAR2(30) not null,
  FIS_CANCEL              CHAR(1) default 'N' not null,
  FCANCEL_REASON          VARCHAR2(60),
  FCANCEL_DATE            timestamp,
  FCANCEL_USER_ID         VARCHAR2(32),
  FCANCEL_USER_NAME       VARCHAR2(30),
  FVERSION                NUMBER(6) default 0 not null,
  FLOGCBY                 VARCHAR2(32) not null,
  FLOGCDATE               timestamp not null,
  FLOGLUBY                VARCHAR2(32) not null,
  FLOGLUDATE              timestamp not null,
  FLOGLABY                VARCHAR2(32) not null,
  FLOGLADATE              timestamp not null,
  FLUNCH_BOX_NO           VARCHAR2(20),
  FSUBJECT_FOOD_LOVE_ID   VARCHAR2(32),
  FSUBJECT_FOOD_LOVE_NAME VARCHAR2(30),
  FIS_MEAL_HELP           CHAR(1)
)
;
alter table NXFT.NXFT_SUBJECT
  add constraint PK_NXFT_SUBJECT primary key (FSUBJECT_ID);
alter table NXFT.NXFT_SUBJECT
  add constraint FK_NXFT_SUBJECT_CIRCLE foreign key (FCIRCLE_ID)
  references FXP.P_CIRCLE (FCIRCLE_ID);
alter table NXFT.NXFT_SUBJECT
  add constraint FK_NXFT_SUBJECT_PERSON foreign key (FPERSON_ID)
  references FXP.P_PERSON (FPERSON_ID);
alter table NXFT.NXFT_SUBJECT
  add constraint FK_NXFT_SUBJECT_TYPE foreign key (FSUBJECT_TYPE_ID)
  references NXFT.D_SUBJECT_TYPE (FSUBJECT_TYPE_ID);

--prompt
--prompt Creating table NXFT_ORDER
--prompt =========================
--prompt
create table NXFT.NXFT_ORDER
(
  FORDER_ID          VARCHAR2(32) not null,
  FSUBJECT_ID        VARCHAR2(32) not null,
  FSUBJECT_NAME      VARCHAR2(80) not null,
  FSEX_ID            VARCHAR2(32) not null,
  FSEX_NAME          VARCHAR2(30) not null,
  FCONTACT_PHONE     VARCHAR2(30) not null,
  FREGION_ID         VARCHAR2(32) not null,
  FREGION_NAME       VARCHAR2(80) not null,
  FADDRESS           VARCHAR2(200),
  FSUBJECT_TYPE_ID   VARCHAR2(32) not null,
  FSUBJECT_TYPE_NAME VARCHAR2(30) not null,
  FSUBJECT_DESC      VARCHAR2(256),
  FCIRCLE_ID         VARCHAR2(32) not null,
  FDELIVE_TYPE       VARCHAR2(30) not null,
  FDELIVE_SITE_ID    VARCHAR2(32) not null,
  FDELIVE_SITE_NAME  VARCHAR2(40) not null,
  FDELIVE_ADDR       VARCHAR2(100) not null,
  FDELIVE_FEE        NUMBER(4,2) not null,
  FKITCHEN_CIRCLE_ID VARCHAR2(32) not null,
  FMEAL_DATE         timestamp not null,
  FWEEK              NUMBER(1) not null,
  FMEAL_TYPE_ID      VARCHAR2(32) not null,
  FMEAL_TYPE_NAME    VARCHAR2(40) not null,
  FMEAL_ID           VARCHAR2(32) not null,
  FMEAL_CODE         VARCHAR2(30) not null,
  FMEAL_NAME         VARCHAR2(40) not null,
  FMEAL_CONTENT      VARCHAR2(60),
  FMEAL_PRICE        NUMBER(4,2) not null,
  FSCHEDULE_DESC     VARCHAR2(256),
  FQUANTITY          NUMBER(6) not null,
  FSUM_TOTAL         NUMBER(10,2) not null,
  FSUM_PAYMENT       NUMBER(10,2) not null,
  FSUM_RECEIVABLE    NUMBER(10,2) not null,
  FDELIVE_NOTE_ID    VARCHAR2(32),
  FCREATE_TIME       timestamp not null,
  FCREATE_USER_ID    VARCHAR2(32) not null,
  FCREATE_USER_NAME  VARCHAR2(50) not null,
  FLAST_STATE        VARCHAR2(30) not null,
  FLAST_TIME         timestamp not null,
  FLAST_USER_ID      VARCHAR2(32) not null,
  FLAST_NICKNAME     VARCHAR2(40) not null,
  FLAST_DESC         VARCHAR2(256),
  FNEXT_NODE_ID      VARCHAR2(30),
  FNEXT_NODE_CONTENT VARCHAR2(300),
  FIS_COMPLETE       CHAR(1) not null,
  FCOMPLETE_STATE    VARCHAR2(30),
  FFAIL_REASON_NAME  VARCHAR2(50),
  FCOMPLETE_TIME     timestamp,
  FCOMPLETE_USER_ID  VARCHAR2(32),
  FCOMPLETE_NICKNAME VARCHAR2(30),
  FCOMPLETE_DESC     VARCHAR2(256),
  FVERSION           NUMBER(6) default 0 not null,
  FLOGCBY            VARCHAR2(32) not null,
  FLOGCDATE          timestamp not null,
  FLOGLUBY           VARCHAR2(32) not null,
  FLOGLUDATE         timestamp not null,
  FLOGLABY           VARCHAR2(32) not null,
  FLOGLADATE         timestamp not null,
  FKITCHEN_TEAM_ID   VARCHAR2(32) not null,
  FLUNCH_BOX_NO      VARCHAR2(20),
  FCREATE_WAY        VARCHAR2(20) not null
)
;
alter table NXFT.NXFT_ORDER
  add constraint PK_NXFT_ORDER primary key (FORDER_ID);
alter table NXFT.NXFT_ORDER
  add constraint FK_NXFT_ORDER_CIRCLE foreign key (FCIRCLE_ID)
  references FXP.P_CIRCLE (FCIRCLE_ID);
alter table NXFT.NXFT_ORDER
  add constraint FK_NXFT_ORDER_KITCHEN foreign key (FKITCHEN_CIRCLE_ID)
  references FXP.P_CIRCLE (FCIRCLE_ID);
alter table NXFT.NXFT_ORDER
  add constraint FK_NXFT_ORDER_KTEAM foreign key (FKITCHEN_TEAM_ID)
  references FXP.P_TEAM (FTEAM_ID);
alter table NXFT.NXFT_ORDER
  add constraint FK_NXFT_ORDER_MEAL foreign key (FMEAL_ID)
  references NXFT.MEAL_SET (FMEAL_ID);
alter table NXFT.NXFT_ORDER
  add constraint FK_NXFT_ORDER_SUBJECT foreign key (FSUBJECT_ID)
  references NXFT.NXFT_SUBJECT (FSUBJECT_ID);

--prompt
--prompt Creating table NXFT_SUBJECT_DISEASE
--prompt ===================================
--prompt
create table NXFT.NXFT_SUBJECT_DISEASE
(
  FPK_ID        VARCHAR2(32) not null,
  FDISEASE_ID   VARCHAR2(32) not null,
  FDISEASE_NAME VARCHAR2(40) not null,
  FSUBJECT_ID   VARCHAR2(32) not null,
  FDISEASE_DESC VARCHAR2(256),
  FVERSION      NUMBER(6) default 0 not null,
  FLOGCBY       VARCHAR2(32) not null,
  FLOGCDATE     timestamp not null,
  FLOGLUBY      VARCHAR2(32) not null,
  FLOGLUDATE    timestamp not null,
  FLOGLABY      VARCHAR2(32) not null,
  FLOGLADATE    timestamp not null
)
;
alter table NXFT.NXFT_SUBJECT_DISEASE
  add constraint PK_NXFT_SUBJECT_DISEASE primary key (FPK_ID);
alter table NXFT.NXFT_SUBJECT_DISEASE
  add constraint UK_NXFT_SUBJECT_DISEASE unique (FSUBJECT_ID, FDISEASE_ID);
alter table NXFT.NXFT_SUBJECT_DISEASE
  add constraint FK_NXFT_SUBJECT_DISEASE_DIS foreign key (FDISEASE_ID)
  references FXP.P_HBC_DISEASE (FDISEASE_ID);
alter table NXFT.NXFT_SUBJECT_DISEASE
  add constraint FK_NXFT_SUBJECT_DISEASE_SUB foreign key (FSUBJECT_ID)
  references NXFT.NXFT_SUBJECT (FSUBJECT_ID);

--prompt
--prompt Creating table NXFT_SUBJECT_FOOD_PROHIBIT
--prompt =========================================
--prompt
create table NXFT.NXFT_SUBJECT_FOOD_PROHIBIT
(
  FPK_ID              VARCHAR2(32) not null,
  FFOOD_PROHIBIT_ID   VARCHAR2(32) not null,
  FFOOD_PROHIBIT_NAME VARCHAR2(40) not null,
  FISOTHER            CHAR(1) not null,
  FSUBJECT_ID         VARCHAR2(32) not null,
  FFOOD_PROHIBIT_DESC VARCHAR2(256),
  FVERSION            NUMBER(6) default 0 not null,
  FLOGCBY             VARCHAR2(32) not null,
  FLOGCDATE           timestamp not null,
  FLOGLUBY            VARCHAR2(32) not null,
  FLOGLUDATE          timestamp not null,
  FLOGLABY            VARCHAR2(32) not null,
  FLOGLADATE          timestamp not null
)
;
alter table NXFT.NXFT_SUBJECT_FOOD_PROHIBIT
  add constraint PK_NXFT_SUBJECT_FOOD_PROHIBIT primary key (FPK_ID);
alter table NXFT.NXFT_SUBJECT_FOOD_PROHIBIT
  add constraint UK_NXFT_SUBJECT_FOOD_PROHIBIT unique (FSUBJECT_ID, FFOOD_PROHIBIT_ID);
alter table NXFT.NXFT_SUBJECT_FOOD_PROHIBIT
  add constraint FK_NXFT_SUBJECT_FOOD_PROHIBIT foreign key (FFOOD_PROHIBIT_ID)
  references NXFT.D_FOOD_PROHIBIT (FFOOD_PROHIBIT_ID);
alter table NXFT.NXFT_SUBJECT_FOOD_PROHIBIT
  add constraint FK_NXFT_SUBJECT_FOOD_SUB foreign key (FSUBJECT_ID)
  references NXFT.NXFT_SUBJECT (FSUBJECT_ID);

--prompt
--prompt Creating table NXFT_SUBJECT_LIVING_CONDI
--prompt ========================================
--prompt
create table NXFT.NXFT_SUBJECT_LIVING_CONDI
(
  FPK_ID             VARCHAR2(32) not null,
  FLIVING_CONDI_ID   VARCHAR2(32) not null,
  FLIVING_CONDI_NAME VARCHAR2(40) not null,
  FISOTHER           CHAR(1) not null,
  FSUBJECT_ID        VARCHAR2(32) not null,
  FLIVING_CONDI_DESC VARCHAR2(256),
  FVERSION           NUMBER(6) default 0 not null,
  FLOGCBY            VARCHAR2(32) not null,
  FLOGCDATE          timestamp not null,
  FLOGLUBY           VARCHAR2(32) not null,
  FLOGLUDATE         timestamp not null,
  FLOGLABY           VARCHAR2(32) not null,
  FLOGLADATE         timestamp not null
)
;
alter table NXFT.NXFT_SUBJECT_LIVING_CONDI
  add constraint PK_NXFT_SUBJECT_LIVING_CONDI primary key (FPK_ID);
alter table NXFT.NXFT_SUBJECT_LIVING_CONDI
  add constraint UK_NXFT_SUBJECT_LIVING_CONDI unique (FSUBJECT_ID, FLIVING_CONDI_ID);
alter table NXFT.NXFT_SUBJECT_LIVING_CONDI
  add constraint FK_NXFT_SUBJECT_LIVING_LIVING foreign key (FLIVING_CONDI_ID)
  references FXP.P_LIVING_CONDI (FLIVING_CONDI_ID);
alter table NXFT.NXFT_SUBJECT_LIVING_CONDI
  add constraint FK_NXFT_SUBJECT_LIVING_SUB foreign key (FSUBJECT_ID)
  references NXFT.NXFT_SUBJECT (FSUBJECT_ID);

--prompt
--prompt Creating table NXFT_SUBJECT_SMS_LOG
--prompt ===================================
--prompt
create table NXFT.NXFT_SUBJECT_SMS_LOG
(
  FSMS_ID         VARCHAR2(32) not null,
  FTSP_NAME       VARCHAR2(30) not null,
  FSUBJECT_ID     VARCHAR2(32) not null,
  FSUBJECT_NAME   VARCHAR2(50) not null,
  FCIRCLE_ID      VARCHAR2(32) not null,
  FCREATE_TIME    timestamp not null,
  FSMS_CONTENT    VARCHAR2(1000) not null,
  FSMS_TYPE       VARCHAR2(32) not null,
  FSMS_DESC       VARCHAR2(256),
  FTO_NUMBER      VARCHAR2(20) not null,
  FTO_NAME        VARCHAR2(40) not null,
  FRELATION_NAME  VARCHAR2(30),
  FUSER_CIRCLE_ID VARCHAR2(32),
  FUSER_TEAM_ID   VARCHAR2(32),
  FUSER_USER_ID   VARCHAR2(32) not null,
  FUSER_NICKNAME  VARCHAR2(40) not null,
  FVERSION        NUMBER(6) default 0 not null
)
;
alter table NXFT.NXFT_SUBJECT_SMS_LOG
  add constraint PK_NXFT_SUBJECT_SMS_LOG primary key (FSMS_ID);
alter table NXFT.NXFT_SUBJECT_SMS_LOG
  add constraint FK_NXFT_SUBJECT_SMS_LOG_SUB foreign key (FSUBJECT_ID)
  references NXFT.NXFT_SUBJECT (FSUBJECT_ID);
create index NXFT.IDX_NXFT_SUBJECT_SMS_LOG1 on NXFT.NXFT_SUBJECT_SMS_LOG (FCREATE_TIME);
create index NXFT.IDX_NXFT_SUBJECT_SMS_LOG2 on NXFT.NXFT_SUBJECT_SMS_LOG (FSUBJECT_ID);

--prompt
--prompt Creating table SIS_SERVICE_RESOURCE
--prompt ===================================
--prompt
create table NXFT.SIS_SERVICE_RESOURCE
(
  FSIS_ID         VARCHAR2(32) not null,
  FCIRCLE_ID      VARCHAR2(32) not null,
  FINDICATOR_ID   VARCHAR2(32) not null,
  FINDICATOR_NAME VARCHAR2(60) not null,
  FQUANTITY       NUMBER(9) not null,
  FDATA_DESC      VARCHAR2(256),
  FVERSION        NUMBER(6) default 0 not null,
  FLOGCBY         VARCHAR2(32) not null,
  FLOGCDATE       timestamp not null,
  FLOGLUBY        VARCHAR2(32) not null,
  FLOGLUDATE      timestamp not null,
  FLOGLABY        VARCHAR2(32) not null,
  FLOGLADATE      timestamp not null
)
;
alter table NXFT.SIS_SERVICE_RESOURCE
  add constraint PK_SIS_SERVICE_RESOURCE primary key (FSIS_ID);
alter table NXFT.SIS_SERVICE_RESOURCE
  add constraint UK_SIS_SERVICE_RESOURCE unique (FCIRCLE_ID, FINDICATOR_ID);
alter table NXFT.SIS_SERVICE_RESOURCE
  add constraint FK_SIS_SERVICE_RESOURCE_CIRCLE foreign key (FCIRCLE_ID)
  references FXP.P_CIRCLE (FCIRCLE_ID);

  
-- spool off