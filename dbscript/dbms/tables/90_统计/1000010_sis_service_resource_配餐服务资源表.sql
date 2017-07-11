--
-- 配餐服务资源表
--
-- v1.0 2017.05.05
-- author：wing
--
-- 说明
--
-- 
-- 修改历史：
--
-- drop table nxft.sis_service_resource;
create table  nxft.sis_service_resource (
-- +-----------------------------+--------------+-----------+
   fsis_id                       varchar2(32)   not null,   -- 统计id
   fcircle_id                    varchar2(32)   not null,   -- 工作圈id
   findicator_id                 varchar2(32)   not null,   -- 统计指标ID(常量) 
   findicator_name               varchar2(60)   not null,   -- 统计指标名称
   fquantity                     number(9,0)    not null,   -- 数量
   fdata_desc                    varchar2(256),             -- 备注
-- +-----------------------------+--------------+-----------+
   --
   -- 日志
   --
   fversion                      number(6)                  -- 版本号
                                 default 0      not null,
   flogcby                       varchar2(32)   not null,   -- 创建者
   flogcdate                     date           not null,   -- 创建时间
   flogluby                      varchar2(32)   not null,   -- 最后修改者
   flogludate                    date           not null,   -- 最后修改时间
   floglaby                      varchar2(32)   not null,   -- 最后访问者
   flogladate                    date           not null,   -- 最后访问时间
   --
   -- 主键、唯一键
   --
   constraint pk_sis_service_resource primary key (fsis_id),
   constraint uk_sis_service_resource unique (fcircle_id,findicator_id)
   --
   -- 约束
   --
);

--
-- 同义词
--

insert into nxft.sis_service_resource (FSIS_ID, FCIRCLE_ID, FINDICATOR_ID, FINDICATOR_NAME, FQUANTITY, FDATA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('00001', '10001', 'ASSIST_MEAL_WORKER', '助餐工作人员', 3, '', 0, 'admin', to_date('06-05-2017', 'dd-mm-yyyy'), 'admin', to_date('06-05-2017', 'dd-mm-yyyy'), 'admin', to_date('06-05-2017', 'dd-mm-yyyy'));

insert into nxft.sis_service_resource (FSIS_ID, FCIRCLE_ID, FINDICATOR_ID, FINDICATOR_NAME, FQUANTITY, FDATA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('00002', '10001', 'ASSIST_MEAL_VOLUNTEER', '助餐志愿者', 10, '', 0, 'admin', to_date('06-05-2017', 'dd-mm-yyyy'), 'admin', to_date('06-05-2017', 'dd-mm-yyyy'), 'admin', to_date('06-05-2017', 'dd-mm-yyyy'));

insert into nxft.sis_service_resource (FSIS_ID, FCIRCLE_ID, FINDICATOR_ID, FINDICATOR_NAME, FQUANTITY, FDATA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('00003', '10001', 'KITCHEN', '中央厨房', 1, '', 0, 'admin', to_date('06-05-2017', 'dd-mm-yyyy'), 'admin', to_date('06-05-2017', 'dd-mm-yyyy'), 'admin', to_date('06-05-2017', 'dd-mm-yyyy'));

insert into nxft.sis_service_resource (FSIS_ID, FCIRCLE_ID, FINDICATOR_ID, FINDICATOR_NAME, FQUANTITY, FDATA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('00004', '10001', 'ASSIST_MEAL_SITE', '助餐点', 3, '', 0, 'admin', to_date('06-05-2017', 'dd-mm-yyyy'), 'admin', to_date('06-05-2017', 'dd-mm-yyyy'), 'admin', to_date('06-05-2017', 'dd-mm-yyyy'));



--
-- 授权
--

--
-- 索引
--

--
-- 修改语句
--
