--
-- 机构表
--
-- v1.0 2015.10.02
-- author：wing
--
-- 说明：
-- 
--
--
--
-- 修改历史：
--
--
-- Drop Table fxp.p_org;
Create Table  fxp.p_org (
-- +-----------------------------+--------------+-----------+
   forg_id                       varchar2(32)   not null,   -- 机构id
   forg_name                     varchar2(50)   not null,   -- 机构名称
   forg_digital_number           number(10)     not null,   -- 机构数字编号  通过票据号生成
   fdomain_name                  varchar2(50),              -- 域名，唯一
   fadmin_user_id                varchar2(32)   not null,   -- 机构主管理员用户
   forg_desc                     varchar2(256),             -- 备注
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
   constraint pk_p_org primary key (forg_id),
   constraint uk_p_org_num unique (forg_digital_number)
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


