--
-- 福来平台开展的服务
--
-- v1.0 2016.01.30
-- author：wing
--
-- 修改历史：
-- 
--  
-- drop table fxp.p_service;
create table  fxp.p_service (
-- +-----------------------------+--------------+-----------+
   fservice_id                   varchar2(32)   not null,   -- 服务_id
   fservice_code                 varchar2(30)   not null,   -- 服务_code
   fservice_name                 varchar2(50)   not null,   -- 服务名称
   ffamily_or_person             varchar2(30)   not null,   -- 家庭 OR 个人  常量  FAMILY  PERSON
   fisavailable                  char(1)        not null,   -- 是否可用？
   fservice_desc                 varchar2(256),             -- 备注   
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
   constraint pk_p_service primary key (fservice_id),
   constraint uk_p_service unique (fservice_code)
);

--
-- 外部键约束
--
--
-- 授权
--
