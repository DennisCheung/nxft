--
-- 子系统服务部门表
--
-- 设置子系统的使用者（部门）。
--
-- v1.0 2015.11.08
-- author：wing
--
-- 说明：
--
--
--
-- 修改历史：
--
--
-- drop table fxp.p_subsys_dept;
create table fxp.p_subsys_dept (
-- +-----------------------------+--------------+-----------+
   forg_id                       varchar2(32)   not null,   -- 机构id
   fdept_id                      varchar2(32)   not null,   -- 部门id
   fsubsys_id                    varchar2(32)   not null,   -- 应用子系统id 常量
   fordernum                     number(6,2)    not null,   -- 排序号
   fdesc                         varchar2(256),             -- 备注
   --
   -- 日志
   --
   fversion                      number(6)                   -- 版本号
                                 default 0      not null,
   flogcby                       varchar2(32)   not null,    -- 创建者
   flogcdate                     date           not null,    -- 创建时间
   flogluby                      varchar2(32)   not null,    -- 最后修改者
   flogludate                    date           not null,    -- 最后修改时间
   floglaby                      varchar2(32)   not null,    -- 最后访问者
   flogladate                    date           not null,    -- 最后访问时间
   --
   -- 主键、唯一键
   --
   constraint pk_p_subsys_dept primary key (forg_id,fdept_id,fsubsys_id)
   --
   -- Check约束
   --
);
