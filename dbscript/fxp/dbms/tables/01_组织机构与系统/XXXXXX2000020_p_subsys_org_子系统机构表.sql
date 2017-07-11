--
-- 子系统机构表
--
-- v1.0 2015.08.13
-- author：wing
--
-- 说明：
-- 1、系统维护分两个 平台系统维护、机构系统维护
--
--
--
-- 修改历史：
--
--
-- Drop Table fxp.p_subsys_org;
Create Table  fxp.p_subsys_org (
-- +-----------------------------+--------------+-----------+
   forg_id                       varchar2(32)   not null,   -- 机构id
   fsubsys_id                    varchar2(32)   not null,   -- 应用子系统id 常量
   fdesc                         varchar2(256),             -- 备注
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
   constraint pk_p_subsys_org primary key (forg_id,fsubsys_id)
);


--
-- 索引
--


--
-- 修改语句：
--
