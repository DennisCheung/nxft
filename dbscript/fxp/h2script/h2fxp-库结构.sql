drop schema if exists fxp;
create schema fxp;

--prompt
--prompt Creating table P_USER
--prompt =====================
--prompt
create table FXP.P_USER
(
  FUSER_ID      VARCHAR2(50) not null,
  FPASSWORD     VARCHAR2(50),
  FNICKNAME     VARCHAR2(50) not null,
  FSEX_ID       VARCHAR2(32),
  FSEX_NAME     VARCHAR2(10),
  FPHOTO_ID     VARCHAR2(32),
  FSIGNATURE_ID VARCHAR2(32),
  FUSER_DESC    VARCHAR2(256),
  FVERSION      NUMBER(6) default 0 not null,
  FLOGCBY       VARCHAR2(32) not null,
  FLOGCDATE     timestamp default sysdate not null,
  FLOGLUBY      VARCHAR2(32) not null,
  FLOGLUDATE    timestamp default sysdate not null,
  FLOGLABY      VARCHAR2(32) not null,
  FLOGLADATE    timestamp default sysdate not null,
  FMOBILE       VARCHAR2(20)
)
;
alter table FXP.P_USER
  add constraint PK_P_USER primary key (FUSER_ID);
alter table FXP.P_USER
  add constraint UK_P_USER_FMOBILE unique (FMOBILE);

--prompt
--prompt Creating table P_BOSS
--prompt =====================
--prompt
create table FXP.P_BOSS
(
  FBOSS_ID          VARCHAR2(32) not null,
  FBOSS_NAME        VARCHAR2(60) not null,
  FADMIN_USER_ID    VARCHAR2(32) not null,
  FBOSS_DESC        VARCHAR2(256),
  FCREATE_TIME      timestamp default sysdate not null,
  FCREATE_USER_ID   VARCHAR2(32) not null,
  FCREATE_USER_NAME VARCHAR2(50) not null,
  FVERSION          NUMBER(6) default 0 not null,
  FLOGCBY           VARCHAR2(32) not null,
  FLOGCDATE         timestamp not null,
  FLOGLUBY          VARCHAR2(32) not null,
  FLOGLUDATE        timestamp not null,
  FLOGLABY          VARCHAR2(32) not null,
  FLOGLADATE        timestamp not null
)
;
alter table FXP.P_BOSS
  add constraint PK_P_BOSS primary key (FBOSS_ID);
alter table FXP.P_BOSS
  add constraint UK_P_BOSS_ADMIN unique (FADMIN_USER_ID);
alter table FXP.P_BOSS
  add constraint FK_P_BOSS_USER foreign key (FADMIN_USER_ID)
  references FXP.P_USER (FUSER_ID);

--prompt
--prompt Creating table P_CIRCLE
--prompt =======================
--prompt
create table FXP.P_CIRCLE
(
  FCIRCLE_ID         VARCHAR2(32) not null,
  FCIRCLE_NAME       VARCHAR2(100) not null,
  FCIRCLE_SHORT_NAME VARCHAR2(100) not null,
  FLOGO_ID           VARCHAR2(32),
  FISAVAILABLE       CHAR(1) not null,
  FBOSS_ID           VARCHAR2(32) not null,
  FCIRCLE_DESC       VARCHAR2(256),
  FCREATE_TIME       timestamp default sysdate not null,
  FCREATE_USER_ID    VARCHAR2(32) not null,
  FCREATE_USER_NAME  VARCHAR2(50) not null,
  FVERSION           NUMBER(6) default 0 not null,
  FLOGCBY            VARCHAR2(32) not null,
  FLOGCDATE          timestamp not null,
  FLOGLUBY           VARCHAR2(32) not null,
  FLOGLUDATE         timestamp not null,
  FLOGLABY           VARCHAR2(32) not null,
  FLOGLADATE         timestamp not null
)
;
alter table FXP.P_CIRCLE
  add constraint PK_P_CIRCLE primary key (FCIRCLE_ID);
alter table FXP.P_CIRCLE
  add constraint FK_P_CIRCLE_BOSS foreign key (FBOSS_ID)
  references FXP.P_BOSS (FBOSS_ID);

--prompt
--prompt Creating table P_APPLICATION
--prompt ============================
--prompt
create table FXP.P_APPLICATION
(
  FAPPLICATION_ID        VARCHAR2(32) not null,
  FAPPLICATION_NAME      VARCHAR2(60) not null,
  FAPPLICATION_MAIN_URL  VARCHAR2(300) not null,
  FAPPLICATION_ADMIN_URL VARCHAR2(300) not null,
  FAPPLICATION_DESC      VARCHAR2(256),
  FCREATE_TIME           timestamp not null,
  FCREATE_USER_ID        VARCHAR2(32) not null,
  FCREATE_USER_NAME      VARCHAR2(50) not null,
  FVERSION               NUMBER(6) not null,
  FLOGCBY                VARCHAR2(32) not null,
  FLOGCDATE              timestamp not null,
  FLOGLUBY               VARCHAR2(32) not null,
  FLOGLUDATE             timestamp not null,
  FLOGLABY               VARCHAR2(32) not null,
  FLOGLADATE             timestamp not null
)
;
alter table FXP.P_APPLICATION
  add constraint PK_P_APPLICATION primary key (FAPPLICATION_ID);

--prompt
--prompt Creating table P_TEAM
--prompt =====================
--prompt
create table FXP.P_TEAM
(
  FTEAM_ID          VARCHAR2(32) not null,
  FTEAM_NAME        VARCHAR2(100) not null,
  FAPPLICATION_ID   VARCHAR2(32) not null,
  FCIRCLE_ID        VARCHAR2(32) not null,
  FISAVAILABLE      CHAR(1) not null,
  FTEAM_DESC        VARCHAR2(256),
  FCREATE_TIME      timestamp default sysdate not null,
  FCREATE_USER_ID   VARCHAR2(32) not null,
  FCREATE_USER_NAME VARCHAR2(50) not null,
  FVERSION          NUMBER(6) default 0 not null,
  FLOGCBY           VARCHAR2(32) not null,
  FLOGCDATE         timestamp not null,
  FLOGLUBY          VARCHAR2(32) not null,
  FLOGLUDATE        timestamp not null,
  FLOGLABY          VARCHAR2(32) not null,
  FLOGLADATE        timestamp not null,
  FREGION_ID        VARCHAR2(32),
  FREGION_NAME      VARCHAR2(80),
  FADDRESS          VARCHAR2(200),
  FCONTACT_PERSON   VARCHAR2(30),
  FCONTACT_MOBILE   VARCHAR2(30)
)
;
alter table FXP.P_TEAM
  add constraint PK_P_TEAM primary key (FTEAM_ID);
alter table FXP.P_TEAM
  add constraint UK_P_TEAM_CIRCLE unique (FTEAM_ID, FCIRCLE_ID);
alter table FXP.P_TEAM
  add constraint FK_P_TEAM_APP foreign key (FAPPLICATION_ID)
  references FXP.P_APPLICATION (FAPPLICATION_ID);
alter table FXP.P_TEAM
  add constraint FK_P_TEAM_CIRCLE foreign key (FCIRCLE_ID)
  references FXP.P_CIRCLE (FCIRCLE_ID);

--prompt
--prompt Creating table INVITE_JOIN_TEAM
--prompt ===============================
--prompt
create table FXP.INVITE_JOIN_TEAM
(
  FINVITE_ID        VARCHAR2(32) not null,
  FTEAM_ID          VARCHAR2(32) not null,
  FUSER_ID          VARCHAR2(32) not null,
  FCIRCLE_ID        VARCHAR2(32) not null,
  FINVITE_DESC      VARCHAR2(256),
  FCREATE_TIME      timestamp default sysdate not null,
  FCREATE_USER_ID   VARCHAR2(32) not null,
  FCREATE_USER_NAME VARCHAR2(50) not null,
  FVERSION          NUMBER(6) default 0 not null,
  FLOGCBY           VARCHAR2(32) not null,
  FLOGCDATE         timestamp not null,
  FLOGLUBY          VARCHAR2(32) not null,
  FLOGLUDATE        timestamp not null,
  FLOGLABY          VARCHAR2(32) not null,
  FLOGLADATE        timestamp not null
)
;
alter table FXP.INVITE_JOIN_TEAM
  add constraint PK_INVITE_JOIN_TEAM primary key (FINVITE_ID);
alter table FXP.INVITE_JOIN_TEAM
  add constraint UK_INVITE_JOIN_TEAM_USER unique (FTEAM_ID, FUSER_ID);
alter table FXP.INVITE_JOIN_TEAM
  add constraint FK_INVITE_JOIN_TEAM_CIRCLE foreign key (FCIRCLE_ID)
  references FXP.P_CIRCLE (FCIRCLE_ID);
alter table FXP.INVITE_JOIN_TEAM
  add constraint FK_INVITE_JOIN_TEAM_TEAM foreign key (FTEAM_ID, FCIRCLE_ID)
  references FXP.P_TEAM (FTEAM_ID, FCIRCLE_ID);
alter table FXP.INVITE_JOIN_TEAM
  add constraint FK_INVITE_JOIN_TEAM_TEAM1 foreign key (FTEAM_ID)
  references FXP.P_TEAM (FTEAM_ID);
alter table FXP.INVITE_JOIN_TEAM
  add constraint FK_INVITE_JOIN_TEAM_USER foreign key (FUSER_ID)
  references FXP.P_USER (FUSER_ID);

--prompt
--prompt Creating table P_ACCOUNT
--prompt ========================
--prompt
create table FXP.P_ACCOUNT
(
  FACCOUNT_ID   VARCHAR2(32) not null,
  FACCOUNT_NAME VARCHAR2(50) not null,
  FBALANCE_CASH NUMBER(12,2) default 0 not null,
  FVERSION      NUMBER(6) default 0 not null,
  FLOGCBY       VARCHAR2(32) not null,
  FLOGCDATE     timestamp not null,
  FLOGLUBY      VARCHAR2(32) not null,
  FLOGLUDATE    timestamp not null,
  FLOGLABY      VARCHAR2(32) not null,
  FLOGLADATE    timestamp not null
)
;
alter table FXP.P_ACCOUNT
  add constraint PK_P_ACCOUNT primary key (FACCOUNT_ID);

--prompt
--prompt Creating table P_ACCOUNT_LIST
--prompt =============================
--prompt
create table FXP.P_ACCOUNT_LIST
(
  FLIST_ID               VARCHAR2(32) not null,
  FACCOUNT_ID            VARCHAR2(32) not null,
  FLIST_TYPE             VARCHAR2(30) not null,
  FLIST_AMOUNT           NUMBER(12,2) not null,
  FLIST_SUMMARY          VARCHAR2(50) not null,
  FORDER_ID              VARCHAR2(32),
  FLIST_DESC             VARCHAR2(256),
  FCREATE_TIME           timestamp default sysdate not null,
  FCREATE_APPLICATION_ID VARCHAR2(32) not null,
  FCREATE_USER_ID        VARCHAR2(32) not null,
  FCREATE_USER_NAME      VARCHAR2(50) not null,
  FVERSION               NUMBER(6) default 0 not null,
  FLOGCBY                VARCHAR2(32) not null,
  FLOGCDATE              timestamp not null,
  FLOGLUBY               VARCHAR2(32) not null,
  FLOGLUDATE             timestamp not null,
  FLOGLABY               VARCHAR2(32) not null,
  FLOGLADATE             timestamp not null
)
;
alter table FXP.P_ACCOUNT_LIST
  add constraint PK_P_ACCOUNT_LIST primary key (FLIST_ID);
alter table FXP.P_ACCOUNT_LIST
  add constraint FK_P_ACCOUNT_LIST_ACCOUNT foreign key (FACCOUNT_ID)
  references FXP.P_ACCOUNT (FACCOUNT_ID);
create index FXP.IDX_P_ACCOUNT_LIST_ACCOUNT on FXP.P_ACCOUNT_LIST (FACCOUNT_ID);
create index FXP.IDX_P_ACCOUNT_LIST_TIME on FXP.P_ACCOUNT_LIST (FCREATE_TIME);

--prompt
--prompt Creating table P_ACCOUNT_PERSON
--prompt ===============================
--prompt
create table FXP.P_ACCOUNT_PERSON
(
  FACCOUNT_ID VARCHAR2(32) not null,
  FPERSON_ID  VARCHAR2(32) not null,
  FVERSION    NUMBER(6) default 0 not null,
  FLOGCBY     VARCHAR2(32) not null,
  FLOGCDATE   timestamp not null,
  FLOGLUBY    VARCHAR2(32) not null,
  FLOGLUDATE  timestamp not null,
  FLOGLABY    VARCHAR2(32) not null,
  FLOGLADATE  timestamp not null
)
;
alter table FXP.P_ACCOUNT_PERSON
  add constraint PK_P_ACCOUNT_PERSON primary key (FACCOUNT_ID);
alter table FXP.P_ACCOUNT_PERSON
  add constraint UK_P_ACCOUNT_PERSON unique (FPERSON_ID);

--prompt
--prompt Creating table P_ACCOUNT_USER
--prompt =============================
--prompt
create table FXP.P_ACCOUNT_USER
(
  FACCOUNT_ID VARCHAR2(32) not null,
  FUSER_ID    VARCHAR2(32) not null,
  FVERSION    NUMBER(6) default 0 not null,
  FLOGCBY     VARCHAR2(32) not null,
  FLOGCDATE   timestamp not null,
  FLOGLUBY    VARCHAR2(32) not null,
  FLOGLUDATE  timestamp not null,
  FLOGLABY    VARCHAR2(32) not null,
  FLOGLADATE  timestamp not null
)
;
alter table FXP.P_ACCOUNT_USER
  add constraint PK_P_ACCOUNT_USER primary key (FACCOUNT_ID);
alter table FXP.P_ACCOUNT_USER
  add constraint UK_P_ACCOUNT_USER unique (FUSER_ID);
alter table FXP.P_ACCOUNT_USER
  add constraint FK_P_ACCOUNT_USER_ACCOUNT foreign key (FACCOUNT_ID)
  references FXP.P_ACCOUNT (FACCOUNT_ID);
alter table FXP.P_ACCOUNT_USER
  add constraint FK_P_ACCOUNT_USER_USER foreign key (FUSER_ID)
  references FXP.P_USER (FUSER_ID);

--prompt
--prompt Creating table P_ACTIVITY_CROWDS
--prompt ================================
--prompt
create table FXP.P_ACTIVITY_CROWDS
(
  FCROWDS_ID       VARCHAR2(32) not null,
  FCROWDS_NAME     VARCHAR2(100) not null,
  FCROWDS_DESC     VARCHAR2(256),
  FACTIVITY_ID     VARCHAR2(32) not null,
  FOPERATOR_ID     VARCHAR2(32) not null,
  FCREATE_DATE     timestamp not null,
  FCREATE_USER_ID  VARCHAR2(32) not null,
  FCREATE_NICKNAME VARCHAR2(30) not null,
  FVERSION         NUMBER(6) default 0 not null,
  FLOGCBY          VARCHAR2(32) not null,
  FLOGCDATE        timestamp not null,
  FLOGLUBY         VARCHAR2(32) not null,
  FLOGLUDATE       timestamp not null,
  FLOGLABY         VARCHAR2(32) not null,
  FLOGLADATE       timestamp not null
)
;
alter table FXP.P_ACTIVITY_CROWDS
  add constraint PK_P_ACTIVITY_CROWDS primary key (FCROWDS_ID);

--prompt
--prompt Creating table P_BILL_TYPE
--prompt ==========================
--prompt
create table FXP.P_BILL_TYPE
(
  FBILL_TYPE_ID   VARCHAR2(32) not null,
  FBILL_TYPE_CODE VARCHAR2(30) not null,
  FBILL_TYPE_NAME VARCHAR2(40) not null,
  FBILL_CLASS     VARCHAR2(30) not null,
  FISAVAILABLE    CHAR(1) not null,
  FBILL_TYPE_DESC VARCHAR2(256),
  FVERSION        NUMBER(6) default 0 not null,
  FLOGCBY         VARCHAR2(32) default 'admin' not null,
  FLOGCDATE       timestamp default sysdate not null,
  FLOGLUBY        VARCHAR2(32) default 'admin' not null,
  FLOGLUDATE      timestamp default sysdate not null,
  FLOGLABY        VARCHAR2(32) default 'admin' not null,
  FLOGLADATE      timestamp default sysdate not null
)
;
alter table FXP.P_BILL_TYPE
  add constraint PK_P_BILL_TYPE primary key (FBILL_TYPE_ID);
alter table FXP.P_BILL_TYPE
  add constraint UK_P_BILL_TYPE_CODE unique (FBILL_TYPE_CODE);

--prompt
--prompt Creating table P_BLOOD_TYPE
--prompt ===========================
--prompt
create table FXP.P_BLOOD_TYPE
(
  FBLOOD_TYPE_ID     VARCHAR2(32) not null,
  FBLOOD_TYPE_CODE   VARCHAR2(8) not null,
  FBLOOD_TYPE_GBCODE VARCHAR2(32),
  FBLOOD_TYPE_NAME   VARCHAR2(40) not null,
  FISAVAILABLE       CHAR(1) not null,
  FORDERNUM          NUMBER(6,2) not null,
  FBLOOD_TYPE_DESC   VARCHAR2(256),
  FVERSION           NUMBER(6) default 0 not null,
  FLOGCBY            VARCHAR2(32) not null,
  FLOGCDATE          timestamp default sysdate not null,
  FLOGLUBY           VARCHAR2(32) not null,
  FLOGLUDATE         timestamp default sysdate not null,
  FLOGLABY           VARCHAR2(32) not null,
  FLOGLADATE         timestamp default sysdate not null
)
;
alter table FXP.P_BLOOD_TYPE
  add constraint PK_P_BLOOD_TYPE primary key (FBLOOD_TYPE_ID);
alter table FXP.P_BLOOD_TYPE
  add constraint UK_P_BLOOD_TYPE_CODE unique (FBLOOD_TYPE_CODE);

--prompt
--prompt Creating table P_BS_CIRCLE_LOGO
--prompt ===============================
--prompt
create table FXP.P_BS_CIRCLE_LOGO
(
  FBUSINESS_CIRCLE_ID VARCHAR2(32) not null,
  FLOGO               BLOB not null,
  FLOGO_TYPE          VARCHAR2(8) not null,
  FLOGO_SIZE          NUMBER(8) not null,
  FLOGO_DATE          timestamp not null,
  FVERSION            NUMBER(6) not null
)
;
alter table FXP.P_BS_CIRCLE_LOGO
  add constraint PK_P_BS_CIRCLE_LOGO primary key (FBUSINESS_CIRCLE_ID);

--prompt
--prompt Creating table P_BUSINESS
--prompt =========================
--prompt
create table FXP.P_BUSINESS
(
  FBUSINESS_ID   VARCHAR2(32) not null,
  FBUSINESS_NAME VARCHAR2(60) not null,
  FISAVAILABLE   CHAR(1) not null,
  FBUSINESS_DESC VARCHAR2(256),
  FVERSION       NUMBER(6) default 0 not null,
  FLOGCBY        VARCHAR2(32) not null,
  FLOGCDATE      timestamp not null,
  FLOGLUBY       VARCHAR2(32) not null,
  FLOGLUDATE     timestamp not null,
  FLOGLABY       VARCHAR2(32) not null,
  FLOGLADATE     timestamp not null
)
;
alter table FXP.P_BUSINESS
  add constraint PK_P_BUSINESS primary key (FBUSINESS_ID);

--prompt
--prompt Creating table P_BUSINESS_CIRCLE
--prompt ================================
--prompt
create table FXP.P_BUSINESS_CIRCLE
(
  FBUSINESS_CIRCLE_ID   VARCHAR2(32) not null,
  FBUSINESS_CIRCLE_NAME VARCHAR2(60) not null,
  FBUSINESS_CIRCLE_INFO VARCHAR2(300),
  FOPERATOR_ID          VARCHAR2(32) not null,
  FCALL_CENTER_ID       VARCHAR2(32) not null,
  FCIRCLE_DESC          VARCHAR2(256),
  FCREATE_DATE          timestamp default sysdate not null,
  FCREATE_USER_ID       VARCHAR2(32) not null,
  FCREATE_USER_NAME     VARCHAR2(50) not null,
  FVERSION              NUMBER(6) default 0 not null,
  FLOGCBY               VARCHAR2(32) not null,
  FLOGCDATE             timestamp not null,
  FLOGLUBY              VARCHAR2(32) not null,
  FLOGLUDATE            timestamp not null,
  FLOGLABY              VARCHAR2(32) not null,
  FLOGLADATE            timestamp not null
)
;
alter table FXP.P_BUSINESS_CIRCLE
  add constraint PK_P_BUSINESS_CIRCLE primary key (FBUSINESS_CIRCLE_ID);

--prompt
--prompt Creating table P_BUSSINESS_APP
--prompt ==============================
--prompt
create table FXP.P_BUSSINESS_APP
(
  FSET_ID         VARCHAR2(32) not null,
  FBUSINESS_ID    VARCHAR2(32) not null,
  FAPPLICATION_ID VARCHAR2(32) not null,
  FSET_DESC       VARCHAR2(256),
  FVERSION        NUMBER(6) default 0 not null,
  FLOGCBY         VARCHAR2(32) not null,
  FLOGCDATE       timestamp not null,
  FLOGLUBY        VARCHAR2(32) not null,
  FLOGLUDATE      timestamp not null,
  FLOGLABY        VARCHAR2(32) not null,
  FLOGLADATE      timestamp not null
)
;
alter table FXP.P_BUSSINESS_APP
  add constraint PK_P_BUSSINESS_APP primary key (FSET_ID);
alter table FXP.P_BUSSINESS_APP
  add constraint UK_P_BUSSINESS_APP unique (FBUSINESS_ID, FAPPLICATION_ID);
alter table FXP.P_BUSSINESS_APP
  add constraint FK_P_BUSSINESS_APP_BUSSINESS foreign key (FBUSINESS_ID)
  references FXP.P_BUSINESS (FBUSINESS_ID);

--prompt
--prompt Creating table P_CHGNOTE
--prompt ========================
--prompt
create table FXP.P_CHGNOTE
(
  FCHGNOTE_ID       VARCHAR2(32) not null,
  FCHGNOTE_NO       VARCHAR2(30) not null,
  FCHGNOTE_TYPE     VARCHAR2(32) not null,
  FCREATE_SUBSYS_ID VARCHAR2(32) not null,
  FCREATE_DATE      timestamp not null,
  FCREATE_ORG_ID    VARCHAR2(32) not null,
  FCREATE_SITE_ID   VARCHAR2(32) not null,
  FCREATE_USER_ID   VARCHAR2(32) not null,
  FCREATE_NICKNAME  VARCHAR2(30) not null,
  FPERSON_ID        VARCHAR2(32),
  FPERSON_CODE      VARCHAR2(32),
  FPERSON_NAME      VARCHAR2(50),
  FOPERATOR_ID      VARCHAR2(32) not null,
  FREFUND_ORIGIN    VARCHAR2(32),
  FREFUND_REVERSE   VARCHAR2(32),
  FREFUND_ID        VARCHAR2(32),
  FSUM_TOTAL        NUMBER(10,2) not null,
  FSUM_DISCOUNTED   NUMBER(10,2) not null,
  FSUM_PAYMENT      NUMBER(10,2) not null,
  FSUM_OWN          NUMBER(10,2) not null,
  FSUM_COUPON       NUMBER(10,2) not null,
  FCSREPORT_ID      VARCHAR2(32) default 'NONE' not null,
  FCSREPORT_DATE    timestamp not null,
  FCHGNOTE_DESC     VARCHAR2(256),
  FVERSION          NUMBER(6) default 0 not null,
  FLOGCBY           VARCHAR2(32) not null,
  FLOGCDATE         timestamp not null,
  FLOGLUBY          VARCHAR2(32) not null,
  FLOGLUDATE        timestamp not null,
  FLOGLABY          VARCHAR2(32) not null,
  FLOGLADATE        timestamp not null
)
;
alter table FXP.P_CHGNOTE
  add constraint PK_P_CHGNOTE primary key (FCHGNOTE_ID);
alter table FXP.P_CHGNOTE
  add constraint UK_P_CHGNOTE_NO unique (FCHGNOTE_NO);
create index FXP.IDX_P_CHGNOTE_CSREDATE on FXP.P_CHGNOTE (FCSREPORT_DATE);
create index FXP.IDX_P_CHGNOTE_CSREPORT on FXP.P_CHGNOTE (FCSREPORT_ID);
create index FXP.IDX_P_CHGNOTE_DATE on FXP.P_CHGNOTE (FCREATE_DATE);
create index FXP.IDX_P_CHGNOTE_PERSON on FXP.P_CHGNOTE (FPERSON_ID);

--prompt
--prompt Creating table P_CHGNOTE_COUPON
--prompt ===============================
--prompt
create table FXP.P_CHGNOTE_COUPON
(
  FCHGNOTE_ID       VARCHAR2(32) not null,
  FCOUPON_ID        VARCHAR2(32) not null,
  FCOUPON_NO        VARCHAR2(30) not null,
  FCOUPON_TYPE_ID   VARCHAR2(32) not null,
  FCOUPON_TYPE_NAME VARCHAR2(40) not null,
  FCOUPON_MONEY     NUMBER(10,2) default 0 not null,
  FCOUPON_UNIT      VARCHAR2(30),
  FCOUPON_DESC      VARCHAR2(256),
  FCOUPON_AMOUNT    NUMBER(10,2) default 0 not null,
  FCREATE_DATE      timestamp not null,
  FVERSION          NUMBER(6) default 0 not null,
  FLOGCBY           VARCHAR2(32) not null,
  FLOGCDATE         timestamp not null,
  FLOGLUBY          VARCHAR2(32) not null,
  FLOGLUDATE        timestamp not null,
  FLOGLABY          VARCHAR2(32) not null,
  FLOGLADATE        timestamp not null
)
;
alter table FXP.P_CHGNOTE_COUPON
  add constraint PK_P_CHGNOTE_COUPON primary key (FCHGNOTE_ID, FCOUPON_ID);
create index FXP.IDX_P_CHGNOTE_COUPON_DATE on FXP.P_CHGNOTE_COUPON (FCREATE_DATE);

--prompt
--prompt Creating table P_CHGNOTE_COUPON_SUM
--prompt ===================================
--prompt
create table FXP.P_CHGNOTE_COUPON_SUM
(
  FCHGNOTE_ID       VARCHAR2(32) not null,
  FCOUPON_TYPE_ID   VARCHAR2(32) not null,
  FCOUPON_TYPE_NAME VARCHAR2(40) not null,
  FCOUPON_MONEY     NUMBER(10,2) default 0 not null,
  FCOUPON_UNIT      VARCHAR2(30),
  FCOUPON_DESC      VARCHAR2(256),
  FCOUPON_QUANTITY  NUMBER(2) default 0 not null,
  FCOUPON_AMOUNT    NUMBER(10,2) default 0 not null,
  FCREATE_DATE      timestamp not null,
  FVERSION          NUMBER(6) default 0 not null,
  FLOGCBY           VARCHAR2(32) not null,
  FLOGCDATE         timestamp not null,
  FLOGLUBY          VARCHAR2(32) not null,
  FLOGLUDATE        timestamp not null,
  FLOGLABY          VARCHAR2(32) not null,
  FLOGLADATE        timestamp not null
)
;
alter table FXP.P_CHGNOTE_COUPON_SUM
  add constraint PK_P_CHGNOTE_COUPON_SUM primary key (FCHGNOTE_ID, FCOUPON_TYPE_ID);
create index FXP.IDX_P_CHGNOTE_COUPON_SUM_DATE on FXP.P_CHGNOTE_COUPON_SUM (FCREATE_DATE);

--prompt
--prompt Creating table P_CIRCLE_SIGN
--prompt ============================
--prompt
create table FXP.P_CIRCLE_SIGN
(
  FSIGN_ID            VARCHAR2(32) not null,
  FPROVIDER_CIRCLE_ID VARCHAR2(32) not null,
  FCUSTOMER_CIRCLE_ID VARCHAR2(32) not null,
  FBUSINESS_ID        VARCHAR2(32) not null,
  FSIGN_DESC          VARCHAR2(256),
  FCREATE_TIME        timestamp default sysdate not null,
  FCREATE_USER_ID     VARCHAR2(32) not null,
  FCREATE_USER_NAME   VARCHAR2(50) not null,
  FVERSION            NUMBER(6) default 0 not null,
  FLOGCBY             VARCHAR2(32) not null,
  FLOGCDATE           timestamp not null,
  FLOGLUBY            VARCHAR2(32) not null,
  FLOGLUDATE          timestamp not null,
  FLOGLABY            VARCHAR2(32) not null,
  FLOGLADATE          timestamp not null
)
;
alter table FXP.P_CIRCLE_SIGN
  add constraint PK_P_CIRCLE_SIGN primary key (FSIGN_ID);
alter table FXP.P_CIRCLE_SIGN
  add constraint UK_P_CIRCLE_SIGN unique (FPROVIDER_CIRCLE_ID, FCUSTOMER_CIRCLE_ID, FBUSINESS_ID);
alter table FXP.P_CIRCLE_SIGN
  add constraint FK_P_CIRCLE_SIGN_BUSSINESS foreign key (FBUSINESS_ID)
  references FXP.P_BUSINESS (FBUSINESS_ID);
alter table FXP.P_CIRCLE_SIGN
  add constraint FK_P_CIRCLE_SIGN_CUSTOMER foreign key (FCUSTOMER_CIRCLE_ID)
  references FXP.P_CIRCLE (FCIRCLE_ID);
alter table FXP.P_CIRCLE_SIGN
  add constraint FK_P_CIRCLE_SIGN_PROVIDER foreign key (FPROVIDER_CIRCLE_ID)
  references FXP.P_CIRCLE (FCIRCLE_ID);

--prompt
--prompt Creating table P_CITIZENSHIP
--prompt ============================
--prompt
create table FXP.P_CITIZENSHIP
(
  FCITIZENSHIP_ID     VARCHAR2(32) not null,
  FCITIZENSHIP_CODE   VARCHAR2(8) not null,
  FCITIZENSHIP_GBCODE VARCHAR2(32),
  FCITIZENSHIP_NAME   VARCHAR2(40) not null,
  FISOTHER            CHAR(1) not null,
  FISAVAILABLE        CHAR(1) not null,
  FORDERNUM           NUMBER(6,2) not null,
  FCITIZENSHIP_DESC   VARCHAR2(256),
  FVERSION            NUMBER(6) default 0 not null,
  FLOGCBY             VARCHAR2(32) not null,
  FLOGCDATE           timestamp default sysdate not null,
  FLOGLUBY            VARCHAR2(32) not null,
  FLOGLUDATE          timestamp default sysdate not null,
  FLOGLABY            VARCHAR2(32) not null,
  FLOGLADATE          timestamp default sysdate not null
)
;
alter table FXP.P_CITIZENSHIP
  add constraint PK_P_CITIZENSHIP primary key (FCITIZENSHIP_ID);
