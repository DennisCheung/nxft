--
-- 固话号码设置表
--
--
-- v1.0 2015.03.25
-- author：wing
--
-- 修改历史：
--
--
-- drop table fxp.p_phone_fix ;
create table  fxp.p_phone_fix (
-- +-----------------------------+--------------+-----------+
   farea_code                    varchar2(20)   not null,   -- 区号
   --
   -- 格式属性
   --
   ftotal_length                 number(2)      not null,   -- 号码总长度（含区号）
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
   constraint pk_p_phone_fix primary key (farea_code)
);

--
-- 同义词
--

insert into fxp.p_phone_fix (FAREA_CODE, FTOTAL_LENGTH, FPNONE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('020', 11, '',0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into fxp.p_phone_fix (FAREA_CODE, FTOTAL_LENGTH, FPNONE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0757', 12, '',0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );


insert into fxp.p_phone_fix (FAREA_CODE, FTOTAL_LENGTH, FPNONE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0758', 11, '',0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );


commit;

