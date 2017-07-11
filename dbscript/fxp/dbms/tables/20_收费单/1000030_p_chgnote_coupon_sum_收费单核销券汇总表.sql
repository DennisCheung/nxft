--
-- 收费单核销券汇总表
--
-- v1.0 2016.12.08
-- author：wing
--
-- 说明：
-- 
--
-- 修改历史：
--
--
-- Drop Table fxp.p_chgnote_coupon_sum ;
Create Table  fxp.p_chgnote_coupon_sum (
-- +-----------------------------+--------------+-----------+
   fchgnote_id                   varchar2(32)   not null,   -- 收费单id   
   --
   -- 券类型
   --
   fcoupon_type_id               varchar2(32)   not null,   -- 券类型id
   fcoupon_type_name             varchar2(40)   not null,   -- 券类型名称
   fcoupon_money                 number(10,2)   default 0 not null,    -- 券面额
   fcoupon_unit                  varchar2(30),              -- 单位
   fcoupon_desc                  varchar2(256),             -- 券的说明
   --
   -- 金额
   --
   fcoupon_quantity              number(2,0)    default 0 not null,    -- 数量
   fcoupon_amount                number(10,2)   default 0 not null,    -- 金额
   --
   -- 创建
   --
   fcreate_date                  date           not null,   -- 创建时间  
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
   constraint pk_p_chgnote_coupon_sum primary key (fchgnote_id,fcoupon_type_id)
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
create index fxp.idx_p_chgnote_coupon_sum_date on fxp.p_chgnote_coupon_sum(fcreate_date);

