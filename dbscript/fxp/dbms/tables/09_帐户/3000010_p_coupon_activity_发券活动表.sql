--
-- 发券活动表
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
-- Drop Table fxp.p_coupon_activity ;
Create Table  fxp.p_coupon_activity (
-- +-----------------------------+--------------+-----------+
   factivity_id                  varchar2(32)   not null,   -- 活动id
   factivity_name                varchar2(100)  not null,   -- 活动名称
   factivity_desc                varchar2(256),             -- 备注
   --
   -- 发券
   --
   foperator_id                  varchar2(32)   not null,   -- 运营商id   
   --
   -- 创建
   --
   fcreate_date                  date           not null,   -- 创建时间
   fcreate_org_id                varchar2(32)   not null,   -- 创建机构id
   fcreate_site_id               varchar2(32)   not null,   -- 创建服务点id  
   fcreate_user_id               varchar2(32)   not null,   -- 创建操作员id
   fcreate_nickname              varchar2(30)   not null,   -- 创建操作员姓名
   --
   -- 发券
   --
   fis_issued                    char(1)        not null,   -- 是否已发放
   fissue_date                   date,                      -- 发放时间
   fissue_user_id                varchar2(32),              -- 发放操作员id
   fissue_nickname               varchar2(30),              -- 发放操作员姓名         
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
   constraint pk_p_coupon_activity primary key (factivity_id)
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
create index fxp.idx_p_coupon_activity_cdate on fxp.p_coupon_activity(fcreate_date);
create index fxp.idx_p_coupon_activity_operator on fxp.p_coupon_activity(foperator_id);

