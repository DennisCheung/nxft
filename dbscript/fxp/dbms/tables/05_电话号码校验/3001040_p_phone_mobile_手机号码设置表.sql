--
-- 手机号码设置表
--
--
--
-- v1.0 2015.03.24
-- author：wing
--
-- 修改历史：
--
--
--
-- drop table fxp.p_phone_mobile ;
create table  fxp.p_phone_mobile (
-- +-----------------------------+--------------+-----------+
   fnumber_begin                 varchar2(30)   not null,   -- 电话号码段起号    包含  1301234
   fnumber_end                   varchar2(30)   not null,   -- 电话号码段止号    包含  1301334
   --
   -- 属性
   --
   ftotal_length                 number(2)      not null,   -- 电话号码总长度
   farea_code                    varchar2(20)   not null,   -- 区号
   fpnone_desc                   varchar2(256),             -- 备注
   --
   -- 日志
   --
-- +-----------------------------+--------------+-----------+
   fversion                      number(6)                  -- 版本号
                                 default 0       not null,
   flogcby                       varchar2(32)               -- 创建者
                                 default 'admin' not null,
   flogcdate                     date                       -- 创建时间
                                 default sysdate not null,
   flogluby                      varchar2(32)               -- 最后修改者
                                 default 'admin' not null,
   flogludate                    date                       -- 最后修改时间
                                 default sysdate not null,
   floglaby                      varchar2(32)               -- 最后访问者
                                 default 'admin' not null,
   flogladate                    date                       -- 最后访问时间
                                 default sysdate not null,
   --
   -- 主键、唯一键
   --
   constraint pk_p_phone_mobile primary key (fnumber_begin),
   constraint uk_p_phone_mobile_end unique (fnumber_end)
);

--
-- 同义词
--
-- 130
insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1300000', '1300049', 11, '020',  '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1300050', '1300060', 11, '020',  '',0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1300061', '1300070', 11, '0757', '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1300071', '1309999', 11, '020',  '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

-- 131
insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1310000', '1319999', 11, '020',  '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

-- 132
insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1320000', '1329999', 11, '020',  '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

-- 133

insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1330000', '1330060', 11, '020', '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1330061', '1330070', 11, '0757', '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1330071', '1339999', 11, '020', '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

-- 134

insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1340000', '1340060', 11, '020', '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1340061', '1340070', 11, '0758', '',0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1340071', '1349999', 11, '020', '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

-- 135
insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1350000', '1350060', 11, '020', '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1350061', '1350070', 11, '0758', '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1350071', '1359999', 11, '020', '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

-- 136
insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1360000', '1369999', 11, '020',  '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

-- 137
insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1370000', '1379999', 11, '020',  '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

-- 138
insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1380000', '1389999', 11, '020',  '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

-- 139
insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1390000', '1399999', 11, '020',  '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

-- 150
insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1500000', '1509999', 11, '020',  '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

-- 151
insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1510000', '1519999', 11, '020',  '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

-- 152
insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1520000', '1529999', 11, '020',  '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

-- 153
insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1530000', '1539999', 11, '020',  '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

-- 154
insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1540000', '1549999', 11, '020',  '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

-- 155
insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1550000', '1559999', 11, '020',  '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

-- 156
insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1560000', '1569999', 11, '020',  '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

-- 157
insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1570000', '1579999', 11, '020',  '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

-- 158

insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1580000', '1580040', 11, '020',  '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );


insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1580041', '1580043', 11, '020',  '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1580044', '1589999', 11, '020',  '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

-- 180

insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1800000', '1809999', 11, '020',  '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

-- 181

insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1810000', '1819999', 11, '020',  '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

-- 182

insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1820000', '1829999', 11, '020',  '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

-- 183

insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1830000', '1839999', 11, '020',  '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

-- 184

insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1840000', '1849999', 11, '020',  '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

-- 185

insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1850000', '1859999', 11, '020',  '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

-- 186

insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1860000', '1869999', 11, '020',  '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

-- 187

insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1870000', '1879999', 11, '020',  '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

-- 188

insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1880000', '1889999', 11, '020',  '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

-- 189

insert into fxp.p_phone_mobile (FNUMBER_BEGIN, FNUMBER_END, FTOTAL_LENGTH, FAREA_CODE, fpnone_desc, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('1890000', '1899999', 11, '020',  '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );





commit;
