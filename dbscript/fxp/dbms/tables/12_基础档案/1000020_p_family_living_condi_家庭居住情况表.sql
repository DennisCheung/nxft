--
-- 家庭居住情况表
--
-- v1.0 2015.01.12
-- author：wing
--
-- 修改历史：
--
--
--
-- Drop Table fxp.p_family_living_condi;
create table  fxp.p_family_living_condi (
-- +-----------------------------+--------------+-----------+
   fpk_id                        varchar2(32)   not null,   -- 主键id
   fliving_condi_id              varchar2(32)   not null,   -- 居住情况ID
   fliving_condi_name            varchar2(40)   not null,   -- 居住情况名称
   --
   ffamily_id                    varchar2(32)   not null,   -- 家庭id
   fordernum                     number(6,2)    not null,   -- 排序号
   fliving_condi_desc            varchar2(256),             -- 备注
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
   constraint pk_p_family_living_condi primary key (fpk_id),
   constraint uk_p_family_living_condi unique (ffamily_id,fliving_condi_id)
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
create index idx_file_family_living_condi1 on fxp.file_family_living_condi(ffamily_id);

--
-- 修改历史：
--
