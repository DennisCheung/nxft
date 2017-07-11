--
-- 服务产品子分类表
--
-- v1.0 2015.08.04
-- author：wing
--
-- 说明
-- 1、服务产品二级分类
-- 2、政策和服务产品子分类挂钩
--
-- 
-- 修改历史：
--
-- drop table fxp.p_product_subclass;
create table  fxp.p_product_subclass (
-- +-----------------------------+--------------+-----------+
   fproduct_subclass_id          varchar2(32)   not null,   -- 服务产品子分类ID
   fproduct_subclass_code        varchar2(8)    not null,   -- 服务产品子分类代码
   fproduct_subclass_name        varchar2(40)   not null,   -- 服务产品子分类名称
   fproduct_class_id             varchar2(32)   not null,   -- 服务产品大类ID
   fisavailable                  char(1)        not null,   -- 是否可用？
   fproduct_subclass_desc        varchar2(256),             -- 备注
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
   constraint pk_p_product_subclass primary key (fproduct_subclass_id),
   constraint uk_p_product_subclass unique (fproduct_subclass_code)
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
