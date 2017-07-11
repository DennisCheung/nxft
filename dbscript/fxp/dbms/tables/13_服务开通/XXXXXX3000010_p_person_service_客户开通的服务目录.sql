--
-- 客户开通的服务目录表
--
-- v1.0 2016.11.10
-- author：wing
--
-- 修改历史：
--
--
--
-- Drop Table fxp.p_person_service;
create table  fxp.p_person_service (
-- +-----------------------------+--------------+-----------+
   fperson_id                    varchar2(32)   not null,   -- 客户ID
   fservice_id                   varchar2(32)   not null,   -- 服务id
   fservice_name                 varchar2(50)   not null,   -- 服务名称
   fservice_begin                date           not null,   -- 服务开始时间
   fservice_end                  date           not null,   -- 服务结束时间
   --
   -- 所属运营商
   --
   foperator_id                  varchar2(32),              -- 运营商id      
   --
   -- 创建
   --
   fcreate_date                  date           not null,   -- 创建时间
   fcreate_org_id                varchar2(32)   not null,   -- 创建机构id
   fcreate_site_id               varchar2(32)   not null,   -- 创建服务点id
   fcreate_user_id               varchar2(32)   not null,   -- 创建操作员id
   fcreate_nickname              varchar2(40)   not null,   -- 创建操作员姓名
   fcreate_desc                  varchar2(256),             -- 创建备注 
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
   constraint pk_p_person_service primary key (fperson_id,fservice_id)
);

--
-- 同义词
--


--
-- 授权
--


--
-- 索引
--
create index fxp.idx_p_person_service_operator on fxp.p_person_service (foperator_id);

--
-- 修改历史：
--
