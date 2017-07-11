--
-- 服务商，相当于机构表的扩展
--
-- v1.0 2015.07.20
-- author：wing
--
-- 机构表中服务商（ P_ORG forg_type=MERCHANT）属性扩展  。
-- 修改历史：
--
--
--
--
-- Drop Table fxp.p_merchant;
Create Table  fxp.p_merchant (
-- +-----------------------------+--------------+-----------+
   fmerchant_id                  varchar2(32)   not null,   -- 服务商id
   fmerchant_name                varchar2(50)   not null,   -- 服务商名称
   fmerchant_fullname            varchar2(100)  not null,   -- 服务商全称
   fmerchant_info                varchar2(1000),            -- 服务商简介
   fservice_class_id             varchar2(32)   not null,   -- 行业分类ID   
   fregion_id                    varchar2(32)   not null,   -- 行政区域ID
   fregion_name                  varchar2(80)   not null,   -- 行政区域名称    
   faddress                      varchar2(200),             -- 详细地址 
   fmerchant_desc                varchar2(256),             -- 备注 
   --
   -- 联系人
   --
   fcontact_person               varchar2(30),              -- 联系人姓名
   fcontact_duty                 varchar2(30),              -- 联系人职位
   fcontact_mobile               varchar2(30),              -- 联系人手机
   fcontact_email                varchar2(30),              -- 联系人邮箱
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
   fversion                      number(6)                   -- 版本号
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
   constraint pk_p_merchant primary key (fmerchant_id)
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
-- 修改语句：
--