alter table FXP.P_CITIZENSHIP
  add constraint UK_P_CITIZENSHIP_CODE unique (FCITIZENSHIP_CODE);

--prompt
--prompt Creating table P_COUPON_ACTIVITY
--prompt ================================
--prompt
create table FXP.P_COUPON_ACTIVITY
(
  FACTIVITY_ID     VARCHAR2(32) not null,
  FACTIVITY_NAME   VARCHAR2(100) not null,
  FACTIVITY_DESC   VARCHAR2(256),
  FOPERATOR_ID     VARCHAR2(32) not null,
  FCREATE_DATE     timestamp not null,
  FCREATE_ORG_ID   VARCHAR2(32) not null,
  FCREATE_SITE_ID  VARCHAR2(32) not null,
  FCREATE_USER_ID  VARCHAR2(32) not null,
  FCREATE_NICKNAME VARCHAR2(30) not null,
  FIS_ISSUED       CHAR(1) not null,
  FISSUE_DATE      timestamp,
  FISSUE_USER_ID   VARCHAR2(32),
  FISSUE_NICKNAME  VARCHAR2(30),
  FVERSION         NUMBER(6) default 0 not null,
  FLOGCBY          VARCHAR2(32) not null,
  FLOGCDATE        timestamp not null,
  FLOGLUBY         VARCHAR2(32) not null,
  FLOGLUDATE       timestamp not null,
  FLOGLABY         VARCHAR2(32) not null,
  FLOGLADATE       timestamp not null
)
;
alter table FXP.P_COUPON_ACTIVITY
  add constraint PK_P_COUPON_ACTIVITY primary key (FACTIVITY_ID);
create index FXP.IDX_P_COUPON_ACTIVITY_CDATE on FXP.P_COUPON_ACTIVITY (FCREATE_DATE);
create index FXP.IDX_P_COUPON_ACTIVITY_OPERATOR on FXP.P_COUPON_ACTIVITY (FOPERATOR_ID);

--prompt
--prompt Creating table P_COUPON_TYPE
--prompt ============================
--prompt
create table FXP.P_COUPON_TYPE
(
  FCOUPON_TYPE_ID   VARCHAR2(32) not null,
  FCOUPON_TYPE_NAME VARCHAR2(40) not null,
  FCOUPON_CLASS     VARCHAR2(30) not null,
  FCOUPON_MONEY     NUMBER(10,2) default 0 not null,
  FCOUPON_UNIT      VARCHAR2(30),
  FCOUPON_DESC      VARCHAR2(256),
  FOPERATOR_ID      VARCHAR2(32) not null,
  FCREATE_DATE      timestamp not null,
  FCREATE_USER_ID   VARCHAR2(32) not null,
  FCREATE_NICKNAME  VARCHAR2(30) not null,
  FIS_CANCEL        CHAR(1) default 'N' not null,
  FCANCEL_REASON    VARCHAR2(100),
  FCANCEL_DATE      timestamp,
  FCANCEL_USER_ID   VARCHAR2(32),
  FCANCEL_NICKNAME  VARCHAR2(40),
  FVERSION          NUMBER(6) default 0 not null,
  FLOGCBY           VARCHAR2(32) not null,
  FLOGCDATE         timestamp not null,
  FLOGLUBY          VARCHAR2(32) not null,
  FLOGLUDATE        timestamp not null,
  FLOGLABY          VARCHAR2(32) not null,
  FLOGLADATE        timestamp not null
)
;
alter table FXP.P_COUPON_TYPE
  add constraint PK_P_COUPON_TYPE primary key (FCOUPON_TYPE_ID);

--prompt
--prompt Creating table P_COUPON
--prompt =======================
--prompt
create table FXP.P_COUPON
(
  FCOUPON_ID        VARCHAR2(32) not null,
  FCOUPON_NO        VARCHAR2(30) not null,
  FCOUPON_TYPE_ID   VARCHAR2(32) not null,
  FCOUPON_TYPE_NAME VARCHAR2(40) not null,
  FCOUPON_MONEY     NUMBER(10,2) default 0 not null,
  FCOUPON_UNIT      VARCHAR2(30),
  FCOUPON_DESC      VARCHAR2(256),
  FDUETIME_BEGIN    timestamp not null,
  FDUETIME_END      timestamp not null,
  FISSUE_DESC       VARCHAR2(256),
  FCOUPON_FROM      VARCHAR2(30) not null,
  FACTIVITY_ID      VARCHAR2(32),
  FCROWDS_ID        VARCHAR2(32),
  FISSUE_ID         VARCHAR2(32),
  FOPERATOR_ID      VARCHAR2(32) not null,
  FACCOUNT_ID       VARCHAR2(32) not null,
  FCREATE_DATE      timestamp not null,
  FCREATE_USER_ID   VARCHAR2(32) not null,
  FCREATE_NICKNAME  VARCHAR2(30) not null,
  FIS_USED          CHAR(1) default 'N' not null,
  FUSED_DATE        timestamp,
  FUSED_CHGNOTE_ID  VARCHAR2(32),
  FUSED_ORG_ID      VARCHAR2(32),
  FUSED_SITE_ID     VARCHAR2(32),
  FUSED_USER_ID     VARCHAR2(32),
  FUSED_NICKNAME    VARCHAR2(40),
  FVERSION          NUMBER(6) default 0 not null,
  FLOGCBY           VARCHAR2(32) not null,
  FLOGCDATE         timestamp not null,
  FLOGLUBY          VARCHAR2(32) not null,
  FLOGLUDATE        timestamp not null,
  FLOGLABY          VARCHAR2(32) not null,
  FLOGLADATE        timestamp not null
)
;
alter table FXP.P_COUPON
  add constraint PK_P_COUPON primary key (FCOUPON_ID);
alter table FXP.P_COUPON
  add constraint UK_P_COUPON_NO unique (FCOUPON_NO);
alter table FXP.P_COUPON
  add constraint FK_P_COUPON_ACCOUNT foreign key (FACCOUNT_ID)
  references FXP.P_ACCOUNT (FACCOUNT_ID);
alter table FXP.P_COUPON
  add constraint FK_P_COUPON_ACTIVITY foreign key (FACTIVITY_ID)
  references FXP.P_COUPON_ACTIVITY (FACTIVITY_ID);
alter table FXP.P_COUPON
  add constraint FK_P_COUPON_COUPON_TYPE foreign key (FCOUPON_TYPE_ID)
  references FXP.P_COUPON_TYPE (FCOUPON_TYPE_ID);
alter table FXP.P_COUPON
  add constraint FK_P_COUPON_CROWDS foreign key (FCROWDS_ID)
  references FXP.P_ACTIVITY_CROWDS (FCROWDS_ID);
create index FXP.IDX_P_COUPON_ACCOUNT on FXP.P_COUPON (FACCOUNT_ID);
create index FXP.IDX_P_COUPON_CHGNOTE on FXP.P_COUPON (FUSED_CHGNOTE_ID);
create index FXP.IDX_P_COUPON_USED_DATE on FXP.P_COUPON (FUSED_DATE);

--prompt
--prompt Creating table P_COUPON_SCOPE
--prompt =============================
--prompt
create table FXP.P_COUPON_SCOPE
(
  FCOUPON_TYPE_ID      VARCHAR2(32) not null,
  FPRODUCT_SUBCLASS_ID VARCHAR2(32) not null,
  FPRODUCT_CLASS_ID    VARCHAR2(32) not null,
  FVERSION             NUMBER(6) default 0 not null,
  FLOGCBY              VARCHAR2(32) not null,
  FLOGCDATE            timestamp not null,
  FLOGLUBY             VARCHAR2(32) not null,
  FLOGLUDATE           timestamp not null,
  FLOGLABY             VARCHAR2(32) not null,
  FLOGLADATE           timestamp not null
)
;
alter table FXP.P_COUPON_SCOPE
  add constraint PK_P_COUPON_SCOPE primary key (FCOUPON_TYPE_ID, FPRODUCT_SUBCLASS_ID);

--prompt
--prompt Creating table P_CROWDS_COUPON
--prompt ==============================
--prompt
create table FXP.P_CROWDS_COUPON
(
  FISSUE_ID         VARCHAR2(32) not null,
  FCOUPON_TYPE_ID   VARCHAR2(32) not null,
  FCOUPON_TYPE_NAME VARCHAR2(40) not null,
  FCOUPON_MONEY     NUMBER(10,2) default 0 not null,
  FCOUPON_UNIT      VARCHAR2(30),
  FCOUPON_DESC      VARCHAR2(256),
  FPERIOD_BEGIN     timestamp not null,
  FPERIOD_END       timestamp not null,
  FAMOUNT           NUMBER(6) not null,
  FISSUE_DESC       VARCHAR2(256),
  FCROWDS_ID        VARCHAR2(32) not null,
  FACTIVITY_ID      VARCHAR2(32) not null,
  FOPERATOR_ID      VARCHAR2(32) not null,
  FCREATE_DATE      timestamp not null,
  FVERSION          NUMBER(6) default 0 not null,
  FLOGCBY           VARCHAR2(32) not null,
  FLOGCDATE         timestamp not null,
  FLOGLUBY          VARCHAR2(32) not null,
  FLOGLUDATE        timestamp not null,
  FLOGLABY          VARCHAR2(32) not null,
  FLOGLADATE        timestamp not null
)
;
alter table FXP.P_CROWDS_COUPON
  add constraint PK_P_CROWDS_COUPON primary key (FISSUE_ID);
alter table FXP.P_CROWDS_COUPON
  add constraint UK_P_CROWDS_COUPON unique (FACTIVITY_ID, FCROWDS_ID, FCOUPON_TYPE_ID);
create index FXP.IDX_P_CROWDS_COUPON_CROWDS on FXP.P_CROWDS_COUPON (FCROWDS_ID);

--prompt
--prompt Creating table P_CROWDS_LIST
--prompt ============================
--prompt
create table FXP.P_CROWDS_LIST
(
  FCROWDS_ID     VARCHAR2(32) not null,
  FPERSON_ID     VARCHAR2(32) not null,
  FPERSON_NO     VARCHAR2(30) not null,
  FPERSON_NAME   VARCHAR2(50) not null,
  FSEX_NAME      VARCHAR2(30),
  FBIRTH_DATE    timestamp,
  FPERSON_MOBILE VARCHAR2(30),
  FID_NO         VARCHAR2(30),
  FACCOUNT_ID    VARCHAR2(32) not null,
  FACTIVITY_ID   VARCHAR2(32) not null,
  FOPERATOR_ID   VARCHAR2(32) not null,
  FLIST_DESC     VARCHAR2(256),
  FCREATE_DATE   timestamp not null,
  FVERSION       NUMBER(6) default 0 not null,
  FLOGCBY        VARCHAR2(32) not null,
  FLOGCDATE      timestamp not null,
  FLOGLUBY       VARCHAR2(32) not null,
  FLOGLUDATE     timestamp not null,
  FLOGLABY       VARCHAR2(32) not null,
  FLOGLADATE     timestamp not null
)
;
alter table FXP.P_CROWDS_LIST
  add constraint PK_P_CROWDS_LIST primary key (FACCOUNT_ID, FACTIVITY_ID);

--prompt
--prompt Creating table P_CSAT_DEGREE
--prompt ============================
--prompt
create table FXP.P_CSAT_DEGREE
(
  FCSAT_DEGREE_ID   VARCHAR2(32) not null,
  FCSAT_DEGREE_NAME VARCHAR2(30) not null,
  FCSAT_DEGREE_DESC VARCHAR2(256),
  FVERSION          NUMBER(6) default 0 not null,
  FLOGCBY           VARCHAR2(32) not null,
  FLOGCDATE         timestamp not null,
  FLOGLUBY          VARCHAR2(32) not null,
  FLOGLUDATE        timestamp not null,
  FLOGLABY          VARCHAR2(32) not null,
  FLOGLADATE        timestamp not null
)
;
alter table FXP.P_CSAT_DEGREE
  add constraint PK_P_CSAT_DEGREE primary key (FCSAT_DEGREE_ID);

--prompt
--prompt Creating table P_CUSTOMER_TYPE
--prompt ==============================
--prompt
create table FXP.P_CUSTOMER_TYPE
(
  FCUSTOMER_TYPE_ID     VARCHAR2(32) not null,
  FCUSTOMER_TYPE_CODE   VARCHAR2(30) not null,
  FCUSTOMER_TYPE_GBCODE VARCHAR2(32),
  FCUSTOMER_TYPE_NAME   VARCHAR2(40) not null,
  FISAVAILABLE          CHAR(1) not null,
  FORDERNUM             NUMBER(6,2) not null,
  FCUSTOMER_TYPE_DESC   VARCHAR2(256),
  FVERSION              NUMBER(6) default 0 not null,
  FLOGCBY               VARCHAR2(32) not null,
  FLOGCDATE             timestamp default sysdate not null,
  FLOGLUBY              VARCHAR2(32) not null,
  FLOGLUDATE            timestamp default sysdate not null,
  FLOGLABY              VARCHAR2(32) not null,
  FLOGLADATE            timestamp default sysdate not null
)
;
alter table FXP.P_CUSTOMER_TYPE
  add constraint PK_P_CUSTOMER_TYPE primary key (FCUSTOMER_TYPE_ID);
alter table FXP.P_CUSTOMER_TYPE
  add constraint UK_P_CUSTOMER_TYPE_CODE unique (FCUSTOMER_TYPE_CODE);

--prompt
--prompt Creating table P_DEVICE_COMPANY
--prompt ===============================
--prompt
create table FXP.P_DEVICE_COMPANY
(
  FCOMPANY_ID      VARCHAR2(32) not null,
  FCOMPANY_CODE    VARCHAR2(30) not null,
  FCOMPANY_NAME    VARCHAR2(30) not null,
  FCOMPANY_DESC    VARCHAR2(256),
  FCREATE_DATE     timestamp not null,
  FCREATE_USER_ID  VARCHAR2(32) not null,
  FCREATE_NICKNAME VARCHAR2(40) not null,
  FIS_CANCEL       CHAR(1) default 'N' not null,
  FCANCEL_REASON   VARCHAR2(100),
  FCANCEL_DATE     timestamp,
  FCANCEL_USER_ID  VARCHAR2(32),
  FCANCEL_NICKNAME VARCHAR2(40),
  FVERSION         NUMBER(6) default 0 not null,
  FLOGCBY          VARCHAR2(32) not null,
  FLOGCDATE        timestamp not null,
  FLOGLUBY         VARCHAR2(32) not null,
  FLOGLUDATE       timestamp not null,
  FLOGLABY         VARCHAR2(32) not null,
  FLOGLADATE       timestamp not null
)
;
alter table FXP.P_DEVICE_COMPANY
  add constraint PK_P_DEVICE_COMPANY primary key (FCOMPANY_ID);
alter table FXP.P_DEVICE_COMPANY
  add constraint UK_P_DEVICE_COMPANY unique (FCOMPANY_CODE);

--prompt
--prompt Creating table P_DEVICE_TYPE
--prompt ============================
--prompt
create table FXP.P_DEVICE_TYPE
(
  FDEVICE_TYPE_ID   VARCHAR2(32) not null,
  FDEVICE_TYPE_NAME VARCHAR2(50) not null,
  FDEVICE_TYPE_DESC VARCHAR2(256),
  FCREATE_DATE      timestamp not null,
  FVERSION          NUMBER(6) default 0 not null,
  FLOGCBY           VARCHAR2(32) not null,
  FLOGCDATE         timestamp not null,
  FLOGLUBY          VARCHAR2(32) not null,
  FLOGLUDATE        timestamp not null,
  FLOGLABY          VARCHAR2(32) not null,
  FLOGLADATE        timestamp not null
)
;
alter table FXP.P_DEVICE_TYPE
  add constraint PK_P_DEVICE_TYPE primary key (FDEVICE_TYPE_ID);

--prompt
--prompt Creating table P_DEVICE_MODEL
--prompt =============================
--prompt
create table FXP.P_DEVICE_MODEL
(
  FDEVICE_MODEL_ID   VARCHAR2(32) not null,
  FDEVICE_MODEL_CODE VARCHAR2(30) not null,
  FDEVICE_MODEL_NAME VARCHAR2(50) not null,
  FCOMPANY_ID        VARCHAR2(32) not null,
  FCOMPANY_NAME      VARCHAR2(30) not null,
  FDEVICE_TYPE_ID    VARCHAR2(32) not null,
  FDEVICE_TYPE_NAME  VARCHAR2(50) not null,
  FMAX_USER          NUMBER(3) not null,
  FDEVICE_MODEL_DESC VARCHAR2(256),
  FCREATE_DATE       timestamp not null,
  FCREATE_USER_ID    VARCHAR2(32) not null,
  FCREATE_NICKNAME   VARCHAR2(40) not null,
  FIS_CANCEL         CHAR(1) default 'N' not null,
  FCANCEL_REASON     VARCHAR2(100),
  FCANCEL_DATE       timestamp,
  FCANCEL_USER_ID    VARCHAR2(32),
  FCANCEL_NICKNAME   VARCHAR2(40),
  FVERSION           NUMBER(6) default 0 not null,
  FLOGCBY            VARCHAR2(32) not null,
  FLOGCDATE          timestamp not null,
  FLOGLUBY           VARCHAR2(32) not null,
  FLOGLUDATE         timestamp not null,
  FLOGLABY           VARCHAR2(32) not null,
  FLOGLADATE         timestamp not null
)
;
alter table FXP.P_DEVICE_MODEL
  add constraint PK_P_DEVICE_MODEL primary key (FDEVICE_MODEL_ID);
alter table FXP.P_DEVICE_MODEL
  add constraint UK_P_DEVICE_MODEL unique (FDEVICE_MODEL_CODE);
alter table FXP.P_DEVICE_MODEL
  add constraint FK_P_DEVICE_MODEL_COMPANY foreign key (FCOMPANY_ID)
  references FXP.P_DEVICE_COMPANY (FCOMPANY_ID);
alter table FXP.P_DEVICE_MODEL
  add constraint FK_P_DEVICE_MODEL_TYPE foreign key (FDEVICE_TYPE_ID)
  references FXP.P_DEVICE_TYPE (FDEVICE_TYPE_ID);

--prompt
--prompt Creating table P_DEVICE
--prompt =======================
--prompt
create table FXP.P_DEVICE
(
  FDEVICE_ID         VARCHAR2(32) not null,
  FDEVICE_TYPE_ID    VARCHAR2(32) not null,
  FDEVICE_TYPE_NAME  VARCHAR2(50) not null,
  FCOMPANY_ID        VARCHAR2(32) not null,
  FCOMPANY_NAME      VARCHAR2(30) not null,
  FDEVICE_MODEL_ID   VARCHAR2(32) not null,
  FDEVICE_MODEL_NAME VARCHAR2(50) not null,
  FMAX_USER          NUMBER(3) not null,
  FDEVICE_SN         VARCHAR2(32) not null,
  FDEVICE_UUID       VARCHAR2(32),
  FPRODUCTION_DATE   timestamp,
  FPURCHASE_DATE     timestamp,
  FDEVICE_DESC       VARCHAR2(256),
  FCIRCLE_ID         VARCHAR2(32),
  FCREATE_DATE       timestamp not null,
  FCREATE_CIRCLE_ID  VARCHAR2(32) not null,
  FCREATE_TEAM_ID    VARCHAR2(32) not null,
  FCREATE_TEAM_NAME  VARCHAR2(100) not null,
  FCREATE_USER_ID    VARCHAR2(32) not null,
  FCREATE_NICKNAME   VARCHAR2(40) not null,
  FIS_USED           CHAR(1) default 'N' not null,
  FUSED_TYPE         VARCHAR2(30),
  FUSED_DATE         timestamp,
  FUSED_USER_ID      VARCHAR2(32),
  FUSED_NICKNAME     VARCHAR2(40),
  FVERSION           NUMBER(6) default 0 not null,
  FLOGCBY            VARCHAR2(32) not null,
  FLOGCDATE          timestamp not null,
  FLOGLUBY           VARCHAR2(32) not null,
  FLOGLUDATE         timestamp not null,
  FLOGLABY           VARCHAR2(32) not null,
  FLOGLADATE         timestamp not null
)
;
alter table FXP.P_DEVICE
  add constraint PK_P_DEVICE primary key (FDEVICE_ID);
alter table FXP.P_DEVICE
  add constraint UK_P_DEVICE_SN unique (FDEVICE_SN, FDEVICE_TYPE_ID, FCOMPANY_ID, FDEVICE_MODEL_ID);
alter table FXP.P_DEVICE
  add constraint FK_P_DEVICE_CIRCLE foreign key (FCIRCLE_ID)
  references FXP.P_CIRCLE (FCIRCLE_ID);
alter table FXP.P_DEVICE
  add constraint FK_P_DEVICE_COMPANY foreign key (FCOMPANY_ID)
  references FXP.P_DEVICE_COMPANY (FCOMPANY_ID);
alter table FXP.P_DEVICE
  add constraint FK_P_DEVICE_MODEL foreign key (FDEVICE_MODEL_ID)
  references FXP.P_DEVICE_MODEL (FDEVICE_MODEL_ID);
alter table FXP.P_DEVICE
  add constraint FK_P_DEVICE_TYPE foreign key (FDEVICE_TYPE_ID)
  references FXP.P_DEVICE_TYPE (FDEVICE_TYPE_ID);
create index FXP.IDX_P_DEVICE_UUID on FXP.P_DEVICE (FDEVICE_UUID);

--prompt
--prompt Creating table P_DEVICE_CALL
--prompt ============================
--prompt
create table FXP.P_DEVICE_CALL
(
  FDEVICE_ID         VARCHAR2(32) not null,
  FCOMPANY_ID        VARCHAR2(32) not null,
  FCOMPANY_NAME      VARCHAR2(30) not null,
  FDEVICE_MODEL_ID   VARCHAR2(32) not null,
  FDEVICE_MODEL_NAME VARCHAR2(50) not null,
  FDEVICE_SN         VARCHAR2(32) not null,
  FPRODUCTION_DATE   timestamp,
  FPURCHASE_DATE     timestamp,
  FDEVICE_DESC       VARCHAR2(256),
  FCIRCLE_ID         VARCHAR2(32),
  FCREATE_DATE       timestamp not null,
  FCREATE_CIRCLE_ID  VARCHAR2(32) not null,
  FCREATE_TEAM_ID    VARCHAR2(32) not null,
  FCREATE_TEAM_NAME  VARCHAR2(100) not null,
  FCREATE_USER_ID    VARCHAR2(32) not null,
  FCREATE_NICKNAME   VARCHAR2(40) not null,
  FIS_USED           CHAR(1) default 'N' not null,
  FUSED_TYPE         VARCHAR2(30),
  FUSED_DATE         timestamp,
  FUSED_USER_ID      VARCHAR2(32),
  FUSED_NICKNAME     VARCHAR2(40),
  FVERSION           NUMBER(6) default 0 not null,
  FLOGCBY            VARCHAR2(32) not null,
  FLOGCDATE          timestamp not null,
  FLOGLUBY           VARCHAR2(32) not null,
  FLOGLUDATE         timestamp not null,
  FLOGLABY           VARCHAR2(32) not null,
  FLOGLADATE         timestamp not null
)
;
alter table FXP.P_DEVICE_CALL
  add constraint PK_P_DEVICE_CALL primary key (FDEVICE_ID);
alter table FXP.P_DEVICE_CALL
  add constraint UK_P_DEVICE_CALL unique (FDEVICE_SN, FCOMPANY_ID, FDEVICE_MODEL_ID);
alter table FXP.P_DEVICE_CALL
  add constraint FK_P_DEVICE_CALL_CIRCLE foreign key (FCIRCLE_ID)
  references FXP.P_CIRCLE (FCIRCLE_ID);
alter table FXP.P_DEVICE_CALL
  add constraint FK_P_DEVICE_CALL_COMPANY foreign key (FCOMPANY_ID)
  references FXP.P_DEVICE_COMPANY (FCOMPANY_ID);
alter table FXP.P_DEVICE_CALL
  add constraint FK_P_DEVICE_CALL_MODEL foreign key (FDEVICE_MODEL_ID)
  references FXP.P_DEVICE_MODEL (FDEVICE_MODEL_ID);

--prompt
--prompt Creating table P_DEVICE_HMO
--prompt ===========================
--prompt
create table FXP.P_DEVICE_HMO
(
  FDEVICE_ID         VARCHAR2(32) not null,
  FCOMPANY_ID        VARCHAR2(32) not null,
  FCOMPANY_NAME      VARCHAR2(30) not null,
  FDEVICE_MODEL_ID   VARCHAR2(32) not null,
  FDEVICE_MODEL_NAME VARCHAR2(50) not null,
  FMAX_USER          NUMBER(3) not null,
  FDEVICE_SN         VARCHAR2(32) not null,
  FDEVICE_UUID       VARCHAR2(32),
  FPRODUCTION_DATE   timestamp,
  FPURCHASE_DATE     timestamp,
  FDEVICE_DESC       VARCHAR2(256),
  FCIRCLE_ID         VARCHAR2(32),
  FCREATE_DATE       timestamp not null,
  FCREATE_CIRCLE_ID  VARCHAR2(32) not null,
  FCREATE_TEAM_ID    VARCHAR2(32) not null,
  FCREATE_TEAM_NAME  VARCHAR2(100) not null,
  FCREATE_USER_ID    VARCHAR2(32) not null,
  FCREATE_NICKNAME   VARCHAR2(40) not null,
  FIS_USED           CHAR(1) default 'N' not null,
  FUSED_NO           NUMBER(3),
  FUSED_TYPE         VARCHAR2(30),
  FUSED_DATE         timestamp,
  FUSED_USER_ID      VARCHAR2(32),
  FUSED_NICKNAME     VARCHAR2(40),
  FVERSION           NUMBER(6) default 0 not null,
  FLOGCBY            VARCHAR2(32) not null,
  FLOGCDATE          timestamp not null,
  FLOGLUBY           VARCHAR2(32) not null,
  FLOGLUDATE         timestamp not null,
  FLOGLABY           VARCHAR2(32) not null,
  FLOGLADATE         timestamp not null
)
;
alter table FXP.P_DEVICE_HMO
  add constraint PK_P_DEVICE_HMO primary key (FDEVICE_ID);
alter table FXP.P_DEVICE_HMO
  add constraint UK_P_DEVICE_HMO unique (FDEVICE_SN, FCOMPANY_ID, FDEVICE_MODEL_ID);
alter table FXP.P_DEVICE_HMO
  add constraint FK_P_DEVICE_HMO_CIRCLE foreign key (FCIRCLE_ID)
  references FXP.P_CIRCLE (FCIRCLE_ID);
alter table FXP.P_DEVICE_HMO
  add constraint FK_P_DEVICE_HMO_COMPANY foreign key (FCOMPANY_ID)
  references FXP.P_DEVICE_COMPANY (FCOMPANY_ID);
alter table FXP.P_DEVICE_HMO
  add constraint FK_P_DEVICE_HMO_MODEL foreign key (FDEVICE_MODEL_ID)
  references FXP.P_DEVICE_MODEL (FDEVICE_MODEL_ID);
create index FXP.P_DEVICE_HMO_UUID on FXP.P_DEVICE_HMO (FDEVICE_UUID);

--prompt
--prompt Creating table P_DEVICE_TEH
--prompt ===========================
--prompt
create table FXP.P_DEVICE_TEH
(
  FDEVICE_ID         VARCHAR2(32) not null,
  FCOMPANY_ID        VARCHAR2(32) not null,
  FCOMPANY_NAME      VARCHAR2(30) not null,
  FDEVICE_MODEL_ID   VARCHAR2(32) not null,
  FDEVICE_MODEL_NAME VARCHAR2(50) not null,
  FDEVICE_SN         VARCHAR2(32) not null,
  FDEVICE_IMEI       VARCHAR2(32) not null,
  FPRODUCTION_DATE   timestamp,
  FPURCHASE_DATE     timestamp,
  FDEVICE_DESC       VARCHAR2(256),
  FCIRCLE_ID         VARCHAR2(32),
  FCREATE_DATE       timestamp not null,
  FCREATE_CIRCLE_ID  VARCHAR2(32) not null,
  FCREATE_TEAM_ID    VARCHAR2(32) not null,
  FCREATE_TEAM_NAME  VARCHAR2(100) not null,
  FCREATE_USER_ID    VARCHAR2(32) not null,
  FCREATE_NICKNAME   VARCHAR2(40) not null,
  FIS_USED           CHAR(1) default 'N' not null,
  FUSED_TYPE         VARCHAR2(30),
  FUSED_DATE         timestamp,
  FUSED_USER_ID      VARCHAR2(32),
  FUSED_NICKNAME     VARCHAR2(40),
  FVERSION           NUMBER(6) default 0 not null,
  FLOGCBY            VARCHAR2(32) not null,
  FLOGCDATE          timestamp not null,
  FLOGLUBY           VARCHAR2(32) not null,
  FLOGLUDATE         timestamp not null,
  FLOGLABY           VARCHAR2(32) not null,
  FLOGLADATE         timestamp not null
)
;
alter table FXP.P_DEVICE_TEH
  add constraint PK_P_DEVICE_TEH primary key (FDEVICE_ID);
alter table FXP.P_DEVICE_TEH
  add constraint UK_P_DEVICE_TEH unique (FDEVICE_SN, FCOMPANY_ID, FDEVICE_MODEL_ID);
alter table FXP.P_DEVICE_TEH
  add constraint FK_P_DEVICE_TEH_CIRCLE foreign key (FCIRCLE_ID)
  references FXP.P_CIRCLE (FCIRCLE_ID);
alter table FXP.P_DEVICE_TEH
  add constraint FK_P_DEVICE_TEH_COMPANY foreign key (FCOMPANY_ID)
  references FXP.P_DEVICE_COMPANY (FCOMPANY_ID);
alter table FXP.P_DEVICE_TEH
  add constraint FK_P_DEVICE_TEH_MODEL foreign key (FDEVICE_MODEL_ID)
  references FXP.P_DEVICE_MODEL (FDEVICE_MODEL_ID);
create index FXP.P_DEVICE_TEH_IMEI on FXP.P_DEVICE_TEH (FDEVICE_IMEI);

