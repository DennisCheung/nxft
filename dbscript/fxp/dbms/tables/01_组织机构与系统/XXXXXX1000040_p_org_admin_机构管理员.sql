--
-- 机构管理员登记表
--
-- v1.0 2015.08.13
-- author：wing
--
-- 说明：
-- 1、登记具有
--
--
--
-- 修改历史：b 
--
--
-- Drop Table fxp.p_org_admin;
Create Table  fxp.p_org_admin (
-- +-----------------------------+--------------+-----------+
   forg_id                       varchar2(32)   not null,   -- 机构id
   fuser_id                      varchar2(32)   not null,   -- 用户id
   fadmin_desc                   varchar2(256),             -- 备注
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
   constraint pk_p_org_admin primary key (forg_id,fuser_id)
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
