--
-- 票据号类型表
-- 
-- 
--
-- v1.0 2015.09.09
-- author：wing
--
-- 修改历史：
-- 
-- 
-- drop table fxp.p_bill_type ;
create table  fxp.p_bill_type (
-- +-----------------------------+--------------+-----------+
   fbill_type_id                 varchar2(32)   not null,   -- 票据类型id  
   fbill_type_code               varchar2(30)   not null,   -- 票据类型代码
   fbill_type_name               varchar2(40)   not null,   -- 票据类型名称
   fbill_class                   varchar2(30)   not null,   -- 票据号分类    GLOBAL 全局  ORG  机构   SITE  商户  USER  操作员
   fisavailable                  char(1)        not null,   -- 是否有效？Y/N
   fbill_type_desc               varchar2(256),             -- 备注   
   --
   -- 日志
   --
   fversion                      number(6)                   -- 版本号
                                 default 0       not null,
   flogcby                       varchar2(32)   
                                 default 'admin' not null,   -- 创建者
   flogcdate                     date 
                                 default sysdate 
                                 not null,   -- 创建时间
   flogluby                      varchar2(32)   
                                 default 'admin' 
                                 not null,   -- 最后修改者
   flogludate                    date 
                                 default sysdate 
                                 not null,   -- 最后修改时间
   floglaby                      varchar2(32)   
                                 default 'admin' 
                                 not null,   -- 最后访问者
   flogladate                    date 
                                 default sysdate 
                                 not null,   -- 最后访问时间
   --
   -- 主键、唯一键
   --
   constraint pk_p_bill_type primary key (fbill_type_id),
   constraint uk_p_bill_type_code unique (fbill_type_code)
);

--
-- 同义词
--

insert into p_bill_type (FBILL_TYPE_ID, FBILL_TYPE_CODE, FBILL_TYPE_NAME, FBILL_CLASS, FISAVAILABLE, FBILL_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('PERSON_CODE', 'PERSON_CODE', '客户编号', 'GLOBAL', 'Y', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

insert into p_bill_type (FBILL_TYPE_ID, FBILL_TYPE_CODE, FBILL_TYPE_NAME, FBILL_CLASS, FISAVAILABLE, FBILL_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('FAMILY_CODE', 'FAMILY_CODE', '家庭编号', 'GLOBAL', 'Y', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

insert into p_bill_type (FBILL_TYPE_ID, FBILL_TYPE_CODE, FBILL_TYPE_NAME, FBILL_CLASS, FISAVAILABLE, FBILL_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('EMP_CODE', 'FEMP_CODE', '职工编码', 'GLOBAL', 'Y', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

insert into p_bill_type (FBILL_TYPE_ID, FBILL_TYPE_CODE, FBILL_TYPE_NAME, FBILL_CLASS, FISAVAILABLE, FBILL_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('ORG_ID', 'FORG_ID', '机构编码', 'GLOBAL', 'Y', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

insert into p_bill_type (FBILL_TYPE_ID, FBILL_TYPE_CODE, FBILL_TYPE_NAME, FBILL_CLASS, FISAVAILABLE, FBILL_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('DEPT_ID', 'FDEPT_ID', '部门编码', 'GLOBAL', 'Y', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

insert into p_bill_type (FBILL_TYPE_ID, FBILL_TYPE_CODE, FBILL_TYPE_NAME, FBILL_CLASS, FISAVAILABLE, FBILL_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('SITE_CODE', 'SITE_CODE', '商户编码', 'GLOBAL', 'Y', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

insert into p_bill_type (FBILL_TYPE_ID, FBILL_TYPE_CODE, FBILL_TYPE_NAME, FBILL_CLASS, FISAVAILABLE, FBILL_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('ACCOUNT_NO', 'ACCOUNT_NO', '账户编码', 'GLOBAL', 'Y', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

insert into p_bill_type (FBILL_TYPE_ID, FBILL_TYPE_CODE, FBILL_TYPE_NAME, FBILL_CLASS, FISAVAILABLE, FBILL_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('HG_SVCNOTE_NO', 'HG_SVCNOTE_NO', '健康指导服务单号', 'GLOBAL', 'Y', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

insert into p_bill_type (FBILL_TYPE_ID, FBILL_TYPE_CODE, FBILL_TYPE_NAME, FBILL_CLASS, FISAVAILABLE, FBILL_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('HG_REPORT_NO', 'HG_REPORT_NO', '健康指导报告单号', 'GLOBAL', 'Y', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

insert into p_bill_type (FBILL_TYPE_ID, FBILL_TYPE_CODE, FBILL_TYPE_NAME, FBILL_CLASS, FISAVAILABLE, FBILL_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('HM_REQNOTE_NO', 'HM_REQNOTE_NO', '健康指导申请单号', 'GLOBAL', 'Y', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

insert into p_bill_type (FBILL_TYPE_ID, FBILL_TYPE_CODE, FBILL_TYPE_NAME, FBILL_CLASS, FISAVAILABLE, FBILL_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('CALL_RED_SVCNOTE_NO', 'CALL_RED_SVCNOTE_NO', '求救服务单号', 'GLOBAL', 'Y', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

insert into p_bill_type (FBILL_TYPE_ID, FBILL_TYPE_CODE, FBILL_TYPE_NAME, FBILL_CLASS, FISAVAILABLE, FBILL_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('CALL_GREEN_SVCNOTE_NO', 'CALL_GREEN_SVCNOTE_NO', '求救服务单号', 'GLOBAL', 'Y', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

insert into p_bill_type (FBILL_TYPE_ID, FBILL_TYPE_CODE, FBILL_TYPE_NAME, FBILL_CLASS, FISAVAILABLE, FBILL_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('CALL_CONSULT_SVCNOTE_NO', 'CALL_CONSULT_SVCNOTE_NO', '咨询服务单号', 'GLOBAL', 'Y', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

commit;
