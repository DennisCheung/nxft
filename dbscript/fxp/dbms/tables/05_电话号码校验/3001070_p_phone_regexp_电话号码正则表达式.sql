--
-- 电话号码正则表达式
--
--
--
-- v1.0 2015.04.07
-- author：wing
--
-- 修改历史：
--
--
-- drop table fxp.p_phone_regexp ;
create table  fxp.p_phone_regexp (
-- +-----------------------------+--------------+-----------+
   fregexp_id                    varchar2(32)   not null,   -- 表达式id
   fphone_regexp                 varchar2(100)  not null,   -- 电话正则表达式
   fphone_type_id                varchar2(32)   not null,   -- 电话类型id
   fordernum                     number(6,2)    not null,   -- 排序号
   fregexp_desc                  varchar2(256),             -- 备注
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
   constraint pk_p_phone_regexp primary key (fregexp_id),
   constraint uk_p_phone_regexp unique (fphone_regexp)
);

--
-- 同义词
--

-- 1.固话

-- 1.1 以2,3,5,6,7 开头

-- 1.1.1 以2,3,5,6,7 开头 + 不带区号的固话

insert into fxp.p_phone_regexp (FREGEXP_ID, FPHONE_REGEXP, FPHONE_TYPE_ID, FORDERNUM, FREGEXP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('111', '^[2|3|5|6|7]', '1', 111, '以2,3,5,6,7 开头，是不带区号的固话', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

-- 1.1.2  三位长途区号+ 以2,3,5,6,7 开头的固话

insert into fxp.p_phone_regexp (FREGEXP_ID, FPHONE_REGEXP, FPHONE_TYPE_ID, FORDERNUM, FREGEXP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('112', '^0[1-9][0-9][2|3|5|6|7]', '1', 112, '三位长途区号+ 以2,3,5,6,7 开头的固话', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

-- 1.1.3  四位长途区号+ 以2,3,5,6,7 开头的固话

insert into fxp.p_phone_regexp (FREGEXP_ID, FPHONE_REGEXP, FPHONE_TYPE_ID, FORDERNUM, FREGEXP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('113', '^0[1-9][0-9][0-9][2|3|5|6|7]', '1', 113, '四位长途区号+ 以2,3,5,6,7 开头的固话', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);


-- 1.2 以4,8 开头（排除400，800 电话）

-- 1.2.1  以4,8 开头（排除400，800 电话）+ ，不带区号
insert into fxp.p_phone_regexp (FREGEXP_ID, FPHONE_REGEXP, FPHONE_TYPE_ID, FORDERNUM, FREGEXP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('121', '^[4|8](?!00)', '1', 121, '以4,8 开头，不带区号的固话（排除400，800 电话）', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

-- 1.2.2  三位长途区号+ 以4,8 开头，固话（排除400，800 电话）

insert into fxp.p_phone_regexp (FREGEXP_ID, FPHONE_REGEXP, FPHONE_TYPE_ID, FORDERNUM, FREGEXP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('122', '^0[1-9][0-9][4|8](?!00)', '1', 122, '三位长途区号+ 以4,8 开头，固话（排除400，800 电话）', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

-- 1.2.3 四位长途区号+ 以4,8 开头，固话（排除400，800 电话）

insert into fxp.p_phone_regexp (FREGEXP_ID, FPHONE_REGEXP, FPHONE_TYPE_ID, FORDERNUM, FREGEXP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('123', '^0[1-9][0-9][0-9][4|8](?!00)', '1', 123, '四位长途区号+ 以4,8 开头，固话（排除400，800 电话）', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

-- 2.手机

-- 2.1  13X,15X,18X

insert into fxp.p_phone_regexp (FREGEXP_ID, FPHONE_REGEXP, FPHONE_TYPE_ID, FORDERNUM, FREGEXP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('201', '^1[3|5|8][0-9]', '2', 201, '13X,15X,18X 手机号码', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

-- 2.2  145,147,170,176,177
insert into fxp.p_phone_regexp (FREGEXP_ID, FPHONE_REGEXP, FPHONE_TYPE_ID, FORDERNUM, FREGEXP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('202', '^1[45|47|70|76|77]', '2', 202, '13X,14X,15X,17X,18X 手机号码', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);


-- 3. 400和800电话

insert into fxp.p_phone_regexp (FREGEXP_ID, FPHONE_REGEXP, FPHONE_TYPE_ID, FORDERNUM, FREGEXP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('301', '^[4|8]00', '3', 301, '400或800开头是400或800电话', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

-- 4. 特服电话

-- 4.1 1开头三位特服号

-- 4.1.1  不带区号1开头三位特服号
insert into fxp.p_phone_regexp (FREGEXP_ID, FPHONE_REGEXP, FPHONE_TYPE_ID, FORDERNUM, FREGEXP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('411', '^1[1|2]\d{1}$', '4', 411, '1开头三位特服号', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);


-- 4.1.2  三位长途区号+ 1开头三位特服号
insert into fxp.p_phone_regexp (FREGEXP_ID, FPHONE_REGEXP, FPHONE_TYPE_ID, FORDERNUM, FREGEXP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('412', '^0[1-9][0-9]1[1|2]\d{1}$', '4', 412, '三位长途区号+ 1开头三位特服号', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);


-- 4.1.3 四位长途区号+ 1开头三位特服号
insert into fxp.p_phone_regexp (FREGEXP_ID, FPHONE_REGEXP, FPHONE_TYPE_ID, FORDERNUM, FREGEXP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('413', '^0[1-9][0-9][0-9]1[1|2]\d{1}$', '4', 413, '四位长途区号+ 1开头三位特服号', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

-- 4.2 1开头5位特服号

-- 4.2.1  不带区号 + 1开头5位特服号
insert into fxp.p_phone_regexp (FREGEXP_ID, FPHONE_REGEXP, FPHONE_TYPE_ID, FORDERNUM, FREGEXP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('421', '^(10|11|12|16|17)\d{3}$', '4', 421, '不带区号 + 1开头5位特服号', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

-- 4.2.2  三位长途区号 + 1开头5位特服号
insert into fxp.p_phone_regexp (FREGEXP_ID, FPHONE_REGEXP, FPHONE_TYPE_ID, FORDERNUM, FREGEXP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('422', '^0[1-9][0-9](10|11|12|16|17)\d{3}$', '4', 422, '三位长途区号 + 1开头5位特服号', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

-- 4.2.3  四位长途区号 + 1开头5位特服号
insert into fxp.p_phone_regexp (FREGEXP_ID, FPHONE_REGEXP, FPHONE_TYPE_ID, FORDERNUM, FREGEXP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('423', '^0[1-9][0-9][0-9](10|11|12|16|17)\d{3}$', '4', 423, '四位长途区号 + 1开头5位特服号', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

-- 4.3 9开头5位特服号

-- 4.3.1 不带区号 + 9开头5位特服号
insert into fxp.p_phone_regexp (FREGEXP_ID, FPHONE_REGEXP, FPHONE_TYPE_ID, FORDERNUM, FREGEXP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('431', '^(95|96)\d{3}$', '4', 431, '不带区号 + 9开头5位特服号', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

-- 4.3.2 三位长途区号 + 9开头5位特服号
insert into fxp.p_phone_regexp (FREGEXP_ID, FPHONE_REGEXP, FPHONE_TYPE_ID, FORDERNUM, FREGEXP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('432', '^0[1-9][0-9](95|96)\d{3}$', '4', 432, '三位长途区号 + 9开头5位特服号', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

-- 4.3.3 四位长途区号 + 9开头5位特服号
insert into fxp.p_phone_regexp (FREGEXP_ID, FPHONE_REGEXP, FPHONE_TYPE_ID, FORDERNUM, FREGEXP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('433', '^0[1-9][0-9][0-9](95|96)\d{3}$', '4', 433, '四位长途区号 + 9开头5位特服号', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

commit;

