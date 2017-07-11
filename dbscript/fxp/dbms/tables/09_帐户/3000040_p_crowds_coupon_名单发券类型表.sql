--
-- 名单发券类型表
--
--
-- v1.0 2016.08.30
-- author：wing
--
-- 
--
-- 修改历史：
--
--
-- Drop Table fxp.p_crowds_coupon ;
Create Table  fxp.p_crowds_coupon (
-- +-----------------------------+--------------+-----------+
   fissue_id                     varchar2(32)   not null,   -- 发放id
   --
   -- 券类型
   --
   fcoupon_type_id               varchar2(32)   not null,   -- 券类型id
   fcoupon_type_name             varchar2(40)   not null,   -- 券类型名称
   fcoupon_money                 number(10,2)   default 0 not null,    -- 券面额
   fcoupon_unit                  varchar2(30),              -- 单位
   fcoupon_desc                  varchar2(256),             -- 券的说明
   --
   -- 数量及有效期
   --
   fperiod_begin                 date           not null,   -- 有效期起日
   fperiod_end                   date           not null,   -- 有效期止日
   famount                       number(6,0)    not null,   -- 卡的数量
   fissue_desc                   varchar2(256),             -- 发券备注
   --
   -- 人群
   --
   fcrowds_id                    varchar2(32)   not null,   -- 名单id   
   --
   -- 所属活动
   --
   factivity_id                  varchar2(32)   not null,   -- 活动id
   --
   -- 所属运营商
   --   
   foperator_id                  varchar2(32)   not null,   -- 运营商id   
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
   constraint pk_p_crowds_coupon primary key (fissue_id),
   constraint uk_p_crowds_coupon unique (factivity_id,fcrowds_id,fcoupon_type_id)
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
create index fxp.idx_p_crowds_coupon_crowds on fxp.p_crowds_coupon(fcrowds_id);

