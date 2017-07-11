--
-- ICD亚类字典表
--
-- v1.0 2016.02.16
-- author：wing
--
-- 修改历史：
--
--
--
-- drop table fxp.p_icd_subclass;
create table  fxp.p_icd_subclass (
-- +-----------------------------+--------------+-----------+
   ficd_subclass_id              varchar2(32)   not null,   -- ICD亚类ID
   ficd_subclass_name            varchar2(80)   not null,   -- ICD亚类名称
   ficd_class_id                 varchar2(32)   not null,   -- ICD大类ID
   ficd_subclass_desc            varchar2(256),             -- 备注
   frefer_disease_id             varchar2(32),              -- 参照疾病ID
   frefer_disease_code           varchar2(20),              -- 参照疾病CODE
   frefer_disease_name           varchar2(100),             -- 参照疾病NAME   
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
   constraint pk_p_icd_subclass primary key (ficd_subclass_id)
);

--
-- 同义词
--

