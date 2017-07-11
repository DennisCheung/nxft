--
-- 400或800商业电话号码
--
--
--
-- v1.0 2015.03.24
-- author：wing
--
-- 修改历史：
--
--
-- drop table fxp.p_phone_business;
create table  fxp.p_phone_business (
-- +-----------------------------+--------------+-----------+
   fnumber_prefix                varchar2(30)   not null,   -- 电话号码字头
   ftotal_length                 number(2)      not null,   -- 号码总长度
   fphone_desc                   varchar2(256),             -- 备注
   --
   -- 日志
   --
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
   constraint pk_p_phone_business primary key (fnumber_prefix)
);

--
-- 同义词
--

insert into fxp.p_phone_business (FNUMBER_PREFIX, FTOTAL_LENGTH, FPHONE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('400', 10, '400电话', 0, 'admin', sysdate , 'admin', sysdate , 'admin', sysdate );

insert into fxp.p_phone_business (FNUMBER_PREFIX, FTOTAL_LENGTH, FPHONE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('800', 10, '800电话', 0, 'admin', sysdate , 'admin', sysdate , 'admin', sysdate );


commit;
