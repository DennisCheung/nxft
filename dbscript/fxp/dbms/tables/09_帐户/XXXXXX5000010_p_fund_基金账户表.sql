--
-- 基金账户表
--
-- v1.0 2016.09.19
-- author：wing
--
-- 说明：
-- 
-- 
--
-- 修改历史：
--
--
-- Drop Table fxp.p_fund ;
Create Table  fxp.p_fund (
-- +-----------------------------+--------------+-----------+
   ffund_id                      varchar2(32)   not null,   -- 基金账户id
   ffund_no                      varchar2(30)   not null,   -- 基金账号
   ffund_user_id                 varchar2(32)   not null,   -- 出资人id
   ffund_company_id              varchar2(32)   not null,   -- 基金公司id
   foperator_id                  varchar2(32)   not null,   -- 运营商id
   pamount                       number(9,2)    not null,   -- 账户金额
   --
   -- 使用
   --
   fis_used                      char(1) default 'N'  not null, -- 是否被使用
   fused_date                    date,                      -- 使用机器时间
   fused_user_id                 varchar2(32),              -- 使用操作员id   
   fused_user_name               varchar2(30),              -- 使用操作员姓名
   fused_desc                    varchar2(256),             -- 使用备注        
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
   constraint pk_p_fund primary key (ffund_id),
   constraint uk_p_fund_no unique (ffund_no)
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


