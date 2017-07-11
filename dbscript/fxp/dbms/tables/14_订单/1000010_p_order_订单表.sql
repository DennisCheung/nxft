--
-- 订单表
--
-- v1.0 2017.03.04
-- author：wing
--
-- 说明
--
-- 
-- 修改历史：
--
-- drop table fxp.p_order;
create table  fxp.p_order (
-- +-----------------------------+--------------+-----------+
   forder_id                     varchar2(32)   not null,   -- 订单ID
   factivation_code              varchar2(30)   not null,   -- 激活码
   --
   -- 商品信息
   --
   fgoods_id                     varchar2(32)   not null,   -- 商品id
   fgoods_name                   varchar2(100)  not null,   -- 商品名称
   fgoods_price                  number(10,2)   not null,   -- 商品单价
   fgoods_unit                   varchar2(30)   not null,   -- 单位
   --
   -- 金额
   --
   fquantity                     number(6,0)    not null,   -- 数量
   fquantity_activate            number(6,0)    not null,   -- 已激活的数量
   fsum_total                    number(10,2)   not null,   -- 金额
   --
   -- 卖方信息
   --
   fsell_circle_id               varchar2(32)   not null,   -- 卖方工作圈id   
-- +-----------------------------+--------------+-----------+
   --
   -- 购买信息
   --
   fbuy_time                     date          not null,    -- 购买时间
   fbuy_circle_id                varchar2(32),              -- 购买工作圈id
   fbuy_team_id                  varchar2(32),              -- 购买工作组id 
   fbuy_user_id                  varchar2(32)  not null,    -- 购买操作员id
   fbuy_user_name                varchar2(50)  not null,    -- 购买操作员姓名
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
   constraint pk_p_order primary key (forder_id)
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