--prompt
--prompt Creating table P_DEVICE_WRISTBAND
--prompt =================================
--prompt
create table FXP.P_DEVICE_WRISTBAND
(
  FDEVICE_ID         VARCHAR2(32) not null,
  FCOMPANY_ID        VARCHAR2(32) not null,
  FCOMPANY_NAME      VARCHAR2(30) not null,
  FDEVICE_MODEL_ID   VARCHAR2(32) not null,
  FDEVICE_MODEL_NAME VARCHAR2(50) not null,
  FDEVICE_SN         VARCHAR2(32) not null,
  FDEVICE_UUID       VARCHAR2(32),
  FPRODUCTION_DATE   timestamp,
  FPURCHASE_DATE     timestamp,
  FDEVICE_DESC       VARCHAR2(256),
  FCIRCLE_ID         VARCHAR2(32),
  FCREATE_DATE       timestamp not null,
  FCREATE_CIRCLE_ID  VARCHAR2(32) not null,
  FCREATE_TEAM_ID    VARCHAR2(32) not null,
  FCREATE_TEAM_NAME  VARCHAR2(100) not null,
  FCREATE_USER_ID    VARCHAR2(32) not null,
  FCREATE_NICKNAME   VARCHAR2(40) not null,
  FIS_USED           CHAR(1) default 'N' not null,
  FUSED_TYPE         VARCHAR2(30),
  FUSED_DATE         timestamp,
  FUSED_USER_ID      VARCHAR2(32),
  FUSED_NICKNAME     VARCHAR2(40),
  FVERSION           NUMBER(6) default 0 not null,
  FLOGCBY            VARCHAR2(32) not null,
  FLOGCDATE          timestamp not null,
  FLOGLUBY           VARCHAR2(32) not null,
  FLOGLUDATE         timestamp not null,
  FLOGLABY           VARCHAR2(32) not null,
  FLOGLADATE         timestamp not null
)
;
alter table FXP.P_DEVICE_WRISTBAND
  add constraint PK_P_DEVICE_WRISTBAND primary key (FDEVICE_ID);
alter table FXP.P_DEVICE_WRISTBAND
  add constraint UK_P_DEVICE_WRISTBAND unique (FDEVICE_SN, FCOMPANY_ID, FDEVICE_MODEL_ID);
alter table FXP.P_DEVICE_WRISTBAND
  add constraint FK_P_DEVICE_WRISTBAND_CIRCLE foreign key (FCIRCLE_ID)
  references FXP.P_CIRCLE (FCIRCLE_ID);
alter table FXP.P_DEVICE_WRISTBAND
  add constraint FK_P_DEVICE_WRISTBAND_COMPANY foreign key (FCOMPANY_ID)
  references FXP.P_DEVICE_COMPANY (FCOMPANY_ID);
alter table FXP.P_DEVICE_WRISTBAND
  add constraint FK_P_DEVICE_WRISTBAND_MODEL foreign key (FDEVICE_MODEL_ID)
  references FXP.P_DEVICE_MODEL (FDEVICE_MODEL_ID);

--prompt
--prompt Creating table P_DEV_DATA_IDCARD
--prompt ================================
--prompt
create table FXP.P_DEV_DATA_IDCARD
(
  FDEVICE_SN        VARCHAR2(32) not null,
  FPERSON_NAME      VARCHAR2(50) not null,
  FSEX_NAME         VARCHAR2(30),
  FNATION_NAME      VARCHAR2(30),
  FBIRTH_DATE       timestamp not null,
  FIDTYPE_ID        VARCHAR2(32) not null,
  FIDTYPE_NAME      VARCHAR2(30) not null,
  FID_NO            VARCHAR2(30) not null,
  FREGISTER_ADDR    VARCHAR2(80),
  FISSUE_ORG        VARCHAR2(50),
  FVALID_DATE_START timestamp,
  FVALID_DATE_END   timestamp,
  FREAD_DATE        timestamp not null,
  FVERSION          NUMBER(6) default 0 not null,
  FLOGCBY           VARCHAR2(32) not null,
  FLOGCDATE         timestamp not null,
  FLOGLUBY          VARCHAR2(32) not null,
  FLOGLUDATE        timestamp not null,
  FLOGLABY          VARCHAR2(32) not null,
  FLOGLADATE        timestamp not null
)
;
alter table FXP.P_DEV_DATA_IDCARD
  add constraint PK_P_DEV_IDCARD primary key (FDEVICE_SN);
create index FXP.IDX_P_DEV_DATA_IDCARD on FXP.P_DEV_DATA_IDCARD (FREAD_DATE);

--prompt
--prompt Creating table P_REGIONALISM
--prompt ============================
--prompt
create table FXP.P_REGIONALISM
(
  FREGION_ID       VARCHAR2(32) not null,
  FREGION_CODE     VARCHAR2(20) not null,
  FREGION_GBCODE   VARCHAR2(30),
  FREGION_NAME     VARCHAR2(40) not null,
  FAT_CLASS        VARCHAR2(1) not null,
  FAT_PROVINCE_ID  VARCHAR2(30),
  FAT_CITY_ID      VARCHAR2(30),
  FAT_DISTRICT_ID  VARCHAR2(30),
  FAT_STREET_ID    VARCHAR2(30),
  FAT_COMMITTEE_ID VARCHAR2(30),
  FISAVAILABLE     CHAR(1) not null,
  FORDERNUM        NUMBER(6,2) not null,
  FREGION_DESC     VARCHAR2(256),
  FVERSION         NUMBER(6) default 0 not null,
  FLOGCBY          VARCHAR2(32) not null,
  FLOGCDATE        timestamp default sysdate not null,
  FLOGLUBY         VARCHAR2(32) not null,
  FLOGLUDATE       timestamp default sysdate not null,
  FLOGLABY         VARCHAR2(32) not null,
  FLOGLADATE       timestamp default sysdate not null
)
;
alter table FXP.P_REGIONALISM
  add constraint PK_P_REGIONALISM primary key (FREGION_ID);
alter table FXP.P_REGIONALISM
  add constraint CK_P_REGIONALISM_AT_CLASS
  check (fat_class in ('1','2','3','4','5'));

--prompt
--prompt Creating table P_FAMILY
--prompt =======================
--prompt
create table FXP.P_FAMILY
(
  FFAMILY_ID         VARCHAR2(32) not null,
  FFAMILY_CODE       VARCHAR2(32) not null,
  FCIRCLE_ID         VARCHAR2(32) not null,
  FAGENT_MOBILE      VARCHAR2(30),
  FAGENT_NAME        VARCHAR2(30) not null,
  FREGION_ID         VARCHAR2(32),
  FREGION_NAME       VARCHAR2(80),
  FADDRESS           VARCHAR2(200),
  FMAP_ADDR          VARCHAR2(200),
  FLATITUDE          NUMBER(19,15),
  FLONGITUDE         NUMBER(19,15),
  FLIVING_CONDI_NAME VARCHAR2(40),
  FFAMILY_DESC       VARCHAR2(256),
  FVERSION           NUMBER(6) default 0 not null,
  FLOGCBY            VARCHAR2(32) not null,
  FLOGCDATE          timestamp not null,
  FLOGLUBY           VARCHAR2(32) not null,
  FLOGLUDATE         timestamp not null,
  FLOGLABY           VARCHAR2(32) not null,
  FLOGLADATE         timestamp not null,
  FAGENT_USER_ID     VARCHAR2(32),
  FFAMILY_MEMBER     VARCHAR2(100),
  FFAMILY_PHONE      VARCHAR2(30),
  FFAMILY_LAST_PHONE VARCHAR2(30),
  FCREATE_DATE       timestamp,
  FCREATE_USER_ID    VARCHAR2(32),
  FCREATE_USER_NAME  VARCHAR2(30),
  FTEAM_ID           VARCHAR2(32) not null
)
;
alter table FXP.P_FAMILY
  add constraint PK_P_FAMILY primary key (FFAMILY_ID);
alter table FXP.P_FAMILY
  add constraint UK_P_FAMILY_CODE unique (FFAMILY_CODE);
alter table FXP.P_FAMILY
  add constraint FK_P_FAMILY_CIRCLE foreign key (FCIRCLE_ID)
  references FXP.P_CIRCLE (FCIRCLE_ID);
alter table FXP.P_FAMILY
  add constraint FK_P_FAMILY_REGION foreign key (FREGION_ID)
  references FXP.P_REGIONALISM (FREGION_ID);
create index FXP.IDX_P_FAMILY_PHONE on FXP.P_FAMILY (FFAMILY_PHONE);

--prompt
--prompt Creating table P_DEV_ISSUE_CALL
--prompt ===============================
--prompt
create table FXP.P_DEV_ISSUE_CALL
(
  FISSUE_ID          VARCHAR2(32) not null,
  FFAMILY_ID         VARCHAR2(32) not null,
  FDEVICE_ID         VARCHAR2(32) not null,
  FCOMPANY_ID        VARCHAR2(32) not null,
  FCOMPANY_NAME      VARCHAR2(30) not null,
  FDEVICE_MODEL_ID   VARCHAR2(32) not null,
  FDEVICE_MODEL_NAME VARCHAR2(50) not null,
  FDEVICE_SN         VARCHAR2(32) not null,
  FPRODUCTION_DATE   timestamp,
  FPURCHASE_DATE     timestamp,
  FDEVICE_DESC       VARCHAR2(256),
  FCIRCLE_ID         VARCHAR2(32),
  FBIND_PHONE        VARCHAR2(32) not null,
  FISSUE_DATE        timestamp not null,
  FISSUE_STATE       VARCHAR2(20) not null,
  FISSUE_CIRCLE_ID   VARCHAR2(32) not null,
  FISSUE_TEAM_ID     VARCHAR2(32) not null,
  FISSUE_TEAM_NAME   VARCHAR2(100) not null,
  FISSUE_USER_ID     VARCHAR2(32) not null,
  FISSUE_NICKNAME    VARCHAR2(40) not null,
  FISSUE_DESC        VARCHAR2(256),
  FVERSION           NUMBER(6) default 0 not null,
  FLOGCBY            VARCHAR2(32) not null,
  FLOGCDATE          timestamp not null,
  FLOGLUBY           VARCHAR2(32) not null,
  FLOGLUDATE         timestamp not null,
  FLOGLABY           VARCHAR2(32) not null,
  FLOGLADATE         timestamp not null
)
;
alter table FXP.P_DEV_ISSUE_CALL
  add constraint PK_P_DEV_ISSUE_CALL primary key (FISSUE_ID);
alter table FXP.P_DEV_ISSUE_CALL
  add constraint UK_P_DEV_ISSUE_CALL_DEV unique (FDEVICE_ID);
alter table FXP.P_DEV_ISSUE_CALL
  add constraint UK_P_DEV_ISSUE_CALL_FAMILY unique (FFAMILY_ID);
alter table FXP.P_DEV_ISSUE_CALL
  add constraint UK_P_DEV_ISSUE_CALL_PHONE unique (FBIND_PHONE);
alter table FXP.P_DEV_ISSUE_CALL
  add constraint UK_P_DEV_ISSUE_CALL_SN unique (FDEVICE_SN, FCOMPANY_ID, FDEVICE_MODEL_ID);
alter table FXP.P_DEV_ISSUE_CALL
  add constraint FK_P_DEV_ISSUE_CALL_CIRCLE foreign key (FCIRCLE_ID)
  references FXP.P_CIRCLE (FCIRCLE_ID);
alter table FXP.P_DEV_ISSUE_CALL
  add constraint FK_P_DEV_ISSUE_CALL_COM foreign key (FCOMPANY_ID)
  references FXP.P_DEVICE_COMPANY (FCOMPANY_ID);
alter table FXP.P_DEV_ISSUE_CALL
  add constraint FK_P_DEV_ISSUE_CALL_DEVICE foreign key (FDEVICE_ID)
  references FXP.P_DEVICE (FDEVICE_ID);
alter table FXP.P_DEV_ISSUE_CALL
  add constraint FK_P_DEV_ISSUE_CALL_FAMILY foreign key (FFAMILY_ID)
  references FXP.P_FAMILY (FFAMILY_ID);
alter table FXP.P_DEV_ISSUE_CALL
  add constraint FK_P_DEV_ISSUE_CALL_MODEL foreign key (FDEVICE_MODEL_ID)
  references FXP.P_DEVICE_MODEL (FDEVICE_MODEL_ID);

--prompt
--prompt Creating table P_DEV_ISSUE_FAMILY
--prompt =================================
--prompt
create table FXP.P_DEV_ISSUE_FAMILY
(
  FISSUE_ID          VARCHAR2(32) not null,
  FFAMILY_ID         VARCHAR2(32) not null,
  FDEVICE_ID         VARCHAR2(32) not null,
  FDEVICE_TYPE_ID    VARCHAR2(32) not null,
  FDEVICE_TYPE_NAME  VARCHAR2(50) not null,
  FCOMPANY_ID        VARCHAR2(32) not null,
  FCOMPANY_NAME      VARCHAR2(30) not null,
  FDEVICE_MODEL_ID   VARCHAR2(32) not null,
  FDEVICE_MODEL_NAME VARCHAR2(50) not null,
  FDEVICE_SN         VARCHAR2(32) not null,
  FDEVICE_UUID       VARCHAR2(32),
  FPRODUCTION_DATE   timestamp,
  FPURCHASE_DATE     timestamp,
  FDEVICE_DESC       VARCHAR2(256),
  FCIRCLE_ID         VARCHAR2(32),
  FISSUE_DATE        timestamp not null,
  FISSUE_CIRCLE_ID   VARCHAR2(32) not null,
  FISSUE_TEAM_ID     VARCHAR2(32) not null,
  FISSUE_TEAM_NAME   VARCHAR2(100) not null,
  FISSUE_USER_ID     VARCHAR2(32) not null,
  FISSUE_NICKNAME    VARCHAR2(40) not null,
  FISSUE_DESC        VARCHAR2(256),
  FVERSION           NUMBER(6) default 0 not null,
  FLOGCBY            VARCHAR2(32) not null,
  FLOGCDATE          timestamp not null,
  FLOGLUBY           VARCHAR2(32) not null,
  FLOGLUDATE         timestamp not null,
  FLOGLABY           VARCHAR2(32) not null,
  FLOGLADATE         timestamp not null
)
;
alter table FXP.P_DEV_ISSUE_FAMILY
  add constraint PK_P_DEV_ISSUE_FAMILY primary key (FISSUE_ID);
alter table FXP.P_DEV_ISSUE_FAMILY
  add constraint UK_P_DEV_ISSUE_FAMILY_DEV unique (FDEVICE_ID);
alter table FXP.P_DEV_ISSUE_FAMILY
  add constraint UK_P_DEV_ISSUE_FAMILY_SN unique (FDEVICE_TYPE_ID, FCOMPANY_ID, FDEVICE_MODEL_ID, FDEVICE_SN);
alter table FXP.P_DEV_ISSUE_FAMILY
  add constraint FK_P_DEV_ISSUE_FAMILY_CIRCLE foreign key (FCIRCLE_ID)
  references FXP.P_CIRCLE (FCIRCLE_ID);
alter table FXP.P_DEV_ISSUE_FAMILY
  add constraint FK_P_DEV_ISSUE_FAMILY_COM foreign key (FCOMPANY_ID)
  references FXP.P_DEVICE_COMPANY (FCOMPANY_ID);
alter table FXP.P_DEV_ISSUE_FAMILY
  add constraint FK_P_DEV_ISSUE_FAMILY_DEVICE foreign key (FDEVICE_ID)
  references FXP.P_DEVICE (FDEVICE_ID);
alter table FXP.P_DEV_ISSUE_FAMILY
  add constraint FK_P_DEV_ISSUE_FAMILY_FAMILY foreign key (FFAMILY_ID)
  references FXP.P_FAMILY (FFAMILY_ID);
alter table FXP.P_DEV_ISSUE_FAMILY
  add constraint FK_P_DEV_ISSUE_FAMILY_MODEL foreign key (FDEVICE_MODEL_ID)
  references FXP.P_DEVICE_MODEL (FDEVICE_MODEL_ID);
alter table FXP.P_DEV_ISSUE_FAMILY
  add constraint FK_P_DEV_ISSUE_FAMILY_TYPE foreign key (FDEVICE_TYPE_ID)
  references FXP.P_DEVICE_TYPE (FDEVICE_TYPE_ID);
create index FXP.IDX_P_DEV_ISSUE_FAMILY_FAMILY on FXP.P_DEV_ISSUE_FAMILY (FFAMILY_ID);
create index FXP.IDX_P_DEV_ISSUE_FAMILY_UUID on FXP.P_DEV_ISSUE_FAMILY (FDEVICE_UUID);

--prompt
--prompt Creating table P_SEX
--prompt ====================
--prompt
create table FXP.P_SEX
(
  FSEX_ID      VARCHAR2(32) not null,
  FSEX_CODE    VARCHAR2(8) not null,
  FSEX_GBCODE  VARCHAR2(32),
  FSEX_NAME    VARCHAR2(40) not null,
  FISAVAILABLE CHAR(1) not null,
  FORDERNUM    NUMBER(6,2) not null,
  FSEX_DESC    VARCHAR2(256),
  FVERSION     NUMBER(6) default 0 not null,
  FLOGCBY      VARCHAR2(32) not null,
  FLOGCDATE    timestamp default sysdate not null,
  FLOGLUBY     VARCHAR2(32) not null,
  FLOGLUDATE   timestamp default sysdate not null,
  FLOGLABY     VARCHAR2(32) not null,
  FLOGLADATE   timestamp default sysdate not null
)
;
alter table FXP.P_SEX
  add constraint PK_P_SEX primary key (FSEX_ID);
alter table FXP.P_SEX
  add constraint UK_P_SEX_CODE unique (FSEX_CODE);

--prompt
--prompt Creating table P_ECONOMY_STATE
--prompt ==============================
--prompt
create table FXP.P_ECONOMY_STATE
(
  FECONOMY_STATE_ID     VARCHAR2(32) not null,
  FECONOMY_STATE_CODE   VARCHAR2(8) not null,
  FECONOMY_STATE_GBCODE VARCHAR2(32),
  FECONOMY_STATE_NAME   VARCHAR2(40) not null,
  FISOTHER              CHAR(1) not null,
  FISAVAILABLE          CHAR(1) not null,
  FORDERNUM             NUMBER(6,2) not null,
  FECONOMY_STATE_DESC   VARCHAR2(256),
  FVERSION              NUMBER(6) default 0 not null,
  FLOGCBY               VARCHAR2(32) not null,
  FLOGCDATE             timestamp default sysdate not null,
  FLOGLUBY              VARCHAR2(32) not null,
  FLOGLUDATE            timestamp default sysdate not null,
  FLOGLABY              VARCHAR2(32) not null,
  FLOGLADATE            timestamp default sysdate not null
)
;
alter table FXP.P_ECONOMY_STATE
  add constraint PK_P_ECONOMY_STATE primary key (FECONOMY_STATE_ID);
alter table FXP.P_ECONOMY_STATE
  add constraint UK_P_ECONOMY_STATE_CODE unique (FECONOMY_STATE_CODE);

--prompt
--prompt Creating table P_EDU_DEGREE
--prompt ===========================
--prompt
create table FXP.P_EDU_DEGREE
(
  FEDU_DEGREE_ID     VARCHAR2(32) not null,
  FEDU_DEGREE_CODE   VARCHAR2(8) not null,
  FEDU_DEGREE_GBCODE VARCHAR2(32),
  FEDU_DEGREE_NAME   VARCHAR2(40) not null,
  FISAVAILABLE       CHAR(1) not null,
  FORDERNUM          NUMBER(6,2) not null,
  FEDU_DEGREE_DESC   VARCHAR2(256),
  FVERSION           NUMBER(6) default 0 not null,
  FLOGCBY            VARCHAR2(32) not null,
  FLOGCDATE          timestamp default sysdate not null,
  FLOGLUBY           VARCHAR2(32) not null,
  FLOGLUDATE         timestamp default sysdate not null,
  FLOGLABY           VARCHAR2(32) not null,
  FLOGLADATE         timestamp default sysdate not null
)
;
alter table FXP.P_EDU_DEGREE
  add constraint PK_P_EDU_DEGREE primary key (FEDU_DEGREE_ID);
alter table FXP.P_EDU_DEGREE
  add constraint UK_P_EDU_DEGREE_CODE unique (FEDU_DEGREE_CODE);

--prompt
--prompt Creating table P_HEALTH_STATE
--prompt =============================
--prompt
create table FXP.P_HEALTH_STATE
(
  FHEALTH_STATE_ID     VARCHAR2(32) not null,
  FHEALTH_STATE_CODE   VARCHAR2(8) not null,
  FHEALTH_STATE_GBCODE VARCHAR2(32),
  FHEALTH_STATE_NAME   VARCHAR2(40) not null,
  FISAVAILABLE         CHAR(1) not null,
  FORDERNUM            NUMBER(6,2) not null,
  FHEALTH_STATE_DESC   VARCHAR2(256),
  FVERSION             NUMBER(6) default 0 not null,
  FLOGCBY              VARCHAR2(32) not null,
  FLOGCDATE            timestamp default sysdate not null,
  FLOGLUBY             VARCHAR2(32) not null,
  FLOGLUDATE           timestamp default sysdate not null,
  FLOGLABY             VARCHAR2(32) not null,
  FLOGLADATE           timestamp default sysdate not null
)
;
alter table FXP.P_HEALTH_STATE
  add constraint PK_P_HEALTH_STATE primary key (FHEALTH_STATE_ID);
alter table FXP.P_HEALTH_STATE
  add constraint UK_P_HEALTH_STATE_CODE unique (FHEALTH_STATE_CODE);

--prompt
--prompt Creating table P_HOUSE_RELATION
--prompt ===============================
--prompt
create table FXP.P_HOUSE_RELATION
(
  FHOUSE_RELATION_ID     VARCHAR2(32) not null,
  FHOUSE_RELATION_CODE   VARCHAR2(8) not null,
  FHOUSE_RELATION_GBCODE VARCHAR2(32),
  FHOUSE_RELATION_NAME   VARCHAR2(40) not null,
  FISAVAILABLE           CHAR(1) not null,
  FORDERNUM              NUMBER(6,2) not null,
  FHOUSE_RELATION_DESC   VARCHAR2(256),
  FVERSION               NUMBER(6) default 0 not null,
  FLOGCBY                VARCHAR2(32) not null,
  FLOGCDATE              timestamp not null,
  FLOGLUBY               VARCHAR2(32) not null,
  FLOGLUDATE             timestamp not null,
  FLOGLABY               VARCHAR2(32) not null,
  FLOGLADATE             timestamp not null
)
;
alter table FXP.P_HOUSE_RELATION
  add constraint PK_P_HOUSE_RELATION primary key (FHOUSE_RELATION_ID);
alter table FXP.P_HOUSE_RELATION
  add constraint UK_P_HOUSE_RELATION unique (FHOUSE_RELATION_CODE);

--prompt
--prompt Creating table P_ID_TYPE
--prompt ========================
--prompt
create table FXP.P_ID_TYPE
(
  FIDTYPE_ID     VARCHAR2(32) not null,
  FIDTYPE_CODE   VARCHAR2(8) not null,
  FIDTYPE_GBCODE VARCHAR2(32),
  FIDTYPE_NAME   VARCHAR2(40) not null,
  FISAVAILABLE   CHAR(1) not null,
  FORDERNUM      NUMBER(6,2) not null,
  FIDTYPE_DESC   VARCHAR2(256),
  FVERSION       NUMBER(6) default 0 not null,
  FLOGCBY        VARCHAR2(32) not null,
  FLOGCDATE      timestamp default sysdate not null,
  FLOGLUBY       VARCHAR2(32) not null,
  FLOGLUDATE     timestamp default sysdate not null,
  FLOGLABY       VARCHAR2(32) not null,
  FLOGLADATE     timestamp default sysdate not null
)
;
alter table FXP.P_ID_TYPE
  add constraint PK_P_ID_TYPE primary key (FIDTYPE_ID);
alter table FXP.P_ID_TYPE
  add constraint UK_P_ID_TYPE_CODE unique (FIDTYPE_CODE);

--prompt
--prompt Creating table P_MARRIAGE
--prompt =========================
--prompt
create table FXP.P_MARRIAGE
(
  FMARRIAGE_ID     VARCHAR2(32) not null,
  FMARRIAGE_CODE   VARCHAR2(8) not null,
  FMARRIAGE_GBCODE VARCHAR2(32),
  FMARRIAGE_NAME   VARCHAR2(40) not null,
  FISAVAILABLE     CHAR(1) not null,
  FORDERNUM        NUMBER(6,2) not null,
  FMARRIAGE_DESC   VARCHAR2(256),
  FVERSION         NUMBER(6) default 0 not null,
  FLOGCBY          VARCHAR2(32) not null,
  FLOGCDATE        timestamp default sysdate not null,
  FLOGLUBY         VARCHAR2(32) not null,
  FLOGLUDATE       timestamp default sysdate not null,
  FLOGLABY         VARCHAR2(32) not null,
  FLOGLADATE       timestamp default sysdate not null
)
;
alter table FXP.P_MARRIAGE
  add constraint PK_P_MARRIAGE primary key (FMARRIAGE_ID);
alter table FXP.P_MARRIAGE
  add constraint UK_P_MARRIAGE_CODE unique (FMARRIAGE_CODE);

--prompt
--prompt Creating table P_MEDINSU_METH
--prompt =============================
--prompt
create table FXP.P_MEDINSU_METH
(
  FMEDINSU_METH_ID     VARCHAR2(32) not null,
  FMEDINSU_METH_CODE   VARCHAR2(30) not null,
  FMEDINSU_METH_GBCODE VARCHAR2(32),
  FMEDINSU_METH_NAME   VARCHAR2(30) not null,
  FISOTHER             CHAR(1) not null,
  FISAVAILABLE         CHAR(1) not null,
  FORDERNUM            NUMBER(6,2) not null,
  FMEDINSU_METH_DESC   VARCHAR2(256),
  FVERSION             NUMBER(6) default 0 not null,
  FLOGCBY              VARCHAR2(32) not null,
  FLOGCDATE            timestamp not null,
  FLOGLUBY             VARCHAR2(32) not null,
  FLOGLUDATE           timestamp not null,
  FLOGLABY             VARCHAR2(32) not null,
  FLOGLADATE           timestamp not null
)
;
alter table FXP.P_MEDINSU_METH
  add constraint PK_P_MEDINSU_METH primary key (FMEDINSU_METH_ID);
alter table FXP.P_MEDINSU_METH
  add constraint UK_P_MEDINSU_METH_CODE unique (FMEDINSU_METH_CODE);

--prompt
--prompt Creating table P_NATION
--prompt =======================
--prompt
create table FXP.P_NATION
(
  FNATION_ID     VARCHAR2(32) not null,
  FNATION_CODE   VARCHAR2(8) not null,
  FNATION_GBCODE VARCHAR2(32),
  FNATION_NAME   VARCHAR2(40) not null,
  FISAVAILABLE   CHAR(1) not null,
  FORDERNUM      NUMBER(6,2) not null,
  FNATION_DESC   VARCHAR2(256),
  FVERSION       NUMBER(6) default 0 not null,
  FLOGCBY        VARCHAR2(32) not null,
  FLOGCDATE      timestamp default sysdate not null,
  FLOGLUBY       VARCHAR2(32) not null,
  FLOGLUDATE     timestamp default sysdate not null,
  FLOGLABY       VARCHAR2(32) not null,
  FLOGLADATE     timestamp default sysdate not null
)
;
alter table FXP.P_NATION
  add constraint PK_P_NATION primary key (FNATION_ID);
alter table FXP.P_NATION
  add constraint UK_P_NATION_CODE unique (FNATION_CODE);

--prompt
--prompt Creating table P_OCCUPATION
--prompt ===========================
--prompt
create table FXP.P_OCCUPATION
(
  FOCCUPATION_ID     VARCHAR2(32) not null,
  FOCCUPATION_CODE   VARCHAR2(30) not null,
  FOCCUPATION_GBCODE VARCHAR2(32),
  FOCCUPATION_NAME   VARCHAR2(40) not null,
  FISOTHER           CHAR(1) not null,
  FISAVAILABLE       CHAR(1) not null,
  FORDERNUM          NUMBER(6,2) not null,
  FOCCUPATION_DESC   VARCHAR2(256),
  FVERSION           NUMBER(6) default 0 not null,
  FLOGCBY            VARCHAR2(32) not null,
  FLOGCDATE          timestamp default sysdate not null,
  FLOGLUBY           VARCHAR2(32) not null,
  FLOGLUDATE         timestamp default sysdate not null,
  FLOGLABY           VARCHAR2(32) not null,
  FLOGLADATE         timestamp default sysdate not null
)
;
alter table FXP.P_OCCUPATION
  add constraint PK_P_OCCUPATION primary key (FOCCUPATION_ID);
alter table FXP.P_OCCUPATION
  add constraint UK_P_OCCUPATION_CODE unique (FOCCUPATION_CODE);

--prompt
--prompt Creating table P_PERSON
--prompt =======================
--prompt
create table FXP.P_PERSON
(
  FPERSON_ID           VARCHAR2(32) not null,
  FPERSON_CODE         VARCHAR2(32) not null,
  FUSER_ID             VARCHAR2(32),
  FPERSON_NAME         VARCHAR2(50) not null,
  FIDTYPE_ID           VARCHAR2(32),
  FIDTYPE_NAME         VARCHAR2(30),
  FID_NO               VARCHAR2(30),
  FSEX_ID              VARCHAR2(32),
  FSEX_NAME            VARCHAR2(30),
  FBIRTH_DATE          timestamp,
  FFAMILY_ID           VARCHAR2(32),
  FHOUSE_RELATION_ID   VARCHAR2(32),
  FHOUSE_RELATION_NAME VARCHAR2(30),
  FIS_NATIVE           CHAR(1),
  FREGISTER_ADDR       VARCHAR2(50),
  FNATION_ID           VARCHAR2(32),
  FNATION_NAME         VARCHAR2(30),
  FMARRIAGE_ID         VARCHAR2(32),
  FMARRIAGE_NAME       VARCHAR2(30),
  FEDU_DEGREE_ID       VARCHAR2(32),
  FEDU_DEGREE_NAME     VARCHAR2(30),
  FOCCUPATION_ID       VARCHAR2(32),
  FOCCUPATION_NAME     VARCHAR2(30),
  FLANGUAGE_NAME       VARCHAR2(30),
  FPHOTO_ID            VARCHAR2(32),
  FECONOMY_STATE_ID    VARCHAR2(32),
  FECONOMY_STATE_NAME  VARCHAR2(30),
  FPERSON_MOBILE       VARCHAR2(30),
  FWORKUNIT_NAME       VARCHAR2(50),
  FMEDINSU_METH_ID     VARCHAR2(32),
  FMEDINSU_METH_NAME   VARCHAR2(30),
  FHEALTH_STATE_ID     VARCHAR2(32),
  FHEALTH_STATE_NAME   VARCHAR2(30),
  FPERSON_DISEASE      VARCHAR2(50),
  FPERSON_DESC         VARCHAR2(256),
  FCUSTOMER_TYPE_ID    VARCHAR2(32),
  FCUSTOMER_TYPE_NAME  VARCHAR2(30),
  FCIRCLE_ID           VARCHAR2(32) not null,
  FLAST_SERVICE_DATE   timestamp default sysdate not null,
  FREGIST_WAY          VARCHAR2(20) not null,
  FCREATE_DATE         timestamp default sysdate not null,
  FCREATE_USER_ID      VARCHAR2(32),
  FCREATE_USER_NAME    VARCHAR2(30),
  FIS_CANCEL           CHAR(1) default 'N' not null,
  FCANCEL_REASON       VARCHAR2(60),
  FCANCEL_DATE         timestamp,
  FCANCEL_USER_ID      VARCHAR2(32),
  FCANCEL_USER_NAME    VARCHAR2(30),
  FVERSION             NUMBER(6) default 0 not null,
  FLOGCBY              VARCHAR2(32) not null,
  FLOGCDATE            timestamp default sysdate not null,
  FLOGLUBY             VARCHAR2(32) not null,
  FLOGLUDATE           timestamp default sysdate not null,
  FLOGLABY             VARCHAR2(32) not null,
  FLOGLADATE           timestamp default sysdate not null
)
;
alter table FXP.P_PERSON
  add constraint PK_P_PERSON primary key (FPERSON_ID);
