--
-- 账户表
--
-- v1.0 2016.08.30
-- author：wing
--
-- 说明：
-- 
-- 
--
-- 修改历史：
--
--
-- Drop Table fxp.p_account ;
Create Table  fxp.p_account (
-- +-----------------------------+--------------+-----------+
   --
   -- 账户信息
   --
   faccount_id                   varchar2(32)   not null,   -- 账户id
   faccount_name                 varchar2(50)   not null,   -- 账户名
   fbalance_cash                 number(12,2)   default 0 not null,      -- 个人账户余额
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
   constraint pk_p_account primary key (faccount_id)
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


