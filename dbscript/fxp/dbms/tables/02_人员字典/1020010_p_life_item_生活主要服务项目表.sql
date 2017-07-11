--
-- 生活主要服务项目字典表
--
-- v1.0 2015.01.12
-- author：wing
--
-- 修改历史：
--
--
-- Drop Table fxp.p_life_item;
create Table  fxp.p_life_item (
-- +-----------------------------+--------------+-----------+		
   flife_item_id                 varchar2(32)   not null,   -- 生活主要服务项目ID
   flife_item_code               varchar2(8)    not null,   -- 生活主要服务项目代码
   flife_item_gbcode             varchar2(32),              -- 国标代码
   flife_item_name               varchar2(60)   not null,   -- 生活主要服务项目名称
   fisavailable                  char(1)        not null,   -- 是否可用？
   fordernum                     number(6,2)    not null,   -- 排序号
   flife_item_desc               varchar2(256),             -- 备注
   --                       
   -- 日志                  
   --                       
   fversion                      number(6)                   -- 版本号
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
   constraint pk_p_life_item primary key (flife_item_id),
   constraint uk_p_life_item unique (flife_item_code)
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

insert into p_life_item (FLIFE_ITEM_ID, FLIFE_ITEM_CODE, FLIFE_ITEM_GBCODE, FLIFE_ITEM_NAME, FISAVAILABLE, FORDERNUM, FLIFE_ITEM_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('01', '01', '01', '保姆', 'Y', 1, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

insert into p_life_item (FLIFE_ITEM_ID, FLIFE_ITEM_CODE, FLIFE_ITEM_GBCODE, FLIFE_ITEM_NAME, FISAVAILABLE, FORDERNUM, FLIFE_ITEM_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('02', '02', '02', '家政服务', 'Y', 2, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

insert into p_life_item (FLIFE_ITEM_ID, FLIFE_ITEM_CODE, FLIFE_ITEM_GBCODE, FLIFE_ITEM_NAME, FISAVAILABLE, FORDERNUM, FLIFE_ITEM_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('03', '03', '03', '送煤气', 'Y', 3, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

insert into p_life_item (FLIFE_ITEM_ID, FLIFE_ITEM_CODE, FLIFE_ITEM_GBCODE, FLIFE_ITEM_NAME, FISAVAILABLE, FORDERNUM, FLIFE_ITEM_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('04', '04', '04', '送水', 'Y', 4, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

insert into p_life_item (FLIFE_ITEM_ID, FLIFE_ITEM_CODE, FLIFE_ITEM_GBCODE, FLIFE_ITEM_NAME, FISAVAILABLE, FORDERNUM, FLIFE_ITEM_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('05', '05', '05', '送米送面', 'Y', 5, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

insert into p_life_item (FLIFE_ITEM_ID, FLIFE_ITEM_CODE, FLIFE_ITEM_GBCODE, FLIFE_ITEM_NAME, FISAVAILABLE, FORDERNUM, FLIFE_ITEM_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('06', '06', '06', '常买肉摊位', 'Y', 6, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

insert into p_life_item (FLIFE_ITEM_ID, FLIFE_ITEM_CODE, FLIFE_ITEM_GBCODE, FLIFE_ITEM_NAME, FISAVAILABLE, FORDERNUM, FLIFE_ITEM_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('07', '07', '07', '士多店', 'Y', 7, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

insert into p_life_item (FLIFE_ITEM_ID, FLIFE_ITEM_CODE, FLIFE_ITEM_GBCODE, FLIFE_ITEM_NAME, FISAVAILABLE, FORDERNUM, FLIFE_ITEM_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('08', '08', '08', '常去的超市', 'Y', 8, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

insert into p_life_item (FLIFE_ITEM_ID, FLIFE_ITEM_CODE, FLIFE_ITEM_GBCODE, FLIFE_ITEM_NAME, FISAVAILABLE, FORDERNUM, FLIFE_ITEM_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('09', '09', '09', '电器维修', 'Y', 9, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

insert into p_life_item (FLIFE_ITEM_ID, FLIFE_ITEM_CODE, FLIFE_ITEM_GBCODE, FLIFE_ITEM_NAME, FISAVAILABLE, FORDERNUM, FLIFE_ITEM_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('10', '10', '10', '水电维修', 'Y', 10, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

commit;

