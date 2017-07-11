--
-- 居家养老档案疾病表
--
-- v1.0 2014.12.08
-- author：wing
--
-- 修改历史：
--
--
--
-- drop table fxp.p_hbc_disease;
create table  fxp.p_hbc_disease (
-- +-----------------------------+--------------+-----------+
   fdisease_id                   varchar2(32)   not null,   -- 常见疾病ID
   fdisease_code                 varchar2(8)    not null,   -- 常见疾病代码
   fdisease_gbcode               varchar2(32),              -- 国标代码
   fdisease_name                 varchar2(40)   not null,   -- 疾病名称
   fisother                      char(1)        not null,   -- 是否是其他项 Y/N  其他项需手工输入备注
   fisavailable                  char(1)        not null,   -- 是否可用？
   fordernum                     number(6,2)    not null,   -- 排序号
   fdisease_desc                 varchar2(256),             -- 备注
   --
   -- 日志
   --
   fversion                      number(6)                  -- 版本号
                                 default 0      not null,
   flogcby                       varchar2(32)   not null,   -- 创建者
   flogcdate                     date default sysdate not null,   -- 创建时间
   flogluby                      varchar2(32)   not null,   -- 最后修改者
   flogludate                    date default sysdate not null,   -- 最后修改时间
   floglaby                      varchar2(32)   not null,   -- 最后访问者
   flogladate                    date default sysdate not null,   -- 最后访问时间
   --
   -- 主键、唯一键
   --
   constraint pk_p_hbc_disease primary key (fdisease_id),
   constraint uk_p_hbc_disease_code unique (fdisease_code)
);

--
-- 同义词
--

insert into p_hbc_disease (FDISEASE_ID, FDISEASE_CODE, FDISEASE_GBCODE, FDISEASE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FDISEASE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('01', '01', '01', '胃病', 'N', 'Y', 1, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_hbc_disease (FDISEASE_ID, FDISEASE_CODE, FDISEASE_GBCODE, FDISEASE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FDISEASE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('02', '02', '02', '肾病', 'N', 'Y', 2, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_hbc_disease (FDISEASE_ID, FDISEASE_CODE, FDISEASE_GBCODE, FDISEASE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FDISEASE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('03', '03', '03', '哮喘', 'N', 'Y', 3, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_hbc_disease (FDISEASE_ID, FDISEASE_CODE, FDISEASE_GBCODE, FDISEASE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FDISEASE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('04', '04', '04', '贫血', 'N', 'Y', 4, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_hbc_disease (FDISEASE_ID, FDISEASE_CODE, FDISEASE_GBCODE, FDISEASE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FDISEASE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('05', '05', '05', '痛风', 'N', 'Y', 5, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_hbc_disease (FDISEASE_ID, FDISEASE_CODE, FDISEASE_GBCODE, FDISEASE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FDISEASE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('06', '06', '06', '脑病', 'N', 'Y', 6, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_hbc_disease (FDISEASE_ID, FDISEASE_CODE, FDISEASE_GBCODE, FDISEASE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FDISEASE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('07', '07', '07', '糖尿病', 'N', 'Y', 7, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_hbc_disease (FDISEASE_ID, FDISEASE_CODE, FDISEASE_GBCODE, FDISEASE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FDISEASE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('08', '08', '08', '高血压', 'N', 'Y', 8, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_hbc_disease (FDISEASE_ID, FDISEASE_CODE, FDISEASE_GBCODE, FDISEASE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FDISEASE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('09', '09', '09', '气管炎', 'N', 'Y', 9, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_hbc_disease (FDISEASE_ID, FDISEASE_CODE, FDISEASE_GBCODE, FDISEASE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FDISEASE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('10', '10', '10', '冠心病', 'N', 'Y', 10, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_hbc_disease (FDISEASE_ID, FDISEASE_CODE, FDISEASE_GBCODE, FDISEASE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FDISEASE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('11', '11', '11', '心脏病', 'N', 'Y', 11, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_hbc_disease (FDISEASE_ID, FDISEASE_CODE, FDISEASE_GBCODE, FDISEASE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FDISEASE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('12', '12', '12', '癫痫病', 'N', 'Y', 12, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_hbc_disease (FDISEASE_ID, FDISEASE_CODE, FDISEASE_GBCODE, FDISEASE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FDISEASE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('13', '13', '13', '关节炎', 'N', 'Y', 13, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_hbc_disease (FDISEASE_ID, FDISEASE_CODE, FDISEASE_GBCODE, FDISEASE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FDISEASE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('14', '14', '14', '皮肤病', 'N', 'Y', 14, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_hbc_disease (FDISEASE_ID, FDISEASE_CODE, FDISEASE_GBCODE, FDISEASE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FDISEASE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('15', '15', '15', '心肌梗塞', 'N', 'Y', 15, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_hbc_disease (FDISEASE_ID, FDISEASE_CODE, FDISEASE_GBCODE, FDISEASE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FDISEASE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('16', '16', '16', '老年痴呆', 'N', 'Y', 16, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_hbc_disease (FDISEASE_ID, FDISEASE_CODE, FDISEASE_GBCODE, FDISEASE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FDISEASE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('17', '17', '17', '精神病', 'N', 'Y', 17, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_hbc_disease (FDISEASE_ID, FDISEASE_CODE, FDISEASE_GBCODE, FDISEASE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FDISEASE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('99', '99', '99', '其它', 'Y', 'Y', 15, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

commit;



