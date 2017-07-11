--
-- 居住情况表
--
-- v1.0 2014.12.08
-- author：wing
--
-- 修改历史：
--
--
--
-- drop table fxp.p_living_condi;
create table  fxp.p_living_condi (
-- +-----------------------------+--------------+-----------+
   fliving_condi_id              varchar2(32)   not null,   -- 居住情况ID
   fliving_condi_code            varchar2(8)    not null,   -- 居住情况代码
   fliving_condi_gbcode          varchar2(32),              -- 国标代码
   fliving_condi_name            varchar2(40)   not null,   -- 居住情况名称
   fisavailable                  char(1)        not null,   -- 是否可用？
   fordernum                     number(6,2)    not null,   -- 排序号
   fliving_condi_desc            varchar2(256),             -- 备注
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
   constraint pk_p_living_condi primary key (fliving_condi_id),
   constraint uk_p_living_condi_code unique (fliving_condi_code)
);

--
-- 同义词
--

insert into p_living_condi (FLIVING_CONDI_ID, FLIVING_CONDI_CODE, FLIVING_CONDI_GBCODE, FLIVING_CONDI_NAME, FISAVAILABLE, FORDERNUM, FLIVING_CONDI_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('03', '03', '03', '夫妻同住', 'Y', 1.00, '', 0, 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into p_living_condi (FLIVING_CONDI_ID, FLIVING_CONDI_CODE, FLIVING_CONDI_GBCODE, FLIVING_CONDI_NAME, FISAVAILABLE, FORDERNUM, FLIVING_CONDI_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('05', '05', '05', '有子女同住', 'Y', 2.00, '', 0, 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into p_living_condi (FLIVING_CONDI_ID, FLIVING_CONDI_CODE, FLIVING_CONDI_GBCODE, FLIVING_CONDI_NAME, FISAVAILABLE, FORDERNUM, FLIVING_CONDI_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('06', '06', '06', '有亲戚（朋友）陪住', 'Y', 3.00, '', 0, 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into p_living_condi (FLIVING_CONDI_ID, FLIVING_CONDI_CODE, FLIVING_CONDI_GBCODE, FLIVING_CONDI_NAME, FISAVAILABLE, FORDERNUM, FLIVING_CONDI_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('04', '04', '04', '有保姆', 'Y', 4.00, '', 0, 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into p_living_condi (FLIVING_CONDI_ID, FLIVING_CONDI_CODE, FLIVING_CONDI_GBCODE, FLIVING_CONDI_NAME, FISAVAILABLE, FORDERNUM, FLIVING_CONDI_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('01', '01', '01', '孤寡', 'Y', 5.00, '', 0, 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into p_living_condi (FLIVING_CONDI_ID, FLIVING_CONDI_CODE, FLIVING_CONDI_GBCODE, FLIVING_CONDI_NAME, FISAVAILABLE, FORDERNUM, FLIVING_CONDI_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('02', '02', '02', '独居', 'Y', 6.00, '', 0, 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into p_living_condi (FLIVING_CONDI_ID, FLIVING_CONDI_CODE, FLIVING_CONDI_GBCODE, FLIVING_CONDI_NAME, FISAVAILABLE, FORDERNUM, FLIVING_CONDI_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('99', '99', '99', '其他', 'Y', 7.00, '', 0, 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'));

commit;



