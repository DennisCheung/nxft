--
-- 账户交易流水表
--
-- v1.0 2017.05.06
-- author：wing
--
-- 说明：
-- 
-- 
--
-- 修改历史：
--
--
-- Drop Table fxp.p_account_list ;
Create Table  fxp.p_account_list (
-- +-----------------------------+--------------+-----------+
   flist_id		                   varchar2(32)   not null,   -- 交易流水号
   --
   -- 交易信息
   --
   faccount_id                   varchar2(32)   not null,   -- 账户id
   flist_type                    varchar2(30)   not null,   -- 交易类型id 常量  充值  提现   消费
   flist_amount                  number(12,2)   not null,		-- 交易金额(增加填正 减少填负)
   flist_summary                 varchar2(50)   not null,   -- 交易摘要
   forder_id                     varchar2(32),              -- 订单id
   flist_desc                    varchar2(256),             -- 备注 
-- +-----------------------------+--------------+-----------+
   --
   -- 创建者
   --
   fcreate_time                  date default sysdate not null, -- 创建时间
   fcreate_application_id        varchar2(32)  not null,   -- 应用id
   fcreate_user_id               varchar2(32)  not null,   -- 创建操作员id
   fcreate_user_name             varchar2(50)  not null,   -- 创建操作员姓名   
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
   constraint pk_p_account_list primary key (flist_id)
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
 create index fxp.idx_p_account_list_account on fxp.p_account_list(faccount_id);
 create index fxp.idx_p_account_list_time on fxp.p_account_list(fcreate_time);
