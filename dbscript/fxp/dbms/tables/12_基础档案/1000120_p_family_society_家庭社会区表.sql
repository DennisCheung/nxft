--
-- 家庭社会区表
--
-- v1.0 2015.01.12
-- author：wing
--
-- 修改历史：
--
--
--
-- Drop Table fxp.p_family_society;
create table  fxp.p_family_society (
-- +-----------------------------+--------------+-----------+
   fcontact_id                   varchar2(32)   not null,   -- 联系人id
   fcontact_name                 varchar2(40)   not null,   -- 联系人姓名
   --
   ffamily_id                    varchar2(32)   not null,   -- 家庭ID， 
   ffamily_relation_id           varchar2(32),              -- 家庭社会关系ID
   ffamily_relation_name         varchar2(30),              -- 家庭社会关系name
   fcontact_phone                varchar2(40),              -- 联系电话
   -- fordernum                  number(6,2)    not null,   -- 排序号
   fcontact_desc                 varchar2(256),             -- 备注
   fcreate_date                  date           not null,   -- 创建时间   
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
   constraint pk_p_family_society primary key (fcontact_id),
   constraint uk_p_family_society unique (ffamily_id,fcontact_name)
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
-- 修改历史：
--
