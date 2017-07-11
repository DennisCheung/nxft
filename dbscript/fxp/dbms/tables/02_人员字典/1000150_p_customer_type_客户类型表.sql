--
-- 客户类型表
--
-- v1.0 2014.12.08
-- author：wing
--
-- 修改历史：
--
--
--
-- drop table fxp.p_customer_type;
create table  fxp.p_customer_type (
-- +-----------------------------+--------------+-----------+
   fcustomer_type_id             varchar2(32)   not null,   -- 客户类型ID
   fcustomer_type_code           varchar2(30)   not null,   -- 客户类型代码
   fcustomer_type_gbcode         varchar2(32),              -- 国标代码
   fcustomer_type_name           varchar2(40)   not null,   -- 客户类型名称
   --
   fisavailable                  char(1)        not null,   -- 是否可用？
   fordernum                     number(6,2)    not null,   -- 排序号
   fcustomer_type_desc           varchar2(256),             -- 备注
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
   constraint pk_p_customer_type primary key (fcustomer_type_id),
   constraint uk_p_customer_type_code unique (fcustomer_type_code)
);

--
-- 同义词
--

insert into p_customer_type (FCUSTOMER_TYPE_ID, FCUSTOMER_TYPE_CODE, FCUSTOMER_TYPE_GBCODE, FCUSTOMER_TYPE_NAME, FISAVAILABLE, FORDERNUM, FCUSTOMER_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('01', '01', '01', '体验客户', 'Y', 1, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_customer_type (FCUSTOMER_TYPE_ID, FCUSTOMER_TYPE_CODE, FCUSTOMER_TYPE_GBCODE, FCUSTOMER_TYPE_NAME, FISAVAILABLE, FORDERNUM, FCUSTOMER_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('02', '02', '02', '付费客户', 'Y', 2, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

commit ;

