--
-- 用户登录默认服务点表
--
-- v1.0 2016.11.16
-- author：wing
--
-- 说明：
--
-- 修改历史：
--
--
--
-- Drop Table fxp.p_login_default_site;
Create Table  fxp.p_login_default_site (
-- +-----------------------------+--------------+-----------+
   fuser_id                      varchar2(32)   not null,   -- 操作员id
   fsubsys_id                    varchar2(32)   not null,   -- 应用子系统id 常量
   forg_id                       varchar2(32)   not null,   -- 机构id
   fsite_id                      varchar2(32)   not null,   -- 服务点id
   fdesc                         varchar2(256),             -- 备注
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
   constraint pk_p_login_default_site primary key (fuser_id,fsubsys_id)
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
