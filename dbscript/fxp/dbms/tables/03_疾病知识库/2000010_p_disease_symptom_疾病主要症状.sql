--
-- 疾病主要症状表
--
-- v1.0 2015.11.17
-- author：wing
--
-- 修改历史：
--
--
--
-- drop table fxp.p_disease_symptom;
create table  fxp.p_disease_symptom (
-- +-----------------------------+--------------+-----------+
   fsymptom_id                   varchar2(32)   not null,   -- 主键ID
   --
   -- 症状
   --
   fdisease_id                   varchar2(32)   not null,   -- 疾病ID
   fsymptom_code                 varchar2(30)   not null,   -- 症状CODE
   fsymptom_name                 varchar2(80)   not null,   -- 症状名称
   fisother                      char(1)        not null,   -- 是否是其他项 Y/N  其他项需手工输入
   fisavailable                  char(1)        not null,   -- 是否可用？
   fsymptom_desc                 varchar2(256),             -- 备注
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
   constraint pk_p_disease_symptom primary key (fsymptom_id),
   constraint uk_p_disease_symptom unique (fdisease_id,fsymptom_code)
);

--
-- 同义词
--

--
-- 索引
--
