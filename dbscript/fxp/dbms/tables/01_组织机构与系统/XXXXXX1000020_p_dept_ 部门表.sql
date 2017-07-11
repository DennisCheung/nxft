--
-- 部门表
--
-- v1.0 2015.08.13
-- author：wing
--
-- 说明：
-- 1、由机构管理员自行根据各机构的实际情况设立
--
--
--
--
-- 修改历史：
--
--
-- Drop Table fxp.p_dept;
Create Table  fxp.p_dept (
-- +-----------------------------+--------------+-----------+
   fdept_id                      varchar2(32)   not null,   -- 部门id，为和微信企业号兼容，以数字开头，由系统自动生成
   fdept_name                    varchar2(50)   not null,   -- 部门名称名称
   forg_id                       varchar2(32)   not null,   -- 所属机构id
   fdept_desc                    varchar2(256),             -- 备注
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
   constraint pk_p_dept primary key (fdept_id),
   constraint uk_p_dept_org unique (forg_id,fdept_id)
);

--
-- 同义词
--
--
-- 授权
--
grant all on fxp.p_dept to sf,hbcs;
--
-- 索引
--


--
-- 修改语句：
--
