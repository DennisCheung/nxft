--
-- 全国统一特种服务电话表，登记特服电话号码
--
--
--
-- v1.0 2015.03.24
-- author：wing
--
-- 修改历史：
--
--
-- drop table fxp.p_phone_special;
create table  fxp.p_phone_special (
-- +-----------------------------+--------------+-----------+
   fphone_number                 varchar2(30)   not null,   -- 电话号码
   fphone_desc                   varchar2(256),             -- 备注
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
   constraint pk_p_phone_special primary key (fphone_number)
);

--
-- 同义词
--

insert into fxp.p_phone_special (FPHONE_NUMBER, FPHONE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('110', '民警、匪警', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into fxp.p_phone_special (FPHONE_NUMBER, FPHONE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('112',  '报修', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );


insert into fxp.p_phone_special (FPHONE_NUMBER, FPHONE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('12110',  '公安短信报警', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into fxp.p_phone_special (FPHONE_NUMBER, FPHONE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('120',  '急救中心', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into fxp.p_phone_special (FPHONE_NUMBER, FPHONE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('119',  '火警', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into fxp.p_phone_special (FPHONE_NUMBER, FPHONE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('95119', '森林火警', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );


insert into fxp.p_phone_special (FPHONE_NUMBER, FPHONE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('117',  '北京时间', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );


insert into fxp.p_phone_special (FPHONE_NUMBER, FPHONE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('121',  '天气预报', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );


insert into fxp.p_phone_special (FPHONE_NUMBER, FPHONE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('122',  '交通事故、交警', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );


insert into fxp.p_phone_special (FPHONE_NUMBER, FPHONE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('11183', 'EMS', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into fxp.p_phone_special (FPHONE_NUMBER, FPHONE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('11185', '邮政业务', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into fxp.p_phone_special (FPHONE_NUMBER, FPHONE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('160', '声讯', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );


insert into fxp.p_phone_special (FPHONE_NUMBER, FPHONE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('12349', '民政公益热线', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

commit;
