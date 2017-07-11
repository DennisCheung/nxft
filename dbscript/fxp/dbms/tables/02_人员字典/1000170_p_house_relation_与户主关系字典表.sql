--
-- 与户主关系字典表
--
-- v1.0 2015.01.12
-- author：wing
--
-- 修改历史：
--
--
-- Drop Table fxp.p_house_relation;
create Table  fxp.p_house_relation (
-- +-----------------------------+--------------+-----------+		
   fhouse_relation_id            varchar2(32)   not null,   -- 联系人关系ID
   fhouse_relation_code          varchar2(8)    not null,   -- 联系人关系代码
   fhouse_relation_gbcode        varchar2(32),              -- 国标代码
   fhouse_relation_name          varchar2(40)   not null,   -- 联系人关系名称
   fisavailable                  char(1)        not null,   -- 是否可用？
   fordernum                     number(6,2)    not null,   -- 排序号
   fhouse_relation_desc          varchar2(256),             -- 备注
   --                       
   -- 日志                  
   --                       
   fversion                      number(6)                  -- 版本号
                                 default 0       not null,
   flogcby                       varchar2(32)   not null,   -- 创建者
   flogcdate                     date           not null,   -- 创建时间
   flogluby                      varchar2(32)   not null,   -- 最后修改者
   flogludate                    date           not null,   -- 最后修改时间
   floglaby                      varchar2(32)   not null,   -- 最后访问者
   flogladate                    date           not null,   -- 最后访问时间
   --
   -- 主键、唯一键
   --
   constraint pk_p_house_relation primary key (fhouse_relation_id),
   constraint uk_p_house_relation unique (fhouse_relation_code)
   );

--
-- 同义词
--

--
-- 外部键约束
--
--
-- 授权
--

insert into p_house_relation (FHOUSE_RELATION_ID, FHOUSE_RELATION_CODE, FHOUSE_RELATION_GBCODE, FHOUSE_RELATION_NAME, FISAVAILABLE, FORDERNUM, FHOUSE_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('01', '01', '01', '户主', 'Y', 1, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_house_relation (FHOUSE_RELATION_ID, FHOUSE_RELATION_CODE, FHOUSE_RELATION_GBCODE, FHOUSE_RELATION_NAME, FISAVAILABLE, FORDERNUM, FHOUSE_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('02', '02', '02', '夫妻', 'Y', 2, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_house_relation (FHOUSE_RELATION_ID, FHOUSE_RELATION_CODE, FHOUSE_RELATION_GBCODE, FHOUSE_RELATION_NAME, FISAVAILABLE, FORDERNUM, FHOUSE_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('03', '03', '03', '子女', 'Y', 3, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_house_relation (FHOUSE_RELATION_ID, FHOUSE_RELATION_CODE, FHOUSE_RELATION_GBCODE, FHOUSE_RELATION_NAME, FISAVAILABLE, FORDERNUM, FHOUSE_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('04', '04', '04', '父母', 'Y', 4, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_house_relation (FHOUSE_RELATION_ID, FHOUSE_RELATION_CODE, FHOUSE_RELATION_GBCODE, FHOUSE_RELATION_NAME, FISAVAILABLE, FORDERNUM, FHOUSE_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('05', '05', '05', '岳父母', 'Y', 5, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_house_relation (FHOUSE_RELATION_ID, FHOUSE_RELATION_CODE, FHOUSE_RELATION_GBCODE, FHOUSE_RELATION_NAME, FISAVAILABLE, FORDERNUM, FHOUSE_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('06', '06', '06', '祖父母', 'Y', 6, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_house_relation (FHOUSE_RELATION_ID, FHOUSE_RELATION_CODE, FHOUSE_RELATION_GBCODE, FHOUSE_RELATION_NAME, FISAVAILABLE, FORDERNUM, FHOUSE_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('07', '07', '07', '外祖父母', 'Y', 7, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_house_relation (FHOUSE_RELATION_ID, FHOUSE_RELATION_CODE, FHOUSE_RELATION_GBCODE, FHOUSE_RELATION_NAME, FISAVAILABLE, FORDERNUM, FHOUSE_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('08', '08', '08', '兄弟', 'Y', 8, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_house_relation (FHOUSE_RELATION_ID, FHOUSE_RELATION_CODE, FHOUSE_RELATION_GBCODE, FHOUSE_RELATION_NAME, FISAVAILABLE, FORDERNUM, FHOUSE_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('09', '09', '09', '姐妹', 'Y', 9, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_house_relation (FHOUSE_RELATION_ID, FHOUSE_RELATION_CODE, FHOUSE_RELATION_GBCODE, FHOUSE_RELATION_NAME, FISAVAILABLE, FORDERNUM, FHOUSE_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('99', '99', '99', '其他', 'Y', 99, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );


commit;

