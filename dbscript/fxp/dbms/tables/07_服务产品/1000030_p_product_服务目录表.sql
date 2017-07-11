--
-- 服务目录表
--
-- v1.0 2017.03.08
-- author：wing
--
-- 说明
--
--
-- 
-- 修改历史：
--
-- drop table fxp.p_product;
create table  fxp.p_product (
-- +-----------------------------+--------------+-----------+
   fproduct_id                   varchar2(32)   not null,   -- 服务目录ID
   fproduct_name                 varchar2(50)   not null,   -- 服务目录名称
   fproduct_info                 varchar2(200),             -- 产品信息
   fproduct_class_id             varchar2(32)   not null,   -- 服务产品大类ID
   fproduct_subclass_id          varchar2(32)   not null,   -- 服务产品子分类ID
   fisavailable                  char(1)        not null,   -- 是否可用？
   fproduct_desc                 varchar2(256),             -- 备注
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
   constraint pk_p_product primary key (fproduct_id)
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
