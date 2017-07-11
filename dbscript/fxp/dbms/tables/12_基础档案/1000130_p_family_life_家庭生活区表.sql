--
-- 家庭生活区表
--
-- v1.0 2015.01.12
-- author：wing
--
-- 修改历史：
-- V1.1 add  by hgr 2015.04.20     fSITE_id            varchar2(32),              -- [V1.1]分配的商户id 
-- V1.1 add  by hgr 2015.04.20     fSITE_name          varchar2(100),             -- [V1.1]分配的商户name
--
--
-- Drop Table fxp.p_family_life;
create table  fxp.p_family_life (
-- +-----------------------------+--------------+-----------+
   flife_id                      varchar2(32)   not null,   -- 主键id
   fcontact_name                 varchar2(100)  not null,   -- 联系人姓名, 填商家的名称
   --
   ffamily_id                    varchar2(32)   not null,   -- 家庭ID， 
   flife_item_id                 varchar2(32)   not null,   -- 生活主要服务项目ID
   flife_item_name               varchar2(60)   not null,   -- 生活主要服务项目名称
   faddress                      varchar2(100),             -- 详细地址
   fcontact_phone                varchar2(40),              -- 联系电话
   -- fsite_id                   varchar2(32),              -- [V1.1]分配的商户id
   -- fsite_name                 varchar2(100),             -- [V1.1]分配的商户name
   -- fordernum                  number(6,2)    not null,   -- 排序号
   fcontact_desc                 varchar2(256),             -- 备注
   --
   -- 日志
   --
   fversion                      number(6)                   -- 版本号
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
   constraint pk_p_family_life primary key (flife_id)
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
create index idx_file_family_life1 on fxp.file_family_life(ffamily_id);


--
-- 修改历史：
--
