--
-- 服务大类表
--
-- v1.0 2015.08.04
-- author：wing
--
-- 说明
-- 1、由于助老及健康服务产品众多，且提供服务的厂家众多，制定统一的产品目录非常困难。
-- 2、服务产品分类分两级：大分类、二级子分类
-- 3、通过制定整个系统通用的服务产品分类，各种助老服务政策不和具体的产品产品绑定，直接和服务产品子分类绑定。
--
-- 
-- 修改历史：
--
-- drop table fxp.p_product_class;
create table  fxp.p_product_class (
-- +-----------------------------+--------------+-----------+
   fproduct_class_id             varchar2(32)   not null,   -- 服务分类ID
   fproduct_class_code           varchar2(8)    not null,   -- 服务分类代码
   fproduct_class_name           varchar2(40)   not null,   -- 服务分类名称
   fisavailable                  char(1)        not null,   -- 是否可用？
   fproduct_class_desc           varchar2(256),             -- 备注
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
   constraint pk_p_product_class primary key (fproduct_class_id),
   constraint uk_p_product_class unique (fproduct_class_code)
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
