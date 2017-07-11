--
-- 居民语言表
--
-- v1.0 2015.01.12
-- author：wing
--
-- 修改历史：
--
--
--
-- Drop Table fxp.p_person_language;
create table  fxp.p_person_language (
-- +-----------------------------+--------------+-----------+
   fpk_id                        varchar2(32)   not null,   -- 主键id
   flanguage_id                  varchar2(32)   not null,   -- 语言id
   flanguage_name                varchar2(40)   not null,   -- 语言名称
   --
   fperson_id                    varchar2(32)   not null,   -- 居民ID，
   fordernum                     number(6,2)    not null,   -- 排序号
   flanguage_desc                varchar2(256),             -- 备注
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
   constraint pk_p_person_language primary key (fpk_id),
   constraint uk_p_person_language unique (fperson_id,flanguage_id)
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
create index idx_file_person_language1 on fxp.file_person_language(fperson_id);

--
-- 修改历史：
--
