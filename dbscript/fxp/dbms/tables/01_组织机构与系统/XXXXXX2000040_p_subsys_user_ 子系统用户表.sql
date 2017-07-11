--
-- 子系统用户表
--
-- v1.0 2015.05.31
-- author：wing
--
-- 说明：
--
-- 修改历史：
--
--
--
-- Drop Table fxp.p_subsys_user;
Create Table  fxp.p_subsys_user (
-- +-----------------------------+--------------+-----------+
   forg_id                       varchar2(32)   not null,   -- 机构id
   fdept_id                      varchar2(32)   not null,   -- 部门id
   fsubsys_id                    varchar2(32)   not null,   -- 应用子系统id 常量
   fuser_id                      varchar2(32)   not null,   -- 操作员id
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
   constraint pk_p_subsys_user primary key (forg_id,fdept_id,fsubsys_id,fuser_id)
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
