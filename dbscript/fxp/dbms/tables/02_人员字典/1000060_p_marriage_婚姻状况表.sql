--
-- 婚姻状况表
--
-- v1.0 2014.12.08
-- author：wing
--
-- 修改历史：
--
--
--
-- drop table fxp.p_marriage;
create table  fxp.p_marriage (
-- +-----------------------------+--------------+-----------+
   fmarriage_id                  varchar2(32)   not null,   -- 婚姻状况ID
   fmarriage_code                varchar2(8)    not null,   -- 婚姻状况代码
   fmarriage_gbcode              varchar2(32),              -- 国标代码
   fmarriage_name                varchar2(40)   not null,   -- 婚姻状况名称
   fisavailable                  char(1)        not null,   -- 是否可用？
   fordernum                     number(6,2)    not null,   -- 排序号
   fmarriage_desc                varchar2(256),             -- 备注
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
   constraint pk_p_marriage primary key (fmarriage_id),
   constraint uk_p_marriage_code unique (fmarriage_code)
);

--
-- 同义词
--

insert into p_marriage (FMARRIAGE_ID, FMARRIAGE_CODE, FMARRIAGE_GBCODE, FMARRIAGE_NAME, FISAVAILABLE, FORDERNUM, FMARRIAGE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('01', '01', '01', '未婚', 'Y', 1, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy') );

insert into p_marriage (FMARRIAGE_ID, FMARRIAGE_CODE, FMARRIAGE_GBCODE, FMARRIAGE_NAME, FISAVAILABLE, FORDERNUM, FMARRIAGE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('02', '02', '02', '已婚', 'Y', 1, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy') );

insert into p_marriage (FMARRIAGE_ID, FMARRIAGE_CODE, FMARRIAGE_GBCODE, FMARRIAGE_NAME, FISAVAILABLE, FORDERNUM, FMARRIAGE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('03', '03', '03', '离异', 'Y', 1, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy') );

commit;

