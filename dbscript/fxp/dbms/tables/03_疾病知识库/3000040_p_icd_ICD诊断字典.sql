--
-- ICD诊断字典
--
-- v1.0 2015.06.11
-- author：wing
--
-- 修改历史：
-- 删除按icd代码匹配病种
--
--
-- drop table fxp.p_icd;
create table  fxp.p_icd (
-- +-----------------------------+--------------+-----------+
   fdiag_code                    varchar2(20)   not null,   -- 医院诊断代码
   fdiag_name                    varchar2(100)  not null,   -- 诊断名称
   fdiag_class                   varchar2(10)   not null,   -- 中西医诊断类别：WM 西医,TCM 中医
   fdisease_class_id             varchar2(32)   not null,   -- 疾病大类ID
   fdiag_level                   number(1)      not null,   -- 诊断级别 1 章节 2 段 例如 K35-K38 3 小类  4 明细
   ftree_id                      varchar2(32)   not null,   -- 目录树ID
   fdiag_system                  varchar2(10)   not null,   -- 诊断代码编码体系：ICD10、ICPC、TCM
   fisavailable                  char(1)        not null,   -- 是否可用？
   fdiag_desc                    varchar2(256),             -- 备注
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
   constraint pk_p_icd primary key (fdiag_code)
);

--
-- 同义词
--
