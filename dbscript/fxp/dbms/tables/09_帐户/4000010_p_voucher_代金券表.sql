--
-- 代金券表
--
-- v1.0 2017.03.20
-- author：wing
--
-- 说明：
-- 
--
-- 修改历史：
--
--
-- Drop Table fxp.p_voucher ;
Create Table  fxp.p_voucher (
-- +-----------------------------+--------------+-----------+
   fvoucher_id                   varchar2(32)   not null,   -- 券id
   fvoucher_name                 varchar2(100)  not null,   -- 券名称
   fvoucher_balance              number(10,2)   default 0 not null,    -- 卡余额
   fduetime_begin                date           not null,   -- 有效期起日
   fduetime_end                  date           not null,   -- 有效期止日
   fvoucher_desc                 varchar2(256),             -- 券备注   
   --
   -- 订单信息
   --
   forder_id                     varchar2(32)   not null,   -- 订单ID   
   fgoods_id                     varchar2(32)   not null,   -- 商品id
   fgoods_name                   varchar2(100)  not null,   -- 商品名称
   fgoods_price                  number(10,2)   not null,   -- 商品单价
   fgoods_unit                   varchar2(30)   not null,   -- 单位
   fsell_circle_id               varchar2(32)   not null,   -- 卖方工作圈id   
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
   constraint pk_p_voucher primary key (fvoucher_id)
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
create index fxp.idx_p_voucher_account on fxp.p_voucher(faccount_id);

