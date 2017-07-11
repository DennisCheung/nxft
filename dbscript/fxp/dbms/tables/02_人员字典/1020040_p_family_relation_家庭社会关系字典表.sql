--
-- 社会关系字典
--
-- v1.0 2015.01.12
-- author：wing
--
-- 修改历史：
--
--
-- Drop Table fxp.p_family_relation;
create Table  fxp.p_family_relation (
-- +-----------------------------+--------------+-----------+		
   ffamily_relation_id           varchar2(32)   not null,   -- 家庭社会关系ID
   ffamily_relation_code         varchar2(8)    not null,   -- 家庭社会关系代码
   ffamily_relation_gbcode       varchar2(32),              -- 国标代码
   ffamily_relation_name         varchar2(40)   not null,   -- 家庭社会关系名称
   frelation_class               varchar2(20)   not null,   -- 关系大类  NEIGHBORHOOD 邻里 或  SOCIETY 社会
   fisavailable                  char(1)        not null,   -- 是否可用？
   fordernum                     number(6,2)    not null,   -- 排序号
   ffamily_relation_desc         varchar2(256),             -- 备注
   --                       
   -- 日志                  
   --                       
  fversion                       number(6)                   -- 版本号
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
   constraint pk_p_family_relation primary key (ffamily_relation_id),
   constraint uk_p_family_relation unique (ffamily_relation_code)
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

insert into p_family_relation (FFAMILY_RELATION_ID, FFAMILY_RELATION_CODE, FFAMILY_RELATION_GBCODE, FFAMILY_RELATION_NAME, FRELATION_CLASS, FISAVAILABLE, FORDERNUM, FFAMILY_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('01', '01', '01', '同层', 'NEIGHBORHOOD', 'Y', 1, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

insert into p_family_relation (FFAMILY_RELATION_ID, FFAMILY_RELATION_CODE, FFAMILY_RELATION_GBCODE, FFAMILY_RELATION_NAME, FRELATION_CLASS, FISAVAILABLE, FORDERNUM, FFAMILY_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('02', '02', '02', '楼上', 'NEIGHBORHOOD', 'Y', 2, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

insert into p_family_relation (FFAMILY_RELATION_ID, FFAMILY_RELATION_CODE, FFAMILY_RELATION_GBCODE, FFAMILY_RELATION_NAME, FRELATION_CLASS, FISAVAILABLE, FORDERNUM, FFAMILY_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('03', '03', '03', '楼下', 'NEIGHBORHOOD', 'Y', 3, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

insert into p_family_relation (FFAMILY_RELATION_ID, FFAMILY_RELATION_CODE, FFAMILY_RELATION_GBCODE, FFAMILY_RELATION_NAME, FRELATION_CLASS, FISAVAILABLE, FORDERNUM, FFAMILY_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('04', '04', '04', '居委会', 'NEIGHBORHOOD', 'Y', 4, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

insert into p_family_relation (FFAMILY_RELATION_ID, FFAMILY_RELATION_CODE, FFAMILY_RELATION_GBCODE, FFAMILY_RELATION_NAME, FRELATION_CLASS, FISAVAILABLE, FORDERNUM, FFAMILY_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('05', '05', '05', '物业管理处', 'NEIGHBORHOOD', 'Y', 5, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);


insert into p_family_relation (FFAMILY_RELATION_ID, FFAMILY_RELATION_CODE, FFAMILY_RELATION_GBCODE, FFAMILY_RELATION_NAME, FRELATION_CLASS, FISAVAILABLE, FORDERNUM, FFAMILY_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('06', '06', '06', '保安/门卫', 'NEIGHBORHOOD', 'Y', 6, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);


insert into p_family_relation (FFAMILY_RELATION_ID, FFAMILY_RELATION_CODE, FFAMILY_RELATION_GBCODE, FFAMILY_RELATION_NAME, FRELATION_CLASS, FISAVAILABLE, FORDERNUM, FFAMILY_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('21', '21', '21', '党群联系人', 'SOCIETY', 'Y', 10, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

insert into p_family_relation (FFAMILY_RELATION_ID, FFAMILY_RELATION_CODE, FFAMILY_RELATION_GBCODE, FFAMILY_RELATION_NAME, FRELATION_CLASS, FISAVAILABLE, FORDERNUM, FFAMILY_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('22', '22', '22', '警民联系人', 'SOCIETY', 'Y', 11, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);


commit;

