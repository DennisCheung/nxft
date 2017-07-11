--
-- 券类型表
--
--
-- v1.0 2016.08.30
-- author：wing
--
-- 说明：
-- 
--
-- 修改历史：
--
--
-- Drop Table fxp.p_coupon_type ;
Create Table  fxp.p_coupon_type (
-- +-----------------------------+--------------+-----------+
   fcoupon_type_id               varchar2(32)   not null,   -- 券类型id
   fcoupon_type_name             varchar2(40)   not null,   -- 券类型名称
   fcoupon_class                 varchar2(30)   not null,   -- 券分类  常量   项目券  工时券  补贴券  
   fcoupon_money                 number(10,2)   default 0 not null,    -- 券面额
   fcoupon_unit                  varchar2(30),              -- 单位
   fcoupon_desc                  varchar2(256),             -- 券的说明
   -- fis_limit_product          char(1) default 'N'  not null, -- 使用是否限制服务产品  
   -- fis_limit_site             char(1) default 'N'  not null, -- 使用是否限制服务点
   --
   -- 所属运营商
   --
   foperator_id                  varchar2(32)   not null,   -- 运营商id   
   --
   -- 创建
   --
   fcreate_date                  date           not null,   -- 创建时间  
   fcreate_user_id               varchar2(32)   not null,   -- 创建操作员id
   fcreate_nickname              varchar2(30)   not null,   -- 创建操作员姓名      
   --
   -- 取消
   --
   fis_cancel                    char(1) default 'N'  not null, -- 是否被注销
   fcancel_reason                varchar2(100),             -- 注销原因
   fcancel_date                  date,                      -- 注销时间
   fcancel_user_id               varchar2(32),              -- 注销操作员id
   fcancel_nickname              varchar2(40),              -- 注销操作员姓名   
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
   constraint pk_p_coupon_type primary key (fcoupon_type_id),
   constraint ck_p_coupon_type_class   check (fcoupon_class in ('项目券','工时券','补贴券'))
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
