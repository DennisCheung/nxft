--
-- 服务点经营范围表
--
-- v1.0 2016.08.04
-- author：wing
--
-- 说明
--
-- 
-- 修改历史：
--
-- drop table fxp.p_site_scope;
create table  fxp.p_site_scope (
-- +-----------------------------+--------------+-----------+
   fsupplier_id                  varchar2(32)   not null,   -- 所属的服务商id
   fsite_id                      varchar2(32)   not null,   -- 服务点id
   fproduct_subclass_id          varchar2(32)   not null,   -- 服务产品子分类ID
   fproduct_class_id             varchar2(32)   not null,   -- 服务产品大类ID
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
   constraint pk_p_site_scope primary key (fsite_id,fproduct_subclass_id)
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
