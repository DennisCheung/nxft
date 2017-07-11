--
-- 电话类型表
-- 该表记录为常量，1,2,3,4 如增加需修改电话校验模块。
--
--
-- v1.0 2015.03.25
-- author：wing
--
-- 修改历史：
--
--
-- drop table fxp.p_phone_type ;
create table  fxp.p_phone_type (
-- +-----------------------------+--------------+-----------+
   fphone_type_id                varchar2(32)   not null,   -- 电话类型id
   fphone_type_code              varchar2(8)    not null,   -- 电话类型代码
   fphone_type_name              varchar2(40)   not null,   -- 电话类型名称
   fphone_type_desc              varchar2(256),             -- 备注
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
   constraint pk_p_phone_type primary key (fphone_type_id),
   constraint uk_p_phone_type_code unique (fphone_type_code)
);

--
-- 同义词
--

insert into fxp.p_phone_type (FPHONE_TYPE_ID, FPHONE_TYPE_CODE, FPHONE_TYPE_NAME, FPHONE_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('1', '1', '固话', '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

insert into fxp.p_phone_type (FPHONE_TYPE_ID, FPHONE_TYPE_CODE, FPHONE_TYPE_NAME, FPHONE_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('2', '2', '手机', '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

insert into fxp.p_phone_type (FPHONE_TYPE_ID, FPHONE_TYPE_CODE, FPHONE_TYPE_NAME, FPHONE_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('3', '3', '400电话', '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

insert into fxp.p_phone_type (FPHONE_TYPE_ID, FPHONE_TYPE_CODE, FPHONE_TYPE_NAME, FPHONE_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('4', '4', '特服电话', '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

commit;