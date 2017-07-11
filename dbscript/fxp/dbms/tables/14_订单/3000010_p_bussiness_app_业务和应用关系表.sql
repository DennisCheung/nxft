--
-- 业务和应用关系表
--
-- v1.0 2017.03.04
-- author：wing
--
-- 说明
--
-- 
-- 修改历史：
--
-- drop table fxp.p_bussiness_app;
create table  fxp.p_bussiness_app (
-- +-----------------------------+--------------+-----------+
   fset_id                       varchar2(32)   not null,   -- 设置ID
   fbusiness_id                  varchar2(32)   not null,   -- 业务id
   fapplication_id               varchar2(32)   not null,   -- 应用id
   fset_desc                     varchar2(256),             -- 备注
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
   constraint pk_p_bussiness_app primary key (fset_id),
   constraint uk_p_bussiness_app unique (fbusiness_id,fapplication_id)
   --
   -- 约束
   --
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
-- 修改语句
--
