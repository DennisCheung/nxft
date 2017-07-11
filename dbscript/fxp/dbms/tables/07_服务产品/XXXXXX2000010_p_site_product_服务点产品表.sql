--
-- 服务点产品表
--
-- v1.0 2016.08.23
-- author：wing
--
-- 说明
--
--
-- 
-- 修改历史：
--
-- drop table fxp.p_site_product;
create table  fxp.p_site_product (
-- +-----------------------------+--------------+-----------+
   fproduct_id                   varchar2(32)   not null,   -- 服务产品ID
   fproduct_name                 varchar2(50)   not null,   -- 服务产品名称
   fproduct_subclass_id          varchar2(32)   not null,   -- 服务产品子分类ID
   fproduct_class_id             varchar2(32)   not null,   -- 服务产品大类ID
   fproduct_info                 varchar2(200),             -- 产品信息   
   --   
   fproduct_price                number(8,2),               -- 价格
   fupdate_price                 char(1)        not null,   -- 是否允许修改价格
   fproduct_unit                 varchar2(10)   not null,   -- 单位
   --
   fsupplier_id                  varchar2(32)   not null,   -- 所属的服务商id
   fsite_id                      varchar2(32)   not null,   -- 所属的服务点id
   fcreate_date                  date default sysdate not null, -- 创建时间 
   fisavailable                  char(1)        not null,   -- 是否可用？
   fuse_coupon                   char(1)        not null,   -- 是否可用券？
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
   constraint pk_p_site_product primary key (fproduct_id)
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
create index fxp.idx_p_site_product_supp on fxp.p_site_product (fsite_id);

--
-- 修改语句
--
