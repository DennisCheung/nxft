--
-- 活动名单明细表
--
--
-- v1.0 2016.08.30
-- author：wing
--
-- 说明：1、先约束一名客户在一次活动中只能参加一个人群
-- 
--
-- 修改历史：
--
--
-- Drop Table fxp.p_crowds_list ;
Create Table  fxp.p_crowds_list (
-- +-----------------------------+--------------+-----------+
   fcrowds_id                    varchar2(32)   not null,   -- 名单id
   --
   -- 账户信息
   --
   fperson_id                    varchar2(32)   not null,   -- 客户ID
   fperson_no                    varchar2(30)   not null,   -- 客户编号   
   fperson_name                  varchar2(50)   not null,   -- 居民姓名
   fsex_name                     varchar2(30),              -- 性别中文
   fbirth_date                   date,                      -- 出生日期, 年龄通过出生日期计算出来
   fperson_mobile                varchar2(30),              -- 居民手机
   fid_no                        varchar2(30),              -- 证件编号（身份证）
   --
   -- 账号
   --
   faccount_id                   varchar2(32)   not null,   -- 账户id
   --
   -- 活动
   --  
   factivity_id                  varchar2(32)   not null,   -- 活动id
   --
   -- 所属运营商
   --
   foperator_id                  varchar2(32)   not null,   -- 运营商id
   flist_desc                    varchar2(256),             -- 备注
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
   constraint pk_p_crowds_list primary key (faccount_id,factivity_id)
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