alter table FXP.P_PERSON
  add constraint UK_P_PERSON_CODE unique (FPERSON_CODE);
alter table FXP.P_PERSON
  add constraint UK_P_PERSON_IDNO unique (FID_NO);
alter table FXP.P_PERSON
  add constraint UK_P_PERSON_MOBILE unique (FPERSON_MOBILE);
alter table FXP.P_PERSON
  add constraint FK_P_PERSON_CIRCLE foreign key (FCIRCLE_ID)
  references FXP.P_CIRCLE (FCIRCLE_ID);
alter table FXP.P_PERSON
  add constraint FK_P_PERSON_CUSTOMER foreign key (FCUSTOMER_TYPE_ID)
  references FXP.P_CUSTOMER_TYPE (FCUSTOMER_TYPE_ID);
alter table FXP.P_PERSON
  add constraint FK_P_PERSON_ECONOMY foreign key (FECONOMY_STATE_ID)
  references FXP.P_ECONOMY_STATE (FECONOMY_STATE_ID);
alter table FXP.P_PERSON
  add constraint FK_P_PERSON_EDU_DEGRE foreign key (FEDU_DEGREE_ID)
  references FXP.P_EDU_DEGREE (FEDU_DEGREE_ID);
alter table FXP.P_PERSON
  add constraint FK_P_PERSON_FAMILY foreign key (FFAMILY_ID)
  references FXP.P_FAMILY (FFAMILY_ID);
alter table FXP.P_PERSON
  add constraint FK_P_PERSON_HEALTH foreign key (FHEALTH_STATE_ID)
  references FXP.P_HEALTH_STATE (FHEALTH_STATE_ID);
alter table FXP.P_PERSON
  add constraint FK_P_PERSON_HOUSE foreign key (FHOUSE_RELATION_ID)
  references FXP.P_HOUSE_RELATION (FHOUSE_RELATION_ID);
alter table FXP.P_PERSON
  add constraint FK_P_PERSON_IDTYPE foreign key (FIDTYPE_ID)
  references FXP.P_ID_TYPE (FIDTYPE_ID);
alter table FXP.P_PERSON
  add constraint FK_P_PERSON_MARRIAGE foreign key (FMARRIAGE_ID)
  references FXP.P_MARRIAGE (FMARRIAGE_ID);
alter table FXP.P_PERSON
  add constraint FK_P_PERSON_MEDINSU foreign key (FMEDINSU_METH_ID)
  references FXP.P_MEDINSU_METH (FMEDINSU_METH_ID);
alter table FXP.P_PERSON
  add constraint FK_P_PERSON_NATION foreign key (FNATION_ID)
  references FXP.P_NATION (FNATION_ID);
alter table FXP.P_PERSON
  add constraint FK_P_PERSON_OCCUPATION foreign key (FOCCUPATION_ID)
  references FXP.P_OCCUPATION (FOCCUPATION_ID);
alter table FXP.P_PERSON
  add constraint FK_P_PERSON_SEX foreign key (FSEX_ID)
  references FXP.P_SEX (FSEX_ID);
alter table FXP.P_PERSON
  add constraint FK_P_PERSON_USER foreign key (FUSER_ID)
  references FXP.P_USER (FUSER_ID);
create index FXP.IDX_P_PERSON_CREATE_DATE on FXP.P_PERSON (FCREATE_DATE);
create index FXP.IDX_P_PERSON_NAME on FXP.P_PERSON (FPERSON_NAME);

--prompt
--prompt Creating table P_DEV_ISSUE_HMO
--prompt ==============================
--prompt
create table FXP.P_DEV_ISSUE_HMO
(
  FISSUE_ID          VARCHAR2(32) not null,
  FPERSON_ID         VARCHAR2(32) not null,
  FPERSON_NAME       VARCHAR2(50) not null,
  FDEVICE_ID         VARCHAR2(32) not null,
  FCOMPANY_ID        VARCHAR2(32) not null,
  FCOMPANY_NAME      VARCHAR2(30) not null,
  FDEVICE_MODEL_ID   VARCHAR2(32) not null,
  FDEVICE_MODEL_NAME VARCHAR2(50) not null,
  FMAX_USER          NUMBER(3) not null,
  FDEVICE_SN         VARCHAR2(32) not null,
  FDEVICE_UUID       VARCHAR2(32),
  FPRODUCTION_DATE   timestamp,
  FPURCHASE_DATE     timestamp,
  FUSER_NO           NUMBER(3) not null,
  FDEVICE_DESC       VARCHAR2(256),
  FAPP_USERNAME      VARCHAR2(50),
  FAPP_PASSWORD      VARCHAR2(50),
  FCIRCLE_ID         VARCHAR2(32),
  FISSUE_DATE        timestamp not null,
  FISSUE_CIRCLE_ID   VARCHAR2(32) not null,
  FISSUE_TEAM_ID     VARCHAR2(32) not null,
  FISSUE_TEAM_NAME   VARCHAR2(100) not null,
  FISSUE_USER_ID     VARCHAR2(32) not null,
  FISSUE_NICKNAME    VARCHAR2(40) not null,
  FISSUE_DESC        VARCHAR2(256),
  FVERSION           NUMBER(6) default 0 not null,
  FLOGCBY            VARCHAR2(32) not null,
  FLOGCDATE          timestamp not null,
  FLOGLUBY           VARCHAR2(32) not null,
  FLOGLUDATE         timestamp not null,
  FLOGLABY           VARCHAR2(32) not null,
  FLOGLADATE         timestamp not null
)
;
alter table FXP.P_DEV_ISSUE_HMO
  add constraint PK_P_DEV_ISSUE_HMO primary key (FISSUE_ID);
alter table FXP.P_DEV_ISSUE_HMO
  add constraint UK_P_DEV_ISSUE_HMO_DEVICE unique (FDEVICE_ID, FUSER_NO);
alter table FXP.P_DEV_ISSUE_HMO
  add constraint UK_P_DEV_ISSUE_HMO_SN unique (FDEVICE_SN, FCOMPANY_ID, FDEVICE_MODEL_ID, FUSER_NO);
alter table FXP.P_DEV_ISSUE_HMO
  add constraint FK_P_DEV_ISSUE_HMO_CIR foreign key (FCIRCLE_ID)
  references FXP.P_CIRCLE (FCIRCLE_ID);
alter table FXP.P_DEV_ISSUE_HMO
  add constraint FK_P_DEV_ISSUE_HMO_COM foreign key (FCOMPANY_ID)
  references FXP.P_DEVICE_COMPANY (FCOMPANY_ID);
alter table FXP.P_DEV_ISSUE_HMO
  add constraint FK_P_DEV_ISSUE_HMO_DEV foreign key (FDEVICE_ID)
  references FXP.P_DEVICE (FDEVICE_ID);
alter table FXP.P_DEV_ISSUE_HMO
  add constraint FK_P_DEV_ISSUE_HMO_MOD foreign key (FDEVICE_MODEL_ID)
  references FXP.P_DEVICE_MODEL (FDEVICE_MODEL_ID);
alter table FXP.P_DEV_ISSUE_HMO
  add constraint FK_P_DEV_ISSUE_HMO_PER foreign key (FPERSON_ID)
  references FXP.P_PERSON (FPERSON_ID);

--prompt
--prompt Creating table P_DEV_ISSUE_PERSON
--prompt =================================
--prompt
create table FXP.P_DEV_ISSUE_PERSON
(
  FISSUE_ID          VARCHAR2(32) not null,
  FPERSON_ID         VARCHAR2(32) not null,
  FPERSON_NAME       VARCHAR2(50) not null,
  FDEVICE_ID         VARCHAR2(32) not null,
  FDEVICE_TYPE_ID    VARCHAR2(32) not null,
  FDEVICE_TYPE_NAME  VARCHAR2(50) not null,
  FCOMPANY_ID        VARCHAR2(32) not null,
  FCOMPANY_NAME      VARCHAR2(30) not null,
  FDEVICE_MODEL_ID   VARCHAR2(32) not null,
  FDEVICE_MODEL_NAME VARCHAR2(50) not null,
  FMAX_USER          NUMBER(3) not null,
  FDEVICE_SN         VARCHAR2(32) not null,
  FDEVICE_UUID       VARCHAR2(32),
  FPRODUCTION_DATE   timestamp,
  FPURCHASE_DATE     timestamp,
  FUSER_NO           NUMBER(3) not null,
  FDEVICE_DESC       VARCHAR2(256),
  FAPP_USERNAME      VARCHAR2(50),
  FAPP_PASSWORD      VARCHAR2(50),
  FCIRCLE_ID         VARCHAR2(32),
  FISSUE_DATE        timestamp not null,
  FISSUE_CIRCLE_ID   VARCHAR2(32) not null,
  FISSUE_TEAM_ID     VARCHAR2(32) not null,
  FISSUE_TEAM_NAME   VARCHAR2(100) not null,
  FISSUE_USER_ID     VARCHAR2(32) not null,
  FISSUE_NICKNAME    VARCHAR2(40) not null,
  FISSUE_DESC        VARCHAR2(256),
  FVERSION           NUMBER(6) default 0 not null,
  FLOGCBY            VARCHAR2(32) not null,
  FLOGCDATE          timestamp not null,
  FLOGLUBY           VARCHAR2(32) not null,
  FLOGLUDATE         timestamp not null,
  FLOGLABY           VARCHAR2(32) not null,
  FLOGLADATE         timestamp not null
)
;
alter table FXP.P_DEV_ISSUE_PERSON
  add constraint PK_P_DEV_ISSUE_PERSON primary key (FISSUE_ID);
alter table FXP.P_DEV_ISSUE_PERSON
  add constraint UK_P_DEV_ISSUE_PERSON_PERSON unique (FDEVICE_ID, FUSER_NO);
alter table FXP.P_DEV_ISSUE_PERSON
  add constraint UK_P_DEV_ISSUE_PERSON_SN unique (FDEVICE_SN, FDEVICE_TYPE_ID, FCOMPANY_ID, FDEVICE_MODEL_ID, FUSER_NO);
alter table FXP.P_DEV_ISSUE_PERSON
  add constraint FK_P_DEV_ISSUE_PERSON_CIRCLE foreign key (FCIRCLE_ID)
  references FXP.P_CIRCLE (FCIRCLE_ID);
alter table FXP.P_DEV_ISSUE_PERSON
  add constraint FK_P_DEV_ISSUE_PERSON_COM foreign key (FCOMPANY_ID)
  references FXP.P_DEVICE_COMPANY (FCOMPANY_ID);
alter table FXP.P_DEV_ISSUE_PERSON
  add constraint FK_P_DEV_ISSUE_PERSON_DEVICE foreign key (FDEVICE_ID)
  references FXP.P_DEVICE (FDEVICE_ID);
alter table FXP.P_DEV_ISSUE_PERSON
  add constraint FK_P_DEV_ISSUE_PERSON_MODEL foreign key (FDEVICE_MODEL_ID)
  references FXP.P_DEVICE_MODEL (FDEVICE_MODEL_ID);
alter table FXP.P_DEV_ISSUE_PERSON
  add constraint FK_P_DEV_ISSUE_PERSON_PERSON foreign key (FPERSON_ID)
  references FXP.P_PERSON (FPERSON_ID);
alter table FXP.P_DEV_ISSUE_PERSON
  add constraint FK_P_DEV_ISSUE_PERSON_TYPE foreign key (FDEVICE_TYPE_ID)
  references FXP.P_DEVICE_TYPE (FDEVICE_TYPE_ID);
alter table FXP.P_DEV_ISSUE_PERSON
  add constraint CK_P_DEV_ISSUE_PERSON_USER
  check (fmax_user >= fuser_no);
create index FXP.IDX_P_DEV_ISSUE_PERSON_PERSON on FXP.P_DEV_ISSUE_PERSON (FPERSON_ID);
create index FXP.IDX_P_DEV_ISSUE_PERSON_UUID on FXP.P_DEV_ISSUE_PERSON (FDEVICE_UUID);

--prompt
--prompt Creating table P_DEV_ISSUE_TEH
--prompt ==============================
--prompt
create table FXP.P_DEV_ISSUE_TEH
(
  FISSUE_ID          VARCHAR2(32) not null,
  FPERSON_ID         VARCHAR2(32) not null,
  FPERSON_NAME       VARCHAR2(50) not null,
  FDEVICE_ID         VARCHAR2(32) not null,
  FCOMPANY_ID        VARCHAR2(32) not null,
  FCOMPANY_NAME      VARCHAR2(30) not null,
  FDEVICE_MODEL_ID   VARCHAR2(32) not null,
  FDEVICE_MODEL_NAME VARCHAR2(50) not null,
  FDEVICE_SN         VARCHAR2(32) not null,
  FDEVICE_IMEI       VARCHAR2(32) not null,
  FDEVICE_SIM        VARCHAR2(32),
  FPRODUCTION_DATE   timestamp,
  FPURCHASE_DATE     timestamp,
  FDEVICE_DESC       VARCHAR2(256),
  FCIRCLE_ID         VARCHAR2(32),
  FISSUE_DATE        timestamp not null,
  FISSUE_CIRCLE_ID   VARCHAR2(32) not null,
  FISSUE_TEAM_ID     VARCHAR2(32) not null,
  FISSUE_TEAM_NAME   VARCHAR2(100) not null,
  FISSUE_USER_ID     VARCHAR2(32) not null,
  FISSUE_NICKNAME    VARCHAR2(40) not null,
  FISSUE_DESC        VARCHAR2(256),
  FVERSION           NUMBER(6) default 0 not null,
  FLOGCBY            VARCHAR2(32) not null,
  FLOGCDATE          timestamp not null,
  FLOGLUBY           VARCHAR2(32) not null,
  FLOGLUDATE         timestamp not null,
  FLOGLABY           VARCHAR2(32) not null,
  FLOGLADATE         timestamp not null
)
;
alter table FXP.P_DEV_ISSUE_TEH
  add constraint PK_P_DEV_ISSUE_TEH primary key (FISSUE_ID);
alter table FXP.P_DEV_ISSUE_TEH
  add constraint UK_P_DEV_ISSUE_TEH_DEVICE unique (FDEVICE_ID);
alter table FXP.P_DEV_ISSUE_TEH
  add constraint UK_P_DEV_ISSUE_TEH_PERSON unique (FPERSON_ID);
alter table FXP.P_DEV_ISSUE_TEH
  add constraint UK_P_DEV_ISSUE_TEH_SN unique (FDEVICE_SN, FCOMPANY_ID, FDEVICE_MODEL_ID);
alter table FXP.P_DEV_ISSUE_TEH
  add constraint FK_P_DEV_ISSUE_TEH_CIR foreign key (FCIRCLE_ID)
  references FXP.P_CIRCLE (FCIRCLE_ID);
alter table FXP.P_DEV_ISSUE_TEH
  add constraint FK_P_DEV_ISSUE_TEH_COM foreign key (FCOMPANY_ID)
  references FXP.P_DEVICE_COMPANY (FCOMPANY_ID);
alter table FXP.P_DEV_ISSUE_TEH
  add constraint FK_P_DEV_ISSUE_TEH_DEV foreign key (FDEVICE_ID)
  references FXP.P_DEVICE (FDEVICE_ID);
alter table FXP.P_DEV_ISSUE_TEH
  add constraint FK_P_DEV_ISSUE_TEH_MOD foreign key (FDEVICE_MODEL_ID)
  references FXP.P_DEVICE_MODEL (FDEVICE_MODEL_ID);
alter table FXP.P_DEV_ISSUE_TEH
  add constraint FK_P_DEV_ISSUE_TEH_PER foreign key (FPERSON_ID)
  references FXP.P_PERSON (FPERSON_ID);

--prompt
--prompt Creating table P_DEV_ISSUE_WRISTBAND
--prompt ====================================
--prompt
create table FXP.P_DEV_ISSUE_WRISTBAND
(
  FISSUE_ID          VARCHAR2(32) not null,
  FPERSON_ID         VARCHAR2(32) not null,
  FPERSON_NAME       VARCHAR2(50) not null,
  FDEVICE_ID         VARCHAR2(32) not null,
  FCOMPANY_ID        VARCHAR2(32) not null,
  FCOMPANY_NAME      VARCHAR2(30) not null,
  FDEVICE_MODEL_ID   VARCHAR2(32) not null,
  FDEVICE_MODEL_NAME VARCHAR2(50) not null,
  FDEVICE_SN         VARCHAR2(32) not null,
  FDEVICE_UUID       VARCHAR2(32),
  FPRODUCTION_DATE   timestamp,
  FPURCHASE_DATE     timestamp,
  FDEVICE_DESC       VARCHAR2(256),
  FCIRCLE_ID         VARCHAR2(32),
  FISSUE_DATE        timestamp not null,
  FISSUE_CIRCLE_ID   VARCHAR2(32) not null,
  FISSUE_TEAM_ID     VARCHAR2(32) not null,
  FISSUE_TEAM_NAME   VARCHAR2(100) not null,
  FISSUE_USER_ID     VARCHAR2(32) not null,
  FISSUE_NICKNAME    VARCHAR2(40) not null,
  FISSUE_DESC        VARCHAR2(256),
  FVERSION           NUMBER(6) default 0 not null,
  FLOGCBY            VARCHAR2(32) not null,
  FLOGCDATE          timestamp not null,
  FLOGLUBY           VARCHAR2(32) not null,
  FLOGLUDATE         timestamp not null,
  FLOGLABY           VARCHAR2(32) not null,
  FLOGLADATE         timestamp not null
)
;
alter table FXP.P_DEV_ISSUE_WRISTBAND
  add constraint PK_P_DEV_ISSUE_WRISTBAND primary key (FISSUE_ID);
alter table FXP.P_DEV_ISSUE_WRISTBAND
  add constraint UK_P_DEV_ISSUE_WRIS_DEVICE unique (FDEVICE_ID);
alter table FXP.P_DEV_ISSUE_WRISTBAND
  add constraint UK_P_DEV_ISSUE_WRIS_PERSON unique (FPERSON_ID);
alter table FXP.P_DEV_ISSUE_WRISTBAND
  add constraint UK_P_DEV_ISSUE_WRIS_SN unique (FDEVICE_SN, FCOMPANY_ID, FDEVICE_MODEL_ID);
alter table FXP.P_DEV_ISSUE_WRISTBAND
  add constraint UK_P_DEV_ISSUE_WRIS_UUID unique (FDEVICE_UUID);
alter table FXP.P_DEV_ISSUE_WRISTBAND
  add constraint FK_P_DEV_ISSUE_WRISTBAND_CIR foreign key (FCIRCLE_ID)
  references FXP.P_CIRCLE (FCIRCLE_ID);
alter table FXP.P_DEV_ISSUE_WRISTBAND
  add constraint FK_P_DEV_ISSUE_WRISTBAND_COM foreign key (FCOMPANY_ID)
  references FXP.P_DEVICE_COMPANY (FCOMPANY_ID);
alter table FXP.P_DEV_ISSUE_WRISTBAND
  add constraint FK_P_DEV_ISSUE_WRISTBAND_DEV foreign key (FDEVICE_ID)
  references FXP.P_DEVICE (FDEVICE_ID);
alter table FXP.P_DEV_ISSUE_WRISTBAND
  add constraint FK_P_DEV_ISSUE_WRISTBAND_MOD foreign key (FDEVICE_MODEL_ID)
  references FXP.P_DEVICE_MODEL (FDEVICE_MODEL_ID);
alter table FXP.P_DEV_ISSUE_WRISTBAND
  add constraint FK_P_DEV_ISSUE_WRISTBAND_PER foreign key (FPERSON_ID)
  references FXP.P_PERSON (FPERSON_ID);

--prompt
--prompt Creating table P_DEV_RECYCLE_FAMILY
--prompt ===================================
--prompt
create table FXP.P_DEV_RECYCLE_FAMILY
(
  FRECYCLE_ID        VARCHAR2(32) not null,
  FFAMILY_ID         VARCHAR2(32) not null,
  FDEVICE_ID         VARCHAR2(32) not null,
  FDEVICE_TYPE_ID    VARCHAR2(32) not null,
  FDEVICE_TYPE_NAME  VARCHAR2(50) not null,
  FCOMPANY_ID        VARCHAR2(32) not null,
  FCOMPANY_NAME      VARCHAR2(30) not null,
  FDEVICE_MODEL_ID   VARCHAR2(32) not null,
  FDEVICE_MODEL_NAME VARCHAR2(50) not null,
  FDEVICE_SN         VARCHAR2(32) not null,
  FDEVICE_UUID       VARCHAR2(32),
  FPRODUCTION_DATE   timestamp,
  FPURCHASE_DATE     timestamp,
  FDEVICE_DESC       VARCHAR2(256),
  FCIRCLE_ID         VARCHAR2(32),
  FISSUE_DATE        timestamp not null,
  FISSUE_CIRCLE_ID   VARCHAR2(32) not null,
  FISSUE_TEAM_ID     VARCHAR2(32) not null,
  FISSUE_TEAM_NAME   VARCHAR2(100) not null,
  FISSUE_USER_ID     VARCHAR2(32) not null,
  FISSUE_NICKNAME    VARCHAR2(40) not null,
  FISSUE_DESC        VARCHAR2(256),
  FRECYCLE_DATE      timestamp not null,
  FRECYCLE_CIRCLE_ID VARCHAR2(32) not null,
  FRECYCLE_TEAM_ID   VARCHAR2(32) not null,
  FRECYCLE_USER_ID   VARCHAR2(32) not null,
  FRECYCLE_NICKNAME  VARCHAR2(40) not null,
  FRECYCLE_DESC      VARCHAR2(256),
  FVERSION           NUMBER(6) default 0 not null,
  FLOGCBY            VARCHAR2(32) not null,
  FLOGCDATE          timestamp not null,
  FLOGLUBY           VARCHAR2(32) not null,
  FLOGLUDATE         timestamp not null,
  FLOGLABY           VARCHAR2(32) not null,
  FLOGLADATE         timestamp not null
)
;
alter table FXP.P_DEV_RECYCLE_FAMILY
  add constraint PK_P_DEV_RECYCLE_FAMILY primary key (FRECYCLE_ID);
create index FXP.IDX_P_DEV_RECYCLE_FAMILY_FAM on FXP.P_DEV_RECYCLE_FAMILY (FFAMILY_ID);
create index FXP.IDX_P_DEV_RECYCLE_FAMILY_SN on FXP.P_DEV_RECYCLE_FAMILY (FDEVICE_SN);

--prompt
--prompt Creating table P_DEV_RECYCLE_PERSON
--prompt ===================================
--prompt
create table FXP.P_DEV_RECYCLE_PERSON
(
  FRECYCLE_ID        VARCHAR2(32) not null,
  FPERSON_ID         VARCHAR2(32) not null,
  FPERSON_NAME       VARCHAR2(50) not null,
  FDEVICE_ID         VARCHAR2(32) not null,
  FDEVICE_TYPE_ID    VARCHAR2(32) not null,
  FDEVICE_TYPE_NAME  VARCHAR2(50) not null,
  FCOMPANY_ID        VARCHAR2(32) not null,
  FCOMPANY_NAME      VARCHAR2(30) not null,
  FDEVICE_MODEL_ID   VARCHAR2(32) not null,
  FDEVICE_MODEL_NAME VARCHAR2(50) not null,
  FMAX_USER          NUMBER(3) not null,
  FDEVICE_SN         VARCHAR2(32) not null,
  FDEVICE_UUID       VARCHAR2(32),
  FPRODUCTION_DATE   timestamp,
  FPURCHASE_DATE     timestamp,
  FUSER_NO           NUMBER(3) not null,
  FDEVICE_DESC       VARCHAR2(256),
  FCIRCLE_ID         VARCHAR2(32),
  FISSUE_DATE        timestamp not null,
  FISSUE_CIRCLE_ID   VARCHAR2(32) not null,
  FISSUE_TEAM_ID     VARCHAR2(32) not null,
  FISSUE_TEAM_NAME   VARCHAR2(100) not null,
  FISSUE_USER_ID     VARCHAR2(32) not null,
  FISSUE_NICKNAME    VARCHAR2(40) not null,
  FISSUE_DESC        VARCHAR2(256),
  FRECYCLE_DATE      timestamp not null,
  FRECYCLE_CIRCLE_ID VARCHAR2(32) not null,
  FRECYCLE_TEAM_ID   VARCHAR2(32) not null,
  FRECYCLE_USER_ID   VARCHAR2(32) not null,
  FRECYCLE_NICKNAME  VARCHAR2(40) not null,
  FRECYCLE_DESC      VARCHAR2(256),
  FVERSION           NUMBER(6) default 0 not null,
  FLOGCBY            VARCHAR2(32) not null,
  FLOGCDATE          timestamp not null,
  FLOGLUBY           VARCHAR2(32) not null,
  FLOGLUDATE         timestamp not null,
  FLOGLABY           VARCHAR2(32) not null,
  FLOGLADATE         timestamp not null
)
;
alter table FXP.P_DEV_RECYCLE_PERSON
  add constraint PK_P_DEV_RECYCLE_PERSON primary key (FRECYCLE_ID);
alter table FXP.P_DEV_RECYCLE_PERSON
  add constraint FK_P_DEV_RECYCLE_PERSON foreign key (FPERSON_ID)
  references FXP.P_PERSON (FPERSON_ID);
create index FXP.IDX_P_DEV_RECYCLE_PERSON_PER on FXP.P_DEV_RECYCLE_PERSON (FPERSON_ID);
create index FXP.IDX_P_DEV_RECYCLE_PERSON_SN on FXP.P_DEV_RECYCLE_PERSON (FDEVICE_SN);

--prompt
--prompt Creating table P_DEV_USER_IDCARD
--prompt ================================
--prompt
create table FXP.P_DEV_USER_IDCARD
(
  FUSER_ID   VARCHAR2(32) not null,
  FUSER_NAME VARCHAR2(50) not null,
  FDEVICE_SN VARCHAR2(32) not null,
  FBIND_DATE timestamp not null,
  FVERSION   NUMBER(6) default 0 not null,
  FLOGCBY    VARCHAR2(32) not null,
  FLOGCDATE  timestamp not null,
  FLOGLUBY   VARCHAR2(32) not null,
  FLOGLUDATE timestamp not null,
  FLOGLABY   VARCHAR2(32) not null,
  FLOGLADATE timestamp not null
)
;
alter table FXP.P_DEV_USER_IDCARD
  add constraint PK_P_DEV_USER_IDCARD primary key (FUSER_ID);
alter table FXP.P_DEV_USER_IDCARD
  add constraint FK_P_DEV_USER_IDCARD_USER foreign key (FUSER_ID)
  references FXP.P_USER (FUSER_ID);

--prompt
--prompt Creating table P_DISEASE_CLASS
--prompt ==============================
--prompt
create table FXP.P_DISEASE_CLASS
(
  FDISEASE_CLASS_ID   VARCHAR2(32) not null,
  FDISEASE_CLASS_CODE VARCHAR2(8) not null,
  FDISEASE_CLASS_NAME VARCHAR2(60) not null,
  FDISEASE_CLASS_DESC VARCHAR2(256),
  FVERSION            NUMBER(6) default 0 not null,
  FLOGCBY             VARCHAR2(32) not null,
  FLOGCDATE           timestamp not null,
  FLOGLUBY            VARCHAR2(32) not null,
  FLOGLUDATE          timestamp not null,
  FLOGLABY            VARCHAR2(32) not null,
  FLOGLADATE          timestamp not null
)
;
alter table FXP.P_DISEASE_CLASS
  add constraint PK_P_DISEASE_CLASS primary key (FDISEASE_CLASS_ID);
alter table FXP.P_DISEASE_CLASS
  add constraint UK_P_DISEASE_CLASS_CODE unique (FDISEASE_CLASS_CODE);

--prompt
--prompt Creating table P_DISEASE
--prompt ========================
--prompt
create table FXP.P_DISEASE
(
  FDISEASE_ID         VARCHAR2(32) not null,
  FDISEASE_CODE       VARCHAR2(20) not null,
  FDISEASE_NAME       VARCHAR2(100) not null,
  FDISEASE_CLASS_ID   VARCHAR2(32) not null,
  FDISEASE_CLASS_NAME VARCHAR2(60) not null,
  FISOTHER            CHAR(1) not null,
  FISDISEASE          CHAR(1) not null,
  FIS_HG_USE          CHAR(1) not null,
  FIS_SF_USE          CHAR(1) not null,
  FIS_HMO_USE         CHAR(1) not null,
  FDISEASE_DESC       VARCHAR2(256),
  FVERSION            NUMBER(6) default 0 not null,
  FLOGCBY             VARCHAR2(32) not null,
  FLOGCDATE           timestamp not null,
  FLOGLUBY            VARCHAR2(32) not null,
  FLOGLUDATE          timestamp not null,
  FLOGLABY            VARCHAR2(32) not null,
  FLOGLADATE          timestamp not null
)
;
alter table FXP.P_DISEASE
  add constraint PK_P_DISEASE primary key (FDISEASE_ID);
alter table FXP.P_DISEASE
  add constraint UK_P_DISEASE_CODE unique (FDISEASE_CODE);
alter table FXP.P_DISEASE
  add constraint FK_P_DISEASE_CLASS foreign key (FDISEASE_CLASS_ID)
  references FXP.P_DISEASE_CLASS (FDISEASE_CLASS_ID);

