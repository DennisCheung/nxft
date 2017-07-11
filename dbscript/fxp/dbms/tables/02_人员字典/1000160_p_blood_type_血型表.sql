--
-- 血型表ABO 血型,还有 Rh 血型 (1 RH阳性, 2 RH阴性, 9 RH血型不详 )
--
-- v1.0 2015.01.12
-- author：wing
-- 
--
-- drop table fxp.p_blood_type;
create table  fxp.p_blood_type (
-- +-----------------------------+--------------+-----------+
   fblood_type_id                varchar2(32)   not null,   -- 血型ID
   fblood_type_code              varchar2(8)    not null,   -- 血型代码
   fblood_type_gbcode            varchar2(32),              -- 国标代码 1 A,2 B,3 O, 4 AB, 9 不祥
   fblood_type_name              varchar2(40)   not null,   -- 血型名称
   fisavailable                  char(1)        not null,   -- 是否可用？
   fordernum                     number(6,2)    not null,   -- 排序号
   fblood_type_desc              varchar2(256),             -- 备注
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
   constraint pk_p_blood_type primary key (fblood_type_id),
   constraint uk_p_blood_type_code unique (fblood_type_code)
);

--
-- 外部键约束
--
--
-- 授权
--
grant select on p_blood_type to public;

--
-- 修改语句
--

insert into p_blood_type (FBLOOD_TYPE_ID, FBLOOD_TYPE_CODE, FBLOOD_TYPE_GBCODE, FBLOOD_TYPE_NAME, FISAVAILABLE, FORDERNUM, FBLOOD_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('01', '01', '01', 'A', 'Y', 1.00, 'A', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_blood_type (FBLOOD_TYPE_ID, FBLOOD_TYPE_CODE, FBLOOD_TYPE_GBCODE, FBLOOD_TYPE_NAME, FISAVAILABLE, FORDERNUM, FBLOOD_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('02', '02', '02', 'B', 'Y', 2.00, 'B', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

insert into p_blood_type (FBLOOD_TYPE_ID, FBLOOD_TYPE_CODE, FBLOOD_TYPE_GBCODE, FBLOOD_TYPE_NAME, FISAVAILABLE, FORDERNUM, FBLOOD_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('03', '03', '03', 'O', 'Y', 3.00, 'O', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_blood_type (FBLOOD_TYPE_ID, FBLOOD_TYPE_CODE, FBLOOD_TYPE_GBCODE, FBLOOD_TYPE_NAME, FISAVAILABLE, FORDERNUM, FBLOOD_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('04', '04', '04', 'AB', 'Y', 4.00, 'AB', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

commit;
