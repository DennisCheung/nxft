--
-- 券表
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
-- Drop Table fxp.p_coupon ;
Create Table  fxp.p_coupon (
-- +-----------------------------+--------------+-----------+
   fcoupon_id                    varchar2(32)   not null,   -- 券id
   fcoupon_no                    varchar2(30)   not null,   -- 券编号
   --
   -- 券类型
   --
   fcoupon_type_id               varchar2(32)   not null,   -- 券类型id
   fcoupon_type_name             varchar2(40)   not null,   -- 券类型名称
   fcoupon_money                 number(10,2)   default 0 not null,    -- 券面额
   fcoupon_unit                  varchar2(30),              -- 单位
   fcoupon_desc                  varchar2(256),             -- 券的说明
   --
   -- 发行
   --
   fduetime_begin                date           not null,   -- 有效期起日
   fduetime_end                  date           not null,   -- 有效期止日
   fissue_desc                   varchar2(256),             -- 发券备注
   --
   --
   --
   fcoupon_from                  varchar2(30)   not null,   -- 发券途径  GROUP 集体发券  PERSON 个人发券
   --
   -- 集体发券
   --
   factivity_id                  varchar2(32),              -- 活动id
   fcrowds_id                    varchar2(32),              -- 名单id
   fissue_id                     varchar2(32),              -- 发放id   
   --
   -- 所属运营商
   --   
   foperator_id                  varchar2(32)   not null,   -- 运营商id   
   --
   -- 账户
   --
   faccount_id                   varchar2(32)   not null,   -- 账户id   
   --
   -- 创建
   --
   fcreate_date                  date           not null,   -- 创建时间  
   fcreate_user_id               varchar2(32)   not null,   -- 创建操作员id
   fcreate_nickname              varchar2(30)   not null,   -- 创建操作员姓名
   --
   -- 核销
   --
   fis_used                      char(1) default 'N'  not null, -- 是否被核销
   fused_date                    date,                      -- 核销时间
   fused_chgnote_id              varchar2(32),              -- 收费单id
   fused_org_id                  varchar2(32),              -- 核销服务商id
   fused_site_id                 varchar2(32),              -- 核销服务点id
   fused_user_id                 varchar2(32),              -- 核销操作员id
   fused_nickname                varchar2(40),              -- 核销操作员姓名 
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
   constraint pk_p_coupon primary key (fcoupon_id),
   constraint uk_p_coupon_no unique (fcoupon_no)
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
create index fxp.idx_p_coupon_used_date on fxp.p_coupon(fused_date);
create index fxp.idx_p_coupon_account on fxp.p_coupon(faccount_id);
create index fxp.idx_p_coupon_chgnote on fxp.p_coupon(fused_chgnote_id);