--prompt
--prompt Creating table P_DISEASE_GUIDE
--prompt ==============================
--prompt
create table FXP.P_DISEASE_GUIDE
(
  FDISEASE_ID     VARCHAR2(32) not null,
  FFOOD_GUIDE     VARCHAR2(2000),
  FSPORTS_GUIDE   VARCHAR2(2000),
  FPSYCH_GUIDE    VARCHAR2(2000),
  FSLEEP_GUIDE    VARCHAR2(2000),
  FMEDICINE_GUIDE VARCHAR2(2000),
  FOTHER_GUIDE    VARCHAR2(2000),
  FDESC           VARCHAR2(256),
  FVERSION        NUMBER(6) default 0 not null,
  FLOGCBY         VARCHAR2(32) not null,
  FLOGCDATE       timestamp not null,
  FLOGLUBY        VARCHAR2(32) not null,
  FLOGLUDATE      timestamp not null,
  FLOGLABY        VARCHAR2(32) not null,
  FLOGLADATE      timestamp not null
)
;
alter table FXP.P_DISEASE_GUIDE
  add constraint PK_P_DISEASE_GUIDE primary key (FDISEASE_ID);
alter table FXP.P_DISEASE_GUIDE
  add constraint FK_P_DISEASE_GUIDE_DISEASE foreign key (FDISEASE_ID)
  references FXP.P_DISEASE (FDISEASE_ID);

--prompt
--prompt Creating table P_DISEASE_SMS
--prompt ============================
--prompt
create table FXP.P_DISEASE_SMS
(
  FDISEASE_ID VARCHAR2(32) not null,
  FGUIDE_SMS  VARCHAR2(2000) not null,
  FDESC       VARCHAR2(256),
  FVERSION    NUMBER(6) default 0 not null,
  FLOGCBY     VARCHAR2(32) not null,
  FLOGCDATE   timestamp not null,
  FLOGLUBY    VARCHAR2(32) not null,
  FLOGLUDATE  timestamp not null,
  FLOGLABY    VARCHAR2(32) not null,
  FLOGLADATE  timestamp not null
)
;
alter table FXP.P_DISEASE_SMS
  add constraint PK_P_DISEASE_SMS primary key (FDISEASE_ID);
alter table FXP.P_DISEASE_SMS
  add constraint FK_P_DISEASE_SMS_DISEASE foreign key (FDISEASE_ID)
  references FXP.P_DISEASE (FDISEASE_ID);

--prompt
--prompt Creating table P_DISEASE_SYMPTOM
--prompt ================================
--prompt
create table FXP.P_DISEASE_SYMPTOM
(
  FSYMPTOM_ID   VARCHAR2(32) not null,
  FDISEASE_ID   VARCHAR2(32) not null,
  FSYMPTOM_CODE VARCHAR2(30) not null,
  FSYMPTOM_NAME VARCHAR2(80) not null,
  FISOTHER      CHAR(1) not null,
  FISAVAILABLE  CHAR(1) not null,
  FSYMPTOM_DESC VARCHAR2(256),
  FVERSION      NUMBER(6) default 0 not null,
  FLOGCBY       VARCHAR2(32) not null,
  FLOGCDATE     timestamp not null,
  FLOGLUBY      VARCHAR2(32) not null,
  FLOGLUDATE    timestamp not null,
  FLOGLABY      VARCHAR2(32) not null,
  FLOGLADATE    timestamp not null
)
;
alter table FXP.P_DISEASE_SYMPTOM
  add constraint PK_P_DISEASE_SYMPTOM primary key (FSYMPTOM_ID);
alter table FXP.P_DISEASE_SYMPTOM
  add constraint UK_P_DISEASE_SYMPTOM unique (FDISEASE_ID, FSYMPTOM_CODE);
alter table FXP.P_DISEASE_SYMPTOM
  add constraint FK_P_DISEASE_SYMPTOM_DISEASE foreign key (FDISEASE_ID)
  references FXP.P_DISEASE (FDISEASE_ID);

--prompt
--prompt Creating table P_FAMILY_CALL_IDENTIFY
--prompt =====================================
--prompt
create table FXP.P_FAMILY_CALL_IDENTIFY
(
  FPHONE_NUMBER VARCHAR2(30) not null,
  FFAMILY_ID    VARCHAR2(32) not null,
  FIS_DEFAULT   CHAR(1) default 'Y' not null,
  FCREATE_DATE  timestamp not null,
  FVERSION      NUMBER(6) default 0 not null,
  FLOGCBY       VARCHAR2(32) not null,
  FLOGCDATE     timestamp not null,
  FLOGLUBY      VARCHAR2(32) not null,
  FLOGLUDATE    timestamp not null,
  FLOGLABY      VARCHAR2(32) not null,
  FLOGLADATE    timestamp not null
)
;
alter table FXP.P_FAMILY_CALL_IDENTIFY
  add constraint PK_P_FAMILY_CALL_IDENTIFY primary key (FPHONE_NUMBER, FFAMILY_ID);
alter table FXP.P_FAMILY_CALL_IDENTIFY
  add constraint FK_P_FAMILY_CALL_IDENTIFY_FAM foreign key (FFAMILY_ID)
  references FXP.P_FAMILY (FFAMILY_ID);

--prompt
--prompt Creating table P_PERSON_RELATION
--prompt ================================
--prompt
create table FXP.P_PERSON_RELATION
(
  FPERSON_RELATION_ID     VARCHAR2(32) not null,
  FPERSON_RELATION_CODE   VARCHAR2(8) not null,
  FPERSON_RELATION_GBCODE VARCHAR2(32),
  FPERSON_RELATION_NAME   VARCHAR2(40) not null,
  FISAVAILABLE            CHAR(1) not null,
  FORDERNUM               NUMBER(6,2) not null,
  FPERSON_RELATION_DESC   VARCHAR2(256),
  FVERSION                NUMBER(6) default 0 not null,
  FLOGCBY                 VARCHAR2(32) not null,
  FLOGCDATE               timestamp not null,
  FLOGLUBY                VARCHAR2(32) not null,
  FLOGLUDATE              timestamp not null,
  FLOGLABY                VARCHAR2(32) not null,
  FLOGLADATE              timestamp not null
)
;
alter table FXP.P_PERSON_RELATION
  add constraint PK_P_PERSON_RELATION primary key (FPERSON_RELATION_ID);
alter table FXP.P_PERSON_RELATION
  add constraint UK_P_PERSON_RELATION_CODE unique (FPERSON_RELATION_CODE);

--prompt
--prompt Creating table P_FAMILY_CONTACTS
--prompt ================================
--prompt
create table FXP.P_FAMILY_CONTACTS
(
  FCONTACT_ID           VARCHAR2(32) not null,
  FCONTACT_NAME         VARCHAR2(40) not null,
  FFAMILY_ID            VARCHAR2(32) not null,
  FFAMILY_RELATION_ID   VARCHAR2(32) not null,
  FFAMILY_RELATION_NAME VARCHAR2(30) not null,
  FUSER_ID              VARCHAR2(32),
  FADDRESS              VARCHAR2(200),
  FCONTACT_PHONE        VARCHAR2(40),
  FMOBILE               VARCHAR2(40),
  FIS_EMERGENCY         CHAR(1) not null,
  FCREATE_DATE          timestamp not null,
  FCONTACT_DESC         VARCHAR2(256),
  FVERSION              NUMBER(6) default 0 not null,
  FLOGCBY               VARCHAR2(32) not null,
  FLOGCDATE             timestamp not null,
  FLOGLUBY              VARCHAR2(32) not null,
  FLOGLUDATE            timestamp not null,
  FLOGLABY              VARCHAR2(32) not null,
  FLOGLADATE            timestamp not null
)
;
alter table FXP.P_FAMILY_CONTACTS
  add constraint PK_P_FAMILY_CONTACTS primary key (FCONTACT_ID);
alter table FXP.P_FAMILY_CONTACTS
  add constraint UK_P_FAMILY_CONTACTS unique (FFAMILY_ID, FCONTACT_NAME);
alter table FXP.P_FAMILY_CONTACTS
  add constraint FK_P_FAMILY_CONTACTS_FAMILY foreign key (FFAMILY_ID)
  references FXP.P_FAMILY (FFAMILY_ID);
alter table FXP.P_FAMILY_CONTACTS
  add constraint FK_P_FAMILY_CONTACTS_RELA foreign key (FFAMILY_RELATION_ID)
  references FXP.P_PERSON_RELATION (FPERSON_RELATION_ID);

--prompt
--prompt Creating table P_FAMILY_FOLLOW
--prompt ==============================
--prompt
create table FXP.P_FAMILY_FOLLOW
(
  FFAMILY_ID   VARCHAR2(32) not null,
  FUSER_ID     VARCHAR2(32) not null,
  FCREATE_DATE timestamp not null,
  FVERSION     NUMBER(6) default 0 not null,
  FLOGCBY      VARCHAR2(32) not null,
  FLOGCDATE    timestamp not null,
  FLOGLUBY     VARCHAR2(32) not null,
  FLOGLUDATE   timestamp not null,
  FLOGLABY     VARCHAR2(32) not null,
  FLOGLADATE   timestamp not null
)
;
alter table FXP.P_FAMILY_FOLLOW
  add constraint PK_P_FAMILY_FOLLOW primary key (FFAMILY_ID, FUSER_ID);
alter table FXP.P_FAMILY_FOLLOW
  add constraint FK_P_FAMILY_FOLLOW_FAMILY foreign key (FFAMILY_ID)
  references FXP.P_FAMILY (FFAMILY_ID);
alter table FXP.P_FAMILY_FOLLOW
  add constraint FK_P_FAMILY_FOLLOW_USER foreign key (FUSER_ID)
  references FXP.P_USER (FUSER_ID);

--prompt
--prompt Creating table P_LIFE_ITEM
--prompt ==========================
--prompt
create table FXP.P_LIFE_ITEM
(
  FLIFE_ITEM_ID     VARCHAR2(32) not null,
  FLIFE_ITEM_CODE   VARCHAR2(8) not null,
  FLIFE_ITEM_GBCODE VARCHAR2(32),
  FLIFE_ITEM_NAME   VARCHAR2(60) not null,
  FISAVAILABLE      CHAR(1) not null,
  FORDERNUM         NUMBER(6,2) not null,
  FLIFE_ITEM_DESC   VARCHAR2(256),
  FVERSION          NUMBER(6) default 0 not null,
  FLOGCBY           VARCHAR2(32) not null,
  FLOGCDATE         timestamp not null,
  FLOGLUBY          VARCHAR2(32) not null,
  FLOGLUDATE        timestamp not null,
  FLOGLABY          VARCHAR2(32) not null,
  FLOGLADATE        timestamp not null
)
;
alter table FXP.P_LIFE_ITEM
  add constraint PK_P_LIFE_ITEM primary key (FLIFE_ITEM_ID);
alter table FXP.P_LIFE_ITEM
  add constraint UK_P_LIFE_ITEM unique (FLIFE_ITEM_CODE);

--prompt
--prompt Creating table P_FAMILY_LIFE
--prompt ============================
--prompt
create table FXP.P_FAMILY_LIFE
(
  FLIFE_ID        VARCHAR2(32) not null,
  FCONTACT_NAME   VARCHAR2(100) not null,
  FFAMILY_ID      VARCHAR2(32) not null,
  FLIFE_ITEM_ID   VARCHAR2(32) not null,
  FLIFE_ITEM_NAME VARCHAR2(60) not null,
  FADDRESS        VARCHAR2(100),
  FCONTACT_PHONE  VARCHAR2(40),
  FSITE_ID        VARCHAR2(32),
  FSITE_NAME      VARCHAR2(100),
  FORDERNUM       NUMBER(6,2) not null,
  FCONTACT_DESC   VARCHAR2(256),
  FVERSION        NUMBER(6) default 0 not null,
  FLOGCBY         VARCHAR2(32) not null,
  FLOGCDATE       timestamp not null,
  FLOGLUBY        VARCHAR2(32) not null,
  FLOGLUDATE      timestamp not null,
  FLOGLABY        VARCHAR2(32) not null,
  FLOGLADATE      timestamp not null
)
;
alter table FXP.P_FAMILY_LIFE
  add constraint PK_P_FAMILY_LIFE primary key (FLIFE_ID);
alter table FXP.P_FAMILY_LIFE
  add constraint FK_P_FAMILY_LIFE_FAMILY foreign key (FFAMILY_ID)
  references FXP.P_FAMILY (FFAMILY_ID);
alter table FXP.P_FAMILY_LIFE
  add constraint FK_P_FAMILY_LIFE_ITEM foreign key (FLIFE_ITEM_ID)
  references FXP.P_LIFE_ITEM (FLIFE_ITEM_ID);
create index FXP.IDX_P_FAMILY_LIFE1 on FXP.P_FAMILY_LIFE (FFAMILY_ID);

--prompt
--prompt Creating table P_LIVING_CONDI
--prompt =============================
--prompt
create table FXP.P_LIVING_CONDI
(
  FLIVING_CONDI_ID     VARCHAR2(32) not null,
  FLIVING_CONDI_CODE   VARCHAR2(8) not null,
  FLIVING_CONDI_GBCODE VARCHAR2(32),
  FLIVING_CONDI_NAME   VARCHAR2(40) not null,
  FISAVAILABLE         CHAR(1) not null,
  FORDERNUM            NUMBER(6,2) not null,
  FLIVING_CONDI_DESC   VARCHAR2(256),
  FVERSION             NUMBER(6) default 0 not null,
  FLOGCBY              VARCHAR2(32) not null,
  FLOGCDATE            timestamp default sysdate not null,
  FLOGLUBY             VARCHAR2(32) not null,
  FLOGLUDATE           timestamp default sysdate not null,
  FLOGLABY             VARCHAR2(32) not null,
  FLOGLADATE           timestamp default sysdate not null
)
;
alter table FXP.P_LIVING_CONDI
  add constraint PK_P_LIVING_CONDI primary key (FLIVING_CONDI_ID);
alter table FXP.P_LIVING_CONDI
  add constraint UK_P_LIVING_CONDI_CODE unique (FLIVING_CONDI_CODE);

