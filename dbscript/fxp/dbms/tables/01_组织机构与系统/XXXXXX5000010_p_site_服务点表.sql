--
-- 服务点表
--
-- v1.0 2016.08.12
-- author：wing
-- 说明：
--
--
-- 修改历史：
--
--
--
-- Drop Table fxp.p_site;
Create Table  fxp.p_site (
-- +-----------------------------+--------------+-----------+
   fsite_id                      varchar2(32)   not null,   -- 服务点id
   fsite_name                    varchar2(100)  not null,   -- 服务点名称
   fsite_info                    varchar2(500),             -- 场所简介
   forg_id                       varchar2(32)   not null,   -- 所属的机构id
   fservice_scope_desc           varchar2(500),             -- 服务范围   
   fregion_id                    varchar2(32),              -- 行政区域ID
   fregion_name                  varchar2(80),              -- 行政区域名称
   faddress                      varchar2(200),             -- 详细地址
   -- fservice_radius            number(6,2)    not null,   -- 服务半径
   -- flatitude                  number(9,6),               -- 纬度值
   -- flongitude                 number(9,6),               -- 经度值
   fadmin_user_id                varchar2(32)   not null,   -- 服务点店长
   fcontact_mobile               varchar2(30)   not null,   -- 联系手机
   fsite_desc                    varchar2(256),             -- 服务点备注    
-- +-----------------------------+--------------+-----------+
   --
   -- 开通
   --
   fcreate_date                   date default sysdate not null, -- 创建日期（录入时输入的日期） 
   fcreate_user_id                varchar2(32)  not null,    -- 创建操作员id
   fcreate_user_name              varchar2(50)  not null,    -- 创建操作员姓名
   --
   -- 注销
   --
   fis_cancel                    char(1) default 'N'  not null, -- 是否被注销
   fcancel_reason                varchar2(300),              -- 注销原因
   fcancel_date                  date,                      -- 注销机器时间
   fcancel_user_id               varchar2(32),              -- 注销操作员id   
   fcancel_user_name             varchar2(30),              -- 注销操作员姓名   
   --
   -- 日志
   --
   fversion                      number(6)                  -- 版本号
                                 default 0       not null,
   flogcby                       varchar2(32)   not null,   -- 创建者
   flogcdate                     date           not null,   -- 创建时间
   flogluby                      varchar2(32)   not null,   -- 最后修改者
   flogludate                    date           not null,   -- 最后修改时间
   floglaby                      varchar2(32)   not null,   -- 最后访问者
   flogladate                    date           not null,   -- 最后访问时间
   --
   -- 主键、唯一键
   --
   constraint pk_p_site primary key (fsite_id),
   constraint uk_p_site_org unique (forg_id,fsite_id)
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


-- 广州福来

