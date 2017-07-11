--
-- 业务表
--
-- v1.0 2017.02.13
-- author：wing
--
-- 
-- 修改历史：
--
--
--
-- Drop Table fxp.p_business;
Create Table  fxp.p_business (
-- +-----------------------------+--------------+-----------+
   fbusiness_id                  varchar2(32)   not null,   -- 业务id
   fbusiness_name                varchar2(60)   not null,   -- 业务名称
   fisavailable                  char(1)        not null,   -- 是否可用？
   fbusiness_desc                varchar2(256),             -- 备注 
-- +-----------------------------+--------------+-----------+
   --
   -- 日志
   --
   fversion                      number(6)                   -- 版本号
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
   constraint pk_p_business primary key (fbusiness_id)
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


--
-- 修改语句：
--