--prompt
--prompt Creating table P_FAMILY_LIVING_CONDI
--prompt ====================================
--prompt
create table FXP.P_FAMILY_LIVING_CONDI
(
  FPK_ID             VARCHAR2(32) not null,
  FLIVING_CONDI_ID   VARCHAR2(32) not null,
  FLIVING_CONDI_NAME VARCHAR2(40) not null,
  FFAMILY_ID         VARCHAR2(32) not null,
  FORDERNUM          NUMBER(6,2) not null,
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
alter table FXP.P_FAMILY_LIVING_CONDI
  add constraint PK_P_FAMILY_LIVING_CONDI primary key (FPK_ID);
alter table FXP.P_FAMILY_LIVING_CONDI
  add constraint UK_P_FAMILY_LIVING_CONDI unique (FFAMILY_ID, FLIVING_CONDI_ID);
alter table FXP.P_FAMILY_LIVING_CONDI
  add constraint FK_P_FAMILY_LIVING_CONDI_CONDI foreign key (FLIVING_CONDI_ID)
  references FXP.P_LIVING_CONDI (FLIVING_CONDI_ID);
alter table FXP.P_FAMILY_LIVING_CONDI
  add constraint FK_P_FAMILY_LIVING_CONDI_FAMI foreign key (FFAMILY_ID)
  references FXP.P_FAMILY (FFAMILY_ID);
create index FXP.IDX_P_FAMILY_LIVING_CONDI1 on FXP.P_FAMILY_LIVING_CONDI (FFAMILY_ID);

--prompt
--prompt Creating table P_FAMILY_RELATION
--prompt ================================
--prompt
create table FXP.P_FAMILY_RELATION
(
  FFAMILY_RELATION_ID     VARCHAR2(32) not null,
  FFAMILY_RELATION_CODE   VARCHAR2(8) not null,
  FFAMILY_RELATION_GBCODE VARCHAR2(32),
  FFAMILY_RELATION_NAME   VARCHAR2(40) not null,
  FRELATION_CLASS         VARCHAR2(20) not null,
  FISAVAILABLE            CHAR(1) not null,
  FORDERNUM               NUMBER(6,2) not null,
  FFAMILY_RELATION_DESC   VARCHAR2(256),
  FVERSION                NUMBER(6) default 0 not null,
  FLOGCBY                 VARCHAR2(32) not null,
  FLOGCDATE               timestamp not null,
  FLOGLUBY                VARCHAR2(32) not null,
  FLOGLUDATE              timestamp not null,
  FLOGLABY                VARCHAR2(32) not null,
  FLOGLADATE              timestamp not null
)
;
alter table FXP.P_FAMILY_RELATION
  add constraint PK_P_FAMILY_RELATION primary key (FFAMILY_RELATION_ID);
alter table FXP.P_FAMILY_RELATION
  add constraint UK_P_FAMILY_RELATION unique (FFAMILY_RELATION_CODE);

--prompt
--prompt Creating table P_FAMILY_SOCIETY
--prompt ===============================
--prompt
create table FXP.P_FAMILY_SOCIETY
(
  FCONTACT_ID           VARCHAR2(32) not null,
  FCONTACT_NAME         VARCHAR2(40) not null,
  FFAMILY_ID            VARCHAR2(32) not null,
  FFAMILY_RELATION_ID   VARCHAR2(32),
  FFAMILY_RELATION_NAME VARCHAR2(30),
  FCONTACT_PHONE        VARCHAR2(40),
  FORDERNUM             NUMBER(6,2) not null,
  FCONTACT_DESC         VARCHAR2(256),
  FVERSION              NUMBER(6) default 0 not null,
  FLOGCBY               VARCHAR2(32) not null,
  FLOGCDATE             timestamp not null,
  FLOGLUBY              VARCHAR2(32) not null,
  FLOGLUDATE            timestamp not null,
  FLOGLABY              VARCHAR2(32) not null,
  FLOGLADATE            timestamp not null
)
;
alter table FXP.P_FAMILY_SOCIETY
  add constraint PK_P_FAMILY_SOCIETY primary key (FCONTACT_ID);
alter table FXP.P_FAMILY_SOCIETY
  add constraint UK_P_FAMILY_SOCIETY unique (FFAMILY_ID, FCONTACT_NAME);
alter table FXP.P_FAMILY_SOCIETY
  add constraint FK_P_FAMILY_SOCIETY_FAMILY foreign key (FFAMILY_ID)
  references FXP.P_FAMILY (FFAMILY_ID);
alter table FXP.P_FAMILY_SOCIETY
  add constraint FK_P_FAMILY_SOCIETY_RELA foreign key (FFAMILY_RELATION_ID)
  references FXP.P_FAMILY_RELATION (FFAMILY_RELATION_ID);

--prompt
--prompt Creating table P_FAVORITE_FAMILY
--prompt ================================
--prompt
create table FXP.P_FAVORITE_FAMILY
(
  FUSER_ID       VARCHAR2(32) not null,
  FFAMILY_ID     VARCHAR2(32) not null,
  FFAMILY_MEMBER VARCHAR2(100),
  FCREATE_DATE   timestamp not null,
  FFAVORITE_DESC VARCHAR2(256),
  FVERSION       NUMBER(6) default 0 not null,
  FLOGCBY        VARCHAR2(32) not null,
  FLOGCDATE      timestamp not null,
  FLOGLUBY       VARCHAR2(32) not null,
  FLOGLUDATE     timestamp not null,
  FLOGLABY       VARCHAR2(32) not null,
  FLOGLADATE     timestamp not null
)
;
alter table FXP.P_FAVORITE_FAMILY
  add constraint PK_P_FAVORITE_FAMILY primary key (FUSER_ID, FFAMILY_ID);
alter table FXP.P_FAVORITE_FAMILY
  add constraint FK_P_FAVORITE_FAMILY_PERSON foreign key (FFAMILY_ID)
  references FXP.P_FAMILY (FFAMILY_ID);
alter table FXP.P_FAVORITE_FAMILY
  add constraint FK_P_FAVORITE_FAMILY_USER foreign key (FUSER_ID)
  references FXP.P_USER (FUSER_ID);

--prompt
--prompt Creating table P_FAVORITE_LINK
--prompt ==============================
--prompt
create table FXP.P_FAVORITE_LINK
(
  FFAVORITE_ID   VARCHAR2(32) not null,
  FUSER_ID       VARCHAR2(32) not null,
  FNOTE_TYPE_ID  VARCHAR2(30) not null,
  FNOTE_ID       VARCHAR2(150) not null,
  FLINK_TOPIC    VARCHAR2(100) not null,
  FLINK_URL      VARCHAR2(300) not null,
  FCREATE_TIME   timestamp not null,
  FFAVORITE_DESC VARCHAR2(256),
  FVERSION       NUMBER(6) default 0 not null,
  FLOGCBY        VARCHAR2(32) not null,
  FLOGCDATE      timestamp not null,
  FLOGLUBY       VARCHAR2(32) not null,
  FLOGLUDATE     timestamp not null,
  FLOGLABY       VARCHAR2(32) not null,
  FLOGLADATE     timestamp not null
)
;
alter table FXP.P_FAVORITE_LINK
  add constraint PK_P_FAVORITE_LINK primary key (FFAVORITE_ID);
alter table FXP.P_FAVORITE_LINK
  add constraint UK_P_FAVORITE_LINK unique (FUSER_ID, FNOTE_TYPE_ID, FNOTE_ID);
alter table FXP.P_FAVORITE_LINK
  add constraint FK_P_FAVORITE_LINK_USER foreign key (FUSER_ID)
  references FXP.P_USER (FUSER_ID);
create index FXP.IDX_P_FAVORITE_LINK_USER on FXP.P_FAVORITE_LINK (FUSER_ID);

--prompt
--prompt Creating table P_FAVORITE_MAP
--prompt =============================
--prompt
create table FXP.P_FAVORITE_MAP
(
  FUSER_ID            VARCHAR2(32) not null,
  FMAP_NAME           VARCHAR2(50) not null,
  FLOCATION_CITY      VARCHAR2(16),
  FLOCATION_ADDRESS   VARCHAR2(128),
  FLOCATION_LONGITUDE NUMBER(19,15),
  FLOCATION_LATITUDE  NUMBER(19,15),
  FCREATE_DATE        timestamp not null,
  FISDEFAULT          CHAR(1) not null,
  FFAVORITE_DESC      VARCHAR2(256),
  FVERSION            NUMBER(6) default 0 not null,
  FLOGCBY             VARCHAR2(32) not null,
  FLOGCDATE           timestamp not null,
  FLOGLUBY            VARCHAR2(32) not null,
  FLOGLUDATE          timestamp not null,
  FLOGLABY            VARCHAR2(32) not null,
  FLOGLADATE          timestamp not null
)
;
alter table FXP.P_FAVORITE_MAP
  add constraint PK_P_FAVORITE_MAP primary key (FUSER_ID, FMAP_NAME);
alter table FXP.P_FAVORITE_MAP
  add constraint FK_P_FAVORITE_MAP_USER foreign key (FUSER_ID)
  references FXP.P_USER (FUSER_ID);

--prompt
--prompt Creating table P_FAVORITE_PERSON
--prompt ================================
--prompt
create table FXP.P_FAVORITE_PERSON
(
  FUSER_ID       VARCHAR2(32) not null,
  FPERSON_ID     VARCHAR2(32) not null,
  FPERSON_NAME   VARCHAR2(50) not null,
  FCREATE_DATE   timestamp not null,
  FFAVORITE_DESC VARCHAR2(256),
  FVERSION       NUMBER(6) default 0 not null,
  FLOGCBY        VARCHAR2(32) not null,
  FLOGCDATE      timestamp not null,
  FLOGLUBY       VARCHAR2(32) not null,
  FLOGLUDATE     timestamp not null,
  FLOGLABY       VARCHAR2(32) not null,
  FLOGLADATE     timestamp not null
)
;
alter table FXP.P_FAVORITE_PERSON
  add constraint PK_P_FAVORITE_PERSON primary key (FUSER_ID, FPERSON_ID);
alter table FXP.P_FAVORITE_PERSON
  add constraint FK_P_FAVORITE_PERSON_PERSON foreign key (FPERSON_ID)
  references FXP.P_PERSON (FPERSON_ID);
alter table FXP.P_FAVORITE_PERSON
  add constraint FK_P_FAVORITE_PERSON_USER foreign key (FUSER_ID)
  references FXP.P_USER (FUSER_ID);

--prompt
--prompt Creating table P_FAVORITE_REGION
--prompt ================================
--prompt
create table FXP.P_FAVORITE_REGION
(
  FUSER_ID       VARCHAR2(32) not null,
  FREGION_ID     VARCHAR2(32) not null,
  FREGION_NAME   VARCHAR2(80) not null,
  FCREATE_DATE   timestamp not null,
  FFAVORITE_DESC VARCHAR2(256),
  FVERSION       NUMBER(6) default 0 not null,
  FLOGCBY        VARCHAR2(32) not null,
  FLOGCDATE      timestamp not null,
  FLOGLUBY       VARCHAR2(32) not null,
  FLOGLUDATE     timestamp not null,
  FLOGLABY       VARCHAR2(32) not null,
  FLOGLADATE     timestamp not null
)
;
alter table FXP.P_FAVORITE_REGION
  add constraint PK_P_FAVORITE_REGION primary key (FUSER_ID);
alter table FXP.P_FAVORITE_REGION
  add constraint FK_P_FAVORITE_REGION_USER foreign key (FUSER_ID)
  references FXP.P_USER (FUSER_ID);

--prompt
--prompt Creating table P_GLOBAL_BILL_NUM
--prompt ================================
--prompt
create table FXP.P_GLOBAL_BILL_NUM
(
  FBILL_TYPE_ID      VARCHAR2(32) not null,
  FSEQ_NAME          VARCHAR2(50) not null,
  FSEQ_INIT_MODE     VARCHAR2(20) not null,
  FSEQ_INIT_SYSDATE  timestamp not null,
  FSEQ_INIT_VAL      NUMBER(12) default 1 not null,
  FSEQ_START_VAL     NUMBER(9) default 1 not null,
  FSN_LEN            NUMBER(2) not null,
  FOUTPUT_EXPRESSION VARCHAR2(80) not null,
  FGLOBAL_BILL_DESC  VARCHAR2(256),
  FVERSION           NUMBER(6) default 0 not null,
  FLOGCBY            VARCHAR2(32) default 'admin' not null,
  FLOGCDATE          timestamp default sysdate not null,
  FLOGLUBY           VARCHAR2(32) default 'admin' not null,
  FLOGLUDATE         timestamp default sysdate not null,
  FLOGLABY           VARCHAR2(32) default 'admin' not null,
  FLOGLADATE         timestamp default sysdate not null
)
;
alter table FXP.P_GLOBAL_BILL_NUM
  add constraint PK_P_GLOBAL_BILL_NUM primary key (FBILL_TYPE_ID);
alter table FXP.P_GLOBAL_BILL_NUM
  add constraint UK_PK_P_GLOBAL_BILL_NUM unique (FSEQ_NAME);
alter table FXP.P_GLOBAL_BILL_NUM
  add constraint FK_P_GLOBAL_BILL_NUM foreign key (FBILL_TYPE_ID)
  references FXP.P_BILL_TYPE (FBILL_TYPE_ID);

--prompt
--prompt Creating table P_GOODS
--prompt ======================
--prompt
create table FXP.P_GOODS
(
  FGOODS_ID        VARCHAR2(32) not null,
  FGOODS_CODE      VARCHAR2(30) not null,
  FGOODS_NAME      VARCHAR2(100) not null,
  FBUSINESS_ID     VARCHAR2(32) not null,
  FGOODS_INFO      VARCHAR2(2000) not null,
  FGOODS_PRICE     NUMBER(10,2) not null,
  FGOODS_UNIT      VARCHAR2(30) not null,
  FGOODS_DESC      VARCHAR2(256),
  FCIRCLE_ID       VARCHAR2(32) not null,
  FCREATE_DATE     timestamp not null,
  FCREATE_USER_ID  VARCHAR2(32) not null,
  FCREATE_NICKNAME VARCHAR2(30) not null,
  FIS_CANCEL       CHAR(1) default 'N' not null,
  FCANCEL_REASON   VARCHAR2(100),
  FCANCEL_DATE     timestamp,
  FCANCEL_USER_ID  VARCHAR2(32),
  FCANCEL_NICKNAME VARCHAR2(40),
  FVERSION         NUMBER(6) default 0 not null,
  FLOGCBY          VARCHAR2(32) not null,
  FLOGCDATE        timestamp not null,
  FLOGLUBY         VARCHAR2(32) not null,
  FLOGLUDATE       timestamp not null,
  FLOGLABY         VARCHAR2(32) not null,
  FLOGLADATE       timestamp not null
)
;
alter table FXP.P_GOODS
  add constraint PK_P_GOODS primary key (FGOODS_ID);
alter table FXP.P_GOODS
  add constraint UK_P_GOODS unique (FCIRCLE_ID, FGOODS_CODE);
alter table FXP.P_GOODS
  add constraint FK_P_GOODS_BUSINESS foreign key (FBUSINESS_ID)
  references FXP.P_BUSINESS (FBUSINESS_ID);
alter table FXP.P_GOODS
  add constraint FK_P_GOODS_CIRCLE foreign key (FCIRCLE_ID)
  references FXP.P_CIRCLE (FCIRCLE_ID);

--prompt
--prompt Creating table P_PRODUCT_CLASS
--prompt ==============================
--prompt
create table FXP.P_PRODUCT_CLASS
(
  FPRODUCT_CLASS_ID   VARCHAR2(32) not null,
  FPRODUCT_CLASS_CODE VARCHAR2(8) not null,
  FPRODUCT_CLASS_NAME VARCHAR2(40) not null,
  FISAVAILABLE        CHAR(1) not null,
  FPRODUCT_CLASS_DESC VARCHAR2(256),
  FVERSION            NUMBER(6) default 0 not null,
  FLOGCBY             VARCHAR2(32) not null,
  FLOGCDATE           timestamp not null,
  FLOGLUBY            VARCHAR2(32) not null,
  FLOGLUDATE          timestamp not null,
  FLOGLABY            VARCHAR2(32) not null,
  FLOGLADATE          timestamp not null
)
;
alter table FXP.P_PRODUCT_CLASS
  add constraint PK_P_PRODUCT_CLASS primary key (FPRODUCT_CLASS_ID);
alter table FXP.P_PRODUCT_CLASS
  add constraint UK_P_PRODUCT_CLASS unique (FPRODUCT_CLASS_CODE);

--prompt
--prompt Creating table P_PRODUCT_SUBCLASS
--prompt =================================
--prompt
create table FXP.P_PRODUCT_SUBCLASS
(
  FPRODUCT_SUBCLASS_ID   VARCHAR2(32) not null,
  FPRODUCT_SUBCLASS_CODE VARCHAR2(8) not null,
  FPRODUCT_SUBCLASS_NAME VARCHAR2(40) not null,
  FPRODUCT_CLASS_ID      VARCHAR2(32) not null,
  FISAVAILABLE           CHAR(1) not null,
  FPRODUCT_SUBCLASS_DESC VARCHAR2(256),
  FVERSION               NUMBER(6) default 0 not null,
  FLOGCBY                VARCHAR2(32) not null,
  FLOGCDATE              timestamp not null,
  FLOGLUBY               VARCHAR2(32) not null,
  FLOGLUDATE             timestamp not null,
  FLOGLABY               VARCHAR2(32) not null,
  FLOGLADATE             timestamp not null
)
;
alter table FXP.P_PRODUCT_SUBCLASS
  add constraint PK_P_PRODUCT_SUBCLASS primary key (FPRODUCT_SUBCLASS_ID);
alter table FXP.P_PRODUCT_SUBCLASS
  add constraint UK_P_PRODUCT_SUBCLASS unique (FPRODUCT_SUBCLASS_CODE);

--prompt
--prompt Creating table P_PRODUCT
--prompt ========================
--prompt
create table FXP.P_PRODUCT
(
  FPRODUCT_ID          VARCHAR2(32) not null,
  FPRODUCT_NAME        VARCHAR2(50) not null,
  FPRODUCT_INFO        VARCHAR2(200),
  FPRODUCT_CLASS_ID    VARCHAR2(32) not null,
  FPRODUCT_SUBCLASS_ID VARCHAR2(32) not null,
  FCOMMISSION_RATE     NUMBER(4,3) not null,
  FISAVAILABLE         CHAR(1) not null,
  FPRODUCT_DESC        VARCHAR2(256),
  FVERSION             NUMBER(6) default 0 not null,
  FLOGCBY              VARCHAR2(32) not null,
  FLOGCDATE            timestamp not null,
  FLOGLUBY             VARCHAR2(32) not null,
  FLOGLUDATE           timestamp not null,
  FLOGLABY             VARCHAR2(32) not null,
  FLOGLADATE           timestamp not null
)
;
alter table FXP.P_PRODUCT
  add constraint PK_P_PRODUCT primary key (FPRODUCT_ID);
alter table FXP.P_PRODUCT
  add constraint FK_P_PRODUCT_CLASS_CLASS foreign key (FPRODUCT_CLASS_ID)
  references FXP.P_PRODUCT_CLASS (FPRODUCT_CLASS_ID);
alter table FXP.P_PRODUCT
  add constraint FK_P_PRODUCT_SUBCLASS_SUBCLASS foreign key (FPRODUCT_SUBCLASS_ID)
  references FXP.P_PRODUCT_SUBCLASS (FPRODUCT_SUBCLASS_ID);

--prompt
--prompt Creating table P_GOODS_COMPOSE
--prompt ==============================
--prompt
create table FXP.P_GOODS_COMPOSE
(
  FCOMPOSE_ID   VARCHAR2(32) not null,
  FGOODS_ID     VARCHAR2(32) not null,
  FPRODUCT_ID   VARCHAR2(32) not null,
  FPERCENT      NUMBER(4,1) not null,
  FFLOATING     NUMBER(4,1) not null,
  FCOMPOSE_DESC VARCHAR2(256),
  FVERSION      NUMBER(6) default 0 not null,
  FLOGCBY       VARCHAR2(32) not null,
  FLOGCDATE     timestamp not null,
  FLOGLUBY      VARCHAR2(32) not null,
  FLOGLUDATE    timestamp not null,
  FLOGLABY      VARCHAR2(32) not null,
  FLOGLADATE    timestamp not null
)
;
alter table FXP.P_GOODS_COMPOSE
  add constraint PK_P_GOODS_COMPOSE primary key (FGOODS_ID, FPRODUCT_ID);
alter table FXP.P_GOODS_COMPOSE
  add constraint FK_P_GOODS_COMPOSE_GOODS foreign key (FGOODS_ID)
  references FXP.P_GOODS (FGOODS_ID);
alter table FXP.P_GOODS_COMPOSE
  add constraint FK_P_GOODS_COMPOSE_PRODUCT foreign key (FPRODUCT_ID)
  references FXP.P_PRODUCT (FPRODUCT_ID);

--prompt
--prompt Creating table P_GOV_HELP
--prompt =========================
--prompt
create table FXP.P_GOV_HELP
(
  FGOV_HELP_ID   VARCHAR2(32) not null,
  FGOV_HELP_CODE VARCHAR2(8) not null,
  FGOV_HELP_NAME VARCHAR2(40) not null,
  FISOTHER       CHAR(1) not null,
  FGOV_HELP_DESC VARCHAR2(256),
  FVERSION       NUMBER(6) default 0 not null,
  FLOGCBY        VARCHAR2(32) not null,
  FLOGCDATE      timestamp not null,
  FLOGLUBY       VARCHAR2(32) not null,
  FLOGLUDATE     timestamp not null,
  FLOGLABY       VARCHAR2(32) not null,
  FLOGLADATE     timestamp not null
)
;
alter table FXP.P_GOV_HELP
  add constraint PK_P_GOV_HELP primary key (FGOV_HELP_ID);
alter table FXP.P_GOV_HELP
  add constraint UK_P_GOV_HELP_CODE unique (FGOV_HELP_CODE);

--prompt
--prompt Creating table P_HBC_DISEASE
--prompt ============================
--prompt
create table FXP.P_HBC_DISEASE
(
  FDISEASE_ID     VARCHAR2(32) not null,
  FDISEASE_CODE   VARCHAR2(8) not null,
  FDISEASE_GBCODE VARCHAR2(32),
  FDISEASE_NAME   VARCHAR2(40) not null,
  FISOTHER        CHAR(1) not null,
  FISAVAILABLE    CHAR(1) not null,
  FORDERNUM       NUMBER(6,2) not null,
  FDISEASE_DESC   VARCHAR2(256),
  FVERSION        NUMBER(6) default 0 not null,
  FLOGCBY         VARCHAR2(32) not null,
  FLOGCDATE       timestamp default sysdate not null,
  FLOGLUBY        VARCHAR2(32) not null,
  FLOGLUDATE      timestamp default sysdate not null,
  FLOGLABY        VARCHAR2(32) not null,
  FLOGLADATE      timestamp default sysdate not null
)
;
alter table FXP.P_HBC_DISEASE
  add constraint PK_P_HBC_DISEASE primary key (FDISEASE_ID);
alter table FXP.P_HBC_DISEASE
  add constraint UK_P_HBC_DISEASE_CODE unique (FDISEASE_CODE);

--prompt
--prompt Creating table P_ICD
--prompt ====================
--prompt
create table FXP.P_ICD
(
  FDIAG_CODE          VARCHAR2(20) not null,
  FDIAG_NAME          VARCHAR2(100) not null,
  FDIAG_CLASS         VARCHAR2(10) not null,
  FDISEASE_CLASS_ID   VARCHAR2(32) not null,
  FDIAG_LEVEL         NUMBER(1) not null,
  FTREE_ID            VARCHAR2(32) not null,
  FDIAG_SYSTEM        VARCHAR2(10) not null,
  FISAVAILABLE        CHAR(1) not null,
  FDIAG_DESC          VARCHAR2(256),
  FREFER_DISEASE_ID   VARCHAR2(32),
  FREFER_DISEASE_CODE VARCHAR2(20),
  FREFER_DISEASE_NAME VARCHAR2(100),
  FVERSION            NUMBER(6) default 0 not null,
  FLOGCBY             VARCHAR2(32) not null,
  FLOGCDATE           timestamp not null,
  FLOGLUBY            VARCHAR2(32) not null,
  FLOGLUDATE          timestamp not null,
  FLOGLABY            VARCHAR2(32) not null,
  FLOGLADATE          timestamp not null
)
;
alter table FXP.P_ICD
  add constraint PK_P_ICD primary key (FDIAG_CODE);

--prompt
--prompt Creating table P_ICD_CLASS
--prompt ==========================
--prompt
create table FXP.P_ICD_CLASS
(
  FICD_CLASS_ID       VARCHAR2(32) not null,
  FICD_CLASS_CODE     VARCHAR2(8) not null,
  FICD_CLASS_NAME     VARCHAR2(60) not null,
  FICD_CLASS_DESC     VARCHAR2(256),
  FREFER_DISEASE_ID   VARCHAR2(32),
  FREFER_DISEASE_CODE VARCHAR2(20),
  FREFER_DISEASE_NAME VARCHAR2(100),
  FVERSION            NUMBER(6) default 0 not null,
  FLOGCBY             VARCHAR2(32) not null,
  FLOGCDATE           timestamp not null,
  FLOGLUBY            VARCHAR2(32) not null,
  FLOGLUDATE          timestamp not null,
  FLOGLABY            VARCHAR2(32) not null,
  FLOGLADATE          timestamp not null
)
;
alter table FXP.P_ICD_CLASS
  add constraint PK_P_ICD_CLASS primary key (FICD_CLASS_ID);
alter table FXP.P_ICD_CLASS
  add constraint UK_P_ICD_CLASS_CODE unique (FICD_CLASS_CODE);

--prompt
--prompt Creating table P_ICD_MINICLASS
--prompt ==============================
--prompt
create table FXP.P_ICD_MINICLASS
(
  FICD_MINICLASS_ID   VARCHAR2(32) not null,
  FICD_MINICLASS_NAME VARCHAR2(80) not null,
  FICD_CLASS_ID       VARCHAR2(32) not null,
  FICD_MINICLASS_DESC VARCHAR2(256),
  FREFER_DISEASE_ID   VARCHAR2(32),
  FREFER_DISEASE_CODE VARCHAR2(20),
  FREFER_DISEASE_NAME VARCHAR2(100),
  FVERSION            NUMBER(6) default 0 not null,
  FLOGCBY             VARCHAR2(32) not null,
  FLOGCDATE           timestamp not null,
  FLOGLUBY            VARCHAR2(32) not null,
  FLOGLUDATE          timestamp not null,
  FLOGLABY            VARCHAR2(32) not null,
  FLOGLADATE          timestamp not null
)
;
alter table FXP.P_ICD_MINICLASS
  add constraint PK_P_ICD_MINICLASS primary key (FICD_MINICLASS_ID);

--prompt
--prompt Creating table P_ICD_SUBCLASS
--prompt =============================
--prompt
create table FXP.P_ICD_SUBCLASS
(
  FICD_SUBCLASS_ID    VARCHAR2(32) not null,
  FICD_SUBCLASS_NAME  VARCHAR2(80) not null,
  FICD_CLASS_ID       VARCHAR2(32) not null,
  FICD_SUBCLASS_DESC  VARCHAR2(256),
  FREFER_DISEASE_ID   VARCHAR2(32),
  FREFER_DISEASE_CODE VARCHAR2(20),
  FREFER_DISEASE_NAME VARCHAR2(100),
  FVERSION            NUMBER(6) default 0 not null,
  FLOGCBY             VARCHAR2(32) not null,
  FLOGCDATE           timestamp not null,
  FLOGLUBY            VARCHAR2(32) not null,
  FLOGLUDATE          timestamp not null,
  FLOGLABY            VARCHAR2(32) not null,
  FLOGLADATE          timestamp not null
)
;
alter table FXP.P_ICD_SUBCLASS
  add constraint PK_P_ICD_SUBCLASS primary key (FICD_SUBCLASS_ID);

--prompt
--prompt Creating table P_ID_BILL_TYPE
--prompt =============================
--prompt
create table FXP.P_ID_BILL_TYPE
(
  FID           VARCHAR2(32) not null,
  FCLASS_NAME   VARCHAR2(80) not null,
  FBILL_TYPE_ID VARCHAR2(32) not null,
  FDESC         VARCHAR2(256),
  FVERSION      NUMBER(6) default 0 not null
)
;
alter table FXP.P_ID_BILL_TYPE
  add constraint PK_P_ID_BILL_TYPE primary key (FID);
alter table FXP.P_ID_BILL_TYPE
  add constraint UK_P_ID_BILL_TYPE_NAME unique (FCLASS_NAME);

--prompt
--prompt Creating table P_INCOME_SOURCE
--prompt ==============================
--prompt
create table FXP.P_INCOME_SOURCE
(
  FINCOME_SOURCE_ID   VARCHAR2(32) not null,
  FINCOME_SOURCE_CODE VARCHAR2(8) not null,
  FINCOME_SOURCE_NAME VARCHAR2(40) not null,
  FISAVAILABLE        CHAR(1) not null,
  FINCOME_SOURCE_DESC VARCHAR2(256),
  FVERSION            NUMBER(6) default 0 not null,
  FLOGCBY             VARCHAR2(32) not null,
  FLOGCDATE           timestamp not null,
  FLOGLUBY            VARCHAR2(32) not null,
  FLOGLUDATE          timestamp not null,
  FLOGLABY            VARCHAR2(32) not null,
  FLOGLADATE          timestamp not null
)
;
alter table FXP.P_INCOME_SOURCE
  add constraint PK_P_INCOME_SOURCE primary key (FINCOME_SOURCE_ID);
alter table FXP.P_INCOME_SOURCE
  add constraint UK_P_INCOME_SOURCE_CODE unique (FINCOME_SOURCE_CODE);

--prompt
--prompt Creating table P_ITEM
--prompt =====================
--prompt
create table FXP.P_ITEM
(
  FITEM_ID      VARCHAR2(32) not null,
  FITEM_NAME    VARCHAR2(50) not null,
  FPRODUCT_ID   VARCHAR2(32) not null,
  FITEM_INFO    VARCHAR2(200),
  FISAVAILABLE  CHAR(1) not null,
  FITEM_DESC    VARCHAR2(256),
  FITEM_PRICE   NUMBER(8,2),
  FUPDATE_PRICE CHAR(1) not null,
  FITEM_UNIT    VARCHAR2(20) not null,
  FCHARGE_MODE  VARCHAR2(10) not null,
  FCIRCLE_ID    VARCHAR2(32) not null,
  FVERSION      NUMBER(6) default 0 not null,
  FLOGCBY       VARCHAR2(32) not null,
  FLOGCDATE     timestamp not null,
  FLOGLUBY      VARCHAR2(32) not null,
  FLOGLUDATE    timestamp not null,
  FLOGLABY      VARCHAR2(32) not null,
  FLOGLADATE    timestamp not null
)
;
alter table FXP.P_ITEM
  add constraint PK_P_ITEM primary key (FITEM_ID);
alter table FXP.P_ITEM
  add constraint FK_P_ITEM_PRODUCT foreign key (FPRODUCT_ID)
  references FXP.P_PRODUCT (FPRODUCT_ID);
alter table FXP.P_ITEM
  add constraint CHECK_P_ITEM_CHARGE_MODE
  check (fcharge_mode IN ('MONTH','TIMES','HOUR','MONTH_AVG'));

--prompt
--prompt Creating table P_LANGUAGE
--prompt =========================
--prompt
create table FXP.P_LANGUAGE
(
  FLANGUAGE_ID     VARCHAR2(32) not null,
  FLANGUAGE_CODE   VARCHAR2(8) not null,
  FLANGUAGE_GBCODE VARCHAR2(32),
  FLANGUAGE_NAME   VARCHAR2(40) not null,
  FISOTHER         CHAR(1) not null,
  FISAVAILABLE     CHAR(1) not null,
  FORDERNUM        NUMBER(6,2) not null,
  FLANGUAGE_DESC   VARCHAR2(256),
  FVERSION         NUMBER(6) default 0 not null,
  FLOGCBY          VARCHAR2(32) not null,
  FLOGCDATE        timestamp default sysdate not null,
  FLOGLUBY         VARCHAR2(32) not null,
  FLOGLUDATE       timestamp default sysdate not null,
  FLOGLABY         VARCHAR2(32) not null,
  FLOGLADATE       timestamp default sysdate not null
)
;
alter table FXP.P_LANGUAGE
  add constraint PK_P_LANGUAGE primary key (FLANGUAGE_ID);
alter table FXP.P_LANGUAGE
  add constraint UK_P_LANGUAGE_CODE unique (FLANGUAGE_CODE);

--prompt
--prompt Creating table P_LOGIN_DEFAULT_TEAM
--prompt ===================================
--prompt
create table FXP.P_LOGIN_DEFAULT_TEAM
(
  FPK_ID          VARCHAR2(32) not null,
  FUSER_ID        VARCHAR2(32) not null,
  FAPPLICATION_ID VARCHAR2(32) not null,
  FCIRCLE_ID      VARCHAR2(32) not null,
  FTEAM_ID        VARCHAR2(32) not null,
  FDESC           VARCHAR2(256),
  FVERSION        NUMBER(6) default 0 not null,
  FLOGCBY         VARCHAR2(32) not null,
  FLOGCDATE       timestamp not null,
  FLOGLUBY        VARCHAR2(32) not null,
  FLOGLUDATE      timestamp not null,
  FLOGLABY        VARCHAR2(32) not null,
  FLOGLADATE      timestamp not null
)
;
alter table FXP.P_LOGIN_DEFAULT_TEAM
  add constraint PK_P_LOGIN_DEFAULT_TEAM primary key (FPK_ID);
alter table FXP.P_LOGIN_DEFAULT_TEAM
  add constraint UK_P_LOGIN_DEFAULT_TEAM unique (FUSER_ID, FAPPLICATION_ID);
alter table FXP.P_LOGIN_DEFAULT_TEAM
  add constraint FK_P_LOGIN_DEFAULT_TEAM_TEAM foreign key (FTEAM_ID)
  references FXP.P_TEAM (FTEAM_ID);
alter table FXP.P_LOGIN_DEFAULT_TEAM
  add constraint FK_P_LOGIN_DEFAULT_TEAM_USER foreign key (FUSER_ID)
  references FXP.P_USER (FUSER_ID);

--prompt
--prompt Creating table P_MESSAGE_HISTORY
--prompt ================================
--prompt
create table FXP.P_MESSAGE_HISTORY
(
  FMESSAGE_ID        VARCHAR2(32) not null,
  FNOTE_TYPE_ID      VARCHAR2(30) not null,
  FNOTE_ID           VARCHAR2(150) not null,
  FMESSAGE_TITLE     VARCHAR2(300) not null,
  FMESSAGE_CONTENT   VARCHAR2(300) not null,
  FNODE_ID           VARCHAR2(30) not null,
  FSEND_TIME         timestamp not null,
  FSEND_CIRCLE_ID    VARCHAR2(32),
  FSEND_TEAM_ID      VARCHAR2(32),
  FSEND_USER_ID      VARCHAR2(32) not null,
  FRECEIVE_CIRCLE_ID VARCHAR2(32),
  FRECEIVE_TEAM_ID   VARCHAR2(32),
  FRECEIVE_USER_ID   VARCHAR2(32) not null,
  FVERSION           NUMBER(6) default 0 not null,
  FLOGCBY            VARCHAR2(32) not null,
  FLOGCDATE          timestamp not null,
  FLOGLUBY           VARCHAR2(32) not null,
  FLOGLUDATE         timestamp not null,
  FLOGLABY           VARCHAR2(32) not null,
  FLOGLADATE         timestamp not null
)
;
alter table FXP.P_MESSAGE_HISTORY
  add constraint PK_P_MESSAGE_HISTORY primary key (FMESSAGE_ID);
alter table FXP.P_MESSAGE_HISTORY
  add constraint UK_P_MESSAGE_HISTORY unique (FNOTE_TYPE_ID, FNOTE_ID);

--prompt
--prompt Creating table P_MESSAGE_SEND
--prompt =============================
--prompt
create table FXP.P_MESSAGE_SEND
(
  FMESSAGE_ID        VARCHAR2(32) not null,
  FNOTE_TYPE_ID      VARCHAR2(30) not null,
  FNOTE_ID           VARCHAR2(150) not null,
  FMESSAGE_TITLE     VARCHAR2(300) not null,
  FMESSAGE_CONTENT   VARCHAR2(300) not null,
  FNODE_ID           VARCHAR2(30) not null,
  FSEND_TIME         timestamp not null,
  FSEND_CIRCLE_ID    VARCHAR2(32),
  FSEND_TEAM_ID      VARCHAR2(32),
  FSEND_USER_ID      VARCHAR2(32) not null,
  FRECEIVE_CIRCLE_ID VARCHAR2(32),
  FRECEIVE_TEAM_ID   VARCHAR2(32),
  FRECEIVE_USER_ID   VARCHAR2(32) not null,
  FVERSION           NUMBER(6) default 0 not null,
  FLOGCBY            VARCHAR2(32) not null,
  FLOGCDATE          timestamp not null,
  FLOGLUBY           VARCHAR2(32) not null,
  FLOGLUDATE         timestamp not null,
  FLOGLABY           VARCHAR2(32) not null,
  FLOGLADATE         timestamp not null
)
;
alter table FXP.P_MESSAGE_SEND
  add constraint PK_P_MESSAGE_SEND primary key (FMESSAGE_ID);
alter table FXP.P_MESSAGE_SEND
  add constraint UK_P_MESSAGE_SEND unique (FNOTE_TYPE_ID, FNOTE_ID);

--prompt
--prompt Creating table P_NOTE_LABEL
--prompt ===========================
--prompt
create table FXP.P_NOTE_LABEL
(
  FLABEL_ID        VARCHAR2(32) not null,
  FLABEL_NAME      VARCHAR2(80) not null,
  FNOTE_TYPE_ID    VARCHAR2(30) not null,
  FNOTE_ID         VARCHAR2(150) not null,
  FCREATE_TIME     timestamp not null,
  FCREATE_USER_ID  VARCHAR2(32) not null,
  FCREATE_NICKNAME VARCHAR2(30) not null,
  FLABEL_DESC      VARCHAR2(256),
  FVERSION         NUMBER(6) default 0 not null,
  FLOGCBY          VARCHAR2(32) not null,
  FLOGCDATE        timestamp not null,
  FLOGLUBY         VARCHAR2(32) not null,
  FLOGLUDATE       timestamp not null,
  FLOGLABY         VARCHAR2(32) not null,
  FLOGLADATE       timestamp not null
)
;
alter table FXP.P_NOTE_LABEL
  add constraint PK_P_NOTE_LABEL primary key (FLABEL_ID);
alter table FXP.P_NOTE_LABEL
  add constraint UK_P_NOTE_LABEL unique (FNOTE_TYPE_ID, FNOTE_ID, FLABEL_NAME);

--prompt
--prompt Creating table P_NOTE_TYPE
--prompt ==========================
--prompt
create table FXP.P_NOTE_TYPE
(
  FNOTE_TYPE_ID   VARCHAR2(32) not null,
  FNOTE_TYPE_NAME VARCHAR2(40) not null,
  FORDERNUM       NUMBER(6,2) not null,
  FNOTE_TYPE_DESC VARCHAR2(256),
  FVERSION        NUMBER(6) default 0 not null,
  FLOGCBY         VARCHAR2(32) not null,
  FLOGCDATE       timestamp default sysdate not null,
  FLOGLUBY        VARCHAR2(32) not null,
  FLOGLUDATE      timestamp default sysdate not null,
  FLOGLABY        VARCHAR2(32) not null,
  FLOGLADATE      timestamp default sysdate not null
)
;
alter table FXP.P_NOTE_TYPE
  add constraint PK_P_NOTE_TYPE primary key (FNOTE_TYPE_ID);

--prompt
--prompt Creating table P_NOTE_NODE
--prompt ==========================
--prompt
create table FXP.P_NOTE_NODE
(
  FNOTE_TYPE_ID VARCHAR2(30) not null,
  FNODE_ID      VARCHAR2(30) not null,
  FNODE_NAME    VARCHAR2(50) not null,
  FORDERNUM     NUMBER(6,2) not null,
  FNODE_DESC    VARCHAR2(256),
  FVERSION      NUMBER(6) default 0 not null,
  FLOGCBY       VARCHAR2(32) not null,
  FLOGCDATE     timestamp default sysdate not null,
  FLOGLUBY      VARCHAR2(32) not null,
  FLOGLUDATE    timestamp default sysdate not null,
  FLOGLABY      VARCHAR2(32) not null,
  FLOGLADATE    timestamp default sysdate not null
)
;
alter table FXP.P_NOTE_NODE
  add constraint PK_P_NOTE_NODE primary key (FNOTE_TYPE_ID, FNODE_ID);
alter table FXP.P_NOTE_NODE
  add constraint FK_P_NOTE_NODE_TYPE foreign key (FNOTE_TYPE_ID)
  references FXP.P_NOTE_TYPE (FNOTE_TYPE_ID);

--prompt
--prompt Creating table P_NOTE_TAG
--prompt =========================
--prompt
create table FXP.P_NOTE_TAG
(
  FNOTE_TYPE_ID VARCHAR2(30) not null,
  FNODE_ID      VARCHAR2(30) not null,
  FNODE_TAG     VARCHAR2(128) not null,
  FICON_FILE    VARCHAR2(30) not null,
  FBLOCK_NO     VARCHAR2(10) not null,
  FORDERNUM     NUMBER(6,2) not null,
  FTAG_DESC     VARCHAR2(256),
  FVERSION      NUMBER(6) default 0 not null,
  FLOGCBY       VARCHAR2(32) not null,
  FLOGCDATE     timestamp default sysdate not null,
  FLOGLUBY      VARCHAR2(32) not null,
  FLOGLUDATE    timestamp default sysdate not null,
  FLOGLABY      VARCHAR2(32) not null,
  FLOGLADATE    timestamp default sysdate not null
)
;
alter table FXP.P_NOTE_TAG
  add constraint PK_P_NOTE_TAG primary key (FNOTE_TYPE_ID, FNODE_ID, FNODE_TAG);
alter table FXP.P_NOTE_TAG
  add constraint FK_P_NOTE_TAG_NODE foreign key (FNOTE_TYPE_ID, FNODE_ID)
  references FXP.P_NOTE_NODE (FNOTE_TYPE_ID, FNODE_ID);
alter table FXP.P_NOTE_TAG
  add constraint CK_P_NOTE_TAG_BLOCK
  check (fblock_no in ('1','2'));

--prompt
--prompt Creating table P_OCCUPATION_TYPE
--prompt ================================
--prompt
create table FXP.P_OCCUPATION_TYPE
(
  FOCCUPATION_TYPE_ID   VARCHAR2(32) not null,
  FOCCUPATION_TYPE_CODE VARCHAR2(30) not null,
  FOCCUPATION_TYPE_NAME VARCHAR2(40) not null,
  FISAVAILABLE          CHAR(1) not null,
  FOCCUPATION_TYPE_DESC VARCHAR2(256),
  FVERSION              NUMBER(6) default 0 not null,
  FLOGCBY               VARCHAR2(32) not null,
  FLOGCDATE             timestamp not null,
  FLOGLUBY              VARCHAR2(32) not null,
  FLOGLUDATE            timestamp not null,
  FLOGLABY              VARCHAR2(32) not null,
  FLOGLADATE            timestamp not null
)
;
alter table FXP.P_OCCUPATION_TYPE
  add constraint PK_P_OCCUPATION_TYPE primary key (FOCCUPATION_TYPE_ID);
alter table FXP.P_OCCUPATION_TYPE
  add constraint UK_P_OCCUPATION_TYPE_CODE unique (FOCCUPATION_TYPE_CODE);

--prompt
--prompt Creating table P_ORDER
--prompt ======================
--prompt
create table FXP.P_ORDER
(
  FORDER_ID          VARCHAR2(32) not null,
  FACTIVATION_CODE   VARCHAR2(30) not null,
  FGOODS_ID          VARCHAR2(32) not null,
  FGOODS_NAME        VARCHAR2(100) not null,
  FGOODS_PRICE       NUMBER(10,2) not null,
  FGOODS_UNIT        VARCHAR2(30) not null,
  FQUANTITY          NUMBER(6) not null,
  FQUANTITY_ACTIVATE NUMBER(6) not null,
  FSUM_TOTAL         NUMBER(10,2) not null,
  FSELL_CIRCLE_ID    VARCHAR2(32) not null,
  FBUY_TIME          timestamp not null,
  FBUY_CIRCLE_ID     VARCHAR2(32),
  FBUY_TEAM_ID       VARCHAR2(32),
  FBUY_USER_ID       VARCHAR2(32) not null,
  FBUY_USER_NAME     VARCHAR2(50) not null,
  FVERSION           NUMBER(6) default 0 not null,
  FLOGCBY            VARCHAR2(32) not null,
  FLOGCDATE          timestamp not null,
  FLOGLUBY           VARCHAR2(32) not null,
  FLOGLUDATE         timestamp not null,
  FLOGLABY           VARCHAR2(32) not null,
  FLOGLADATE         timestamp not null
)
;
alter table FXP.P_ORDER
  add constraint PK_P_ORDER primary key (FORDER_ID);
alter table FXP.P_ORDER
  add constraint FK_P_ORDER_GOODS foreign key (FGOODS_ID)
  references FXP.P_GOODS (FGOODS_ID);
alter table FXP.P_ORDER
  add constraint FK_P_ORDER_SELL foreign key (FSELL_CIRCLE_ID)
  references FXP.P_CIRCLE (FCIRCLE_ID);

--prompt
--prompt Creating table P_PERSON_DISEASE
--prompt ===============================
--prompt
create table FXP.P_PERSON_DISEASE
(
  FPK_ID        VARCHAR2(32) not null,
  FDISEASE_ID   VARCHAR2(32) not null,
  FDISEASE_NAME VARCHAR2(40) not null,
  FPERSON_ID    VARCHAR2(32) not null,
  FORDERNUM     NUMBER(6,2) not null,
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
alter table FXP.P_PERSON_DISEASE
  add constraint PK_P_PERSON_DISEASE primary key (FPK_ID);
alter table FXP.P_PERSON_DISEASE
  add constraint UK_P_PERSON_DISEASE unique (FPERSON_ID, FDISEASE_ID);
alter table FXP.P_PERSON_DISEASE
  add constraint FK_P_PERSON_DISEASE_DISEASE foreign key (FDISEASE_ID)
  references FXP.P_HBC_DISEASE (FDISEASE_ID);
alter table FXP.P_PERSON_DISEASE
  add constraint FK_P_PERSON_DISEASE_PERSON foreign key (FPERSON_ID)
  references FXP.P_PERSON (FPERSON_ID);
create index FXP.IDX_FILE_PERSON_DISEASE1 on FXP.P_PERSON_DISEASE (FPERSON_ID);

--prompt
--prompt Creating table P_PERSON_LANGUAGE
--prompt ================================
--prompt
create table FXP.P_PERSON_LANGUAGE
(
  FPK_ID         VARCHAR2(32) not null,
  FLANGUAGE_ID   VARCHAR2(32) not null,
  FLANGUAGE_NAME VARCHAR2(40) not null,
  FPERSON_ID     VARCHAR2(32) not null,
  FORDERNUM      NUMBER(6,2) not null,
  FLANGUAGE_DESC VARCHAR2(256),
  FVERSION       NUMBER(6) default 0 not null,
  FLOGCBY        VARCHAR2(32) not null,
  FLOGCDATE      timestamp not null,
  FLOGLUBY       VARCHAR2(32) not null,
  FLOGLUDATE     timestamp not null,
  FLOGLABY       VARCHAR2(32) not null,
  FLOGLADATE     timestamp not null
)
;
alter table FXP.P_PERSON_LANGUAGE
  add constraint PK_P_PERSON_LANGUAGE primary key (FPK_ID);
alter table FXP.P_PERSON_LANGUAGE
  add constraint UK_P_PERSON_LANGUAGE unique (FPERSON_ID, FLANGUAGE_ID);
alter table FXP.P_PERSON_LANGUAGE
  add constraint FK_P_PERSON_LANGUAGE_LANGUAGE foreign key (FLANGUAGE_ID)
  references FXP.P_LANGUAGE (FLANGUAGE_ID);
alter table FXP.P_PERSON_LANGUAGE
  add constraint FK_P_PERSON_LANGUAGE_PERSON foreign key (FPERSON_ID)
  references FXP.P_PERSON (FPERSON_ID);
create index FXP.IDX_P_PERSON_LANGUAGE1 on FXP.P_PERSON_LANGUAGE (FPERSON_ID);

--prompt
--prompt Creating table P_PERSON_LOCATION
--prompt ================================
--prompt
create table FXP.P_PERSON_LOCATION
(
  FPERSON_ID     VARCHAR2(32) not null,
  FREC_TIME      timestamp not null,
  FLOCATION_TIME timestamp not null,
  FCITY          VARCHAR2(16),
  FADDRESS       VARCHAR2(128),
  FLONGITUDE     NUMBER(19,15) not null,
  FLATITUDE      NUMBER(19,15) not null,
  FVERSION       NUMBER(6) default 0 not null,
  FLOGCBY        VARCHAR2(32) not null,
  FLOGCDATE      timestamp not null,
  FLOGLUBY       VARCHAR2(32) not null,
  FLOGLUDATE     timestamp not null,
  FLOGLABY       VARCHAR2(32) not null,
  FLOGLADATE     timestamp not null
)
;
alter table FXP.P_PERSON_LOCATION
  add constraint PK_P_PERSON_LOCATION primary key (FPERSON_ID);
alter table FXP.P_PERSON_LOCATION
  add constraint FK_P_PERSON_LOCATION_PERSON foreign key (FPERSON_ID)
  references FXP.P_PERSON (FPERSON_ID);

--prompt
--prompt Creating table P_PERSON_MEDICAL
--prompt ===============================
--prompt
create table FXP.P_PERSON_MEDICAL
(
  FREGISTER_ID            VARCHAR2(32) not null,
  FPERSON_ID              VARCHAR2(32) not null,
  FHOSPITAL_NAME          VARCHAR2(60),
  FDOCTOR_NAME            VARCHAR2(40),
  FCONTACT_PHONE          VARCHAR2(40),
  FMEDICAL_ITEM           VARCHAR2(80),
  FMEDICAL_TREATMENT_ID   VARCHAR2(32),
  FMEDICAL_TREATMENT_NAME VARCHAR2(30),
  FORDERNUM               NUMBER(6,2) not null,
  FREGISTER_DESC          VARCHAR2(256),
  FVERSION                NUMBER(6) default 0 not null,
  FLOGCBY                 VARCHAR2(32) not null,
  FLOGCDATE               timestamp not null,
  FLOGLUBY                VARCHAR2(32) not null,
  FLOGLUDATE              timestamp not null,
  FLOGLABY                VARCHAR2(32) not null,
  FLOGLADATE              timestamp not null
)
;
alter table FXP.P_PERSON_MEDICAL
  add constraint PK_P_PERSON_MEDICAL primary key (FREGISTER_ID);
alter table FXP.P_PERSON_MEDICAL
  add constraint FK_P_PERSON_MEDICAL_PERSON foreign key (FPERSON_ID)
  references FXP.P_PERSON (FPERSON_ID);

--prompt
--prompt Creating table P_SERVICE
--prompt ========================
--prompt
create table FXP.P_SERVICE
(
  FSERVICE_ID       VARCHAR2(32) not null,
  FSERVICE_CODE     VARCHAR2(30) not null,
  FSERVICE_NAME     VARCHAR2(50) not null,
  FFAMILY_OR_PERSON VARCHAR2(30) not null,
  FISAVAILABLE      CHAR(1) not null,
  FSERVICE_DESC     VARCHAR2(256),
  FVERSION          NUMBER(6) default 0 not null,
  FLOGCBY           VARCHAR2(32) not null,
  FLOGCDATE         timestamp not null,
  FLOGLUBY          VARCHAR2(32) not null,
  FLOGLUDATE        timestamp not null,
  FLOGLABY          VARCHAR2(32) not null,
  FLOGLADATE        timestamp not null
)
;
alter table FXP.P_SERVICE
  add constraint PK_P_SERVICE primary key (FSERVICE_ID);
alter table FXP.P_SERVICE
  add constraint UK_P_SERVICE unique (FSERVICE_CODE);

--prompt
--prompt Creating table P_PERSON_SERVICE
--prompt ===============================
--prompt
create table FXP.P_PERSON_SERVICE
(
  FPERSON_ID        VARCHAR2(32) not null,
  FSERVICE_ID       VARCHAR2(32) not null,
  FSERVICE_NAME     VARCHAR2(50) not null,
  FSERVICE_BEGIN    timestamp not null,
  FSERVICE_END      timestamp not null,
  FCIRCLE_ID        VARCHAR2(32),
  FCREATE_DATE      timestamp not null,
  FCREATE_CIRCLE_ID VARCHAR2(32) not null,
  FCREATE_USER_ID   VARCHAR2(32) not null,
  FCREATE_NICKNAME  VARCHAR2(40) not null,
  FCREATE_DESC      VARCHAR2(256),
  FVERSION          NUMBER(6) default 0 not null,
  FLOGCBY           VARCHAR2(32) not null,
  FLOGCDATE         timestamp not null,
  FLOGLUBY          VARCHAR2(32) not null,
  FLOGLUDATE        timestamp not null,
  FLOGLABY          VARCHAR2(32) not null,
  FLOGLADATE        timestamp not null
)
;
alter table FXP.P_PERSON_SERVICE
  add constraint PK_P_PERSON_SERVICE primary key (FPERSON_ID, FSERVICE_ID);
alter table FXP.P_PERSON_SERVICE
  add constraint FK_P_PERSON_SERVICE_CIRCLE foreign key (FCIRCLE_ID)
  references FXP.P_CIRCLE (FCIRCLE_ID);
alter table FXP.P_PERSON_SERVICE
  add constraint FK_P_PERSON_SERVICE_PERSON foreign key (FPERSON_ID)
  references FXP.P_PERSON (FPERSON_ID);
alter table FXP.P_PERSON_SERVICE
  add constraint FK_P_PERSON_SERVICE_SERVICE foreign key (FSERVICE_ID)
  references FXP.P_SERVICE (FSERVICE_ID);
create index FXP.IDX_P_PERSON_SERVICE_OPERATOR on FXP.P_PERSON_SERVICE (FCIRCLE_ID);

--prompt
--prompt Creating table P_PHONE_AREACODE
--prompt ===============================
--prompt
create table FXP.P_PHONE_AREACODE
(
  FAREA_CODE VARCHAR2(20) not null,
  FREGION_ID VARCHAR2(32) not null,
  FAREA_DESC VARCHAR2(256),
  FVERSION   NUMBER(6) default 0 not null,
  FLOGCBY    VARCHAR2(32) default 'admin' not null,
  FLOGCDATE  timestamp default sysdate not null,
  FLOGLUBY   VARCHAR2(32) default 'admin' not null,
  FLOGLUDATE timestamp default sysdate not null,
  FLOGLABY   VARCHAR2(32) default 'admin' not null,
  FLOGLADATE timestamp default sysdate not null
)
;
alter table FXP.P_PHONE_AREACODE
  add constraint PK_P_PHONE_AREACODE primary key (FAREA_CODE);

--prompt
--prompt Creating table P_PHONE_BUSINESS
--prompt ===============================
--prompt
create table FXP.P_PHONE_BUSINESS
(
  FNUMBER_PREFIX VARCHAR2(30) not null,
  FTOTAL_LENGTH  NUMBER(2) not null,
  FPHONE_DESC    VARCHAR2(256),
  FVERSION       NUMBER(6) default 0 not null,
  FLOGCBY        VARCHAR2(32) default 'admin' not null,
  FLOGCDATE      timestamp default sysdate not null,
  FLOGLUBY       VARCHAR2(32) default 'admin' not null,
  FLOGLUDATE     timestamp default sysdate not null,
  FLOGLABY       VARCHAR2(32) default 'admin' not null,
  FLOGLADATE     timestamp default sysdate not null
)
;
alter table FXP.P_PHONE_BUSINESS
  add constraint PK_P_PHONE_BUSINESS primary key (FNUMBER_PREFIX);

--prompt
--prompt Creating table P_PHONE_FIX
--prompt ==========================
--prompt
create table FXP.P_PHONE_FIX
(
  FAREA_CODE    VARCHAR2(20) not null,
  FTOTAL_LENGTH NUMBER(2) not null,
  FPNONE_DESC   VARCHAR2(256),
  FVERSION      NUMBER(6) default 0 not null,
  FLOGCBY       VARCHAR2(32) default 'admin' not null,
  FLOGCDATE     timestamp default sysdate not null,
  FLOGLUBY      VARCHAR2(32) default 'admin' not null,
  FLOGLUDATE    timestamp default sysdate not null,
  FLOGLABY      VARCHAR2(32) default 'admin' not null,
  FLOGLADATE    timestamp default sysdate not null
)
;
alter table FXP.P_PHONE_FIX
  add constraint PK_P_PHONE_FIX primary key (FAREA_CODE);

--prompt
--prompt Creating table P_PHONE_MOBILE
--prompt =============================
--prompt
create table FXP.P_PHONE_MOBILE
(
  FNUMBER_BEGIN VARCHAR2(30) not null,
  FNUMBER_END   VARCHAR2(30) not null,
  FTOTAL_LENGTH NUMBER(2) not null,
  FAREA_CODE    VARCHAR2(20) not null,
  FPNONE_DESC   VARCHAR2(256),
  FVERSION      NUMBER(6) default 0 not null,
  FLOGCBY       VARCHAR2(32) default 'admin' not null,
  FLOGCDATE     timestamp default sysdate not null,
  FLOGLUBY      VARCHAR2(32) default 'admin' not null,
  FLOGLUDATE    timestamp default sysdate not null,
  FLOGLABY      VARCHAR2(32) default 'admin' not null,
  FLOGLADATE    timestamp default sysdate not null
)
;
alter table FXP.P_PHONE_MOBILE
  add constraint PK_P_PHONE_MOBILE primary key (FNUMBER_BEGIN);
alter table FXP.P_PHONE_MOBILE
  add constraint UK_P_PHONE_MOBILE_END unique (FNUMBER_END);

--prompt
--prompt Creating table P_PHONE_REGEXP
--prompt =============================
--prompt
create table FXP.P_PHONE_REGEXP
(
  FREGEXP_ID     VARCHAR2(32) not null,
  FPHONE_REGEXP  VARCHAR2(100) not null,
  FPHONE_TYPE_ID VARCHAR2(32) not null,
  FORDERNUM      NUMBER(6,2) not null,
  FREGEXP_DESC   VARCHAR2(256),
  FVERSION       NUMBER(6) default 0 not null,
  FLOGCBY        VARCHAR2(32) default 'admin' not null,
  FLOGCDATE      timestamp default sysdate not null,
  FLOGLUBY       VARCHAR2(32) default 'admin' not null,
  FLOGLUDATE     timestamp default sysdate not null,
  FLOGLABY       VARCHAR2(32) default 'admin' not null,
  FLOGLADATE     timestamp default sysdate not null
)
;
alter table FXP.P_PHONE_REGEXP
  add constraint PK_P_PHONE_REGEXP primary key (FREGEXP_ID);
alter table FXP.P_PHONE_REGEXP
  add constraint UK_P_PHONE_REGEXP unique (FPHONE_REGEXP);

--prompt
--prompt Creating table P_PHONE_SPECIAL
--prompt ==============================
--prompt
create table FXP.P_PHONE_SPECIAL
(
  FPHONE_NUMBER VARCHAR2(30) not null,
  FPHONE_DESC   VARCHAR2(256),
  FVERSION      NUMBER(6) default 0 not null,
  FLOGCBY       VARCHAR2(32) default 'admin' not null,
  FLOGCDATE     timestamp default sysdate not null,
  FLOGLUBY      VARCHAR2(32) default 'admin' not null,
  FLOGLUDATE    timestamp default sysdate not null,
  FLOGLABY      VARCHAR2(32) default 'admin' not null,
  FLOGLADATE    timestamp default sysdate not null
)
;
alter table FXP.P_PHONE_SPECIAL
  add constraint PK_P_PHONE_SPECIAL primary key (FPHONE_NUMBER);

--prompt
--prompt Creating table P_PHONE_TYPE
--prompt ===========================
--prompt
create table FXP.P_PHONE_TYPE
(
  FPHONE_TYPE_ID   VARCHAR2(32) not null,
  FPHONE_TYPE_CODE VARCHAR2(8) not null,
  FPHONE_TYPE_NAME VARCHAR2(40) not null,
  FPHONE_TYPE_DESC VARCHAR2(256),
  FVERSION         NUMBER(6) default 0 not null,
  FLOGCBY          VARCHAR2(32) default 'admin' not null,
  FLOGCDATE        timestamp default sysdate not null,
  FLOGLUBY         VARCHAR2(32) default 'admin' not null,
  FLOGLUDATE       timestamp default sysdate not null,
  FLOGLABY         VARCHAR2(32) default 'admin' not null,
  FLOGLADATE       timestamp default sysdate not null
)
;
alter table FXP.P_PHONE_TYPE
  add constraint PK_P_PHONE_TYPE primary key (FPHONE_TYPE_ID);
alter table FXP.P_PHONE_TYPE
  add constraint UK_P_PHONE_TYPE_CODE unique (FPHONE_TYPE_CODE);

--prompt
--prompt Creating table P_QYH_GUEST
--prompt ==========================
--prompt
create table FXP.P_QYH_GUEST
(
  FQYH_USER_ID VARCHAR2(64) not null,
  FOPEN_ID     VARCHAR2(256) not null,
  FUSER_NAME   VARCHAR2(50) not null,
  FSEX_ID      VARCHAR2(32),
  FSEX_NAME    VARCHAR2(10),
  FWEIXINID    VARCHAR2(64),
  FMOBILE      VARCHAR2(20),
  FEMAIL       VARCHAR2(30),
  FVERSION     NUMBER(6) default 0 not null,
  FLOGCBY      VARCHAR2(32) not null,
  FLOGCDATE    timestamp not null,
  FLOGLUBY     VARCHAR2(32) not null,
  FLOGLUDATE   timestamp not null,
  FLOGLABY     VARCHAR2(32) not null,
  FLOGLADATE   timestamp not null
)
;
alter table FXP.P_QYH_GUEST
  add constraint PK_P_QYH_GUEST primary key (FOPEN_ID);
create unique index FXP.UK_P_QYH_GUEST_OPENID on FXP.P_QYH_GUEST (FOPEN_ID);

--prompt
--prompt Creating table P_QYH_USER
--prompt =========================
--prompt
create table FXP.P_QYH_USER
(
  FQYH_USER_ID VARCHAR2(64) not null,
  FUSER_NAME   VARCHAR2(50) not null,
  FSEX_ID      VARCHAR2(32),
  FSEX_NAME    VARCHAR2(10),
  FWEIXINID    VARCHAR2(64),
  FMOBILE      VARCHAR2(20),
  FEMAIL       VARCHAR2(30),
  FUSER_ID     VARCHAR2(32) not null,
  FVERSION     NUMBER(6) default 0 not null,
  FLOGCBY      VARCHAR2(32) not null,
  FLOGCDATE    timestamp not null,
  FLOGLUBY     VARCHAR2(32) not null,
  FLOGLUDATE   timestamp not null,
  FLOGLABY     VARCHAR2(32) not null,
  FLOGLADATE   timestamp not null,
  FUSER_TYPE   VARCHAR2(20)
)
;
alter table FXP.P_QYH_USER
  add constraint PK_P_QYH_USER primary key (FQYH_USER_ID);
alter table FXP.P_QYH_USER
  add constraint UK_P_QYH_USER_USER unique (FUSER_ID);
alter table FXP.P_QYH_USER
  add constraint FK_P_QYH_USER_USER foreign key (FUSER_ID)
  references FXP.P_USER (FUSER_ID);

--prompt
--prompt Creating table P_QYH_USER_ORG
--prompt =============================
--prompt
create table FXP.P_QYH_USER_ORG
(
  FQYH_USER_ID VARCHAR2(64) not null,
  FORG_ID      VARCHAR2(32) not null,
  FVERSION     NUMBER(6) default 0 not null,
  FLOGCBY      VARCHAR2(32) not null,
  FLOGCDATE    timestamp not null,
  FLOGLUBY     VARCHAR2(32) not null,
  FLOGLUDATE   timestamp not null,
  FLOGLABY     VARCHAR2(32) not null,
  FLOGLADATE   timestamp not null
)
;
alter table FXP.P_QYH_USER_ORG
  add constraint PK_P_QYH_USER_ORG primary key (FQYH_USER_ID, FORG_ID);

--prompt
--prompt Creating table P_RELIGION
--prompt =========================
--prompt
create table FXP.P_RELIGION
(
  FRELIGION_ID   VARCHAR2(32) not null,
  FRELIGION_CODE VARCHAR2(8) not null,
  FRELIGION_NAME VARCHAR2(40) not null,
  FISAVAILABLE   CHAR(1) not null,
  FRELIGION_DESC VARCHAR2(256),
  FVERSION       NUMBER(6) default 0 not null,
  FLOGCBY        VARCHAR2(32) not null,
  FLOGCDATE      timestamp not null,
  FLOGLUBY       VARCHAR2(32) not null,
  FLOGLUDATE     timestamp not null,
  FLOGLABY       VARCHAR2(32) not null,
  FLOGLADATE     timestamp not null
)
;
alter table FXP.P_RELIGION
  add constraint PK_P_RELIGION primary key (FRELIGION_ID);
alter table FXP.P_RELIGION
  add constraint UK_P_RELIGION_CODE unique (FRELIGION_CODE);

--prompt
--prompt Creating table P_SITE
--prompt =====================
--prompt
create table FXP.P_SITE
(
  FSITE_ID            VARCHAR2(32) not null,
  FSITE_NAME          VARCHAR2(100) not null,
  FSITE_INFO          VARCHAR2(500),
  FORG_ID             VARCHAR2(32) not null,
  FSERVICE_SCOPE_DESC VARCHAR2(500),
  FADDRESS            VARCHAR2(200),
  FSITE_DESC          VARCHAR2(256),
  FCREATE_DATE        timestamp not null,
  FCREATE_USER_ID     VARCHAR2(32) not null,
  FCREATE_USER_NAME   VARCHAR2(50) not null,
  FIS_CANCEL          CHAR(1) not null,
  FCANCEL_REASON      VARCHAR2(300),
  FCANCEL_DATE        timestamp,
  FCANCEL_USER_ID     VARCHAR2(32),
  FCANCEL_USER_NAME   VARCHAR2(30),
  FVERSION            NUMBER(6) default 0 not null,
  FLOGCBY             VARCHAR2(32) not null,
  FLOGCDATE           timestamp not null,
  FLOGLUBY            VARCHAR2(32) not null,
  FLOGLUDATE          timestamp not null,
  FLOGLABY            VARCHAR2(32) not null,
  FLOGLADATE          timestamp not null,
  FADMIN_USER_ID      VARCHAR2(32) not null,
  FCONTACT_MOBILE     VARCHAR2(30) not null,
  FREGION_ID          VARCHAR2(32),
  FREGION_NAME        VARCHAR2(80)
)
;
alter table FXP.P_SITE
  add constraint PK_P_SITE primary key (FSITE_ID);
alter table FXP.P_SITE
  add constraint UK_P_SITE_ORG unique (FORG_ID, FSITE_ID);

--prompt
--prompt Creating table P_SITE_BS_CIRCLE
--prompt ===============================
--prompt
create table FXP.P_SITE_BS_CIRCLE
(
  FSUPPLIER_ID        VARCHAR2(32) not null,
  FSITE_ID            VARCHAR2(32) not null,
  FBUSINESS_CIRCLE_ID VARCHAR2(32) not null,
  FOPERATOR_ID        VARCHAR2(32) not null,
  FCIRCLE_DESC        VARCHAR2(256),
  FCREATE_DATE        timestamp default sysdate not null,
  FCREATE_USER_ID     VARCHAR2(32) not null,
  FCREATE_USER_NAME   VARCHAR2(50) not null,
  FVERSION            NUMBER(6) default 0 not null,
  FLOGCBY             VARCHAR2(32) not null,
  FLOGCDATE           timestamp not null,
  FLOGLUBY            VARCHAR2(32) not null,
  FLOGLUDATE          timestamp not null,
  FLOGLABY            VARCHAR2(32) not null,
  FLOGLADATE          timestamp not null
)
;
alter table FXP.P_SITE_BS_CIRCLE
  add constraint PK_P_SITE_BS_CIRCLE primary key (FSITE_ID, FBUSINESS_CIRCLE_ID);

--prompt
--prompt Creating table P_SITE_PRODUCT
--prompt =============================
--prompt
create table FXP.P_SITE_PRODUCT
(
  FPRODUCT_ID          VARCHAR2(32) not null,
  FPRODUCT_NAME        VARCHAR2(50) not null,
  FPRODUCT_SUBCLASS_ID VARCHAR2(32) not null,
  FPRODUCT_CLASS_ID    VARCHAR2(32) not null,
  FPRODUCT_INFO        VARCHAR2(200),
  FPRODUCT_PRICE       NUMBER(8,2),
  FUPDATE_PRICE        CHAR(1) not null,
  FPRODUCT_UNIT        VARCHAR2(10) not null,
  FSUPPLIER_ID         VARCHAR2(32) not null,
  FSITE_ID             VARCHAR2(32) not null,
  FCREATE_DATE         timestamp default sysdate not null,
  FISAVAILABLE         CHAR(1) not null,
  FUSE_COUPON          CHAR(1) not null,
  FPRODUCT_DESC        VARCHAR2(256),
  FVERSION             NUMBER(6) default 0 not null,
  FLOGCBY              VARCHAR2(32) not null,
  FLOGCDATE            timestamp not null,
  FLOGLUBY             VARCHAR2(32) not null,
  FLOGLUDATE           timestamp not null,
  FLOGLABY             VARCHAR2(32) not null,
  FLOGLADATE           timestamp not null
)
;
alter table FXP.P_SITE_PRODUCT
  add constraint PK_P_SITE_PRODUCT primary key (FPRODUCT_ID);
create index FXP.IDX_P_SITE_PRODUCT_SUPP on FXP.P_SITE_PRODUCT (FSITE_ID);

--prompt
--prompt Creating table P_SITE_SCOPE
--prompt ===========================
--prompt
create table FXP.P_SITE_SCOPE
(
  FSUPPLIER_ID         VARCHAR2(32) not null,
  FSITE_ID             VARCHAR2(32) not null,
  FPRODUCT_SUBCLASS_ID VARCHAR2(32) not null,
  FPRODUCT_CLASS_ID    VARCHAR2(32) not null,
  FDESC                VARCHAR2(256),
  FVERSION             NUMBER(6) default 0 not null,
  FLOGCBY              VARCHAR2(32) not null,
  FLOGCDATE            timestamp not null,
  FLOGLUBY             VARCHAR2(32) not null,
  FLOGLUDATE           timestamp not null,
  FLOGLABY             VARCHAR2(32) not null,
  FLOGLADATE           timestamp not null
)
;
alter table FXP.P_SITE_SCOPE
  add constraint PK_P_SITE_SCOPE primary key (FSITE_ID, FPRODUCT_SUBCLASS_ID);

--prompt
--prompt Creating table P_TEAM_MEMBER
--prompt ============================
--prompt
create table FXP.P_TEAM_MEMBER
(
  FMEMBER_ID        VARCHAR2(32) not null,
  FTEAM_ID          VARCHAR2(32) not null,
  FUSER_ID          VARCHAR2(32) not null,
  FCIRCLE_ID        VARCHAR2(32) not null,
  FMEMBER_DESC      VARCHAR2(256),
  FCREATE_TIME      timestamp default sysdate not null,
  FCREATE_USER_ID   VARCHAR2(32) not null,
  FCREATE_USER_NAME VARCHAR2(50) not null,
  FVERSION          NUMBER(6) default 0 not null,
  FLOGCBY           VARCHAR2(32) not null,
  FLOGCDATE         timestamp not null,
  FLOGLUBY          VARCHAR2(32) not null,
  FLOGLUDATE        timestamp not null,
  FLOGLABY          VARCHAR2(32) not null,
  FLOGLADATE        timestamp not null
)
;
alter table FXP.P_TEAM_MEMBER
  add constraint PK_P_TEAM_MEMBER primary key (FMEMBER_ID);
alter table FXP.P_TEAM_MEMBER
  add constraint UK_P_TEAM_MEMBER_USER unique (FTEAM_ID, FUSER_ID);
alter table FXP.P_TEAM_MEMBER
  add constraint FK_P_TEAM_MEMBER_TEAM foreign key (FTEAM_ID, FCIRCLE_ID)
  references FXP.P_TEAM (FTEAM_ID, FCIRCLE_ID);
alter table FXP.P_TEAM_MEMBER
  add constraint FK_P_TEAM_MEMBER_USER foreign key (FUSER_ID)
  references FXP.P_USER (FUSER_ID);

--prompt
--prompt Creating table P_TODO
--prompt =====================
--prompt
create table FXP.P_TODO
(
  FTODO_ID        VARCHAR2(32) not null,
  FNOTE_TYPE_ID   VARCHAR2(30) not null,
  FNOTE_ID        VARCHAR2(150) not null,
  FTODO_CONTENT   VARCHAR2(300) not null,
  FTODO_REMARK    VARCHAR2(300),
  FCREATE_TIME    timestamp not null,
  FNODE_ID        VARCHAR2(30) not null,
  FNOTE_TAG       VARCHAR2(128) not null,
  FICON_FILE      VARCHAR2(30) not null,
  FBLOCK_NO       VARCHAR2(10) not null,
  FORDERNUM       NUMBER(6,2) not null,
  FIS_GRABBED     CHAR(1) not null,
  FGRAB_TIME      timestamp,
  FGRAB_CIRCLE_ID VARCHAR2(32),
  FGRAB_TEAM_ID   VARCHAR2(32),
  FGRAB_USER_ID   VARCHAR2(32),
  FGRAB_USER_NAME VARCHAR2(40),
  FPERSON_ID      VARCHAR2(32),
  FPERSON_NAME    VARCHAR2(50),
  FFAMILY_ID      VARCHAR2(32),
  FCIRCLE_ID      VARCHAR2(32),
  FVERSION        NUMBER(6) default 0 not null,
  FLOGCBY         VARCHAR2(32) not null,
  FLOGCDATE       timestamp not null,
  FLOGLUBY        VARCHAR2(32) not null,
  FLOGLUDATE      timestamp not null,
  FLOGLABY        VARCHAR2(32) not null,
  FLOGLADATE      timestamp not null
)
;
alter table FXP.P_TODO
  add constraint PK_P_TODO primary key (FTODO_ID);
alter table FXP.P_TODO
  add constraint UK_P_TODO unique (FNOTE_TYPE_ID, FNOTE_ID);
alter table FXP.P_TODO
  add constraint FK_P_TODO_CIRCLE foreign key (FGRAB_CIRCLE_ID)
  references FXP.P_CIRCLE (FCIRCLE_ID);
alter table FXP.P_TODO
  add constraint FK_P_TODO_NODE foreign key (FNOTE_TYPE_ID, FNODE_ID)
  references FXP.P_NOTE_NODE (FNOTE_TYPE_ID, FNODE_ID);
alter table FXP.P_TODO
  add constraint FK_P_TODO_USER foreign key (FGRAB_USER_ID)
  references FXP.P_USER (FUSER_ID);

--prompt
--prompt Creating table P_TODO_AUTO
--prompt ==========================
--prompt
create table FXP.P_TODO_AUTO
(
  FTODO_ID      VARCHAR2(32) not null,
  FNOTE_TYPE_ID VARCHAR2(30) not null,
  FNOTE_ID      VARCHAR2(150) not null,
  FTODO_CONTENT VARCHAR2(300) not null,
  FTODO_REMARK  VARCHAR2(300),
  FCREATE_TIME  timestamp not null,
  FNODE_ID      VARCHAR2(30) not null,
  FVERSION      NUMBER(6) default 0 not null,
  FLOGCBY       VARCHAR2(32) not null,
  FLOGCDATE     timestamp not null,
  FLOGLUBY      VARCHAR2(32) not null,
  FLOGLUDATE    timestamp not null,
  FLOGLABY      VARCHAR2(32) not null,
  FLOGLADATE    timestamp not null
)
;
alter table FXP.P_TODO_AUTO
  add constraint PK_P_TODO_AUTO primary key (FTODO_ID);
alter table FXP.P_TODO_AUTO
  add constraint UK_P_TODO_AUTO unique (FNOTE_TYPE_ID, FNOTE_ID);

--prompt
--prompt Creating table P_TODO_TEAM
--prompt ==========================
--prompt
create table FXP.P_TODO_TEAM
(
  FTODO_ID     VARCHAR2(32) not null,
  FCREATE_TIME timestamp not null,
  FCIRCLE_ID   VARCHAR2(32) not null,
  FTEAM_ID     VARCHAR2(32) not null,
  FVERSION     NUMBER(6) default 0 not null,
  FLOGCBY      VARCHAR2(32) not null,
  FLOGCDATE    timestamp not null,
  FLOGLUBY     VARCHAR2(32) not null,
  FLOGLUDATE   timestamp not null,
  FLOGLABY     VARCHAR2(32) not null,
  FLOGLADATE   timestamp not null
)
;
alter table FXP.P_TODO_TEAM
  add constraint PK_P_TODO_DEPT primary key (FTODO_ID, FCIRCLE_ID, FTEAM_ID);
alter table FXP.P_TODO_TEAM
  add constraint FK_P_TODO_TEAM_TEAM foreign key (FTEAM_ID, FCIRCLE_ID)
  references FXP.P_TEAM (FTEAM_ID, FCIRCLE_ID);

--prompt
--prompt Creating table P_USER_ANSWER_NUM
--prompt ================================
--prompt
create table FXP.P_USER_ANSWER_NUM
(
  FUSER_ID       VARCHAR2(32) not null,
  FANSWER_NUMBER VARCHAR2(30) not null,
  FISDEFAULT     CHAR(1) not null,
  FSET_DESC      VARCHAR2(256),
  FVERSION       NUMBER(6) default 0 not null,
  FLOGCBY        VARCHAR2(32) not null,
  FLOGCDATE      timestamp not null,
  FLOGLUBY       VARCHAR2(32) not null,
  FLOGLUDATE     timestamp not null,
  FLOGLABY       VARCHAR2(32) not null,
  FLOGLADATE     timestamp not null
)
;
alter table FXP.P_USER_ANSWER_NUM
  add constraint PK_P_USER_ANSWER_NUM primary key (FUSER_ID, FANSWER_NUMBER);
alter table FXP.P_USER_ANSWER_NUM
  add constraint FK_P_USER_ANSWER_NUM foreign key (FUSER_ID)
  references FXP.P_USER (FUSER_ID);

--prompt
--prompt Creating table P_USER_BS_CIRCLE
--prompt ===============================
--prompt
create table FXP.P_USER_BS_CIRCLE
(
  FUSER_ID            VARCHAR2(32) not null,
  FBUSINESS_CIRCLE_ID VARCHAR2(32) not null,
  FCREATE_DATE        timestamp default sysdate not null,
  FVERSION            NUMBER(6) default 0 not null,
  FLOGCBY             VARCHAR2(32) not null,
  FLOGCDATE           timestamp not null,
  FLOGLUBY            VARCHAR2(32) not null,
  FLOGLUDATE          timestamp not null,
  FLOGLABY            VARCHAR2(32) not null,
  FLOGLADATE          timestamp not null
)
;
alter table FXP.P_USER_BS_CIRCLE
  add constraint PK_P_USER_BS_CIRCLE primary key (FUSER_ID, FBUSINESS_CIRCLE_ID);

--prompt
--prompt Creating table P_USER_CUR_ORG
--prompt =============================
--prompt
create table FXP.P_USER_CUR_ORG
(
  FUSER_ID    VARCHAR2(32) not null,
  FCUR_ORG_ID VARCHAR2(32) not null,
  FVERSION    NUMBER(6) default 0 not null,
  FLOGCBY     VARCHAR2(32) not null,
  FLOGCDATE   timestamp not null,
  FLOGLUBY    VARCHAR2(32) not null,
  FLOGLUDATE  timestamp not null,
  FLOGLABY    VARCHAR2(32) not null,
  FLOGLADATE  timestamp not null
)
;
alter table FXP.P_USER_CUR_ORG
  add constraint PK_P_USER_CUR_ORG primary key (FUSER_ID);

--prompt
--prompt Creating table P_USER_EMAIL
--prompt ===========================
--prompt
create table FXP.P_USER_EMAIL
(
  FUSER_ID   VARCHAR2(32) not null,
  FEMAIL_NO  VARCHAR2(30) not null,
  FVERSION   NUMBER(6) default 0 not null,
  FLOGCBY    VARCHAR2(32) not null,
  FLOGCDATE  timestamp not null,
  FLOGLUBY   VARCHAR2(32) not null,
  FLOGLUDATE timestamp not null,
  FLOGLABY   VARCHAR2(32) not null,
  FLOGLADATE timestamp not null
)
;
alter table FXP.P_USER_EMAIL
  add constraint PK_P_USER_EMAIL primary key (FUSER_ID);
alter table FXP.P_USER_EMAIL
  add constraint UK_P_USER_EMAIL unique (FEMAIL_NO);
alter table FXP.P_USER_EMAIL
  add constraint FK_P_USER_EMAIL foreign key (FUSER_ID)
  references FXP.P_USER (FUSER_ID);

--prompt
--prompt Creating table P_USER_LOCATION
--prompt ==============================
--prompt
create table FXP.P_USER_LOCATION
(
  FUSER_ID       VARCHAR2(32) not null,
  FREC_TIME      timestamp not null,
  FLOCATION_TIME timestamp not null,
  FCITY          VARCHAR2(16),
  FADDRESS       VARCHAR2(128),
  FLONGITUDE     NUMBER(19,15) not null,
  FLATITUDE      NUMBER(19,15) not null,
  FVERSION       NUMBER(6) default 0 not null,
  FLOGCBY        VARCHAR2(32) not null,
  FLOGCDATE      timestamp not null,
  FLOGLUBY       VARCHAR2(32) not null,
  FLOGLUDATE     timestamp not null,
  FLOGLABY       VARCHAR2(32) not null,
  FLOGLADATE     timestamp not null
)
;
alter table FXP.P_USER_LOCATION
  add constraint PK_P_USER_LOCATION primary key (FUSER_ID);
alter table FXP.P_USER_LOCATION
  add constraint FK_P_USER_LOCATION_USER foreign key (FUSER_ID)
  references FXP.P_USER (FUSER_ID);

--prompt
--prompt Creating table P_USER_MESSAGE
--prompt =============================
--prompt
create table FXP.P_USER_MESSAGE
(
  FMESSAGE_ID        VARCHAR2(32) not null,
  FNOTE_TYPE_ID      VARCHAR2(30) not null,
  FNOTE_ID           VARCHAR2(150) not null,
  FMESSAGE_TITLE     VARCHAR2(300) not null,
  FMESSAGE_CONTENT   VARCHAR2(300) not null,
  FNODE_ID           VARCHAR2(30) not null,
  FSEND_TIME         timestamp not null,
  FSEND_CIRCLE_ID    VARCHAR2(32),
  FSEND_TEAM_ID      VARCHAR2(32),
  FSEND_USER_ID      VARCHAR2(32) not null,
  FRECEIVE_CIRCLE_ID VARCHAR2(32),
  FRECEIVE_TEAM_ID   VARCHAR2(32),
  FRECEIVE_USER_ID   VARCHAR2(32) not null,
  FIS_READ           CHAR(1) not null,
  FVERSION           NUMBER(6) default 0 not null,
  FLOGCBY            VARCHAR2(32) not null,
  FLOGCDATE          timestamp not null,
  FLOGLUBY           VARCHAR2(32) not null,
  FLOGLUDATE         timestamp not null,
  FLOGLABY           VARCHAR2(32) not null,
  FLOGLADATE         timestamp not null
)
;
alter table FXP.P_USER_MESSAGE
  add constraint PK_P_USER_MESSAGE primary key (FMESSAGE_ID);
alter table FXP.P_USER_MESSAGE
  add constraint UK_P_USER_MESSAGE unique (FNOTE_TYPE_ID, FNOTE_ID);
alter table FXP.P_USER_MESSAGE
  add constraint FK_P_USER_MESSAGE_NODE foreign key (FNOTE_TYPE_ID, FNODE_ID)
  references FXP.P_NOTE_NODE (FNOTE_TYPE_ID, FNODE_ID);
alter table FXP.P_USER_MESSAGE
  add constraint FK_P_USER_MESSAGE_RUSER foreign key (FRECEIVE_USER_ID)
  references FXP.P_USER (FUSER_ID);
alter table FXP.P_USER_MESSAGE
  add constraint FK_P_USER_MESSAGE_SUSER foreign key (FSEND_USER_ID)
  references FXP.P_USER (FUSER_ID);
create index FXP.IDX_P_USER_MESSAGE_RECEIVE on FXP.P_USER_MESSAGE (FRECEIVE_USER_ID);

--prompt
--prompt Creating table P_USER_MOBILE
--prompt ============================
--prompt
create table FXP.P_USER_MOBILE
(
  FUSER_ID   VARCHAR2(32) not null,
  FMOBILE_NO VARCHAR2(30) not null,
  FVERSION   NUMBER(6) default 0 not null,
  FLOGCBY    VARCHAR2(32) not null,
  FLOGCDATE  timestamp not null,
  FLOGLUBY   VARCHAR2(32) not null,
  FLOGLUDATE timestamp not null,
  FLOGLABY   VARCHAR2(32) not null,
  FLOGLADATE timestamp not null
)
;
alter table FXP.P_USER_MOBILE
  add constraint PK_P_USER_MOBILE primary key (FUSER_ID);
alter table FXP.P_USER_MOBILE
  add constraint UK_P_USER_MOBILE unique (FMOBILE_NO);
alter table FXP.P_USER_MOBILE
  add constraint FK_P_USER_MOBILE foreign key (FUSER_ID)
  references FXP.P_USER (FUSER_ID);

--prompt
--prompt Creating table P_USER_SIGNATURE
--prompt ===============================
--prompt
create table FXP.P_USER_SIGNATURE
(
  FSIGNATURE_ID      VARCHAR2(32) not null,
  FUSER_ID           VARCHAR2(32) not null,
  FSIGNATURE_CONTENT VARCHAR2(500) not null,
  FSIGNATURE_DATE    timestamp not null,
  FVERSION           NUMBER(6) not null
)
;
alter table FXP.P_USER_SIGNATURE
  add constraint PK_P_USER_SIGNATURE primary key (FSIGNATURE_ID);
alter table FXP.P_USER_SIGNATURE
  add constraint FK_P_USER_SIGNATURE foreign key (FUSER_ID)
  references FXP.P_USER (FUSER_ID);

--prompt
--prompt Creating table P_USER_WECHAT
--prompt ============================
--prompt
create table FXP.P_USER_WECHAT
(
  FOPEN_ID     VARCHAR2(128) not null,
  FUSER_ID     VARCHAR2(32) not null,
  FPUBLIC_NO   VARCHAR2(128) not null,
  FWECHAT_NAME VARCHAR2(50) not null,
  FWECHAT_AREA VARCHAR2(50),
  FWECHAT_SEX  VARCHAR2(10),
  FVERSION     NUMBER(6) default 0 not null,
  FLOGCBY      VARCHAR2(32) not null,
  FLOGCDATE    timestamp not null,
  FLOGLUBY     VARCHAR2(32) not null,
  FLOGLUDATE   timestamp not null,
  FLOGLABY     VARCHAR2(32) not null,
  FLOGLADATE   timestamp not null
)
;
alter table FXP.P_USER_WECHAT
  add constraint PK_P_USER_WECHAT primary key (FOPEN_ID);
alter table FXP.P_USER_WECHAT
  add constraint UK_P_USER_WECHAT unique (FUSER_ID, FPUBLIC_NO);
alter table FXP.P_USER_WECHAT
  add constraint FK_P_USER_WECHAT_USER foreign key (FUSER_ID)
  references FXP.P_USER (FUSER_ID);

--prompt
--prompt Creating table P_VOUCHER
--prompt ========================
--prompt
create table FXP.P_VOUCHER
(
  FVOUCHER_ID      VARCHAR2(32) not null,
  FVOUCHER_NAME    VARCHAR2(100) not null,
  FVOUCHER_BALANCE NUMBER(10,2) default 0 not null,
  FDUETIME_BEGIN   timestamp not null,
  FDUETIME_END     timestamp not null,
  FVOUCHER_DESC    VARCHAR2(256),
  FORDER_ID        VARCHAR2(32) not null,
  FGOODS_ID        VARCHAR2(32) not null,
  FGOODS_NAME      VARCHAR2(100) not null,
  FGOODS_PRICE     NUMBER(10,2) not null,
  FGOODS_UNIT      VARCHAR2(30) not null,
  FSELL_CIRCLE_ID  VARCHAR2(32) not null,
  FACCOUNT_ID      VARCHAR2(32) not null,
  FCREATE_DATE     timestamp not null,
  FCREATE_USER_ID  VARCHAR2(32) not null,
  FCREATE_NICKNAME VARCHAR2(30) not null,
  FVERSION         NUMBER(6) default 0 not null,
  FLOGCBY          VARCHAR2(32) not null,
  FLOGCDATE        timestamp not null,
  FLOGLUBY         VARCHAR2(32) not null,
  FLOGLUDATE       timestamp not null,
  FLOGLABY         VARCHAR2(32) not null,
  FLOGLADATE       timestamp not null
)
;
alter table FXP.P_VOUCHER
  add constraint PK_P_VOUCHER primary key (FVOUCHER_ID);
create index FXP.IDX_P_VOUCHER_ACCOUNT on FXP.P_VOUCHER (FACCOUNT_ID);

--prompt
--prompt Creating table P_VOUCHER_COMPOSE
--prompt ================================
--prompt
create table FXP.P_VOUCHER_COMPOSE
(
  FCOMPOSE_ID   VARCHAR2(32) not null,
  FVOUCHER_ID   VARCHAR2(32) not null,
  FPRODUCT_ID   VARCHAR2(32) not null,
  FPERCENT      NUMBER(4,1) not null,
  FFLOATING     NUMBER(4,1) not null,
  FCOMPOSE_DESC VARCHAR2(256),
  FVERSION      NUMBER(6) default 0 not null,
  FLOGCBY       VARCHAR2(32) not null,
  FLOGCDATE     timestamp not null,
  FLOGLUBY      VARCHAR2(32) not null,
  FLOGLUDATE    timestamp not null,
  FLOGLABY      VARCHAR2(32) not null,
  FLOGLADATE    timestamp not null
)
;
alter table FXP.P_VOUCHER_COMPOSE
  add constraint PK_P_VOUCHER_COMPOSE primary key (FCOMPOSE_ID);
alter table FXP.P_VOUCHER_COMPOSE
  add constraint UK_P_VOUCHER_COMPOSE unique (FVOUCHER_ID, FPRODUCT_ID);

--prompt
--prompt Creating table REQ_JOIN_BUSINESS_CIRCLE
--prompt =======================================
--prompt
create table FXP.REQ_JOIN_BUSINESS_CIRCLE
(
  FREQNOTE_ID         VARCHAR2(32) not null,
  FBUSINESS_CIRCLE_ID VARCHAR2(32) not null,
  FOPERATOR_ID        VARCHAR2(32) not null,
  FREQ_SITE_DESC      VARCHAR2(300) not null,
  FREQ_DESC           VARCHAR2(60),
  FCREATE_TIME        timestamp not null,
  FCREATE_USER_ID     VARCHAR2(32) not null,
  FCREATE_NICKNAME    VARCHAR2(30) not null,
  FLAST_STATE         VARCHAR2(30) not null,
  FLAST_TIME          timestamp not null,
  FLAST_USER_ID       VARCHAR2(32) not null,
  FLAST_NICKNAME      VARCHAR2(40) not null,
  FLAST_DESC          VARCHAR2(256),
  FNEXT_NODE_ID       VARCHAR2(30),
  FNEXT_NODE_CONTENT  VARCHAR2(300),
  FIS_COMPLETE        CHAR(1) not null,
  FCOMPLETE_STATE     VARCHAR2(30),
  FCOMPLETE_TIME      timestamp,
  FCOMPLETE_USER_ID   VARCHAR2(32),
  FCOMPLETE_NICKNAME  VARCHAR2(30),
  FCOMPLETE_DESC      VARCHAR2(256),
  FVERSION            NUMBER(6) default 0 not null,
  FLOGCBY             VARCHAR2(32) not null,
  FLOGCDATE           timestamp not null,
  FLOGLUBY            VARCHAR2(32) not null,
  FLOGLUDATE          timestamp not null,
  FLOGLABY            VARCHAR2(32) not null,
  FLOGLADATE          timestamp not null
)
;
alter table FXP.REQ_JOIN_BUSINESS_CIRCLE
  add constraint PK_REQ_JOIN_BUSINESS_CIRCLE primary key (FREQNOTE_ID);
create index FXP.IDX_REQ_JOIN_BUSINESS_CIRCLE on FXP.REQ_JOIN_BUSINESS_CIRCLE (FBUSINESS_CIRCLE_ID);
create index FXP.IDX_REQ_JOIN_BUSINESS_COMPLETE on FXP.REQ_JOIN_BUSINESS_CIRCLE (FIS_COMPLETE);
create index FXP.IDX_REQ_JOIN_BUSINESS_TIME on FXP.REQ_JOIN_BUSINESS_CIRCLE (FLAST_TIME);

--prompt
--prompt Creating table REQ_JOIN_BUSINESS_SITE
--prompt =====================================
--prompt
create table FXP.REQ_JOIN_BUSINESS_SITE
(
  FREQNOTE_ID         VARCHAR2(32) not null,
  FBUSINESS_CIRCLE_ID VARCHAR2(32) not null,
  FOPERATOR_ID        VARCHAR2(32) not null,
  FSUPPLIER_ID        VARCHAR2(32) not null,
  FSITE_ID            VARCHAR2(32) not null,
  FVERSION            NUMBER(6) default 0 not null,
  FLOGCBY             VARCHAR2(32) not null,
  FLOGCDATE           timestamp not null,
  FLOGLUBY            VARCHAR2(32) not null,
  FLOGLUDATE          timestamp not null,
  FLOGLABY            VARCHAR2(32) not null,
  FLOGLADATE          timestamp not null
)
;
alter table FXP.REQ_JOIN_BUSINESS_SITE
  add constraint PK_REQ_JOIN_BUSINESS_SITE primary key (FREQNOTE_ID, FSITE_ID);

--prompt
--prompt Creating sequence SEQ_ACCOUNT_NO
--prompt ================================
--prompt
create sequence FXP.SEQ_ACCOUNT_NO
minvalue 1
maxvalue 99999999
start with 460
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_ASSESS_REPORT_ID
--prompt ======================================
--prompt
create sequence FXP.SEQ_ASSESS_REPORT_ID
minvalue 1
maxvalue 99999999
start with 100
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_BOSS_ID
--prompt =============================
--prompt
create sequence FXP.SEQ_BOSS_ID
minvalue 1
maxvalue 99999999
start with 100
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_BRANCH_CODE
--prompt =================================
--prompt
create sequence FXP.SEQ_BRANCH_CODE
minvalue 1
maxvalue 99999999
start with 100
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_CALL_CONSULT_SVCNOTE_NO
--prompt =============================================
--prompt
create sequence FXP.SEQ_CALL_CONSULT_SVCNOTE_NO
minvalue 1
maxvalue 99999999
start with 150
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_CALL_GREEN_SVCNOTE_NO
--prompt ===========================================
--prompt
create sequence FXP.SEQ_CALL_GREEN_SVCNOTE_NO
minvalue 1
maxvalue 99999999
start with 120
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_CALL_RED_SVCNOTE_NO
--prompt =========================================
--prompt
create sequence FXP.SEQ_CALL_RED_SVCNOTE_NO
minvalue 1
maxvalue 99999999
start with 120
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_CHGNOTE_NO
--prompt ================================
--prompt
create sequence FXP.SEQ_CHGNOTE_NO
minvalue 1
maxvalue 99999999
start with 100
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_CIRCLE_ID
--prompt ===============================
--prompt
create sequence FXP.SEQ_CIRCLE_ID
minvalue 1
maxvalue 99999999
start with 100
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_COUPON_NO
--prompt ===============================
--prompt
create sequence FXP.SEQ_COUPON_NO
minvalue 1
maxvalue 99999999
start with 250
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_DEPT_ID
--prompt =============================
--prompt
create sequence FXP.SEQ_DEPT_ID
minvalue 1
maxvalue 99999999
start with 100
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_DIS_BOOKING_NOTE_NO
--prompt =========================================
--prompt
create sequence FXP.SEQ_DIS_BOOKING_NOTE_NO
minvalue 1
maxvalue 99999999
start with 100
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_DIS_PHYS_SVCNOTE_NO
--prompt =========================================
--prompt
create sequence FXP.SEQ_DIS_PHYS_SVCNOTE_NO
minvalue 1
maxvalue 99999999
start with 100
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_DIS_SUBJECT_NO
--prompt ====================================
--prompt
create sequence FXP.SEQ_DIS_SUBJECT_NO
minvalue 1
maxvalue 99999999
start with 100
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_ECNA_ASSESS_REPORT
--prompt ========================================
--prompt
create sequence FXP.SEQ_ECNA_ASSESS_REPORT
minvalue 1
maxvalue 99999999
start with 100
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_ECNA_ITEM_ID
--prompt ==================================
--prompt
create sequence FXP.SEQ_ECNA_ITEM_ID
minvalue 1
maxvalue 99999999
start with 100
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_EMP_CODE
--prompt ==============================
--prompt
create sequence FXP.SEQ_EMP_CODE
minvalue 1
maxvalue 99999999
start with 100
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_FAMILY_CODE
--prompt =================================
--prompt
create sequence FXP.SEQ_FAMILY_CODE
minvalue 1
maxvalue 99999999
start with 190
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_HG_REPORT_NO
--prompt ==================================
--prompt
create sequence FXP.SEQ_HG_REPORT_NO
minvalue 1
maxvalue 99999999
start with 120
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_HG_SVCNOTE_NO
--prompt ===================================
--prompt
create sequence FXP.SEQ_HG_SVCNOTE_NO
minvalue 1
maxvalue 99999999
start with 135
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_HMO_AMR_ICVD_EV_NO
--prompt ========================================
--prompt
create sequence FXP.SEQ_HMO_AMR_ICVD_EV_NO
minvalue 1
maxvalue 99999999
start with 100
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_HMO_AMR_MEAL_PRES_NO
--prompt ==========================================
--prompt
create sequence FXP.SEQ_HMO_AMR_MEAL_PRES_NO
minvalue 1
maxvalue 99999999
start with 100
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_HMO_AMR_PSY_REPORT_NO
--prompt ===========================================
--prompt
create sequence FXP.SEQ_HMO_AMR_PSY_REPORT_NO
minvalue 1
maxvalue 99999999
start with 100
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_HMO_AMR_SPORT_PRES_NO
--prompt ===========================================
--prompt
create sequence FXP.SEQ_HMO_AMR_SPORT_PRES_NO
minvalue 1
maxvalue 99999999
start with 100
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_HMO_AMR_SPORT_REPORT_NO
--prompt =============================================
--prompt
create sequence FXP.SEQ_HMO_AMR_SPORT_REPORT_NO
minvalue 1
maxvalue 99999999
start with 100
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_HMO_EVALUATE_REPORT_NO
--prompt ============================================
--prompt
create sequence FXP.SEQ_HMO_EVALUATE_REPORT_NO
minvalue 1
maxvalue 99999999
start with 100
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_HMO_SUBJECT_NO
--prompt ====================================
--prompt
create sequence FXP.SEQ_HMO_SUBJECT_NO
minvalue 1
maxvalue 99999999
start with 100
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_HM_REQNOTE_NO
--prompt ===================================
--prompt
create sequence FXP.SEQ_HM_REQNOTE_NO
minvalue 1
maxvalue 99999999
start with 315
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_IHJ_SVCNOTE_NO
--prompt ====================================
--prompt
create sequence FXP.SEQ_IHJ_SVCNOTE_NO
minvalue 1
maxvalue 99999999
start with 100
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_IJK_DOCTOR_ID
--prompt ===================================
--prompt
create sequence FXP.SEQ_IJK_DOCTOR_ID
minvalue 1
maxvalue 99999999
start with 100
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_IJK_GROUP_ID
--prompt ==================================
--prompt
create sequence FXP.SEQ_IJK_GROUP_ID
minvalue 1
maxvalue 99999999
start with 100
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_ITEM_CODE
--prompt ===============================
--prompt
create sequence FXP.SEQ_ITEM_CODE
minvalue 1
maxvalue 99999999
start with 100
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_LIS_GROUP_ID
--prompt ==================================
--prompt
create sequence FXP.SEQ_LIS_GROUP_ID
minvalue 1
maxvalue 99999999
start with 100
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_NXFT_DELIVE_NOTE_ID
--prompt =========================================
--prompt
create sequence FXP.SEQ_NXFT_DELIVE_NOTE_ID
minvalue 1
maxvalue 99999999
start with 100
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_NXFT_MEAL_ID
--prompt ==================================
--prompt
create sequence FXP.SEQ_NXFT_MEAL_ID
minvalue 1
maxvalue 99999999
start with 100
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_NXFT_ORDER_ID
--prompt ===================================
--prompt
create sequence FXP.SEQ_NXFT_ORDER_ID
minvalue 1
maxvalue 99999999
start with 100
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_NXFT_SUBJECT_ID
--prompt =====================================
--prompt
create sequence FXP.SEQ_NXFT_SUBJECT_ID
minvalue 1
maxvalue 99999999
start with 100
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_ORDER_ID
--prompt ==============================
--prompt
create sequence FXP.SEQ_ORDER_ID
minvalue 1
maxvalue 99999999
start with 100
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_ORG_DIGITAL_NUMBER
--prompt ========================================
--prompt
create sequence FXP.SEQ_ORG_DIGITAL_NUMBER
minvalue 1
maxvalue 99999999
start with 100
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_ORG_ID
--prompt ============================
--prompt
create sequence FXP.SEQ_ORG_ID
minvalue 1
maxvalue 99999999
start with 100
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_PERSON_CODE
--prompt =================================
--prompt
create sequence FXP.SEQ_PERSON_CODE
minvalue 1
maxvalue 99999999
start with 500
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_QYH_USER_ID
--prompt =================================
--prompt
create sequence FXP.SEQ_QYH_USER_ID
minvalue 1
maxvalue 99999999
start with 100
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_REGION_ID
--prompt ===============================
--prompt
create sequence FXP.SEQ_REGION_ID
minvalue 1
maxvalue 99999999
start with 500
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_SITE_CODE
--prompt ===============================
--prompt
create sequence FXP.SEQ_SITE_CODE
minvalue 1
maxvalue 99999999
start with 100
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_TEAM_ID
--prompt =============================
--prompt
create sequence FXP.SEQ_TEAM_ID
minvalue 1
maxvalue 99999999
start with 100
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_TEH_SVCNOTE_NO
--prompt ====================================
--prompt
create sequence FXP.SEQ_TEH_SVCNOTE_NO
minvalue 1
maxvalue 99999999
start with 100
increment by 1
cache 10;

--prompt
--prompt Creating sequence SEQ_WORKSHEET_ID
--prompt ==================================
--prompt
create sequence FXP.SEQ_WORKSHEET_ID
minvalue 1
maxvalue 99999999
start with 100
increment by 1
cache 10;

--prompt
--prompt Creating view PV_REGION_NAME
--prompt ============================
--prompt
create or replace view fxp.pv_region_name as
select r.fregion_id    fregion_id,
       r.fat_class     fat_class,
       p.fregion_id    fprovince_id,
       p.fregion_code  fprovince_code,
       p.fregion_name  fprovince_name,
       p.fordernum     fprovince_ordernum,
       c.fregion_id    fcity_id,
       c.fregion_code  fcity_code,
       c.fregion_name  fcity_name,
       c.fordernum     fcity_ordernum,
       d.fregion_id    fdistrict_id,
       d.fregion_code  fdistrict_code,
       d.fregion_name  fdistrict_name,
       d.fordernum     fdistrict_ordernum,
       s.fregion_id    fstreet_id,
       s.fregion_code  fstreet_code,
       s.fregion_name  fstreet_name,
       s.fordernum     fstreet_ordernum,
       m.fregion_id    fcommittee_id,
       m.fregion_code  fcommittee_code,
       m.fregion_name  fcommittee_name,
       m.fordernum     fcommittee_ordernum,
       r.fversion      fversion,
       r.flogcby       flogcby,
       r.flogcdate     flogcdate,
       r.flogluby      flogluby,
       r.flogludate    flogludate,
       r.floglaby      floglaby,
       r.flogladate    flogladate
  from fxp.p_regionalism r left outer join fxp.p_regionalism p on r.fat_province_id = p.fregion_id
       left outer join fxp.p_regionalism c on r.fat_city_id = c.fregion_id
       left outer join fxp.p_regionalism d on r.fat_district_id = d.fregion_id
       left outer join fxp.p_regionalism s on r.fat_street_id = s.fregion_id
       left outer join fxp.p_regionalism m on r.fat_committee_id = m.fregion_id;
       

-- 本脚本在H2的查询窗口执行，并创建一个函数 getNextbn 
-- CREATE ALIAS wgetNextbn;
-- 注意：本脚本只能在H2的console执行才正确。
CREATE ALIAS FXP.wgetNextbn AS $$
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.h2.tools.SimpleResultSet;

@CODE
    String getNextbn(java.sql.Connection conn,
            String schema, String billTypeId, String orgId, String siteId, String userId, String sysId, Date sdate) throws SQLException {
        String sbh;
        String lsbillclass;

        String sql = "select fbill_class from " + schema + ".P_BILL_TYPE" + " where fbill_type_id = '" + billTypeId + "'";
        try (ResultSet rsclass = conn.createStatement().executeQuery(sql);) {
            if (rsclass.first()) {
                lsbillclass = rsclass.getString(1);
            }
            else  {
                throw new RuntimeException("数据不存在！ tableName [P_BILL_TYPE] fieldName [fbill_class] where fbill_type_id = " + billTypeId);
            }
        }

        if ("GLOBAL".equals(lsbillclass)) {
            sql = "select foutput_expression,fsn_len,fseq_name,fseq_init_val,fseq_start_val "
                    + "from " + schema + ".P_GLOBAL_BILL_NUM where FBILL_TYPE_ID = '" + billTypeId + "'";
            try (ResultSet rs = conn.createStatement().executeQuery(sql);) {
                if (rs.first()) {
                    String lsoutputfmt = rs.getString("foutput_expression");
                    int    lnsnlen = rs.getInt("fsn_len");
                    String lsseqname = rs.getString("fseq_name");
                    long  lninitval = rs.getLong("fseq_init_val");
                    long  lnstartval = rs.getLong("fseq_start_val");
                    long  lnseqval  = getSeqNum(conn, schema, lsseqname);
                    long lnbillsn = lnseqval - lninitval + lnstartval;
                    sbh = vfFormatNum(lnbillsn, orgId, siteId, userId, sysId, sdate, lsoutputfmt, lnsnlen);
                }
                else {
                    throw new RuntimeException("在表P_GLOBAL_BILL_NUM找不到预定BILL_TYPE_ID [ " + billTypeId + " ]");
                }
            }
        }
        else {
            throw new RuntimeException("在表P_BILL_TYPE找不到预定GLOBAL, billTypeId [ " +  billTypeId + " ] " + lsbillclass);
        }

        return sbh;
    }

    /**
     * 得到序列值
     * @param seqName
     * @return
     * @throws SQLException
     */
    static long getSeqNum(java.sql.Connection conn, String schema, String seqName) throws SQLException {

        long irtn;
        String sql = "select " + seqName + ".nextval as useq from dual";
        try (ResultSet rs = conn.createStatement().executeQuery(sql);) {
            rs.first();
            irtn = rs.getLong("useq");
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("序列[ " + seqName + " ]不存在！", e);
        }
        return irtn;
    }

    static String vfFormatNum(long snumber, String orgId, String siteId,
            String userId, String sysId, Date sdate, String snOutput, int snlen) {

        String lsoutput;
        String sfFormat = "%0" + String.valueOf(snlen) + "d";

        lsoutput = snOutput;
        lsoutput = lsoutput.replace("<sysdate.yyyymmdd>", (new SimpleDateFormat("yyyyMMdd")).format(sdate));
        lsoutput = lsoutput.replace("<sysdate.yymmdd>", (new SimpleDateFormat("yyMMdd")).format(sdate));
        lsoutput = lsoutput.replace("<sysdate.hhmmss>", (new SimpleDateFormat("HHmmss")).format(sdate));
        lsoutput = lsoutput.replace("<ucode>", userId);
        lsoutput = lsoutput.replace("<sscode>", sysId);
        lsoutput = lsoutput.replace("<orgcode>", orgId);
        lsoutput = lsoutput.replace("<sitecode>", siteId);
        lsoutput = lsoutput.replace("<sn>", String.format(sfFormat, snumber));
        return lsoutput;
    }
$$;      
  
--spool off
