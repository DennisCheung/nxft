--
-- 居民疾病表
--
-- v1.0 2015.01.12
-- author：wing
--
-- 修改历史：
--
--
--
-- Drop Table fxp.p_person_disease;
create table  fxp.p_person_disease (
-- +-----------------------------+--------------+-----------+
   fpk_id                        varchar2(32)   not null,   -- 主键id
   fdisease_id                   varchar2(32)   not null,   -- 疾病id
   fdisease_name                 varchar2(40)   not null,   -- 疾病名称
   --
   fperson_id                    varchar2(32)   not null,   -- 居民ID，
   fordernum                     number(6,2)    not null,   -- 排序号
   fdisease_desc                 varchar2(256),             -- 备注
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
   constraint pk_p_person_disease primary key (fpk_id),
   constraint uk_p_person_disease unique (fperson_id,fdisease_id)
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
create index idx_p_person_disease1 on fxp.p_person_disease(fperson_id);

--
-- 修改历史：
--
