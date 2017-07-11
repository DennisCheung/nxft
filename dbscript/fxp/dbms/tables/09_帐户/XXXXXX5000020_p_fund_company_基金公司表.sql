--
-- 基金公司表
--
-- v1.0 2016.09.19
-- author：wing
--
-- 说明：
-- 1、由运营商创建，用于托管来源资金
-- 
--
-- 修改历史：
--
--
-- Drop Table fxp.p_fund_company ;
Create Table  fxp.p_fund_company (
-- +-----------------------------+--------------+-----------+
   ffund_company_id              varchar2(32)   not null,   -- 基金公司id
   ffund_company_name            varchar2(50)   not null,   -- 基金公司名称
   foperator_id                  varchar2(32)   not null,   -- 运营商id
   fcompany_desc                 varchar2(256),             -- 备注
   --
   -- 联系人
   --
   fcontact_person               varchar2(30),              -- 联系人姓名
   fcontact_mobile               varchar2(30),              -- 联系人手机
-- +-----------------------------+--------------+-----------+
   --
   -- 开通
   --
   fcreate_date                  date default sysdate not null, -- 创建日期（录入时输入的日期） 
   fcreate_user_id               varchar2(32)  not null,   -- 创建操作员id
   fcreate_user_name             varchar2(50)  not null,   -- 创建操作员姓名
   --
   -- 注销
   --
   fis_cancel                    char(1) default 'N'  not null, -- 是否被注销
   fcancel_reason                varchar2(60),              -- 注销原因
   fcancel_date                  date,                      -- 注销机器时间
   fcancel_user_id               varchar2(32),              -- 注销操作员id   
   fcancel_user_name             varchar2(30),              -- 注销操作员姓名   
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
   constraint pk_p_fund_company primary key (ffund_company_id)
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


