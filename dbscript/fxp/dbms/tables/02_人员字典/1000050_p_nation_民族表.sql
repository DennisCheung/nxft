--
-- 民族表
--
-- v1.0 2014.12.08
-- author：wing
--
-- 修改历史：
--
--
-- drop table fxp.p_nation;
create table fxp.p_nation (
-- +-----------------------------+--------------+-----------+
   fnation_id                    varchar2(32)   not null,   -- 民族ID
   fnation_code                  varchar2(8)    not null,   -- 民族代码
   fnation_gbcode                varchar2(32),              -- 国标代码
   fnation_name                  varchar2(40)   not null,   -- 民族名称
   fisavailable                  char(1)        not null,   -- 是否可用？
   fordernum                     number(6,2)    not null,   -- 排序号
   fnation_desc                  varchar2(256),             -- 备注
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
   constraint pk_p_nation primary key (fnation_id),
   constraint uk_p_nation_code unique (fnation_code)
);

--
-- 同义词
--

insert into p_nation (fnation_id, fnation_code, fnation_gbcode, fnation_name, fisavailable, fordernum, fnation_desc, fversion, flogcby, flogcdate, flogluby, flogludate, floglaby, flogladate )
values ('01', '01', '01', '汉族', 'Y', 1, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_nation (fnation_id, fnation_code, fnation_gbcode, fnation_name, fisavailable, fordernum, fnation_desc, fversion, flogcby, flogcdate, flogluby, flogludate, floglaby, flogladate )
values ('02', '02', '02', '壮族', 'Y', 2, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_nation (fnation_id, fnation_code, fnation_gbcode, fnation_name, fisavailable, fordernum, fnation_desc, fversion, flogcby, flogcdate, flogluby, flogludate, floglaby, flogladate )
values ('03', '03', '03', '满族', 'Y', 3, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_nation (fnation_id, fnation_code, fnation_gbcode, fnation_name, fisavailable, fordernum, fnation_desc, fversion, flogcby, flogcdate, flogluby, flogludate, floglaby, flogladate )
values ('04', '04', '04', '回族', 'Y', 4, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_nation (fnation_id, fnation_code, fnation_gbcode, fnation_name, fisavailable, fordernum, fnation_desc, fversion, flogcby, flogcdate, flogluby, flogludate, floglaby, flogladate )
values ('05', '05', '05', '苗族', 'Y', 5, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_nation (fnation_id, fnation_code, fnation_gbcode, fnation_name, fisavailable, fordernum, fnation_desc, fversion, flogcby, flogcdate, flogluby, flogludate, floglaby, flogladate )
values ('06', '06', '06', '维吾尔族', 'Y', 6, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_nation (fnation_id, fnation_code, fnation_gbcode, fnation_name, fisavailable, fordernum, fnation_desc, fversion, flogcby, flogcdate, flogluby, flogludate, floglaby, flogladate )
values ('07', '07', '07', '彝族', 'Y', 7, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_nation (fnation_id, fnation_code, fnation_gbcode, fnation_name, fisavailable, fordernum, fnation_desc, fversion, flogcby, flogcdate, flogluby, flogludate, floglaby, flogladate )
values ('08', '08', '08', '土家族', 'Y', 8, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_nation (fnation_id, fnation_code, fnation_gbcode, fnation_name, fisavailable, fordernum, fnation_desc, fversion, flogcby, flogcdate, flogluby, flogludate, floglaby, flogladate )
values ('09', '09', '09', '蒙古族', 'Y', 9, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_nation (fnation_id, fnation_code, fnation_gbcode, fnation_name, fisavailable, fordernum, fnation_desc, fversion, flogcby, flogcdate, flogluby, flogludate, floglaby, flogladate )
values ('10', '10', '10', '藏族', 'Y', 10, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

commit;


